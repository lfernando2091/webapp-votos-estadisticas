package com.saganet.politik.components.eventos;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.saganet.politik.database.eventos.EventoSocialEO;
import com.saganet.politik.database.eventos.PresidiumEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.Modelo;

@Component("PresidiumC")
public class PresidiumC {
	private static final Logger logger = LoggerFactory.getLogger(PresidiumC.class);

	@Autowired
	SqlSession sqlSession;
	
	
	public Modelo<PresidiumEO> tablaPresidium(EventoSocialEO evento ,PresidiumEO presidiumSeleccionado) {
		Modelo<PresidiumEO> tabla =new Modelo<>();
		List<PresidiumEO> listado=new ArrayList<>();

		listado=sqlSession.selectList("eventos.presidium.buscarPorEvento",evento.getId());
		logger.debug("El listado es {}",listado);

		tabla.setListado(listado);
		if (presidiumSeleccionado!=null) {
			tabla.setSeleccionado(presidiumSeleccionado);
		}
		else if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}
	
	public PresidiumEO crearMiembroPresidium(EventoSocialEO evento, PersonaEO persona) {
		PresidiumEO miembroPresidium = new PresidiumEO();
		miembroPresidium.setEvento(evento);
		miembroPresidium.setPersona(persona);
		return miembroPresidium;
	}
	public PresidiumEO nuevoMiembroPresidium (PresidiumEO miembroPresidium) {
		logger.debug("El miembro del Presidium recibido es {}",miembroPresidium);
		Integer id=sqlSession.selectOne("eventos.presidium.nuevoID");
		miembroPresidium.setId(id);
		sqlSession.insert("eventos.presidium.agregar",miembroPresidium);
		return miembroPresidium;
	}
	
	public void eliminarMiembroPresidium(PresidiumEO miembroPresidium) {
		logger.debug("Miembro del Presidium {}",miembroPresidium);
		if (miembroPresidium!=null) {
			sqlSession.delete("eventos.presidium.eliminar",miembroPresidium);
		}
	}
}
