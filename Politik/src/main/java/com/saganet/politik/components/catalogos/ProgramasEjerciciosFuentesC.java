package com.saganet.politik.components.catalogos;

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
import com.saganet.politik.database.catalogos.ProgramaEjercicioEO;
import com.saganet.politik.database.catalogos.ProgramaEjercicioFuenteEO;
import com.saganet.politik.dominios.TiposAccionesDO;
import com.saganet.politik.dominios.TiposInversionDO;
import com.saganet.politik.modelos.Modelo;

@Component("ProgramasEjerciciosFuentesC")
public class ProgramasEjerciciosFuentesC {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	BitacorasC bitacoraC;
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramasEjerciciosFuentesC.class);
	
	public Modelo<ProgramaEjercicioFuenteEO> modelo(ProgramaEjercicioEO programaEjercicio){
		Modelo<ProgramaEjercicioFuenteEO> modelo;
		List<ProgramaEjercicioFuenteEO> listado;
		
		listado = sqlSession.selectList("catalogos.programasEjerciciosFuentes.listadoByIdEjercicio", programaEjercicio);
		logger.debug("listado ProgramasEjerciciosFuentes: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo ProgramasEjerciciosFuentes: {}",modelo);
		
		return modelo;
	}
	
	public ProgramaEjercicioFuenteEO nuevo(ProgramaEjercicioEO programaEjercicio){
		ProgramaEjercicioFuenteEO nuevo;
		nuevo = new ProgramaEjercicioFuenteEO();
		nuevo.setIdEjercicio(programaEjercicio.getId());
		return nuevo;
	}
	
	public ProgramaEjercicioFuenteEO guardar(ProgramaEjercicioFuenteEO nuevo){
		ProgramaEjercicioEO ejercicio;
		ejercicio = new ProgramaEjercicioEO();
		logger.debug("ProgramaEjercicioFuente Recibido: {}", nuevo);
		
		ejercicio = sqlSession.selectOne("catalogos.programasEjercicios.buscarID", nuevo.getIdEjercicio());
		Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		nuevo.setNick(usuario.getUsuario().getNick());
		
		sqlSession.insert("catalogos.programasEjerciciosFuentes.insertar", nuevo);
		bitacoraC.insert(TiposAccionesDO.INSERTAR, "Programas", "Se agrego el tipo de inversi�n "+ nuevo.getTipoInversion() + " al programa "+ejercicio.getPrograma().getPrograma()+" del ejercicio " + ejercicio.getEjercicio(), nuevo.getNick());
		logger.debug("El ProgramaEjercicioFuente fue guardado correctamente");
		return nuevo;
	}
	
	public void guardarSimple(ProgramaEjercicioFuenteEO nuevo){
		ProgramaEjercicioEO ejercicio;
		ejercicio = new ProgramaEjercicioEO();
		logger.debug("ProgramaEjercicioFuente Recibido: {}", nuevo);
		
		ejercicio = sqlSession.selectOne("catalogos.programasEjercicios.buscarID", nuevo.getIdEjercicio());
		Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		nuevo.setNick(usuario.getUsuario().getNick());
		
		sqlSession.insert("catalogos.programasEjerciciosFuentes.insertar", nuevo);
		bitacoraC.insert(TiposAccionesDO.INSERTAR, "Programas", "Se agrego el tipo de inversi�n "+ nuevo.getTipoInversion() + " al programa "+ejercicio.getPrograma().getPrograma()+" del ejercicio " + ejercicio.getEjercicio(), nuevo.getNick());
		logger.debug("El ProgramaEjercicioFuente fue guardado correctamente");
	}
	
	public TiposInversionDO[] listadoTiposInversion(){
		logger.debug("Se genera listado de Tipos de Inversion");
		return TiposInversionDO.values();
	}
	
	public void eliminar(ProgramaEjercicioFuenteEO programaEjercicioFuenteEO){
		ProgramaEjercicioEO ejercicio;
		ejercicio = new ProgramaEjercicioEO();
		
		
		
		logger.debug("ProgramaEjercicioFuenteEO Recibido: {}", programaEjercicioFuenteEO);
		ejercicio = sqlSession.selectOne("catalogos.programasEjercicios.buscarID", programaEjercicioFuenteEO.getIdEjercicio());
		sqlSession.delete("catalogos.programasEjerciciosFuentes.eliminar",programaEjercicioFuenteEO.getId());
		bitacoraC.insert(TiposAccionesDO.ELIMINAR, "Programas", "Se elimin� el tipo de inversi�n "+ programaEjercicioFuenteEO.getTipoInversion() + " del programa " + ejercicio.getPrograma().getPrograma() + " en el ejercicio " + ejercicio.getEjercicio() , programaEjercicioFuenteEO.getNick());
		logger.debug("La fuente se elimino correctamente");
	}
	
	public Double totalMonto(List<ProgramaEjercicioFuenteEO> listado){
		Double total = (double) 0;
		for(ProgramaEjercicioFuenteEO obj : listado){
			total = total + obj.getMonto();
		}
		return total;
	}
	
	public void actualizar(ProgramaEjercicioFuenteEO programaEjercicioFuenteEO){
		ProgramaEjercicioEO ejercicio;
		ejercicio = new ProgramaEjercicioEO();
		ejercicio = sqlSession.selectOne("catalogos.programasEjercicios.buscarID", programaEjercicioFuenteEO.getIdEjercicio());
		
		logger.debug("ProgramaEjercicioFuente recibido para actualizar: {}", programaEjercicioFuenteEO);
		programaEjercicioFuenteEO.setNickActualizacion(getUsuario().getNick());
		sqlSession.update("catalogos.programasEjerciciosFuentes.actualizar", programaEjercicioFuenteEO);
		bitacoraC.insert(TiposAccionesDO.ACTUALIZAR, "Programas", "Se actualizo el tipo de inversi�n "+ programaEjercicioFuenteEO.getTipoInversion() + " al programa "+ejercicio.getPrograma().getPrograma()+" del ejercicio " + ejercicio.getEjercicio(), getUsuario().getNick());
		logger.debug("El ProgramaEjercicioFuente se a actualizado correctamnete");
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
}
