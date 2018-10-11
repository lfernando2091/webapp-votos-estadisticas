package com.saganet.politik.components.biblioteca;

import com.saganet.politik.database.biblioteca.BibliotecaEO;
import com.saganet.politik.database.biblioteca.ReportesParametros;
import com.saganet.politik.modelos.biblioteca.BibliotecaT;
import com.saganet.politik.utilidades.FilePolitik;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("BibliotecaC")

public class BibliotecaC {

	private static final Logger logger = LoggerFactory.getLogger(BibliotecaC.class);

	@Autowired
	private ReportesParametros reportesParametros;

	public BibliotecaT tabla(String ruta) {
		BibliotecaT tabla;
		List<BibliotecaEO> listado;
		BibliotecaEO biblioteca;
		int registro;
		
		try{
		
		tabla = new BibliotecaT();
		
		File directorio = new File(ruta);
		

		listado = new ArrayList<>();
		registro = 0;

		reportesParametros.setRutaAnterior(reportesParametros.getRutaActual());
		reportesParametros.setRutaActual(ruta.toString());

		logger.debug("_Despues de crear opbjeto {}", reportesParametros.getRutaActual());

		File[] archivosLista = directorio.listFiles();

		for (File archivo : archivosLista) {
			registro++;
			biblioteca = new BibliotecaEO();
			biblioteca.setArchivo(archivo);
			biblioteca.setId(registro);
			listado.add(biblioteca);
			logger.debug("Ruta completa del archivo: {}", archivo.getParentFile().getName());
		}
		logger.debug("Tamanio de la lista: {}", listado.size());
		tabla.setListado(listado);

		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		
		return tabla;
		
		}catch(Exception e){
			logger.debug("Error La carpeta no existe: {}", e.getMessage());
			FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, "No existe esta ubicación.",null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			return new BibliotecaT();
			
		}

	}

	public void descargaArchivo(File archivo) {
		FacesContext fC = FacesContext.getCurrentInstance();
		ExternalContext externalContext = fC.getExternalContext();
		try {
			reportesParametros.setAr(archivo);
			externalContext.redirect(externalContext.getRequestContextPath() + "/app/descargaArchivo.saga");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void crearCarpeta(String ruta, String nombre) {

		logger.debug("Datos recibidos: {}", ruta + " Nombre : " + nombre);

		reportesParametros.setRutaAnterior(reportesParametros.getRutaActual());
		reportesParametros.setRutaActual(ruta.toString());

		File file = new File(ruta + "\\" + nombre);
		if (!file.exists()) {
			if (file.mkdir()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"La carpeta " + nombre + " se ha creado con exito", "Aviso"));

			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"La carpeta " + nombre + " no se ha creado con exito, revise el nombre nuevamente", "Aviso"));

			}
		}
	}

	public String getRuta() {
		return "C:\\reportes";
	}

}
