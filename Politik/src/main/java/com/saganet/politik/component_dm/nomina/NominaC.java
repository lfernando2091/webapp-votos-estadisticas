package com.saganet.politik.component_dm.nomina;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("NominaC")
public class NominaC {
	
	@Autowired
	SqlSession sqlSessionDM;
	
	private static final Logger logger = LoggerFactory.getLogger(NominaC.class);
	
	public List<HashMap<String, Object>> listadoNomina(){
		List<HashMap<String, Object>> listado;
		listado = sqlSessionDM.selectList("nomina.nomina.listado");
		logger.debug("Listado Nomina: {}", listado);
		
		
		for(HashMap<String, Object> map : listado){
			//Calculamos_total_encuestas
			if (map.get("con_resp")!=null && map.get("sin_resp")!=null) {

				//map.put("encuestas_total", Integer.parseInt(map.get("con_resp").toString())+Integer.parseInt(map.get("sin_resp").toString()));
			}
			else if (map.get("con_resp")!=null) {
				map.put("encuestas_total", Integer.parseInt(map.get("con_resp").toString()));
			}
			else if (map.get("sin_resp")!=null) {
				map.put("encuestas_total", Integer.parseInt(map.get("sin_resp").toString()));
			}
			else{
				map.put("encuestas_total",0);
			}
			//Calculamos_meta_general
			map.put("meta_general", (Integer)Integer.parseInt(map.get("dias_a_considerar").toString())*Integer.parseInt(map.get("meta_por_dia").toString()));	
			//Calculamos_meta_final
			map.put("meta_final", (float)Integer.parseInt(map.get("meta_general").toString())*Double.parseDouble("0.9"));
			//Calculamos_productividad_total
			if(Integer.parseInt(map.get("encuestas_total").toString())>Double.parseDouble(map.get("meta_final").toString())){
				map.put("productividad_total", (float)1);
			}else{
				map.put("productividad_total", (float)Integer.parseInt(map.get("encuestas_total").toString())/Double.parseDouble(map.get("meta_final").toString()));
			}
			//Calculamos_monto_proporcional
			map.put("monto_proporcional", (float)((133.3333333333333)*(double)(Integer.parseInt(map.get("dias_a_considerar").toString()))));
			//Calculamos_monto_a_pagar
			map.put("monto_a_pagar", Double.parseDouble(map.get("productividad_total").toString())*Double.parseDouble(map.get("monto_proporcional").toString()));
		}
		
		//logger.debug("Listado Nomina Completa: {}", listado);
		
		return listado;
	}
	
}
