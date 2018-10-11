package com.saganet.politik.components.estructurasEdoMex;

import java.util.List;
import org.slf4j.Logger;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import com.saganet.politik.modelos.Modelo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import com.saganet.politik.database.catalogos.MunicipioEO;
import org.springframework.beans.factory.annotation.Autowired;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.estructurasEdoMex.VisitadorEO;

@Component("EstructurasEdoMexVisitadoresC")
public class VisitadoresC {
	private static final Logger logger = LoggerFactory.getLogger(VisitadoresC.class);

	@Autowired
	SqlSession sqlSession;
	
	public Modelo<VisitadorEO> modelo(GeozonaParticionEO region, MunicipioEO municipio) {
		HashMap<String, Object> mapa=new HashMap<>();
		mapa.put("region", region);
		mapa.put("municipio", municipio);
		logger.debug("Region Recibida : {}",region);
		logger.debug("Municipio Recibida : {}",municipio);
		List<VisitadorEO> listado=sqlSession.selectList("estructurasEdoMex.visitador.listado",mapa);
		return new Modelo<>(listado);		
	}
}
