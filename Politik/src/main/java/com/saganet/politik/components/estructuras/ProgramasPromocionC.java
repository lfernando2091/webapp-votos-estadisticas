package com.saganet.politik.components.estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.EleccionEO;
import com.saganet.politik.database.estructuras.EstructuraEO;
import com.saganet.politik.database.estructuras.ProgramaPromocionEO;
import com.saganet.politik.dominios.AmbitosDO;
import com.saganet.politik.modelos.Modelo;

@Component("EstructurasProgramasPromocionC")
public class ProgramasPromocionC {
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<ProgramaPromocionEO> modelo(){
		Modelo<ProgramaPromocionEO> modelo;
		List<ProgramaPromocionEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("estructuras.programasPromocion.listado");
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<ProgramaPromocionEO> modelo(List<ProgramaPromocionEO> listado){
		Modelo<ProgramaPromocionEO> modelo;
		
		modelo = new Modelo<>();
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<ProgramaPromocionEO> modelo(HashMap<String, Object> mapaCaptura){
		Modelo<ProgramaPromocionEO> modelo;
		EstructuraEO estructura;
		EleccionEO eleccion;
		List<ProgramaPromocionEO> listado;
		
		modelo = new Modelo<>();
		
		estructura = (EstructuraEO) mapaCaptura.get("estructura");
		
		if(estructura.getAmbito().equals(AmbitosDO.ELECCION)){
			eleccion = (EleccionEO) mapaCaptura.get("eleccion");
			listado = eleccion.getProgramasPromocion();
		} else {
			listado = new ArrayList<>();
		}
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public ProgramaPromocionEO nuevoPrograma(){
		ProgramaPromocionEO programa;
		
		programa = new ProgramaPromocionEO();
		
		return programa;
	}
	
	public void guardar(ProgramaPromocionEO programaCRUD){
		if(programaCRUD.getId() == null){
			sqlSession.insert("estructuras.programasPromocion.insertar", programaCRUD);
		} else {
			sqlSession.insert("estructuras.programasPromocion.actualizar", programaCRUD);
		}
	}
}
