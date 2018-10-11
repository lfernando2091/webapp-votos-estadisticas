package com.saganet.politik.components.warehouse;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.TipoTelefonoEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.database.warehouse.TelefonoEO;
import com.saganet.politik.modelos.warehouse.TelefonosT;

@Component("WarehouseTelefonosC")
public class TelefonosC {

	@Autowired
	private SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(TelefonosC.class);

	public TelefonosT tabla(PersonaEO persona) {
		TelefonosT tabla;
		List<TelefonoEO> listado;
        
		tabla = new TelefonosT();
		logger.debug("Id Persona recibida {}", persona.getId());
		
		try{
			listado = sqlSession.selectList("warehouse.telefonos.listado", persona.getId());
			logger.debug("telefonos {}", listado.size());
			tabla.setListado(listado);
			if (!listado.isEmpty()) {
				tabla.setSeleccionado(listado.get(0));
			}
		}catch(Exception ex){
			logger.debug("Error al consultar lista de teléfonos: {}", ex.toString());
		}

		return tabla;
	}
	public TelefonoEO nuevo(){
		TelefonoEO telefono;
		TipoTelefonoEO tipo;
		
		telefono = new TelefonoEO();
		tipo = new TipoTelefonoEO();
		tipo.setId(3);
		tipo.setNombre("Celular");
		telefono.setTipo(tipo);
		
		return telefono;
	}
	
	public void insertar(TelefonoEO telefono, PersonaEO persona){
		HashMap<String, Object> parametros;
		
		parametros = new HashMap<>();
		parametros.put("telefono", telefono);
		parametros.put("persona", persona);
		
		sqlSession.insert("warehouse.telefonos.insertar", parametros);
		
		persona.getTelefonos().add(telefono);
	}
}
