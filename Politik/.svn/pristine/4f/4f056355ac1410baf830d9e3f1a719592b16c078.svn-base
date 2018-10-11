package com.saganet.politik.component_dm.sincronizacion;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database_dm.sincronizacion.UsuarioEO;
import com.saganet.politik.dominios_dm.EmpresaDO;
import com.saganet.politik.dominios_dm.EstatusUsuarioDO;
import com.saganet.politik.dominios_dm.RegionesDO;
import com.saganet.politik.modelos.Modelo;

@Component("UsuarioC")
public class UsuarioC {
	
	@Autowired
	SqlSession sqlSessionDM;
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioC.class);
	
	public Modelo<UsuarioEO> modelo(){
		Modelo<UsuarioEO> modelo;
		List<UsuarioEO> listado;
		listado = sqlSessionDM.selectList("sincronizacion.usuario.listado");
		logger.debug("Listado Usuario: {}", listado);
		modelo = new Modelo<>();
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo Usuario: {}", modelo);		
		return modelo;
	}
	
	public EmpresaDO[] empresa(){
		return EmpresaDO.values();
	}
	
	public RegionesDO[] listadoRegiones(){
		return RegionesDO.values();
	}
	
	public EstatusUsuarioDO[] listadoEstatus(){
		return EstatusUsuarioDO.values();
	}
	
	public UsuarioEO crearUsuario(){
		UsuarioEO usuario= new UsuarioEO();
		usuario.setEmpresa(EmpresaDO.SAGA);
		logger.debug("Usuario cargado {}", usuario);
		return usuario;
	}
	
	public void agregarUsuario(UsuarioEO usuario){
		usuario.setNombre(usuario.getNombre().toUpperCase());
		usuario.setPrimerApellido(usuario.getPrimerApellido().toUpperCase());
		usuario.setSegundoApellido(usuario.getSegundoApellido().toUpperCase());
		logger.debug("Usuario a guradar es {}", usuario);
		sqlSessionDM.insert("sincronizacion.usuario.insertar", usuario);
		logger.debug("Cargo a guradar es {}", usuario);
		//return usuario;
	}
	
	public void editarUsuario(UsuarioEO usuario){
		usuario.setNombre(usuario.getNombre().toUpperCase());
		usuario.setPrimerApellido(usuario.getPrimerApellido().toUpperCase());
		usuario.setSegundoApellido(usuario.getSegundoApellido().toUpperCase());
		logger.debug("Usuario a actualizar es {}", usuario);
		sqlSessionDM.insert("sincronizacion.usuario.actualizarUsuario", usuario);
	}
	
	public void eliminiarUsuario(UsuarioEO usuario){
		logger.debug("Usuario a Eliminar es {}", usuario);	
		//sqlSession.
		sqlSessionDM.delete("sincronizacion.usuario.eliminar", usuario);
		
	}
	
}
