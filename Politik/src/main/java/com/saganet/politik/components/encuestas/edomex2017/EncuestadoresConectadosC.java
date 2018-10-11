package com.saganet.politik.components.encuestas.edomex2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;
import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.edomex2017.EncuestadoresConectadosEO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.Modelo;

@Component("Edomex2017EncuestadoresConectados")
public class EncuestadoresConectadosC {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	SessionRegistry session;
	
	private static final Logger logger = LoggerFactory.getLogger(EncuestadoresConectadosC.class);


	public Modelo<EncuestadoresConectadosEO> usuariosConectados(ProgramasEdoMexDO programa){
		HashMap<String, Object>  mapa = new HashMap<>();
		Usuario user;
		List<String> usuarios=new ArrayList<>();
		for(Object o : session.getAllPrincipals()){
			user = (Usuario) o;
			usuarios.add(user.getUsuario().getNick());			
		}
		logger.debug("usuarios : {}", usuarios);
		mapa.put("usuarios", usuarios);
		mapa.put("programa", programa);
		List<EncuestadoresConectadosEO> listado=sqlSession.selectList("encuestas.edomex2017.encuestadoresConectados.listado",mapa);
		return new Modelo<>(listado);
	}
	
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

}
