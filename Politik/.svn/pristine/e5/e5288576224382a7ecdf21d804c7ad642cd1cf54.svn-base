package com.saganet.politik.utils.converters;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saganet.politik.utilidades.Formateador;

@FacesConverter("TimestampConverter")
public class TimestampConverter implements Converter {
	private static final Logger logger = LoggerFactory.getLogger(TimestampConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		logger.debug("getAsObject");
		logger.debug("context: {}", context);
		logger.debug("component: {}", component);
		logger.debug("value: {}", value);
		
		Timestamp objeto;
		Calendar calendario;
		// 2016/04/01 00:00
		// 0123456789012345
		calendario = Calendar.getInstance();
		calendario.set(Calendar.YEAR, Integer.parseInt(value.substring(0, 4)));
		calendario.set(Calendar.MONTH, Integer.parseInt(value.substring(5, 7))-1);
		calendario.set(Calendar.DAY_OF_MONTH, Integer.parseInt(value.substring(8, 10)));
		calendario.set(Calendar.HOUR_OF_DAY, Integer.parseInt(value.substring(11, 13)));
		calendario.set(Calendar.MINUTE, Integer.parseInt(value.substring(14, 16)));
		calendario.set(Calendar.SECOND, 0);
		calendario.set(Calendar.MILLISECOND, 0);
		
		objeto = new Timestamp(calendario.getTimeInMillis());
		logger.debug("Se genera objeto Timestamp: {}", objeto);
		
		return objeto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Date fecha;
		Formateador formateador;
		String fechaConvertida;
		
		formateador = new Formateador();
		
		fecha = new Date(((Timestamp) value).getTime());
		fechaConvertida = formateador.fechaCalendario(fecha);
		
		logger.debug("getAsString");
		logger.debug("context: {}", context);
		logger.debug("component: {}", component);
		logger.debug("value: {}", value);
		logger.debug("value class: {}", value.getClass());
		logger.debug("Valor generado: {}", fechaConvertida);
		
		return fechaConvertida;
	}

}
