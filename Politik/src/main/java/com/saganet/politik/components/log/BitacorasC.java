package com.saganet.politik.components.log;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.saganet.politik.database.log.BitacoraEO;
import com.saganet.politik.dominios.TiposAccionesDO;
import com.saganet.politik.modelos.Modelo;

@Component("BitacorasC")
public class BitacorasC {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(BitacorasC.class);
	
	public Modelo<BitacoraEO> modelo(){
		
		Modelo<BitacoraEO> modelo;
		List<BitacoraEO> listado;
		
		listado = sqlSession.selectList("log.bitacoras.listado");
		logger.debug("Listado Bitacoras: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo Bitacoras: {}", modelo);
		
		return modelo;
		
	}
	
	public Modelo<BitacoraEO> modeloNick(List<UsuarioEO> usuarios){
		
		logger.debug("Usuarios Recibidos: {}", usuarios);
		
		Modelo<BitacoraEO> modelo;
		List<BitacoraEO> listado;
		HashMap<String, Object> params;
		params = new HashMap<>();
		params.put("usuarios", usuarios);
		
		listado = sqlSession.selectList("log.bitacoras.listadoPorNick", params);
		logger.debug("Listado Bitacoras Por Nick: {}", listado);
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		logger.debug("Modelo Bitacoras Por Nick: {}", modelo);
		
		return modelo;
		
	}
	
	public Modelo<BitacoraEO> modeloGenerico(){
		Modelo<BitacoraEO> modelo;
		modelo = new Modelo<>();
		return modelo;
	}
	
	public BitacoraEO nuevo(){
		BitacoraEO nuevo = new BitacoraEO();
		nuevo.setNick(getUsuario().getNick());
		return nuevo;
	}
	
	public void insert(TiposAccionesDO tipoAccion, String involucrado, String descripcion, String nick){
		BitacoraEO nuevo;
		nuevo = new BitacoraEO();
		nuevo.setTipoAccion(tipoAccion.getNombre());
		nuevo.setInvolucrado(involucrado);
		nuevo.setDescripcion(descripcion);
		nuevo.setNick(nick);
		logger.debug("Bitacora recibida: {}", nuevo);
		sqlSession.insert("log.bitacoras.insertar", nuevo);
		logger.debug("Se ha guardado correctamente la bitacora");
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
	public TiposAccionesDO[] tiposAcciones(){
		logger.debug("Se genera listado de tipos de acciones para las bitacoras");
		return TiposAccionesDO.values();
	}
	
	
@SuppressWarnings("deprecation")
public List<HashMap<String, Object>> listadoConcentrado(String nick, Date fechaInicio, Date fechaFin){
	
	logger.debug("Fecha Inicio: {}", fechaInicio);
	logger.debug("Fecha Fin: {}", fechaFin);
	
	List<HashMap<String, Object>> listado;
	
	String fechaInicioF;
	String fechaFinF;
	
	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	if(fechaInicio.getDate()==fechaFin.getDate()){
		fechaInicioF = formatter.format(fechaInicio);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaFin);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		fechaFin = calendar.getTime();
		fechaFinF = formatter.format(fechaFin);
	}else{
		fechaInicioF = formatter.format(fechaInicio);
		fechaFinF = formatter.format(fechaFin);
	}
	
	HashMap<String, Object> params;
	params = new HashMap<>();
	params.put("nick", nick);
	params.put("fechaInicio", fechaInicioF);
	params.put("fechaFin", fechaFinF);
	
	listado = new ArrayList<>();
	
	listado = sqlSession.selectList("log.bitacoras.concentrado", params);
	
	
	logger.debug("Listado Concentrado: {}", listado);
	logger.debug("Parametro recibido");
	
   return listado;
	
}
	
}
