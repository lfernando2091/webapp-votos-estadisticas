package com.saganet.politik.components.catalogos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.TipoTelefonoEO;
import com.saganet.politik.modelos.Modelo;

@Component("CatalogosTiposTelefonoC")
public class TiposTelefonoC {
	private static final Logger logger = LoggerFactory.getLogger(TiposTelefonoC.class);
	
	@Autowired
	private SqlSession sqlSession;

	public Modelo<TipoTelefonoEO> modelo(){
		logger.debug("Ingresando");
		Modelo<TipoTelefonoEO> modelo;
		List<TipoTelefonoEO> listado;

		modelo = new Modelo<TipoTelefonoEO>();
		listado = sqlSession.selectList("catalogos.tiposTelefonos.listado");
		modelo.setListado(listado);
		if (!listado.isEmpty()) {
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se genera modelo de TipoTelefonoEO: {}", listado);
		return modelo;
	}
}
