package com.saganet.politik.components.administracion;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("AvisosC")
public class AvisosC {
	@Autowired SqlSession sqlSession;

	private String mensaje;

	public String getMensaje() {
		mensaje = sqlSession.selectOne("administracion.avisos.mostrar");
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
