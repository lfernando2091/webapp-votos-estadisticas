package mx.com.saganet.peon.beans.sig;

import java.io.Serializable;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.MapModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapaB implements Serializable {
	private static final long serialVersionUID = -5475735119125104628L;
	
	private Object data;
	private MapModel modeloMapa;

	private static final Logger logger = LoggerFactory.getLogger(MapaB.class);
	
	public void onOverlaySelect(OverlaySelectEvent event){
		this.setData(event.getOverlay().getData());
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public MapModel getModeloMapa() {
		return modeloMapa;
	}

	public void setModeloMapa(MapModel modeloMapa) {
		this.modeloMapa = modeloMapa;
	}
}
