package com.saganet.politik.components.catalogos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.TipoRedSocialEO;
import com.saganet.politik.modelos.Modelo;

@Component("CatalogosTiposRedesSocialesC")
public class TiposRedesSocialesC {
	@Autowired
	private SqlSession sqlSession;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TiposRedesSocialesC.class);
	
	public Modelo<TipoRedSocialEO> modelo(){
		Modelo<TipoRedSocialEO> modelo;
		List<TipoRedSocialEO> listado;

		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.tiposRedesSociales.listado");
		
		modelo.setListado(listado);
		if (!listado.isEmpty()) {
			modelo.setSeleccionado(listado.get(0));
		}

		return modelo;
		
	}
}
