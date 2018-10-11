package com.saganet.politik.components.catalogos;

import java.text.Format;
import java.text.SimpleDateFormat;
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
import com.saganet.politik.components.log.BitacorasC;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.DLocalEO;
import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.ProgramaEO;
import com.saganet.politik.database.catalogos.ProgramaEjercicioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.dominios.TiposAccionesDO;
import com.saganet.politik.dominios.TiposEjerciciosFiscalesDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;

@Component("ProgramasEjerciciosC")
public class ProgramasEjerciciosC {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	BitacorasC bitacorasC;
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramasEjerciciosC.class);
	
	public Modelo<ProgramaEjercicioEO> modelo(ProgramaEO programa){
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
	
	public ProgramaEjercicioEO nuevo(ProgramaEO programa){
		ProgramaEjercicioEO nuevo;
		nuevo = new ProgramaEjercicioEO();
		nuevo.setIdPrograma(programa.getId());
		return nuevo;
	}
	
	public ProgramaEjercicioEO guardar(ProgramaEjercicioEO nuevo){
		logger.debug("ProgramaEjercicio Recibido: {}", nuevo);
		
		ProgramaEO programa;
		programa = sqlSession.selectOne("catalogos.programas.programaById", nuevo.getIdPrograma());
		
		//Formateamos_la_fecha
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		nuevo.setFechaInicio(formatter.format(nuevo.getIni()));
		nuevo.setFechaTermino(formatter.format(nuevo.getFin()));
		
		Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		nuevo.setNick(usuario.getUsuario().getNick());
		
		sqlSession.insert("catalogos.programasEjercicios.insertar", nuevo);
		logger.debug("El ProgramaEjercicio fue guardado correctamente: {}", nuevo);
		bitacorasC.insert(TiposAccionesDO.INSERTAR, "Programas", "Se inserto el Ejercicio "+nuevo.getEjercicio()+" al Programa "+programa.getId()+" - "+programa.getPrograma(),getUsuario().getNick());
		
		return nuevo;
	}
	
	public void guardarTerritorios(List<JavaBeanT> territorios, ProgramaEjercicioEO programaEjercicio) {
		logger.debug("Territorios: {}", territorios);
		HashMap<String, Object> params;
		
		Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		for(JavaBeanT jbt : territorios){
			params = new HashMap<>();
			logger.debug("OJBT: {}", jbt);
			logger.debug("Nombre de la clase: {}", jbt.getClass().getName()+"*********************************************");
			switch (jbt.getClass().getSimpleName()) {
			case "EntidadEO":
				params.put("idEjercicio", programaEjercicio.getId());
				params.put("llave", ((EntidadEO) jbt).getId());
				params.put("nick", usuario.getUsuario().getNick());
				logger.debug("Parametros para guardar territorios: {}", params);
				sqlSession.insert("catalogos.programasEjercicios.insertarProgramasEjerciciosLlaves",params);
				bitacorasC.insert(TiposAccionesDO.INSERTAR, "Programas", "Se agrego a nivel Entidad la llave "+jbt.getId()+" al ejercicio "+programaEjercicio.getId(), usuario.getUsuario().getNick());
				break;
				
			case "DFederalEO":
				params.put("idEjercicio", programaEjercicio.getId());
				params.put("llave", ((DFederalEO) jbt).getLlave());
				params.put("nick", usuario.getUsuario().getNick());
				logger.debug("Parametros para guardar territorios: {}", params);
				sqlSession.insert("catalogos.programasEjercicios.insertarProgramasEjerciciosLlaves",params);
				bitacorasC.insert(TiposAccionesDO.INSERTAR, "Programas", "Se agrego a nivel Dfederal la llave "+params.get("llave")+" al ejercicio "+programaEjercicio.getId(), usuario.getUsuario().getNick());
				break;
				
			case "DlocalEO":
				params.put("idEjercicio", programaEjercicio.getId());
				params.put("llave", ((DLocalEO) jbt).getLlave());
				params.put("nick", usuario.getUsuario().getNick());
				logger.debug("Parametros para guardar territorios: {}", params);
				sqlSession.insert("catalogos.programasEjercicios.insertarProgramasEjerciciosLlaves",params);
				bitacorasC.insert(TiposAccionesDO.INSERTAR, "Programas", "Se agrego a nivel Dlocal la llave "+params.get("llave")+" al ejercicio "+programaEjercicio.getId(), usuario.getUsuario().getNick());
				break;
				
			case "MunicipioEO":
				params.put("idEjercicio", programaEjercicio.getId());
				params.put("llave", ((MunicipioEO) jbt).getLlave());
				params.put("nick", usuario.getUsuario().getNick());
				logger.debug("Parametros para guardar territorios: {}", params);
				sqlSession.insert("catalogos.programasEjercicios.insertarProgramasEjerciciosLlaves",params);
				bitacorasC.insert(TiposAccionesDO.INSERTAR, "Programas", "Se agrego a nivel Municipio la llave "+params.get("llave")+" al ejercicio "+programaEjercicio.getId(), usuario.getUsuario().getNick());
				break;
				
			case "SeccionEO":
				params.put("idEjercicio", programaEjercicio.getId());
				params.put("llave", ((SeccionEO) jbt).getLlave());
				params.put("nick", usuario.getUsuario().getNick());
				logger.debug("Parametros para guardar territorios: {}", params);
				sqlSession.insert("catalogos.programasEjercicios.insertarProgramasEjerciciosLlaves",params);
				bitacorasC.insert(TiposAccionesDO.INSERTAR, "Programas", "Se agrego a nivel Seccion la llave "+params.get("llave")+" al ejercicio "+programaEjercicio.getId(), usuario.getUsuario().getNick());
				break;
				
			}
			
		}
		
	}
	
	public void eliminarEjercicio(ProgramaEjercicioEO programaEjercicio){
		logger.debug("ProgramaEjercicioEO Recibido: {}", programaEjercicio);
		try {
			sqlSession.delete("catalogos.programasEjercicios.eliminarProgramasEjerciciosLlaves",programaEjercicio.getId());
		} catch (Exception e) {
			logger.debug("No hay territorios para eliminar");
		}
		
		try{
			sqlSession.delete("catalogos.programasEjercicios.eliminarProgramasEjerciciosFuentes",programaEjercicio.getId());
		}catch(Exception e){
			logger.debug("No hay fuentes para eliminar");
		}
		
		sqlSession.delete("catalogos.programasEjercicios.eliminarEjercicio",programaEjercicio.getId());
		bitacorasC.insert(TiposAccionesDO.ELIMINAR, "Programas", "Se elimino el Ejercicio "+programaEjercicio.getId()+" - "+programaEjercicio.getEjercicio()+" del Programa "+programaEjercicio.getPrograma().getId()+" - "+programaEjercicio.getPrograma().getPrograma(), getUsuario().getNick());
		
		logger.debug("El Ejercicio se elimino correctamente, junto con los niveles mas bajos.");
	}
	
	public ProgramaEjercicioEO getProgramaEjercicioCompleto(ProgramaEjercicioEO ejercicio, DependenciaEO dependencia){
		logger.debug("Ejercicio recibido: {}", ejercicio);
		logger.debug("Dependencia Recibida: {}", dependencia);
		ejercicio.setTerritorios(consultaTerritorios(ejercicio, dependencia));
		return ejercicio;
	}
	
	public List<JavaBeanT> consultaTerritorios(ProgramaEjercicioEO ejercicio, DependenciaEO dependencia){
		
		List<JavaBeanT> territorios;
		String llaves = "";
		
		territorios = new ArrayList<>();
		
		try{
			llaves = sqlSession.selectOne("catalogos.programasEjercicios.listadoProgramasEjerciciosLlavesStr", ejercicio.getId());
		}catch(Exception e){
			logger.debug("No hay dependencias");
		}
		
		logger.debug("LLaves: {}", llaves);
		
		if(llaves!=null){
			switch (dependencia.getNivelGeografico()) {
			
			case ENTIDAD:
				territorios = sqlSession.selectList("catalogos.entidades.entidadInId",llaves);
				return territorios;
			case DFEDERAL:
				territorios = sqlSession.selectList("catalogos.dFederales.dfederalInLlaves", llaves);
				return territorios;
			case DLOCAL:
				territorios = sqlSession.selectList("catalogos.dLocales.dlocalInLlaves", llaves);
				return territorios;
			case MUNICIPIO:
				territorios = sqlSession.selectList("catalogos.municipios.municipioInLlaves", llaves);
				return territorios;
			case SECCION:
				territorios = sqlSession.selectList("catalogos.secciones.seccionInLlaves", llaves);
				return territorios;
			default:
				return territorios;
			}
		}else{
			return territorios;
		}
		
		
	}
	
	public TiposEjerciciosFiscalesDO[] listadoTiposEjerciciosFiscales(){
		logger.debug("Se genera listado de Tipos de Ejercicios Fiscales");
		return TiposEjerciciosFiscalesDO.values();
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
}
