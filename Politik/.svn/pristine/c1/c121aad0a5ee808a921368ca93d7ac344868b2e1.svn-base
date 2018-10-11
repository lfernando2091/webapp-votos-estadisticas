package com.saganet.politik.components.catalogos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContextHolder;

import com.saganet.politik.database.catalogos.PartidoEO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.modelos.catalogos.PartidosT;

@Component("CatalogosPartidosC")
public class PartidosC {
	private static final Logger logger = LoggerFactory.getLogger(PartidosC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<PartidoEO> modelo(){
		Modelo<PartidoEO> modelo;
		List<PartidoEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.partidos.listado");
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public PartidoEO partidoPorId(Integer idPartido){
		PartidoEO partido;
		
		partido = sqlSession.selectOne("catalogos.partidos.porId", idPartido);
		
		return partido;
	}
	
	public PartidosT tabla(){
		PartidosT tabla;
		List<PartidoEO> listado;
		
		tabla = new PartidosT();
		
		listado = sqlSession.selectList("catalogos.partidos.listado");
		tabla.setListado(listado);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se genera listado de Partidos: {}", listado);
		return tabla;
	}
	
	public PartidoEO nuevo(){
		PartidoEO partido;
		
		partido = new PartidoEO();
		
		return partido;
	}
	
	public void insertar(PartidoEO partido){
		MessageContext messageContext;
		
		messageContext = RequestContextHolder.getRequestContext().getMessageContext();
		
		if(partido.getId() == null){
			sqlSession.insert("catalogos.partidos.insertar", partido);
			logger.debug("Se insertar Partido: {}", partido);
			messageContext.addMessage(new MessageBuilder().info().defaultText("Partido Agregado").build());
		} else {
			sqlSession.update("catalogos.partidos.actualizar", partido);
			logger.debug("Se actualiza Partido: {}", partido);
			messageContext.addMessage(new MessageBuilder().info().defaultText("Partido Actualizado").build());
		}
	}
	
	public PartidosT tablaModeloDual(boolean coaliciones, PartidoEO partido){
		PartidosT tabla;
		DualListModel<PartidoEO> modelo;
		List<PartidoEO> source, target;
		
		tabla = new PartidosT();
		source = sqlSession.selectList("catalogos.partidos.listado", coaliciones);
		
		if(partido.getId() == null){
			target = new ArrayList<PartidoEO>();
		} else {
			target = partido.getPartidosCoalicion();
			for(PartidoEO pt : target){
				for(PartidoEO ps : source){
					if(ps.equals(pt)){
						source.remove(pt);
						break;
					}
				}
			}
		}
		
		modelo = new DualListModel<PartidoEO>(source, target);
		
		tabla.setModeloDual(modelo);
		
		return tabla;
	}
	
	public PartidosT tablaModeloDual(){
		PartidosT tabla;
		DualListModel<PartidoEO> modelo;
		List<PartidoEO> source, target;
		
		tabla = new PartidosT();
		
		target = new ArrayList<PartidoEO>();
		
		source = sqlSession.selectList("catalogos.partidos.listado");
		
		modelo = new DualListModel<PartidoEO>(source, target);
		
		tabla.setModeloDual(modelo);
		
		return tabla;
	}
	
	public void insertarCoalicion(PartidoEO partido, List<PartidoEO> listado){
		logger.debug("Ingresando a la funcion");
		
		MessageContext messageContext;
		HashMap<String, Object> mapa;
		boolean principal;
		StringTokenizer tokenizer, tokenizer2;
		String token, token2;
		List<String> combinaciones;
		String idCoalicion;
		StringBuilder combinacion, auxNombre;
		String auxComa;
		PartidoEO coalicion;
		
		messageContext = RequestContextHolder.getRequestContext().getMessageContext();
		
		principal = true;
		if(partido.getId() != null){
			principal = false;
			for(PartidoEO pActual : partido.getPartidosCoalicion()){
				for(PartidoEO pListado : listado){
					if(pListado.equals(pActual)){
						listado.remove(pActual);
						break;
					}
				}
			}
		}
		
		insertar(partido);
		mapa = new HashMap<String, Object>();
		mapa.put("idCoalicion", partido.getId());
		
		for(PartidoEO p : listado){
			mapa.put("idPartido", p.getId());
			mapa.put("principal", principal);
			principal = false;
			sqlSession.insert("catalogos.partidos.insertarCoalicion", mapa);
		}
		
		sqlSession.update("catalogos.partidos.generarCombinaciones", partido);
		
		partido.setCombinaciones((String) sqlSession.selectOne("catalogos.partidos.combinacionesPorPartido", partido));
		tokenizer = new StringTokenizer(partido.getCombinaciones(), ",");
		combinaciones = new ArrayList<>();
		while(tokenizer.hasMoreTokens()){
			token = tokenizer.nextToken();
			if(token.indexOf(";") == -1){
				combinaciones.add(token);
			} else {
				token = token.replaceAll(";", ",");
				idCoalicion = null;
				idCoalicion = sqlSession.selectOne("catalogos.partidos.idCoalicionPorCombinacion", token);
				if(idCoalicion != null){
					combinaciones.add(idCoalicion);
				} else {
					coalicion = new PartidoEO();
					coalicion.setCoalicion(true);
					coalicion.setPartidosCoalicion(new ArrayList<PartidoEO>());
					tokenizer2 = new StringTokenizer(token, ",");
					while(tokenizer2.hasMoreTokens()){
						token2 = tokenizer2.nextToken();
						for(PartidoEO p : partido.getPartidosCoalicion()){
							if(p.getId().toString().equals(token2)){
								coalicion.getPartidosCoalicion().add(p);
								break;
							}
						}
					}
					auxNombre = new StringBuilder();
					auxComa = "";
					for(PartidoEO p : coalicion.getPartidosCoalicion()){
						auxNombre.append(auxComa);
						auxNombre.append(p.getSiglas());
						auxComa = "-";
					}
					coalicion.setNombre(auxNombre.toString());
					coalicion.setSiglas(auxNombre.toString());
					insertarCoalicion(coalicion, coalicion.getPartidosCoalicion());
					combinaciones.add(coalicion.getId().toString());
				}
			}
		}
		combinacion = new StringBuilder();
		auxComa = "";
		if(!combinaciones.isEmpty()){
			for(String c : combinaciones){
				combinacion.append(auxComa);
				combinacion.append(c);
				auxComa = ",";
			}
		}
		partido.setCombinaciones(combinacion.toString());
		sqlSession.update("catalogos.partidos.actualizarCombinacionesPorPartido", partido);
		
		messageContext.addMessage(new MessageBuilder().info().defaultText("Coalición Generada").build());
	}
}
