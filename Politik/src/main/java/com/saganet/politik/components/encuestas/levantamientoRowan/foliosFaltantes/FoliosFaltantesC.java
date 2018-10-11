package com.saganet.politik.components.encuestas.levantamientoRowan.foliosFaltantes;



import java.util.HashMap;
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
import com.saganet.politik.database.estructurasEdoMex.VisitadorEO;
import com.saganet.politik.modelos.Modelo;

@Component("levantamientoRowanFoliosFaltantesC")
public class FoliosFaltantesC {
	@Autowired
	SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(FoliosFaltantesC.class);
	
	public Modelo<FoliosFaltantesEO> listado (){
		
		Modelo<FoliosFaltantesEO> modelo;
		List<FoliosFaltantesEO> listado;
		HashMap<String, Object> parametros;
		VisitadorEO encuestador=new VisitadorEO();
		modelo = new Modelo<>();
		parametros = new HashMap<>();
		encuestador=sqlSession.selectOne("levantamienntoRowan.foliosFaltantes.visitador.buscarPorNick",getUsuario().getNick());
		logger.debug("encuestador : {}", encuestador);
		parametros.put("municipio", encuestador.getMunicipio().getIdMunicipio());
		logger.debug("nick encuestador : {}", getUsuario().getNick());
		logger.debug("parametros : {}", parametros);
		listado = sqlSession.selectList("encuestas.levantamientoRowan.foliosFaltantes.faltantes", parametros);	
		modelo.setListado(listado);
		return modelo; 
	}
	

	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

}
