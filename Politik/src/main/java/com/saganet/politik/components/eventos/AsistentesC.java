package com.saganet.politik.components.eventos;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.dominios.PosturaDO;
import com.saganet.politik.database.eventos.AsistenteEO;
import com.saganet.politik.database.eventos.EventoSocialEO;
import com.saganet.politik.database.eventos.IntervencionEO;
import com.saganet.politik.database.eventos.MencionEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.Modelo;


@Component("AsistentesC")
public class AsistentesC {
	private static final Logger logger = LoggerFactory.getLogger(AsistentesC.class);

	@Autowired
	SqlSession sqlSession;
//listado	
	public Modelo <AsistenteEO> tablaAsistentes(EventoSocialEO evento , AsistenteEO asistente){
	    	Modelo<AsistenteEO> tabla=new Modelo<>();
	    	List<AsistenteEO> listado = new ArrayList<>();
	    	
	    	listado=sqlSession.selectList("eventos.asistentes.listadoPorEvento", evento.getId());
	    	tabla.setListado(listado);
	    	logger.debug("El listado es {}",listado);
	    	if (asistente!=null) {
				tabla.setSeleccionado(asistente);
			}
	    	else if(!listado.isEmpty()){
	    		tabla.setSeleccionado(listado.get(0));
	    	}
	
	return tabla;
	}
	
	public AsistenteEO crearAsistente(EventoSocialEO evento, PersonaEO persona){
		logger.debug("evento a guardar ess {}",evento);
		logger.debug("persa a guardar es {}",persona);
			AsistenteEO asistente= new AsistenteEO();
			asistente.setEvento(evento);
			asistente.setPersona(persona);
			return asistente;			
	}	
	
	public void nuevoAsistente(AsistenteEO asistente) {
		logger.debug("asistente a guardar ess {}",asistente);
			sqlSession.insert("eventos.asistentes.insertar", asistente);	
	}

	public void eliminarAsistente(AsistenteEO asistente) {
		if(asistente!=null){
					sqlSession.delete("eventos.asistentes.eliminar", asistente);
					sqlSession.delete("eventos.intervenciones.eliminarAsistenteEO", asistente);
					sqlSession.delete("eventos.menciones.eliminarAsistenteEO", asistente);
		}
	}
	
	public Modelo<IntervencionEO> tablaIntervenciones(AsistenteEO asistente, IntervencionEO intervencion) {
		logger.debug("asistente es {}",asistente);
		Modelo<IntervencionEO> tabla=new Modelo<>();
		List<IntervencionEO> listado=new ArrayList<>();
		listado=sqlSession.selectList("eventos.intervenciones.listadoPorAsistente", asistente);
		tabla.setListado(listado);
		if (intervencion!=null) {
			tabla.setSeleccionado(intervencion);
		}else if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}		
		return tabla;
	}

	public IntervencionEO crearIntervencion(AsistenteEO asistente){
		logger.debug("nuevoIntervencion el asistente es {}",asistente);
		IntervencionEO intervencion= new IntervencionEO();
		intervencion.setAsistente(asistente);
		return intervencion;
	}
	
	public IntervencionEO nuevoIntervencion(IntervencionEO intervencion) {
		logger.debug("Intervencion a guradar es {}",intervencion);
		Integer id=sqlSession.selectOne("eventos.intervenciones.nextID");
		intervencion.setId(id);
		sqlSession.insert("eventos.intervenciones.insertar",intervencion);	
		return intervencion;
	}
	
	
	public Modelo<MencionEO> tablaMenciones(IntervencionEO intervencion, MencionEO mencion) {
		logger.debug("Intervencion {}",intervencion);
		Modelo<MencionEO> tabla=new Modelo<>();
		List<MencionEO> listado=new ArrayList<>();
		listado=sqlSession.selectList("eventos.menciones.listadoPorIntervencion", intervencion);
		tabla.setListado(listado);
		if (mencion!=null) {
			tabla.setSeleccionado(mencion);
		}
		else if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}		
		return tabla;
	}
	
	public MencionEO crearMencion(IntervencionEO intervencion){
		MencionEO mencion= new MencionEO();
		mencion.setIntervencion(intervencion);
		return mencion;
	}
	
	public MencionEO nuevoMencion(MencionEO mencion) {
		logger.debug("Intervencion a guradar es {}",mencion);
		Integer id=sqlSession.selectOne("eventos.menciones.nextID");
		mencion.setId(id);
		sqlSession.insert("eventos.menciones.insertar",mencion);
		return mencion;
	}
	

	public PosturaDO[] listadoPosturas(){
		logger.debug("Se genera listado de listadoPosturas");
		return PosturaDO.values();
	}
	
	public void eliminarIntervenciones (IntervencionEO intervencion){
		sqlSession.delete("eventos.menciones.eliminarIntervencion", intervencion);
		sqlSession.delete("eventos.intervenciones.eliminar", intervencion);
		
	}
	
	public void eliminarMenciones (MencionEO mencion){
		sqlSession.delete("eventos.menciones.eliminar", mencion);
	}
	
}
