package com.saganet.politik.components.encuestas.admin;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.encuestas.admin.CampaniaEO;
import com.saganet.politik.database.encuestas.admin.CampaniaUsuarioEO;
import com.saganet.politik.modelos.Modelo;

@Component("CampaniasUsuariosC")
public class CampaniasUsuariosC {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(CampaniasUsuariosC.class);
	
	public Modelo<CampaniaUsuarioEO> modelo(CampaniaEO campania){
		
		logger.debug("CampaniaRecibida: {}", campania);
		
		Modelo<CampaniaUsuarioEO> modelo;
		List<CampaniaUsuarioEO> listado;
		
		listado = sqlSession.selectList("encuestas.admin.campaniasUsuarios.listado", campania);
		logger.debug("listadoCampaniasUsuarios: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("modeloCampaniasUsuarios: {}", modelo);
		
		return modelo;
		
	}
	
	public CampaniaUsuarioEO nuevo(CampaniaEO campania){
		CampaniaUsuarioEO nuevo;
		nuevo = new CampaniaUsuarioEO();
		
		nuevo.setIdCampania(campania.getId());
		
		return nuevo;
		
	}
	
	public void guardar(CampaniaUsuarioEO nuevo){
		
		logger.debug("CampaniaUsuarioRecibida: {}", nuevo);
		
		Integer validacion = 0;
		
		validacion = sqlSession.selectOne("encuestas.admin.campaniasUsuarios.insertarValidacion", nuevo);
		
		if(validacion == 0){
			sqlSession.insert("encuestas.admin.campaniasUsuarios.insertar", nuevo);
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lo sentimos, está asignación ya fue realizada anteriormente.", "Asignación fallida :("));
		}
		
		
	}
	
}
