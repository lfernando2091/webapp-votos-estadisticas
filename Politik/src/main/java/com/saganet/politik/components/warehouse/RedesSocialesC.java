package com.saganet.politik.components.warehouse;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.TipoRedSocialEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.database.warehouse.RedSocialEO;

@Component("WarehouseRedesSocialesC")
public class RedesSocialesC {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(RedesSocialesC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public RedSocialEO nuevo(){
		RedSocialEO redSocial;
		TipoRedSocialEO tipo;
		
		tipo = new TipoRedSocialEO();
		tipo.setId(1);
		tipo.setDireccion("https://www.facebook.com/");
		tipo.setNombre("Facebook");
		tipo.setLogo("/resources/img/facebook22x22.png");
		
		redSocial = new RedSocialEO();
		redSocial.setTipo(tipo);
		
		return redSocial;
	}
	
	public void insertar(RedSocialEO redSocial, PersonaEO persona){
		HashMap<String, Object> parametros;
		
		parametros = new HashMap<>();
		parametros.put("redSocial", redSocial);
		parametros.put("persona", persona);
		
		sqlSession.insert("warehouse.redesSociales.insertar", parametros);
		
		persona.getRedesSociales().add(redSocial);
	}
}
