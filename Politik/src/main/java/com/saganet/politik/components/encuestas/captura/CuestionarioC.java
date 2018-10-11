package com.saganet.politik.components.encuestas.captura;

import java.util.HashMap;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.components.encuestas.admin.CampaniasC;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.admin.PreguntaEO;
import com.saganet.politik.database.encuestas.captura.ContactoEO;
import com.saganet.politik.database.encuestas.captura.CuestionarioEO;
import com.saganet.politik.dominios.EstatusCuestionarioDO;

@Component("CuestionarioC")
public class CuestionarioC {
	
	private static final Logger logger = LoggerFactory.getLogger(CuestionarioC.class);
	
	@Autowired
	CampaniasC campaniaC;
	
	@Autowired
	SqlSession sqlSession;

	public CuestionarioEO cuestionarioByNick(){
		String nick;
		nick = getUsuario().getNick();
		CuestionarioEO cuestionario;
		ContactoEO contacto;
		HashMap<String, Object> params;
		
		cuestionario = new CuestionarioEO();
		cuestionario.setCampania(campaniaC.campaniaCompetaByNick(nick));
		
		contacto = sqlSession.selectOne("encuestas.captura.cuestionario.contactoByEstatus", cuestionario.getCampania().getTablaContactos());
		
		//CAmbiamos_estatus_del_contacto_a_ocupado
		params = new HashMap<>();
		params.put("tablaContactos", cuestionario.getCampania().getTablaContactos());
		params.put("estatus", "OCUPADO");
		params.put("id", contacto.getId());
		
		sqlSession.update("encuestas.captura.cuestionario.cabiarEstatusContacto", params);
		
		cuestionario.setContacto(contacto);
		
		logger.debug("CuestionarioByNick: {}", cuestionario);
		
		return cuestionario;
	}
	
	public void guardarCuestionario(CuestionarioEO cuestionario){
		
		HashMap<String, Object> params;
		StringBuilder camposPreguntas;
		StringBuilder camposRespuestas;
		
		camposPreguntas = new StringBuilder();
		camposRespuestas = new StringBuilder();
		
		for(PreguntaEO pregunta : cuestionario.getCampania().getEncuesta().getPreguntas()){
			camposPreguntas.append("_"+pregunta.getConsecutivoPregunta()+",");
		}
		
		for(PreguntaEO pregunta : cuestionario.getCampania().getEncuesta().getPreguntas()){
			camposRespuestas.append("'"+pregunta.getRespuesta()+"',");
		}
		
		logger.debug("cuestionario: {}", cuestionario);
		
		params = new HashMap<>();
		params.put("cuestionario", cuestionario);
		params.put("camposPreguntas", camposPreguntas);
		params.put("camposRespuestas", camposRespuestas);
		
		try{
			
			if(cuestionario.getEstatus().equals("ENCUESTADO")){
				//Guardamos_cuestionario
				sqlSession.insert("encuestas.captura.cuestionario.insertar", params);
			}
			
			//CAmbiamos_estatus_del_contacto_a_encuestado
			String nick;
			nick = getUsuario().getNick();
			
			params = new HashMap<>();
			params.put("tablaContactos", cuestionario.getCampania().getTablaContactos());
			params.put("estatus", cuestionario.getEstatus());
			params.put("id", cuestionario.getContacto().getId());
			params.put("nickUso", nick);
			
			logger.debug("params: {}", params);
			
			sqlSession.update("encuestas.captura.cuestionario.cabiarEstatusContacto", params);
			logger.debug("Se cambio el estatus");
			
			//Incrementar vuelta contacto
			sqlSession.update("encuestas.captura.cuestionario.incrementarVueltaContacto", params);
			logger.debug("Se incremento la vuelta");
			
		}catch(Exception e){
			
			//CAmbiamos_estatus_del_contacto_a_libre
			params = new HashMap<>();
			params.put("tablaContactos", cuestionario.getCampania().getTablaContactos());
			params.put("estatus", "LIBRE");
			params.put("id", cuestionario.getContacto().getId());
			
			sqlSession.update("encuestas.captura.cuestionario.cabiarEstatusContacto", params);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡ERROR!", "No se guardo la encuesta."));
			
			logger.debug("Error al guardat el cuestionario: {}", e.getCause());
		}
		
	}
	
	public void cancelarCuestionario(ContactoEO contacto){
		logger.debug("contacto: {}", contacto);
	}
	
	public EstatusCuestionarioDO[] estatusCuestionario(){
		return EstatusCuestionarioDO.values();
	}
	
	public String validaContactosDisponibles(){
		
		String nick;
		nick = getUsuario().getNick();
		CuestionarioEO cuestionario;
		
		cuestionario = new CuestionarioEO();
		cuestionario.setCampania(campaniaC.campaniaCompetaByNick(nick));
		try{
			Integer validacion = sqlSession.selectOne("encuestas.captura.cuestionario.validaContactosDisponibles", cuestionario.getCampania().getTablaContactos());
			
			if(validacion>0){
				return "SI";
			}else{
				return "NO";
			}
			
		}catch(Exception e){
			logger.debug("Error: {}", e.toString());
			return "NO_ASIGNADO";
		}
		
		
		
		
	}

	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
