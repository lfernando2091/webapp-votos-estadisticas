package com.saganet.politik.components.encuestas.levantamientoRowan;

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
import com.saganet.politik.database.encuestas.levantamientoRowan.EntrevistadorEO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;

@Component("LevantamientoRowanRegistroUsuarioC")
public class RegistroUsuarioC {
	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(RegistroUsuarioC.class);

	public EntrevistadorEO nuevo(){
		EntrevistadorEO nuevo;
		nuevo = new EntrevistadorEO();
		return nuevo;
	}
	
	
	public String validarDatos(RequestContext context, EntrevistadorEO visitador) {
		HashMap<String, Object> mapa, viewScope;
		UsuarioEO us;
		Integer filas;

		filas = 0;
		mapa = new HashMap<>();
		viewScope = (HashMap<String, Object>) context.getFlowScope().asMap();

		us = new UsuarioEO();
		mapa.put("clave", visitador.getClave());
		mapa.put("municipio", visitador.getMunicipio().getIdMunicipio());
		filas = sqlSession.selectOne("encuestas.levantamientoRowan.registroUsuarios.validarCodigo", mapa);
		if (filas == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontró información", "Error"));
			return "error";
		} else {
			us = registrar(visitador);
			viewScope.put("usuario", us);
			return "success";
		}

	}

	public UsuarioEO registrar(EntrevistadorEO visitador) {
		HashMap<String, Object>  valorRegistro, mapa;
		UsuarioEO usuario;
		
		MunicipioEO municipioe;
		List<RolEO> listado;
		RolEO rol;
		
		municipioe = new MunicipioEO();
		//mapa = new HashMap<>();
		usuario = new UsuarioEO();
		listado = new ArrayList<>();
		mapa = new HashMap<>();
		
		// registrar en tabla de encuestador
		logger.debug("antes Valor registro : {}", usuario);
		valorRegistro =  sqlSession.selectOne("encuestas.levantamientoRowan.registroUsuarios.datosCodigo", visitador.getClave());
		logger.debug("despues Valor registro : {}", valorRegistro);
			visitador.setPrograma(valorRegistro.get("programa").toString());
		////informacion del usuario
		
		rol = new RolEO();
		rol.setRol("ROLE_DIA_D_JORNADA");
		listado.add(rol);
		
		rol = new RolEO();
		rol.setRol("ROLE_USER");
		listado.add(rol);
		
		rol = new RolEO();
		rol.setRol("ROLE_MOVILIZACION_CAPTURISTA");
		listado.add(rol);
		
		rol = new RolEO();
		rol.setRol("ROLE_MOSTRAR_MENU");
		listado.add(rol);
		
		
		// crear usuario
		usuario.setNick("lw_" + sqlSession.selectOne("encuestas.levantamientoRowan.registroUsuarios.conteoUsuario"));
		usuario.setNombre(visitador.getNombre() + " " + visitador.getPrimerApellido() + " " + visitador.getSegundoApellido());
		usuario.setCelular(visitador.getMovil());
		usuario.setMail(visitador.getEmail());
		usuario.setPw(clave());
		usuario.setHabilitado(true);
		usuario.setNivel(NivelesDO.MUNICIPIO);
		usuario.setRoles(listado);
		//// fin de la informacion del usuario
        visitador.setNick(usuario.getNick());
        visitador.setPw(usuario.getPw());
		visitador.setUsuario(usuario);
		visitador.setIdRegion(Integer.parseInt(valorRegistro.get("region").toString()));
		municipioe.setIdMunicipio(visitador.getMunicipio().getIdMunicipio());
		visitador.setMunicipio(municipioe);
		mapa.put("nick", usuario.getNick());
		mapa.put("llave","15-"+visitador.getMunicipio().getIdMunicipio());
		logger.debug("Validador: {} ", visitador);
		logger.debug("Usuario: {} ", usuario);
		sqlSession.insert("encuestas.levantamientoRowan.registroUsuarios.insertarEncuestadores", visitador);
	 	sqlSession.insert("administracion.usuarios.insertar", usuario);
		sqlSession.insert("administracion.roles.insertarAutorizacionesPorUsuario", usuario);
		sqlSession.insert("encuestas.levantamientoRowan.registroUsuarios.insertarPrograma", visitador);
		
		sqlSession.insert("administracion.usuarios.insertarLlave",mapa);
		
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
				'H',  'J', 'K',  'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
				'c', 'd', 'e', 'f', 'g', 'h',  'j', 'k', 'm', 'n',  'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' };
		for (int i = 0; i < 9; i++) {
			pass += caracteres[new Random().nextInt(55)];
		}
		return pass;
	}

	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
