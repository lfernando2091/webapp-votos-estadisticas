package com.saganet.politik.component_dm.estadisticas;

import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.event.TabChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("EstadisticasAvancesC")
public class EstadisticasAvancesC {


	@Autowired
	SqlSession sqlSessionDM;
	
	private static final Logger logger = LoggerFactory.getLogger(EstadisticasAvancesC.class);
	
	public List<HashMap<String, Object>> listadoSemanas(){
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> params;
		
		params =  new HashMap<>();
		listado = sqlSessionDM.selectList("estadisticas.estadisticas_avances.selectSemanas");
		logger.debug("Listado: {}", listado);
		return listado;
		
	}
	
	
	
	public List<HashMap<String, Object>> listadoContestadas (Integer region, String semana, Integer nivel){
	List<HashMap<String, Object>> listado;
	HashMap<String, Object> params;
	
	params =  new HashMap<>();
	params.put("region", region);
	params.put("semana", semana);
	params.put("nivel", nivel);
	listado = sqlSessionDM.selectList("estadisticas.estadisticas_avances.selectContestadas", params);
	logger.debug("Listado: {}", listado);
	return listado;
	}
	public List<HashMap<String, Object>> listadoNoContestadas (Integer region, String semana, Integer nivel){
	List<HashMap<String, Object>> listado;
	HashMap<String, Object> params;
	
	params =  new HashMap<>();
	params.put("region", region);
	params.put("semana", semana);
	params.put("nivel", nivel);
	listado = sqlSessionDM.selectList("estadisticas.estadisticas_avances.selectNoContestadas", params);
	logger.debug("Listado: {}", listado);
	return listado;
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
			map.put("llave", 1);
			var1 = var1 + Integer.parseInt(map.get("c_lunes").toString());
			var2 = var2 + Integer.parseInt(map.get("c_martes").toString());
			var3 = var3 + Integer.parseInt(map.get("c_miercoles").toString());
			var4 = var4 + Integer.parseInt(map.get("c_jueves").toString());
			var5 = var5 + Integer.parseInt(map.get("c_viernes").toString());
			var6 = var6 + Integer.parseInt(map.get("c_sabado").toString());
			var7 = var7 + Integer.parseInt(map.get("c_domingo").toString());
			var8 = var8 + Integer.parseInt(map.get("c_total").toString());
		}
		
		resultado.put("tc_lunes",var1);
		resultado.put("tc_martes",var2);
		resultado.put("tc_miercoles",var3);
		resultado.put("tc_jueves",var4);
		resultado.put("tc_viernes",var5);
		resultado.put("tc_sabado",var6);
		resultado.put("tc_domingo",var7);
		resultado.put("tc_total",var8);
		
		logger.debug("Totales Concentrado: {}", resultado);
		
		return resultado;
	}
	
	
	public HashMap<String, Object> totalesNoConcentrados(List<HashMap<String, Object>> listado){
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
			map.put("llave", 1);
			var1 = var1 + Integer.parseInt(map.get("nc_lunes").toString());
			var2 = var2 + Integer.parseInt(map.get("nc_martes").toString());
			var3 = var3 + Integer.parseInt(map.get("nc_miercoles").toString());
			var4 = var4 + Integer.parseInt(map.get("nc_jueves").toString());
			var5 = var5 + Integer.parseInt(map.get("nc_viernes").toString());
			var6 = var6 + Integer.parseInt(map.get("nc_sabado").toString());
			var7 = var7 + Integer.parseInt(map.get("nc_domingo").toString());
			var8 = var8 + Integer.parseInt(map.get("nc_total").toString());
		}
		
		resultado.put("tc_lunes",var1);
		resultado.put("tc_martes",var2);
		resultado.put("tc_miercoles",var3);
		resultado.put("tc_jueves",var4);
		resultado.put("tc_viernes",var5);
		resultado.put("tc_sabado",var6);
		resultado.put("tc_domingo",var7);
		resultado.put("tc_total",var8);
		
		logger.debug("Totales Concentrado: {}", resultado);
		
		return resultado;
	}
	
	
    
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        logger.debug("DAto: {}", event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
       
}
