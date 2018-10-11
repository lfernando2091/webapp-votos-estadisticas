package com.saganet.politik.components.eventos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.modelos.Modelo;

@Component("EventosReportesC")
public class EventosReportesC {

	private static final Logger logger = LoggerFactory.getLogger(EventosReportesC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<HashMap<String, Object>> modelo(String fecha){
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> params;
		
		List<HashMap<String, Object>> dias;
		dias = new ArrayList<>();
		
		dias = dias(Integer.parseInt(fecha.substring(0, 2)), Integer.parseInt(fecha.substring(3, 7)));
		
		params = new HashMap<>();
		
		params.put("dias", dias);
		
		listado = sqlSession.selectList("eventos.eventosReportes.reportePorMes", params);
		logger.debug("Listado de días: {}", listado.toString());
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo de días: {}", modelo.toString());
		return modelo;
		
	}
	
	@SuppressWarnings("deprecation")
	public List<HashMap<String, Object>> dias(Integer mes, Integer anio){
		
		List<HashMap<String, Object>> dias = new ArrayList<>();
		
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		date.setYear(anio);
		date.setMonth(mes-1);
		calendar.setTime(date);
		@SuppressWarnings("static-access")
		int days = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		
		HashMap<String, Object> param;
		
		for(int i = 1; i<=days; i++){
			param= new HashMap<>();
			if(String.valueOf(i).length()==1){
				if(String.valueOf(mes).length()==1){
					//dias.add("0"+i+"-"+"0"+(mes)+"-"+anio);
					param.put("dia", "0"+i+"-"+"0"+(mes)+"-"+anio);
					param.put("alias", "dia_"+i);
					logger.debug("dia: {}","0"+i+"-"+"0"+(mes)+"-"+anio);
				}else{
					//dias.add("0"+i+"-"+(mes)+"-"+anio);
					param.put("dia", "0"+i+"-"+(mes)+"-"+anio);
					param.put("alias", "dia_"+i);
					logger.debug("0"+i+"-"+(mes)+"-"+anio);
				}
			}else{
				if(String.valueOf(mes).length()==1){
					//dias.add(i+"-"+"0"+(mes)+"-"+anio);
					param.put("dia", i+"-"+"0"+(mes)+"-"+anio);
					param.put("alias", "dia_"+i);
					logger.debug(i+"-"+"0"+(mes)+"-"+anio);
				}else{
					//dias.add(i+"-"+(mes)+"-"+anio);
					param.put("dia", i+"-"+(mes)+"-"+anio);
					param.put("alias", "dia_"+i);
					logger.debug(i+"-"+(mes)+"-"+anio);
				}
			}
			dias.add(param);
		}
		return dias;
	}
	
	public Modelo<HashMap<String, Object>> modeloConteo(String fecha){
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> params;
		
		List<HashMap<String, Object>> dias;
		dias = new ArrayList<>();
		
		dias = dias(Integer.parseInt(fecha.substring(0, 2)), Integer.parseInt(fecha.substring(3, 7)));
		
		params = new HashMap<>();
		
		params.put("dias", dias);
		
		listado = sqlSession.selectList("eventos.eventosReportes.reportePorMesConteo", params);
		logger.debug("Listado de días: {}", listado.toString());
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			listado.add(sumaModeloConteo(modelo));
			modelo.setSeleccionado(listado.get(0));
		}

		modelo.setListado(listado);
		logger.debug("Modelo de días: {}", modelo.toString());
		
		
		return modelo;
		
	}
	
	public HashMap<String, Object> sumaModeloConteo(Modelo<HashMap<String, Object>> modelo){
		//logger.debug("modeloConteo: {}", modelo.toString());
		HashMap<String, Object> r;
		r = new HashMap<>();
		/*Integer contador=0;
		for(int i = 1; i<=31; i++){
			r = new HashMap<>();
			if (modelo.getListado()!=null) {
				for(HashMap<String, Object> mapMod : modelo.getListado()){
					//logger.debug("Res: {}, {}", mapMod.get("dia_"+i), mapMod.get("dia_"+i).toString().getClass());
					if (mapMod!=null) {
						contador=contador+Integer.parseInt(((mapMod.get("dia_"+i).toString()!=null)?mapMod.get("dia_"+i).toString():"0"));
					}
					//logger.debug("contador: {}", contador);
				}
			}
			r.put("dia_"+i,contador);
			logger.debug("Res: {}", r.get("dia_"+i));
			result.add(r);
			contador=0;
		}
		logger.debug("REsult {}",result);*/
		for(int i = 1; i<=31; i++){
			r.put("dia_"+i,0);
		}
		if (modelo!=null) {
			if (modelo.getListado()!=null) {
				for(HashMap<String, Object> mapMod : modelo.getListado()){
					//logger.debug("Res: {}", mapMod.get("particion"));
					for(int i = 1; i<=31; i++){
							if(mapMod.get("dia_"+i)!=null){
								r.put("dia_"+i, Integer.parseInt((r.get("dia_"+i).toString()!=null?r.get("dia_"+i).toString():"0"))+Integer.parseInt(mapMod.get("dia_"+i).toString()!=null?mapMod.get("dia_"+i).toString():"0"));
							}
					}
					//logger.debug("r: {}", r);
				}
			}
		}
		r.put("particion","Total");
		r.put("id_particion","-1");
		logger.debug("resultado: {}", r);
		return r;
	}
	
}
