package com.saganet.politik.components.match;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.TablaEO;
import com.saganet.politik.database.match.MatchEO;
import com.saganet.politik.dominios.TiposMatchDO;
import com.saganet.politik.dominios.TiposObjetosDO;
import com.saganet.politik.modelos.Modelo;

@Component("MatchC")
public class MatchC {
	
	private static final Logger logger = LoggerFactory.getLogger(MatchC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<MatchEO> modelo(){
		Modelo<MatchEO> modelo;
		List<MatchEO> listado;
		
		listado = sqlSession.selectList("match.Match.listado");
		logger.debug("Listado de Match: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo de Match: {}", modelo);
		
		return modelo;
	}
	
	public MatchEO nuevo(TablaEO tabla){
		logger.debug("Tabla recibida: {}", tabla);
		MatchEO nuevo = new MatchEO();
		nuevo.setTabla(tabla);
		return nuevo;
	}
	
	public void guardar(MatchEO nuevo){
		logger.debug("MatchEO Recibido: {}", nuevo);
		sqlSession.insert("match.Match.insertar", nuevo);
		logger.debug("El objeto MatchEO se guardo correctamente");
	}
	
	public TiposMatchDO[] tiposMatch(){
		logger.debug("Se genera listado de Tipos Match");
		return TiposMatchDO.values();
	}
	
	public TiposObjetosDO[] tiposObjetos(){
		logger.debug("Se genera listado de Tipos Objetos");
		return TiposObjetosDO.values();
	}
}
