package com.saganet.politik.components.administracion;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.administracion.RolEO;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.modelos.Modelo;

@Component("AdministracionRolesC")
public class RolesC {
	
	@Autowired 
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(RolesC.class);
	
	public Modelo<RolEO> modelo() {
		Modelo<RolEO> modelo;
		List<RolEO> listado;

		modelo = new Modelo<>();

		listado = sqlSession.selectList("administracion.roles.listado");
		if (!listado.isEmpty()) {
			modelo.setSeleccionado(listado.get(0));
		}
		modelo.setListado(listado);

		return modelo;
	}
	
	public Modelo<RolEO> modelo(UsuarioEO usuario) {
		Modelo<RolEO> modelo;
		List<RolEO> listado;

		modelo = new Modelo<>();

		listado = usuario.getRoles();
		if (!listado.isEmpty()) {
			modelo.setSeleccionado(listado.get(0));
		}
		modelo.setListado(listado);

		return modelo;
	}

	public void quitarRolDeModelo(Modelo<RolEO> modelo, RolEO rol) {
		if (!modelo.getListado().isEmpty()) {
			modelo.getListado().remove(rol);
			if (!modelo.getListado().isEmpty()) {
				modelo.setSeleccionado(modelo.getListado().get(0));
			} else {
				modelo.setSeleccionado(null);
			}
		}
	}
	
	public RolEO nuevo(){
		RolEO rol;
		
		rol = new RolEO();
		
		return rol;
	}
	
	public void insertarActualizar(RolEO rol){
		if(rol.getId() == null){
			rol.setRol(rol.getRol().toUpperCase());
			sqlSession.insert("administracion.roles.insertar", rol);
		}
	}
}
