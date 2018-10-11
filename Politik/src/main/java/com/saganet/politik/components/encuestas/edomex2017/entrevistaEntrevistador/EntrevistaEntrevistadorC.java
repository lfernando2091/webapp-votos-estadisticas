package com.saganet.politik.components.encuestas.edomex2017.entrevistaEntrevistador;

import java.util.HashMap;

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
import com.saganet.politik.database.encuestas.edomex2017.entrevistaEntrevistador.EntrevistaEO;
import com.saganet.politik.database.estructurasEdoMex.VisitadorEO;

@Component("Edomex2017EntrevistaEntrevistadorC")
public class EntrevistaEntrevistadorC {

	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(EntrevistaEntrevistadorC.class);

	public String buscarFolio(RequestContext context, Integer id) {
		HashMap<String, Object> viewScope;
		EntrevistaEO entrevista;
		VisitadorEO visitador;
		visitador = new VisitadorEO();
		viewScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		visitador = sqlSession.selectOne("estructurasEdoMex.visitador.buscarFolio", id);
		logger.debug("visitador: {}", visitador);
		if (visitador!= null) {

			// buscamos la encuesta

			
			entrevista = sqlSession.selectOne("encuestas.edomex2017.entrevistaEntrevistador.entrevistaEntrevistador.listadoBuscarEntrevista", id);
			logger.debug("Entrevista: {}", entrevista);
			if (entrevista==null) {
				entrevista = new EntrevistaEO();
				entrevista.setNick(getUsuario().getNick());
				entrevista.setFolio(id);
			}

			viewScope.put("entrevista", entrevista);
			viewScope.put("visitador", visitador);
			viewScope.put("usuario", getUsuario());
			logger.debug("viewScope: {}", viewScope);
			return "success";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontró información", "Contact admin."));
			return "error";
		}
	}

	public String guardar(RequestContext context) {
		logger.debug("Encuesta: ", context);
		HashMap<String, Object> viewScope;
		viewScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		EntrevistaEO entrevista;
		VisitadorEO visitador;
		entrevista = (EntrevistaEO) viewScope.get("entrevista");
		visitador = (VisitadorEO) viewScope.get("visitador");
		try {
		
			sqlSession.insert("encuestas.edomex2017.entrevistaEntrevistador.entrevistaEntrevistador.insertar",
					entrevista);
			sqlSession.update("estructurasEdoMex.visitador.actualizar", viewScope);
			logger.debug("VVVVV:{}", visitador);
			return "success";
		} catch (Exception error) {
			error.printStackTrace();
			return "error";
		}
	}

	public String actualizar(RequestContext context){
		HashMap<String, Object> viewScope;
		viewScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		EntrevistaEO entrevista;
		VisitadorEO visitador;
		entrevista = (EntrevistaEO) viewScope.get("entrevista");
		visitador = (VisitadorEO) viewScope.get("visitador");
		
		try {
			
			sqlSession.insert("encuestas.edomex2017.entrevistaEntrevistador.entrevistaEntrevistador.actualizar",
					entrevista);
			sqlSession.update("estructurasEdoMex.visitador.actualizar", viewScope);
			logger.debug("VVVVV:{}", visitador);
			return "success";
		} catch (Exception error) {
			error.printStackTrace();
			return "error";
		}
	}
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
