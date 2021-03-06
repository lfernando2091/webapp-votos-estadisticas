package com.saganet.politik.components.catalogos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.DLocalEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.modelos.catalogos.DLocalesT;

@Component("CatalogosDLocalesC")
public class DLocalesC {
	private static final Logger logger = LoggerFactory.getLogger(DLocalesC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<DLocalEO> modelo(EntidadEO entidad){
		Modelo<DLocalEO> modelo;
		List<DLocalEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.dLocales.listado", entidad);
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	
	public DLocalesT tabla(EntidadEO entidad){
		DLocalesT tabla;
		List<DLocalEO> listado;
		logger.debug("Entidad recibidad: {}", entidad);
		
		tabla = new DLocalesT();
		
		listado = sqlSession.selectList("catalogos.dLocales.listado", entidad);
		tabla.setListado(listado);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de DLocales: {}", listado);
		
		return tabla;
	}
	
	public DLocalesT tabla(List<EntidadEO> entidades){
		DLocalesT tabla;
		List<DLocalEO> listado;
		
		logger.debug("Entidades recibidadas: {}", entidades);
		
		tabla = new DLocalesT();
		
		if(entidades == null || entidades.isEmpty())
			listado = new ArrayList<DLocalEO>();
		else
			listado = sqlSession.selectList("catalogos.dLocales.listadoPorEntidades", entidades);
		
		tabla.setListado(listado);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de DLocales: {}", listado);
		
		return tabla;
	}
	
	public Modelo<DLocalEO> modelo(List<EntidadEO> entidades){
		Modelo<DLocalEO> modelo;
		List<DLocalEO> listado;
		
		logger.debug("Entidades recibidadas: {}", entidades);
		
		modelo = new Modelo<DLocalEO>();
		
		if(entidades == null || entidades.isEmpty())
			listado = new ArrayList<DLocalEO>();
		else
			listado = sqlSession.selectList("catalogos.dLocales.listadoPorEntidades", entidades);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de DLocales: {}", listado);
		
		return modelo;
	}
	
	public DLocalEO buscarPorLlave(String llave){
		DLocalEO dLocal;
		
		dLocal = sqlSession.selectOne("catalogos.dLocales.porLlave", llave);
		
		return dLocal;
	}
}
