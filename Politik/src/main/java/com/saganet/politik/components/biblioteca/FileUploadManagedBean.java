package com.saganet.politik.components.biblioteca;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.biblioteca.ReportesParametros;

@Component("FileUploadManagedBean")
@ManagedBean(name = "FileUploadManagedBean")
public class FileUploadManagedBean {

	@Autowired
	private ReportesParametros reportesParametros;

	private static final Logger logger = LoggerFactory.getLogger(FileUploadManagedBean.class);

	public void upload(FileUploadEvent event) {
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream(), event.getFile());
			FacesMessage message = new FacesMessage(
					"El archivo se ha subido con �xito! " + event.getFile().getFileName().toString());
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void copyFile(String fileName, InputStream in, UploadedFile archivo) {
		try {
			String realPath = reportesParametros.getRutaActual() + File.separator + File.separator + fileName;
			FileOutputStream out = new FileOutputStream(realPath);
			byte[] buffer = new byte[(int) archivo.getSize()];
			int contador = 0;
			while ((contador = in.read(buffer)) > 0) {
				out.write(buffer, 0, contador);
			}
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.debug("Error: {}", e.getMessage());
		}
	}

	public String getRutaActual() {
		return reportesParametros.getRutaActual();
	}

	public String getRutaAnterior() {
		return reportesParametros.getRutaAnterior();
	}

	public String getRutaActualNavegacion(String rutaInicio) {
		logger.debug("SIZE: {}",rutaInicio.length());
		return reportesParametros.getRutaActual().substring(rutaInicio.length());
	}
}