package com.saganet.politik.components.estructurasEdoMex.reportes;

import java.util.List;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.LoggerFactory;

import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.database.encuestas.edomex2017.AvanceEncuestadoresEO;

import org.springframework.beans.factory.annotation.Autowired;

import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.GeozonaEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.estructurasEdoMex.SupervisorEO;
import com.saganet.politik.database.estructurasEdoMex.reportes.AvanceEstrucutrasEO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;

@Component("ReportesEstructurasEdoMexC")
public class ReportesEstructurasEdoMexC {
	private static final Logger logger = LoggerFactory.getLogger(ReportesEstructurasEdoMexC.class);

	@Autowired
	SqlSession sqlSession;
	
	
	public Modelo<NivelesDO> modeloNiveles(){
		Modelo<NivelesDO> modelo;
		List<NivelesDO> listado;
		
		modelo = new Modelo<>();
		listado = new ArrayList<>();
		
		listado.add(NivelesDO.ENTIDAD);
		listado.add(NivelesDO.GEOZONA);
		listado.add(NivelesDO.MUNICIPIO);
		listado.add(NivelesDO.SECCION);
		
		modelo.setListado(listado);
		modelo.setSeleccionado(listado.get(0));
		
		return modelo;
	}
	

	public Modelo<AvanceEstrucutrasEO>  modeloAvance(NivelesDO nivel, ProgramasEdoMexDO programa){
		Modelo<AvanceEstrucutrasEO> modelo;
		List<AvanceEstrucutrasEO> listado=new ArrayList<>();
		
		
		switch (nivel) {
		case ENTIDAD:
			listado=sqlSession.selectList("estructurasEdoMex.reportes.avanceEstructuras.listadoEntidad", programa);
			logger.debug("nivel: {}", nivel);
			logger.debug("nivel: {}", programa);
			logger.debug("Listado Entidad: {}", listado);
		break;	
		case GEOZONA:
			listado=sqlSession.selectList("estructurasEdoMex.reportes.avanceEstructuras.listadoRegiones", programa);
			logger.debug("nivel: {}", nivel);
			logger.debug("nivel: {}", programa);
			logger.debug("Listado Geozona: {}", listado);
		break
		;	
		
		case MUNICIPIO:
			listado=sqlSession.selectList("estructurasEdoMex.reportes.avanceEstructuras.listadoMunicipio", programa);
			logger.debug("nivel: {}", nivel);
			logger.debug("nivel: {}", programa);
			logger.debug("Listado Municipio: {}", listado);
		break
		;
		case SECCION:
//			listado=sqlSession.selectList("estructurasEdoMex.reportes.avanceEstructuras.listadoMunicipio", programa);
			logger.debug("nivel: {}", nivel);
			logger.debug("nivel: {}", programa);
			logger.debug("Listado Seccion: {}", listado);
		break
		;
	
		
	}
	
		logger.debug("Listado: {}", listado);
		modelo = new Modelo<>(listado);
		return modelo;
	}
	
	public Modelo<AvanceEstrucutrasEO>  avanceSecciones (  ){
		Modelo<AvanceEstrucutrasEO> modelo;
		List<AvanceEstrucutrasEO> listado=new ArrayList<>();
		logger.debug("Listado: {}", listado);
		modelo = new Modelo<>(listado);
		return modelo;
	}
}
