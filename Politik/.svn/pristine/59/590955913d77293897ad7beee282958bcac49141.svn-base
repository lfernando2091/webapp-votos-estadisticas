package com.saganet.politik.utils.converters;

import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saganet.politik.database.cronograma.IconoEO;

@FacesConverter("IconoConverter")
public class IconoConverter implements Converter {
	private static final Logger logger = LoggerFactory.getLogger(IconoConverter.class);
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		IconoEO icono;
		StringTokenizer token;
		
		icono = new IconoEO();
		token = new StringTokenizer(value, "@");
		
		if(token.countTokens() == 3){
			icono.setId(Integer.parseInt(token.nextToken()));
			icono.setNombre(token.nextToken());
			icono.setRuta(token.nextToken());
		}
		
		logger.debug("getAsObject");
		logger.debug("context: {}", context);
		logger.debug("component: {}", component);
		logger.debug("value: {}", value);
		logger.debug("Icono generado: {}", icono);
		
		return icono;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String iconoString;
		IconoEO icono;
		
		icono = (IconoEO) value;
		iconoString = icono.getId() + "@" + icono.getNombre() + "@" + icono.getRuta();
		
		logger.debug("getAsString");
		logger.debug("context: {}", context);
		logger.debug("component: {}", component);
		logger.debug("value: {}", value);
		logger.debug("value class: {}", value.getClass());
		logger.debug("Icono String generado: {}", iconoString);
		
		return iconoString;
	}

}
