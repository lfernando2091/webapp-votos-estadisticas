package com.saganet.politik.components.encuestas.syncdm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.map.Circle;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.components.sig.PoligonosC;
import com.saganet.politik.components.sig.ReportesC;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.utilidades.Poligono;

import mx.com.saganet.peon.database.dominios.TiposPoligonoDO;

import com.saganet.politik.components.catalogos.MunicipiosC;
@Component("SyncDMMonitorC")
public class MonitorC {
	
	@Autowired SqlSession sqlSession;
	@Autowired PoligonosC poligonosC;
	
	@Autowired
	MunicipiosC municipiosC;
	private static final Logger logger = LoggerFactory.getLogger(ReportesC.class);
	
	
	public void mapaMunicipio(RequestContext rc){
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> llavesPrioridades, listado;
		HashMap<String, Object> mapa, viewScope;
		MunicipioEO municipio;
		MapModel modeloMapa;
		List<Poligono> poligonos;
		Poligono poligono;
		
		modelo = new Modelo<>();
		listado = new ArrayList<>();
		viewScope = (HashMap<String, Object>) rc.getViewScope().asMap();
		modeloMapa = new DefaultMapModel();
		
		llavesPrioridades = sqlSession.selectList("encuestas.syncdm.llaves.municipiosImjuve", "15-38");
		
		for(HashMap<String, Object> m : llavesPrioridades){
			mapa = new HashMap<>();
			
			municipio = municipiosC.buscarPorLlave((String) m.get("llave"));
			mapa.put("municipio", municipio);
			mapa.put("prioridad", m.get("prioridad"));
			
			listado.add(mapa);
		}
		
		modelo.setListado(listado);
		modelo.setSeleccionado(listado.get(0));
		
		poligonos = new ArrayList<>();
			
		for(HashMap<String, Object> m : modelo.getListado()){
			poligono = new Poligono();
			poligono.setTipo(TiposPoligonoDO.MUNICIPIO);
			poligono.setLlave( ((MunicipioEO) m.get("municipio")).getLlave() );
			poligono.setOpacidadRelleno(0.5);
				poligono.setColorRelleno("GREEN");
			poligonos.add(poligono);
		}
		modeloMapa = poligonosC.modeloMapa(poligonos);
		
		viewScope.put("modeloMunicipios", modelo);
		viewScope.put("modeloMapa", modeloMapa);
		viewScope.put("width", 2000);
		viewScope.put("height", 2000);
	}


}
