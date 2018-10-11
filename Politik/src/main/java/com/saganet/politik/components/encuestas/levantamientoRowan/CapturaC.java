package com.saganet.politik.components.encuestas.levantamientoRowan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.levantamientoRowan.EncuestaEO;
import com.saganet.politik.database.encuestas.levantamientoRowan.EntrevistadoEO;
import com.saganet.politik.modelos.Modelo;

@Component("LevantamientoRowanCapturaC")
public class CapturaC {
	@Autowired
	SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(CapturaC.class);

	public String buscarId(RequestContext context, Integer id) {
		logger.debug("Encuesta: {}",id);
		HashMap<String, Object> flowScope, parametros, datosNick;
		List<Object> entrevistados;
		EntrevistadoEO entrevistado;
		EncuestaEO encuesta;
		Integer idMunicipioLogueado;
		
		List<UsuarioEO> listado;
		int suma;
		listado = new ArrayList<>();
		suma = 1;
		idMunicipioLogueado=0;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		parametros = new HashMap<>();
		datosNick = new HashMap<>();
		
		//buscamos municipio del logeado
		datosNick = sqlSession.selectOne("encuestas.levantamientoRowan.registroUsuarios.buscarDatosNick", getUsuario().getNick());
		
		
		parametros.put("folio", id);
		parametros.put("municipio", Integer.parseInt(datosNick.get("id_municipio").toString()));
		entrevistado = sqlSession.selectOne("encuestas.levantamientoRowan.entrevistado.buscarId", parametros);

		logger.debug("parametros: {}",parametros);
		logger.debug("entrevistado: {}",entrevistado);
		if(entrevistado!=null){
		
				encuesta = new EncuestaEO();
				entrevistado.setFechaNacimiento(entrevistado.getFechaNacimiento().toString().substring(6,8)+"/"+entrevistado.getFechaNacimiento().toString().substring(4,6) + "/"+entrevistado.getFechaNacimiento().toString().substring(0,5));
				//buscamos si esta contestado
				logger.debug("Encuesta: {}",entrevistado);
				try{
				encuesta = sqlSession.selectOne("encuestas.levantamientoRowan.captura.buscarPorId", entrevistado);
				}catch(Exception e){
					logger.debug(" Error: {}",e.getCause());
				}
				if(encuesta==null){
					encuesta = new EncuestaEO();
					encuesta.setNick(getUsuario().getNick());
					encuesta.setIdContacto(entrevistado.getIdInterno().toString());
				}else{
					encuesta.setNickActualizacion(getUsuario().getNick());
					entrevistado.setNombre(encuesta.getNombre());
					entrevistado.setApellidoPaterno(encuesta.getPaterno());
					entrevistado.setApellidoMaterno(encuesta.getMaterno());
					entrevistado.setFechaNacimiento(encuesta.getFechaNacimiento());
					entrevistado.setSexo(encuesta.getGenero());
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "*IMPORTANTE: El folio consultado ya ha sido capturado anteriormente ("+encuesta.getNick()+ " " + encuesta.getFecha() + ").", "Contact admin."));
				}
				listado.add(getUsuario());
				flowScope.put("entrevistado", entrevistado);
				flowScope.put("encuesta", encuesta);
				flowScope.put("modeloEncuestadores", new Modelo<>(listado));
				logger.debug("encuesta: {}", encuesta);
				logger.debug("entrevistado: {}", entrevistado);
				return "success";
			}else{
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Folio no encontrádo.", "Contact admin."));
				return "error";
			}
			
		
	}
	
	
	public String buscaInterno(RequestContext context, Integer id) {
		logger.debug("Encuesta: {}",id);
		HashMap<String, Object> flowScope, parametros;
		List<Object> entrevistados;
		EntrevistadoEO entrevistado;
		EncuestaEO encuesta;
		
		List<UsuarioEO> listado;
		int suma;
		listado = new ArrayList<>();
		suma = 1;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		parametros = new HashMap<>();
		
		//buscamos al visitador
		
		
		parametros.put("folio", id);
		
		entrevistado = sqlSession.selectOne("encuestas.levantamientoRowan.entrevistado.buscarIdInterno", parametros);
		
		if(entrevistado!=null){
			
				encuesta = new EncuestaEO();
				entrevistado.setFechaNacimiento(entrevistado.getFechaNacimiento().toString().substring(6,8)+"/"+entrevistado.getFechaNacimiento().toString().substring(4,6) + "/"+entrevistado.getFechaNacimiento().toString().substring(0,5));
				//buscamos si esta contestado
				logger.debug("Encuesta: {}",entrevistado);
				try{
				encuesta = sqlSession.selectOne("encuestas.levantamientoRowan.captura.buscarPorId", entrevistado);
				}catch(Exception e){
					logger.debug(" Error: {}",e.getCause());
				}
				if(encuesta==null){
					encuesta = new EncuestaEO();
					encuesta.setNick(getUsuario().getNick());
					encuesta.setIdContacto(entrevistado.getIdInterno().toString());
				}else{
					encuesta.setNickActualizacion(getUsuario().getNick());
					entrevistado.setNombre(encuesta.getNombre());
					entrevistado.setApellidoPaterno(encuesta.getPaterno());
					entrevistado.setApellidoMaterno(encuesta.getMaterno());
					entrevistado.setFechaNacimiento(encuesta.getFechaNacimiento());
					entrevistado.setSexo(encuesta.getGenero());
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "*IMPORTANTE: El folio consultado ya ha sido capturado anteriormente ("+encuesta.getNick()+ " " + encuesta.getFecha() + ").", "Contact admin."));
				}
				listado.add(getUsuario());
				flowScope.put("entrevistado", entrevistado);
				flowScope.put("encuesta", encuesta);
				flowScope.put("modeloEncuestadores", new Modelo<>(listado));
				logger.debug("encuesta: {}", encuesta);
				logger.debug("entrevistado: {}", entrevistado);
				return "success";
			
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontró información", "Contact admin."));
			return "error";
		}
		
	}
	
	
	public void guardar(RequestContext context) {
		logger.debug("Encuesta guardar: {}", "entro");
		HashMap<String, Object> flowScope;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
	try{
		logger.debug(" flowScope: {}",flowScope );
		sqlSession.insert("encuestas.levantamientoRowan.captura.insertar",flowScope);
		sqlSession.update("encuestas.levantamientoRowan.captura.actualizarEstatus", flowScope);
	}catch(Exception e){
		logger.debug(" Error: {}",e.getCause());
		
	}
	}


	public void actualizar(RequestContext context) {
		try{
		HashMap<String, Object> flowScope;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		sqlSession.update("encuestas.levantamientoRowan.captura.actualizarEncuesta", flowScope);
		sqlSession.update("encuestas.levantamientoRowan.captura.actualizarEstatus", flowScope);
		logger.debug(" encuesta: {}",flowScope.get("entrevistado"));
		}catch(Exception e){
			logger.debug(" Error: {}",e.getCause());
			
		}
	}

public Modelo<UsuarioEO> modeloEntrevistadores(){
	List<UsuarioEO> listado;
	listado = new ArrayList<>();
	listado.add(getUsuario());
	return new Modelo<>(listado);
}
	

	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

}
