package com.saganet.politik.components.encuestas.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.admin.PreguntaEO;
import com.saganet.politik.database.encuestas.admin.RespuestaCerradaEO;
import com.saganet.politik.modelos.Modelo;

@Component("RespuestasCerradasC")
public class RespuestasCerradasC {
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<RespuestaCerradaEO> modelo(PreguntaEO pregunta){
		Modelo<RespuestaCerradaEO> modelo;
		List<RespuestaCerradaEO> listado;
		
		modelo = new Modelo<>();
		listado = sqlSession.selectList("encuestas.admin.respuestasCerradas.listado", pregunta);
		
		modelo.setListado(listado);

		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public RespuestaCerradaEO nuevo(PreguntaEO pregunta){
		RespuestaCerradaEO nuevo = new RespuestaCerradaEO();
		nuevo.setIdPregunta(pregunta.getId());
		return nuevo;
	}
	
	public void insertar(RespuestaCerradaEO nuevo){
		nuevo.setNick(getUsuario().getNick());
		sqlSession.insert("encuestas.admin.respuestasCerradas.insertar", nuevo);
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
