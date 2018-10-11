package com.saganet.politik.components.catalogos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.CampoTablaEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.TablaEO;
import com.saganet.politik.database.catalogos.TablaParticionEO;
import com.saganet.politik.dominios.EsquemasDO;
import com.saganet.politik.dominios.PlantillasParticionDO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.modelos.catalogos.TablasT;

@Component("CatalogosTablasC")
public class TablasC {
	private static final Logger logger = LoggerFactory.getLogger(TablasC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	EntidadesC entidadesC;
	
	public TablasT tabla(){
		TablasT tabla;
		List<TablaEO> listado;
		
		tabla = new TablasT();
		
		listado = sqlSession.selectList("catalogos.tablas.listado");
		if(!listado.isEmpty())
			tabla.setSeleccionado(listado.get(0));
		tabla.setListado(listado);
		
		return tabla;
	}
	
	public TablasT tablaPorEsquema(EsquemasDO esquema){
		TablasT tabla;
		List<TablaEO> listado;
		
		tabla = new TablasT();
		
		listado = sqlSession.selectList("catalogos.tablas.listadoPorEsquema", esquema.toString());
		if(!listado.isEmpty())
			tabla.setSeleccionado(listado.get(0));
			logger.debug("Tabla Seleccionada: {}", listado.get(0));
		tabla.setListado(listado);
		
		return tabla;
	}
	
	public TablaEO nuevo(){
		TablaEO nuevo;
		List<TablaParticionEO> particiones;
		
		nuevo = new TablaEO();
		particiones = new ArrayList<TablaParticionEO>();
		nuevo.setParticiones(particiones);
		logger.debug("Se crea objeto TablaEO nuevo: {}", nuevo);
		
		return nuevo;
	}
	
	public TablaParticionEO nuevaParticion(TablaEO tabla){
		TablaParticionEO particion;
		
		particion = new TablaParticionEO();
		
		particion.setIdTabla(tabla.getId());
		
		return particion;
	}
	
	public String necesitaParticiones(TablaEO nuevo){
		String respuesta;
		
		respuesta = nuevo.getParticionada() ? "Si" : "No";
		logger.debug("Se obtiene respuesta de decision: {}", respuesta);
		
		return respuesta;
	}
	
	public void aplicarPlantilla(PlantillasParticionDO plantilla, TablaEO tabla){
		List<TablaParticionEO> listado;
		TablaParticionEO particion;
		
		listado = new ArrayList<>();
		
		switch(plantilla){
		case ENTIDADES:
			Modelo<EntidadEO> modelo;
			modelo = entidadesC.modeloCompleto();
			for(EntidadEO entidad : modelo.getListado()){
				particion = new TablaParticionEO();
				particion.setIdParticion(entidad.getId());
				particion.setParticion(entidad.getNombre().toLowerCase().replaceAll(" ", "_"));
				listado.add(particion);
			}
			tabla.setParticiones(listado);
			break;
		}
	}
	
	public CampoTablaEO nuevoCampo(){
		CampoTablaEO campo;
		
		campo = new CampoTablaEO();
		
		return campo;
	}
	
	public Modelo<CampoTablaEO> nuevoModeloCampos(){
		Modelo<CampoTablaEO> modelo;
		
		modelo = new Modelo<>();
		
		modelo.setListado(new ArrayList<CampoTablaEO>());
		
		return modelo;
	}
	
	public void agregarCampo(Modelo<CampoTablaEO> modelo, CampoTablaEO campo){
		int i;
		
		i = modelo.getListado().size();
		
		campo.setId(i+1);
		
		modelo.getListado().add(campo);
	}
	
	public void insertar(TablaEO tabla, List<CampoTablaEO> campos){
		HashMap<String, Object> parametros;
		
		parametros = new HashMap<>();
		
		sqlSession.insert("catalogos.tablas.insertar", tabla);
		sqlSession.insert("catalogos.tablasParticiones.insertar", tabla);
		
		parametros.put("tabla", tabla);
		parametros.put("campos", campos);
		sqlSession.update("catalogos.tablas.crearTabla", parametros);
		
		if(tabla.getParticionada()){
			for(TablaParticionEO particion : tabla.getParticiones()){
				parametros.put("particion", particion);
				sqlSession.update("catalogos.tablasParticiones.crearParticion", parametros);
			}
		}
	}
	
}
