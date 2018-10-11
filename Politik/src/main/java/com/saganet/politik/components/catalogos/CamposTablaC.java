package com.saganet.politik.components.catalogos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.CampoTablaEO;
import com.saganet.politik.database.catalogos.TablaEO;
import com.saganet.politik.dominios.TiposCampoDO;
import com.saganet.politik.modelos.catalogos.CamposTablaT;

@Component("CatalogosCamposTablaC")
public class CamposTablaC {
	private static final Logger logger = LoggerFactory.getLogger(CamposTablaC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public CamposTablaT tabla(TablaEO tablaEO, String tipo){
		CamposTablaT tabla;
		List<CampoTablaEO> listado;
		HashMap<String, String> mapa;
		CampoTablaEO campoNinguno;
		
		tabla = new CamposTablaT();
		mapa = new HashMap<String, String>();
		campoNinguno = new CampoTablaEO();
		
		mapa.put("esquema", "warehouse");
		mapa.put("tabla", tablaEO.getTabla());
		mapa.put("tipo", tipo);
		
		campoNinguno.setId(0);
		campoNinguno.setNombre("Ninguno");
		campoNinguno.setTipo(TiposCampoDO.INTEGER);
		
		listado = sqlSession.selectList("catalogos.camposTabla.listado", mapa);
		tabla.setListado(listado);
		listado.add(0, campoNinguno);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de Campos de la Tabla: {}", listado);
		
		return tabla;
	}
	
	public CamposTablaT tablaVacia(){
		CamposTablaT tabla;
		List<CampoTablaEO> listado=new ArrayList<>();
		tabla = new CamposTablaT();
		tabla.setListado(listado);
		return tabla;
	}
	
	public CamposTablaT tablaSinTipo(TablaEO tablaEO){
		CamposTablaT tabla;
		List<CampoTablaEO> listado;
		HashMap<String, String> mapa;
		CampoTablaEO campoNinguno;
		
		tabla = new CamposTablaT();
		mapa = new HashMap<String, String>();
		campoNinguno = new CampoTablaEO();
		
		mapa.put("esquema", tablaEO.getEsquema().getNombre());
		mapa.put("tabla", tablaEO.getTabla());
		
		campoNinguno.setId(0);
		campoNinguno.setNombre("Ninguno");
		campoNinguno.setTipo(TiposCampoDO.INTEGER);
		
		listado = sqlSession.selectList("catalogos.camposTabla.listado", mapa);
		tabla.setListado(listado);
		listado.add(0, campoNinguno);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de Campos de la Tabla: {}", listado);
		
		return tabla;
	}
	
	public CamposTablaT tablaSinTipoSimple(TablaEO tablaEO){
		CamposTablaT tabla;
		List<CampoTablaEO> listado;
		HashMap<String, String> mapa;
		
		tabla = new CamposTablaT();
		mapa = new HashMap<String, String>();
		
		mapa.put("esquema", tablaEO.getEsquema().getNombre());
		mapa.put("tabla", tablaEO.getTabla());
		
		
		listado = sqlSession.selectList("catalogos.camposTabla.listado", mapa);
		tabla.setListado(listado);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de Campos de la Tabla: {}", listado);
		
		return tabla;
	}
	
	public CamposTablaT obtenerCamposTabla(HashMap<String, String> mapaRecibido){
		CamposTablaT tabla;
		List<CampoTablaEO> listado;
		HashMap<String, String> mapa;
		
		tabla = new CamposTablaT();
		mapa = new HashMap<String, String>();
		
		String esquema=mapaRecibido.get("esquema").toString();
		String nombreTabla=mapaRecibido.get("nombreTabla").toString();
		
		mapa.put("esquema",esquema);
		mapa.put("tabla",nombreTabla);

		logger.debug("Mapa :{}",mapa);
		/*campoNinguno.setId(0);
		campoNinguno.setNombre("Ninguno"); 
		campoNinguno.setTipo(TiposCampoDO.INTEGER);
		*/
		listado = sqlSession.selectList("catalogos.camposTabla.listado", mapa);
		tabla.setListado(listado);
		//listado.add(0, campoNinguno);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de Campos de la Tabla: {}", listado);
		
		return tabla;
	}
	
	public CampoTablaEO crearCampo(String nombre, TiposCampoDO tipo){
		CampoTablaEO campo;
		
		campo = new CampoTablaEO();
		
		campo.setNombre(nombre);
		campo.setTipo(tipo);
		
		return campo;
	}
}
