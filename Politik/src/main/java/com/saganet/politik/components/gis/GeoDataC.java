package com.saganet.politik.components.gis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.gis.GeoDataEO;
import com.saganet.politik.database.gis.GeoDataGlobal;
import com.saganet.politik.modelos.JavaBeanT;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("GisGeoDataC")
public class GeoDataC {
	private static final Logger logger = LoggerFactory.getLogger(GeoDataC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public GeoDataGlobal nuevoGeoDataGlobal(){
		GeoDataGlobal geoDataGlobal;
		
		geoDataGlobal = new GeoDataGlobal();
		
		return geoDataGlobal;
	}
	
	public GeoDataGlobal geoDataGlobalPorTerritorios(List<JavaBeanT> listado){
		GeoDataEO geoData;
		GeoDataGlobal geoDataGlobal;
		String clase;
		
		geoDataGlobal = new GeoDataGlobal();
		
		if(!listado.isEmpty()){
			clase = listado.get(0).getClass().getSimpleName();
			switch(clase){
			case "EntidadEO":
				geoData = sqlSession.selectOne("gis.geoData.porListadoEntidades", listado);
				geoDataGlobal.setGeoData(geoData);
				break;
			case "MunicipioEO":
				geoData = sqlSession.selectOne("gis.geoData.porListadoMunicipios", listado);
				geoDataGlobal.setGeoData(geoData);
				break;
			}
			geoDataGlobal.setTerritorios(listado);
		}
		
		return geoDataGlobal;
	}
}
