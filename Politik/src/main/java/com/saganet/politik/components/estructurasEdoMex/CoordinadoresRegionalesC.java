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
import com.saganet.politik.database.estructurasEdoMex.CoordinadorRegionalEO;

@Component("EstructurasEdoMexCoordinadoresRegionalesC")
public class CoordinadoresRegionalesC {
	private static final Logger logger = LoggerFactory.getLogger(CoordinadoresRegionalesC.class);

	@Autowired
	SqlSession sqlSession;
	
	public Modelo<CoordinadorRegionalEO> modelo(GeozonaParticionEO region) {
		HashMap<String, Object> mapa=new HashMap<>();
		mapa.put("region", region);
		logger.debug("Region Recuibida : {}",region);
		List<CoordinadorRegionalEO> listado=sqlSession.selectList("estructurasEdoMex.coordinadorRegional.listado",mapa);
		return new Modelo<>(listado);		
	}
}
