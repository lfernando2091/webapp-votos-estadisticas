package com.saganet.politik.components.estructuras;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.endpoint.RectangleEndPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.utilidades.diagram.DiagramModelPolitik;
import com.saganet.politik.utilidades.diagram.ElementPolitik;

@Component("EstructurasDiagramaC")
public class DiagramaC {
	private static final Logger logger = LoggerFactory.getLogger(DiagramaC.class);

	@Autowired
	SqlSession sqlSession;

	public DiagramModel prueba() {
		DiagramModelPolitik model;
		List<EntidadEO> entidades;
		EndPoint endPoint;

		model = new DiagramModelPolitik();

		model.setMaxConnections(-1);
		
		entidades = sqlSession.selectList("catalogos.entidades.listado");
        
        ElementPolitik elementA = new ElementPolitik(entidades.get(9), entidades.get(9).getNombre(), "20em", "6em");
        endPoint = new RectangleEndPoint(EndPointAnchor.BOTTOM);
        endPoint.setSource(true);
        elementA.addEndPoint(endPoint);
        
        ElementPolitik elementB = new ElementPolitik(entidades.get(13), entidades.get(13).getNombre(), "10em", "18em");
        endPoint = new DotEndPoint(EndPointAnchor.TOP);
        endPoint.setTarget(true);
        elementB.addEndPoint(endPoint);
        
        endPoint = new RectangleEndPoint(EndPointAnchor.RIGHT, 5, 5);
        endPoint.setTarget(true);
        elementB.addEndPoint(endPoint);
         
        ElementPolitik elementC = new ElementPolitik(entidades.get(15), entidades.get(15).getNombre(), "40em", "18em");
        endPoint = new DotEndPoint(EndPointAnchor.TOP);
        endPoint.setTarget(true);
        elementC.addEndPoint(endPoint);
        
        endPoint = new DotEndPoint(EndPointAnchor.LEFT);
        endPoint.setTarget(true);
        elementC.addEndPoint(endPoint);
                         
        model.addElement(elementA);
        model.addElement(elementB);
        model.addElement(elementC);
         
        Connection conection;
        FlowChartConnector flowChartConnector;
        
        conection = new Connection(elementA.getEndPoints().get(0), elementB.getEndPoints().get(0));
        //conection.setDetachable(false);
        flowChartConnector = new FlowChartConnector();
        flowChartConnector.setPaintStyle("{strokeStyle:'#98AFC7', lineWidth:1}");
        conection.setConnector(flowChartConnector);
        model.connect(conection);
        
        conection = new Connection(elementA.getEndPoints().get(0), elementC.getEndPoints().get(0));
        //conection.setDetachable(false);
        conection.setConnector(new StraightConnector());
        model.connect(conection);
        
        conection = new Connection(elementB.getEndPoints().get(1), elementC.getEndPoints().get(1));
        //conection.setDetachable(false);
        conection.setConnector(new StateMachineConnector());
        model.connect(conection);

		return model;
	}
}
