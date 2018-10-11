package com.saganet.politik.components.encuestas.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.admin.EncuestaEO;
import com.saganet.politik.database.encuestas.admin.PreguntaEO;
import com.saganet.politik.dominios.TiposPreguntaDO;
import com.saganet.politik.modelos.Modelo;

@Component("PreguntasC")
public class PreguntasC {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(PreguntasC.class);
	
	public Modelo<PreguntaEO> modelo(EncuestaEO encuesta, PreguntaEO preguntaSeleccionada){
		
		logger.debug("preguntaSeleccionada0: {}", preguntaSeleccionada);
		
		Modelo<PreguntaEO> modelo;
		List<PreguntaEO> listado;
		
		modelo = new Modelo<>();
		listado = sqlSession.selectList("encuestas.admin.preguntas.listado", encuesta);
		
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			
			if(preguntaSeleccionada==null){
				modelo.setSeleccionado(listado.get(0));
				logger.debug("preguntaSeleccionada1: {}", listado.get(0));
			}else{
				modelo.setSeleccionado(preguntaSeleccionada);
			}
			
		}
		
		return modelo;
	}
	
	public PreguntaEO nuevo(EncuestaEO encuesta){
		PreguntaEO nuevo = new  PreguntaEO();
		nuevo.setIdEncuesta(encuesta.getId());
		return nuevo;
	}
	
	public void insertar(PreguntaEO nuevo){
		Integer conteoConsecutivo = 0;
		conteoConsecutivo = sqlSession.selectOne("encuestas.admin.preguntas.conteoConsecutivo",nuevo.getIdEncuesta());
		nuevo.setConsecutivoPregunta(conteoConsecutivo+1);
		nuevo.setNick(getUsuario().getNick());
		sqlSession.insert("encuestas.admin.preguntas.insertar",nuevo);
	}
	
	public TiposPreguntaDO[] listadoTiposPregunta(){
		logger.debug("Se genera listado de Niveles");
		return TiposPreguntaDO.values();
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
