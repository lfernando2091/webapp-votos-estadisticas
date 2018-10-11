package com.saganet.politik.components.encuestas.levantamientoRowan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.map.MapModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.components.catalogos.MunicipiosC;
import com.saganet.politik.components.sig.PoligonosC;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.dominios.NivelesReporteDO;
import com.saganet.politik.dominios.TiposColumnaDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.utilidades.Columna;
import com.saganet.politik.utilidades.Poligono;

import mx.com.saganet.peon.database.dominios.TiposPoligonoDO;

import com.saganet.politik.database.encuestas.levantamientoRowan.ResultadoEncuestaEO;

@Component("LevantamientoRowanResultadoEncuestas")
public class ResultadoEncuestasC {
	@Autowired
	SqlSession sqlSession;
	
	@Autowired PoligonosC poligonosC;
	@Autowired MunicipiosC municipiosC;
	
	private static final Logger logger = LoggerFactory.getLogger(ResultadoEncuestasC.class);

	public Modelo<ResultadoEncuestaEO> modelo(NivelesReporteDO nivel) {
		Modelo<ResultadoEncuestaEO> tabla;
		List<ResultadoEncuestaEO> listado=new ArrayList<>();
		HashMap<String, Object> mapa=new HashMap<>();
		UsuarioEO usuario=getUsuario();
		if (usuario.getTerritorios()!=null) {
			switch (usuario.getNivel()) {
				case GEOZONA:
					List<GeozonaParticionEO> geozonasParticiones=new ArrayList<>();
					logger.debug("Territorio : {} ", usuario.getTerritorios());
					for (JavaBeanT geozona : usuario.getTerritorios()) {
						geozonasParticiones.add((GeozonaParticionEO)geozona);
					} 
					mapa.put("regiones",geozonasParticiones);
				break;
				case MUNICIPIO:
					mapa.put("municipios",usuario.getTerritorios());
				break;
				default:
				break;
			}
		}
		if (nivel!=null) {
			switch (nivel) {
				case REGION:
					listado=sqlSession.selectList("encuestas.levantamientoRowan.resultadoEncuestas.resultadoRegionPrograma",mapa);			
				break;
				case MUNICIPIO:
					listado=sqlSession.selectList("encuestas.levantamientoRowan.resultadoEncuestas.resultadoMunicipioPrograma",mapa);
				break;
				case SECCION:
					listado=sqlSession.selectList("encuestas.levantamientoRowan.resultadoEncuestas.resultadoSeccionPrograma",mapa);
				break;
			}
		}
		//logger.debug("Listado {}",listado);
		tabla=new Modelo<>(listado);
		return tabla;
	}
	
	public BarChartModel generaGrafica(ResultadoEncuestaEO seleccionado, NivelesReporteDO nivel){
		BarChartModel model = new BarChartModel();
		ChartSeries completadas = new ChartSeries();
        completadas.setLabel("Completadas");
        completadas.set("Estatus", (seleccionado!=null?seleccionado.getExitoso():0));
        ChartSeries noHuboQuienContestara = new ChartSeries();
        noHuboQuienContestara.setLabel("No Hubo Quien Contestara");
        noHuboQuienContestara.set("Estatus", (seleccionado!=null?seleccionado.getNoHuboQuienContestara():0));
        ChartSeries menorDeEdad = new ChartSeries();
        menorDeEdad.setLabel("Menor De Edad");
        menorDeEdad.set("Estatus", (seleccionado!=null?seleccionado.getMenorDeEdad():0));
        ChartSeries domicilioNoEncontrado = new ChartSeries();
        domicilioNoEncontrado.setLabel("Domicilio No Encontrado");
        domicilioNoEncontrado.set("Estatus", (seleccionado!=null?seleccionado.getDomicilioNoEncontrado():0));
        ChartSeries noQuisieronContestar = new ChartSeries();
        noQuisieronContestar.setLabel("No Quisieron Contestar");
        noQuisieronContestar.set("Estatus", (seleccionado!=null?seleccionado.getNoQuisieronContestar():0));
        ChartSeries otro = new ChartSeries();
        otro.setLabel("Otro");
        otro.set("Estatus", (seleccionado!=null?seleccionado.getOtro():0));
        model.addSeries(completadas); 
        model.addSeries(noHuboQuienContestara);  
        model.addSeries(menorDeEdad);  
        model.addSeries(domicilioNoEncontrado);  
        model.addSeries(noQuisieronContestar);  
        model.addSeries(otro);        
        model.setLegendPosition("ne");
        switch (nivel) {
			case REGION:
		        model.setTitle("Región : "+(seleccionado!=null?seleccionado.getNombreRegion():"")); 			
			break;
			case MUNICIPIO:
		        model.setTitle("Municipio : "+(seleccionado!=null?seleccionado.getNombreMunicipio():"")); 			
			break;
			case SECCION:
		        model.setTitle("Sección :"+(seleccionado!=null?seleccionado.getSeccion():"")); 			
			break;
		} 
        /*  Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("Gender");*/
        model.setSeriesColors("3DC946,D5AC15,549F8E,103769,AA0B08,B6B9BA");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("N° Encuestas");
        yAxis.setMin(0);
        Integer maximo=0;
        if (seleccionado!=null) {
            if (maximo<seleccionado.getExitoso()) {
    			maximo=seleccionado.getExitoso();
    		}
            if (maximo<seleccionado.getNoHuboQuienContestara()) {
    			maximo=seleccionado.getNoHuboQuienContestara();
    		}
            if (maximo<seleccionado.getMenorDeEdad()) {
    			maximo=seleccionado.getMenorDeEdad();
    		}
            if (maximo<seleccionado.getDomicilioNoEncontrado()) {
    			maximo=seleccionado.getDomicilioNoEncontrado();
    		}
            if (maximo<seleccionado.getNoQuisieronContestar()) {
    			maximo=seleccionado.getNoQuisieronContestar();
    		}
            if (maximo<seleccionado.getOtro()) {
    			maximo=seleccionado.getOtro();
    		}   
		}  
        yAxis.setMax(maximo);
		return model;
	}
	
	public ResultadoEncuestaEO filaTotales(Modelo<ResultadoEncuestaEO> modelo){
		ResultadoEncuestaEO total=new ResultadoEncuestaEO();		
		total.setExitoso(0);
		total.setMenorDeEdad(0);
		total.setNoHuboQuienContestara(0);
		total.setNoQuisieronContestar(0);
		total.setDomicilioNoEncontrado(0);
		total.setOtro(0);		
		total.setTotal(0);
		total.setTotalTotal(0);
		total.setMeta(0);		
		for (ResultadoEncuestaEO actual : modelo.getListado()) {
			//logger.debug("Actual : {}",actual);
			total.setExitoso(total.getExitoso()+actual.getExitoso());
			total.setMenorDeEdad(total.getMenorDeEdad()+actual.getMenorDeEdad());
			total.setNoHuboQuienContestara(total.getNoHuboQuienContestara()+actual.getNoHuboQuienContestara());
			total.setNoQuisieronContestar(total.getNoQuisieronContestar()+actual.getNoQuisieronContestar());
			total.setDomicilioNoEncontrado(total.getDomicilioNoEncontrado()+actual.getDomicilioNoEncontrado());
			total.setOtro(total.getOtro()+actual.getOtro());			
			total.setTotal(total.getTotal()+(actual.getTotal()!=null?actual.getTotal():0));
			total.setTotalTotal(total.getTotalTotal()+(actual.getTotalTotal()!=null?actual.getTotalTotal():0));
			total.setMeta(total.getMeta()+(actual.getMeta()!=null?actual.getMeta():0));
		}
		return total;
	}
	
	public void generarMapa(RequestContext rc, NivelesReporteDO nivel){
		HashMap<String, Object> viewScope;
		Modelo<ResultadoEncuestaEO> modelo;
		Modelo<HashMap<String, Object>> modeloDatos;
		List<HashMap<String, Object>> listadoDatos;
		HashMap<String, Object> dato;
		List<Columna> columnas;
		MapModel modeloMapa;
		List<Poligono> poligonos;
		Poligono poligono;
		List<MunicipioEO> municipios;
		MunicipioEO municipio;
		
		viewScope = (HashMap<String, Object>) rc.getViewScope().asMap();
		modelo = modelo(nivel);
		viewScope.put("modelo", modelo);
		
		//modeloMapa = new DefaultMapModel();
		
		modeloDatos = new Modelo<>();
		viewScope.put("modeloDatos", modeloDatos);
		listadoDatos = new ArrayList<>();
		modeloDatos.setListado(listadoDatos);
		poligonos = new ArrayList<>();
		
		//Poligono entidad
		poligono = new Poligono();
		poligono.setTipo(TiposPoligonoDO.ENTIDAD);
		poligono.setLlave("15");
		poligono.setOpacidadRelleno(0);
		poligono.setGrosorLinea(1);
		poligono.setOpacidadLinea(1);
		poligonos.add(poligono);
		
		for(ResultadoEncuestaEO resultado : modelo.getListado()){
			dato = new HashMap<>();
			listadoDatos.add(dato);
			switch (nivel) {
			case MUNICIPIO:
				dato.put("idRegion", resultado.getRegion());
				dato.put("region", resultado.getNombreRegion());
				dato.put("idMunicipio", resultado.getMunicipio());
				dato.put("municipio", resultado.getNombreMunicipio());
				dato.put("secciones", resultado.getNumSeccion());
				dato.put("completadas", resultado.getExitoso());
				dato.put("faltantes", resultado.getMeta() - resultado.getExitoso());
				dato.put("porcentajeCompletadas",
						resultado.getExitoso().doubleValue() / resultado.getMeta().doubleValue());
				dato.put("total", resultado.getMeta());

				municipio = municipiosC.buscarPorLlave("15-" + dato.get("idMunicipio"));

				poligono = new Poligono();
				poligono.setTipo(TiposPoligonoDO.MUNICIPIO);
				poligono.setLlave(municipio.getLlave());
				poligono.setOpacidadRelleno(0.5);

				if (((double) dato.get("porcentajeCompletadas")) < 0.5)
					poligono.setColorRelleno("RED");
				else if (((double) dato.get("porcentajeCompletadas")) < 0.75)
					poligono.setColorRelleno("YELLOW");
				else if (((double) dato.get("porcentajeCompletadas")) < 1)
					poligono.setColorRelleno("ORANGE");
				else
					poligono.setColorRelleno("GREEN");

				poligonos.add(poligono);
				break;
			case REGION:
				dato.put("idRegion", resultado.getRegion());
				dato.put("region", resultado.getNombreRegion());
				dato.put("municipios", resultado.getNumMunicipio());
				dato.put("secciones", resultado.getNumSeccion());
				dato.put("completadas", resultado.getExitoso());
				dato.put("faltantes", resultado.getMeta() - resultado.getExitoso());
				dato.put("porcentajeCompletadas",
						resultado.getExitoso().doubleValue() / resultado.getMeta().doubleValue());
				dato.put("total", resultado.getMeta());

				municipios = sqlSession.selectList("catalogos.municipios.porRegion", dato.get("idRegion"));

				for (MunicipioEO m : municipios) {
					poligono = new Poligono();
					poligono.setTipo(TiposPoligonoDO.MUNICIPIO);
					poligono.setLlave(m.getLlave());
					poligono.setOpacidadRelleno(0.5);

					if (((double) dato.get("porcentajeCompletadas")) < 0.5)
						poligono.setColorRelleno("RED");
					else if (((double) dato.get("porcentajeCompletadas")) < 0.75)
						poligono.setColorRelleno("YELLOW");
					else if (((double) dato.get("porcentajeCompletadas")) < 1)
						poligono.setColorRelleno("ORANGE");
					else
						poligono.setColorRelleno("GREEN");

					poligonos.add(poligono);
				}
				break;
			case SECCION:
				break;
			}
		}
		modeloMapa = poligonosC.modeloMapa(poligonos);
		viewScope.put("modeloMapa", modeloMapa);
		
		columnas = new ArrayList<>();
		switch(nivel){
		case MUNICIPIO:
			columnas.add(new Columna("idRegión", "idRegion", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Región", "region", TiposColumnaDO.TEXTO));
			columnas.add(new Columna("idMunicipio", "idMunicipio", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Municipio", "municipio", TiposColumnaDO.TEXTO));
			//columnas.add(new Columna("Secciones", "secciones", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Completadas", "completadas", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Faltantes", "faltantes", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Avance", "porcentajeCompletadas", TiposColumnaDO.PORCENTAJE));
			columnas.add(new Columna("Total", "total", TiposColumnaDO.ENTERO));
			break;
		case REGION:
			columnas.add(new Columna("idRegión", "idRegion", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Región", "region", TiposColumnaDO.TEXTO));
			//columnas.add(new Columna("Municipios", "municipios", TiposColumnaDO.ENTERO));
			//columnas.add(new Columna("Secciones", "secciones", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Completadas", "completadas", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Faltantes", "faltantes", TiposColumnaDO.ENTERO));
			columnas.add(new Columna("Avance", "porcentajeCompletadas", TiposColumnaDO.PORCENTAJE));
			columnas.add(new Columna("Total", "total", TiposColumnaDO.ENTERO));
			break;
		case SECCION:
			break;
		}
		viewScope.put("columnas", columnas);
		viewScope.put("width", 500);
		viewScope.put("height", 500);
	}
	
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

}
