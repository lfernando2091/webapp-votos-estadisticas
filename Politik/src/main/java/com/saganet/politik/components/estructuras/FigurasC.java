package com.saganet.politik.components.estructuras;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.components.catalogos.GeozonasC;
import com.saganet.politik.database.estructuras.FiguraEO;
import com.saganet.politik.dominios.FiguraAtributosDO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.modelos.Modelo;

@Component("EstructurasFigurasC")
public class FigurasC {
	private static final Logger logger = LoggerFactory.getLogger(FigurasC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	GeozonasC geozonaC;
	
	public Modelo<FiguraEO> modelo(){
		Modelo<FiguraEO> modelo;
		List<FiguraEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("estructuras.figuras.listado");
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		//Llenar Geozonas y Atributos
		for(FiguraEO figura : listado){
			completarFigura(figura);
		}
		
		logger.debug("Se obtiene listado de FiguraEO: {}", listado);
		
		return modelo;
	}
	
	public void completarFigura(FiguraEO figura) {
		List<FiguraAtributosDO> atributos;

		if (figura.getNivel().equals(NivelesDO.GEOZONA)) {
			figura.setGeozona(geozonaC.obtenerGeozona(figura.getIdGeozona()));
		}
		atributos = sqlSession.selectList("estructuras.figuras.listadoAtributos", figura);
		figura.setAtributos(atributos);
	}
	
	public FiguraEO nuevo(){
		FiguraEO figura;
		
		figura = new FiguraEO();
		
		return figura;
	}
	
	public void insertar(FiguraEO figura){
		if(figura.getId() == null){
			sqlSession.insert("estructuras.figuras.insertar", figura);
			sqlSession.insert("estructuras.figuras.insertarAtributos", figura);
			logger.debug("Se insertar FiguraEO", figura);
		} else {
			sqlSession.insert("estructuras.figuras.eliminarAtributos", figura);
			sqlSession.insert("estructuras.figuras.insertarAtributos", figura);
			logger.debug("Se actualiza FiguraEO", figura);
		}
	}
	
	public void agregarAtributo(FiguraEO figura, FiguraAtributosDO atributo){
		if(!figura.getAtributos().contains(atributo))
			figura.getAtributos().add(atributo);
	}
}
