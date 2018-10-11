package com.saganet.politik.component_dm.sincronizacion;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database_dm.sincronizacion.PrecargaEO;
import com.saganet.politik.modelos.Modelo;

@Component("PrecargaC")
public class PrecargaC {
	
	@Autowired
	SqlSession sqlSessionDM;
	
	private static final Logger logger = LoggerFactory.getLogger(PrecargaC.class);
	
	public Modelo<PrecargaEO> modelo(){
		Modelo<PrecargaEO> modelo;
		List<PrecargaEO> listado;
		
		listado = sqlSessionDM.selectList("sincronizacion.precarga.listado");
		logger.debug("Listado Precarga: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo Precarga: {}", modelo);
		
		return modelo;
	}
	
	public PrecargaEO nuevo(){
		return new PrecargaEO();
	}
	
	public PrecargaEO guardar(PrecargaEO nuevo){
		logger.debug("La precarga recibida es: {}", nuevo);
		try{
			sqlSessionDM.insert("sincronizacion.precarga.insertar");
			logger.debug("La precarga se guardo correctamente.");
			return nuevo;
		}catch(Exception ex){
			logger.debug("La precarga no se guardo correctamente: {}", ex);
			return null;
		}
	}
	
	public Boolean actualizar(PrecargaEO precarga){
		logger.debug("La precarga recibida es: {}", precarga);
		try{
			sqlSessionDM.update("sincronizacion.precarga.actualizar");
			logger.debug("La precarga se actualizo correctamente.");
			return true;
		}catch(Exception ex){
			logger.debug("La precarga no se actualizo correctamente: {}", ex);
			return false;
		}
	}
	
	public Boolean enlazarPrecargaUsuario(PrecargaEO precarga, UsuarioEO usuario){
		logger.debug("Precargar recibida: {}", precarga);
		logger.debug("Usuario recibido: {}", usuario);
		HashMap<String, Object> params;
		params = new HashMap<>();
		params.put("precarga", precarga);
		params.put("usuario", usuario);
		try{
			sqlSessionDM.insert("sincronizacion.precarga.insertarPrecargaUsuario", params);
			logger.debug("La precarga y usuario se enlazaron correctamente");
			return true;
		}catch(Exception ex){
			logger.debug("La precarga y usuario no se enlazaron correctamente: {}", ex);
			return false;
		}
	}
	
	public Boolean actualizarPrecargaUsuario(PrecargaEO precarga, UsuarioEO usuario){
		logger.debug("Precargar recibida: {}", precarga);
		logger.debug("Usuario recibido: {}", usuario);
		HashMap<String, Object> params;
		params = new HashMap<>();
		params.put("precarga", precarga);
		params.put("usuario", usuario);
		try{
			sqlSessionDM.update("sincronizacion.precarga.actualizarPrecargaUsuario", params);
			logger.debug("El enlace de la precarga y usuario se actualizo correctamente");
			return true;
		}catch(Exception ex){
			logger.debug("El enlace de la precarga y usuario no se actualizo correctamente");
			return false;
		}
	}
	
}
