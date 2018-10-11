package com.saganet.politik.components.estructuras;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.beans.estructuras.CapturaB;
import com.saganet.politik.components.catalogos.ComisionesCongresoUnionC;
import com.saganet.politik.components.catalogos.DFederalesC;
import com.saganet.politik.components.catalogos.DLocalesC;
import com.saganet.politik.components.catalogos.EntidadesC;
import com.saganet.politik.components.catalogos.GeozonasC;
import com.saganet.politik.components.catalogos.MunicipiosC;
import com.saganet.politik.components.catalogos.PartidosC;
import com.saganet.politik.components.catalogos.SeccionesC;
import com.saganet.politik.components.mdm.PersonasC;
import com.saganet.politik.database.catalogos.ComisionCongresoUnionEO;
import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.DLocalEO;
import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.catalogos.EleccionEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.GeozonaEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.PartidoEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.database.catalogos.TablaParticionEO;
import com.saganet.politik.database.estructuras.CapturaEO;
import com.saganet.politik.database.estructuras.EstructuraEO;
import com.saganet.politik.database.estructuras.FiguraAtributoEO;
import com.saganet.politik.database.estructuras.FiguraEO;
import com.saganet.politik.database.estructuras.LegislaturaEO;
import com.saganet.politik.database.estructuras.NodoEO;
import com.saganet.politik.database.estructuras.ProgramaPromocionEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.database.mdm.TablaPersonaEO;
import com.saganet.politik.dominios.CargosComisionCongresoUnionDO;
import com.saganet.politik.dominios.FiguraAtributosDO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.TiposCampoDO;
import com.saganet.politik.dominios.TiposSenadorDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.utilidades.Formateador;

@Component("EstructurasCapturaC")
public class CapturaC {
	private static final Logger logger = LoggerFactory.getLogger(CapturaC.class);

	@Autowired
	SqlSession sqlSession;
	
	@Autowired PersonasC personasC;
	
	@Autowired EntidadesC entidadesC;
	@Autowired DFederalesC dFederalesC;
	@Autowired DLocalesC dLocalesC;
	@Autowired MunicipiosC municipiosC;
	@Autowired SeccionesC seccionesC;
	@Autowired GeozonasC geozonasC;
	@Autowired LegislaturasC legislaturasC;
	@Autowired PartidosC partidosC;
	@Autowired ComisionesCongresoUnionC comisionesCongresoUnionC;
	@Autowired EstructurasC estructurasC;
	@Autowired FigurasC figurasC;
		
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> iniciarMapaCaptura(RequestContext context){
		EstructuraEO estructura;
		EleccionEO eleccion;
		DependenciaEO dependencia;
		Modelo<EstructuraEO> modeloEstructuras;
		Modelo<DependenciaEO> modeloDependencias;
		Modelo<EleccionEO> modeloElecciones;
		HashMap<String, Object> viewScope, mapaCaptura;
		List<HashMap<String, Object>> superiores;

		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		modeloEstructuras = (Modelo<EstructuraEO>) viewScope.get("modeloEstructuras");
		mapaCaptura = new HashMap<>();
		superiores = new ArrayList<>();
		
		estructura = modeloEstructuras.getSeleccionado();
		mapaCaptura.put("superiores", superiores);
		mapaCaptura.put("nivel", new Integer(1));
		mapaCaptura.put("estructura", estructura);
		mapaCaptura.put("personaPadre", null);
		mapaCaptura.put("objetoSeleccionado", null);
		mapaCaptura.put("idPolitikRequest", null);
		mapaCaptura.put("idNodoRequest", null);
		
		switch(estructura.getAmbito()){
		case DEPENDENCIA:
			modeloDependencias = (Modelo<DependenciaEO>) viewScope.get("modeloDependencias");
			dependencia = modeloDependencias.getSeleccionado();
			mapaCaptura.put("dependencia", dependencia);
			break;
		case ELECCION:
			modeloElecciones = (Modelo<EleccionEO>) viewScope.get("modeloElecciones");
			eleccion = modeloElecciones.getSeleccionado();
			mapaCaptura.put("eleccion", eleccion);
			break;
		case DEPENDENCIAS:
			break;
		case GENERAL:
			break;
		}
		
		actualizarMapaCaptura(mapaCaptura);

		return mapaCaptura;
	}
	
	@SuppressWarnings("unchecked")
	public void actualizarMapaCaptura(HashMap<String, Object> mapaCaptura){
		HashMap<String, Object> parametros; //, objetoSeleccionado;
		HashMap<String, List<HashMap<String, Object>>> tablasEstructura;
		List<HashMap<String, Object>> listadoEstructura, superiores;
		List<NodoEO> nodos;
		NodoEO nodoPadre;
		PersonaEO personaPadre;
		JavaBeanT territorio, territorioPadre;
		int index;
		
		parametros = new HashMap<>();
		tablasEstructura = new HashMap<>();
		//objetoSeleccionado = new HashMap<>();
		
		superiores = (List<HashMap<String, Object>>) mapaCaptura.get("superiores");
		nodoPadre = null;
		personaPadre = null;
		
		if(!superiores.isEmpty()){
			index = superiores.size() - 1;
			nodoPadre = (NodoEO) superiores.get(index).get("nodo");
			personaPadre = (PersonaEO) superiores.get(index).get("persona");
			territorioPadre = (JavaBeanT) superiores.get(index).get("territorio");
		}
		
		nodos = nodosPorNivel((Integer) mapaCaptura.get("nivel"), nodoPadre, (EstructuraEO) mapaCaptura.get("estructura"));
		mapaCaptura.put("nodos", nodos);
		
		parametros.put("estructura", mapaCaptura.get("estructura"));
		parametros.put("personaPadre", personaPadre);
		
		for(NodoEO nodo : nodos){
			parametros.put("nodo", nodo);
			listadoEstructura = sqlSession.selectList("estructuras.tablaEstructura.listadoPorNodo", parametros);
			for(HashMap<String, Object> registro : listadoEstructura){
				registro.put("persona", personasC.personaSimplePorId((Integer) registro.get("id_persona"), (Integer) registro.get("id_entidad_nacimiento")));
				registro.put("nodo", nodo);
				territorio = null;
				switch(nodo.getFigura().getNivel()){
				case DFEDERAL:
					territorio = dFederalesC.buscarPorLlave((String) registro.get("llave"));
					break;
				case DLOCAL:
					territorio = dLocalesC.buscarPorLlave((String) registro.get("llave"));
					break;
				case ENTIDAD:
					territorio = entidadesC.buscarPorLlave((String) registro.get("llave"));
					break;
				case GEOZONA:
					territorio = geozonasC.buscarParticionPorLlave((String) registro.get("llave"));
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					territorio = municipiosC.buscarPorLlave((String) registro.get("llave"));
					break;
				case NACIONAL:
					break;
				case SECCION:
					territorio = seccionesC.buscarPorLlave((String) registro.get("llave"));
					break;
				}
				registro.put("territorio", territorio);
			}
			tablasEstructura.put("nodo_" + nodo.getId(), listadoEstructura);
			/*
			if(!listadoEstructura.isEmpty()){
				//objetoSeleccionado.put("nodo_" + nodo.getId(), listadoEstructura.get(0));
				objetoSeleccionado = listadoEstructura.get(0);
			} else {
				//objetoSeleccionado.put("nodo_" + nodo.getId(), new HashMap<>());
				objetoSeleccionado = new HashMap<>();
			}
			*/
		}
		//logger.debug("objetoSeleccionado: {}", objetoSeleccionado);
		mapaCaptura.put("tablasEstructura", tablasEstructura);
		mapaCaptura.put("objetoSeleccionado", null);
		//mapaCaptura.put("objetoSeleccionado", objetoSeleccionado);
	}
	
	@SuppressWarnings("unchecked")
	public void actualizarMapaCaptura(HashMap<String, Object> mapaCaptura, Integer nivel, PersonaEO personaPadre, NodoEO nodo, JavaBeanT territorioPadre){
		HashMap<String, Object> superior;
		
		if(nivel.compareTo((Integer) mapaCaptura.get("nivel")) > 0){
			superior = new HashMap<>();
			
			superior.put("nivel", nivel);
			superior.put("nodo", nodo);
			superior.put("persona", personaPadre);
			superior.put("territorio", territorioPadre);
			((List<HashMap<String, Object>>) mapaCaptura.get("superiores")).add(superior);
		}
		
		mapaCaptura.put("nivel", nivel);
		mapaCaptura.put("personaPadre", personaPadre);

		actualizarMapaCaptura(mapaCaptura);
	}
	
	@SuppressWarnings("unchecked")
	public void actualizarMapaCaptura(HashMap<String, Object> mapaCaptura, Integer nivel, CapturaEO capturaCRUD){
		HashMap<String, Object> superior;
		
		if(nivel.compareTo((Integer) mapaCaptura.get("nivel")) > 0){
			superior = new HashMap<>();
			
			superior.put("nivel", nivel);
			superior.put("nodo", capturaCRUD.getNodo());
			superior.put("persona", capturaCRUD.getPersona());
			superior.put("territorio", capturaCRUD.getTerritorio());
			((List<HashMap<String, Object>>) mapaCaptura.get("superiores")).add(superior);
		}
		
		mapaCaptura.put("nivel", nivel);
		//mapaCaptura.put("personaPadre", capturaCRUD.getPersona());

		actualizarMapaCaptura(mapaCaptura);
	}
	
	@SuppressWarnings("unchecked")
	public void avanzarNivel(HashMap<String, Object> mapaCaptura, CapturaB capturaB){
		EstructuraEO estructura;
		Integer nivel, idNodoRequest, idPolitikRequest;
		List<NodoEO> nodos;
		NodoEO nodo, nodoPadre;
		HashMap<String, Object> objetoSeleccionado;
		PersonaEO persona;
		List<HashMap<String, Object>> superiores;
		HashMap<String, Object> superior;
		int index;
		HashMap<String, List<HashMap<String, Object>>> tablasEstructura;
		List<HashMap<String, Object>> listadoEstructura;
		JavaBeanT territorio, territorioPadre;
		
		try {
		estructura = (EstructuraEO) mapaCaptura.get("estructura");
		nivel = (Integer) mapaCaptura.get("nivel");
		
		nodoPadre = null;
		territorioPadre = null;
		superiores = (List<HashMap<String, Object>>) mapaCaptura.get("superiores");
		if(!superiores.isEmpty()){
			index = superiores.size() - 1;
			superior = superiores.get(index);
			nodoPadre = (NodoEO) superior.get("nodo");
			territorioPadre = (JavaBeanT) superior.get("territorio");
		}
		
		//nodos = nodosPorNivel(nivel.intValue()+1, nodoPadre, estructura);
		logger.debug("*************************");
		//idPolitikRequest = (Integer) mapaCaptura.get("idPolitikRequest");
		//objetoSeleccionado = (HashMap<String, Object>) mapaCaptura.get("objetoSeleccionado");
		objetoSeleccionado = capturaB.getSeleccionado();
		//logger.debug("objetosSeleccionados size: {}", objetoSeleccionado.size());
		logger.debug("objetoSeleccionado: {}", objetoSeleccionado);
		//logger.debug("CapturaBean Seleccionado: {}", capturaB.getSeleccionado());
		//logger.debug("idPolitkRequest: {}", idPolitikRequest);
		
		nodo = null;
		//idNodoRequest = (Integer) mapaCaptura.get("idNodoRequest");
		nodo = (NodoEO) objetoSeleccionado.get("nodo");
		logger.debug("Nodo: {}", nodo);
		nodos = nodosPorNivel(nivel.intValue()+1, nodo, estructura); // check
		//for(NodoEO n : estructura.getNodos()){
			//if(n.getId().equals(idNodoRequest)){
				//nodo = n;
			//}
		//}
		
		///*
		//logger.debug("Nodo localizado: {}", nodo.getId());
		tablasEstructura = (HashMap<String, List<HashMap<String, Object>>>) mapaCaptura.get("tablasEstructura");
		listadoEstructura = tablasEstructura.get("nodo_" + nodo.getId());
		
		persona = (PersonaEO) objetoSeleccionado.get("persona");
		territorio = (JavaBeanT) objetoSeleccionado.get("territorio");
		//for(HashMap<String, Object> datos :  listadoEstructura){
			//if(idPolitikRequest.equals(datos.get("id_politik"))){
				//persona = (PersonaEO) datos.get("persona");
				//break;
			//}
		//}
		
		
		logger.debug("Persona Seleccionada: {}", persona);
		//logger.debug("Nodo Seleccionado: {}", nodo.getId());
		logger.debug("*************************");
		
		//nodo = (NodoEO) objetosSeleccionados.get(repeatIndex).get("nodo");
		//persona = (PersonaEO) objetosSeleccionados.get(repeatIndex).get("persona");
		//persona = (PersonaEO) ((HashMap<String, Object>) objetoSeleccionado.get("nodo_" + nodo.getId())).get("persona");
		
		if(!nodos.isEmpty())
			actualizarMapaCaptura(mapaCaptura, nivel.intValue()+1, persona, nodo, territorio);
		else
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No hay M�s Niveles en la Estructura", "Fin de Cadena"));
		} catch(Exception e){
			e.printStackTrace();
		}
		
		//*/
	}
	
	@SuppressWarnings("unchecked")
	public void regresarNivel(HashMap<String, Object> mapaCaptura) {
		Integer nivel;
		List<HashMap<String, Object>> superiores;
		HashMap<String, Object> superior;
		PersonaEO persona;
		NodoEO nodo;
		JavaBeanT territorio;
		int index;
		
		nivel = (Integer) mapaCaptura.get("nivel");
		superiores = (List<HashMap<String, Object>>) mapaCaptura.get("superiores");
		
		persona = null;
		nodo = null;
		territorio = null;
		if(!superiores.isEmpty()){
			index = superiores.size()-1;
			superiores.remove(index);
			if(!superiores.isEmpty()){
				superior = superiores.get(index-1);
				persona = (PersonaEO) superior.get("persona");
				nodo = (NodoEO) superior.get("nodo");
				territorio = (JavaBeanT) superior.get("territorio");
			}
		}
		
		actualizarMapaCaptura(mapaCaptura, nivel.intValue()-1, persona, nodo, territorio);
	}
	
	public List<NodoEO> nodosPorNivel(Integer nivel, NodoEO nodoPadre, EstructuraEO estructura){
		List<NodoEO> listado;
		HashMap<String, Object> parametros;
		FiguraEO figura;
		List<FiguraAtributosDO> atributos;
		
		parametros = new HashMap<>();
		
		parametros.put("nodoPadre", nodoPadre);
		parametros.put("nivel", nivel);
		parametros.put("estructura", estructura);
		
		listado = sqlSession.selectList("estructuras.nodos.porEstructuraPadreYNivel", parametros);
		
		//Completar Figuras
		for(NodoEO nodo : listado){
			figura = nodo.getFigura();
			atributos = sqlSession.selectList("estructuras.figuras.listadoAtributos", figura);
			figura.setAtributos(atributos);
		}
		
		//Verificar Figuras Jer�rquicas
		/*
		figuraRecursiva: if (listado.isEmpty()) {
			for (int i = nivel; i > 0; i--) {
				logger.debug("�ndice: {}", i);
				for (NodoEO nodo : estructura.getNodos()) {
					logger.debug("Nodo: {}", nodo);
					if (nodo.getNivel().equals(i) && nodo.getFigura().getJerarquico()) {
						listado.add(nodo);
					}
				}
				if (!listado.isEmpty()) {
					break figuraRecursiva;
				}
			}
		}
		*/
		
		if(listado.isEmpty() && nodoPadre != null){
			if(nodoPadre.getFigura().getJerarquico()){
				listado.add(nodoPadre);
			}
		}
		
		logger.debug("listado de nodos por nivel: {}", listado);
		
		return listado;
	}
	
	public CapturaEO nuevaCaptura(){
		CapturaEO captura;
		
		captura = new CapturaEO();
		
		return captura;
	}
	
	public CapturaEO nuevaCaptura(Integer idNodoRequest){
		CapturaEO captura;
		NodoEO nodo;
		FiguraEO figura;
		List<FiguraAtributosDO> atributos;
		
		captura = new CapturaEO();
		//try{
		if(idNodoRequest != null){
			nodo = sqlSession.selectOne("estructuras.nodos.porId", idNodoRequest);
			figura = nodo.getFigura();
			
			if(figura.getNivel().equals(NivelesDO.GEOZONA)){
				figura.setGeozona(geozonasC.obtenerGeozona(figura.getIdGeozona()));
			}
			
			atributos = sqlSession.selectList("estructuras.figuras.listadoAtributos", figura);
			figura.setAtributos(atributos);
			captura.setNodo(nodo);
			List<FiguraAtributoEO> lista;
			if(!atributos.isEmpty()){
				for(FiguraAtributosDO atributo : atributos){
					switch(atributo){
					case LEGISLATURA:
					case PROGRAMA_PROMOCION:
					case COMISION_CAMARA_SENADORES:
						captura.getMapaAtributos().put(atributo.name(), new ArrayList<FiguraAtributoEO>());
						break;
					case PERIODO:
					case PARTIDO_POLITICO:
					case TIPO_SENADOR:
						lista = new ArrayList<FiguraAtributoEO>();
						lista.add(new FiguraAtributoEO());
						captura.getMapaAtributos().put(atributo.name(), lista);
						break;
					}
				}
			}
		}
		//} catch(Exception e){e.printStackTrace();}
		
		return captura;
	}
	
	public CapturaEO editarCaptura(HashMap<String, Object> seleccionado){
		CapturaEO captura;
		List<FiguraAtributosDO> atributos;
		
		captura = new CapturaEO();
		
		captura.setTerritorio((JavaBeanT) seleccionado.get("territorio"));
		captura.setId((Integer) seleccionado.get("id_politik"));
		captura.setNodo((NodoEO) seleccionado.get("nodo"));
		captura.setPersona((PersonaEO) seleccionado.get("persona"));
		
		if(captura.getNodo().getFigura().getNivel().equals(NivelesDO.GEOZONA)){
			captura.getNodo().getFigura().setGeozona(geozonasC.obtenerGeozona(captura.getNodo().getFigura().getIdGeozona()));
		}
		
		atributos = sqlSession.selectList("estructuras.figuras.listadoAtributos", captura.getNodo().getFigura());
		captura.getNodo().getFigura().setAtributos(atributos);
		List<FiguraAtributoEO> lista;
		if(!atributos.isEmpty()){
			for(FiguraAtributosDO atributo : atributos){
				switch(atributo){
				case LEGISLATURA:
				case PROGRAMA_PROMOCION:
				case COMISION_CAMARA_SENADORES:
					captura.getMapaAtributos().put(atributo.name(), new ArrayList<FiguraAtributoEO>());
					break;
				case PERIODO:
				case PARTIDO_POLITICO:
				case TIPO_SENADOR:
					lista = new ArrayList<FiguraAtributoEO>();
					lista.add(new FiguraAtributoEO());
					captura.getMapaAtributos().put(atributo.name(), lista);
					break;
				}
			}
		}
		
		return captura;
	}
	
	public void verificarDuplicado(HashMap<String, Object> mapaCaptura, CapturaEO capturaCRUD){
		EstructuraEO estructura;
		HashMap<String, Object> parametros, respuesta;
		
		parametros = new HashMap<>();
		estructura = (EstructuraEO) mapaCaptura.get("estructura");
		
		parametros.put("esquema", "warehouse");
		parametros.put("tabla", "estructura_" + estructura.getId());
		parametros.put("persona", capturaCRUD.getPersona());
		parametros.put("nodo", capturaCRUD.getNodo());
		
		//Llenar Objeto Captura
		respuesta = sqlSession.selectOne("estructuras.tablaEstructura.buscarPersona", parametros);
		if(respuesta == null){
			return;
		}
		
		capturaCRUD.setId((Integer) respuesta.get("id_politik"));
		
		switch(capturaCRUD.getNodo().getFigura().getNivel()){
		case CASILLA:
			break;
		case DFEDERAL:
			break;
		case DLOCAL:
			break;
		case ENTIDAD:
			capturaCRUD.setTerritorio(entidadesC.buscarPorId(Integer.parseInt((String)respuesta.get("llave"))));
			break;
		case GEOZONA:
			break;
		case LOCALIDAD:
			break;
		case MANZANA:
			break;
		case MUNICIPIO:
			break;
		case NACIONAL:
			break;
		case SECCION:
			break;
		}
		
		llenarAtributos(estructura, capturaCRUD);
	}
	
	public void llenarAtributos(EstructuraEO estructura, CapturaEO capturaCRUD){
		HashMap<String, Object> parametros, registroAtributo;
		List<HashMap<String, Object>> listado;
		LegislaturaEO legislatura;
		PartidoEO partido;
		FiguraAtributoEO figuraAtributo;
		Formateador formateador;
		ComisionCongresoUnionEO comision;
		
		formateador = new Formateador();
		
		parametros = new HashMap<>();
		
		parametros.put("esquema", "warehouse");
		parametros.put("tabla", "estructura_" + estructura.getId());
		parametros.put("persona", capturaCRUD.getPersona());
		parametros.put("nodo", capturaCRUD.getNodo());
		
		parametros.put("tabla", "estructura_" + estructura.getId() + "_atributos");
		parametros.put("idPolitikPadre", capturaCRUD.getId());
		switch(estructura.getAmbito()){
		case DEPENDENCIA:
			break;
		case DEPENDENCIAS:
			break;
		case ELECCION:
			break;
		case GENERAL:
			for(FiguraAtributosDO atributo : capturaCRUD.getNodo().getFigura().getAtributos()){
				parametros.put("tipoAtributo", atributo.name());
				switch(atributo){
				case LEGISLATURA:
					listado = sqlSession.selectList("estructuras.tablaEstructura.buscarAtributos", parametros);
					if(listado != null){
						for(HashMap<String, Object> registro : listado){
							logger.debug("registro: {}", registro);
							legislatura = legislaturasC.porId((Integer) registro.get("dato01_int"));
							figuraAtributo = new FiguraAtributoEO();
							figuraAtributo.setId((Integer) registro.get("id_politik"));
							figuraAtributo.setIdPolitikPadre((Integer) registro.get("id_politik_padre"));
							figuraAtributo.setAtributo(atributo);
							figuraAtributo.setLegislatura(legislatura);
							capturaCRUD.getMapaAtributos().get(atributo.name()).add(figuraAtributo);
						}
					}
					break;
				case PARTIDO_POLITICO:
					registroAtributo = sqlSession.selectOne("estructuras.tablaEstructura.buscarAtributos", parametros);
					logger.debug("registro: {}", registroAtributo);
					if(registroAtributo != null){
						partido = partidosC.partidoPorId((Integer) registroAtributo.get("dato01_int"));
						figuraAtributo = new FiguraAtributoEO();
						figuraAtributo.setId((Integer) registroAtributo.get("id_politik"));
						figuraAtributo.setIdPolitikPadre((Integer) registroAtributo.get("id_politik_padre"));
						figuraAtributo.setAtributo(atributo);
						figuraAtributo.setPartidoPolitico(partido);
						capturaCRUD.getMapaAtributos().get(atributo.name()).clear();
						capturaCRUD.getMapaAtributos().get(atributo.name()).add(figuraAtributo);
					}
					break;
				case PERIODO:
					registroAtributo = sqlSession.selectOne("estructuras.tablaEstructura.buscarAtributos", parametros);
					if(registroAtributo != null){
						logger.debug("registro: {}", registroAtributo);
						figuraAtributo = new FiguraAtributoEO();
						figuraAtributo.setId((Integer) registroAtributo.get("id_politik"));
						figuraAtributo.setIdPolitikPadre((Integer) registroAtributo.get("id_politik_padre"));
						figuraAtributo.setAtributo(atributo);
						figuraAtributo.setFechaInicio(formateador.fechaStringToDate((String) registroAtributo.get("dato01_text")));
						figuraAtributo.setFechaTermino(formateador.fechaStringToDate((String) registroAtributo.get("dato02_text")));
						figuraAtributo.setVigente(((Integer) registroAtributo.get("dato01_int")) == 1 ? true : false );
						capturaCRUD.getMapaAtributos().get(atributo.name()).clear();
						capturaCRUD.getMapaAtributos().get(atributo.name()).add(figuraAtributo);
					}
					break;
				case PROGRAMA_PROMOCION:
					break;
				case TIPO_SENADOR:
					registroAtributo = sqlSession.selectOne("estructuras.tablaEstructura.buscarAtributos", parametros);
					if(registroAtributo != null){
						logger.debug("registro: {}", registroAtributo);
						figuraAtributo = new FiguraAtributoEO();
						figuraAtributo.setId((Integer) registroAtributo.get("id_politik"));
						figuraAtributo.setIdPolitikPadre((Integer) registroAtributo.get("id_politik_padre"));
						figuraAtributo.setAtributo(atributo);
						figuraAtributo.setTipoSenador(TiposSenadorDO.valueOf((String) registroAtributo.get("dato01_text")));
						capturaCRUD.getMapaAtributos().get(atributo.name()).clear();
						capturaCRUD.getMapaAtributos().get(atributo.name()).add(figuraAtributo);
					}
					break;
				case COMISION_CAMARA_SENADORES:
					listado = sqlSession.selectList("estructuras.tablaEstructura.buscarAtributos", parametros);
					if(listado != null){
						for(HashMap<String, Object> registro : listado){
							logger.debug("registro: {}", registro);
							
							comision = comisionesCongresoUnionC.porId((Integer) registro.get("dato01_int"));
							
							figuraAtributo = new FiguraAtributoEO();
							figuraAtributo.setId((Integer) registro.get("id_politik"));
							figuraAtributo.setIdPolitikPadre((Integer) registro.get("id_politik_padre"));
							figuraAtributo.setAtributo(atributo);
							
							figuraAtributo.setComision(comision);
							figuraAtributo.setComisionCargo(CargosComisionCongresoUnionDO.valueOf((String) registro.get("dato01_text")));
							
							capturaCRUD.getMapaAtributos().get(atributo.name()).add(figuraAtributo);
						}
					}
				}
			}
			
			break;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void capturar(RequestContext context){
		HashMap<String, Object> mapaCaptura;
		CapturaEO capturaCRUD;
		HashMap<String, Object> flowScope, viewScope, modelos, parametros, parametrosAtributos, datos;
		EstructuraEO estructura;
		List<String> campos;
		List<TiposCampoDO> tiposCampo;
		TablaPersonaEO tablaPersona;
		TablaParticionEO particion;
		EntidadEO entidad;
		DFederalEO dFederal;
		DLocalEO dLocal;
		MunicipioEO municipio;
		SeccionEO seccion;
		GeozonaParticionEO geozonaParticion;
		EleccionEO eleccion;
		PersonaEO personaPadre;
		List<HashMap<String, Object>> superiores;
		HashMap<String, Object> superior;
		int index;
		boolean insertarTablaPersona;
		String f1, f2;
		
		
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		modelos = (HashMap<String, Object>) viewScope.get("modelos");
		
		mapaCaptura = (HashMap<String, Object>) flowScope.get("mapaCaptura");
		capturaCRUD = (CapturaEO) flowScope.get("capturaCRUD");
		estructura = (EstructuraEO) mapaCaptura.get("estructura");
		try{
		superiores = ((List<HashMap<String, Object>>) mapaCaptura.get("superiores"));
		personaPadre = null;
		if(!superiores.isEmpty()){
			index = superiores.size() - 1;
			superior = superiores.get(index);
			personaPadre = (PersonaEO) superior.get("persona");
		}
		
		parametros = new HashMap<>();
		campos = new ArrayList<>();
		datos = new HashMap<>();
		tiposCampo = new ArrayList<>();
		tablaPersona = new TablaPersonaEO();
		
		parametros.put("esquema", "warehouse");
		parametros.put("tabla", "estructura_" + estructura.getId());
		datos.put("id_persona", capturaCRUD.getPersona().getId());
		datos.put("id_entidad_nacimiento", capturaCRUD.getPersona().getEntidadNacimiento().getId());
		
		if(personaPadre == null){
			datos.put("id_persona_padre", null);
			datos.put("id_entidad_nacimiento_padre", null);
		} else {
			datos.put("id_persona_padre", personaPadre.getId());
			datos.put("id_entidad_nacimiento_padre", personaPadre.getEntidadNacimiento().getId());
		}
		
		datos.put("id_nodo", capturaCRUD.getNodo().getId());
		
		logger.debug("Nivel de Figura: {}", capturaCRUD.getNodo().getFigura().getNivel());
		switch(capturaCRUD.getNodo().getFigura().getNivel()){
		case DFEDERAL:
			dFederal = ((Modelo<DFederalEO>) modelos.get("dFederales")).getSeleccionado();
			datos.put("llave", dFederal.getLlave());
			capturaCRUD.setTerritorio(dFederal);
			break;
		case DLOCAL:
			dLocal = ((Modelo<DLocalEO>) modelos.get("dLocales")).getSeleccionado();
			datos.put("llave", dLocal.getLlave());
			capturaCRUD.setTerritorio(dLocal);
			break;
		case ENTIDAD:
			entidad = ((Modelo<EntidadEO>) modelos.get("entidades")).getSeleccionado();
			datos.put("llave", entidad.getLlave());
			capturaCRUD.setTerritorio(entidad);
			break;
		case GEOZONA:
			geozonaParticion = ((Modelo<GeozonaParticionEO>) modelos.get("geozonaParticiones")).getSeleccionado();
			datos.put("llave", geozonaParticion.getLlave());
			capturaCRUD.setTerritorio(geozonaParticion);
			break;
		case LOCALIDAD:
			break;
		case MANZANA:
			break;
		case MUNICIPIO:
			municipio = ((Modelo<MunicipioEO>) modelos.get("municipios")).getSeleccionado();
			datos.put("llave", municipio.getLlave());
			capturaCRUD.setTerritorio(municipio);
			break;
		case NACIONAL:
			datos.put("llave", null);
			break;
		case SECCION:
			seccion = ((Modelo<SeccionEO>) modelos.get("secciones")).getSeleccionado();
			datos.put("llave", seccion.getLlave());
			capturaCRUD.setTerritorio(seccion);
			break;
		}
		
		campos.add("id_persona");
		campos.add("id_entidad_nacimiento");
		campos.add("id_persona_padre");
		campos.add("id_entidad_nacimiento_padre");
		campos.add("id_nodo");
		campos.add("llave");
		
		tiposCampo.add(TiposCampoDO.INTEGER);
		tiposCampo.add(TiposCampoDO.INTEGER);
		tiposCampo.add(TiposCampoDO.INTEGER);
		tiposCampo.add(TiposCampoDO.INTEGER);
		tiposCampo.add(TiposCampoDO.INTEGER);
		tiposCampo.add(TiposCampoDO.TEXT);
		
		switch(estructura.getAmbito()){
		case DEPENDENCIA:
			break;
		case DEPENDENCIAS:
			datos.put("id_dependencia", capturaCRUD.getDependencia().getId());
			datos.put("cargo", capturaCRUD.getCargo());
			datos.put("fecha_inicio", capturaCRUD.getFechaInicio());
			datos.put("fecha_termino", capturaCRUD.getFechaTermino());
			datos.put("vigente", capturaCRUD.getVigente());
			campos.add("id_dependencia");
			campos.add("cargo");
			campos.add("fecha_inicio");
			campos.add("fecha_termino");
			campos.add("vigente");
			tiposCampo.add(TiposCampoDO.INTEGER);
			tiposCampo.add(TiposCampoDO.TEXT);
			tiposCampo.add(TiposCampoDO.DATE);
			tiposCampo.add(TiposCampoDO.DATE);
			tiposCampo.add(TiposCampoDO.INTEGER);
			break;
		case ELECCION:
			eleccion = (EleccionEO) mapaCaptura.get("eleccion");
			datos.put("id_eleccion", eleccion.getId());
			campos.add("id_eleccion");
			tiposCampo.add(TiposCampoDO.INTEGER);
			break;
		case GENERAL:
			break;
		}
		
		parametros.put("campos", campos);
		parametros.put("datos", datos);
		parametros.put("tiposCampos", tiposCampo);
		parametros.put("idPolitik", capturaCRUD.getId());
		
		insertarTablaPersona = true;
		if(capturaCRUD.getId() == null){
			sqlSession.insert("estructuras.tablaEstructura.insertar", parametros);
			
			//Actualizar Meta
			actualizarAvance((Integer) datos.get("id_nodo"), (String) datos.get("llave"));
		} else {
			sqlSession.insert("estructuras.tablaEstructura.actualizar", parametros);
			insertarTablaPersona = false;
		}
		
		
		particion = new TablaParticionEO();
		if(estructura.getTabla().getParticionada()){
			//TODO: Proceso en caso de que la tabla de Estructura este particionada (Aun no implementado)
		}
		
		//Insertar Atributos de Figura
		parametrosAtributos = new HashMap<>();
		parametrosAtributos.put("esquema", parametros.get("esquema"));
		parametrosAtributos.put("tabla", parametros.get("tabla") + "_atributos");
		parametrosAtributos.put("idPolitik", null);
		
		campos = new ArrayList<>();
		datos = new HashMap<>();
		tiposCampo = new ArrayList<>();
		
		parametrosAtributos.put("campos", campos);
		parametrosAtributos.put("datos", datos);
		parametrosAtributos.put("tiposCampos", tiposCampo);
		
		logger.debug("Atributos a Capturar: {}", capturaCRUD.getNodo().getFigura().getAtributos());
		
		for(FiguraAtributosDO figuraAtributo : capturaCRUD.getNodo().getFigura().getAtributos()){
			campos.clear();
			tiposCampo.clear();
			
			campos.add("id_politik_padre");
			campos.add("tipo_atributo");
			tiposCampo.add(TiposCampoDO.INTEGER);
			tiposCampo.add(TiposCampoDO.TEXT);
			
			datos.put("id_politik_padre", parametros.get("idPolitik"));
			datos.put("tipo_atributo", figuraAtributo);
			
			logger.debug("Atributo a Capturar: {}", capturaCRUD.getMapaAtributos().get(figuraAtributo.name()));
			switch(figuraAtributo){
			case PROGRAMA_PROMOCION:
				campos.add("dato01_int");
				tiposCampo.add(TiposCampoDO.INTEGER);
				for(FiguraAtributoEO atributo : capturaCRUD.getMapaAtributos().get(figuraAtributo.name())){
					datos.put("dato01_int", atributo.getProgramaPromocion().getId());
					if(atributo.getId() == null){
						sqlSession.insert("estructuras.tablaEstructura.insertar", parametrosAtributos);
					} else {
						parametrosAtributos.put("idPolitik", atributo.getId());
						sqlSession.insert("estructuras.tablaEstructura.actualizar", parametrosAtributos);
					}
				}
				break;
			case PARTIDO_POLITICO:
				campos.add("dato01_int");
				tiposCampo.add(TiposCampoDO.INTEGER);
				for(FiguraAtributoEO atributo : capturaCRUD.getMapaAtributos().get(figuraAtributo.name())){
					datos.put("dato01_int", atributo.getPartidoPolitico().getId());
					if(atributo.getId() == null){
						sqlSession.insert("estructuras.tablaEstructura.insertar", parametrosAtributos);
					} else {
						parametrosAtributos.put("idPolitik", atributo.getId());
						sqlSession.insert("estructuras.tablaEstructura.actualizar", parametrosAtributos);
					}
				}
				break;
			case PERIODO:
				campos.add("dato01_text");
				campos.add("dato02_text");
				campos.add("dato01_int");
				tiposCampo.add(TiposCampoDO.TEXT);
				tiposCampo.add(TiposCampoDO.TEXT);
				tiposCampo.add(TiposCampoDO.INTEGER);
				
				for(FiguraAtributoEO atributo : capturaCRUD.getMapaAtributos().get(figuraAtributo.name())){
					f1 = atributo.getFechaInicio() == null ? null : atributo.getFechaInicio().toString();
					f2 = atributo.getFechaTermino() == null ? null : atributo.getFechaTermino().toString();
					datos.put("dato01_text", f1);
					datos.put("dato02_text", f2);
					datos.put("dato01_int", atributo.getVigente() ? 1 : 0);
					if(atributo.getId() == null){
						sqlSession.insert("estructuras.tablaEstructura.insertar", parametrosAtributos);
					} else {
						parametrosAtributos.put("idPolitik", atributo.getId());
						sqlSession.insert("estructuras.tablaEstructura.actualizar", parametrosAtributos);
					}
				}
				break;
			case LEGISLATURA:
				campos.add("dato01_int");
				tiposCampo.add(TiposCampoDO.INTEGER);
				for(FiguraAtributoEO atributo : capturaCRUD.getMapaAtributos().get(figuraAtributo.name())){
					datos.put("dato01_int", atributo.getLegislatura().getId());
					if(atributo.getId() == null){
						sqlSession.insert("estructuras.tablaEstructura.insertar", parametrosAtributos);
					} else {
						parametrosAtributos.put("idPolitik", atributo.getId());
						sqlSession.insert("estructuras.tablaEstructura.actualizar", parametrosAtributos);
					}
				}
				break;
			case TIPO_SENADOR:
				campos.add("dato01_text");
				tiposCampo.add(TiposCampoDO.TEXT);
				for(FiguraAtributoEO atributo : capturaCRUD.getMapaAtributos().get(figuraAtributo.name())){
					datos.put("dato01_text", atributo.getTipoSenador().name());
					if(atributo.getId() == null){
						sqlSession.insert("estructuras.tablaEstructura.insertar", parametrosAtributos);
					} else {
						parametrosAtributos.put("idPolitik", atributo.getId());
						sqlSession.insert("estructuras.tablaEstructura.actualizar", parametrosAtributos);
					}
				}
				break;
			case COMISION_CAMARA_SENADORES:
				campos.add("dato01_int");
				campos.add("dato01_text");
				tiposCampo.add(TiposCampoDO.INTEGER);
				tiposCampo.add(TiposCampoDO.TEXT);
				for(FiguraAtributoEO atributo : capturaCRUD.getMapaAtributos().get(figuraAtributo.name())){
					datos.put("dato01_int", atributo.getComision().getId());
					datos.put("dato01_text", atributo.getComisionCargo().name());
					
					if(atributo.getId() == null){
						sqlSession.insert("estructuras.tablaEstructura.insertar", parametrosAtributos);
					} else {
						parametrosAtributos.put("idPolitik", atributo.getId());
						sqlSession.insert("estructuras.tablaEstructura.actualizar", parametrosAtributos);
					}
				}
				break;
			}
		}
		
		//Insertar Tabla Persona
		if(insertarTablaPersona){
			tablaPersona.setTabla(estructura.getTabla());
			tablaPersona.setIdPolitik((Integer) parametros.get("idPolitik"));
			tablaPersona.setParticion(particion);
			personasC.insertarTablaPersona(tablaPersona, capturaCRUD.getPersona());
		}
		
		} catch(Exception e){ e.printStackTrace(); }
		
		//Avanza al siguiente nivel
		Integer nivel = (Integer) mapaCaptura.get("nivel");
		if(!nodosPorNivel(nivel.intValue()+1, capturaCRUD.getNodo(), estructura).isEmpty())
			actualizarMapaCaptura(mapaCaptura, nivel.intValue()+1, capturaCRUD);
		else
			actualizarMapaCaptura(mapaCaptura);
	}
	
	public void actualizarAvance(Integer idNodo, String llave){
		HashMap<String, Object> parametros;
		
		parametros = new HashMap<>();
		
		parametros.put("idNodo", idNodo);
		parametros.put("llave", llave);
		
		sqlSession.update("estructuras.nodos.actualizarAvance", parametros);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> generarModelos(HashMap<String, Object> mapaCaptura, CapturaEO capturaCRUD){
		Integer nivel;
		HashMap<String, Object> modelos, superior;
		List<HashMap<String, Object>> superiores;
		Modelo<EntidadEO> modeloEntidades;
		Modelo<DFederalEO> modeloDFederales;
		Modelo<DLocalEO> modeloDLocales;
		Modelo<MunicipioEO> modeloMunicipios;
		Modelo<SeccionEO> modeloSecciones;
		Modelo<GeozonaParticionEO> modeloGeozonasParticiones;
		NodoEO nodoPadre;
		List<EntidadEO> listadoEntidades;
		EntidadEO entidad;
		DFederalEO dFederal;
		DLocalEO dLocal;
		MunicipioEO municipio;
		SeccionEO seccion;
		GeozonaParticionEO geozonaParticion;
		String llave;
		JavaBeanT territorioPadre;
		int index;
		List<MunicipioEO> municipios;
		List<DLocalEO> dLocales;
		List<DFederalEO> dFederales;
		
		modelos = new HashMap<>();
		//try{
		
		nivel = (Integer) mapaCaptura.get("nivel");
		superiores = (List<HashMap<String, Object>>) mapaCaptura.get("superiores");
		
		nodoPadre = null;
		superior = null;
		territorioPadre = null;
		if(!superiores.isEmpty()){
			index = superiores.size() - 1;
			superior = superiores.get(index);
			nodoPadre = (NodoEO) superior.get("nodo");
			territorioPadre = (JavaBeanT) superior.get("territorio");
		}
		
		entidad = null;
		dFederal = null;
		dLocal = null;
		municipio = null;
		seccion = null;
		geozonaParticion = null;
		if(nodoPadre != null){
			switch(nodoPadre.getFigura().getNivel()){
			case DFEDERAL:
				dFederal = (DFederalEO) territorioPadre;
				entidad = dFederal.getEntidad();
				break;
			case DLOCAL:
				dLocal = (DLocalEO) territorioPadre;
				entidad = dLocal.getEntidad();
				break;
			case ENTIDAD:
				entidad = (EntidadEO) territorioPadre;
				break;
			case GEOZONA:
				geozonaParticion = (GeozonaParticionEO) territorioPadre;
				break;
			case LOCALIDAD:
				break;
			case MANZANA:
				break;
			case MUNICIPIO:
				municipio = (MunicipioEO) territorioPadre;
				entidad = municipio.getEntidad();
				break;
			case NACIONAL:
				break;
			case SECCION:
				seccion = (SeccionEO) territorioPadre;
				entidad = seccion.getEntidad();
				dFederal = seccion.getdFederal();
				dLocal = seccion.getdLocal();
				municipio = seccion.getMunicipio();
				break;
			}
		}
		
		//TODO Agregar comportamientos para filtrar los distintos niveles en funci�n del territorio del padre
		if(entidad != null){
			listadoEntidades = new ArrayList<>();
			modeloEntidades = new Modelo<>();
			
			listadoEntidades.add(entidad);
			modeloEntidades.setListado(listadoEntidades);
			modeloEntidades.setSeleccionado(entidad);
		} else {
			modeloEntidades = entidadesC.modelo();
		}
		
		modelos.put("entidades", modeloEntidades);
		
		//Verificar si se trata de una edicion
		if(capturaCRUD.getTerritorio() != null){
			switch(capturaCRUD.getNodo().getFigura().getNivel()){
			case CASILLA:
				break;
			case DFEDERAL:
				modeloEntidades.setSeleccionado(((DFederalEO) capturaCRUD.getTerritorio()).getEntidad());
				modeloDFederales = dFederalesC.modelo(modeloEntidades.getSeleccionado());
				modeloDFederales.setSeleccionado((DFederalEO) capturaCRUD.getTerritorio());
				modelos.put("dFederales", modeloDFederales);
				break;
			case DLOCAL:
				break;
			case ENTIDAD:
				modeloEntidades.setSeleccionado((EntidadEO) capturaCRUD.getTerritorio());
				break;
			case GEOZONA:
				modeloGeozonasParticiones = geozonasC.modeloGeozonaParticionesSinTerritorios(capturaCRUD.getNodo().getFigura().getGeozona());
				modeloGeozonasParticiones.setSeleccionado((GeozonaParticionEO) capturaCRUD.getTerritorio());
				modelos.put("geozonaParticiones", modeloGeozonasParticiones);
				break;
			case LOCALIDAD:
				break;
			case MANZANA:
				break;
			case MUNICIPIO:
				modeloEntidades.setSeleccionado(((MunicipioEO) capturaCRUD.getTerritorio()).getEntidad());
				modeloMunicipios = municipiosC.modelo(modeloEntidades.getSeleccionado());
				modeloMunicipios.setSeleccionado((MunicipioEO) capturaCRUD.getTerritorio());
				modelos.put("municipios", modeloMunicipios);
				break;
			case NACIONAL:
				break;
			case SECCION:
				//TODO falta por implementar
				break;
			}
		} else {
			switch(capturaCRUD.getNodo().getFigura().getNivel()){
			case DFEDERAL:
				modeloDFederales = dFederalesC.modelo(modeloEntidades.getSeleccionado());
				modelos.put("dFederales", modeloDFederales);
				break;
			case DLOCAL:
				modeloDLocales = dLocalesC.modelo(modeloEntidades.getSeleccionado());
				modelos.put("dLocales", modeloDLocales);
				break;
			case ENTIDAD:
				break;
			case GEOZONA:
				modeloGeozonasParticiones = geozonasC.modeloGeozonaParticionesSinTerritorios(capturaCRUD.getNodo().getFigura().getGeozona());
				if(geozonaParticion != null){
					modeloGeozonasParticiones.setSeleccionado(geozonaParticion);
				}
				modelos.put("geozonaParticiones", modeloGeozonasParticiones);
				break;
			case LOCALIDAD:
				break;
			case MANZANA:
				break;
			case MUNICIPIO:
				modeloMunicipios = municipiosC.modelo(modeloEntidades.getSeleccionado());
				modelos.put("municipios", modeloMunicipios);
				break;
			case NACIONAL:
				break;
			case SECCION:
				modeloMunicipios = new Modelo<>();
				municipios = new ArrayList<>();
				modeloMunicipios.setListado(municipios);
				if(municipio != null){
					municipios.add(municipio);
					modeloMunicipios.setSeleccionado(municipio);
				}
				
				modeloDLocales = new Modelo<>();
				dLocales = new ArrayList<>();
				modeloDLocales.setListado(dLocales);
				if(dLocal != null){
					dLocales.add(dLocal);
					modeloDLocales.setSeleccionado(dLocal);
				}
				
				modeloDFederales = new Modelo<>();
				dFederales = new ArrayList<>();
				modeloDFederales.setListado(dFederales);
				if(dFederal != null){
					dFederales.add(dFederal);
					modeloDFederales.setSeleccionado(dFederal);
				}
				
				modeloSecciones = seccionesC.modeloSecciones(municipios, dLocales, dFederales);
				modelos.put("dFederales", modeloDFederales);
				modelos.put("dLocales", modeloDLocales);
				modelos.put("municipios", modeloMunicipios);
				modelos.put("secciones", modeloSecciones);
				break;
			}
		}
		
		
		//} catch(Exception e){ e.printStackTrace();}
		//logger.debug("Modelos Generados: {}", modelos);
		
		return modelos;
	}
	
	@SuppressWarnings("unchecked")
	public void actualizarModelos(HashMap<String, Object> modelos, NivelesDO nivel){
		Modelo<EntidadEO> modeloEntidades;
		Modelo<DFederalEO> modeloDFederales;
		Modelo<DLocalEO> modeloDLocales;
		Modelo<MunicipioEO> modeloMunicipios;
		Modelo<SeccionEO> modeloSecciones;
		List<MunicipioEO> municipios;
		List<DLocalEO> dLocales;
		List<DFederalEO> dFederales;
		
		modeloEntidades = (Modelo<EntidadEO>) modelos.get("entidades");
		
		switch(nivel){
		case DFEDERAL:
			modeloDFederales = (Modelo<DFederalEO>) modelos.get("dFederales");
			modeloDFederales = dFederalesC.modelo(modeloEntidades.getSeleccionado());
			modelos.put("dFederales", modeloDFederales);
			break;
		case DLOCAL:
			modeloDLocales = (Modelo<DLocalEO>) modelos.get("dLocales");
			modeloDLocales = dLocalesC.modelo(modeloEntidades.getSeleccionado());
			modelos.put("dLocales", modeloDLocales);
			break;
		case ENTIDAD:
			break;
		case GEOZONA:
			break;
		case LOCALIDAD:
			break;
		case MANZANA:
			break;
		case MUNICIPIO:
			modeloMunicipios = (Modelo<MunicipioEO>) modelos.get("municipios");
			modeloMunicipios = municipiosC.modelo(modeloEntidades.getSeleccionado());
			modelos.put("municipios", modeloMunicipios);
			break;
		case NACIONAL:
			break;
		case SECCION:
			modeloDFederales = (Modelo<DFederalEO>) modelos.get("dFederales");
			dFederales = new ArrayList<>();
			dFederales.add(modeloDFederales.getSeleccionado());
			modeloDLocales = (Modelo<DLocalEO>) modelos.get("dLocales");
			dLocales = new ArrayList<>();
			dLocales.add(modeloDLocales.getSeleccionado());
			modeloMunicipios = (Modelo<MunicipioEO>) modelos.get("municipios");
			municipios = new ArrayList<>();
			municipios.add(modeloMunicipios.getSeleccionado());
			modeloSecciones = seccionesC.modeloSecciones(municipios, dLocales, dFederales);
			modelos.put("secciones", modeloSecciones);
			break;
		}
	}
	
	public void agregarProgramaPromocion(CapturaEO capturaCRUD, ProgramaPromocionEO programaPromocion){
		FiguraAtributoEO figuraAtributo;
		boolean flag;
		
		figuraAtributo = new FiguraAtributoEO();
		figuraAtributo.setAtributo(FiguraAtributosDO.PROGRAMA_PROMOCION);
		figuraAtributo.setProgramaPromocion(programaPromocion);
		
		flag = true;
		for(FiguraAtributoEO fa : capturaCRUD.getMapaAtributos().get(FiguraAtributosDO.PROGRAMA_PROMOCION.name())){
			if(fa.getProgramaPromocion().equals(programaPromocion)){
				flag = false;
				break;
			}
		}
		
		if(flag){
			capturaCRUD.getMapaAtributos().get(FiguraAtributosDO.PROGRAMA_PROMOCION.name()).add(figuraAtributo);
		}
	}
	
	public void agregarLegislatura(CapturaEO capturaCRUD, LegislaturaEO legislatura){
		FiguraAtributoEO figuraAtributo;
		boolean flag;
		
		figuraAtributo = new FiguraAtributoEO();
		figuraAtributo.setAtributo(FiguraAtributosDO.PROGRAMA_PROMOCION);
		figuraAtributo.setLegislatura(legislatura);
		
		flag = true;
		for(FiguraAtributoEO fa : capturaCRUD.getMapaAtributos().get(FiguraAtributosDO.LEGISLATURA.name())){
			if(fa.getLegislatura().equals(legislatura)){
				flag = false;
				break;
			}
		}
		
		if(flag){
			capturaCRUD.getMapaAtributos().get(FiguraAtributosDO.LEGISLATURA.name()).add(figuraAtributo);
		}
	}
	
	public void agregarComisionCU(CapturaEO capturaCRUD, ComisionCongresoUnionEO comision, String tipoComision, CargosComisionCongresoUnionDO cargo){
		FiguraAtributoEO figuraAtributo;
		FiguraAtributosDO auxAtributo;
		boolean flag;
		
		figuraAtributo = new FiguraAtributoEO();
		auxAtributo = FiguraAtributosDO.valueOf(tipoComision);
		figuraAtributo.setAtributo(auxAtributo);
		figuraAtributo.setComision(comision);
		figuraAtributo.setComisionCargo(cargo);
		
		flag = true;
		for(FiguraAtributoEO fa : capturaCRUD.getMapaAtributos().get(auxAtributo.name())){
			if(fa.getComision().equals(comision)){
				flag = false;
				break;
			}
		}
		
		if(flag){
			capturaCRUD.getMapaAtributos().get(auxAtributo.name()).add(figuraAtributo);
		}
	}
	
	public CapturaEO recuperarCaptura(EstructuraEO estructura, Integer idPolitik){
		CapturaEO captura;
		HashMap<String, Object> parametros, datos;
		JavaBeanT territorio;
		
		captura = new CapturaEO();
		parametros = new HashMap<>();
				
		captura.setId(idPolitik);
		
		parametros.put("estructura", estructura);
		parametros.put("idPolitik", idPolitik);
		
		datos = sqlSession.selectOne("estructuras.tablaEstructura.buscarCaptura", parametros);
		
		for(NodoEO nodo : estructura.getNodos()){
			if(nodo.getId().equals(datos.get("id_nodo"))){
				figurasC.completarFigura(nodo.getFigura());
				captura.setNodo(nodo);
				break;
			}
		}
		
		switch(estructura.getAmbito()){
		case DEPENDENCIA:
			break;
		case DEPENDENCIAS:
			break;
		case ELECCION:
			break;
		case GENERAL:
			captura.setPersona(personasC.personaSimplePorId((Integer) datos.get("id_persona"), (Integer) datos.get("id_entidad_nacimiento")));
			captura.setPersonaPadre(personasC.personaSimplePorId((Integer) datos.get("id_persona_padre"), (Integer) datos.get("id_entidad_nacimiento_padre")));
			break;
		}
		
		territorio = null;
		switch(captura.getNodo().getFigura().getNivel()){
		case DFEDERAL:
			territorio = dFederalesC.buscarPorLlave((String) datos.get("llave"));
			break;
		case DLOCAL:
			territorio = dLocalesC.buscarPorLlave((String) datos.get("llave"));
			break;
		case ENTIDAD:
			territorio = entidadesC.buscarPorLlave((String) datos.get("llave"));
			break;
		case GEOZONA:
			territorio = geozonasC.buscarParticionPorLlave((String) datos.get("llave"));
			break;
		case LOCALIDAD:
			break;
		case MANZANA:
			break;
		case MUNICIPIO:
			territorio = municipiosC.buscarPorLlave((String) datos.get("llave"));
			break;
		case NACIONAL:
			break;
		case SECCION:
			territorio = seccionesC.buscarPorLlave((String) datos.get("llave"));
			break;
		case CASILLA:
			break;
		}
		captura.setTerritorio(territorio);
		
		try {
			
			if(!captura.getNodo().getFigura().getAtributos().isEmpty()){
				for(FiguraAtributosDO atributo : captura.getNodo().getFigura().getAtributos()){
					switch(atributo){
					case LEGISLATURA:
					case PROGRAMA_PROMOCION:
					case COMISION_CAMARA_SENADORES:
						captura.getMapaAtributos().put(atributo.name(), new ArrayList<FiguraAtributoEO>());
						break;
					case PERIODO:
					case PARTIDO_POLITICO:
					case TIPO_SENADOR:
						List<FiguraAtributoEO> lista = new ArrayList<FiguraAtributoEO>();
						lista.add(new FiguraAtributoEO());
						captura.getMapaAtributos().put(atributo.name(), lista);
						break;
					}
				}
			}
			
			
			llenarAtributos(estructura, captura);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		return captura;
	}
}
