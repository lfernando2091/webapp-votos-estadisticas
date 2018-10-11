package com.saganet.politik.utilidades.diagram;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.Connector;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.overlay.Overlay;

import com.saganet.politik.modelos.JavaBeanT;

public class DiagramModelPolitik implements DiagramModel, Serializable {
	private static final long serialVersionUID = 2422166011411753734L;

	private List<Element> elements;

	private List<Connection> connections;

	private Connector defaultConnector;

	private List<Overlay> defaultConnectionOverlays;

	private boolean connectionsDetachable = true;

	private int maxConnections = 1;

	public DiagramModelPolitik() {
        elements = new ElementList();
        connections = new ArrayList<Connection>();
        defaultConnectionOverlays = new ArrayList<Overlay>();
    }

	@Override
	public String toString() {
		return "DiagramModelPolitik [elements=" + elements + ", connections=" + connections + ", defaultConnector="
				+ defaultConnector + ", defaultConnectionOverlays=" + defaultConnectionOverlays
				+ ", connectionsDetachable=" + connectionsDetachable + ", maxConnections=" + maxConnections + "]";
	}

	public List<Element> getElements() {
		return elements;
	}

	public void addElement(Element element) {
		elements.add(element);
	}

	public void removeElement(Element element) {
		elements.remove(element);
	}

	public void clear() {
		elements.clear();
	}

	public void clearElements() {
		elements.clear();
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void connect(Connection connection) {
		this.connections.add(connection);
	}

	public void disconnect(Connection connection) {
		this.connections.remove(connection);
	}

	public Connector getDefaultConnector() {
		return defaultConnector;
	}

	public void setDefaultConnector(Connector defaultConnector) {
		this.defaultConnector = defaultConnector;
	}

	public List<Overlay> getDefaultConnectionOverlays() {
		return this.defaultConnectionOverlays;
	}

	public boolean isConnectionsDetachable() {
		return connectionsDetachable;
	}

	public void setConnectionsDetachable(boolean connectionsDetachable) {
		this.connectionsDetachable = connectionsDetachable;
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	public Element findElement(String id) {
		Element element = null;
		if (elements != null && !elements.isEmpty()) {
			for (int i = 0; i < elements.size(); i++) {
				Element el = elements.get(i);

				if (el.getId().equals(id)) {
					element = el;
					break;
				}
			}
		}

		return element;
	}
	
	public Element buscarElementoPorJavaBean(JavaBeanT objeto){
		Element encontrado;
		
		encontrado = null;
		for(Element elemento : elements){
			if(elemento.getData().equals(objeto)){
				encontrado = elemento;
			}
		}
		
		return encontrado;
	}
	
	public Element buscarElementoPorEndPoint(EndPoint endPoint){
		Element encontrado;
		
		encontrado = null;
		for(Element elemento : elements){
			for(EndPoint ep : elemento.getEndPoints()){
				if(ep.equals(endPoint)){
					encontrado = elemento;
				}
			}
		}
		
		return encontrado;
	}

	public EndPoint findEndPoint(Element element, String id) {
		EndPoint endPoint = null;
		List<EndPoint> endPoints = element.getEndPoints();

		if (endPoints != null && !endPoints.isEmpty()) {
			for (int i = 0; i < endPoints.size(); i++) {
				EndPoint ep = endPoints.get(i);

				if (ep.getId().equals(id)) {
					endPoint = ep;
					break;
				}
			}
		}

		return endPoint;
	}
}
