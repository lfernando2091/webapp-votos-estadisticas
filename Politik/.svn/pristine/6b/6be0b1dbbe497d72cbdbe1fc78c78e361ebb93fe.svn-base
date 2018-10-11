package com.saganet.politik.components.catalogos;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.ComisionCongresoUnionEO;
import com.saganet.politik.modelos.Modelo;

@Component("CatalogosComisionesCongresoUnionC")
public class ComisionesCongresoUnionC {
	
	@Autowired SqlSession sqlSession;
	
	public Modelo<ComisionCongresoUnionEO> modelo(){
		Modelo<ComisionCongresoUnionEO> modelo;
		List<ComisionCongresoUnionEO> listado;

		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.comisionesCongresoUnion.listado");
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<ComisionCongresoUnionEO> modelo(boolean diputados, boolean senadores){
		Modelo<ComisionCongresoUnionEO> modelo;
		List<ComisionCongresoUnionEO> listado;
		HashMap<String, Object> parametros;

		modelo = new Modelo<>();
		parametros = new HashMap<>();
		
		parametros.put("diputados", diputados);
		parametros.put("senadores", senadores);
		listado = sqlSession.selectList("catalogos.comisionesCongresoUnion.listado", parametros);
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public ComisionCongresoUnionEO porId(Integer idComision){
		ComisionCongresoUnionEO comision;
		
		comision = sqlSession.selectOne("catalogos.comisionesCongresoUnion.porId", idComision);
		
		return comision;
	}
}
