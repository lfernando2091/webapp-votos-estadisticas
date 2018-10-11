package com.saganet.politik.components.encuestas.edomex2017.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
import com.saganet.politik.database.administracion.RolEO;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.estructurasEdoMex.VisitadorEO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;

@Component("Edomex2017V2RegistroUsuarioC")
public class RegistroUsuarioC {
	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(RegistroUsuarioC.class);

	public VisitadorEO nuevo(){
		VisitadorEO nuevo;
		nuevo = new VisitadorEO();
		return nuevo;
	}
	
	
	public String validarDatos(RequestContext context, VisitadorEO visitador) {
		HashMap<String, Object> mapa, viewScope;
		UsuarioEO us;
		Integer filas;

		filas = 0;
		mapa = new HashMap<>();
		viewScope = (HashMap<String, Object>) context.getFlowScope().asMap();

		us = new UsuarioEO();
		mapa.put("codigo", visitador.getCodigo());
		mapa.put("municipio", visitador.getMunicipio().getIdMunicipio());
		filas = sqlSession.selectOne("encuestas.edomex2017.v2.registroUsuarios.validarCodigo", mapa);
		if (filas == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontró información", "Error"));
			return "error";
		} else {
			// FacesContext.getCurrentInstance().addMessage(null, new
			// FacesMessage(FacesMessage.SEVERITY_INFO, "Codigo Correcto",
			// "Error"));
			us = registrar(visitador);
			viewScope.put("usuario", us);
			return "success";
		}

	}

	public UsuarioEO registrar(VisitadorEO visitador) {
		HashMap<String, Object> mapa, valorRegistro;
		UsuarioEO usuario;
		
		MunicipioEO municipioe;
		List<RolEO> listado;
		RolEO rol;
		
		municipioe = new MunicipioEO();

		mapa = new HashMap<>();
		usuario = new UsuarioEO();
		listado = new ArrayList<>();
		
		// usuario.setTerritorios(territorios);
		// registrar en tabla de encuestador
		logger.debug("antes Valor registro : {}", usuario);
		valorRegistro =  sqlSession.selectOne("encuestas.edomex2017.v2.registroUsuarios.datosCodigo", visitador.getCodigo());
		logger.debug("despues Valor registro : {}", valorRegistro);
		switch (valorRegistro.get("programa").toString()) {
		case "PROSPERA":
			visitador.setPrograma(ProgramasEdoMexDO.PROSPERA);
			break;
		case "INSUS":
			visitador.setPrograma(ProgramasEdoMexDO.INSUS);
			break;
		case "LICONSA":
			visitador.setPrograma(ProgramasEdoMexDO.LICONSA);
			break;

		default:
			break;
		}
		
		////informacion del usuario
		if(valorRegistro.get("entrevista").toString().equals("1,2")){
			rol = new RolEO();
			rol.setRol("ROLE_ENCUESTA_SUJETOS_SOCIALES");
			listado.add(rol);
			
/*
			rol = new RolEO();
			rol.setRol("ROLE_ENCUESTA_EDOMEX");
			listado.add(rol);*/
		}
		
		if(valorRegistro.get("entrevista").toString().equals("3")){
		rol = new RolEO();
		rol.setRol("ROLE_ENCUESTA_FUERZA_CIUDADANA");
		listado.add(rol);
		}
		
		rol = new RolEO();
		rol.setRol("ROLE_USER");
		listado.add(rol);
		

		mapa.put("nombre", visitador.getNombre());
		mapa.put("primerApellido", visitador.getPrimerApellido());
		mapa.put("segundoApellido",visitador.getSegundoApellido());
		mapa.put("email", visitador.getEmail());
		mapa.put("movil", visitador.getMovil());
		mapa.put("municipio", visitador.getMunicipio());
		mapa.put("codigo", visitador.getCodigo());
		// crear usuario
		usuario.setNick("ems_" + sqlSession.selectOne("encuestas.edomex2017.v2.registroUsuarios.conteoUsuario"));
		usuario.setNombre(visitador.getNombre() + " " + visitador.getPrimerApellido() + " " + visitador.getSegundoApellido());
		usuario.setCelular(visitador.getMovil());
		usuario.setMail(visitador.getEmail());
		usuario.setPw(clave());
		usuario.setHabilitado(true);
		usuario.setNivel(NivelesDO.NACIONAL);
		usuario.setRoles(listado);
		//// fin de la informacion del usuario
        visitador.setNick(usuario.getNick());
        visitador.setPw(usuario.getPw());
		visitador.setUsuario(usuario);
		GeozonaParticionEO geo = new GeozonaParticionEO();
		geo.setIdParticion(Integer.parseInt(valorRegistro.get("region").toString()));
		visitador.setRegion(geo);
		municipioe.setIdMunicipio(visitador.getMunicipio().getIdMunicipio());
		visitador.setMunicipio(municipioe);
		logger.debug("Validador: {} ", visitador);
		sqlSession.insert("encuestas.edomex2017.v2.registroUsuarios.insertarEncuestadores", visitador);
	 	sqlSession.insert("administracion.usuarios.insertar", usuario);
		sqlSession.insert("administracion.roles.insertarAutorizacionesPorUsuario", usuario);
		// nick, pw, habilitado, nombre, pkey, nivel, mail, celular
		
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"¡Registro Correcto!. Los datos de acceso se muestran a continuación, favor de conservelos en un lugar seguro.",
						"Ok"));
		return usuario;
	}

	public String clave() {
		String pass = "";
		char[] caracteres;
		caracteres = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H',  'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
				'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n',  'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' };
		for (int i = 0; i < 9; i++) {
			pass += caracteres[new Random().nextInt(62)];
		}
		return pass;
	}

	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
