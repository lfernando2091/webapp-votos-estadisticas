package com.saganet.politik.components.catalogos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.components.log.BitacorasC;
import com.saganet.politik.database.catalogos.ProgramaEO;
import com.saganet.politik.database.catalogos.ProgramaPoblacionObjetivoEO;
import com.saganet.politik.dominios.TiposAccionesDO;
import com.saganet.politik.dominios.TiposPoblacionObjetivoDO;
import com.saganet.politik.modelos.Modelo;

@Component("ProgramaPoblacionObjetivoC")
public class ProgramaPoblacionObjetivoC {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	BitacorasC BitacorasC;
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramaPoblacionObjetivoC.class);
	
	public Modelo<ProgramaPoblacionObjetivoEO> modelo(ProgramaEO programa){
		Modelo<ProgramaPoblacionObjetivoEO> modelo;
		List<ProgramaPoblacionObjetivoEO> listado;
		
		listado = sqlSession.selectList("catalogos.programasPoblacionObjectivo.listado", programa);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo poblaciones: {}", modelo);
		
		return modelo;
		
	}
	
	public Modelo<ProgramaPoblacionObjetivoEO> nuevoModelo(){
		Modelo<ProgramaPoblacionObjetivoEO> modelo;
		List<ProgramaPoblacionObjetivoEO> listado;
		
		listado = new ArrayList<>();
		modelo = new Modelo<>();
		
		modelo.setListado(listado);
		
		return modelo;
	}
	
	public Modelo<ProgramaPoblacionObjetivoEO> llenarModelo(Modelo<ProgramaPoblacionObjetivoEO> modelo, ProgramaPoblacionObjetivoEO nuevo){
		nuevo.setId(modelo.getListado().size()+1);
		modelo.getListado().add(nuevo);
		modelo.setSeleccionado(nuevo);
		logger.debug("Se agrego a la lista del modelo: {}", nuevo);
		logger.debug("Modelo: {}", modelo);
		return modelo;
	}
	
	public Modelo<ProgramaPoblacionObjetivoEO> desagregarModelo(Modelo<ProgramaPoblacionObjetivoEO> modelo, ProgramaPoblacionObjetivoEO aDesagregar){
		logger.debug("Modelo recibido: {}", modelo);
		logger.debug("Programa Recibido: {}", aDesagregar);
		
		modelo.getListado().remove(aDesagregar);
		
		if(!modelo.getListado().isEmpty()){
			modelo.setSeleccionado(modelo.getListado().get(0));
		}
		logger.debug("Modelo final: {}", modelo.getListado());
		return modelo;
	}
	
	public ProgramaPoblacionObjetivoEO nuevo(){
		ProgramaPoblacionObjetivoEO nuevo;
		nuevo = new ProgramaPoblacionObjetivoEO();
		return nuevo;
	}
	
	public void guardar(ProgramaEO programa, Modelo<ProgramaPoblacionObjetivoEO> modeloProgramaPoblacionObjetivo){
		logger.debug("Programa Recibido: {}", programa);
		logger.debug("Modelo Recibido: {}", modeloProgramaPoblacionObjetivo);
		Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		for(ProgramaPoblacionObjetivoEO obj : modeloProgramaPoblacionObjetivo.getListado()){
			obj.setNick(usuario.getUsuario().getNick());
			obj.setIdPrograma(programa.getId());
			sqlSession.insert("catalogos.programasPoblacionObjectivo.insertar", obj);
			BitacorasC.insert(TiposAccionesDO.INSERTAR, "Programas", "Se asigno la poblacion objetivo "+obj.getPoblacion()+" - "+obj.getBeneficiariosProyectados()+" al Programa "+programa.getId()+" - "+programa.getPrograma(), usuario.getUsuario().getNick());
		}
		
	}
	
	public TiposPoblacionObjetivoDO[] tiposPoblacionObjetivo(){
		logger.debug("Se genera listado de Tipos Población Objetivo");
		return TiposPoblacionObjetivoDO.values();
	}
	
}
