package com.saganet.politik.components.diaD;

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
import com.saganet.politik.database.diaD.MovilizadorEO;
import com.saganet.politik.database.diaD.RegistroMovilizadorEO;
import com.saganet.politik.dominios.NivelesDO;


@Component("RegistroMovilizadoresC")
public class RegistroUsuarioMovilizadoresC {
	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(RegistroUsuarioMovilizadoresC.class);

	public MovilizadorEO nuevo(){
		MovilizadorEO nuevo;
		nuevo = new MovilizadorEO();
		return nuevo;
	}
	
	
	public String validarDatos(RequestContext context, MovilizadorEO movilizador) {
		logger.debug("Datos de entrada  : {}",movilizador);
		HashMap<String, Object> flowScope, parametros;
		RegistroMovilizadorEO registro;
		GeozonaParticionEO particion;
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		UsuarioEO us;
		parametros = new HashMap<>();
		
		logger.debug("Datos de CODIGO  : {}", parametros.put("codigo", movilizador.getCodigoAlfanumerico()));
		logger.debug("Datos de municipio  : {}", parametros.put("municipio", movilizador.getMunicipio().getIdMunicipio()));
		
		parametros.put("codigo", movilizador.getCodigoAlfanumerico());
		parametros.put("municipio", movilizador.getMunicipio().getIdMunicipio());
		registro=sqlSession.selectOne("diaD.registroUsuariosMovilizadores.validarCodigo",parametros);
		
		logger.debug("Registro : {}",registro);
		if(registro != null){
			particion = new GeozonaParticionEO();
			particion.setIdParticion(registro.getRegion());
			movilizador.setRegion(particion);
			movilizador.setPrograma(registro.getPrograma());
			logger.debug("movilizador a registrar: {}",movilizador);
			us = registrar(movilizador);
			flowScope.put("usuario", us);
			return "success";
		}else{
			FacesContext faceContext = FacesContext.getCurrentInstance();
			faceContext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se encontró información", "Contact admin."));
			return "error";
		}
	}

	
	public UsuarioEO registrar(MovilizadorEO movilizador) {
		UsuarioEO usuario;
		List<RolEO> listado;
		RolEO rol = new RolEO();
		usuario = new UsuarioEO();
		listado = new ArrayList<>();
		rol.setRol("ROLE_MOVILIZACION_ASIGNACION");
		listado.add(rol);
		rol = new RolEO();
		rol.setRol("ROLE_USER");
		listado.add(rol);
	
				
		usuario.setId((Integer)sqlSession.selectOne("diaD.capturaMovilizador.contadorMovilizadores"));
		usuario.setNick("mo_" + usuario.getId());
		usuario.setNombre(movilizador.getNombre() + " " + movilizador.getPrimerApellido() + " " + movilizador.getSegundoApellido());
		usuario.setCelular(movilizador.getTelefono());
		usuario.setMail(movilizador.getEmail());
		usuario.setPw(clave());
		usuario.setHabilitado(true);
		usuario.setNivel(NivelesDO.NACIONAL);
		usuario.setRoles(listado);
		
		
		movilizador.setNick(usuario.getNick());
		movilizador.setPw(usuario.getPw());
		logger.debug("Movilizador: {}", movilizador);
		
		sqlSession.insert("diaD.capturaMovilizador.insertarMovilizador", movilizador);
		sqlSession.insert("administracion.usuarios.insertar", usuario);
		sqlSession.insert("administracion.roles.insertarAutorizacionesPorUsuario", usuario);
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Registro Correcto!. Los datos de acceso se muestran a continuación, favor de conservelos en un lugar seguro.", "Ok"));
		return usuario;
	}

	public String clave() {
		String pass = "";
		char[] caracteres;
		caracteres = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'J', 'K', 'M', 'N',  'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for (int i = 0; i < 8; i++) {
			pass += caracteres[new Random().nextInt(32)];
		}
		return pass;
	}


}
