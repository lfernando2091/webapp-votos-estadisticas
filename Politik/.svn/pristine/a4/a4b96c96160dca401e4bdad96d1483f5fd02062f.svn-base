package com.saganet.politik.components.sig;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Polygon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.components.catalogos.DFederalesC;
import com.saganet.politik.components.catalogos.EntidadesC;
import com.saganet.politik.components.catalogos.ManzanasC;
import com.saganet.politik.components.catalogos.MunicipiosC;
import com.saganet.politik.components.catalogos.SeccionesC;
import mx.com.saganet.peon.database.PoligonoData;
import mx.com.saganet.peon.database.dominios.TiposPoligonoDO;

import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.ManzanaEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.database.sig.PoligonoEO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.utilidades.Poligono;


@Component("SigPoligonosC")
public class PoligonosC {
	private static final Logger logger = LoggerFactory.getLogger(PoligonosC.class);

	@Autowired SqlSession sqlSession;
	@Autowired SqlSession sqlSessionSig;
	@Autowired EntidadesC entidadesC;
	@Autowired MunicipiosC municipiosC;
	@Autowired DFederalesC dFederalesC;
	@Autowired SeccionesC seccionesC;
	@Autowired ManzanasC manzanasC;
	
	public void cargarPoligonos(PoligonoEO poligono){
		ByteArrayInputStream bais;
		ObjectInputStream ois;
		List<byte[]> objetosBytes;
		
		poligono.setPoligonos(new ArrayList<Polygon>());
		//logger.debug("Poligono: {}", poligono);
		objetosBytes = sqlSession.selectList("sig.poligonos.obtenerPoligonos", poligono);
		try {
			for(byte[] b : objetosBytes){
				bais = new ByteArrayInputStream(b);
				ois = new ObjectInputStream(bais);
				poligono.getPoligonos().add((Polygon) ois.readObject());
				//logger.debug("Poligono llenado: {}", poligono);
				ois.close();
				bais.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.debug("Error: {}",e.getMessage());
		}
	}
	
	public MapModel modeloMapa(List<Poligono> listaPoligonos){
		logger.debug("Listado: {}", listaPoligonos);
		MapModel modelo;
		int id;
		PoligonoEO poligono;
		
		modelo = new DefaultMapModel();
		
		id = 0;
		for(Poligono pol : listaPoligonos){
			poligono = new PoligonoEO();
			poligono.setId(id++);
			poligono.setLlave(pol.getLlave());
			poligono.setTipo(pol.getTipo());
			cargarPoligonos(poligono);
			for(Polygon p : poligono.getPoligonos()){
				p.setFillColor(pol.getColorRelleno());
				p.setFillOpacity(pol.getOpacidadRelleno());
				p.setStrokeColor(pol.getColorLinea());
				p.setStrokeOpacity(pol.getOpacidadLinea());
				p.setStrokeWeight(pol.getGrosorLinea());
				modelo.addOverlay(p);
			}
		}
		
		return modelo;
	}
	
	public List<Poligono> testPoligonos(String llaveSeccion){
		List<Poligono> lista;
		Poligono poligono;
		
		lista = new ArrayList<>();
		
		

		/*
		poligono = new Poligono();
		poligono.setTipo(TiposPoligonoDO.ENTIDAD);
		poligono.setLlave("13");
		//poligono.setColorLinea(colorLinea);
		poligono.setColorRelleno("#FE2E2E");
		//poligono.setGrosorLinea(grosorLinea);
		//poligono.setOpacidadLinea(opacidadLinea);
		poligono.setOpacidadRelleno(0.1);
		lista.add(poligono);
		
		poligono = new Poligono();
		poligono.setTipo(TiposPoligonoDO.DISTRITO_FEDERAL);
		poligono.setLlave("13-6");
		//poligono.setColorLinea(colorLinea);
		poligono.setColorRelleno("#F4FA58");
		//poligono.setGrosorLinea(grosorLinea);
		//poligono.setOpacidadLinea(opacidadLinea);
		poligono.setOpacidadRelleno(0.2);
		lista.add(poligono);
		
		poligono = new Poligono();
		poligono.setTipo(TiposPoligonoDO.MUNICIPIO);
		poligono.setLlave("13-47");
		//poligono.setColorLinea(colorLinea);
		poligono.setColorRelleno("#58D3F7");
		//poligono.setGrosorLinea(grosorLinea);
		//poligono.setOpacidadLinea(opacidadLinea);
		poligono.setOpacidadRelleno(0.3);
		lista.add(poligono);
		
		poligono = new Poligono();
		poligono.setTipo(TiposPoligonoDO.SECCION);
		poligono.setLlave("13-854");
		//poligono.setColorLinea(colorLinea);
		poligono.setColorRelleno("#01DF01");
		//poligono.setGrosorLinea(grosorLinea);
		//poligono.setOpacidadLinea(opacidadLinea);
		poligono.setOpacidadRelleno(0.4);
		lista.add(poligono);
		*/
		
		List<ManzanaEO> manzanas;
		manzanas = manzanasC.modelo(seccionesC.buscarPorLlave(llaveSeccion)).getListado();
		
		for(ManzanaEO m : manzanas){
			poligono = new Poligono();
			poligono.setTipo(TiposPoligonoDO.MANZANA);
			poligono.setLlave(m.getLlave());
			//poligono.setColorLinea(colorLinea);
			poligono.setColorRelleno("#A4A4A4");
			//poligono.setGrosorLinea(grosorLinea);
			//poligono.setOpacidadLinea(opacidadLinea);
			poligono.setOpacidadRelleno(0.5);
			lista.add(poligono);
		}
		
		/*
		for(EntidadEO entidad : entidadesC.modelo().getListado()){
			poligono = new Poligono();
			poligono.setTipo(TiposPoligonoDO.ENTIDAD);
			poligono.setLlave(entidad.getLlave());
			//poligono.setColorLinea(colorLinea);
			poligono.setColorRelleno("#A4A4A4");
			//poligono.setGrosorLinea(grosorLinea);
			//poligono.setOpacidadLinea(opacidadLinea);
			poligono.setOpacidadRelleno(0.5);
			lista.add(poligono);
		}
		*/
		
		return lista;
	}
	
	public MapModel modeloMapaEntidades(){
		return modeloMapa(TiposPoligonoDO.ENTIDAD, null);
	}
	
	public MapModel modeloMapaMunicipios(){
		return modeloMapa(TiposPoligonoDO.MUNICIPIO, null);
	}
	
	public MapModel modeloMapaDFederales(){
		return modeloMapa(TiposPoligonoDO.DISTRITO_FEDERAL, null);
	}
	
	public MapModel modeloMapaSecciones(){
		return modeloMapa(TiposPoligonoDO.SECCION, null);
	}
	
	public MapModel modeloMapaManzanas(){
		return modeloMapa(TiposPoligonoDO.MANZANA, null);
	}
	
	public MapModel modeloMapa(TiposPoligonoDO tipo, EntidadEO entidad){
		MapModel modelo;
		Modelo<EntidadEO> modeloEntidades;
		Modelo<MunicipioEO> modeloMunicipios;
		Modelo<DFederalEO> modeloDFederales;
		Modelo<SeccionEO> modeloSecciones;
		Modelo<ManzanaEO> modeloManzanas;
		List<String> llaves;
		List<PoligonoEO> poligonos;
		PoligonoEO poligono;
		int id;
		
		modelo = new DefaultMapModel();
		llaves = new ArrayList<>();
		
		switch(tipo){
		case ENTIDAD:
			modeloEntidades = entidadesC.modelo();
			for(EntidadEO e : modeloEntidades.getListado()){
				llaves.add(e.getLlave());
			}
			break;
		case MUNICIPIO:
			entidad = new EntidadEO();
			entidad.setLlave("15");
			modeloMunicipios = municipiosC.modelo(entidad);
			for(MunicipioEO m : modeloMunicipios.getListado()){
				llaves.add(m.getLlave());
			}
			break;
		case DISTRITO_FEDERAL:
			entidad = new EntidadEO();
			entidad.setLlave("15");
			modeloDFederales = dFederalesC.modelo(entidad);
			for(DFederalEO df : modeloDFederales.getListado()){
				llaves.add(df.getLlave());
			}
			break;
		case SECCION:
			entidad = new EntidadEO();
			entidad.setLlave("2");
			modeloSecciones = seccionesC.modelo(entidad);
			for(SeccionEO s : modeloSecciones.getListado()){
				//if(s.getMunicipio().getLlave().equals("13-47"))
					llaves.add(s.getLlave());
			}
			break;
		case MANZANA:
			modeloManzanas = manzanasC.modelo(municipiosC.buscarPorLlave("13-47"));
			for(ManzanaEO m : modeloManzanas.getListado()){
				llaves.add(m.getLlave());
			}
			break;
		}
		
		
		poligonos = new ArrayList<>();
		
		id = 0;
		for(String llave : llaves){
			poligono = new PoligonoEO();
			poligono.setId(id++);
			poligono.setLlave(llave);
			poligono.setTipo(tipo);
			cargarPoligonos(poligono);
			poligonos.add(poligono);
		}
		
		for(PoligonoEO pEO : poligonos){
			for(Polygon p : pEO.getPoligonos()){
				p.setStrokeColor("BLACK");
				p.setFillColor("ORANGE");
				p.setFillOpacity(0.5);
				modelo.addOverlay(p);
			}
		}
		
		return modelo;
	}
	
	public void crearPoligonos(String columnaLlave, String tabla) throws IOException{
		PoligonoEO poligonoEO;
		Polygon poligono;
		List<String> llaves;
		HashMap<String, Object> parametros, parametros2;
		List<HashMap<String, Object>> poligonosPuntos;
		int path1;
		ByteArrayOutputStream baos;
		ObjectOutputStream oos;
		List<byte[]> poligonosBytes;
		
		parametros = new HashMap<>();
		parametros2 = new HashMap<>();
		
		parametros.put("columnaLlave", columnaLlave);
		parametros.put("tabla", tabla);
		llaves = sqlSessionSig.selectList("sig.poligonos.obtenerLlaves", parametros);
		
		for(String llave : llaves){
			poligonoEO = new PoligonoEO();
			poligonoEO.setTipo(TiposPoligonoDO.MANZANA);
			poligonoEO.setLlave(llave);
			poligonoEO.setPoligonos(new ArrayList<Polygon>());
			
			path1 = 1;
			poligono = new Polygon();
			poligono.setData(new PoligonoData(poligonoEO.getTipo(), poligonoEO.getLlave()));
			poligonoEO.getPoligonos().add(poligono);
			
			parametros.put("llave", llave);
			poligonosPuntos = sqlSessionSig.selectList("sig.poligonos.poligonosPuntosPorLlave", parametros);
			
			for(HashMap<String, Object> poligonoPunto : poligonosPuntos){
				//Nuevo Poligono?
				if(path1 != ((int) poligonoPunto.get("path1"))){
					//Nuevo Poligono
					path1 = (int) poligonoPunto.get("path1");
					poligono = new Polygon();
					poligono.setData(new PoligonoData(poligonoEO.getTipo(), poligonoEO.getLlave()));
					poligonoEO.getPoligonos().add(poligono);
				}
				
				//Anillo exterior?
				if(((int) poligonoPunto.get("path2")) == 1){
					//Anillo exterior
					poligono.getPaths().add(new LatLng((double) poligonoPunto.get("lat"), (double) poligonoPunto.get("lon")));
				}
			}
			
			//Insertar Poligono a Base de Datos
			parametros2.put("poligonoEO", poligonoEO);
			poligonosBytes = new ArrayList<>();
			parametros2.put("poligonosBytes", poligonosBytes);
			for(Polygon po : poligonoEO.getPoligonos()){
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.writeObject(po);
				oos.close();
				poligonosBytes.add(baos.toByteArray());
				baos.close();
			}
			
			sqlSession.insert("sig.poligonos.insertar", parametros2);
		}
	}
	
}
