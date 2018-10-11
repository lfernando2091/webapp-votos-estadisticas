package com.saganet.politik.components.encuestas.fuerzaCiudadana.foliosFaltantes;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.encuestas.edomex2017.foliosFaltantes.FoliosFaltantesEO;
import com.saganet.politik.modelos.Modelo;

@Component("fuerzaCiudadanaFoliosFaltantesC")
public class FoliosFaltantesC {
	@Autowired
	SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(FoliosFaltantesC.class);
	
	public Modelo<FoliosFaltantesEO> listado (){
		
		Modelo<FoliosFaltantesEO> modelo;
		List<FoliosFaltantesEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("encuestas.fuerzaCiudadana.foliosFaltantes.faltantes");	
		modelo.setListado(listado);
		return modelo; 
	}
	

	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

}
