package com.saganet.politik.components.catalogos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.DLocalEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.modelos.catalogos.SeccionesT;

@Component("CatalogosSeccionesC")
public class SeccionesC {
	private static final Logger logger = LoggerFactory.getLogger(SeccionesC.class);

	@Autowired
	SqlSession sqlSession;
	
	public Modelo<SeccionEO> buscarPorIdEntidad(Integer idEntidad) {
		List<SeccionEO> listado=sqlSession.selectList("catalogos.secciones.porIdEntidad",idEntidad);
		return new Modelo<>(listado);
	} 	
	
	public SeccionesT tabla(EntidadEO entidad) {
		SeccionesT tabla;
		List<SeccionEO> listado;

		tabla = new SeccionesT();

		listado = sqlSession.selectList("catalogos.secciones.listado", entidad);
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}

		return tabla;
	}

	public SeccionesT tabla(List<EntidadEO> entidades) {
		SeccionesT tabla;
		List<SeccionEO> listado;

		logger.debug("Entidades recibidadas: {}", entidades);

		tabla = new SeccionesT();

		if (entidades == null || entidades.isEmpty())
			listado = new ArrayList<SeccionEO>();
		else
			listado = sqlSession.selectList("catalogos.municipios.listadoPorEntidades", entidades);

		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}

		logger.debug("Se obtiene listado de Secciones: {}", listado);

		return tabla;
	}
	
	public Modelo<SeccionEO> modeloByEntidades(List<EntidadEO> entidades){
		Modelo<SeccionEO> modelo;
		List<SeccionEO> listado;
		
		listado = sqlSession.selectList("catalogos.secciones.listadoPorEntidades", entidades);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<SeccionEO> modelo(EntidadEO entidad){
		Modelo<SeccionEO> modelo;
		List<SeccionEO> listado;

		modelo = new Modelo<>();

		listado = sqlSession.selectList("catalogos.secciones.listado", entidad);
		modelo.setListado(listado);
		if (!listado.isEmpty()) {
			modelo.setSeleccionado(listado.get(0));
		}

		return modelo;
	}
	
	public Modelo<SeccionEO> modeloSecciones(List<MunicipioEO> municipios, List<DLocalEO> dLocales, List<DFederalEO> dFederales){
		Modelo<SeccionEO> modelo;
		List<SeccionEO> listado;
		HashMap<String, Object> parametros;
		
		logger.debug("********************************************************************************************");
		logger.debug("municipios: {}", municipios);
		logger.debug("dLocales: {}", dLocales);
		logger.debug("dFederales: {}", dFederales);
		logger.debug("********************************************************************************************");
		
		modelo = new Modelo<>();
		parametros = new HashMap<>();
		
		logger.debug("Listado de Municipios: {}", municipios);
		logger.debug("Listado de DLocales: {}", dLocales);
		
		if(!municipios.isEmpty())
			parametros.put("municipios", municipios);
		
		if(!dLocales.isEmpty())
			parametros.put("dLocales", dLocales);
		
		if(!dFederales.isEmpty())
			parametros.put("dFederales", dFederales);
		
		listado = sqlSession.selectList("catalogos.secciones.listadoPorEDFDLM", parametros);
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}

	public SeccionesT tablaPrimerElemento(List<EntidadEO> entidades) {
		SeccionesT tabla;

		tabla = new SeccionesT();
		
		if(entidades != null && !entidades.isEmpty()){
			tabla = tabla(entidades.get(0));
		} else {
			tabla.setListado(new ArrayList<SeccionEO>());
		}

		return tabla;
	}

	public Modelo<SeccionEO> nuevoModelo() {
		Modelo<SeccionEO> modelo;

		modelo = new Modelo<>();
		modelo.setListado(new ArrayList<SeccionEO>());
		return modelo;
	}
	
	public SeccionEO buscarPorLlave(String llave){
		SeccionEO seccion;
		
		seccion = sqlSession.selectOne("catalogos.secciones.porLlave", llave);
		
		return seccion;
	}

	
	public  Modelo<SeccionEO> seccionesMunicipio(String idEntidad, Integer municipio){
		Modelo<SeccionEO> modelo;
		List<SeccionEO> listado;
		HashMap<String, Object> parametros;
		logger.debug("Entidad: {}", idEntidad);
		logger.debug("Municipio: {}", municipio);
		modelo = new Modelo<>();
		parametros = new HashMap<>();
		parametros.put("entidad", Integer.parseInt(idEntidad));
		parametros.put("municipio", municipio);
		listado = sqlSession.selectList("catalogos.secciones.porMunicipio", parametros);
		modelo.setListado(listado);
		if (!listado.isEmpty()) {
			modelo.setSeleccionado(listado.get(0));
		}

		return modelo;
	}

	public Modelo<SeccionEO> modeloporEntidadMpio(MunicipioEO municipio){
		logger.debug("Listado de municipio: ---->>>{}", municipio);
		List<SeccionEO> listado = sqlSession.selectList("catalogos.secciones.listadoSimple2", municipio);
		logger.debug("listado es vacio: ---->>>{}", listado.isEmpty());		
		return new Modelo<>(listado);
	}

}
