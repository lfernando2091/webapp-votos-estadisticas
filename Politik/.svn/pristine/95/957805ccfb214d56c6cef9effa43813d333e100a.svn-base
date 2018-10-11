package com.saganet.politik.component_dm.estadisticas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.dominios_dm.RegionesDO;

@Component("EstadisticasPorDiaC")
public class EstadisticasPorDiaC {
	
	@Autowired
	SqlSession sqlSessionDM;
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(EstadisticasPorDiaC.class);
	
	public LineChartModel listado(String fechaInicio, String fechaFin, Integer tipoFiltro, Integer region, String Municipio, Integer zona, Integer seccion){
		
		logger.debug("FechaInicio: {}", fechaInicio);
		logger.debug("FechaFin: {}", fechaFin);
		logger.debug("TipoFiltro: {}", tipoFiltro);
		
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> params;
		LineChartModel model;
		ChartSeries totales;
		ChartSeries conResp;
		ChartSeries sinResp;
		
		Integer nivelUsuario = Integer.parseInt(nivelUsuario(getUsuario().getNick()).get("nivel").toString());
		
		params = new HashMap<>();
		params.put("fechaInicio", fechaInicio);
		params.put("fechaFin", fechaFin);
		params.put("tipoBusqueda", nivelUsuario);
		params.put("region", region);
		
		if(tipoFiltro == 2){
			logger.debug("Municipio: {}", Municipio);
			params.put("municipio", Municipio);
		}
		if(tipoFiltro == 3){
			logger.debug("Zona: {}", zona);
			params.put("zona", zona);
		}
		if(tipoFiltro == 4){
			logger.debug("Municipio: {}", Municipio);
			params.put("municipio", Municipio);
			logger.debug("Zona: {}", zona);
			params.put("zona", zona);
			logger.debug("Seccion: {}", seccion);
			params.put("seccion", seccion);
		}
		
		listado = sqlSessionDM.selectList("estadisticas.estadisticasPorDia.listado", params);
		
		logger.debug("Listado estadistica: {}", listado);
		
		model = new LineChartModel();
		
		
		totales = new ChartSeries();
		totales.setLabel("Total encuestas");
		conResp = new ChartSeries();
		conResp.setLabel("Encuestas con respuesta");
		sinResp = new ChartSeries();
		sinResp.setLabel("Encuestas sin respuesta");
		
		Integer totalEncuestaMaxima = 0;
		
		if(!listado.isEmpty()){
			for(HashMap<String, Object> map : listado){
				totales.set(map.get("dia").toString(), Integer.parseInt(map.get("total_encuestas").toString()));
				conResp.set(map.get("dia").toString(), Integer.parseInt(map.get("con_resp").toString()));
				sinResp.set(map.get("dia").toString(), Integer.parseInt(map.get("sin_resp").toString()));
				
				if(Integer.parseInt(map.get("total_encuestas").toString())>totalEncuestaMaxima){
					totalEncuestaMaxima = Integer.parseInt(map.get("total_encuestas").toString());
				}
				
			}
		}else{
			totales.set(0, 0);
			conResp.set(0, 0);
			sinResp.set(0, 0);
			totalEncuestaMaxima = 0;
		}
		
		model.addSeries(totales);
		model.addSeries(conResp);
		model.addSeries(sinResp);
		
//		model.setTitle("Linear Chart");
//		model.setLegendPosition("e");
//        Axis yAxis = model.getAxis(AxisType.Y);
//        yAxis.setMin(0);
//        yAxis.setMax(10000);
        
        
        model.setTitle("Comportamiento por días");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        model.setZoom(true);
        model.setAnimate(true);
        model.getAxes().put(AxisType.X, new CategoryAxis("Días"));
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Encuestas");
        yAxis.setMin(0);
        if(tipoFiltro==1){
        	yAxis.setMax((totalEncuestaMaxima*5)/4);
        }else if(tipoFiltro==4){
        	yAxis.setMax((totalEncuestaMaxima*5)/4);
        }else{
        	yAxis.setMax((totalEncuestaMaxima*5)/4);
        }
        	
        
        
		
		return model;
		
	}
	
	
	//Administracion de niveles
	
public HashMap<String, Object> nivelUsuario(String nick){
		
		HashMap<String, Object> nivel;
		nivel = new HashMap<>();
		
		//Nivel_Region 
		if(getUsuario().getNivel().getNombre().equals("Geozona")){
			nivel.put("nivel", 1);
			nivel.put("region", sqlSession.selectOne("administracion.usuariosTerritorios.usuarioRegiones",nick)); 
		}else if(getUsuario().getNivel().getNombre().equals("Zona")){
			nivel.put("nivel", 3);
			HashMap<String, Object> result;
			try{
				result = sqlSession.selectOne("administracion.usuariosTerritorios.usuarioZona",nick);
				nivel.put("region", result.get("region"));
				nivel.put("zona", result.get("zona"));
			}catch(Exception ex){
				nivel = new HashMap<>();
			}
		}else if(getUsuario().getNivel().getNombre().equals("Municipio")){
			nivel.put("nivel", 2);
			HashMap<String, Object> result;
			try{
				result = sqlSession.selectOne("administracion.usuariosTerritorios.usuarioMunicipio",nick);
				nivel.put("region", result.get("region"));
				nivel.put("id_municipio", result.get("id_municipio"));
				nivel.put("municipio", result.get("municipio"));
			}catch(Exception ex){
				nivel = new HashMap<>();
			}
		}else{
			nivel.put("nivel", 0);
		}
		
		logger.debug("Mapa nivel: {}", nivel);
		
		return nivel;
		
	}
	
	public Integer getNivelUsuario(){
		HashMap<String, Object> nivel;
		nivel = nivelUsuario(getUsuario().getNick());
		logger.debug("Nivel Usuario: {}", nivel);
		if(!nivel.isEmpty()){
			return Integer.parseInt(nivel.get("nivel").toString());
		}
		return 0;
	}
	
	public Integer getZonaUsuario(){
		HashMap<String, Object> nivel;
		nivel = nivelUsuario(getUsuario().getNick());
		logger.debug("Nivel Usuario: {}", nivel);
		if(!nivel.isEmpty() && nivel.get("zona")!=null){
			return Integer.parseInt(nivel.get("zona").toString());
		}
		return -1;
	}
	
	public String getMunicipioUsuario(){
		HashMap<String, Object> nivel;
		nivel = nivelUsuario(getUsuario().getNick());
		logger.debug("Nivel Usuario: {}", nivel);
		if(!nivel.isEmpty() && nivel.get("municipio")!=null){
			return nivel.get("municipio").toString();
		}
		return null;
	}
	
	public Integer getRegionUser() {
		HashMap<String, Object> nivel;
		nivel = nivelUsuario(getUsuario().getNick());
		logger.debug("Nivel Usuario: {}", nivel);
		if(!nivel.isEmpty()){
			if(nivel.get("region")!=null)
			 return Integer.parseInt(nivel.get("region").toString());
		}
		return 1;
	}
	
	public RegionesDO[] regiones(){
		HashMap<String, Object> params = nivelUsuario(getUsuario().getNick());
		
		if(!params.isEmpty()){
			if(Integer.parseInt(params.get("nivel").toString())==1){
								
				StringTokenizer token = new StringTokenizer(params.get("region").toString(), ",");
				
				RegionesDO[] regiones = new RegionesDO[token.countTokens()];
				int c=0;
				
				RegionesDO[] regionesCompleta = RegionesDO.values();
				
				while (token.hasMoreElements()) {
					regiones[c] = regionesCompleta[Integer.parseInt(token.nextElement().toString())-1];
					c++;		
				}
				
				return regiones;
				
				
			}else if(Integer.parseInt(params.get("nivel").toString())==2){
				RegionesDO[] regiones = new RegionesDO[1];
				RegionesDO[] regionesCompleta = RegionesDO.values();
				regiones[0] = regionesCompleta[Integer.parseInt(nivelUsuario(getUsuario().getNick()).get("region").toString())-1];
				return regiones;
			}else if(Integer.parseInt(params.get("nivel").toString())==3){
				RegionesDO[] regiones = new RegionesDO[1];
				RegionesDO[] regionesCompleta = RegionesDO.values();
				regiones[0] = regionesCompleta[Integer.parseInt(nivelUsuario(getUsuario().getNick()).get("region").toString())-1];
				return regiones;
			}else if(Integer.parseInt(params.get("nivel").toString())==4){
				RegionesDO[] regiones = new RegionesDO[1];
				RegionesDO[] regionesCompleta = RegionesDO.values();
				regiones[0] = regionesCompleta[Integer.parseInt(nivelUsuario(getUsuario().getNick()).get("region").toString())-1];
				return regiones;
			}else{
				return RegionesDO.values();
			}
		}else{
			//logger.debug("Se genera listado de Regiones");
			return RegionesDO.values();
		}
		
	}
	
	public List<String> listadoMunicipios(Integer region){
		List<String> listado;
		HashMap<String, Object> params;
		params = new HashMap<>();
		params.put("region", region);
		
		if(getNivelUsuario()==2){
			params.put("municipio", getMunicipioUsuario());
		}
		if(getNivelUsuario()==3){
			params.put("zona", getZonaUsuario());
		}
		listado = sqlSessionDM.selectList("estadisticas.estadisticasPorDia.listadoMunicipios", params);
		logger.debug("Listado Municipios: {}", listado);
		return listado;
	}
	
	public List<Integer> listadoZonas(Integer region, String municipio, Integer tipoFiltro){
		logger.debug("municipio: {}", municipio);
		logger.debug("tipoFiltro: {}", tipoFiltro);
		List<Integer> listado;
		HashMap<String, Object> params;
		params = new HashMap<>();
		params.put("region", region);
		params.put("municipio", municipio);
		params.put("tipoFiltro", tipoFiltro);
		params.put("nivelUsuario", getNivelUsuario());
		if(getNivelUsuario()==3){
			params.put("zona", getZonaUsuario());
		}
		listado = sqlSessionDM.selectList("estadisticas.estadisticasPorDia.listadoZonas", params);
		return listado;
	}
	
	public List<Integer> listadoSecciones(Integer region, String municipio, Integer zona){
		List<Integer> listado;
		HashMap<String, Object> params;
		params = new HashMap<>();
		params.put("region", region);
		params.put("municipio", municipio);
		params.put("zona", zona);
		listado = sqlSessionDM.selectList("estadisticas.estadisticasPorDia.listadoSecciones", params);
		logger.debug("Listado Secciones: {}", listado);
		return listado;
	}
	
	public Date getFecha(){
		return new Date();
	}
	
	public Date getFechaAntras(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -10);
		return calendar.getTime();
	}
	
	public String combierteDateToString(Date fecha){
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String result = df.format(fecha);
		logger.debug("fecha: {}", result);
		return result;
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
	public List<HashMap<String, Object>> listadoTiposFiltro(){
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> tipoFiltro;
		
		listado = new ArrayList<>();
		
		Integer nivelUsuario = getNivelUsuario();
		
		if(nivelUsuario == 0 || nivelUsuario == 1){
			tipoFiltro = new HashMap<>();
			tipoFiltro.put("nombre", "Region");
			tipoFiltro.put("id", 1);
			listado.add(tipoFiltro);
		}
		if(nivelUsuario == 0 || nivelUsuario == 1 || nivelUsuario == 2){
			tipoFiltro = new HashMap<>();
			tipoFiltro.put("nombre", "Municipio");
			tipoFiltro.put("id", 2);
			listado.add(tipoFiltro);
		}
		if(nivelUsuario == 0 || nivelUsuario == 1 || nivelUsuario == 2 || nivelUsuario == 3){
			tipoFiltro = new HashMap<>();
			tipoFiltro.put("nombre", "Zona");
			tipoFiltro.put("id", 3);
			listado.add(tipoFiltro);
		}
		if(nivelUsuario == 0 || nivelUsuario == 1 || nivelUsuario == 2 || nivelUsuario == 3 || nivelUsuario == 4){
			tipoFiltro = new HashMap<>();
			tipoFiltro.put("nombre", "Sección");
			tipoFiltro.put("id", 4);
			listado.add(tipoFiltro);
		}
		
		return listado;
	}

}
