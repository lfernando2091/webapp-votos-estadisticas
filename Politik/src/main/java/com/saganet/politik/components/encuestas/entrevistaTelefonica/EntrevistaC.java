package com.saganet.politik.components.encuestas.entrevistaTelefonica;

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
import com.saganet.politik.database.encuestas.entrevistasTelefonicas.ContactoEO;
import com.saganet.politik.database.encuestas.entrevistasTelefonicas.ResultadosEO;


@Component("EntrevistaTelefonicaC")
public class EntrevistaC {

	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(EntrevistaC.class);

	public String buscarFolio(RequestContext context, Integer id) {
		HashMap<String, Object> viewScope;
		ResultadosEO entrevista;
		ContactoEO contacto;
		contacto = new ContactoEO();
		viewScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		contacto = sqlSession.selectOne("encuestas.entrevistaTelefonica.contacto2.buscarFolio", id);
		logger.debug("contacto: {}", contacto);
		if (contacto!= null) {

			// buscamos la encuesta

			entrevista = sqlSession.selectOne("encuestas.entrevistaTelefonica.resultados2.listadoBuscarEntrevista", id);
			logger.debug("Entrevista: {}", entrevista);
			if (entrevista==null) {
				entrevista = new ResultadosEO();
				entrevista.setNick(getUsuario().getNick());
				entrevista.setFolio(id);
			}

			viewScope.put("entrevista", entrevista);
			viewScope.put("contacto", contacto);
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
		ResultadosEO entrevista;
		ContactoEO contacto;
		entrevista = (ResultadosEO) viewScope.get("entrevista");
		contacto = (ContactoEO) viewScope.get("contacto");
		try {
		
			sqlSession.insert("encuestas.entrevistaTelefonica.resultados2.insertar", entrevista);
			sqlSession.update("encuestas.entrevistaTelefonica.contacto2.actualizar", entrevista);
			logger.debug("VVVVV:{}", contacto);
			return "success";
		} catch (Exception error) {
			error.printStackTrace();
			return "error";
		}
	}

	public String actualizar(RequestContext context){
		HashMap<String, Object> viewScope;
		viewScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		ResultadosEO entrevista;
		ContactoEO visitador;
		entrevista = (ResultadosEO) viewScope.get("entrevista");
		visitador = (ContactoEO) viewScope.get("contacto");
		
		try {
			
			sqlSession.insert("encuestas.entrevistaTelefonica.resultados2.actualizar", entrevista);
			sqlSession.update("encuestas.entrevistaTelefonica.contacto2.actualizar", entrevista);
			
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
