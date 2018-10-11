package com.saganet.politik.components.diaD;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.components.catalogos.EntidadesC;
import com.saganet.politik.components.catalogos.MunicipiosC;
import com.saganet.politik.components.catalogos.SeccionesC;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.database.diaD.SeccionalEO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.Modelo;

@Component("CatalogoSeccionalC")
public class SeccionalC {
	private static final Logger logger = LoggerFactory.getLogger(SeccionalC.class);

	@Autowired SqlSession sqlSession;
	@Autowired EntidadesC entidadesC;
	@Autowired MunicipiosC municipiosC;
	@Autowired SeccionesC seccionesC;
	public Modelo<SeccionalEO> modelo(ProgramasEdoMexDO programa){
		HashMap<String, Object> mapa;
		Modelo<SeccionalEO> modelo;
		List<SeccionalEO> listado;
		mapa=  new HashMap<>();
		mapa.put("programa", programa);
		listado = sqlSession.selectList("diaD.seccional.listado", mapa);
		modelo = new Modelo<>(listado);
		logger.debug("Modelo: {}",modelo.getListado());
		return modelo;
	}
	
	public Modelo<SeccionalEO> modelo(SeccionalEO obj) {
		Modelo<SeccionalEO> nuevoModelo;
		List<SeccionalEO> listado;		
		listado=sqlSession.selectList("diaD.seccional.listado");
		nuevoModelo=new Modelo<>(listado);
		logger.debug("Listado {}", nuevoModelo);
		if (obj!=null) nuevoModelo.setSeleccionado(obj);
		return nuevoModelo;
	}
	
	
	public SeccionalEO nuevo(){
		SeccionalEO seccional= new SeccionalEO();
		//System.out.println(seccional.toString());
			seccional.setPrograma(getUsuario().getProgamas().get(0));
		logger.debug("seccional: {}", seccional);
		return seccional;
	}
	
	public SeccionalEO guardar(SeccionalEO obj) {
		if(obj.getId()==null)sqlSession.insert("diaD.seccional.insertar",obj);
		else sqlSession.update("diaD.seccional.actualizar",obj);
		return obj;
	}
	
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
