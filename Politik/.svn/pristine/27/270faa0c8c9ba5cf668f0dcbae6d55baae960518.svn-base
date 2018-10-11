package com.saganet.politik.component_dm.estadisticas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.dominios_dm.RegionesDO;

@Component("EstadisticasSincronizacionC")
public class EstadisticasC {
	
	@Autowired
	SqlSession sqlSessionDM;
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(EstadisticasC.class);
	
	public List<HashMap<String, Object>> listadoPorUsuarioRegion(Integer idRegion, String usuario, String nombre, String imei){
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> params = new HashMap<>();
		params.put("idRegion", idRegion);
		params.put("usuario", usuario);
		params.put("nombre", nombre.toUpperCase());
		params.put("imei", imei);
		
		HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
		if(!nivel.isEmpty()){
			if(nivel.get("zona")!=null){
				params.put("zona", Integer.parseInt(nivel.get("zona").toString()));
			}else{
				params.put("zona", "");
			}
			if(nivel.get("id_municipio")!=null){
				params.put("municipio", nivel.get("id_municipio"));
			}else{
				params.put("municipio", "");
			}
		}else{
			params.put("municipio", "");
			params.put("zona", "");
		}
		
		listado = sqlSessionDM.selectList("estadisticas.estadisticas.porUsuarioRegion", params);
		
		for(HashMap<String, Object> map : listado){
			map.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
		}
		
		logger.debug("Listado de estadisticas por usuario y region: {}", listado);
		return listado;
	}
	
//	public List<HashMap<String, Object>> listadoPorFechas(String fechaInicio, String fechaFin){
//		List<HashMap<String, Object>> listado;
//		HashMap<String, Object> params;
//		params = new HashMap<>();
//		params.put("fechaInicio", fechaInicio);
//		params.put("fechaFin", fechaFin);
//		listado = sqlSessionDM.selectList("estadisticas.estadisticas.porFechas", params);
//		logger.debug("Listado de estadisticas por fecha: {}", listado);
//		return listado;
//	}
	
	public List<HashMap<String, Object>> listadoPorRegiones(){
		List<HashMap<String, Object>> listado;
		List<HashMap<String, Object>> listadoFinal = new ArrayList<>();
		
		HashMap<String, Object> params = nivelUsuario(getUsuario().getNick());
		
		if(!params.isEmpty()){
			if(Integer.parseInt(params.get("nivel").toString())==1){
				HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
				if(!nivel.isEmpty()){
					if(nivel.get("region")!=null){
						params.put("region", (nivel.get("region").toString()));
					}
					else{
						params.put("region","");
					}
				}else{
					params.put("region","");
				}
				params.put("zona", "");
				params.put("municipio", "");
				logger.debug("Parametros Por region: {}", params);
				listado = sqlSessionDM.selectList("estadisticas.estadisticas.porRegiones", params);
			}
			else if(Integer.parseInt(params.get("nivel").toString())==3){
				HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
				if(!nivel.isEmpty()){
					if(nivel.get("zona")!=null){
						params.put("zona", Integer.parseInt(nivel.get("zona").toString()));
					}else{
						params.put("zona", "");
					}
					if(nivel.get("region")!=null){
						params.put("region", (nivel.get("region").toString()));
					}
					else{
						params.put("region","");
					}
				}else{
					params.put("zona", "");
					params.put("region","");
				}
				params.put("municipio", "");
				listado = sqlSessionDM.selectList("estadisticas.estadisticas.porRegiones", params);
			}else if(Integer.parseInt(params.get("nivel").toString())==2){
				HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
				if(!nivel.isEmpty()){
					if(nivel.get("municipio")!=null){
						params.put("municipio", Integer.parseInt(nivel.get("id_municipio").toString()));
					}else{
						params.put("municipio", "");
					}
					if(nivel.get("region")!=null){
						params.put("region", (nivel.get("region").toString()));
					}
					else{
						params.put("region","");
					}
				}else{
					params.put("zona", "");
					params.put("region","");
				}
				params.put("zona", "");
				listado = sqlSessionDM.selectList("estadisticas.estadisticas.porRegiones", params);
			}
			else{
				params = new HashMap<>();
				params.put("region", "");
				listado = sqlSessionDM.selectList("estadisticas.estadisticas.porRegiones", params);
			}
		}else{
			params = new HashMap<>();
			HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
			if(!nivel.isEmpty()){
				if(nivel.get("zona")!=null){
					params.put("zona", Integer.parseInt(nivel.get("zona").toString()));
				}else{
					params.put("zona", "");
				}
			}else{
				params.put("zona", "");
			}
			params.put("region", "");
			params.put("zona", "");
			params.put("municipio", "");
			listado = sqlSessionDM.selectList("estadisticas.estadisticas.porRegiones", params);
		}
		//logger.debug("params region: {}", params);
		//listado = sqlSessionDM.selectList("estadisticas.estadisticas.porRegiones");
		
		for(HashMap<String, Object> map : listado){
			HashMap<String, Object> map2 = new HashMap<>();
			map2.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
			map2.put("num", map.get("num"));
			listadoFinal.add(map2);
		}
		
		//logger.debug("Listado de estadisticas por Region: {}", listadoFinal);
		return listadoFinal;
	}
	
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
		return 0;
	}
	
	public String getMunicipioUsuario(){
		HashMap<String, Object> nivel;
		nivel = nivelUsuario(getUsuario().getNick());
		logger.debug("Nivel Usuario: {}", nivel);
		if(!nivel.isEmpty() && nivel.get("municipio")!=null){
			return nivel.get("municipio").toString();
		}
		return "";
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
				
				
			}else{
				//logger.debug("Se genera listado de Regiones");
				return RegionesDO.values();
			}
		}else{
			//logger.debug("Se genera listado de Regiones");
			return RegionesDO.values();
		}
		
	}
	
	public Date getFecha(){
		return new Date();
	}
	
	public String combierteDateToString(Date fecha){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String result = df.format(fecha);
		logger.debug("fecha: {}", result);
		return result;
	}
	
	public Integer calculaTotalEncuestas(List<HashMap<String, Object>> listado){
		Integer total = 0;
		for(HashMap<String, Object> map : listado){
			total = total + Integer.parseInt(map.get("num").toString());
		}
		return total;
	}
	
	
	public List<HashMap<String, Object>> concentrado1(){
		List<HashMap<String, Object>> listado;
		List<HashMap<String, Object>> listadoFinal = new ArrayList<>();
		
		HashMap<String, Object> params = nivelUsuario(getUsuario().getNick());
		
		if(!params.isEmpty()){
			if(Integer.parseInt(params.get("nivel").toString())==1){
				listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado1", params);
			}else{
				logger.debug("region: {}", params.get("region"));
				if(params.get("region")==null){
					params = new HashMap<>();
					params.put("region", "");
				}else{
					params = new HashMap<>();
					params.put("region", "-1");
				}
				listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado1", params);
			}
		}else{
			params = new HashMap<>();
			params.put("region", "");
			listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado1", params);
		}
		
		
		
		for(HashMap<String, Object> map : listado){
			HashMap<String, Object> map2 = new HashMap<>();
			map2.put("reporte", 1);
			map2.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
			map2.put("count", map.get("count"));
			map2.put("usuarios_registrados", map.get("usuarios_registrados"));
			map2.put("mas_de_10", map.get("mas_de_10"));
			map2.put("por_mas_de_10", map.get("por_mas_de_10"));
			map2.put("menos_de_10", map.get("menos_de_10"));
			map2.put("por_menos_de_10", map.get("por_menos_de_10"));
			map2.put("total_uconectados", map.get("total_uconectados"));
			map2.put("con_resp", map.get("con_resp"));
			map2.put("por_con_resp", map.get("por_con_resp"));
			map2.put("sin_resp", map.get("sin_resp"));
			map2.put("por_sin_resp", map.get("por_sin_resp"));
			map2.put("total_enc_sincronizadas", map.get("total_enc_sincronizadas"));
			map2.put("de_usuarios_conectados", map.get("de_usuarios_conectados"));
			listadoFinal.add(map2);
		}
		
		logger.debug("Listado de estadisticas por Region: {}", listadoFinal);
		return listadoFinal;
	}
	
	public List<HashMap<String, Object>> concentrado1PorFecha(String fechaInicio, String fechaFin){
		List<HashMap<String, Object>> listado;
		List<HashMap<String, Object>> listadoFinal = new ArrayList<>();
		//HashMap<String, Object> params = new HashMap<>();
		//params.put("fechaInicio", fechaInicio);
		//params.put("fechaFin", fechaFin);
		
		HashMap<String, Object> params = nivelUsuario(getUsuario().getNick());
		
		if(!params.isEmpty()){
			if(Integer.parseInt(params.get("nivel").toString())==1){
				params.put("fechaInicio", fechaInicio);
				params.put("fechaFin", fechaFin);
				listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado1PorFecha",params);
			}else{
				
				logger.debug("region: {}", params.get("region"));
				if(params.get("region")==null){
					params = new HashMap<>();
					params.put("region", "");
					params.put("fechaInicio", fechaInicio);
					params.put("fechaFin", fechaFin);
				}else{
					params = new HashMap<>();
					params.put("region", "-1");
					params.put("fechaInicio", fechaInicio);
					params.put("fechaFin", fechaFin);
				}
								
				listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado1PorFecha",params);
			}
		}else{
			params = new HashMap<>();
			params.put("region", "");
			params.put("fechaInicio", fechaInicio);
			params.put("fechaFin", fechaFin);
			listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado1PorFecha",params);
		}
		
		
		//listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado1PorFecha",params);
		
		for(HashMap<String, Object> map : listado){
			HashMap<String, Object> map2 = new HashMap<>();
			map2.put("reporte", 1);
			map2.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
			map2.put("count", map.get("count"));
			map2.put("usuarios_registrados", map.get("usuarios_registrados"));
			map2.put("mas_de_10", map.get("mas_de_10"));
			map2.put("por_mas_de_10", map.get("por_mas_de_10"));
			map2.put("menos_de_10", map.get("menos_de_10"));
			map2.put("por_menos_de_10", map.get("por_menos_de_10"));
			map2.put("total_uconectados", map.get("total_uconectados"));
			map2.put("con_resp", map.get("con_resp"));
			map2.put("por_con_resp", map.get("por_con_resp"));
			map2.put("sin_resp", map.get("sin_resp"));
			map2.put("por_sin_resp", map.get("por_sin_resp"));
			map2.put("total_enc_sincronizadas", map.get("total_enc_sincronizadas"));
			map2.put("de_usuarios_conectados", map.get("de_usuarios_conectados"));
			listadoFinal.add(map2);
		}
		
		logger.debug("Listado de estadisticas por Region: {}", listadoFinal);
		return listadoFinal;
	}
	
	public HashMap<String, Object> totalesConcentrados(List<HashMap<String, Object>> listado){
		Integer var1 = 0;
		Integer var2 = 0;
		Integer var3 = 0;
		Integer var4 = 0;
		Integer var5 = 0;
		Integer var6 = 0;
		Integer var7 = 0;
		Integer var8 = 0;
		HashMap<String, Object> resultado;
		resultado = new HashMap<>();
		
		for(HashMap<String, Object> map : listado){
			var8 = var8 + Integer.parseInt(map.get("usuarios_registrados").toString());
			var1 = var1 + Integer.parseInt(map.get("mas_de_10").toString());
			var2 = var2 + Integer.parseInt(map.get("menos_de_10").toString());
			var3 = var3 + Integer.parseInt(map.get("total_uconectados").toString());
			var4 = var4 + Integer.parseInt(map.get("con_resp").toString());
			var5 = var5 + Integer.parseInt(map.get("sin_resp").toString());
			var6 = var6 + Integer.parseInt(map.get("total_enc_sincronizadas").toString());
			var7 = var7 + Integer.parseInt(map.get("de_usuarios_conectados").toString());
		}
		
		resultado.put("total_usuarios_registrados",var8);
		resultado.put("total_mas_de_10",var1);
		resultado.put("total_menos_de_10",var2);
		resultado.put("total_total_uconectados",var3);
		resultado.put("total_con_resp",var4);
		resultado.put("total_sin_resp",var5);
		resultado.put("total_total_enc_sincronizadas",var6);
		resultado.put("total_de_usuarios_conectados",var7);
		
		logger.debug("Totales Concentrado1: {}", resultado);
		
		return resultado;
	}
	
	public List<HashMap<String, Object>> concentrado2Municipios(Integer idRegion){
		List<HashMap<String, Object>> listado;
		List<HashMap<String, Object>> listadoFinal = new ArrayList<>();
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("idRegion", idRegion);

		HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
		if(!nivel.isEmpty()){
			if(nivel.get("id_municipio")!=null){
				params.put("municipio", nivel.get("id_municipio"));
			}else{
				params.put("municipio", "");
			}
		}else{
			params.put("municipio", "");
		}
		listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado2Municipios",params);
		
		for(HashMap<String, Object> map : listado){
			HashMap<String, Object> map2 = new HashMap<>();
			map2.put("reporte", 1);
			map2.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
			
			map2.put("id_municipio", map.get("id_municipio"));
			map2.put("municipio", map.get("municipio"));
			
			map2.put("count", map.get("count"));
			map2.put("usuarios_registrados", map.get("usuarios_registrados"));
			map2.put("mas_de_10", map.get("mas_de_10"));
			map2.put("por_mas_de_10", map.get("por_mas_de_10"));
			map2.put("menos_de_10", map.get("menos_de_10"));
			map2.put("por_menos_de_10", map.get("por_menos_de_10"));
			map2.put("total_uconectados", map.get("total_uconectados"));
			map2.put("con_resp", map.get("con_resp"));
			map2.put("por_con_resp", map.get("por_con_resp"));
			map2.put("sin_resp", map.get("sin_resp"));
			map2.put("por_sin_resp", map.get("por_sin_resp"));
			map2.put("total_enc_sincronizadas", map.get("total_enc_sincronizadas"));
			map2.put("de_usuarios_conectados", map.get("de_usuarios_conectados"));
			listadoFinal.add(map2);
		}
		
		logger.debug("Listado de estadisticas por Municipios: {}", listadoFinal);
		return listadoFinal;
	}
	
	public List<HashMap<String, Object>> concentrado2MunicipiosFecha(Integer idRegion, String fechaInicio, String fechaFin){
		List<HashMap<String, Object>> listado;
		List<HashMap<String, Object>> listadoFinal = new ArrayList<>();
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("idRegion", idRegion);
		params.put("fechaInicio", fechaInicio);
		params.put("fechaFin", fechaFin);
		
		HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
		if(!nivel.isEmpty()){
			if(nivel.get("id_municipio")!=null){
				params.put("municipio", nivel.get("id_municipio"));
			}else{
				params.put("municipio", "");
			}
		}else{
			params.put("municipio", "");
		}
		
		listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado2MunicipiosFecha",params);
		
		for(HashMap<String, Object> map : listado){
			HashMap<String, Object> map2 = new HashMap<>();
			map2.put("reporte", 1);
			map2.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
			
			map2.put("id_municipio", map.get("id_municipio"));
			map2.put("municipio", map.get("municipio"));
			
			map2.put("count", map.get("count"));
			map2.put("usuarios_registrados", map.get("usuarios_registrados"));
			map2.put("mas_de_10", map.get("mas_de_10"));
			map2.put("por_mas_de_10", map.get("por_mas_de_10"));
			map2.put("menos_de_10", map.get("menos_de_10"));
			map2.put("por_menos_de_10", map.get("por_menos_de_10"));
			map2.put("total_uconectados", map.get("total_uconectados"));
			map2.put("con_resp", map.get("con_resp"));
			map2.put("por_con_resp", map.get("por_con_resp"));
			map2.put("sin_resp", map.get("sin_resp"));
			map2.put("por_sin_resp", map.get("por_sin_resp"));
			map2.put("total_enc_sincronizadas", map.get("total_enc_sincronizadas"));
			map2.put("de_usuarios_conectados", map.get("de_usuarios_conectados"));
			listadoFinal.add(map2);
		}
		
		logger.debug("Listado de estadisticas por Municipios: {}", listadoFinal);
		return listadoFinal;
	}
	
	
	
	public List<HashMap<String, Object>> concentrado3Zonas(Integer idRegion){
		List<HashMap<String, Object>> listado;
		List<HashMap<String, Object>> listadoFinal = new ArrayList<>();
		
		HashMap<String, Object> params = new HashMap<>();
		
		
		params.put("idRegion", idRegion);
		HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
		if(!nivel.isEmpty()){
			if(nivel.get("zona")!=null){
				params.put("zona", nivel.get("zona"));
			}else{
				params.put("zona", "");
			}
		}else{
			params.put("zona", "");
		}
		listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado3Zonas",params);
		
		for(HashMap<String, Object> map : listado){
			HashMap<String, Object> map2 = new HashMap<>();
			map2.put("reporte", 1);
			map2.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
			
			map2.put("zona", map.get("zona"));
			
			map2.put("count", map.get("count"));
			map2.put("usuarios_registrados", map.get("usuarios_registrados"));
			map2.put("mas_de_10", map.get("mas_de_10"));
			map2.put("por_mas_de_10", map.get("por_mas_de_10"));
			map2.put("menos_de_10", map.get("menos_de_10"));
			map2.put("por_menos_de_10", map.get("por_menos_de_10"));
			map2.put("total_uconectados", map.get("total_uconectados"));
			map2.put("con_resp", map.get("con_resp"));
			map2.put("por_con_resp", map.get("por_con_resp"));
			map2.put("sin_resp", map.get("sin_resp"));
			map2.put("por_sin_resp", map.get("por_sin_resp"));
			map2.put("total_enc_sincronizadas", map.get("total_enc_sincronizadas"));
			map2.put("de_usuarios_conectados", map.get("de_usuarios_conectados"));
			listadoFinal.add(map2);
		}
		
		logger.debug("Listado de estadisticas por Zonas: {}", listadoFinal);
		return listadoFinal;
	}
	
	public List<HashMap<String, Object>> concentrado3ZonasFecha(Integer idRegion, String fechaInicio, String fechaFin){
		List<HashMap<String, Object>> listado;
		List<HashMap<String, Object>> listadoFinal = new ArrayList<>();
		
		
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("idRegion", idRegion);
		params.put("fechaInicio", fechaInicio);
		params.put("fechaFin", fechaFin);
		
		HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
		if(!nivel.isEmpty()){
			if(nivel.get("zona")!=null){
				params.put("zona", nivel.get("zona"));
			}else{
				params.put("zona", "");
			}
		}else{
			params.put("zona", "");
		}
		
		logger.debug("params: {}", params);
		
		listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado3ZonasFecha",params);
		
		for(HashMap<String, Object> map : listado){
			HashMap<String, Object> map2 = new HashMap<>();
			map2.put("reporte", 1);
			map2.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
			
			map2.put("zona", map.get("zona"));
			
			map2.put("count", map.get("count"));
			map2.put("usuarios_registrados", map.get("usuarios_registrados"));
			map2.put("mas_de_10", map.get("mas_de_10"));
			map2.put("por_mas_de_10", map.get("por_mas_de_10"));
			map2.put("menos_de_10", map.get("menos_de_10"));
			map2.put("por_menos_de_10", map.get("por_menos_de_10"));
			map2.put("total_uconectados", map.get("total_uconectados"));
			map2.put("con_resp", map.get("con_resp"));
			map2.put("por_con_resp", map.get("por_con_resp"));
			map2.put("sin_resp", map.get("sin_resp"));
			map2.put("por_sin_resp", map.get("por_sin_resp"));
			map2.put("total_enc_sincronizadas", map.get("total_enc_sincronizadas"));
			map2.put("de_usuarios_conectados", map.get("de_usuarios_conectados"));
			listadoFinal.add(map2);
		}
		
		logger.debug("Listado de estadisticas por Zonas: {}", listadoFinal);
		return listadoFinal;
	}
	
	
	
	public List<HashMap<String, Object>> concentrado4Secciones(Integer idRegion){
		List<HashMap<String, Object>> listado;
		List<HashMap<String, Object>> listadoFinal = new ArrayList<>();
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("idRegion", idRegion);
		
		HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
		if(!nivel.isEmpty()){
			if(nivel.get("zona")!=null){
				params.put("zona", nivel.get("zona"));
			}else{
				params.put("zona", "");
			}
			if(nivel.get("id_municipio")!=null){
				params.put("municipio", nivel.get("id_municipio"));
			}else{
				params.put("municipio", "");
			}
		}else{
			params.put("municipio", "");
			params.put("zona", "");
		}
		
		listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado4Secciones",params);
		
		for(HashMap<String, Object> map : listado){
			HashMap<String, Object> map2 = new HashMap<>();
			map2.put("reporte", 1);
			map2.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
			
			map2.put("id_municipio", map.get("id_municipio"));
			map2.put("municipio", map.get("municipio"));
			
			map2.put("zona", map.get("zona"));
			
			map2.put("seccion", map.get("seccion"));
			
			map2.put("count", map.get("count"));
			map2.put("usuarios_registrados", map.get("usuarios_registrados"));
			map2.put("mas_de_10", map.get("mas_de_10"));
			map2.put("por_mas_de_10", map.get("por_mas_de_10"));
			map2.put("menos_de_10", map.get("menos_de_10"));
			map2.put("por_menos_de_10", map.get("por_menos_de_10"));
			map2.put("total_uconectados", map.get("total_uconectados"));
			map2.put("con_resp", map.get("con_resp"));
			map2.put("por_con_resp", map.get("por_con_resp"));
			map2.put("sin_resp", map.get("sin_resp"));
			map2.put("por_sin_resp", map.get("por_sin_resp"));
			map2.put("total_enc_sincronizadas", map.get("total_enc_sincronizadas"));
			map2.put("de_usuarios_conectados", map.get("de_usuarios_conectados"));
			listadoFinal.add(map2);
		}
		
		logger.debug("Listado de estadisticas por Secciones: {}", listadoFinal);
		return listadoFinal;
	}
	
	public List<HashMap<String, Object>> concentrado4SeccionesFecha(Integer idRegion, String fechaInicio, String fechaFin){
		List<HashMap<String, Object>> listado;
		List<HashMap<String, Object>> listadoFinal = new ArrayList<>();
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("idRegion", idRegion);
		params.put("fechaInicio", fechaInicio);
		params.put("fechaFin", fechaFin);
		
	
		HashMap<String, Object> nivel = nivelUsuario(getUsuario().getNick());
		if(!nivel.isEmpty()){
			if(nivel.get("zona")!=null){
				params.put("zona", nivel.get("zona"));
			}else{
				params.put("zona", "");
			}
			if(nivel.get("id_municipio")!=null){
				params.put("municipio", nivel.get("id_municipio"));
			}else{
				params.put("municipio", "");
			}
		}else{
			params.put("municipio", "");
			params.put("zona", "");
		}
		
		listado = sqlSessionDM.selectList("estadisticas.estadisticas.concentrado4SeccionesFecha",params);
		
		for(HashMap<String, Object> map : listado){
			HashMap<String, Object> map2 = new HashMap<>();
			map2.put("reporte", 1);
			map2.put("region", RegionesDO.values()[Integer.parseInt(map.get("region").toString())-1].getNombre());
			
			map2.put("id_municipio", map.get("id_municipio"));
			map2.put("municipio", map.get("municipio"));
			
			map2.put("zona", map.get("zona"));
			
			map2.put("seccion", map.get("seccion"));
			
			map2.put("count", map.get("count"));
			map2.put("usuarios_registrados", map.get("usuarios_registrados"));
			map2.put("mas_de_10", map.get("mas_de_10"));
			map2.put("por_mas_de_10", map.get("por_mas_de_10"));
			map2.put("menos_de_10", map.get("menos_de_10"));
			map2.put("por_menos_de_10", map.get("por_menos_de_10"));
			map2.put("total_uconectados", map.get("total_uconectados"));
			map2.put("con_resp", map.get("con_resp"));
			map2.put("por_con_resp", map.get("por_con_resp"));
			map2.put("sin_resp", map.get("sin_resp"));
			map2.put("por_sin_resp", map.get("por_sin_resp"));
			map2.put("total_enc_sincronizadas", map.get("total_enc_sincronizadas"));
			map2.put("de_usuarios_conectados", map.get("de_usuarios_conectados"));
			listadoFinal.add(map2);
		}
		
		logger.debug("Listado de estadisticas por Secciones: {}", listadoFinal);
		return listadoFinal;
	}
	
	public PieChartModel pg1(){
		PieChartModel pie;
		List<HashMap<String, Object>> result;
		result = sqlSessionDM.selectList("estadisticas.estadisticas.pg1");
		pie = new PieChartModel();
		
		for(HashMap<String, Object> map : result){
			pie.set(map.get("texto").toString()+" : "+map.get("count"), Integer.parseInt(map.get("count").toString()));
		}
		
		pie.setTitle("1.- ¿Cuenta usted con credencial de elector vigente?");
		pie.setLegendPosition("w");
		
		return pie;		
	}
	
	public PieChartModel pg3(){
		PieChartModel pie;
		List<HashMap<String, Object>> result;
		result = sqlSessionDM.selectList("estadisticas.estadisticas.pg3");
		pie = new PieChartModel();
		
		for(HashMap<String, Object> map : result){
			pie.set(map.get("texto").toString()+" : "+map.get("count").toString(), Integer.parseInt(map.get("count").toString()));
		}
		
		pie.setTitle("3. ¿Cómo califica la situación actual del país respecto a la existente el año pasado en lo económico?");
		pie.setLegendPosition("w");
		
		return pie;		
	}
	
	public PieChartModel pg4(){
		PieChartModel pie;
		List<HashMap<String, Object>> result;
		result = sqlSessionDM.selectList("estadisticas.estadisticas.pg4");
		
		logger.debug("result pg4: {}", result);
		
		pie = new PieChartModel();
		
		for(HashMap<String, Object> map : result){
			pie.set(map.get("texto").toString()+" : "+map.get("count"), Integer.parseInt(map.get("count").toString()));
		}
		
		pie.setTitle("4. ¿Cómo califica la situación actual del país respecto a la existente el año pasado en lo político?");
		pie.setLegendPosition("w");
		
		return pie;		
	}
	
	public PieChartModel pg5(){
		PieChartModel pie;
		List<HashMap<String, Object>> result;
		result = sqlSessionDM.selectList("estadisticas.estadisticas.pg5");
		
		logger.debug("result pg4: {}", result);
		
		pie = new PieChartModel();
		
		for(HashMap<String, Object> map : result){
			pie.set(map.get("texto").toString()+" : "+map.get("count"), Integer.parseInt(map.get("count").toString()));
		}
		
		pie.setTitle("5. ¿Cómo cree que será la situación del país para el año próximo respecto a la actual en lo económico?");
		pie.setLegendPosition("w");
		
		return pie;		
	}
	
	public PieChartModel pg6(){
		PieChartModel pie;
		List<HashMap<String, Object>> result;
		result = sqlSessionDM.selectList("estadisticas.estadisticas.pg6");
		
		logger.debug("result pg4: {}", result);
		
		pie = new PieChartModel();
		
		for(HashMap<String, Object> map : result){
			pie.set(map.get("texto").toString()+" : "+map.get("count"), Integer.parseInt(map.get("count").toString()));
		}
		
		pie.setTitle("6. ¿Cómo cree que será la situación del país para el año próximo respecto a la actual en lo político?");
		pie.setLegendPosition("w");
		
		return pie;		
	}
	
	public BarChartModel pg7(){
		BarChartModel bar;
		List<HashMap<String, Object>> result;
		result = sqlSessionDM.selectList("estadisticas.estadisticas.pg7");
		
		bar = new BarChartModel();
		bar.setTitle("7. ¿Cuál es el medio por el que usted generalmente se entera de las noticias?");
		bar.setLegendPosition("ne");
		Axis xAxis = bar.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        Axis yAxis = bar.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200000);
		
		
		for(HashMap<String, Object> map : result){
			ChartSeries serie = new ChartSeries();
			serie.setLabel(map.get("texto").toString());
			serie.set(map.get("texto").toString(), Integer.parseInt(map.get("count").toString()));
			bar.addSeries(serie);
		}
		
		return bar;
		
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
}
