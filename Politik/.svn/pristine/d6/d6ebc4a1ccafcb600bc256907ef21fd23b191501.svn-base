package com.saganet.politik.components.estructurasEdoMex;

import java.util.List;
import org.slf4j.Logger;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import com.saganet.politik.modelos.Modelo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.estructurasEdoMex.CoordinadorMunicipalEO;

@Component("EstructurasEdoMexCoordinadoresMunicipalesC")
public class CoordinadoresMunicipalesC {
	private static final Logger logger = LoggerFactory.getLogger(CoordinadoresMunicipalesC.class);

	@Autowired
	SqlSession sqlSession;
	
	public Modelo<CoordinadorMunicipalEO> modelo(GeozonaParticionEO region, MunicipioEO municipio) {
		HashMap<String, Object> mapa=new HashMap<>();
		mapa.put("region", region);
		mapa.put("municipio", municipio);
		logger.debug("Region Recibida : {}",region);
		logger.debug("Municipio Recibida : {}",municipio);
		List<CoordinadorMunicipalEO> listado=sqlSession.selectList("estructurasEdoMex.coordinadorMunicipal.listado",mapa);
		return new Modelo<>(listado);		
	}
}
