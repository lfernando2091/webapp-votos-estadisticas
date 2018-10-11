package com.saganet.politik.components.catalogos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.modelos.JavaBeanT;
//import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.modelos.catalogos.MunicipiosT;


@Component("CatalogosMunicipiosC")
public class MunicipiosC {
	private static final Logger logger = LoggerFactory.getLogger(MunicipiosC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<MunicipioEO> modeloRegion(MunicipioEO municipio, GeozonaParticionEO region){
		logger.debug("Region : {}",region);
		List<MunicipioEO> listado = sqlSession.selectList("catalogos.municipios.listadoRegion", region);
		Modelo<MunicipioEO> modelo= new Modelo<>(listado);
		if (municipio!=null) {
			modelo.setSeleccionado(municipio);
		}
		logger.debug("Listado : {}",listado);
		return modelo;
	}
	
	public Modelo<MunicipioEO> modeloRegion(GeozonaParticionEO region){
		logger.debug("Region : {}",region);
		List<MunicipioEO> listado = sqlSession.selectList("catalogos.municipios.listadoRegion", region);
		logger.debug("Listado : {}",listado);
		return new Modelo<>(listado);
	}
	
	
	public Modelo<MunicipioEO> modelo(EntidadEO entidad){
		Modelo<MunicipioEO> modelo;
		List<MunicipioEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.municipios.listado", entidad);
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<MunicipioEO> modelo(String idEntidad){
		Modelo<MunicipioEO> modelo;
		List<MunicipioEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.municipios.listadoLlave", Integer.parseInt(idEntidad));
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public MunicipiosT tabla(EntidadEO entidad){
		MunicipiosT tabla;
		List<MunicipioEO> listado;
		logger.debug("Entidad recibidad: {}", entidad);
		
		tabla = new MunicipiosT();
		
		listado = sqlSession.selectList("catalogos.municipios.listado", entidad);
		tabla.setListado(listado);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de Municipios: {}", listado);
		
		return tabla;
	}
	
	public MunicipiosT tabla(List<EntidadEO> entidades){
		MunicipiosT tabla;
		List<MunicipioEO> listado;
		
		logger.debug("Entidades recibidadas: {}", entidades);
		
		tabla = new MunicipiosT();
		
		if(entidades == null || entidades.isEmpty())
			listado = new ArrayList<MunicipioEO>();
		else
			listado = sqlSession.selectList("catalogos.municipios.listadoPorEntidades", entidades);
		
		tabla.setListado(listado);
		if(!listado.isEmpty()){
			tabla.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de Municipios: {}", listado);
		
		return tabla;
	}
	
	public Modelo<MunicipioEO> modelo(List<EntidadEO> entidades){
		Modelo<MunicipioEO> modelo;
		List<MunicipioEO> listado;
		
		logger.debug("Entidades recibidadas: {}", entidades);
		
		modelo = new Modelo<MunicipioEO>();
		
		if(entidades == null || entidades.isEmpty())
			listado = new ArrayList<MunicipioEO>();
		else
			listado = sqlSession.selectList("catalogos.municipios.listadoPorEntidades", entidades);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Se obtiene listado de Municipios: {}", listado);
		
		return modelo;
	}
	
	public MunicipioEO buscarPorLlave(String llave){
		MunicipioEO municipio;
		
		municipio = sqlSession.selectOne("catalogos.municipios.porLlave", llave);
		
		return municipio;
	}
	

	private UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

	public Modelo<MunicipioEO> modeloPorUsuario(String idEntidad){
		List<MunicipioEO> listado=new ArrayList<>();
		switch (getUsuario().getNivel()) {
			case MUNICIPIO:
				for (JavaBeanT municipioEO : getUsuario().getTerritorios()) {
					listado.add((MunicipioEO)municipioEO);
				}
			break;
			default:
				listado = sqlSession.selectList("catalogos.municipios.listadoLlave", Integer.parseInt(idEntidad));
			break;
		}
		logger.debug("Listado : {}",listado);
		return new Modelo<>(listado);
	}
	
	public Modelo<MunicipioEO> modeloConRegion(GeozonaParticionEO region){
		List<MunicipioEO> listado = new ArrayList<>();
		switch (getUsuario().getNivel()) {
			case MUNICIPIO:
				HashMap<String, Object> mapa= new HashMap<>();
				mapa.put("municipios", getUsuario().getTerritorios());
				mapa.put("region", region);
				listado= sqlSession.selectList("catalogos.municipios.listadoMunicipioRegion2", mapa);
			break;
			default:
				listado= sqlSession.selectList("catalogos.municipios.listadoMunicipioRegion", region);
			break;
		}
		return new Modelo<>(listado);
	}
	
	
	public MunicipioEO buscarPorLlaveMpio(String llave){
		MunicipioEO municipio;		
		municipio = sqlSession.selectOne("catalogos.municipios.buscarPorLlave", llave);		
		return municipio;
	}
	
	
}
