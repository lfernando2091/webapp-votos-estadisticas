package com.saganet.politik.components.eventos;

import java.util.ArrayList;
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
import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.catalogos.ProgramaEO;
import com.saganet.politik.database.catalogos.ProgramaEjercicioEO;
import com.saganet.politik.database.eventos.EventoEjercicioProgramaEO;
import com.saganet.politik.database.eventos.EventoSocialEO;
import com.saganet.politik.modelos.Modelo;

@Component("EventosProgramasC")
public class EventosProgramasC {
	private static final Logger logger = LoggerFactory.getLogger(EventosProgramasC.class);

	@Autowired
	SqlSession sqlSession;

	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
	public Modelo<EventoEjercicioProgramaEO> tabla(EventoSocialEO eventoSocial) {
		Modelo<EventoEjercicioProgramaEO> tabla =new Modelo<>();
		List<EventoEjercicioProgramaEO> listado=new ArrayList<>();
		listado=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial);
		logger.debug("El listado {}",listado);
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}
	

	public Modelo<ProgramaEO> modeloDependencia(DependenciaEO dependencia){
		Modelo<ProgramaEO> modelo;
		List<ProgramaEO> listado;

		logger.debug("Listado dependencia: {}", dependencia);
		listado = sqlSession.selectList("catalogos.programas.listadoPorDependencia",dependencia);
		logger.debug("Listado Programas: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo Programas: {}", modelo);
		
		return modelo;
	}
	
	
	public Modelo<DependenciaEO> modelo(){
		Modelo<DependenciaEO> modelo= new Modelo<>();
		List<DependenciaEO> listado= new ArrayList<>();
//		List<DependenciaEO> listadoAux= new ArrayList<>();
//		HashMap<String, Object> params= new HashMap<>();
//		if(!getUsuario().getDependencias().isEmpty()){
//			params.put("dependencias", getUsuario().getDependencias());
//			listado = sqlSession.selectList("catalogos.dependencias.listadoUsuarioDependencias",params);
//		}
//		List<DependenciaEO> depenedenciasUsuario=getUsuario().getDependencias();
		
		//listado = sqlSession.selectList("catalogos.dependencias.listado");
		//Se_genera_listado_de_arbol_de_dependecias_por_usuario--------------------------------------
		if(!getUsuario().getDependencias().isEmpty()){
			HashMap<String, Object> params;
			params = new HashMap<>();
			params.put("dependencias", getUsuario().getDependencias());
			listado = sqlSession.selectList("catalogos.dependencias.listadoUsuarioDependencias", params);
		}else{
			listado = sqlSession.selectList("catalogos.dependencias.listado");
		}
		
		//---------------------------------------------------------------------------------------------
		
//		listadoAux.addAll(listado);
//		for (DependenciaEO dependencia : listadoAux) {
//			boolean band=false;
//			for (DependenciaEO depenedenciaUsuario : depenedenciasUsuario) {
//				logger.debug("La dependencia {} , la dependencia del usuario es {} y entre ellas {}",dependencia.getId(), depenedenciaUsuario.getId(), dependencia.hijoDe(depenedenciaUsuario));
//				if (dependencia.hijoDe(depenedenciaUsuario)) {
//					band=true;
//				}
//			}
//			if (!band) {
//				logger.debug("Se borra la dependencia con id {}",dependencia.getId());
//				listado.remove(dependencia);
//			}
//			else{
//				logger.debug("La bandera es {}",band);
//			}
//		}
		
		logger.debug("ListadoDependecias: {}", listado);
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		return modelo;
	}
	

	public Modelo<ProgramaEjercicioEO> modeloEjercicios(ProgramaEO programa){
		Modelo<ProgramaEjercicioEO> modelo;
		List<ProgramaEjercicioEO> listado;
		
		listado = sqlSession.selectList("catalogos.programasEjercicios.listadoByIdPrograma", programa);
		logger.debug("listado ProgramasEjercicios: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo ProgramasEjercicios: {}",modelo);
		
		return modelo;
	}
	
	public EventoEjercicioProgramaEO crearEventoEjercicioProgramma(EventoSocialEO evento){
		EventoEjercicioProgramaEO nuevo=new EventoEjercicioProgramaEO();
		nuevo.setEventoSocial(evento);
		return nuevo;
	}
	
	
	public void guardarEventoEjercicioProgramma(EventoEjercicioProgramaEO evento){
		logger.debug("EventoEjercicioProgramaEO es {}",evento);
		sqlSession.insert("eventos.eventosEjercicioPrograma.agregarEjercicioPrograma",evento);
	}
	
	public void eliminarEventoEjercicioProgramma(EventoEjercicioProgramaEO evento){
		sqlSession.delete("eventos.eventosEjercicioPrograma.eliminar",evento);
	}
}
