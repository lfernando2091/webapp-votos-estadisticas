package com.saganet.politik.components.encuestas.edomex2017.foliosFaltantes;


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

@Component("Edomex2017FoliosFaltantesC")
public class FoliosFaltantesC {
	@Autowired
	SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(FoliosFaltantesC.class);

	
	public Modelo<FoliosFaltantesEO> listado (){
		HashMap<String, Object> parametros;
		VisitadorEO encuestador=new VisitadorEO();
		Modelo<FoliosFaltantesEO> modelo;
		List<FoliosFaltantesEO> listado;
		
		modelo = new Modelo<>();
		logger.debug("FOLIOS FALTANTES:{}", encuestador);
		parametros = new HashMap<>();
		logger.debug("nick encuestador : {}", getUsuario().getNick());
		encuestador=sqlSession.selectOne("estructurasEdoMex.visitador.buscarPorNick",getUsuario().getNick());
		logger.debug("ENCUESTADOR : {}", encuestador);
		parametros.put("programa", encuestador.getPrograma()) ;
		parametros.put("municipio", encuestador.getMunicipio().getIdMunicipio());
		listado = sqlSession.selectList("encuestas.edomex2017.foliosFaltantes.faltantesSegunda",parametros);	
		modelo.setListado(listado);
		return modelo; 
	}
	

	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

}
