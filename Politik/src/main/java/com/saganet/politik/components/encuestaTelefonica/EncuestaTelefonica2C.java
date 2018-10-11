package com.saganet.politik.components.encuestaTelefonica;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestaTelefonica.RespuestasEncuestaTelefonica2EO;
import com.saganet.politik.database.encuestas.entrevistasTelefonicas.ContactoEO;


@Component("EncuestaTelefonica2C")
public class EncuestaTelefonica2C {
	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(EncuestaTelefonica2C.class);

	public ContactoEO listadoContacto() {
		ContactoEO contacto= new ContactoEO();
		contacto= sqlSession.selectOne("encuestasTelefonicas.contacto.listado");
		logger.debug("contacto listadoContacto : {}", contacto);
		return contacto;
	}
	
	public RespuestasEncuestaTelefonica2EO nuevo(ContactoEO contacto){
		RespuestasEncuestaTelefonica2EO encuesta=new RespuestasEncuestaTelefonica2EO();
		encuesta.setContacto(contacto);
		encuesta.setNick(getUsuario().getNick());
		logger.debug("Entro a listado encuesta: {}", encuesta );
		return encuesta;
	}
	
	public void guardar(RespuestasEncuestaTelefonica2EO encuesta){
		logger.debug("encuesta A GUARDAR: {}", encuesta);
		sqlSession.insert("encuestasTelefonicas.respuestas.guardar",encuesta);
		sqlSession.update("encuestasTelefonicas.contacto.actualizarEstado", encuesta.getContacto().getId());
		sqlSession.update("encuestasTelefonicas.contacto.actualizarVuelta",encuesta.getContacto().getId());
		
	}	
	
	public void actualizarVuelta(ContactoEO contacto){
		logger.debug("encuesta: {}", contacto);
		sqlSession.update("encuestasTelefonicas.contacto.actualizarVuelta", contacto.getId());
	}
	
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
