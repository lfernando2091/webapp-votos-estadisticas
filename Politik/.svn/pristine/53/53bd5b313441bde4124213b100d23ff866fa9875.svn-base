package com.saganet.politik.components.diaD.reportes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LegendPlacement;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.map.MapModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.components.catalogos.MunicipiosC;
import com.saganet.politik.components.sig.PoligonosC;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.database.diaD.ParametrosMuncipios;
import com.saganet.politik.dominios.NivelReporteCompletoDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.dominios.TiposColumnaDO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.utilidades.Columna;
import com.saganet.politik.utilidades.Poligono;

import mx.com.saganet.peon.database.dominios.TiposPoligonoDO;

@Component("diaDReportesMetasJornadaEstatica")
public class MetasJornadaEstaticaC {
	private static final Logger logger = LoggerFactory.getLogger(MetasJornadaEstaticaC.class);
	
	@Autowired SqlSession sqlSession;
	@Autowired PoligonosC poligonosC;
	@Autowired MunicipiosC municipiosC;
	@Autowired ParametrosMuncipios parametrosReportesMunicipios;
	
	public String elegirGrupo(Modelo<ProgramasEdoMexDO> modeloGrupos){
		String grupo;
		
		if(modeloGrupos.getListado().size() > 1)
			grupo = "Todos";
		else
			grupo = modeloGrupos.getSeleccionado().getNombre2();
		
		return grupo;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> metasJornada(RequestContext rc){
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> mapa, parametros, viewScope, totales;
		List<Columna> columnas; 
		NivelReporteCompletoDO nivel;
		Modelo<NivelReporteCompletoDO> modeloNiveles;
		Modelo<GeozonaParticionEO> modeloRegiones;
		Modelo<MunicipioEO> modeloMunicipios;
		Modelo<SeccionEO> modeloSecciones;
		MapModel modeloMapa;
		int meta, registrados, noRegistrados;
		
		
		mapa = new HashMap<>();
		parametros = new HashMap<>();
		totales = new HashMap<>();
		columnas = new ArrayList<>();
		viewScope = (HashMap<String, Object>) rc.getViewScope().asMap();
		modeloNiveles = (Modelo<NivelReporteCompletoDO>) viewScope.get("modeloNiveles");
		modeloRegiones = (Modelo<GeozonaParticionEO>) viewScope.get("modeloRegiones");
		modeloMunicipios = (Modelo<MunicipioEO>) viewScope.get("modeloMunicipios");
		modeloSecciones = (Modelo<SeccionEO>) viewScope.get("modeloSecciones");
		
		listado = null;
		modeloMapa = null;
		parametros.put("grupo", viewScope.get("grupo"));
		nivel = modeloNiveles.getSeleccionado();
		meta = 0;
		registrados = 0;
		noRegistrados = 0;
		switch(nivel){
		case GENERAL:
			listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.general", parametros);
			totales.put("pkey", 0);
			totales.put("entidad", "Totales");
			
			columnas.add(new Columna("Entidad", "entidad", TiposColumnaDO.TEXTO));
			columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
			listado.get(0).put("llave", "15");
			modeloMapa = mapaAvance(TiposPoligonoDO.ENTIDAD, listado);
			break;
		case ESTATAL:
			listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.estatal", parametros);
			totales.put("pkey", 0);
			totales.put("region", "");
			totales.put("nombre_region", "Totales");
			
			columnas.add(new Columna("idRegión", "region", TiposColumnaDO.TEXTO));
			columnas.add(new Columna("Región", "nombre_region", TiposColumnaDO.TEXTO));
			columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
			modeloMapa = mapaAvance(TiposPoligonoDO.REGION, listado);
			break;
		case REGION:
			parametros.put("idRegion", modeloRegiones.getSeleccionado().getIdParticion());
			listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.region", parametros);
			totales.put("pkey", 0);
			totales.put("municipio", "");
			totales.put("nombre_municipio", "Totales");
			
			columnas.add(new Columna("idMunicipio", "municipio", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Municipio", "nombre_municipio", TiposColumnaDO.TEXTO));
			columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
			modeloMapa = mapaAvance(TiposPoligonoDO.MUNICIPIO, listado);
			break;
		case MUNICIPIO:
			parametros.put("idMunicipio", modeloMunicipios.getSeleccionado().getIdMunicipio());
			listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.municipio", parametros);
			totales.put("pkey", 0);
			totales.put("seccion", "Totales");
			
			columnas.add(new Columna("Sección", "seccion", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
			modeloMapa = mapaAvance(TiposPoligonoDO.SECCION, listado);
			break;
		case SECCION:
			parametros.put("idSeccion", modeloSecciones.getSeleccionado().getIdSeccion());
			listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.seccion", parametros);
			totales.put("pkey", "0");
			totales.put("loc_man", "Totales");
			
			columnas.add(new Columna("Manzana", "loc_man", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
			modeloMapa = mapaAvance(TiposPoligonoDO.MANZANA, listado);
			break;
		}

		for(HashMap<String, Object> t : listado){
			meta += (int) t.get("meta");
			registrados += (int) t.get("registrados");
			noRegistrados += (int) t.get("no_registrados");
		}
		totales.put("meta", meta);
		totales.put("registrados", registrados);
		totales.put("no_registrados", noRegistrados);
		listado.add(0, totales);

		
		mapa.put("modeloMetas", new Modelo<>(listado));
		mapa.put("columnas", columnas);
		mapa.put("modeloMapa", modeloMapa);
		if (listado.size()>1 && (nivel.equals(NivelReporteCompletoDO.MUNICIPIO)||nivel.equals(NivelReporteCompletoDO.REGION))) {
			mapa.put("seleccionado", listado.get(1));
		}
		return mapa;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> metasJornadaSinMapa(RequestContext rc, int porMunicipio){
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> mapa, parametros, viewScope, totales;
		List<Columna> columnas; 
		NivelReporteCompletoDO nivel;
		Modelo<NivelReporteCompletoDO> modeloNiveles;
		Modelo<GeozonaParticionEO> modeloRegiones;
		Modelo<MunicipioEO> modeloMunicipios;
		Modelo<SeccionEO> modeloSecciones;
		int meta, registrados, noRegistrados;
		PieChartModel modeloPie;
		
		
		mapa = new HashMap<>();
		parametros = new HashMap<>();
		totales = new HashMap<>();
		columnas = new ArrayList<>();
		viewScope = (HashMap<String, Object>) rc.getViewScope().asMap();
		modeloNiveles = (Modelo<NivelReporteCompletoDO>) viewScope.get("modeloNiveles");
		modeloRegiones = (Modelo<GeozonaParticionEO>) viewScope.get("modeloRegiones");
		modeloMunicipios = (Modelo<MunicipioEO>) viewScope.get("modeloMunicipios");
		modeloSecciones = (Modelo<SeccionEO>) viewScope.get("modeloSecciones");
		
		listado = null;
		parametros.put("grupo", viewScope.get("grupo"));
		nivel = modeloNiveles.getSeleccionado();
		meta = 0;
		registrados = 0;
		noRegistrados = 0;
		
		if(porMunicipio > 0){
			switch(porMunicipio){
			case 1:
				parametros.put("idRegion", 0);
				break;
			case 34:
				parametros.put("idRegion", -1);
				break;
			case 91:
				parametros.put("idRegion", -2);
				break;
			}
			
			logger.debug("idRegion1: {}", parametros.get("idRegion"));

			listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.region", parametros);
			totales.put("pkey", 0);
			totales.put("municipio", "");
			totales.put("nombre_municipio", "Totales");
			
			columnas.add(new Columna("idMunicipio", "municipio", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Municipio", "nombre_municipio", TiposColumnaDO.TEXTO));
			columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
		} else {
			switch(nivel){
			case GENERAL:
				listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.general", parametros);
				totales.put("pkey", 0);
				totales.put("entidad", "Totales");
				
				columnas.add(new Columna("Entidad", "entidad", TiposColumnaDO.TEXTO));
				columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
				listado.get(0).put("llave", "15");
				break;
			case ESTATAL:
				listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.estatal", parametros);
				totales.put("pkey", 0);
				totales.put("region", "");
				totales.put("nombre_region", "Totales");
				
				columnas.add(new Columna("idRegión", "region", TiposColumnaDO.TEXTO));
				columnas.add(new Columna("Región", "nombre_region", TiposColumnaDO.TEXTO));
				columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
				break;
			case REGION:
				parametros.put("idRegion", modeloRegiones.getSeleccionado().getIdParticion());
				listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.region", parametros);
				totales.put("pkey", 0);
				totales.put("municipio", "");
				totales.put("nombre_municipio", "Totales");
				logger.debug("idRegion2: {}", parametros.get("idRegion"));
				
				columnas.add(new Columna("idMunicipio", "municipio", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Municipio", "nombre_municipio", TiposColumnaDO.TEXTO));
				columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
				break;
			case MUNICIPIO:
				parametros.put("idMunicipio", modeloMunicipios.getSeleccionado().getIdMunicipio());
				listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.municipio", parametros);
				totales.put("pkey", 0);
				totales.put("seccion", "Totales");
				
				columnas.add(new Columna("Sección", "seccion", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
				break;
			case SECCION:
				parametros.put("idSeccion", modeloSecciones.getSeleccionado().getIdSeccion());
				listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.seccion", parametros);
				totales.put("pkey", "0");
				totales.put("loc_man", "Totales");
				
				columnas.add(new Columna("Manzana", "loc_man", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Meta", "meta", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Votaron", "registrados", TiposColumnaDO.ENTERO));
				columnas.add(new Columna("Pendientes", "no_registrados", TiposColumnaDO.ENTERO));
				break;
			}
		}
		
		for(HashMap<String, Object> t : listado){
			meta += (int) t.get("meta");
			registrados += (int) t.get("registrados");
			noRegistrados += (int) t.get("no_registrados");
		}
		totales.put("meta", meta);
		totales.put("registrados", registrados);
		totales.put("no_registrados", noRegistrados);
		listado.add(0, totales);
		
		modeloPie = new PieChartModel();
		modeloPie.set("Pendientes", noRegistrados);
		modeloPie.set("Votaron", registrados);
		modeloPie.setTitle("Totales");
		modeloPie.setLegendPosition("s");
		modeloPie.setLegendCols(4);
		modeloPie.setShowDataLabels(true);
		modeloPie.setSeriesColors("E6E6E6, 04B431");
		
		mapa.put("modeloPie", modeloPie);

		mapa.put("modeloMetas", new Modelo<>(listado));
		mapa.put("columnas", columnas);

		if (listado.size()>1 && (nivel.equals(NivelReporteCompletoDO.MUNICIPIO)||nivel.equals(NivelReporteCompletoDO.REGION))) {
			mapa.put("seleccionado", listado.get(1));
		}
		return mapa;
	}
	
	public HashMap<String, Object> tablero(){
		HashMap<String, Object> mapaGlobal, mapaGrupo;
		List<HashMap<String, Object>> listado;
		MeterGaugeChartModel medidor;
		MapModel modeloMapa;
		List<Poligono> poligonos;
		Poligono poligono;
		MunicipioEO municipio;
		int meta, registrados;
		double avance;
		List<HashMap<String, Object>> cortes;
		//LineChartModel grafica;
		BarChartModel grafica;
		LineChartSeries serieMeta;
		BarChartSeries serieTodos, serieRowan, serieAbby, serieFitz, serieHermanos;
		String etiquetasCortes[];
		Axis yAxis;
		
		mapaGlobal = new HashMap<>();
		mapaGrupo = new HashMap<>();
		
		//Medidor General
		medidor = modeloMedidorAvance(NivelReporteCompletoDO.GENERAL, "Todos", "Total", mapaGrupo);
		mapaGlobal.put("general", new HashMap<>(mapaGrupo));
		mapaGlobal.put("medidorGeneral", medidor);
		logger.debug("mapaGrupo General: {}", mapaGlobal.get("general"));
		
		//Medidor Rowan
		medidor = modeloMedidorAvance(NivelReporteCompletoDO.GENERAL, ProgramasEdoMexDO.INSUS.getNombre2(), "Rowan", mapaGrupo);
		mapaGlobal.put("rowan", new HashMap<>(mapaGrupo));
		mapaGlobal.put("medidorRowan", medidor);
		logger.debug("mapaGrupo Rowan: {}", mapaGlobal.get("rowan"));
		
		//Medidor Abby
		medidor = modeloMedidorAvance(NivelReporteCompletoDO.GENERAL, ProgramasEdoMexDO.PROSPERA.getNombre2(), "Abby", mapaGrupo);
		mapaGlobal.put("abby", new HashMap<>(mapaGrupo));
		mapaGlobal.put("medidorAbby", medidor);
		logger.debug("mapaGrupo Abby: {}", mapaGlobal.get("abby"));
		
		//Medidor Fitz
		medidor = modeloMedidorAvance(NivelReporteCompletoDO.GENERAL, ProgramasEdoMexDO.LICONSA.getNombre2(), "Fitz", mapaGrupo);
		mapaGlobal.put("fitz", new HashMap<>(mapaGrupo));
		mapaGlobal.put("medidorFitz", medidor);
		logger.debug("mapaGrupo Fitz: {}", mapaGlobal.get("fitz"));

		//Medidor Hermanos
		medidor = modeloMedidorAvance(NivelReporteCompletoDO.GENERAL, ProgramasEdoMexDO.HERMANOS.getNombre2(), "Hermanos", mapaGrupo);
		mapaGlobal.put("hermanos", new HashMap<>(mapaGrupo));
		mapaGlobal.put("medidorHermanos", medidor);
		logger.debug("mapaGrupo Hermanos: {}", mapaGlobal.get("hermanos"));

		//Mapa Municipal
		poligonos = new ArrayList<>();
		
		//Polígono entidad
		poligono = new Poligono();
		poligono.setTipo(TiposPoligonoDO.ENTIDAD);
		poligono.setLlave("15");
		poligono.setOpacidadRelleno(0);
		poligono.setGrosorLinea(2);
		poligono.setOpacidadLinea(1);
		poligonos.add(poligono);
		
		//Polígonos Region
		listado = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.municipiosMapa");
		for(HashMap<String, Object> m : listado){
			municipio = municipiosC.buscarPorLlave((String) m.get("llave_municipio"));
			registrados = (int) m.get("registrados");
			meta = (int) m.get("meta");
			avance = registrados / (double)meta;
			logger.debug("meta: {}, registrados: {}, avance: {}", meta, registrados, avance);
			
			poligono = new Poligono();
			poligono.setTipo(TiposPoligonoDO.MUNICIPIO);
			poligono.setLlave(municipio.getLlave());
			poligono.setOpacidadRelleno(0.5);

			if (avance < 0.25)
				poligono.setColorRelleno("GRAY");
			else if (avance < 0.50)
				poligono.setColorRelleno("ORANGE");
			else if (avance < 0.75)
				poligono.setColorRelleno("RED");
			else
				poligono.setColorRelleno("GREEN");

			poligonos.add(poligono);
		}
		
		modeloMapa = poligonosC.modeloMapa(poligonos);
		mapaGlobal.put("modeloMapa", modeloMapa);
		
		//Gráfica de Cortes
		//grafica = new LineChartModel();
		grafica = new BarChartModel();
		grafica.setStacked(true);
		grafica.setAnimate(false);
		grafica.setTitle("Avance");
		grafica.setLegendPosition("s");
		grafica.setLegendCols(6);
		grafica.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
		grafica.setShowPointLabels(false);
		grafica.getAxes().put(AxisType.X, new CategoryAxis("Hora"));
		yAxis = grafica.getAxis(AxisType.Y);
		yAxis.setLabel("Promovidos");
		yAxis.setMin(0);
		
		serieRowan = new BarChartSeries();
		serieAbby = new BarChartSeries();
		serieFitz = new BarChartSeries();
		serieHermanos = new BarChartSeries();
		serieTodos = new BarChartSeries();
		serieMeta = new LineChartSeries();
		
		etiquetasCortes = new String[5];
		etiquetasCortes[0] = "10:00";
		etiquetasCortes[1] = "12:00";
		etiquetasCortes[2] = "14:00";
		etiquetasCortes[3] = "16:00";
		etiquetasCortes[4] = "18:00";
		
		cortes = sqlSession.selectList("diaD.reportes.metasJornadaEstatica.cortes");

		for(HashMap<String, Object> corte : cortes){
			switch((String) corte.get("grupo")){
			case "Rowan-JAL":
				logger.debug("Corte: {}", corte);
				serieRowan.setLabel((String) corte.get("grupo"));
				serieRowan.set(etiquetasCortes[0], (Number) corte.get("c1"));
				serieRowan.set(etiquetasCortes[1], (Number) corte.get("c2"));
				serieRowan.set(etiquetasCortes[2], (Number) corte.get("c3"));
				serieRowan.set(etiquetasCortes[3], (Number) corte.get("c4"));
				serieRowan.set(etiquetasCortes[4], (Number) corte.get("c5"));
				break;
			case "Fitz-HP":
				logger.debug("Corte: {}", corte);
				serieFitz.setLabel((String) corte.get("grupo"));
				serieFitz.set(etiquetasCortes[0], (Number) corte.get("c1"));
				serieFitz.set(etiquetasCortes[1], (Number) corte.get("c2"));
				serieFitz.set(etiquetasCortes[2], (Number) corte.get("c3"));
				serieFitz.set(etiquetasCortes[3], (Number) corte.get("c4"));
				serieFitz.set(etiquetasCortes[4], (Number) corte.get("c5"));
				break;
			case "Abby-PH":
				logger.debug("Corte: {}", corte);
				serieAbby.setLabel((String) corte.get("grupo"));
				serieAbby.set(etiquetasCortes[0], (Number) corte.get("c1"));
				serieAbby.set(etiquetasCortes[1], (Number) corte.get("c2"));
				serieAbby.set(etiquetasCortes[2], (Number) corte.get("c3"));
				serieAbby.set(etiquetasCortes[3], (Number) corte.get("c4"));
				serieAbby.set(etiquetasCortes[4], (Number) corte.get("c5"));
				break;
			case "Hermanos":
				logger.debug("Corte: {}", corte);
				serieHermanos.setLabel((String) corte.get("grupo"));
				serieHermanos.set(etiquetasCortes[0], (Number) corte.get("c1"));
				serieHermanos.set(etiquetasCortes[1], (Number) corte.get("c2"));
				serieHermanos.set(etiquetasCortes[2], (Number) corte.get("c3"));
				serieHermanos.set(etiquetasCortes[3], (Number) corte.get("c4"));
				serieHermanos.set(etiquetasCortes[4], (Number) corte.get("c5"));
				break;
			case "Todos":
				logger.debug("Corte: {}", corte);
				serieTodos.setLabel("Todos");
				serieTodos.set(etiquetasCortes[0], (Number) corte.get("c1"));
				serieTodos.set(etiquetasCortes[1], (Number) corte.get("c2"));
				serieTodos.set(etiquetasCortes[2], (Number) corte.get("c3"));
				serieTodos.set(etiquetasCortes[3], (Number) corte.get("c4"));
				serieTodos.set(etiquetasCortes[4], (Number) corte.get("c5"));
				
				serieMeta.setLabel("Meta");
				if( ((int) corte.get("meta")*0.2) - ((int) corte.get("c1")) >= 0){
					serieMeta.set(etiquetasCortes[0], (Number) (((int) corte.get("meta")*0.2) - ((int) corte.get("c1"))));
				} else {
					serieMeta.set(etiquetasCortes[0], (Number) 0);
				}
				if( ((int) corte.get("meta")*0.4) - ((int) corte.get("c2")) >= 0){
					serieMeta.set(etiquetasCortes[1], (Number) (((int) corte.get("meta")*0.4) - ((int) corte.get("c2"))));
				} else {
					serieMeta.set(etiquetasCortes[1], (Number) 0);
				}
				if( ((int) corte.get("meta")*0.6) - ((int) corte.get("c3")) >= 0){
					serieMeta.set(etiquetasCortes[2], (Number) (((int) corte.get("meta")*0.6) - ((int) corte.get("c3"))));
				} else {
					serieMeta.set(etiquetasCortes[2], (Number) 0);
				}
				if( ((int) corte.get("meta")*0.8) - ((int) corte.get("c4")) >= 0){
					serieMeta.set(etiquetasCortes[3], (Number) (((int) corte.get("meta")*0.8) - ((int) corte.get("c4"))));
				} else {
					serieMeta.set(etiquetasCortes[3], (Number) 0);
				}
				if( ((int) corte.get("meta")) - ((int) corte.get("c5")) >= 0){
					serieMeta.set(etiquetasCortes[4], (Number) (((int) corte.get("meta")) - ((int) corte.get("c5"))));
				} else {
					serieMeta.set(etiquetasCortes[4], (Number) 0);
				}
				
				//yAxis.setMax(((Integer)corte.get("meta")).longValue() + 10);
				break;
			}
		}
		
		//grafica.addSeries(serieTodos);
		grafica.addSeries(serieRowan);
		grafica.addSeries(serieFitz);
		grafica.addSeries(serieAbby);
		grafica.addSeries(serieHermanos);
		grafica.addSeries(serieMeta);
		
		grafica.setSeriesColors("FF8000, 8258FA, FE2E2E, 81DAF5, 01DF01");
		
		mapaGlobal.put("grafica", grafica);
		
		return mapaGlobal;
	}
	
	private MeterGaugeChartModel modeloMedidorAvance(NivelReporteCompletoDO nivel, String grupo, String titulo, HashMap<String, Object> mapa){
		MeterGaugeChartModel modelo;
		List<Number> intervalos;
		float avance;
		String colores;
		HashMap<String, Object> parametros, resultado;
		
		colores = "808080, FFA500, FF0000, 008000";
		
		parametros = new HashMap<>();
		
		resultado = null;
		switch(nivel){
		case GENERAL:
			parametros.put("grupo", grupo);
			resultado = sqlSession.selectOne("diaD.reportes.metasJornadaEstatica.general", parametros);
			break;
		case ESTATAL:
			break;
		case REGION:
			break;
		case MUNICIPIO:
			break;
		case SECCION:
			break;
		}
		
		if(!resultado.isEmpty()){
			mapa.clear();
			for(String key : resultado.keySet()){
				mapa.put(key, resultado.get(key));
			}
		}
		
		intervalos = new ArrayList<>();
		
		intervalos.add(25);
		intervalos.add(50);
		intervalos.add(75);
		intervalos.add(100);
		
		avance = ( ((Integer)mapa.get("registrados")).floatValue() / ((Integer)mapa.get("meta")).floatValue() ) * 100f;
		
		modelo = new MeterGaugeChartModel(avance, intervalos);
		modelo.setTitle(titulo);
		modelo.setSeriesColors(colores);
		
		
		return modelo;
	}
	
	public MapModel mapaAvance(TiposPoligonoDO tipoPoligono, List<HashMap<String, Object>> listado){
		List<Poligono> poligonos;
		Poligono pSuperior, poligono;
		StringBuilder llave;
		int meta, registrados;
		double avance;
		
		poligonos = new ArrayList<>();
		
		//Polígonos dinamico
		pSuperior = new Poligono();
		pSuperior.setOpacidadRelleno(0);
		pSuperior.setGrosorLinea(2);
		pSuperior.setOpacidadLinea(1);
		llave = null;
		meta = 0;
		for(HashMap<String, Object> dato : listado){
			llave = new StringBuilder();
			switch(tipoPoligono){
			case DISTRITO_FEDERAL:
				break;
			case ENTIDAD:
				llave.append(dato.get("llave"));
				break;
			case MANZANA:
				pSuperior.setTipo(TiposPoligonoDO.SECCION);
				pSuperior.setLlave("15-" + dato.get("seccion"));
				
				llave.append("15-")
					.append(dato.get("municipio"))
					.append("-")
					.append(dato.get("localidad"))
					.append("-")
					.append(dato.get("seccion"))
					.append("-")
					.append(dato.get("manzana"));
				break;
			case MUNICIPIO:
				pSuperior.setTipo(TiposPoligonoDO.REGION);
				pSuperior.setLlave("15-" + dato.get("region"));
				
				llave.append("15-")
					.append(dato.get("municipio"));
				break;
			case REGION:
				pSuperior.setTipo(TiposPoligonoDO.ENTIDAD);
				pSuperior.setLlave("15");
				
				llave.append("15-")
					.append(dato.get("region")); 
				break;
			case SECCION:
				pSuperior.setTipo(TiposPoligonoDO.MUNICIPIO);
				pSuperior.setLlave("15-" + dato.get("municipio"));
				
				llave.append("15-")
					.append(dato.get("seccion"));
				break;
			}
			poligonos.add(pSuperior);
			
			registrados = (int) dato.get("registrados");
			meta = ((Integer) dato.get("meta")).intValue();
			avance = registrados / (meta * 1f);
			
			poligono = new Poligono();
			poligono.setTipo(tipoPoligono);
			poligono.setLlave(llave.toString());
			poligono.setOpacidadRelleno(0.5);
			
			if (avance <= 0.25)
				poligono.setColorRelleno("GRAY");
			else if (avance <= 0.50)
				poligono.setColorRelleno("ORANGE");
			else if (avance <= 0.75)
				poligono.setColorRelleno("RED");
			else
				poligono.setColorRelleno("GREEN");

			poligonos.add(poligono);
		}
		
		return poligonosC.modeloMapa(poligonos);
	}
//	
//	public void cargarMunicipio(MunicipioEO municipio , String programa){
//		parametrosReportesMunicipios.setMunicipio(municipio);
//		parametrosReportesMunicipios.setPrograma(programa);
//	}
	public void cargarMunicipio(HashMap<String, Object> municipio , String programa){
		MunicipioEO mun=new MunicipioEO();
		mun.setIdMunicipio((Integer)municipio.get("municipio"));
		if (municipio.get("seccion")!=null) {
			parametrosReportesMunicipios.setSeccion((Integer)municipio.get("seccion"));
		}
		parametrosReportesMunicipios.setMunicipio(mun);
		parametrosReportesMunicipios.setPrograma(programa);
	}
	
}
