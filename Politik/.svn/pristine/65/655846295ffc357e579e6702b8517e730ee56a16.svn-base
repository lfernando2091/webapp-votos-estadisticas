package com.saganet.politik.components.encuestas.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.encuestas.admin.TablaContactoEO;
import com.saganet.politik.modelos.Modelo;

@Component("TablasContactosC")
public class TablasContactosC {
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<TablaContactoEO> modelo(){
		Modelo<TablaContactoEO> modelo;
		List<TablaContactoEO> listado;
		
		modelo = new Modelo<>();
		listado = sqlSession.selectList("encuestas.admin.tablasContactos.listado");
		
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
}
