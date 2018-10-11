package com.saganet.politik.utils.converters;

import java.sql.Date;
import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saganet.politik.utilidades.Formateador;

@FacesConverter("DateConverter")
public class DateConverter implements Converter {
	private static final Logger logger = LoggerFactory.getLogger(DateConverter.class);
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		//logger.debug("getAsObject");
		//logger.debug("context: {}", context);
		//logger.debug("component: {}", component);
		//logger.debug("value: {}", value);
		
		Date objeto;
		Calendar calendario;
		// 01/04/2016
		calendario = Calendar.getInstance();
		calendario.set(Calendar.DAY_OF_MONTH, Integer.parseInt(value.substring(0, 2)));
		calendario.set(Calendar.MONTH, Integer.parseInt(value.substring(3, 5))-1);
		calendario.set(Calendar.YEAR, Integer.parseInt(value.substring(6, 10)));
		
		objeto = new Date(calendario.getTimeInMillis());
		logger.debug("Se genera objeto Date: {}", objeto);
		
		return objeto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Date fecha;
		Formateador formateador;
		String fechaConvertida;
		
		formateador = new Formateador();
		
		fecha = new Date(((Date) value).getTime());
		fechaConvertida = formateador.fecha(fecha);
		
		//logger.debug("getAsString");
		//logger.debug("context: {}", context);
		//logger.debug("component: {}", component);
		//logger.debug("value: {}", value);
		//logger.debug("value class: {}", value.getClass());
		//logger.debug("Valor generado: {}", fechaConvertida);
		
		return fechaConvertida;
	}

}
