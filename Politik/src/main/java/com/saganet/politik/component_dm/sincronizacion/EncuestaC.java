package com.saganet.politik.component_dm.sincronizacion;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.saganet.politik.database_dm.sincronizacion.EncuestaEO;
import com.saganet.politik.modelos.Modelo;

@Component("EncuestaC")
public class EncuestaC {
	
	@Autowired
	SqlSession sqlSessionDM;
	
	private static final Logger logger = LoggerFactory.getLogger(EncuestaC.class);
	
	public Modelo<EncuestaEO> modelo(){
		Modelo<EncuestaEO> modelo;
		List<EncuestaEO> listado;
		
		listado = sqlSessionDM.selectList("sincronizacion.encuesta.listado");
		//logger.debug("Listado Encuesta: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			logger.debug("listado.get(0): {}", listado.get(0));
			modelo.setSeleccionado(listado.get(0));
		}
		
		//logger.debug("Modelo Encuesta: {}", modelo);
		
		return modelo;
	}
	
}
