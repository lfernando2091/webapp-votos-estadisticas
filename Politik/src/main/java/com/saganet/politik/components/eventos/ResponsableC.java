package com.saganet.politik.components.eventos;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.saganet.politik.database.eventos.EventoSocialEO;
import com.saganet.politik.database.eventos.ResponsableEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.Modelo;

@Component("ResponsableC")
public class ResponsableC {
	private static final Logger logger = LoggerFactory.getLogger(ResponsableC.class);

	@Autowired
	SqlSession sqlSession;
	
	public Modelo<ResponsableEO> tablaResponsable(EventoSocialEO evento ,ResponsableEO responsableseleccionado) {
		Modelo<ResponsableEO> tabla =new Modelo<>();
		List<ResponsableEO> listado=new ArrayList<>();
		listado=sqlSession.selectList("eventos.responsables.buscarPorEvento",evento.getId());
		logger.debug("El listado es {}",listado);
		tabla.setListado(listado);
		if (responsableseleccionado!=null) {
			tabla.setSeleccionado(responsableseleccionado);
		}
		else if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}
	
	public ResponsableEO crearResponsableEvento(EventoSocialEO evento, PersonaEO persona) {
		ResponsableEO responsableEvento = new ResponsableEO();
		responsableEvento.setEvento(evento);
		responsableEvento.setPersona(persona);
		return responsableEvento;
	}
	public ResponsableEO nuevoResponsableEvento (ResponsableEO responsableEvento) {
		logger.debug("El Responsable del Evento recibido es {}", responsableEvento);
		Integer id=sqlSession.selectOne("eventos.responsables.nuevoID");
		responsableEvento.setId(id);
		sqlSession.insert("eventos.responsables.agregar",responsableEvento);
		return responsableEvento;
	}
	
	public void eliminarResponsableEvento(ResponsableEO responsableEvento) {
		logger.debug("Responsable Evento {}",responsableEvento);
		if (responsableEvento!=null) {
			sqlSession.delete("eventos.responsables.eliminar",responsableEvento);
		}
	}
}
