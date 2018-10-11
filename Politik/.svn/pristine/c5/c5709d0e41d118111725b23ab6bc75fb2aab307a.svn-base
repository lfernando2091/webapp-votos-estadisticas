package com.saganet.politik.components.estructuras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.components.catalogos.DFederalesC;
import com.saganet.politik.components.catalogos.EntidadesC;
import com.saganet.politik.components.catalogos.MunicipiosC;
import com.saganet.politik.components.catalogos.PartidosC;
import com.saganet.politik.components.catalogos.SeccionesC;
import com.saganet.politik.components.mdm.PersonasC;
import com.saganet.politik.database.catalogos.CasillaEO;
import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.PartidoEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.database.estructuras.EstructuraEO;
import com.saganet.politik.database.estructuras.NodoEO;
import com.saganet.politik.database.estructuras.NodoMetaEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.dominios.EstructurasReportesDO;
import com.saganet.politik.dominios.FiguraAtributosDO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.utilidades.Formateador;

@Component("EstructurasReportesC")
public class ReportesC {
	private static final Logger logger = LoggerFactory.getLogger(ReportesC.class);
	
	@Autowired SqlSession sqlSession;
	@Autowired PersonasC personasC;
	@Autowired PartidosC partidosC;
	@Autowired EntidadesC entidadesC;
	@Autowired DFederalesC dFederalesC;
	@Autowired MunicipiosC municipiosC;
	@Autowired SeccionesC seccionesC;
	@Autowired EstructurasC estructurasC;
	
	
	public Modelo<EntidadEO> modeloEntidades(){
		logger.debug("modeloEntidades");
		Modelo<EntidadEO> modelo = entidadesC.modeloAdmin();
//		List<EntidadEO> listado;
//		
//		modelo = new Modelo<>();
//		listado = new ArrayList<>();
//		listado.addAll(entidadesC.)
//		listado.add(entidadesC.buscarPorId(2));
//		listado.add(entidadesC.buscarPorId(6));
//		listado.add(entidadesC.buscarPorId(10));
//		
//		modelo.setListado(listado);
//		modelo.setSeleccionado(listado.get(0));
//		
//		logger.debug("Se genera modeloEntidades");
		return modelo;
	}
	
	public Modelo<NivelesDO> modeloNiveles(){
		Modelo<NivelesDO> modelo;
		List<NivelesDO> listado;
		
		modelo = new Modelo<>();
		listado = new ArrayList<>();
		
		listado.add(NivelesDO.NACIONAL);
		listado.add(NivelesDO.ENTIDAD);
		listado.add(NivelesDO.DFEDERAL);
		listado.add(NivelesDO.MUNICIPIO);
		listado.add(NivelesDO.SECCION);
		
		modelo.setListado(listado);
		modelo.setSeleccionado(listado.get(0));
		
		return modelo;
	}
		
	public String elegirReporte(EstructurasReportesDO reporte){
		String respuesta;
		
		respuesta = null;
		switch(reporte){
		case CONCENTRADO_ESTATAL:
			respuesta = "concentradoEstatal";
			break;
		case ESTRUCTURA_OPERATIVA_2018:
			respuesta = "estructuraOperativa2018";
			break;
		case CONCENTRADO_NACIONAL:
			respuesta = "concentradoNacional";
			break;
		}
		
		return respuesta;
	}
	
	@SuppressWarnings("unchecked")
	public void actualizarCombos(RequestContext context){
		HashMap<String, Object> viewScope;
		NivelesDO nivel;
		Modelo<EntidadEO> modeloEntidades;
		Modelo<DFederalEO> modeloDFederales;
		Modelo<MunicipioEO> modeloMunicipios;
		Modelo<SeccionEO> modeloSecciones;
		
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		
		nivel = (NivelesDO) viewScope.get("nivel");
		
		modeloEntidades = (Modelo<EntidadEO>) viewScope.get("modeloEntidades");
		modeloDFederales = (Modelo<DFederalEO>) viewScope.get("modeloDFederales");
		modeloMunicipios = (Modelo<MunicipioEO>) viewScope.get("modeloMunicipios");
		modeloSecciones = (Modelo<SeccionEO>) viewScope.get("modeloSecciones");
		
		logger.debug("Nivel a Generar: {}", nivel);
		
		if(modeloEntidades == null){
			//modeloEntidades = modeloEntidades();
			modeloEntidades = entidadesC.modelo();
		}
		
		if(modeloEntidades.getSeleccionado() == null){
			modeloEntidades.setSeleccionado(modeloEntidades.getListado().get(0));
		}
		viewScope.put("modeloEntidades", modeloEntidades);
		
		switch(nivel){
		case CASILLA:
			break;
		case DFEDERAL:
			if(modeloDFederales == null){
				modeloDFederales = dFederalesC.modelo(modeloEntidades.getSeleccionado());
			}
			
			if(modeloDFederales.getSeleccionado() == null){
				modeloDFederales = dFederalesC.modelo(modeloEntidades.getSeleccionado());
			} else {
				if(!modeloDFederales.getSeleccionado().getEntidad().equals(modeloEntidades.getSeleccionado())){
					modeloDFederales = dFederalesC.modelo(modeloEntidades.getSeleccionado());
				}
			}
			viewScope.put("modeloDFederales", modeloDFederales);
			break;
		case DLOCAL:
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
			if(modeloMunicipios == null){
				modeloMunicipios = municipiosC.modelo(modeloEntidades.getSeleccionado());
			}
			
			if(modeloMunicipios.getSeleccionado() == null){
				modeloMunicipios = municipiosC.modelo(modeloEntidades.getSeleccionado());
			} else {
				if(!modeloMunicipios.getSeleccionado().getEntidad().equals(modeloEntidades.getSeleccionado())){
					modeloMunicipios = municipiosC.modelo(modeloEntidades.getSeleccionado());
				}
			}
			viewScope.put("modeloMunicipios", modeloMunicipios);
			break;
		case NACIONAL:
			break;
		case SECCION:
			if(modeloSecciones == null){
				modeloSecciones = seccionesC.modelo(modeloEntidades.getSeleccionado());
			}
			
			if(modeloSecciones.getSeleccionado() == null){
				modeloSecciones = seccionesC.modelo(modeloEntidades.getSeleccionado());
			} else {
				if(!modeloSecciones.getSeleccionado().getEntidad().equals(modeloEntidades.getSeleccionado())){
					modeloSecciones = seccionesC.modelo(modeloEntidades.getSeleccionado());
				}
			}
			viewScope.put("modeloSecciones", modeloSecciones);
			break;
		}
		
		viewScope.put("modeloEntidades", modeloEntidades);
		
		if(modeloDFederales == null)
			viewScope.put("modeloDFederales", new Modelo<DFederalEO>());
		if(modeloMunicipios == null)
			viewScope.put("modeloMunicipios", new Modelo<MunicipioEO>());
		if(modeloSecciones == null)
			viewScope.put("modeloSecciones", new Modelo<SeccionEO>());
	}
	
	@SuppressWarnings("unchecked")
	public void estructuraOperativa2018(NivelesDO nivel, RequestContext context){
		HashMap<String, Object> viewScope, parametros, parametros_p1y2, parametros_p3;
		EstructuraEO estructura, estructura_p1y2, estructura_p3;
		List<NodoMetaEO> metas, metas_p1y2, metas_p3;
		NodoMetaEO meta, meta_p1y2, meta_p3;
		EntidadEO entidad;
		DFederalEO dFederal;
		MunicipioEO municipio;
		SeccionEO seccion;
		CasillaEO casilla;
		
		parametros = new HashMap<>();
		parametros_p1y2 = new HashMap<>();
		parametros_p3 = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		estructura_p1y2 = estructurasC.obtenerPorId(32);
		estructura_p3 = estructurasC.obtenerPorId(32);
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		
		//obtener metas
		for(NodoEO nodo : estructura.getNodos()){
			metas = new ArrayList<>();
			metas_p1y2 = new ArrayList<>();
			metas_p3 = new ArrayList<>();
			
			meta = new NodoMetaEO();
			meta_p1y2 = new NodoMetaEO();
			meta_p3 = new NodoMetaEO();
			
			meta.setId(1);
			meta.setLlave(null);
			meta.setMeta(0);
			
			meta_p1y2.setId(1);
			meta_p1y2.setLlave(null);
			meta_p1y2.setMeta(0);
			
			meta_p3.setId(1);
			meta_p3.setLlave(null);
			meta_p3.setMeta(0);
			
			parametros.put("nodo", nodo);
			
			parametros.put("joinQuery", null);
			parametros.put("llave", null);
			parametros.put("llaveCompleja", null);
			switch(nivel){
			case CASILLA:
				
				break;
			case DFEDERAL:
				dFederal = ((Modelo<DFederalEO>) viewScope.get("modeloDFederales")).getSeleccionado();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave) JOIN catalogos.secciones SeccionEO on (CasillaEO.id_entidad = SeccionEO.id_entidad AND CasillaEO.id_seccion = SeccionEO.id_seccion)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + dFederal.getEntidad().getId() + " AND SeccionEO.id_dfederal = " + dFederal.getIdDFederal());
					break;
				case DFEDERAL:
					parametros.put("llave", dFederal.getLlave());
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", dFederal.getEntidad().getLlave());
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					parametros.put("llaveCompleja", "MunicipioEO.llave in (SELECT id_entidad||'-'||id_municipio FROM catalogos.secciones WHERE id_entidad = " + dFederal.getEntidad().getId() + " AND id_dfederal = " + dFederal.getIdDFederal() + " group by id_entidad, id_municipio)");
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + dFederal.getEntidad().getId() + " AND SeccionEO.id_dfederal = " + dFederal.getIdDFederal());
					break;
				}
				break;
			case DLOCAL:
				break;
			case ENTIDAD:
				entidad = ((Modelo<EntidadEO>) viewScope.get("modeloEntidades")).getSeleccionado();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					break;
				case DFEDERAL:
					parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					parametros.put("llaveCompleja", "DFederalEO.id_entidad = " + entidad.getLlave());
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", entidad.getLlave());
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					parametros.put("llaveCompleja", "MunicipioEO.id_entidad = " + entidad.getLlave());
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + entidad.getLlave());
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
				municipio = ((Modelo<MunicipioEO>) viewScope.get("modeloMunicipios")).getSeleccionado();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave) JOIN catalogos.secciones SeccionEO on (CasillaEO.id_entidad = SeccionEO.id_entidad AND CasillaEO.id_seccion = SeccionEO.id_seccion)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + municipio.getEntidad().getId() + " AND SeccionEO.id_municipio = " + municipio.getIdMunicipio());
					break;
				case DFEDERAL:
					parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					parametros.put("llaveCompleja", "DFederalEO.llave in (SELECT id_entidad||'-'||id_dfederal FROM catalogos.secciones WHERE id_entidad = " + municipio.getEntidad().getId() + " AND id_municipio = " + municipio.getIdMunicipio() + " group by id_entidad, id_dfederal)");
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", municipio.getEntidad().getLlave());
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("llave", municipio.getLlave());
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + municipio.getEntidad().getId() + " AND SeccionEO.id_municipio = " + municipio.getIdMunicipio());
					break;
				}
				break;
			case NACIONAL:
				
				break;
			case SECCION:
				seccion = ((Modelo<SeccionEO>) viewScope.get("modeloSecciones")).getSeleccionado();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + seccion.getEntidad().getId() + " AND CasillaEO.id_seccion = " + seccion.getIdSeccion());
					break;
				case DFEDERAL:
					parametros.put("llave", seccion.getdFederal().getLlave());
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", seccion.getEntidad().getLlave());
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("llave", seccion.getMunicipio().getLlave());
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("llave", seccion.getLlave());
					break;
				}
				break;
			}
			
			//TODO cambio error nodo
			if(false) { //if(nodo.getId().equals(76) || nodo.getId().equals(77)){
				meta = new NodoMetaEO();
				meta.setAvance(0);
				meta.setMeta(0);
			} else {
				meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
			}
			
			
			parametros_p1y2.put("nodo", nodo);
			parametros_p1y2.put("joinQuery", parametros.get("joinQuery"));
			parametros_p1y2.put("llave", parametros.get("llave"));
			parametros_p1y2.put("llaveCompleja", parametros.get("llaveCompleja"));
			
			parametros_p3.put("nodo", nodo);
			parametros_p3.put("joinQuery", parametros.get("joinQuery"));
			parametros_p3.put("llave", parametros.get("llave"));
			parametros_p3.put("llaveCompleja", parametros.get("llaveCompleja"));
			
			switch(nodo.getFigura().getNivel()){
			case CASILLA:
				parametros_p1y2.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosCasillas.llave FROM catalogos.casillas CatalogosCasillas JOIN catalogos.secciones CatalogosSecciones ON (CatalogosCasillas.id_entidad = CatalogosSecciones.id_entidad AND CatalogosCasillas.id_seccion = CatalogosSecciones.id_seccion) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2) GROUP BY CatalogosCasillas.llave)");
				parametros_p3.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosCasillas.llave FROM catalogos.casillas CatalogosCasillas JOIN catalogos.secciones CatalogosSecciones ON (CatalogosCasillas.id_entidad = CatalogosSecciones.id_entidad AND CatalogosCasillas.id_seccion = CatalogosSecciones.id_seccion) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3) GROUP BY CatalogosCasillas.llave)");
				break;
			case DFEDERAL:
				parametros_p1y2.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosDFederales.llave FROM catalogos.dfederales CatalogosDFederales JOIN catalogos.secciones CatalogosSecciones ON (CatalogosDFederales.id_entidad = CatalogosSecciones.id_entidad AND CatalogosDFederales.id_dfederal = CatalogosSecciones.id_dfederal) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2) GROUP BY CatalogosDFederales.llave)");
				parametros_p3.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosDFederales.llave FROM catalogos.dfederales CatalogosDFederales JOIN catalogos.secciones CatalogosSecciones ON (CatalogosDFederales.id_entidad = CatalogosSecciones.id_entidad AND CatalogosDFederales.id_dfederal = CatalogosSecciones.id_dfederal) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3) GROUP BY CatalogosDFederales.llave)");
				break;
			case DLOCAL:
				break;
			case ENTIDAD:
				parametros_p1y2.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT id_entidad::text FROM estadisticas.municipios EstadisticasMunicipios WHERE prioridad_nacional_2018 IN (1,2) GROUP BY id_entidad)");
				parametros_p3.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT id_entidad::text FROM estadisticas.municipios EstadisticasMunicipios WHERE prioridad_nacional_2018 IN (3) GROUP BY id_entidad)");
				break;
			case GEOZONA:
				break;
			case LOCALIDAD:
				break;
			case MANZANA:
				break;
			case MUNICIPIO:
				parametros_p1y2.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT llave FROM catalogos.municipios CatalogosMunicipios JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosMunicipios.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosMunicipios.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2))");
				parametros_p3.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT llave FROM catalogos.municipios CatalogosMunicipios JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosMunicipios.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosMunicipios.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3))");
				break;
			case NACIONAL:
				break;
			case SECCION:
				parametros_p1y2.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosSecciones.llave FROM catalogos.secciones CatalogosSecciones JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2) GROUP BY CatalogosSecciones.llave)");
				parametros_p3.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosSecciones.llave FROM catalogos.secciones CatalogosSecciones JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3) GROUP BY CatalogosSecciones.llave)");
				break;
			}
			
			//TODO cambio error nodo
			if(false) { //if(((NodoEO)parametros_p1y2.get("nodo")).getId().equals(76) || ((NodoEO)parametros_p1y2.get("nodo")).getId().equals(77)){
				meta_p1y2 = new NodoMetaEO();
				meta_p1y2.setMeta(0);
				meta_p1y2.setAvance(0);
			} else {
				meta_p1y2 = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros_p1y2);
			}
			
			if(false) { //if(((NodoEO)parametros_p3.get("nodo")).getId().equals(76) || ((NodoEO)parametros_p3.get("nodo")).getId().equals(77)){
				meta_p3 = new NodoMetaEO();
				meta_p3.setMeta(0);
				meta_p3.setAvance(0);
			} else {
				meta_p3 = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros_p3);
			}
			
			metas.add(meta);
			metas_p1y2.add(meta_p1y2);
			metas_p3.add(meta_p3);
			
			nodo.setMetas(metas);
			
			for(NodoEO n : estructura_p1y2.getNodos()){
				if(n.getId().equals(nodo.getId())){
					n.setMetas(metas_p1y2);
					break;
				}
			}
			
			for(NodoEO n : estructura_p3.getNodos()){
				if(n.getId().equals(nodo.getId())){
					n.setMetas(metas_p3);
					break;
				}
			}
		}
		
		viewScope.put("estructura", estructura);
		viewScope.put("estructura_p1y2", estructura_p1y2);
		viewScope.put("estructura_p3", estructura_p3);
		
	}
	
	public void estructuraOperativa2018_desgloseEntidad(RequestContext context){
		HashMap<String, Object> viewScope, parametros, registro, seleccionado;
		int[] tMeta, tAvance;
		String[] tMetaS, tAvanceS;
		List<HashMap<String, Object>> tabla;
		EstructuraEO estructura;
		List<NodoMetaEO> metas;
		NodoMetaEO meta;
		DFederalEO dFederal;
		MunicipioEO municipio;
		SeccionEO seccion;
		CasillaEO casilla;
		Modelo<EntidadEO> modeloEntidades;
		Formateador formateador;
		
		parametros = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		modeloEntidades = entidadesC.modelo();
		tabla = new ArrayList<>();
		formateador = new Formateador();
		
		tMeta = new int[5];
		tAvance = new int[5];
		for(int i = 0 ; i < 5 ; i++){
			tMeta[i] = 0;
			tAvance[i] = 0;
		}
		tMetaS = new String[10];
		tAvanceS = new String[10];
		
		
		for(EntidadEO entidad : modeloEntidades.getListado()){
			registro = new HashMap<>();
			registro.put("entidadEO", entidad);
			registro.put("id", entidad.getId());
			registro.put("entidad", entidad.getNombre());
			for(NodoEO nodo : estructura.getNodos()){
				
				parametros.put("nodo", nodo);
				
				parametros.put("joinQuery", null);
				parametros.put("llave", null);
				parametros.put("llaveCompleja", null);
				
				meta = new NodoMetaEO();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					break;
				case DFEDERAL:
					parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					parametros.put("llaveCompleja", "DFederalEO.id_entidad = " + entidad.getLlave());
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", entidad.getLlave());
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					parametros.put("llaveCompleja", "MunicipioEO.id_entidad = " + entidad.getLlave());
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + entidad.getLlave());
					break;
				}
				
				//TODO cambio error nodo
				try{
					//if(!nodo.getId().equals(76) || !nodo.getId().equals(77))
						meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
					//else
						//throw new Exception("Bye bye 76");
					
				} catch(Exception e) {
					e.printStackTrace();
					meta = new NodoMetaEO();
					meta.setMeta(0);
					meta.setAvance(0);
				}
				
				
				registro.put("meta_" + nodo.getId(), meta.getMeta());
				registro.put("avance_" + nodo.getId(), meta.getAvance());
				tMeta[nodo.getId()-73] += meta.getMeta();
				tAvance[nodo.getId()-73] += meta.getAvance();
			}
			tabla.add(registro);
		}
		
		for (int i = 0; i < 5; i++) {
			tMetaS[i] = formateador.entero(tMeta[i]);
			tAvanceS[i] = formateador.entero(tAvance[i]);
		}
		
		viewScope.put("tabla", tabla);
		viewScope.put("tMeta", tMetaS);
		viewScope.put("tAvance", tAvanceS);
		
		seleccionado = tabla.get(0);
		viewScope.put("seleccionado", seleccionado);
	}
	
	public void estructuraOperativa2018_desgloseEntidadP12(RequestContext context){
		HashMap<String, Object> viewScope, parametros, registro, seleccionado;
		int[] tMeta, tAvance;
		String[] tMetaS, tAvanceS;
		List<HashMap<String, Object>> tabla;
		EstructuraEO estructura;
		List<NodoMetaEO> metas;
		NodoMetaEO meta;
		DFederalEO dFederal;
		MunicipioEO municipio;
		SeccionEO seccion;
		CasillaEO casilla;
		Modelo<EntidadEO> modeloEntidades;
		Formateador formateador;
		
		parametros = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		modeloEntidades = entidadesC.modelo();
		tabla = new ArrayList<>();
		formateador = new Formateador();
		
		tMeta = new int[5];
		tAvance = new int[5];
		for(int i = 0 ; i < 5 ; i++){
			tMeta[i] = 0;
			tAvance[i] = 0;
		}
		tMetaS = new String[10];
		tAvanceS = new String[10];
		
		
		for(EntidadEO entidad : modeloEntidades.getListado()){
			registro = new HashMap<>();
			registro.put("entidadEO", entidad);
			registro.put("id", entidad.getId());
			registro.put("entidad", entidad.getNombre());
			for(NodoEO nodo : estructura.getNodos()){
				
				parametros.put("nodo", nodo);
				
				parametros.put("joinQuery", null);
				parametros.put("llave", null);
				parametros.put("llaveCompleja", null);
				
				meta = new NodoMetaEO();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosCasillas.llave FROM catalogos.casillas CatalogosCasillas JOIN catalogos.secciones CatalogosSecciones ON (CatalogosCasillas.id_entidad = CatalogosSecciones.id_entidad AND CatalogosCasillas.id_seccion = CatalogosSecciones.id_seccion) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2) GROUP BY CatalogosCasillas.llave)");
					break;
				case DFEDERAL:
					parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					parametros.put("llaveCompleja", "DFederalEO.id_entidad = " + entidad.getLlave());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosDFederales.llave FROM catalogos.dfederales CatalogosDFederales JOIN catalogos.secciones CatalogosSecciones ON (CatalogosDFederales.id_entidad = CatalogosSecciones.id_entidad AND CatalogosDFederales.id_dfederal = CatalogosSecciones.id_dfederal) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2) GROUP BY CatalogosDFederales.llave)");
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", entidad.getLlave());
					parametros.put("llaveCompleja", null);
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT id_entidad::text FROM estadisticas.municipios EstadisticasMunicipios WHERE prioridad_nacional_2018 IN (1,2) GROUP BY id_entidad)");
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					parametros.put("llaveCompleja", "MunicipioEO.id_entidad = " + entidad.getLlave());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT llave FROM catalogos.municipios CatalogosMunicipios JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosMunicipios.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosMunicipios.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2))");
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + entidad.getLlave());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosSecciones.llave FROM catalogos.secciones CatalogosSecciones JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2) GROUP BY CatalogosSecciones.llave)");
					break;
				}
				
				//TODO cambio error nodo
				try{
					//if(!nodo.getId().equals(76) || !nodo.getId().equals(77))
						meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
					//else
						//throw new Exception("Bye bye 76");
					
				} catch(Exception e) {
					e.printStackTrace();
					meta = new NodoMetaEO();
					meta.setMeta(0);
					meta.setAvance(0);
				}
				
				
				registro.put("meta_" + nodo.getId(), meta.getMeta());
				registro.put("avance_" + nodo.getId(), meta.getAvance());
				tMeta[nodo.getId()-73] += meta.getMeta();
				tAvance[nodo.getId()-73] += meta.getAvance();
			}
			tabla.add(registro);
		}
		
		for (int i = 0; i < 5; i++) {
			tMetaS[i] = formateador.entero(tMeta[i]);
			tAvanceS[i] = formateador.entero(tAvance[i]);
		}
		
		viewScope.put("tablaP1y2", tabla);
		viewScope.put("tMetaP1y2", tMetaS);
		viewScope.put("tAvanceP1y2", tAvanceS);
		
		seleccionado = tabla.get(0);
		viewScope.put("seleccionadoP1y2", seleccionado);
	}
	
	public void estructuraOperativa2018_desgloseEntidadP3(RequestContext context){
		HashMap<String, Object> viewScope, parametros, registro, seleccionado;
		int[] tMeta, tAvance;
		String[] tMetaS, tAvanceS;
		List<HashMap<String, Object>> tabla;
		EstructuraEO estructura;
		List<NodoMetaEO> metas;
		NodoMetaEO meta;
		DFederalEO dFederal;
		MunicipioEO municipio;
		SeccionEO seccion;
		CasillaEO casilla;
		Modelo<EntidadEO> modeloEntidades;
		Formateador formateador;
		
		parametros = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		modeloEntidades = entidadesC.modelo();
		tabla = new ArrayList<>();
		formateador = new Formateador();
		
		tMeta = new int[5];
		tAvance = new int[5];
		for(int i = 0 ; i < 5 ; i++){
			tMeta[i] = 0;
			tAvance[i] = 0;
		}
		tMetaS = new String[10];
		tAvanceS = new String[10];
		
		
		for(EntidadEO entidad : modeloEntidades.getListado()){
			registro = new HashMap<>();
			registro.put("entidadEO", entidad);
			registro.put("id", entidad.getId());
			registro.put("entidad", entidad.getNombre());
			for(NodoEO nodo : estructura.getNodos()){
				
				parametros.put("nodo", nodo);
				
				parametros.put("joinQuery", null);
				parametros.put("llave", null);
				parametros.put("llaveCompleja", null);
				
				meta = new NodoMetaEO();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosCasillas.llave FROM catalogos.casillas CatalogosCasillas JOIN catalogos.secciones CatalogosSecciones ON (CatalogosCasillas.id_entidad = CatalogosSecciones.id_entidad AND CatalogosCasillas.id_seccion = CatalogosSecciones.id_seccion) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3) GROUP BY CatalogosCasillas.llave)");
					break;
				case DFEDERAL:
					parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					parametros.put("llaveCompleja", "DFederalEO.id_entidad = " + entidad.getLlave());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosDFederales.llave FROM catalogos.dfederales CatalogosDFederales JOIN catalogos.secciones CatalogosSecciones ON (CatalogosDFederales.id_entidad = CatalogosSecciones.id_entidad AND CatalogosDFederales.id_dfederal = CatalogosSecciones.id_dfederal) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3) GROUP BY CatalogosDFederales.llave)");
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", entidad.getLlave());
					parametros.put("llaveCompleja", null);
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT id_entidad::text FROM estadisticas.municipios EstadisticasMunicipios WHERE prioridad_nacional_2018 IN (3) GROUP BY id_entidad)");
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					parametros.put("llaveCompleja", "MunicipioEO.id_entidad = " + entidad.getLlave());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT llave FROM catalogos.municipios CatalogosMunicipios JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosMunicipios.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosMunicipios.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3))");
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + entidad.getLlave());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosSecciones.llave FROM catalogos.secciones CatalogosSecciones JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3) GROUP BY CatalogosSecciones.llave)");
					break;
				}
				
				//TODO cambio error nodo
				try{
					//if(!nodo.getId().equals(76) || !nodo.getId().equals(77))
						meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
					//else
						//throw new Exception("Bye bye 76");
					
				} catch(Exception e) {
					e.printStackTrace();
					meta = new NodoMetaEO();
					meta.setMeta(0);
					meta.setAvance(0);
				}
				
				
				if(meta != null){
					try{
					registro.put("meta_" + nodo.getId(), meta.getMeta());
					registro.put("avance_" + nodo.getId(), meta.getAvance());
					tMeta[nodo.getId()-73] += meta.getMeta();
					tAvance[nodo.getId()-73] += meta.getAvance();
					} catch(Exception e){}
				} else {
					registro.put("meta_" + nodo.getId(), 0);
					registro.put("avance_" + nodo.getId(), 0);
					tMeta[nodo.getId()-73] += 0;
					tAvance[nodo.getId()-73] += 0;
				}
				
			}
			tabla.add(registro);
		}
		
		for (int i = 0; i < 5; i++) {
			tMetaS[i] = formateador.entero(tMeta[i]);
			tAvanceS[i] = formateador.entero(tAvance[i]);
		}
		
		viewScope.put("tablaP3", tabla);
		viewScope.put("tMetaP3", tMetaS);
		viewScope.put("tAvanceP3", tAvanceS);
		
		seleccionado = tabla.get(0);
		viewScope.put("seleccionadoP3", seleccionado);
	}
	
	@SuppressWarnings("unchecked")
	public void estructuraOperativa2018_desgloseMunicipio(RequestContext context){
		HashMap<String, Object> viewScope, parametros, registro, seleccionado, padre;
		int[] tMeta, tAvance;
		String[] tMetaS, tAvanceS;
		List<HashMap<String, Object>> tabla;
		EstructuraEO estructura;
		List<NodoMetaEO> metas;
		NodoMetaEO meta;
		DFederalEO dFederal;
		SeccionEO seccion;
		CasillaEO casilla;
		Modelo<EntidadEO> modeloEntidades;
		Modelo<MunicipioEO> modeloMunicipios;
		Formateador formateador;
		
		parametros = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		padre = (HashMap<String, Object>) viewScope.get("padre");
		
		modeloMunicipios = municipiosC.modelo((EntidadEO) padre.get("entidadEO"));

		tabla = new ArrayList<>();
		formateador = new Formateador();
		
		tMeta = new int[5];
		tAvance = new int[5];
		for(int i = 0 ; i < 5 ; i++){
			tMeta[i] = 0;
			tAvance[i] = 0;
		}
		tMetaS = new String[10];
		tAvanceS = new String[10];
		
		
		for(MunicipioEO municipio : modeloMunicipios.getListado()){
			registro = new HashMap<>();
			registro.put("id", municipio.getId());
			registro.put("municipio", municipio.getNombre());
			for(NodoEO nodo : estructura.getNodos()){
				
				parametros.put("nodo", nodo);
				
				parametros.put("joinQuery", null);
				parametros.put("llave", null);
				parametros.put("llaveCompleja", null);
				
				meta = new NodoMetaEO();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					//parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					//parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					break;
				case DFEDERAL:
					//parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					//parametros.put("llaveCompleja", "DFederalEO.id_entidad = " + entidad.getLlave());
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", municipio.getEntidad().getLlave());
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					parametros.put("llaveCompleja", "MunicipioEO.llave = '" + municipio.getLlave() + "'");
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + municipio.getEntidad().getLlave() + " and SeccionEO.id_municipio = " + municipio.getIdMunicipio());
					break;
				}
				
				//TODO cambio error nodo
				try{
					//if(!nodo.getId().equals(76) || !nodo.getId().equals(77))
						meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
					//else
						//throw new Exception("Bye bye 76");
					
				} catch(Exception e) {
					e.printStackTrace();
					meta = new NodoMetaEO();
					meta.setMeta(0);
					meta.setAvance(0);
				}
				
				
				registro.put("meta_" + nodo.getId(), meta.getMeta());
				registro.put("avance_" + nodo.getId(), meta.getAvance());
				tMeta[nodo.getId()-73] += meta.getMeta();
				tAvance[nodo.getId()-73] += meta.getAvance();
			}
			tabla.add(registro);
		}
		
		for (int i = 0; i < 5; i++) {
			tMetaS[i] = formateador.entero(tMeta[i]);
			tAvanceS[i] = formateador.entero(tAvance[i]);
		}
		
		viewScope.put("tabla", tabla);
		viewScope.put("tMeta", tMetaS);
		viewScope.put("tAvance", tAvanceS);
		
		seleccionado = tabla.get(0);
		viewScope.put("seleccionado", seleccionado);
	}
	
	@SuppressWarnings("unchecked")
	public void estructuraOperativa2018_desgloseMunicipioP12(RequestContext context){
		HashMap<String, Object> viewScope, parametros, registro, seleccionado, padre;
		int[] tMeta, tAvance;
		String[] tMetaS, tAvanceS;
		List<HashMap<String, Object>> tabla;
		EstructuraEO estructura;
		List<NodoMetaEO> metas;
		NodoMetaEO meta;
		DFederalEO dFederal;
		SeccionEO seccion;
		CasillaEO casilla;
		Modelo<EntidadEO> modeloEntidades;
		Modelo<MunicipioEO> modeloMunicipios;
		Formateador formateador;
		
		parametros = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		padre = (HashMap<String, Object>) viewScope.get("padre");
		
		modeloMunicipios = municipiosC.modelo((EntidadEO) padre.get("entidadEO"));

		tabla = new ArrayList<>();
		formateador = new Formateador();
		
		tMeta = new int[5];
		tAvance = new int[5];
		for(int i = 0 ; i < 5 ; i++){
			tMeta[i] = 0;
			tAvance[i] = 0;
		}
		tMetaS = new String[10];
		tAvanceS = new String[10];
		
		
		for(MunicipioEO municipio : modeloMunicipios.getListado()){
			registro = new HashMap<>();
			registro.put("id", municipio.getId());
			registro.put("municipio", municipio.getNombre());
			for(NodoEO nodo : estructura.getNodos()){
				
				parametros.put("nodo", nodo);
				
				parametros.put("joinQuery", null);
				parametros.put("llave", null);
				parametros.put("llaveCompleja", null);
				
				meta = new NodoMetaEO();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					//parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					//parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					break;
				case DFEDERAL:
					//parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					//parametros.put("llaveCompleja", "DFederalEO.id_entidad = " + entidad.getLlave());
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", municipio.getEntidad().getLlave());
					parametros.put("llaveCompleja", null);
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT id_entidad::text FROM estadisticas.municipios EstadisticasMunicipios WHERE prioridad_nacional_2018 IN (1,2) GROUP BY id_entidad)");
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					parametros.put("llaveCompleja", "MunicipioEO.llave = '" + municipio.getLlave() + "'");
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT llave FROM catalogos.municipios CatalogosMunicipios JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosMunicipios.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosMunicipios.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2))");
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + municipio.getEntidad().getLlave() + " and SeccionEO.id_municipio = " + municipio.getIdMunicipio());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosSecciones.llave FROM catalogos.secciones CatalogosSecciones JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2) GROUP BY CatalogosSecciones.llave)");
					break;
				}
				
				//TODO cambio error nodo
				try{
					//if(!nodo.getId().equals(76) || !nodo.getId().equals(77))
						meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
					//else
						//throw new Exception("Bye bye 76");
					
				} catch(Exception e) {
					e.printStackTrace();
					meta = new NodoMetaEO();
					meta.setMeta(0);
					meta.setAvance(0);
				}
				
				try{
				registro.put("meta_" + nodo.getId(), meta.getMeta());
				registro.put("avance_" + nodo.getId(), meta.getAvance());
				tMeta[nodo.getId()-73] += meta.getMeta();
				tAvance[nodo.getId()-73] += meta.getAvance();
				} catch(Exception e){}
			}
			tabla.add(registro);
		}
		
		for (int i = 0; i < 5; i++) {
			tMetaS[i] = formateador.entero(tMeta[i]);
			tAvanceS[i] = formateador.entero(tAvance[i]);
		}
		
		viewScope.put("tablaP12", tabla);
		viewScope.put("tMetaP12", tMetaS);
		viewScope.put("tAvanceP12", tAvanceS);
		
		seleccionado = tabla.get(0);
		viewScope.put("seleccionadoP12", seleccionado);
	}
	
	@SuppressWarnings("unchecked")
	public void estructuraOperativa2018_desgloseMunicipioP3(RequestContext context){
		HashMap<String, Object> viewScope, parametros, registro, seleccionado, padre;
		int[] tMeta, tAvance;
		String[] tMetaS, tAvanceS;
		List<HashMap<String, Object>> tabla;
		EstructuraEO estructura;
		List<NodoMetaEO> metas;
		NodoMetaEO meta;
		DFederalEO dFederal;
		SeccionEO seccion;
		CasillaEO casilla;
		Modelo<EntidadEO> modeloEntidades;
		Modelo<MunicipioEO> modeloMunicipios;
		Formateador formateador;
		
		parametros = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		padre = (HashMap<String, Object>) viewScope.get("padre");
		
		modeloMunicipios = municipiosC.modelo((EntidadEO) padre.get("entidadEO"));

		tabla = new ArrayList<>();
		formateador = new Formateador();
		
		tMeta = new int[5];
		tAvance = new int[5];
		for(int i = 0 ; i < 5 ; i++){
			tMeta[i] = 0;
			tAvance[i] = 0;
		}
		tMetaS = new String[10];
		tAvanceS = new String[10];
		
		
		for(MunicipioEO municipio : modeloMunicipios.getListado()){
			registro = new HashMap<>();
			registro.put("id", municipio.getId());
			registro.put("municipio", municipio.getNombre());
			for(NodoEO nodo : estructura.getNodos()){
				
				parametros.put("nodo", nodo);
				
				parametros.put("joinQuery", null);
				parametros.put("llave", null);
				parametros.put("llaveCompleja", null);
				
				meta = new NodoMetaEO();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					//parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					//parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					break;
				case DFEDERAL:
					//parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					//parametros.put("llaveCompleja", "DFederalEO.id_entidad = " + entidad.getLlave());
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", municipio.getEntidad().getLlave());
					parametros.put("llaveCompleja", null);
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT id_entidad::text FROM estadisticas.municipios EstadisticasMunicipios WHERE prioridad_nacional_2018 IN (3) GROUP BY id_entidad)");
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					parametros.put("llaveCompleja", "MunicipioEO.llave = '" + municipio.getLlave() + "'");
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT llave FROM catalogos.municipios CatalogosMunicipios JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosMunicipios.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosMunicipios.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3))");
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + municipio.getEntidad().getLlave() + " and SeccionEO.id_municipio = " + municipio.getIdMunicipio());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosSecciones.llave FROM catalogos.secciones CatalogosSecciones JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3) GROUP BY CatalogosSecciones.llave)");
					break;
				}
				
				//TODO cambio error nodo
				try{
					//if(!nodo.getId().equals(76) || !nodo.getId().equals(77))
						meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
					//else
						//throw new Exception("Bye bye 76");
					
				} catch(Exception e) {
					e.printStackTrace();
					meta = new NodoMetaEO();
					meta.setMeta(0);
					meta.setAvance(0);
				}
				
				try{
				registro.put("meta_" + nodo.getId(), meta.getMeta());
				registro.put("avance_" + nodo.getId(), meta.getAvance());
				tMeta[nodo.getId()-73] += meta.getMeta();
				tAvance[nodo.getId()-73] += meta.getAvance();
				} catch(Exception e){}
			}
			tabla.add(registro);
		}
		
		for (int i = 0; i < 5; i++) {
			tMetaS[i] = formateador.entero(tMeta[i]);
			tAvanceS[i] = formateador.entero(tAvance[i]);
		}
		
		viewScope.put("tablaP3", tabla);
		viewScope.put("tMetaP3", tMetaS);
		viewScope.put("tAvanceP3", tAvanceS);
		
		seleccionado = tabla.get(0);
		viewScope.put("seleccionadoP3", seleccionado);
	}
	
	@SuppressWarnings("unchecked")
	public void estructuraOperativa2018_desgloseDFederal(RequestContext context){
		HashMap<String, Object> viewScope, parametros, registro, seleccionado, padre;
		int[] tMeta, tAvance;
		String[] tMetaS, tAvanceS;
		List<HashMap<String, Object>> tabla;
		EstructuraEO estructura;
		List<NodoMetaEO> metas;
		NodoMetaEO meta;
		SeccionEO seccion;
		CasillaEO casilla;
		Modelo<EntidadEO> modeloEntidades;
		Modelo<MunicipioEO> modeloMunicipios;
		Modelo<DFederalEO> modeloDFederales;
		Formateador formateador;
		
		parametros = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		padre = (HashMap<String, Object>) viewScope.get("padre");
		
		modeloDFederales = dFederalesC.modelo((EntidadEO) padre.get("entidadEO"));

		tabla = new ArrayList<>();
		formateador = new Formateador();
		
		tMeta = new int[5];
		tAvance = new int[5];
		for(int i = 0 ; i < 5 ; i++){
			tMeta[i] = 0;
			tAvance[i] = 0;
		}
		tMetaS = new String[10];
		tAvanceS = new String[10];
		
		
		for(DFederalEO dFederal : modeloDFederales.getListado()){
			registro = new HashMap<>();
			registro.put("id", dFederal.getId());
			registro.put("dfederal", dFederal.getNombre());
			for(NodoEO nodo : estructura.getNodos()){
				
				parametros.put("nodo", nodo);
				
				parametros.put("joinQuery", null);
				parametros.put("llave", null);
				parametros.put("llaveCompleja", null);
				
				meta = new NodoMetaEO();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					//parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					//parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					break;
				case DFEDERAL:
					parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					parametros.put("llaveCompleja", "DFederalEO.llave = '" + dFederal.getLlave() + "'");
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", dFederal.getEntidad().getLlave());
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					//parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					//parametros.put("llaveCompleja", "MunicipioEO.llave = '" + municipio.getLlave() + "'");
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + dFederal.getEntidad().getLlave() + " and SeccionEO.id_dfederal = " + dFederal.getIdDFederal());
					break;
				}
				
				//TODO cambio error nodo
				try{
					//if(!nodo.getId().equals(76) || !nodo.getId().equals(77))
						meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
					//else
						//throw new Exception("Bye bye 76");
					
				} catch(Exception e) {
					e.printStackTrace();
					meta = new NodoMetaEO();
					meta.setMeta(0);
					meta.setAvance(0);
				}
				
				
				registro.put("meta_" + nodo.getId(), meta.getMeta());
				registro.put("avance_" + nodo.getId(), meta.getAvance());
				tMeta[nodo.getId()-73] += meta.getMeta();
				tAvance[nodo.getId()-73] += meta.getAvance();
			}
			tabla.add(registro);
		}
		
		for (int i = 0; i < 5; i++) {
			tMetaS[i] = formateador.entero(tMeta[i]);
			tAvanceS[i] = formateador.entero(tAvance[i]);
		}
		
		viewScope.put("tabla", tabla);
		viewScope.put("tMeta", tMetaS);
		viewScope.put("tAvance", tAvanceS);
		
		seleccionado = tabla.get(0);
		viewScope.put("seleccionado", seleccionado);
	}
	
	@SuppressWarnings("unchecked")
	public void estructuraOperativa2018_desgloseDFederalP12(RequestContext context){
		HashMap<String, Object> viewScope, parametros, registro, seleccionado, padre;
		int[] tMeta, tAvance;
		String[] tMetaS, tAvanceS;
		List<HashMap<String, Object>> tabla;
		EstructuraEO estructura;
		List<NodoMetaEO> metas;
		NodoMetaEO meta;
		SeccionEO seccion;
		CasillaEO casilla;
		Modelo<EntidadEO> modeloEntidades;
		Modelo<MunicipioEO> modeloMunicipios;
		Modelo<DFederalEO> modeloDFederales;
		Formateador formateador;
		
		parametros = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		padre = (HashMap<String, Object>) viewScope.get("padre");
		
		modeloDFederales = dFederalesC.modelo((EntidadEO) padre.get("entidadEO"));

		tabla = new ArrayList<>();
		formateador = new Formateador();
		
		tMeta = new int[5];
		tAvance = new int[5];
		for(int i = 0 ; i < 5 ; i++){
			tMeta[i] = 0;
			tAvance[i] = 0;
		}
		tMetaS = new String[10];
		tAvanceS = new String[10];
		
		
		for(DFederalEO dFederal : modeloDFederales.getListado()){
			registro = new HashMap<>();
			registro.put("id", dFederal.getId());
			registro.put("dfederal", dFederal.getNombre());
			for(NodoEO nodo : estructura.getNodos()){
				
				parametros.put("nodo", nodo);
				
				parametros.put("joinQuery", null);
				parametros.put("llave", null);
				parametros.put("llaveCompleja", null);
				
				meta = new NodoMetaEO();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					//parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					//parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					break;
				case DFEDERAL:
					parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					parametros.put("llaveCompleja", "DFederalEO.llave = '" + dFederal.getLlave() + "'");
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosDFederales.llave FROM catalogos.dfederales CatalogosDFederales JOIN catalogos.secciones CatalogosSecciones ON (CatalogosDFederales.id_entidad = CatalogosSecciones.id_entidad AND CatalogosDFederales.id_dfederal = CatalogosSecciones.id_dfederal) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2) GROUP BY CatalogosDFederales.llave)");
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", dFederal.getEntidad().getLlave());
					parametros.put("llaveCompleja", null);
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT id_entidad::text FROM estadisticas.municipios EstadisticasMunicipios WHERE prioridad_nacional_2018 IN (1,2) GROUP BY id_entidad)");
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					//parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					//parametros.put("llaveCompleja", "MunicipioEO.llave = '" + municipio.getLlave() + "'");
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + dFederal.getEntidad().getLlave() + " and SeccionEO.id_dfederal = " + dFederal.getIdDFederal());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosSecciones.llave FROM catalogos.secciones CatalogosSecciones JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (1,2) GROUP BY CatalogosSecciones.llave)");
					break;
				}
				
				//TODO cambio error nodo
				try{
					//if(!nodo.getId().equals(76) || !nodo.getId().equals(77))
						meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
					//else
						//throw new Exception("Bye bye 76");
					
				} catch(Exception e) {
					e.printStackTrace();
					meta = new NodoMetaEO();
					meta.setMeta(0);
					meta.setAvance(0);
				}
				
				try{
				registro.put("meta_" + nodo.getId(), meta.getMeta());
				registro.put("avance_" + nodo.getId(), meta.getAvance());
				tMeta[nodo.getId()-73] += meta.getMeta();
				tAvance[nodo.getId()-73] += meta.getAvance();
				} catch(Exception e){}
			}
			tabla.add(registro);
		}
		
		for (int i = 0; i < 5; i++) {
			tMetaS[i] = formateador.entero(tMeta[i]);
			tAvanceS[i] = formateador.entero(tAvance[i]);
		}
		
		viewScope.put("tablaP12", tabla);
		viewScope.put("tMetaP12", tMetaS);
		viewScope.put("tAvanceP12", tAvanceS);
		
		seleccionado = tabla.get(0);
		viewScope.put("seleccionadoP12", seleccionado);
	}
	
	@SuppressWarnings("unchecked")
	public void estructuraOperativa2018_desgloseDFederalP3(RequestContext context){
		HashMap<String, Object> viewScope, parametros, registro, seleccionado, padre;
		int[] tMeta, tAvance;
		String[] tMetaS, tAvanceS;
		List<HashMap<String, Object>> tabla;
		EstructuraEO estructura;
		List<NodoMetaEO> metas;
		NodoMetaEO meta;
		SeccionEO seccion;
		CasillaEO casilla;
		Modelo<EntidadEO> modeloEntidades;
		Modelo<MunicipioEO> modeloMunicipios;
		Modelo<DFederalEO> modeloDFederales;
		Formateador formateador;
		
		parametros = new HashMap<>();

		estructura = estructurasC.obtenerPorId(32);
		
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		padre = (HashMap<String, Object>) viewScope.get("padre");
		
		modeloDFederales = dFederalesC.modelo((EntidadEO) padre.get("entidadEO"));

		tabla = new ArrayList<>();
		formateador = new Formateador();
		
		tMeta = new int[5];
		tAvance = new int[5];
		for(int i = 0 ; i < 5 ; i++){
			tMeta[i] = 0;
			tAvance[i] = 0;
		}
		tMetaS = new String[10];
		tAvanceS = new String[10];
		
		
		for(DFederalEO dFederal : modeloDFederales.getListado()){
			registro = new HashMap<>();
			registro.put("id", dFederal.getId());
			registro.put("dfederal", dFederal.getNombre());
			for(NodoEO nodo : estructura.getNodos()){
				
				parametros.put("nodo", nodo);
				
				parametros.put("joinQuery", null);
				parametros.put("llave", null);
				parametros.put("llaveCompleja", null);
				
				meta = new NodoMetaEO();
				switch(nodo.getFigura().getNivel()){
				case CASILLA:
					//parametros.put("joinQuery", "JOIN catalogos.casillas CasillaEO on (NodoMetaEO.llave = CasillaEO.llave)");
					//parametros.put("llaveCompleja", "CasillaEO.id_entidad = " + entidad.getLlave());
					break;
				case DFEDERAL:
					parametros.put("joinQuery", "JOIN catalogos.dfederales DFederalEO on (NodoMetaEO.llave = DFederalEO.llave)");
					parametros.put("llaveCompleja", "DFederalEO.llave = '" + dFederal.getLlave() + "'");
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosDFederales.llave FROM catalogos.dfederales CatalogosDFederales JOIN catalogos.secciones CatalogosSecciones ON (CatalogosDFederales.id_entidad = CatalogosSecciones.id_entidad AND CatalogosDFederales.id_dfederal = CatalogosSecciones.id_dfederal) JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3) GROUP BY CatalogosDFederales.llave)");
					break;
				case DLOCAL:
					break;
				case ENTIDAD:
					parametros.put("llave", dFederal.getEntidad().getLlave());
					parametros.put("llaveCompleja", null);
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT id_entidad::text FROM estadisticas.municipios EstadisticasMunicipios WHERE prioridad_nacional_2018 IN (3) GROUP BY id_entidad)");
					break;
				case GEOZONA:
					break;
				case LOCALIDAD:
					break;
				case MANZANA:
					break;
				case MUNICIPIO:
					//parametros.put("joinQuery", "JOIN catalogos.municipios MunicipioEO on (NodoMetaEO.llave = MunicipioEO.llave)");
					//parametros.put("llaveCompleja", "MunicipioEO.llave = '" + municipio.getLlave() + "'");
					break;
				case NACIONAL:
					break;
				case SECCION:
					parametros.put("joinQuery", "JOIN catalogos.secciones SeccionEO on (NodoMetaEO.llave = SeccionEO.llave)");
					parametros.put("llaveCompleja", "SeccionEO.id_entidad = " + dFederal.getEntidad().getLlave() + " and SeccionEO.id_dfederal = " + dFederal.getIdDFederal());
					parametros.put("llaveCompleja2", "NodoMetaEO.llave in (SELECT CatalogosSecciones.llave FROM catalogos.secciones CatalogosSecciones JOIN estadisticas.municipios EstadisticasMunicipios ON (CatalogosSecciones.id_entidad = EstadisticasMunicipios.id_entidad AND CatalogosSecciones.id_municipio = EstadisticasMunicipios.id_municipio) WHERE EstadisticasMunicipios.prioridad_nacional_2018 IN (3) GROUP BY CatalogosSecciones.llave)");
					break;
				}
				
				//TODO cambio error nodo
				try{
					//if(!nodo.getId().equals(76) || !nodo.getId().equals(77))
						meta = sqlSession.selectOne("estructuras.nodos.metasPorNodoDinamico", parametros);
					//else
						//throw new Exception("Bye bye 76");
					
				} catch(Exception e) {
					e.printStackTrace();
					meta = new NodoMetaEO();
					meta.setMeta(0);
					meta.setAvance(0);
				}
				
				try{
				registro.put("meta_" + nodo.getId(), meta.getMeta());
				registro.put("avance_" + nodo.getId(), meta.getAvance());
				tMeta[nodo.getId()-73] += meta.getMeta();
				tAvance[nodo.getId()-73] += meta.getAvance();
				} catch(Exception e){}
			}
			tabla.add(registro);
		}
		
		for (int i = 0; i < 5; i++) {
			tMetaS[i] = formateador.entero(tMeta[i]);
			tAvanceS[i] = formateador.entero(tAvance[i]);
		}
		
		viewScope.put("tablaP3", tabla);
		viewScope.put("tMetaP3", tMetaS);
		viewScope.put("tAvanceP3", tAvanceS);
		
		seleccionado = tabla.get(0);
		viewScope.put("seleccionadoP3", seleccionado);
	}
	
	public NivelesDO nivelPredeterminado(){
		return NivelesDO.NACIONAL;
	}
	
	public void concentradoEstatal(String vista, EntidadEO entidad, RequestContext context){
		HashMap<String, Object> viewScope;
		
		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		
		switch(vista){
		case "Gobernador":
			viewScope.put("gobernador", infoGobernador(entidad));
			break;
		case "ExGobernadores":
			viewScope.put("modeloExGobernadores", infoExGobernadores(entidad));
			break;
		case "Senadores de MR":
			viewScope.put("modeloSenadoresMR", infoSenadoresMR(entidad));
			break;
		case "Senadores de RP":
			viewScope.put("modeloSenadoresRP", infoSenadoresRP(entidad));
			break;
		case "Diputados de MR":
			viewScope.put("modeloDiputadosMR", infoDiputadosMR(entidad));
			break;
		case "Presidentes Municipales":
			viewScope.put("modeloPresidentesMunicipales", infoPresidentesMunicipales(entidad));
			break;
		}
		
	}
	
	public HashMap<String, Object> infoGobernador(EntidadEO entidad){
		HashMap<String, Object> gobernador, parametros;
		HashMap<String, Integer> mapa;
		List<HashMap<String, Object>> atributos;
		PersonaEO persona;
		PartidoEO partido;
		FiguraAtributosDO figuraAtributo;
		
		gobernador = new HashMap<>();
		persona = new PersonaEO();
		
		mapa = sqlSession.selectOne("estructuras.reportes.gobernadorPorEntidad", entidad);
		
		if(mapa != null){
			persona = personasC.personaSimplePorId(mapa.get("id_persona"), mapa.get("id_entidad_nacimiento"));
			gobernador.put("persona", persona);
			parametros = new HashMap<>();
			parametros.put("idPolitik", mapa.get("id_politik"));
			parametros.put("idEstructura", 26);
			
			atributos = sqlSession.selectList("estructuras.reportes.atributos", parametros);
			for(HashMap<String, Object> atributo : atributos){
				figuraAtributo = FiguraAtributosDO.valueOf((String) atributo.get("tipo_atributo"));
				switch(figuraAtributo){
				case PARTIDO_POLITICO:
					partido = partidosC.partidoPorId((Integer) atributo.get("dato01_int"));
					gobernador.put("partido", partido);
					break;
				case PERIODO:
					gobernador.put("fechaInicio", atributo.get("dato01_text"));
					gobernador.put("fechaTermino", atributo.get("dato02_text"));
					break;
				}
			}
			
		}
		
		return gobernador;
	}
	
	public Modelo<HashMap<String, Object>> infoExGobernadores(EntidadEO entidad){
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> mapa, listado, atributos;
		HashMap<String, Object> gobernador, parametros;
		PersonaEO persona;
		PartidoEO partido;
		FiguraAtributosDO figuraAtributo;
		
		modelo = new Modelo<>();
		listado = new ArrayList<>();
		
		mapa = sqlSession.selectList("estructuras.reportes.exGobernadoresPorEntidad", entidad);
		logger.debug("mapa: {}", mapa);
		
		parametros = new HashMap<>();
		parametros.put("idEstructura", 26);
		if(mapa != null){
			for(HashMap<String, Object> reg : mapa){
				gobernador = new HashMap<>();
				persona = personasC.personaSimplePorId(((Integer)reg.get("id_persona")), ((Integer)reg.get("id_entidad_nacimiento")));
				gobernador.put("persona", persona);
				parametros.put("idPolitik", reg.get("id_politik"));
				atributos = sqlSession.selectList("estructuras.reportes.atributos", parametros);
				for(HashMap<String, Object> atributo : atributos){
					figuraAtributo = FiguraAtributosDO.valueOf((String) atributo.get("tipo_atributo"));
					switch(figuraAtributo){
					case PARTIDO_POLITICO:
						partido = partidosC.partidoPorId((Integer) atributo.get("dato01_int"));
						gobernador.put("partido", partido);
						break;
					case PERIODO:
						gobernador.put("fechaInicio", atributo.get("dato01_text"));
						gobernador.put("fechaTermino", atributo.get("dato02_text"));
						break;
					}
				}
				listado.add(gobernador);
			}
		}
		logger.debug("listado de Exgobernadores: {}", listado);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<HashMap<String, Object>> infoSenadoresMR(EntidadEO entidad){
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> mapa, listado, atributos;
		HashMap<String, Object> senador, parametros;
		PersonaEO persona;
		PartidoEO partido;
		FiguraAtributosDO figuraAtributo;
		
		modelo = new Modelo<>();
		listado = new ArrayList<>();
		
		mapa = sqlSession.selectList("estructuras.reportes.senadoresMRPorEntidad", entidad);
		logger.debug("mapa: {}", mapa);
		
		parametros = new HashMap<>();
		parametros.put("idEstructura", 27);
		if(mapa != null){
			for(HashMap<String, Object> reg : mapa){
				senador = new HashMap<>();
				persona = personasC.personaSimplePorId(((Integer)reg.get("id_persona")), ((Integer)reg.get("id_entidad_nacimiento")));
				senador.put("persona", persona);
				parametros.put("idPolitik", reg.get("id_politik"));
				atributos = sqlSession.selectList("estructuras.reportes.atributos", parametros);
				for(HashMap<String, Object> atributo : atributos){
					figuraAtributo = FiguraAtributosDO.valueOf((String) atributo.get("tipo_atributo"));
					switch(figuraAtributo){
					case PARTIDO_POLITICO:
						partido = partidosC.partidoPorId((Integer) atributo.get("dato01_int"));
						senador.put("partido", partido);
						break;
					}
				}
				listado.add(senador);
			}
		}
		logger.debug("listado de Senadores: {}", listado);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<HashMap<String, Object>> infoSenadoresRP(EntidadEO entidad){
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> mapa, listado, atributos;
		HashMap<String, Object> senador, parametros;
		PersonaEO persona;
		PartidoEO partido;
		FiguraAtributosDO figuraAtributo;
		
		modelo = new Modelo<>();
		listado = new ArrayList<>();
		
		mapa = sqlSession.selectList("estructuras.reportes.senadoresRPPorEntidad", entidad);
		logger.debug("mapa: {}", mapa);
		
		parametros = new HashMap<>();
		parametros.put("idEstructura", 28);
		if(mapa != null){
			for(HashMap<String, Object> reg : mapa){
				senador = new HashMap<>();
				persona = personasC.personaSimplePorId(((Integer)reg.get("id_persona")), ((Integer)reg.get("id_entidad_nacimiento")));
				senador.put("persona", persona);
				parametros.put("idPolitik", reg.get("id_politik"));
				atributos = sqlSession.selectList("estructuras.reportes.atributos", parametros);
				for(HashMap<String, Object> atributo : atributos){
					figuraAtributo = FiguraAtributosDO.valueOf((String) atributo.get("tipo_atributo"));
					switch(figuraAtributo){
					case PARTIDO_POLITICO:
						partido = partidosC.partidoPorId((Integer) atributo.get("dato01_int"));
						senador.put("partido", partido);
						break;
					}
				}
				listado.add(senador);
			}
		}
		logger.debug("listado de Senadores: {}", listado);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<HashMap<String, Object>> infoDiputadosMR(EntidadEO entidad){
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> mapa, listado, atributos;
		HashMap<String, Object> diputado, parametros;
		PersonaEO persona;
		PartidoEO partido;
		FiguraAtributosDO figuraAtributo;
		
		modelo = new Modelo<>();
		listado = new ArrayList<>();
		
		mapa = sqlSession.selectList("estructuras.reportes.diputadosMRPorEntidad", entidad);
		logger.debug("mapa: {}", mapa);
		
		parametros = new HashMap<>();
		parametros.put("idEstructura", 29);
		if(mapa != null){
			for(HashMap<String, Object> reg : mapa){
				diputado = new HashMap<>();
				persona = personasC.personaSimplePorId(((Integer)reg.get("id_persona")), ((Integer)reg.get("id_entidad_nacimiento")));
				diputado.put("persona", persona);
				parametros.put("idPolitik", reg.get("id_politik"));
				atributos = sqlSession.selectList("estructuras.reportes.atributos", parametros);
				for(HashMap<String, Object> atributo : atributos){
					figuraAtributo = FiguraAtributosDO.valueOf((String) atributo.get("tipo_atributo"));
					switch(figuraAtributo){
					case PARTIDO_POLITICO:
						partido = partidosC.partidoPorId((Integer) atributo.get("dato01_int"));
						diputado.put("partido", partido);
						break;
					}
				}
				listado.add(diputado);
			}
		}
		logger.debug("listado de Diputados de MR: {}", listado);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<HashMap<String, Object>> infoPresidentesMunicipales(EntidadEO entidad){
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> mapa, listado, atributos;
		HashMap<String, Object> presidenteMunicipal, parametros;
		PersonaEO persona;
		PartidoEO partido;
		FiguraAtributosDO figuraAtributo;
		
		modelo = new Modelo<>();
		listado = new ArrayList<>();
		
		mapa = sqlSession.selectList("estructuras.reportes.presidentesMunicipalesPorEntidad", entidad);
		logger.debug("mapa: {}", mapa);
		
		parametros = new HashMap<>();
		parametros.put("idEstructura", 31);
		if(mapa != null){
			for(HashMap<String, Object> reg : mapa){
				presidenteMunicipal = new HashMap<>();
				persona = personasC.personaSimplePorId(((Integer)reg.get("id_persona")), ((Integer)reg.get("id_entidad_nacimiento")));
				presidenteMunicipal.put("persona", persona);
				parametros.put("idPolitik", reg.get("id_politik"));
				presidenteMunicipal.put("territorio", municipiosC.buscarPorLlave((String) reg.get("llave")));
				
				atributos = sqlSession.selectList("estructuras.reportes.atributos", parametros);
				for(HashMap<String, Object> atributo : atributos){
					figuraAtributo = FiguraAtributosDO.valueOf((String) atributo.get("tipo_atributo"));
					switch(figuraAtributo){
					case PARTIDO_POLITICO:
						partido = partidosC.partidoPorId((Integer) atributo.get("dato01_int"));
						presidenteMunicipal.put("partido", partido);
						break;
					case PERIODO:
						presidenteMunicipal.put("fechaInicio", atributo.get("dato01_text"));
						presidenteMunicipal.put("fechaTermino", atributo.get("dato02_text"));
						break;
					}
				}
				listado.add(presidenteMunicipal);
			}
		}
		logger.debug("listado de Presidentes Municipales: {}", listado);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public JavaBeanT territorioEnCoordenadas(String[] coordenadas){
		JavaBeanT territorio;
		
		logger.debug("parametros: {}, {}", coordenadas[0], coordenadas[1]);
		
		territorio = entidadesC.porCoordenadas(coordenadas);
		
		return territorio;
	}
}
