package com.saganet.politik.beans.estadisticas.syncdm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.Circle;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MapaEncuestas implements Serializable {
	private static final long serialVersionUID = -867764391919942230L;
	private MapModel circleModel;
	private static final Logger logger = LoggerFactory.getLogger(MapaEncuestas.class);
    @PostConstruct
    public void init() {
         
        circleModel = new DefaultMapModel();
  
        //Shared coordinates
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord4 = new LatLng(36.885233, 30.702323);
 
        //Circle
        Circle circle1 = new Circle(coord1, 500);
        circle1.setStrokeColor("#d93c3c");
        circle1.setFillColor("#d93c3c");
        circle1.setFillOpacity(0.5);
 
        Circle circle2 = new Circle(coord4, 300);
        circle2.setStrokeColor("#00ff00");
        circle2.setFillColor("#00ff00");
        circle2.setStrokeOpacity(0.7);
        circle2.setFillOpacity(0.7);
 
        circleModel.addOverlay(circle1);
        circleModel.addOverlay(circle2);
    }
    public MapModel mapa(String latitud, String longitud){
    	MapModel mapaRetornar;
    	logger.debug("Latitud: {}", latitud); 
    	logger.debug("Latitud: {}", longitud); 
    	mapaRetornar = new DefaultMapModel();
    	LatLng coord1 = new LatLng(Double.parseDouble(latitud.toString()),  Double.parseDouble(longitud.toString()));
        LatLng coord4 = new LatLng(36.885233, 30.702323);
        //Circle
        Circle circle1 = new Circle(coord1, 30);
        circle1.setStrokeColor("#d93c3c");
        circle1.setFillColor("#d93c3c");
        circle1.setFillOpacity(0.5);
 
        Circle circle2 = new Circle(coord4, 300);
        circle2.setStrokeColor("#00ff00");
        circle2.setFillColor("#00ff00");
        circle2.setStrokeOpacity(0.7);
        circle2.setFillOpacity(0.7);
        mapaRetornar.addOverlay(circle1);
       // mapaRetornar.addOverlay(circle2);
    	return mapaRetornar;
    }
    public MapModel mapaUsuario(List<HashMap<String, Object>> encuestas){
   	 MapModel modeloCirculo;
   	modeloCirculo = new DefaultMapModel();
   	for(HashMap<String, Object> ubicacionEncuestas: encuestas){
   		 LatLng coord1 = new LatLng(Double.parseDouble(ubicacionEncuestas.get("longitud_encuesta").toString()), Double.parseDouble(ubicacionEncuestas.get("latitud_encuesta").toString()));
   		 //Circle
   	        Circle circle1 = new Circle(coord1, 500);
   	        circle1.setStrokeColor("#d93c3c");
   	        circle1.setFillColor("#d93c3c");
   	        modeloCirculo.addOverlay(circle1);
   	}
   	return modeloCirculo;
   }
    public MapModel getCircleModel() {
        return circleModel;
    }
  
    public void onCircleSelect(OverlaySelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Circle Selected", null));
    }
}
