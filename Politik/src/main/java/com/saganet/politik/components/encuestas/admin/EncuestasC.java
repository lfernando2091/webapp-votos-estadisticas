package com.saganet.politik.components.encuestas.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.admin.EncuestaEO;
import com.saganet.politik.modelos.Modelo;

@Component("EncuestasC")
public class EncuestasC {
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<EncuestaEO> modelo(EncuestaEO encuestaSeleccionada){
		Modelo<EncuestaEO> modelo;
		List<EncuestaEO> listado;
		
		modelo = new Modelo<>();
		listado = sqlSession.selectList("encuestas.admin.encuestas.listadoCompleto");
		
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			
			if(encuestaSeleccionada==null){
				modelo.setSeleccionado(listado.get(0));
			}else{
				modelo.setSeleccionado(encuestaSeleccionada);
			}
			
		}
		
		return modelo;
	}
	
	public EncuestaEO nuevo(){
		return new EncuestaEO();
	}
	
	public void insertar(EncuestaEO nuevo){
		nuevo.setNick(getUsuario().getNick());
		sqlSession.insert("encuestas.admin.encuestas.insertar",nuevo);
	}
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
