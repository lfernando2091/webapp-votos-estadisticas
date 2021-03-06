package com.saganet.politik.components.encuestas.edomex2017.supervisor;


import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.edomex2017.supervisor.SupervisorEO;


@Component("Edomex2017SupervisorSupervisor")
public class SupervisorC {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(SupervisorC.class);
	
	public SupervisorEO obtenerSupervisor(){
		SupervisorEO actual;
		actual=sqlSession.selectOne("encuestas.supervisor.supervisor.buscarPorId",getUsuario().getNick());
		logger.debug("Actual: {}",actual);
		return actual;
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
