package com.saganet.politik.components.catalogos;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.modelos.catalogos.EntidadesT;

@Component("CatalogosEntidadesC")
public class EntidadesC {
	
	//private static final Logger logger = LoggerFactory.getLogger(EntidadesC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public Modelo<EntidadEO> modelo(){
		Modelo<EntidadEO> modelo;
		List<EntidadEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.entidades.listadoSimple", getUsuario());
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		modelo.setListado(listado);
		
		return modelo;
	}
	
	public Modelo<EntidadEO> modeloEdomex(){
		Modelo<EntidadEO> modelo;
		List<EntidadEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.entidades.entidadById",15);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		modelo.setListado(listado);
		
		return modelo;
	}
	public Modelo<EntidadEO> modeloAdmin(){
		Modelo<EntidadEO> modelo;
		List<EntidadEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.entidades.listadoSimple");
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		modelo.setListado(listado);
		
		return modelo;
	}
	
	public EntidadesT tabla(){
		EntidadesT tabla;
		List<EntidadEO> listado;
		
		tabla = new EntidadesT();
		
		listado = sqlSession.selectList("catalogos.entidades.listadoSimple", getUsuario());
		if(!listado.isEmpty())
			tabla.setSeleccionado(listado.get(0));
		tabla.setListado(listado);
		
		return tabla;
	}
	
	public Modelo<EntidadEO> modeloCompleto(){
		Modelo<EntidadEO> modelo;
		List<EntidadEO> listado;
		
		modelo = new Modelo<>();
		
		listado = sqlSession.selectList("catalogos.entidades.listado", getUsuario());
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		modelo.setListado(listado);
		
		return modelo;
	}
	
	public EntidadesT tablaBuscador(){
		EntidadesT tabla;
		List<EntidadEO> listado;
		
		tabla = new EntidadesT();
		
		listado = sqlSession.selectList("catalogos.entidades.listadoBuscador", getUsuario());
		if(!listado.isEmpty())
			tabla.setSeleccionado(listado.get(0));
		tabla.setListado(listado);
		
		return tabla;
	}
	
	public EntidadesT tablaBuscadorSimple(){
		EntidadesT tabla;
		List<EntidadEO> listado;
		
		tabla = new EntidadesT();
		
		listado = sqlSession.selectList("catalogos.entidades.listadoSimple", getUsuario());
		if(!listado.isEmpty())
			tabla.setSeleccionado(listado.get(0));
		tabla.setListado(listado);
		
		return tabla;
	}
	
	public EntidadEO buscarPorId(Integer idEntidad){
		EntidadEO entidad;
		
		entidad = sqlSession.selectOne("catalogos.entidades.entidadById", idEntidad);
		
		return entidad;
	}
	
	public EntidadEO buscarPorLlave(String llave){
		Integer idEntidad;
		
		idEntidad = Integer.valueOf(llave);
		
		return buscarPorId(idEntidad);
	}
	
	private UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
	public EntidadEO porCoordenadas(String[] coordenadas){
		EntidadEO entidad;
		HashMap<String, Object> parametros;
		
		parametros = new HashMap<>();
		
		parametros.put("longitud", coordenadas[0]);
		parametros.put("latitud", coordenadas[1]);
		
		entidad = sqlSession.selectOne("catalogos.entidades.porCoordenadas", parametros);
		
		return entidad;
	}
}
