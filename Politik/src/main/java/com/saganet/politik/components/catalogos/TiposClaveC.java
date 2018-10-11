package com.saganet.politik.components.catalogos;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.TipoClaveEO;
import com.saganet.politik.modelos.catalogos.TiposClaveT;


@Component("CatalogosTiposClaveC")
public class TiposClaveC {
	@Autowired
	SqlSession sqlSession;
	
	public TiposClaveT tabla(){
		TiposClaveT tabla;
		List<TipoClaveEO> listado;
		
		tabla = new TiposClaveT();
		
		listado = sqlSession.selectList("catalogos.tiposClave.listado");
		if(!listado.isEmpty())
			tabla.setSeleccionado(listado.get(0));
		tabla.setListado(listado);
		
		return tabla;
	}
}
