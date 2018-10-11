package com.saganet.politik.components.warehouse;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.database.warehouse.EmailEO;

@Component("WarehouseEMailsC")
public class EmailsC {
	private static final Logger logger = LoggerFactory.getLogger(EmailsC.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	public EmailEO nuevo(){
		return new EmailEO();
	}
	
	public void insertar(EmailEO eMail, PersonaEO persona){
		HashMap<String, Object> parametros;
		
		parametros = new HashMap<>();
		parametros.put("eMail", eMail);
		parametros.put("persona", persona);
		
		sqlSession.insert("warehouse.eMails.insertar", parametros);
		logger.debug("Se agregar eMail: {}", eMail);
		
		persona.getEMails().add(eMail);
	}
}
