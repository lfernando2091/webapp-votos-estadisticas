package com.saganet.politik.utils.converters;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@FacesConverter("ObjectConverter")
public class ObjectConverter implements Converter {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ObjectConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		String cadena;
		ObjectMapper objectMapper;
		StringTokenizer tokenizer;
		Object objeto;
		String clase;
		String json;
		
		//logger.debug("getAsObject");
		//logger.debug("context: {}", context);
		//logger.debug("component: {}", component);
		//logger.debug("value: {}", value);
		
		cadena = value.replaceAll("&c;", "\"");
		
		//logger.debug("cadena: {}", cadena);
		
		objectMapper = new ObjectMapper();
		//logger.debug("objectMapper generado: {}", objectMapper);
		tokenizer = new StringTokenizer(cadena, "@", true);
		//logger.debug("Tokenizer creado: {} con tokens: {}", tokenizer, tokenizer.countTokens());
		
		if(tokenizer.countTokens() >= 2){
			clase = tokenizer.nextToken();
			tokenizer.nextToken(); //Descartar la @
			json = tokenizer.nextToken("");
			//logger.debug("tokens leidos. clase: {} json: {}", clase, json);
		} else {
			clase = null;
			json = null;
		}
		
		objeto = null;
		
		try {
			objeto = objectMapper.readValue(json, Class.forName(clase));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//logger.debug("getAsObject Objeto Generado: {}", objeto);		
		return objeto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		StringBuilder stringBuilder;
		ObjectMapper objectMapper;
		String respuesta;
		
		//logger.debug("getAsString");
		//logger.debug("context: {}", context);
		//logger.debug("component: {}", component);
		//logger.debug("value: {}", value);
		//logger.debug("value class: {}", value.getClass().getName());
		
		objectMapper = new ObjectMapper();
		//objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		stringBuilder = new StringBuilder(value.getClass().getName());
		stringBuilder.append("@");
		try {
			stringBuilder.append(objectMapper.writeValueAsString(value));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		respuesta = stringBuilder.toString().replaceAll("\"", "&c;");
		
		//logger.debug("getAsString Respuesta Generada: {}", respuesta);	
		return respuesta;
	}

}
