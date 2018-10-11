package com.saganet.politik.components.eventos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.components.administracion.UsuariosC;
import com.saganet.politik.components.catalogos.GeozonasC;
import com.saganet.politik.components.log.BitacorasC;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.DLocalEO;
import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.GeozonaEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.LocalidadEO;
import com.saganet.politik.database.catalogos.ManzanaEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.database.eventos.CalendarioEventoSocialEO;
import com.saganet.politik.database.eventos.EventoEjercicioProgramaEO;
import com.saganet.politik.database.eventos.EventoSocialEO;
import com.saganet.politik.dominios.EstatusEventoDO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.TipoEventoDO;
import com.saganet.politik.dominios.TiposAccionesDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.utilidades.eventos.FiltrosMapa;

@Component("EventosSocialesC")
public class EventosSocialesC {
	private static final Logger logger = LoggerFactory.getLogger(EventosSocialesC.class);

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	GeozonasC geozonaC;
	
	@Autowired
	BitacorasC bitacorasC;
	
	@Autowired
	UsuariosC usuariosC;

	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
//	public Modelo<EventoSocialEO> tablaEventosSociales(EventoSocialEO eventoSeleccionado) {
//		Modelo<EventoSocialEO> tabla = new Modelo<>();
//		List<EventoSocialEO> listado = new ArrayList<>();
//		List<EventoSocialEO> listadoAux = new ArrayList<>();
//		List<JavaBeanT> territorios = new ArrayList<>();
//
//		////////////////////////////////////////////////////////////////////////////
//		logger.debug("EL usuario es {} y su dependencia es {}",getUsuario(),getUsuario().getDependencias());
//		List<DependenciaEO> dependenciasUsuarios = getUsuario().getDependencias();
//		listado = sqlSession.selectList("eventos.eventos.listado");
//		listadoAux.addAll(listado);
//		
//
//		
//		for (EventoSocialEO eventoSocial2 : listado) {	
//			List<DependenciaEO> listadoDependencias = new ArrayList<>();
//			List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
//			listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial2);
//			for (EventoEjercicioProgramaEO eventoEjercicioProgramaEO : listadoEventosProgramas) {
//				boolean ban=true;
//				for (DependenciaEO dependencia : listadoDependencias) {
//					if (dependencia.equals(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia())){
//						ban=false;
//					}
//				}
//				if (ban) {
//					listadoDependencias.add(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia());
//				}
//			}
//			eventoSocial2.setDependencias(listadoDependencias);
//			logger.debug("Del evento {} las dependencias son {}",eventoSocial2.getNombre(),listadoDependencias);
//			Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas =new Modelo<>();
//			tablaEjerciciosProgramas.setListado(listadoEventosProgramas);
//			if (!listadoEventosProgramas.isEmpty()) {
//				tablaEjerciciosProgramas.setSeleccionado(listadoEventosProgramas.get(0));
//			}
//			eventoSocial2.setTablaEjerciciosProgramas(tablaEjerciciosProgramas);
//			
//			
//		}
//		for (EventoSocialEO eventoSocial : listadoAux) {
//			boolean bandUsuario=false;
//			boolean bandDependencias=true;
//			logger.debug("Las dependenciasUsuarios son: {}",dependenciasUsuarios);
//			if (dependenciasUsuarios!=null && !dependenciasUsuarios.isEmpty()) {
//				List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
//				listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial);
//				logger.debug("Los eventosEjercicioPrograma son: {}",listadoEventosProgramas);
//				if (!listadoEventosProgramas.isEmpty()) {
//					for (EventoEjercicioProgramaEO eventoEjercicioPrograma : listadoEventosProgramas) {
//						logger.debug("el eventoEjercicioPrograma es: {}",eventoEjercicioPrograma);
//						logger.debug("lAS dependenciasUsuarios SON: {}",dependenciasUsuarios);
//						for (DependenciaEO dependencia : dependenciasUsuarios) {
//							logger.debug("la dependencia ({}) la dependencia del evento es ({})",dependencia.getDependencia(),eventoEjercicioPrograma.getProgramaEjercicio().getPrograma().getDependencia().getDependencia());
//							logger.debug("Se encuentra arriba o es la misma ({})",eventoEjercicioPrograma.getProgramaEjercicio().getPrograma().getDependencia().hijoDe(dependencia));
//							if(eventoEjercicioPrograma.getProgramaEjercicio().getPrograma().getDependencia().hijoDe(dependencia)){
//								bandDependencias=false;
//							}
//						}
//					}
//				}
//				else {
//					logger.debug("El listadoEventosProgramas ({}) el nick del evento es {} y el del usuario es {}",listadoEventosProgramas,eventoSocial.getNick(),getUsuario().getNick());
//					bandUsuario=true;
//					if (!eventoSocial.getNick().equals(getUsuario().getNick())) {
//							listado.remove(eventoSocial);
//					}
//				}
//			}
//			else  {
//				logger.debug(" Usuario no tiene dependencias {} el nick del evento es {} y el del usuario es {}",dependenciasUsuarios,eventoSocial.getNick(),getUsuario().getNick());
//				bandUsuario=true;
//				if (!eventoSocial.getNick().equals(getUsuario().getNick())) {
//						listado.remove(eventoSocial);
//				}
//			}
//			
//			if (!bandUsuario && bandDependencias) {
//				logger.debug("El evento social ES eliminado {}",eventoSocial);
//				listado.remove(eventoSocial);
//			}
//			else{
//				logger.debug("El evento social NO es eliminado {}",eventoSocial);
//			}
//			
//		}
//
//		////////////////////////////////////////////////////////////////////////////
//		/*if(!getUsuario().getDependencias().isEmpty()){
//			HashMap<String, Object> params= new HashMap<>();
//			params.put("dependencias", getUsuario().getDependencias());
//			params.put("nick", getUsuario().getNick());
//			listado = sqlSession.selectList("eventos.eventos.listadoPorDependencia", params);
//		}
//		else{*/
//			
//		//}
//		
//		logger.debug("El listado es {}", listado);
//		for (EventoSocialEO eventoSocial : listado) {
//			logger.debug("El nivel es {}", eventoSocial.getNivel());
//			switch (eventoSocial.getNivel()) {
//			case NACIONAL:
//				logger.debug("Todo El País");
//				territorios = new ArrayList<>();
//				break;
//			case ENTIDAD:
//				territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", eventoSocial);
//				break;
//			case MUNICIPIO:
//				territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", eventoSocial);
//				break;
//			case DFEDERAL:
//				territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", eventoSocial);
//				break;
//			case DLOCAL:
//				territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", eventoSocial);
//				break;
//			case GEOZONA:
//				territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", eventoSocial);
//				break;
//			default:
//				break;
//			}
//			eventoSocial.setTerritorios(territorios);
//		}
//
//		tabla.setListado(listado);
//		if (eventoSeleccionado != null) {
//			tabla.setSeleccionado(eventoSeleccionado);
//		} else if (!listado.isEmpty()) {
//			tabla.setSeleccionado(listado.get(0));
//		}
//		return tabla;
//	}
	
	public Modelo<EventoSocialEO> tablaEventosSociales(EventoSocialEO eventoSeleccionado) {
		Modelo<EventoSocialEO> tabla = new Modelo<>();
		List<EventoSocialEO> listado = new ArrayList<>();
		//List<EventoSocialEO> listadoPorNick = new ArrayList<>();
		//List<EventoSocialEO> listadoFinal = new ArrayList<>();
		List<JavaBeanT> territorios = new ArrayList<>();
		HashMap<String, Object> params;
		
		////////////////////////////////////////////////////////////////////////////
		logger.debug("EL usuario es {} y su dependencia es {}",getUsuario(),getUsuario().getDependencias());
		if(!getUsuario().getDependencias().isEmpty()){
			params = new HashMap<>();
			params.put("dependencias", getUsuario().getDependencias());
			//params.put("nick", getUsuario().getNick());
			listado = sqlSession.selectList("eventos.eventos.listadoPorDependenciaCompleto", params);
			//Obtenemos_listado_por_el_nick
			//listadoPorNick = sqlSession.selectList("eventos.eventos.listadoPorNick", getUsuario().getNick());
		}else{
			listado = sqlSession.selectList("eventos.eventos.listadoCompleto");
		}
		
		for (EventoSocialEO eventoSocial2 : listado) {	
			List<DependenciaEO> listadoDependencias = new ArrayList<>();
			List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
			listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial2);
			for (EventoEjercicioProgramaEO eventoEjercicioProgramaEO : listadoEventosProgramas) {
				boolean ban=true;
				for (DependenciaEO dependencia : listadoDependencias) {
					if (dependencia.equals(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia())){
						ban=false;
					}
				}
				if (ban) {
					listadoDependencias.add(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia());
				}
			}
			eventoSocial2.setDependencias(listadoDependencias);
			logger.debug("Del evento {} las dependencias son {}",eventoSocial2.getNombre(),listadoDependencias);
			Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas =new Modelo<>();
			tablaEjerciciosProgramas.setListado(listadoEventosProgramas);
			if (!listadoEventosProgramas.isEmpty()) {
				eventoSocial2.setSinDependencias(false);
				tablaEjerciciosProgramas.setSeleccionado(listadoEventosProgramas.get(0));
			}
			else{
				eventoSocial2.setSinDependencias(true);
			}
			eventoSocial2.setTablaEjerciciosProgramas(tablaEjerciciosProgramas);
			
			
		}
		
		/*if(!listadoPorNick.isEmpty()){
			for(EventoSocialEO ev : listadoPorNick){
				listadoFinal.add(ev);
			}
		}
		
		for(EventoSocialEO ev : listado){
			listadoFinal.add(ev);
		}*/
		
		logger.debug("El listado es {}", listado);
		for (EventoSocialEO eventoSocial : listado) {
			logger.debug("El nivel es {}", eventoSocial.getNivel());
			switch (eventoSocial.getNivel()) {
			case NACIONAL:
				logger.debug("Todo El País");
				territorios = new ArrayList<>();
				break;
			case ENTIDAD:
				territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", eventoSocial);
				break;
			case MUNICIPIO:
				territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", eventoSocial);
				break;
			case DFEDERAL:
				territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", eventoSocial);
				break;
			case DLOCAL:
				territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", eventoSocial);
				break;
			case GEOZONA:
				territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", eventoSocial);
				break;
			default:
				break;
			}
			eventoSocial.setTerritorios(territorios);
		}
		
		tabla.setListado(listado);
		if (eventoSeleccionado != null) {
			tabla.setSeleccionado(eventoSeleccionado);
		} 
		else if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}

	public EventoSocialEO crearEventoSocial() {
		EventoSocialEO eventoSocial = new EventoSocialEO();
		List<JavaBeanT> territorios = new ArrayList<>();
		eventoSocial.setTerritorios(territorios);
		eventoSocial.setNick(getUsuario().getNick());
		eventoSocial.setNumeroAsistentes(0);
		eventoSocial.setEstatus(EstatusEventoDO.PROGRAMADO);
		eventoSocial.setNivel(NivelesDO.NACIONAL);
		Date date = new Date();
		eventoSocial.setFechaString(date);
		eventoSocial.setFechaStringFin(date);
		if (!getUsuario().getDependencias().isEmpty()) {
			eventoSocial.setDependenciasUsuario(getUsuario().getDependencias());
		}
		return eventoSocial;
	}
	
	public EventoSocialEO nuevoEventoSocial(EventoSocialEO eventoSocial, boolean bandera, GeozonaEO geozona) {

		logger.debug("El evento recibido es {}", eventoSocial);
		Integer id = sqlSession.selectOne("eventos.eventos.nuevoID");
		eventoSocial.setId(id);
		if (bandera) {
			eventoSocial.setNivel(geozona.getNivel());
		}
		if (eventoSocial.getFechaFin() == null) {
			eventoSocial.setFechaFin(eventoSocial.getFecha());
		}
		sqlSession.insert("eventos.eventos.agregar", eventoSocial);
		bitacorasC.insert(TiposAccionesDO.INSERTAR, "Eventos", "Se creo el evento "+eventoSocial.getId()+" - "+eventoSocial.getNombre()+" a nivel "+eventoSocial.getNivel().getNombre(), getUsuario().getNick());
		for (JavaBeanT territorio : eventoSocial.getTerritorios()) {
			HashMap<String, Object> mapa = new HashMap<>();
			mapa.put("idEvento", eventoSocial.getId());
			switch (eventoSocial.getNivel()) {
			case ENTIDAD:
				mapa.put("llave", ((EntidadEO) territorio).getLlave());
				break;
			case MUNICIPIO:
				mapa.put("llave", ((MunicipioEO) territorio).getLlave());
				break;
			case DFEDERAL:
				mapa.put("llave", ((DFederalEO) territorio).getLlave());
				break;
			case DLOCAL:
				mapa.put("llave", ((DLocalEO) territorio).getLlave());
				break;
			case GEOZONA:
				mapa.put("llave", ((GeozonaParticionEO) territorio).getLlave());
				break;
			default:
				break;
			}
			sqlSession.insert("eventos.eventos.agregarllaves", mapa);
			bitacorasC.insert(TiposAccionesDO.INSERTAR, "Eventos", "Se agregaron los territorios al evento social "+eventoSocial.getId()+" - "+eventoSocial.getNombre()+" a nivel "+eventoSocial.getNivel().getNombre(), getUsuario().getNick());
		}

		return eventoSocial;
	}

	public void eliminarEventoSocial(EventoSocialEO eventoSocial) {
		logger.debug("Evento {}", eventoSocial);
		sqlSession.delete("eventos.responsables.eliminarDeEvento",eventoSocial);	
		sqlSession.delete("eventos.presidium.eliminarDeEvento",eventoSocial);
		sqlSession.delete("eventos.eventosEjercicioPrograma.eliminar",eventoSocial);
		sqlSession.delete("eventos.eventos.eliminarllaves", eventoSocial);
		sqlSession.delete("eventos.eventos.eliminar", eventoSocial);
		bitacorasC.insert(TiposAccionesDO.ELIMINAR, "Eventos", "Se elimino el evento "+eventoSocial.getId()+" - "+eventoSocial.getNombre()+" a nivel "+eventoSocial.getNivel().getNombre(), getUsuario().getNick());
	}

	public NivelesDO[] listadoNiveles() {
		NivelesDO[] listado = new NivelesDO[4];
		listado[0] = NivelesDO.NACIONAL;
		listado[1] = NivelesDO.ENTIDAD;
		listado[2] = NivelesDO.MUNICIPIO;
		listado[3] = NivelesDO.GEOZONA;
		return listado;
	}

	public EstatusEventoDO[] listadoEstatus() {
		return EstatusEventoDO.values();
	}

	public TipoEventoDO[] listadoTipo() {
		logger.debug("Lsitado Tipos {}", TipoEventoDO.values()[0]);
		return TipoEventoDO.values();
	}

	// public Modelo<JavaBeanT> obtenerTabla(S) {
	// Modelo<JavaBeanT> tabla=new Modelo<>();
	// List<JavaBeanT> listado=new ArrayList<>();
	//
	// }

	public Modelo<JavaBeanT> nivelTerritorio(NivelesDO nivel, List<EntidadEO> entidades) {
		Modelo<JavaBeanT> tabla = new Modelo<>();
		List<JavaBeanT> listado = new ArrayList<>();
		logger.debug("Entidades {} Nivel {} ", entidades, nivel);
		if (entidades == null || entidades.isEmpty()) {
			entidades = new ArrayList<>();
		}
		switch (nivel) {
		case MUNICIPIO:
			listado = sqlSession.selectList("catalogos.municipios.listadoPorEntidades", entidades);
			break;
		case DFEDERAL:
			listado = sqlSession.selectList("catalogos.dFederales.listadoPorEntidades", entidades);
			break;
		case DLOCAL:
			listado = sqlSession.selectList("catalogos.dLocales.listadoPorEntidades", entidades);
			break;
		default:
			break;
		}
		logger.debug("El listado de nivel es {}", listado);
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}

	public Modelo<GeozonaEO> tablaGeozonas() {
		Modelo<GeozonaEO> tabla = new Modelo<>();
		List<GeozonaEO> listado = new ArrayList<>();
		listado = sqlSession.selectList("catalogos.geozonas.listado");
		logger.debug("El listado {}", listado);
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}

	public Modelo<GeozonaParticionEO> crearModeloParticiones(List<GeozonaParticionEO> particiones) {
		logger.debug("Particiones {}", particiones);
		Modelo<GeozonaParticionEO> tabla = new Modelo<>();
		List<GeozonaParticionEO> listado = particiones;
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}

	public Modelo<JavaBeanT> territoriosSubnivel(GeozonaEO geozona, List<GeozonaParticionEO> particiones) {
		Modelo<JavaBeanT> tabla = new Modelo<>();
		List<JavaBeanT> listado = new ArrayList<>();
		if (!particiones.isEmpty()) {
			switch (geozona.getNivel()) {
			case ENTIDAD:
				listado = sqlSession.selectList("catalogos.entidades.listadoPorGeozonaParticionesLlaves", particiones);
				break;
			case MUNICIPIO:
				listado = sqlSession.selectList("catalogos.municipios.listadoPorGeozonaParticionesLlaves", particiones);
				break;
			default:
				break;
			}
		}

		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}

	public Modelo<JavaBeanT> tablaCalendario(List<EventoSocialEO> listadoEventoSocial) {
		Modelo<JavaBeanT> tabla = new Modelo<>();
		List<JavaBeanT> listado = new ArrayList<>();
		 //= new ArrayList<>();
		//listadoEventoSocial=tablaEventosSociales(null).getListado();
		if (!listadoEventoSocial.isEmpty()) {
			listado = sqlSession.selectList("eventos.calendarioEventos.listado",listadoEventoSocial);
		}
		tabla.setListado(listado);
		for (JavaBeanT cal : listado) {
			CalendarioEventoSocialEO calendario = (CalendarioEventoSocialEO) cal;
			logger.debug("Calendario {}", calendario);
			calendario.setId((int) (Math.random() * 100));
			cal = calendario;
		}
		return tabla;
	}

	public ScheduleModel calendario(List<CalendarioEventoSocialEO> listado) {
		ScheduleModel modelo = null;
		modelo = new DefaultScheduleModel();
		logger.debug("El listadoes {}", listado);
		for (CalendarioEventoSocialEO calendarioEventoSocialEO : listado) {
			Date fechaInicio = new Date(calendarioEventoSocialEO.getFecha().getTime());
			Date fechaFinDate = new Date(calendarioEventoSocialEO.getFechaFin().getTime());
			if (!fechaInicio.equals(fechaFinDate)) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fechaFinDate);
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				fechaFinDate = calendar.getTime();
			}
			modelo.addEvent(new DefaultScheduleEvent("   " + calendarioEventoSocialEO.getConteo()+ " Evento(s)"+(calendarioEventoSocialEO.getDependencias()!=null?"\n Dependencia(s) :"+calendarioEventoSocialEO.getDependencias():""),
					fechaInicio, fechaFinDate));
		}
		return modelo;
	}

	String fecha = new String("");

	public void onDateSelect(SelectEvent selectEvent) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = ((Date) selectEvent.getObject());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaDate);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		fechaDate = calendar.getTime();
		fecha = formatter.format(fechaDate);
		logger.debug("La fecha es {} con formato es {}", fechaDate, fecha);
	}

//	public Modelo<EventoSocialEO> tablaEventosSocialesCalendario() {
//		Modelo<EventoSocialEO> tabla = new Modelo<>();
//		List<EventoSocialEO> listado = new ArrayList<>();
//		List<JavaBeanT> territorios = new ArrayList<>();
//		List<EventoSocialEO> listadoAux = new ArrayList<>();
//		List<DependenciaEO> dependenciasUsuarios = getUsuario().getDependencias();
//		logger.debug("EL usuario es {} y su dependencia es {}",getUsuario(), dependenciasUsuarios);
//		logger.debug("El fecha es listado {}", fecha);
//		if (!fecha.equals("")) {
//			listado = sqlSession.selectList("eventos.eventos.buscarPorFecha", fecha);
//			////////////////////////////////////////////////////////////////////////////
//			
//			listadoAux.addAll(listado);
//
//			for (EventoSocialEO eventoSocial2 : listado) {	
//				List<DependenciaEO> listadoDependencias = new ArrayList<>();
//				List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
//				listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial2);
//				for (EventoEjercicioProgramaEO eventoEjercicioProgramaEO : listadoEventosProgramas) {
//					boolean ban=true;
//					for (DependenciaEO dependencia : listadoDependencias) {
//						if (dependencia.equals(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia())){
//							ban=false;
//						}
//					}
//					if (ban) {
//						listadoDependencias.add(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia());
//					}
//				}
//				eventoSocial2.setDependencias(listadoDependencias);
//				logger.debug("Del evento {} las dependencias son {}",eventoSocial2.getNombre(),listadoDependencias);
//				Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas =new Modelo<>();
//				tablaEjerciciosProgramas.setListado(listadoEventosProgramas);
//				if (!listadoEventosProgramas.isEmpty()) {
//					tablaEjerciciosProgramas.setSeleccionado(listadoEventosProgramas.get(0));
//				}
//				eventoSocial2.setTablaEjerciciosProgramas(tablaEjerciciosProgramas);
//				
//				
//			}
//			for (EventoSocialEO eventoSocial : listadoAux) {
//				boolean bandUsuario=false;
//				boolean bandDependencias=true;
//				if (dependenciasUsuarios!=null && !dependenciasUsuarios.isEmpty()) {
//					List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
//					listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial);
//					if (!listadoEventosProgramas.isEmpty()) {
//						for (EventoEjercicioProgramaEO eventoEjercicioPrograma : listadoEventosProgramas) {
//							for (DependenciaEO dependencia : dependenciasUsuarios) {
//								logger.debug("la dependencia ({}) la dependencia del evento es {}",dependencia,eventoEjercicioPrograma.getProgramaEjercicio().getPrograma().getDependencia());
//								if(eventoEjercicioPrograma.getProgramaEjercicio().getPrograma().getDependencia().hijoDe(dependencia)){
//									bandDependencias=false;
//								}
//							}
//						}
//					}
//					else {
//						logger.debug("El listadoEventosProgramas ({}) el nick del evento es {} y el del usuario es {}",listadoEventosProgramas,eventoSocial.getNick(),getUsuario().getNick());
//						bandUsuario=true;
//						if (!eventoSocial.getNick().equals(getUsuario().getNick())) {
//								listado.remove(eventoSocial);
//						}
//					}
//				}
//				else  {
//					logger.debug(" Usuario no tiene dependencias {} el nick del evento es {} y el del usuario es {}",dependenciasUsuarios,eventoSocial.getNick(),getUsuario().getNick());
//					bandUsuario=true;
//					if (!eventoSocial.getNick().equals(getUsuario().getNick())) {
//							listado.remove(eventoSocial);
//					}
//				}
//				
//				if (!bandUsuario && bandDependencias) {
//					listado.remove(eventoSocial);
//				}
//				
//			}
//
//			////////////////////////////////////////////////////////////////////////////
//			
//			
//			logger.debug("El listado es {}", listado);
//			for (EventoSocialEO eventoSocial : listado) {
//				logger.debug("El nivel es {}", eventoSocial.getNivel());
//				switch (eventoSocial.getNivel()) {
//				case NACIONAL:
//					logger.debug("Todo El País");
//					territorios = new ArrayList<>();
//					break;
//				case ENTIDAD:
//					territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", eventoSocial);
//					break;
//				case MUNICIPIO:
//					territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", eventoSocial);
//					break;
//				case DFEDERAL:
//					territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", eventoSocial);
//					break;
//				case DLOCAL:
//					territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", eventoSocial);
//					break;
//				case GEOZONA:
//					territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", eventoSocial);
//					break;
//				default:
//					break;
//				}
//				eventoSocial.setTerritorios(territorios);
//			}
//		}
//
//		tabla.setListado(listado);
//		if (!listado.isEmpty()) {
//			tabla.setSeleccionado(listado.get(0));
//		}
//		return tabla;
//	}
	
	public Modelo<EventoSocialEO> tablaEventosSocialesCalendario() {
		Modelo<EventoSocialEO> tabla = new Modelo<>();
		List<EventoSocialEO> listado = new ArrayList<>();
		//List<EventoSocialEO> listadoPorNick = new ArrayList<>();
		//List<EventoSocialEO> listadoFinal = new ArrayList<>();
		List<JavaBeanT> territorios = new ArrayList<>();
		HashMap<String, Object> params;
		List<DependenciaEO> dependenciasUsuarios = getUsuario().getDependencias();
		logger.debug("EL usuario es {} y su dependencia es {}",getUsuario(), dependenciasUsuarios);
		logger.debug("El fecha es listado {}", fecha);
		//if (!fecha.equals("")) {
			
			if(!getUsuario().getDependencias().isEmpty()){
				params = new HashMap<>();
				params.put("dependencias", getUsuario().getDependencias());
				params.put("fecha", fecha);
				//params.put("nick", getUsuario().getNick());listadoPorDependenciaCompleto
				listado = sqlSession.selectList("eventos.eventos.buscarPorFechaCompleto", params);
				//Obtenemos_listado_por_el_nick
				//listadoPorNick = sqlSession.selectList("eventos.eventos.listadoPorNick", getUsuario().getNick());
			}else{
				logger.debug("buscarPorFechaCompletoDependenciasTodas");
				listado = sqlSession.selectList("eventos.eventos.buscarPorFechaCompletoDependenciasTodas", fecha);
			}
			
			////////////////////////////////////////////////////////////////////////////

			logger.debug("listado {}",listado);
			for (EventoSocialEO eventoSocial2 : listado) {	
				List<DependenciaEO> listadoDependencias = new ArrayList<>();
				List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
				listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial2);
				for (EventoEjercicioProgramaEO eventoEjercicioProgramaEO : listadoEventosProgramas) {
					boolean ban=true;
					for (DependenciaEO dependencia : listadoDependencias) {
						if (dependencia.equals(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia())){
							ban=false;
						}
					}
					if (ban) {
						listadoDependencias.add(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia());
					}
				}
				eventoSocial2.setDependencias(listadoDependencias);
				logger.debug("Del evento {} las dependencias son {}",eventoSocial2.getNombre(),listadoDependencias);
				Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas =new Modelo<>();
				tablaEjerciciosProgramas.setListado(listadoEventosProgramas);
				if (!listadoEventosProgramas.isEmpty()) {
					tablaEjerciciosProgramas.setSeleccionado(listadoEventosProgramas.get(0));
				}
				eventoSocial2.setTablaEjerciciosProgramas(tablaEjerciciosProgramas);
				
				
			}
			////////////////////////////////////////////////////////////////////////////
			
			/*if(!listadoPorNick.isEmpty()){
				for(EventoSocialEO ev : listadoPorNick){
					listadoFinal.add(ev);
				}
			}
			
			for(EventoSocialEO ev : listado){
				listadoFinal.add(ev);
			}
*/
			////////////////////////////////////////////////////////////////////////////
			
			logger.debug("El listado es {}", listado);
			for (EventoSocialEO eventoSocial : listado) {
				logger.debug("El nivel es {}", eventoSocial.getNivel());
				switch (eventoSocial.getNivel()) {
				case NACIONAL:
					logger.debug("Todo El País");
					territorios = new ArrayList<>();
					break;
				case ENTIDAD:
					territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", eventoSocial);
					break;
				case MUNICIPIO:
					territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", eventoSocial);
					break;
				case DFEDERAL:
					territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", eventoSocial);
					break;
				case DLOCAL:
					territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", eventoSocial);
					break;
				case GEOZONA:
					territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", eventoSocial);
					break;
				default:
					break;
				}
				eventoSocial.setTerritorios(territorios);
			}
		//}
		
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}

	public void actualizarEstatus(EventoSocialEO evento) {
		logger.debug("El evento a actualizar {}-{} a el estatus {}", evento.getId(), evento.getNombre(),
				evento.getEstatus().getNombre());
		sqlSession.update("eventos.eventos.actualizarEstatus", evento);
		bitacorasC.insert(TiposAccionesDO.ACTUALIZAR, "Eventos", "Se actualizo el estatus del evento "+evento.getId()+" - "+evento.getNombre()+" a estado "+evento.getEstatus().getNombre(), getUsuario().getNick());
	}

//	public Modelo<EventoSocialEO> tablaEventosSocialesRealizados(EventoSocialEO eventoSeleccionado) {
//		Modelo<EventoSocialEO> tabla = new Modelo<>();
//		List<EventoSocialEO> listado = new ArrayList<>();
//		List<JavaBeanT> territorios = new ArrayList<>();
//		List<EventoSocialEO> listadoAux = new ArrayList<>();
//		List<DependenciaEO> dependenciasUsuarios = getUsuario().getDependencias();
//
//		////////////////////////////////////////////////////////////////////////////
//		logger.debug("EL usuario es {} y su dependencia es {}",getUsuario(),dependenciasUsuarios);
//		
//		
//		
//		listado = sqlSession.selectList("eventos.eventos.listadoRealizados");
//		listadoAux.addAll(listado);
//
//
//		
//		for (EventoSocialEO eventoSocial2 : listado) {	
//			List<DependenciaEO> listadoDependencias = new ArrayList<>();
//			List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
//			listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial2);
//			for (EventoEjercicioProgramaEO eventoEjercicioProgramaEO : listadoEventosProgramas) {
//				boolean ban=true;
//				for (DependenciaEO dependencia : listadoDependencias) {
//					if (dependencia.equals(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia())){
//						ban=false;
//					}
//				}
//				if (ban) {
//					listadoDependencias.add(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia());
//				}
//			}
//			eventoSocial2.setDependencias(listadoDependencias);
//			logger.debug("Del evento {} las dependencias son {}",eventoSocial2.getNombre(),listadoDependencias);
//			Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas =new Modelo<>();
//			tablaEjerciciosProgramas.setListado(listadoEventosProgramas);
//			if (!listadoEventosProgramas.isEmpty()) {
//				tablaEjerciciosProgramas.setSeleccionado(listadoEventosProgramas.get(0));
//			}
//			eventoSocial2.setTablaEjerciciosProgramas(tablaEjerciciosProgramas);
//			
//			
//		}
//		for (EventoSocialEO eventoSocial : listadoAux) {
//			boolean bandUsuario=false;
//			boolean bandDependencias=true;
//			if (dependenciasUsuarios!=null && !dependenciasUsuarios.isEmpty()) {
//				List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
//				listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial);
//				if (!listadoEventosProgramas.isEmpty()) {
//					for (EventoEjercicioProgramaEO eventoEjercicioPrograma : listadoEventosProgramas) {
//						for (DependenciaEO dependencia : dependenciasUsuarios) {
//							logger.debug("la dependencia ({}) la dependencia del evento es {}",dependencia,eventoEjercicioPrograma.getProgramaEjercicio().getPrograma().getDependencia());
//							if(eventoEjercicioPrograma.getProgramaEjercicio().getPrograma().getDependencia().hijoDe(dependencia)){
//								bandDependencias=false;
//							}
//						}
//					}
//				}
//				else {
//					logger.debug("El listadoEventosProgramas ({}) el nick del evento es {} y el del usuario es {}",listadoEventosProgramas,eventoSocial.getNick(),getUsuario().getNick());
//					bandUsuario=true;
//					if (!eventoSocial.getNick().equals(getUsuario().getNick())) {
//							listado.remove(eventoSocial);
//					}
//				}
//			}
//			else  {
//				logger.debug(" Usuario no tiene dependencias {} el nick del evento es {} y el del usuario es {}",dependenciasUsuarios,eventoSocial.getNick(),getUsuario().getNick());
//				bandUsuario=true;
//				if (!eventoSocial.getNick().equals(getUsuario().getNick())) {
//						listado.remove(eventoSocial);
//				}
//			}
//			
//			if (!bandUsuario && bandDependencias) {
//				listado.remove(eventoSocial);
//			}
//			
//		}
//
//		////////////////////////////////////////////////////////////////////////////
//		logger.debug("El listado es {}", listado);
//		for (EventoSocialEO eventoSocial : listado) {
//			logger.debug("El nivel es {}", eventoSocial.getNivel());
//			switch (eventoSocial.getNivel()) {
//			case NACIONAL:
//				logger.debug("Todo El País");
//				territorios = new ArrayList<>();
//				break;
//			case ENTIDAD:
//				territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", eventoSocial);
//				break;
//			case MUNICIPIO:
//				territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", eventoSocial);
//				break;
//			case DFEDERAL:
//				territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", eventoSocial);
//				break;
//			case DLOCAL:
//				territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", eventoSocial);
//				break;
//			case GEOZONA:
//				territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", eventoSocial);
//				break;
//			default:
//				break;
//			}
//			eventoSocial.setTerritorios(territorios);
//		}
//
//		tabla.setListado(listado);
//		if (eventoSeleccionado != null) {
//			tabla.setSeleccionado(eventoSeleccionado);
//		} else if (!listado.isEmpty()) {
//			tabla.setSeleccionado(listado.get(0));
//		}
//		return tabla;
//	}

	
	public Modelo<EventoSocialEO> tablaEventosSocialesRealizados(EventoSocialEO eventoSeleccionado) {
		Modelo<EventoSocialEO> tabla = new Modelo<>();
		List<EventoSocialEO> listado = new ArrayList<>();
		List<JavaBeanT> territorios = new ArrayList<>();

		//Obtenemos_eventos_realizados_en_el_arbol_de_nuestra_dependencia_asignada
		HashMap<String, Object> params;
		params = new HashMap<>();
		if(!getUsuario().getDependencias().isEmpty()){
			params.put("dependencias", getUsuario().getDependencias());
			params.put("estatus", EstatusEventoDO.REALIZADO);
			logger.debug("El params es {}", params);
			listado = sqlSession.selectList("eventos.eventos.listadoPorDependenciaCompleto", params);
		}else{
			listado = sqlSession.selectList("eventos.eventos.listadoRealizados");
		}
		
		
		for (EventoSocialEO eventoSocial2 : listado) {	
			List<DependenciaEO> listadoDependencias = new ArrayList<>();
			List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
			listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial2);
			for (EventoEjercicioProgramaEO eventoEjercicioProgramaEO : listadoEventosProgramas) {
				boolean ban=true;
				for (DependenciaEO dependencia : listadoDependencias) {
					if (dependencia.equals(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia())){
						ban=false;
					}
				}
				if (ban) {
					listadoDependencias.add(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia());
				}
			}
			eventoSocial2.setDependencias(listadoDependencias);
			//logger.debug("Del evento {} las dependencias son {}",eventoSocial2.getNombre(),listadoDependencias);
			Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas =new Modelo<>();
			tablaEjerciciosProgramas.setListado(listadoEventosProgramas);
			if (!listadoEventosProgramas.isEmpty()) {
				tablaEjerciciosProgramas.setSeleccionado(listadoEventosProgramas.get(0));
			}
			eventoSocial2.setTablaEjerciciosProgramas(tablaEjerciciosProgramas);
			
			
		}

		////////////////////////////////////////////////////////////////////////////
		//logger.debug("El listado es {}", listado);
		for (EventoSocialEO eventoSocial : listado) {
			//logger.debug("El nivel es {}", eventoSocial.getNivel());
			switch (eventoSocial.getNivel()) {
			case NACIONAL:
				//logger.debug("Todo El País");
				territorios = new ArrayList<>();
				break;
			case ENTIDAD:
				territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", eventoSocial);
				break;
			case MUNICIPIO:
				territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", eventoSocial);
				break;
			case DFEDERAL:
				territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", eventoSocial);
				break;
			case DLOCAL:
				territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", eventoSocial);
				break;
			case GEOZONA:
				territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", eventoSocial);
				break;
			default:
				break;
			}
			eventoSocial.setTerritorios(territorios);
		}

		tabla.setListado(listado);
		if (eventoSeleccionado != null) {
			tabla.setSeleccionado(eventoSeleccionado);
		} else if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}
	
	// Inicio: Funciones para Mapa de Eventos
	public FiltrosMapa nuevoFiltros() {
		FiltrosMapa filtros;

		filtros = new FiltrosMapa();

		return filtros;
	}

	public HashMap<String, Object> nuevoModeloMapa() {
		HashMap<String, Object> parametros;
		String inicio, actualizar, actualizarCapa;

		parametros = new HashMap<>();
		inicio = "iniciarMapaNacional('formMapaEventos:tabView:panelMapa');";
		actualizar = "";
		actualizarCapa = "";

		parametros.put("inicio", inicio);
		parametros.put("actualizar", actualizar);
		parametros.put("actualizarCapa", actualizarCapa);
		parametros.put("eventos", new ArrayList<EventoSocialEO>());

		return parametros;
	}

	public HashMap<String, Object> modeloMapa(FiltrosMapa filtros) {
		HashMap<String, Object> parametros;
		List<EventoSocialEO> eventos, auxEventos;
		EventoSocialEO seleccionado;
		StringBuilder actualizar;
		Set<String> llaves, llavesSeleccionado;
		String auxComa;

		parametros = new HashMap<>();
		actualizar = new StringBuilder();
		llaves = new HashSet<>();
		llavesSeleccionado = new HashSet<>();

		//logger.debug("Parametros Recibidos: {}", filtros);

		eventos = sqlSession.selectList("eventos.eventos.porFiltros", filtros);
		auxEventos = new ArrayList<>();
		auxEventos.addAll(eventos);
		
		parametros.put("eventos", eventos);
		//logger.debug("Eventos obtenidos: {}", eventos.size());
		
		for(EventoSocialEO evento : eventos){
			cargarTerritorios(evento);
		}
		
		actualizar.append("quitarCapa(1);\n"); //Capa roja
		actualizar.append("quitarCapa(1);\n"); //Capa gris
		actualizar.append("quitarCapa(1);\n"); //Capa amarilla

		switch (filtros.getNivel()) {
		case DFEDERAL:
			break;
		case DLOCAL:
			break;
		case MUNICIPIO:
			// dejar solo eventos de la Entidad seleccionada
			for (EventoSocialEO evento : auxEventos) {
				if (quitarEvento(filtros.getEntidad(), evento))
					eventos.remove(evento);
			}
			
			//Pintar los Municipios donde haya evento
			for (EventoSocialEO evento : eventos) {
				for (JavaBeanT t : evento.getTerritorios()) {
					//logger.debug("{}", t.getClass().getSimpleName());
					llaves.addAll(obtenerLlaves(NivelesDO.MUNICIPIO, t));
				}
			}
			
			actualizar.append("actualizarMapa([");
			actualizar.append(filtros.getEntidad().getGeoData().getBounds());
			actualizar.append("]);\n");
			actualizar.append("agregarCapa('politik:municipios', '', 'id_entidad = ");
			actualizar.append(filtros.getEntidad().getLlave());
			actualizar.append("');\n");
			actualizar.append("agregarCapa('politik:municipios', 'poligono_rojo', \"llave in (");
			auxComa = "";
			for(String l : llaves){
				actualizar.append(auxComa);
				actualizar.append("'");
				actualizar.append(l);
				actualizar.append("'");
				auxComa = ",";
			}
			actualizar.append(")\");\n");

			//Agregar Capa Seleccionado
			actualizar.append("agregarCapa('politik:municipios', 'poligono_amarillo', \"llave in (");
			if (!eventos.isEmpty()) {
				seleccionado = eventos.get(0);
			} else {
				EntidadEO entidadFalsa;
				List<JavaBeanT> listadoFalso;
				entidadFalsa = new EntidadEO();
				entidadFalsa.setId(-1);
				listadoFalso = new ArrayList<>();
				listadoFalso.add(entidadFalsa);
				seleccionado = new EventoSocialEO();
				seleccionado.setTerritorios(listadoFalso);
			}
			for (JavaBeanT t : seleccionado.getTerritorios()) {
				llavesSeleccionado.addAll(obtenerLlaves(NivelesDO.MUNICIPIO, t));
			}
			auxComa = "";
			for (String l : llavesSeleccionado) {
				actualizar.append(auxComa);
				actualizar.append("'");
				actualizar.append(l);
				actualizar.append("'");
				auxComa = ",";
			}
			actualizar.append(")\");\n");
			break;
		case GEOZONA:
			break;
		case ENTIDAD:
			actualizar.append("actualizarMapa([-118.454994376215, 14.5330668762905, -86.712489103835, 32.7220212408026]);\n");
			
			//Agregar capa de Entidades
			actualizar.append("agregarCapa('politik:entidades', 'poligono_rojo', 'id_entidad in (");
			for (EventoSocialEO evento : eventos) {
				for (JavaBeanT t : evento.getTerritorios()) {
					//logger.debug("{}", t.getClass().getSimpleName());
					llaves.addAll(obtenerLlaves(NivelesDO.ENTIDAD, t));
				}
			}
			auxComa = "";
			for(String l : llaves){
				actualizar.append(auxComa);
				actualizar.append(l);
				auxComa = ",";
			}
			actualizar.append(")');\n");
			
			//Agregar Capa Seleccionado
			actualizar.append("agregarCapa('politik:entidades', 'poligono_amarillo', 'id_entidad in (");
			if (!eventos.isEmpty()) {
				seleccionado = eventos.get(0);
			} else {
				EntidadEO entidadFalsa;
				List<JavaBeanT> listadoFalso;
				entidadFalsa = new EntidadEO();
				entidadFalsa.setId(-1);
				listadoFalso = new ArrayList<>();
				listadoFalso.add(entidadFalsa);
				seleccionado = new EventoSocialEO();
				seleccionado.setTerritorios(listadoFalso);
			}
			for (JavaBeanT t : seleccionado.getTerritorios()) {
				llavesSeleccionado.addAll(obtenerLlaves(NivelesDO.ENTIDAD, t));
			}
			auxComa = "";
			for (String l : llavesSeleccionado) {
				actualizar.append(auxComa);
				actualizar.append(l);
				auxComa = ",";
			}
			actualizar.append(")');\n");
			break;
		default:
			break;
		}
		//logger.debug("Llaves obtenidas: {}", llaves);

		parametros.put("actualizar", actualizar.toString());

		return parametros;
	}
	
	public void modeloMapaActualizarSeleccionado(FiltrosMapa filtros, HashMap<String, Object> modeloMapa, EventoSocialEO seleccionado){
		List<String> llaves;
		StringBuilder actualizarCapa;
		String auxComa;
		
		llaves = new ArrayList<>();
		actualizarCapa = new StringBuilder();
		
		switch(filtros.getNivel()){
		case DFEDERAL:
			break;
		case DLOCAL:
			break;
		case ENTIDAD:
			actualizarCapa.append("actualizarCapa(2, 'id_entidad in (");
			for (JavaBeanT t : seleccionado.getTerritorios()) {
				llaves.addAll(obtenerLlaves(NivelesDO.ENTIDAD, t));
			}
			auxComa = "";
			for (String l : llaves) {
				actualizarCapa.append(auxComa);
				actualizarCapa.append(l);
				auxComa = ",";
			}
			actualizarCapa.append(")');\n");
			break;
		case GEOZONA:
			break;
		case LOCALIDAD:
			break;
		case MANZANA:
			break;
		case MUNICIPIO:
			actualizarCapa.append("actualizarCapa(3, \"llave in (");
			for (JavaBeanT t : seleccionado.getTerritorios()) {
				llaves.addAll(obtenerLlaves(NivelesDO.MUNICIPIO, t));
			}
			auxComa = "";
			for (String l : llaves) {
				actualizarCapa.append(auxComa);
				actualizarCapa.append("'");
				actualizarCapa.append(l);
				actualizarCapa.append("'");
				auxComa = ",";
			}
			actualizarCapa.append(")\");\n");
			break;
		case NACIONAL:
			break;
		case SECCION:
			break;
		default:
			break;
		}
		
		modeloMapa.put("actualizarCapa", actualizarCapa.toString());
	}
	
	private boolean quitarEvento(JavaBeanT territorio, EventoSocialEO evento){
		boolean respuesta;
		List<JavaBeanT> territorios;
		String claseTerritorioEvento;
		
		respuesta = false;
		territorios = evento.getTerritorios();
		claseTerritorioEvento = null;
		
		if(!territorios.isEmpty()){
			claseTerritorioEvento = territorios.get(0).getClass().getSimpleName();
		}
		
		for(JavaBeanT t : territorios){
			//logger.debug("territorio a verificar: {}", t);
			switch(claseTerritorioEvento){
			case "EntidadEO":
				respuesta |= ((EntidadEO) t).contieneTerritorio(territorio);
				break;
			case "DFederalEO":
				respuesta |= ((DFederalEO) t).contieneTerritorio(territorio);
				break;
			case "DLocalEO":
				respuesta |= ((DLocalEO) t).contieneTerritorio(territorio);
				break;
			case "MunicipioEO":
				respuesta |= ((MunicipioEO) t).contieneTerritorio(territorio);
				break;
			case "SeccionEO":
				respuesta |= ((SeccionEO) t).contieneTerritorio(territorio);
				break;
			case "LocalidadEO":
				respuesta |= ((LocalidadEO) t).contieneTerritorio(territorio);
				break;
			case "ManzanaEO":
				respuesta |= ((ManzanaEO) t).contieneTerritorio(territorio);
				break;
			case "GeozonaParticionEO":
				respuesta |= ((GeozonaParticionEO) t).contieneTerritorio(territorio);
				break;
			}
		}
		
		return !respuesta;
	}
	
	private List<String> obtenerLlaves(NivelesDO nivel, JavaBeanT territorio){
		List<String> llaves;
		//logger.debug("ObtenerLlaves: {} - {}", nivel, territorio);
		
		llaves = new ArrayList<>();
		
		switch(nivel){
		case DFEDERAL:
			break;
		case DLOCAL:
			break;
		case ENTIDAD:
			switch(territorio.getClass().getSimpleName()){
			case "EntidadEO":
				llaves.add(((EntidadEO)territorio).getLlave());
				break;
			case "MunicipioEO":
				llaves.add(((MunicipioEO)territorio).getEntidad().getLlave());
				break;
			case "DFederalEO":
				llaves.add(((DFederalEO)territorio).getEntidad().getLlave());
				break;
			case "DLocalEO":
				llaves.add(((DLocalEO)territorio).getEntidad().getLlave());
				break;
			case "SeccionEO":
				llaves.add(((SeccionEO)territorio).getEntidad().getLlave());
				break;
			case "LocalidadEO":
				llaves.add(((LocalidadEO)territorio).getMunicipio().getEntidad().getLlave());
				break;
			case "ManzanaEO":
				llaves.add(((ManzanaEO)territorio).getSeccion().getEntidad().getLlave());
				break;
			case "GeozonaParticionEO":
				for(JavaBeanT t : ((GeozonaParticionEO)territorio).getTerritorios()){
					llaves.addAll(obtenerLlaves(nivel, t));
				}
				break;
			}
			break;
		case GEOZONA:
			break;
		case LOCALIDAD:
			break;
		case MANZANA:
			break;
		case MUNICIPIO:
			switch(territorio.getClass().getSimpleName()){
			case "EntidadEO":
			case "DFederalEO":
			case "DLocalEO":
				break;
			case "MunicipioEO":
				llaves.add(((MunicipioEO)territorio).getLlave());
				break;
			case "SeccionEO":
				llaves.add(((SeccionEO)territorio).getMunicipio().getLlave());
				break;
			case "LocalidadEO":
				llaves.add(((LocalidadEO)territorio).getMunicipio().getLlave());
				break;
			case "ManzanaEO":
				llaves.add(((ManzanaEO)territorio).getSeccion().getMunicipio().getLlave());
				break;
			case "GeozonaParticionEO":
				for(JavaBeanT t : ((GeozonaParticionEO)territorio).getTerritorios()){
					llaves.addAll(obtenerLlaves(nivel, t));
				}
				break;
			}
			break;
		case NACIONAL:
			break;
		case SECCION:
			break;
		default:
			break;
		}
		
		return llaves;
	}

	private void cargarTerritorios(EventoSocialEO evento) {
		List<JavaBeanT> territorios;
		
		//logger.debug("El nivel es {}", evento.getNivel());
		territorios = new ArrayList<>();
		
		switch (evento.getNivel()) {
		case NACIONAL:
			//logger.debug("Todo El País");
			territorios = new ArrayList<>();
			break;
		case ENTIDAD:
			territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", evento);
			break;
		case MUNICIPIO:
			territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", evento);
			break;
		case DFEDERAL:
			territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", evento);
			break;
		case DLOCAL:
			territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", evento);
			break;
		case GEOZONA:
			territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", evento);
			for(JavaBeanT particion : territorios){
				geozonaC.cargarTerritoriosParticion(((GeozonaParticionEO)particion));
			}
			break;
		default:
			break;
		}
		evento.setTerritorios(territorios);
	}
	
	@SuppressWarnings("unchecked")
	public Modelo<EventoSocialEO> modeloEventosMapa(HashMap<String, Object> modeloMapa){
		Modelo<EventoSocialEO> modelo;
		
		modelo = new Modelo<>();
		
		modelo.setListado((List<EventoSocialEO>) modeloMapa.get("eventos"));
		if(!modelo.getListado().isEmpty()){
			modelo.setSeleccionado(modelo.getListado().get(0));
		}
		
		return modelo;
	}
	// Fin: Funciones para Mapa de Eventos
	
	
	public void actualizarEventoSocial(EventoSocialEO eventoSocial, boolean bandera, GeozonaEO geozona) {

		logger.debug("El evento recibido es {}", eventoSocial);
		logger.debug("Bandera: {}", bandera);
		logger.debug("Geozona: {}", geozona);
		
		if (bandera) {
			eventoSocial.setNivel(geozona.getNivel());
		}
		if (eventoSocial.getFechaFin() == null) {
			eventoSocial.setFechaFin(eventoSocial.getFecha());
		}
		
		//Asignamos_nick_de_la_actualizacion
		eventoSocial.setNickActualizacion(getUsuario().getNick());
		
		//Actualizamos_el_evento_en_la_base_de_datos
		sqlSession.insert("eventos.eventos.actualizar", eventoSocial);
		logger.debug("El Evento social se actualizo correctamente");
		bitacorasC.insert(TiposAccionesDO.ACTUALIZAR, "Eventos", "Se actualizó el evento "+eventoSocial.getId()+" - "+eventoSocial.getNombre()+" a nivel "+eventoSocial.getNivel().getNombre(), getUsuario().getNick());
		
		//Eliminamos_las_llaves_territoriales,_para_volver_a_insertarlas
		sqlSession.insert("eventos.eventos.eliminarllaves", eventoSocial);
		logger.debug("Las llaves territoriales se eliminaron correctamente");
		
		
		for (JavaBeanT territorio : eventoSocial.getTerritorios()) {
			HashMap<String, Object> mapa = new HashMap<>();
			mapa.put("idEvento", eventoSocial.getId());
			switch (eventoSocial.getNivel()) {
			case ENTIDAD:
				mapa.put("llave", ((EntidadEO) territorio).getLlave());
				break;
			case MUNICIPIO:
				mapa.put("llave", ((MunicipioEO) territorio).getLlave());
				break;
			case DFEDERAL:
				mapa.put("llave", ((DFederalEO) territorio).getLlave());
				break;
			case DLOCAL:
				mapa.put("llave", ((DLocalEO) territorio).getLlave());
				break;
			case GEOZONA:
				mapa.put("llave", ((GeozonaParticionEO) territorio).getLlave());
				break;
			default:
				break;
			}
			sqlSession.insert("eventos.eventos.agregarllaves", mapa);
			bitacorasC.insert(TiposAccionesDO.ACTUALIZAR, "Eventos", "Se actualizaron las llaves del evento "+eventoSocial.getId()+" - "+eventoSocial.getNombre()+" a nivel "+eventoSocial.getNivel().getNombre(), getUsuario().getNick());
		}

	}
	
	public EventoSocialEO obtenerFechas(EventoSocialEO eventoSocial){
		
		eventoSocial.setFechaString(new Date(eventoSocial.getFecha().getTime()));
		eventoSocial.setFechaStringFin(new Date(eventoSocial.getFechaFin().getTime()));
		
		return eventoSocial;		
		
	}
	
	public Date getFecha(){
		return new Date();
	}
	
	public Modelo<JavaBeanT> modeloTerritoriosUsuario(){
		return usuariosC.modeloTerritorios(getUsuario());
	}
	
	//Metodos_para_filtro_en_calendario
	public Modelo<JavaBeanT> tablaCalendarioFiltro(Date fechaDesde, Date fechaHasta, DependenciaEO dependenciaSeleccionada, List<JavaBeanT> territoriosSeleccionados) {
		Modelo<JavaBeanT> tabla = new Modelo<>();
		List<JavaBeanT> listado = new ArrayList<>();
		List<EventoSocialEO> listadoEventoSocial = new ArrayList<>();
		
		listadoEventoSocial=tablaEventosSocialesFiltro(fechaDesde, fechaHasta, dependenciaSeleccionada, territoriosSeleccionados).getListado();
		if (!listadoEventoSocial.isEmpty()) {
			listado = sqlSession.selectList("eventos.calendarioEventos.listado",listadoEventoSocial);
		}
		tabla.setListado(listado);
		for (JavaBeanT cal : listado) {
			CalendarioEventoSocialEO calendario = (CalendarioEventoSocialEO) cal;
			logger.debug("Calendario {}", calendario);
			calendario.setId((int) (Math.random() * 100));
			cal = calendario;
		}
		return tabla;
	}
	
	public Modelo<EventoSocialEO> tablaEventosSocialesFiltro(Date fechaDesde, Date fechaHasta, DependenciaEO dependenciaSeleccionada, List<JavaBeanT> territoriosSeleccionados) {
		Modelo<EventoSocialEO> tabla = new Modelo<>();
		List<EventoSocialEO> listado = new ArrayList<>();
		//List<EventoSocialEO> listado2 = new ArrayList<>();
		List<JavaBeanT> territorios = new ArrayList<>();
		HashMap<String, Object> params;
		
		////////////////////////////////////////////////////////////////////////////
		logger.debug("EL usuario es {} y su dependencia seleccionada es {}",getUsuario(),dependenciaSeleccionada);
		params = new HashMap<>();
		params.put("dependencia", dependenciaSeleccionada);
		//params.put("nick", getUsuario().getNick());
		//Formateamos_la_fecha
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		params.put("fechaDesde", df.format(fechaDesde));
		params.put("fechaHasta", df.format(fechaHasta));
		
		if(!territoriosSeleccionados.isEmpty()){
			//Creamos_string_de_territorios
			/*StringBuilder territoriosStr = new StringBuilder();
			String aux = "";
			for(JavaBeanT obj : territoriosSeleccionados){
				switch (obj.getClass().getSimpleName()) {
				case "DfederalEO":
					
					break;
				case "DlocalEO":
					
					break;
				case "EntidadEO":
					EntidadEO entidad;
					entidad = (EntidadEO) obj;
					territoriosStr.append(aux);
					territoriosStr.append("'");
					territoriosStr.append(entidad.getId().toString());
					territoriosStr.append("'");
					break;
				case "GeozonaParticionEO":
					GeozonaParticionEO geozonaParticionEO;
					geozonaParticionEO = (GeozonaParticionEO) obj;
					territoriosStr.append(aux);
					territoriosStr.append("'");
					territoriosStr.append(geozonaParticionEO.getLlave());
					territoriosStr.append("'");
					break;
				case "LocalodadEO":
					break;
				case "ManzanaEO":
					break;
				case "MunicipioEO":
					MunicipioEO municipio;
					municipio = (MunicipioEO) obj;
					territoriosStr.append(aux);
					territoriosStr.append("'");
					territoriosStr.append(municipio.getLlave());
					territoriosStr.append("'");
					break;
				case "SeccionEO":
					break;
				}
				aux = ",";
			}
			params.put("territorios", territoriosStr.toString());
			*/
			params.put("territorios", territoriosSeleccionados);
			switch (territoriosSeleccionados.get(0).getClass().getSimpleName()) {
			case "DfederalEO":
				params.put("nivel", NivelesDO.DFEDERAL);
				break;
			case "DlocalEO":
				params.put("nivel", NivelesDO.DLOCAL);
				break;
			case "EntidadEO":
				params.put("nivel", NivelesDO.ENTIDAD);
				break;
			case "GeozonaParticionEO":
				params.put("nivel", NivelesDO.GEOZONA);
				break;
			case "LocalodadEO":
				params.put("nivel", NivelesDO.LOCALIDAD);
				break;
			case "ManzanaEO":
				params.put("nivel", NivelesDO.MANZANA);
				break;
			case "MunicipioEO":
				params.put("nivel", NivelesDO.MUNICIPIO);
				break;
			case "SeccionEO":
				params.put("nivel", NivelesDO.SECCION);
				break;
			}
		}
		
		
		//Consulta_por_dependencia_y_fecha
		listado = sqlSession.selectList("eventos.eventos.listadoFiltroPorDependenciaFechas", params);
		logger.debug("Listado: {}", listado);
		
		/*if(!territoriosSeleccionados.isEmpty()){
			//Consulta_por_territorios_y_fecha
			if(params.get("territorios").toString().length()<=4){
				listado2 = sqlSession.selectList("eventos.eventos.listadoFiltroPorTerritoriosFechasEntidad", params);
			}else{
				listado2 = sqlSession.selectList("eventos.eventos.listadoFiltroPorTerritoriosFechas", params);
			}
			logger.debug("listado2: {}", listado2);
		}
		
		if(!listado2.isEmpty() && !listado.isEmpty()){
			for(EventoSocialEO ev2 : listado2){
				if(!listado.contains(ev2)){
					listado.add(ev2);
				}
			}
		}else if(!listado2.isEmpty() && listado.isEmpty()){
			listado.addAll(listado2);
		}
		*/
		for (EventoSocialEO eventoSocial2 : listado) {	
			List<DependenciaEO> listadoDependencias = new ArrayList<>();
			List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
			listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial2);
			for (EventoEjercicioProgramaEO eventoEjercicioProgramaEO : listadoEventosProgramas) {
				boolean ban=true;
				for (DependenciaEO dependencia : listadoDependencias) {
					if (dependencia.equals(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia())){
						ban=false;
					}
				}
				if (ban) {
					listadoDependencias.add(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia());
				}
			}
			eventoSocial2.setDependencias(listadoDependencias);
			logger.debug("Del evento {} las dependencias son {}",eventoSocial2.getNombre(),listadoDependencias);
			Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas =new Modelo<>();
			tablaEjerciciosProgramas.setListado(listadoEventosProgramas);
			if (!listadoEventosProgramas.isEmpty()) {
				tablaEjerciciosProgramas.setSeleccionado(listadoEventosProgramas.get(0));
			}
			eventoSocial2.setTablaEjerciciosProgramas(tablaEjerciciosProgramas);
			
			
		}
		
		logger.debug("El listado es {}", listado);
		for (EventoSocialEO eventoSocial : listado) {
			logger.debug("El nivel es {}", eventoSocial.getNivel());
			switch (eventoSocial.getNivel()) {
			case NACIONAL:
				logger.debug("Todo El País");
				territorios = new ArrayList<>();
				break;
			case ENTIDAD:
				territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", eventoSocial);
				break;
			case MUNICIPIO:
				territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", eventoSocial);
				break;
			case DFEDERAL:
				territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", eventoSocial);
				break;
			case DLOCAL:
				territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", eventoSocial);
				break;
			case GEOZONA:
				territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", eventoSocial);
				break;
			default:
				break;
			}
			eventoSocial.setTerritorios(territorios);
		}
		
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}
	
	public void fechaVacia() {
		fecha= new String("");
	}
	public Modelo<EventoSocialEO> tablaEventosSocialesFiltroCalendario(DependenciaEO dependenciaSeleccionada, List<JavaBeanT> territoriosSeleccionados, Date fechaDesde, Date fechaHasta) {
		Modelo<EventoSocialEO> tabla = new Modelo<>();
		List<EventoSocialEO> listado = new ArrayList<>();
		//List<EventoSocialEO> listado2 = new ArrayList<>();
		List<JavaBeanT> territorios = new ArrayList<>();
		HashMap<String, Object> params;
		
		////////////////////////////////////////////////////////////////////////////
		logger.debug("EL usuario es {} y su dependencia seleccionada es {}",getUsuario(),dependenciaSeleccionada);
		params = new HashMap<>();
		params.put("dependencia", dependenciaSeleccionada);
		//params.put("nick", getUsuario().getNick());
		//Formateamos_la_fecha
		params.put("fecha", fecha);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		params.put("fechaDesde", df.format(fechaDesde));
		params.put("fechaHasta", df.format(fechaHasta));
		
		if(!territoriosSeleccionados.isEmpty()){
			//Creamos_string_de_territorios
			/*StringBuilder territoriosStr = new StringBuilder();
			String aux = "";
			for(JavaBeanT obj : territoriosSeleccionados){
				switch (obj.getClass().getSimpleName()) {
				case "DfederalEO":
					
					break;
				case "DlocalEO":
					
					break;
				case "EntidadEO":
					EntidadEO entidad;
					entidad = (EntidadEO) obj;
					territoriosStr.append(aux);
					territoriosStr.append("'");
					territoriosStr.append(entidad.getId().toString());
					territoriosStr.append("'");
					break;
				case "GeozonaParticionEO":
					GeozonaParticionEO geozonaParticionEO;
					geozonaParticionEO = (GeozonaParticionEO) obj;
					territoriosStr.append(aux);
					territoriosStr.append("'");
					territoriosStr.append(geozonaParticionEO.getLlave());
					territoriosStr.append("'");
					break;
				case "LocalodadEO":
					break;
				case "ManzanaEO":
					break;
				case "MunicipioEO":
					MunicipioEO municipio;
					municipio = (MunicipioEO) obj;
					territoriosStr.append(aux);
					territoriosStr.append("'");
					territoriosStr.append(municipio.getLlave());
					territoriosStr.append("'");
					break;
				case "SeccionEO":
					break;
				}
				aux = ",";
			}
			
			params.put("territorios", territoriosStr.toString());*/
			params.put("territorios", territoriosSeleccionados);
			switch (territoriosSeleccionados.get(0).getClass().getSimpleName()) {
			case "DfederalEO":
				params.put("nivel", NivelesDO.DFEDERAL);
				break;
			case "DlocalEO":
				params.put("nivel", NivelesDO.DLOCAL);
				break;
			case "EntidadEO":
				params.put("nivel", NivelesDO.ENTIDAD);
				break;
			case "GeozonaParticionEO":
				params.put("nivel", NivelesDO.GEOZONA);
				break;
			case "LocalodadEO":
				params.put("nivel", NivelesDO.LOCALIDAD);
				break;
			case "ManzanaEO":
				params.put("nivel", NivelesDO.MANZANA);
				break;
			case "MunicipioEO":
				params.put("nivel", NivelesDO.MUNICIPIO);
				break;
			case "SeccionEO":
				params.put("nivel", NivelesDO.SECCION);
				break;
			}
		}
		
		
		//Consulta_por_dependencia_y_fecha
		listado = sqlSession.selectList("eventos.eventos.listadoFiltroPorDependenciaFechas", params);
		logger.debug("Listado: {}", listado);
		
		/*if(!territoriosSeleccionados.isEmpty()){
			//Consulta_por_territorios_y_fecha
			if(params.get("territorios").toString().length()<=4){
				listado2 = sqlSession.selectList("eventos.eventos.listadoFiltroPorTerritoriosFechas2Entidad", params);
			}else{
				listado2 = sqlSession.selectList("eventos.eventos.listadoFiltroPorTerritoriosFechas2", params);
			}
			
			
			
//			listado2 = sqlSession.selectList("eventos.eventos.listadoFiltroPorTerritoriosFechas2", params);
			logger.debug("listado2: {}", listado2);
		}
		
		if(!listado2.isEmpty() && !listado.isEmpty()){
			for(EventoSocialEO ev2 : listado2){
				if(!listado.contains(ev2)){
					listado.add(ev2);
				}
			}
		}else if(!listado2.isEmpty() && listado.isEmpty()){
			listado.addAll(listado2);
		}
		*/
		for (EventoSocialEO eventoSocial2 : listado) {	
			List<DependenciaEO> listadoDependencias = new ArrayList<>();
			List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
			listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial2);
			for (EventoEjercicioProgramaEO eventoEjercicioProgramaEO : listadoEventosProgramas) {
				boolean ban=true;
				for (DependenciaEO dependencia : listadoDependencias) {
					if (dependencia.equals(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia())){
						ban=false;
					}
				}
				if (ban) {
					listadoDependencias.add(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia());
				}
			}
			eventoSocial2.setDependencias(listadoDependencias);
			logger.debug("Del evento {} las dependencias son {}",eventoSocial2.getNombre(),listadoDependencias);
			Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas =new Modelo<>();
			tablaEjerciciosProgramas.setListado(listadoEventosProgramas);
			if (!listadoEventosProgramas.isEmpty()) {
				tablaEjerciciosProgramas.setSeleccionado(listadoEventosProgramas.get(0));
			}
			eventoSocial2.setTablaEjerciciosProgramas(tablaEjerciciosProgramas);
			
			
		}
		
		logger.debug("El listado es {}", listado);
		for (EventoSocialEO eventoSocial : listado) {
			logger.debug("El nivel es {}", eventoSocial.getNivel());
			switch (eventoSocial.getNivel()) {
			case NACIONAL:
				logger.debug("Todo El País");
				territorios = new ArrayList<>();
				break;
			case ENTIDAD:
				territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", eventoSocial);
				break;
			case MUNICIPIO:
				territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", eventoSocial);
				break;
			case DFEDERAL:
				territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", eventoSocial);
				break;
			case DLOCAL:
				territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", eventoSocial);
				break;
			case GEOZONA:
				territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", eventoSocial);
				break;
			default:
				break;
			}
			eventoSocial.setTerritorios(territorios);
		}
		
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}
	
//	public Modelo<EventoSocialEO> modeloReportesEventosSociales(Date desde, Date hasta, DependenciaEO dependenciaSeleccionada, List<JavaBeanT> territoriosSeleccionados){
//		
//		Modelo<EventoSocialEO> tabla = new Modelo<>();
//		List<EventoSocialEO> listado = new ArrayList<>();
//		List<EventoSocialEO> listadoPorNick = new ArrayList<>();
//		List<EventoSocialEO> listadoFinal = new ArrayList<>();
//		List<JavaBeanT> territorios = new ArrayList<>();
//		HashMap<String, Object> params;
//		
//		////////////////////////////////////////////////////////////////////////////
//		logger.debug("EL usuario es {} y su dependencia es {}",getUsuario(),getUsuario().getDependencias());
//		if(!getUsuario().getDependencias().isEmpty()){//Si_existen_dependencias
//			params = new HashMap<>();
//			params.put("dependencias", getUsuario().getDependencias());
//			params.put("nick", getUsuario().getNick());
//			params.put("desde", desde);
//			params.put("hasta", hasta);
//			listado = sqlSession.selectList("eventos.eventos.buscarPorFechaCompletoReportes", params);
//			//Obtenemos_listado_por_el_nick_fecha
//			listadoPorNick = sqlSession.selectList("eventos.eventos.buscarPorFechaNick", params);
//		}else{//Si_no_existen_dependencias
//			params = new HashMap<>();
//			params.put("desde", desde);
//			params.put("hasta", hasta);
//			listado = sqlSession.selectList("eventos.eventos.buscarPorFechaCompletoDependenciasTodasReportes", params);
//		}
//		
//		//Obtenemos_los_programas_del_evento
//		for (EventoSocialEO eventoSocial2 : listado) {	
//			List<DependenciaEO> listadoDependencias = new ArrayList<>();
//			List<EventoEjercicioProgramaEO> listadoEventosProgramas = new ArrayList<>();
//			listadoEventosProgramas=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento",eventoSocial2);
//			for (EventoEjercicioProgramaEO eventoEjercicioProgramaEO : listadoEventosProgramas) {
//				boolean ban=true;
//				for (DependenciaEO dependencia : listadoDependencias) {
//					if (dependencia.equals(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia())){
//						ban=false;
//					}
//				}
//				if (ban) {
//					listadoDependencias.add(eventoEjercicioProgramaEO.getProgramaEjercicio().getPrograma().getDependencia());
//				}
//			}
//			eventoSocial2.setDependencias(listadoDependencias);
//			logger.debug("Del evento {} las dependencias son {}",eventoSocial2.getNombre(),listadoDependencias);
//			Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas =new Modelo<>();
//			tablaEjerciciosProgramas.setListado(listadoEventosProgramas);
//			if (!listadoEventosProgramas.isEmpty()) {
//				tablaEjerciciosProgramas.setSeleccionado(listadoEventosProgramas.get(0));
//			}
//			eventoSocial2.setTablaEjerciciosProgramas(tablaEjerciciosProgramas);
//			
//			
//		}
//		
//		if(!listadoPorNick.isEmpty()){
//			for(EventoSocialEO ev : listadoPorNick){
//				listadoFinal.add(ev);
//			}
//		}
//		
//		for(EventoSocialEO ev : listado){
//			listadoFinal.add(ev);
//		}
//		
//		
//		//Obtenemos_los_territorios_del_evento
//		logger.debug("El listado es {}", listadoFinal);
//		for (EventoSocialEO eventoSocial : listadoFinal) {
//			logger.debug("El nivel es {}", eventoSocial.getNivel());
//			switch (eventoSocial.getNivel()) {
//			case NACIONAL:
//				logger.debug("Todo El País");
//				territorios = new ArrayList<>();
//				break;
//			case ENTIDAD:
//				territorios = sqlSession.selectList("catalogos.entidades.listadoEvento", eventoSocial);
//				break;
//			case MUNICIPIO:
//				territorios = sqlSession.selectList("catalogos.municipios.listadoEvento", eventoSocial);
//				break;
//			case DFEDERAL:
//				territorios = sqlSession.selectList("catalogos.dFederales.listadoEvento", eventoSocial);
//				break;
//			case DLOCAL:
//				territorios = sqlSession.selectList("catalogos.dLocales.listadoEvento", eventoSocial);
//				break;
//			case GEOZONA:
//				territorios = sqlSession.selectList("catalogos.geozonas.listadoEvento", eventoSocial);
//				break;
//			default:
//				break;
//			}
//			eventoSocial.setTerritorios(territorios);
//		}
//		
//		tabla.setListado(listadoFinal);
//		
//		if (!listadoFinal.isEmpty()) {
//			tabla.setSeleccionado(listadoFinal.get(0));
//		}
//		return tabla;
//		
//	}
	
}