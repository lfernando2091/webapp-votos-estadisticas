package com.saganet.politik.components.catalogos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.database.catalogos.*;

@Component("CatalogosManzanasC")
public class ManzanasC {

	@Autowired
	SqlSession sqlSession;
	
	public Modelo<ManzanaEO> modelo(){
		Modelo<ManzanaEO> modelo;
		List<ManzanaEO> listado;
		modelo = new Modelo<>();
		listado = sqlSession.selectList("catalogos.manzanas.listado");
		modelo.setListado(listado);
		return modelo;
	}
	
	public Modelo<ManzanaEO> modelo(EntidadEO entidad){
		Modelo<ManzanaEO> modelo;
		List<ManzanaEO> listado;	
		modelo = new Modelo<>();
		listado = sqlSession.selectList("catalogos.manzanas.listadoFiltroEntidad", entidad.getLlave());
		modelo.setListado(listado);
		return modelo;
	}
	
	public Modelo<ManzanaEO> modelo(MunicipioEO municipio){
		Modelo<ManzanaEO> modelo;
		List<ManzanaEO> listado;	
		modelo = new Modelo<>();
		listado = sqlSession.selectList("catalogos.manzanas.listadoFiltroMunicipio", municipio.getLlave());
		modelo.setListado(listado);
		return modelo;
	}
	
	public Modelo<ManzanaEO> modelo(SeccionEO seccion){
		Modelo<ManzanaEO> modelo;
		List<ManzanaEO> listado;	
		modelo = new Modelo<>();
		listado = sqlSession.selectList("catalogos.manzanas.listadoFiltroSeccion", seccion.getLlave());
		modelo.setListado(listado);
		return modelo;
	}

	public ManzanaEO buscarPorLlave(String llave){
		ManzanaEO manzana;
		manzana = sqlSession.selectOne("catalogos.manzanas.buscarPorLlave", llave);
		return manzana;
	}
}
