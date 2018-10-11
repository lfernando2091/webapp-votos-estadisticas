package com.saganet.politik.components.catalogos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.components.log.BitacorasC;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.DLocalEO;
import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.NivelesDependenciasDO;
import com.saganet.politik.dominios.TiposAccionesDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.GeozonaEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;

@Component("DependenciasC")
public class DependenciasC {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	BitacorasC bitacorasC;
	
	private static final Logger logger = LoggerFactory.getLogger(DependenciasC.class);

	public Modelo<DependenciaEO> modelo(){
		Modelo<DependenciaEO> modelo;
		List<DependenciaEO> listado;
		
		listado = new ArrayList<>();
		
		listado = sqlSession.selectList("catalogos.dependencias.listado");
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			logger.debug("ListadoDependecias: {}", listado);
			modelo.setSeleccionado(listado.get(0));
			modelo.getSeleccionado().setTerritorios(consultaTerritorios(modelo.getSeleccionado()));
		}
		
		logger.debug("ModeloDependecias: {}", modelo);
		
		return modelo;
	}
	
	public Modelo<DependenciaEO> modeloByUsuario(){
		Modelo<DependenciaEO> modelo;
		List<DependenciaEO> listado;
		
		listado = new ArrayList<>();
		
		HashMap<String, Object> params;
		params = new HashMap<>();
		
		if(!getUsuario().getDependencias().isEmpty()){
			params.put("dependencias", getUsuario().getDependencias());
			listado = sqlSession.selectList("catalogos.dependencias.listadoUsuarioDependencias",params);
		}else{
			listado = sqlSession.selectList("catalogos.dependencias.listado");
		}
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			logger.debug("ListadoDependecias: {}", listado);
			modelo.setSeleccionado(listado.get(0));
			modelo.getSeleccionado().setTerritorios(consultaTerritorios(modelo.getSeleccionado()));
		}else{
			modelo.setSeleccionado(new DependenciaEO());
			modelo.getSeleccionado().setTerritorios(new ArrayList<JavaBeanT>());
		}
		
		logger.debug("ModeloDependecias: {}", modelo);
		
		return modelo;
	}
	
	public DependenciaEO getDependenciaCompleta(DependenciaEO dependencia){
		// Se_asignan_los_territorios_a_las_dependencias
		dependencia.setTerritorios(consultaTerritorios(dependencia));
		logger.debug("Dependencia - Territorios: {}", dependencia.getTerritorios());
		
		return dependencia;
	}
	
	public DependenciaEO nuevo(){
		return new DependenciaEO();
	}
	
	public DependenciaEO nuevoSubnivel(DependenciaEO dependencia){
		logger.debug("Dependencia recibida: {}", dependencia);
		DependenciaEO nuevo = new DependenciaEO();
		nuevo.setDependenciaPadre(dependencia);
		return nuevo;
	}
	
	public void guardar(DependenciaEO nuevaDependencia, List<JavaBeanT> seleccionMultiple){
		
		logger.debug("Nueva Dependencia recibida: {}", nuevaDependencia);
		
		//Asignamos_siguiente_pkey
		nuevaDependencia.setId((Integer) sqlSession.selectOne("catalogos.dependencias.idNextDependencia"));
		
		logger.debug("Nueva Secciones Recibida: {}", seleccionMultiple);
		
		nuevaDependencia.setNick(getUsuario().getNick());
		
		sqlSession.insert("catalogos.dependencias.insertar", nuevaDependencia);
		//Guardamos_insercion_de_nuevaDependencia_en_la_bitacora
		bitacorasC.insert(TiposAccionesDO.INSERTAR, "Dependencias", nuevaDependencia.getId()+" - "+nuevaDependencia.getNivelDependencia(), getUsuario().getNick());
		
		//Asignamos_Dependencia_al_usuario_loggeado
//		HashMap<String, Object> usuariosDependenciaParametros;
//		usuariosDependenciaParametros = new HashMap<>();
//		usuariosDependenciaParametros.put("nick", getUsuario().getNick());
//		usuariosDependenciaParametros.put("idDependencia", nuevaDependencia.getId());
//		
//		logger.debug("Se asigno correctamente la dependencia al usuario: {}", usuariosDependenciaParametros);
//		sqlSession.insert("administracion.usuarios.insertarDependenciaUsuario", usuariosDependenciaParametros);
//		bitacorasC.insert(TiposAccionesDO.INSERTAR, "Dependencias", "Se asigno Dependencia:"+nuevaDependencia.getId()+" - "+nuevaDependencia.getDependencia()+" a Usuario:"+getUsuario().getNick(), getUsuario().getNick());
		
		logger.debug("La Dependecia se guardo correctamente!: {}", nuevaDependencia);
//		logger.debug("Se asigno correctamente la dependencia al usuario: {}", usuariosDependenciaParametros);
		
		//Guardamos_las_llaves_de_la_dependencia(_Territorios)
		if(!seleccionMultiple.isEmpty()){
			//Insertamos_las_nueva_bateria_de_dependencias_de_la_seleccion_multiple
			for(JavaBeanT javaBeanT : seleccionMultiple){
				logger.debug("Objeto JavaBeanT: {}", javaBeanT);
				HashMap<String, Object> params;
				params = new HashMap<>();
				
				switch (nuevaDependencia.getNivelGeografico()) {
				case ENTIDAD:
					
					EntidadEO entidad;
					entidad = (EntidadEO) javaBeanT;
					params.put("idDependencia", nuevaDependencia.getId());
					params.put("llave", entidad.getId());
					params.put("nick", getUsuario().getNick());
					
					break;
					
				case DFEDERAL:
					
					DFederalEO dfederal;
					dfederal = (DFederalEO) javaBeanT;
					params.put("idDependencia", nuevaDependencia.getId());
					params.put("llave", dfederal.getLlave());
					params.put("nick", getUsuario().getNick());
					
					break;
					
				case DLOCAL:
					
					DLocalEO dlocal;
					dlocal = (DLocalEO) javaBeanT;
					params.put("idDependencia", nuevaDependencia.getId());
					params.put("llave", dlocal.getLlave());
					params.put("nick", getUsuario().getNick());
					
					break;
					
				case MUNICIPIO:
					logger.debug("Entro en municipio");
					MunicipioEO municipio;
					municipio = (MunicipioEO) javaBeanT;
					params.put("idDependencia", nuevaDependencia.getId());
					params.put("llave", municipio.getLlave());
					params.put("nick", getUsuario().getNick());
					
					break;
					
				case SECCION:
					logger.debug("Entro en seccion");
					SeccionEO seccion;
					seccion = (SeccionEO) javaBeanT;
					params.put("idDependencia", nuevaDependencia.getId());
					params.put("llave", seccion.getLlave());
					params.put("nick", getUsuario().getNick());
					
					logger.debug("Seccion a guardar: {}", seccion);
					
					break;
					
				case GEOZONA:
					logger.debug("Entro en Geozona");
					GeozonaParticionEO geozonaParticion;
					geozonaParticion = (GeozonaParticionEO) javaBeanT;
					params.put("idDependencia", nuevaDependencia.getId());
					params.put("llave", geozonaParticion.getLlave());
					params.put("nick", getUsuario().getNick());
					
					logger.debug("Geozona Partici�n a guardar: {}", geozonaParticion);
					
					break;

				default:
					break;
				}
				
				logger.debug("Parametros Insertar Llave: {}", params);
				
				if(!params.isEmpty())
				sqlSession.insert("catalogos.dependenciasLlaves.insertar", params);
				bitacorasC.insert(TiposAccionesDO.INSERTAR, "Dependencias", "Se inserto a nivel "+nuevaDependencia.getNivelGeografico()+" la Llave: "+params.get("llave"), getUsuario().getNick());
				
			}
		}
		
		
	}
	
	public void actualizar(DependenciaEO dependencia, List<T> seleccionMultiple){
		logger.debug("Dependencia Recibida: {}", dependencia);
		
		sqlSession.update("catalogos.dependencias.actualizar", dependencia);
		
		logger.debug("La dependencia fue actualizada correctamente!");
		
		//Actualizamos_dependencias_llaves,_si_no_esta_vacia
		
//		if(!seleccionMultiple.isEmpty()){
//			//Eliminamos_llaves_actuales_en_dependencias_llaves
//			sqlSession.delete("catalogos.dependenciasLlaves.eliminar", dependencia.getId());
//			logger.debug("Las llaves de la dependencia se eliminaron correctamente");
//			
//			//Insertamos_las_nueva_bateria_de_dependencias_de_la_seleccion_multiple
//			for(T t : seleccionMultiple){
//				
//			}
//		}
		
	}
	
	public NivelesDependenciasDO[] nivelesDependencias(){
		logger.debug("Se genera listado de Niveles Dependencias");
		return NivelesDependenciasDO.values();
	}
	
	public NivelesDO[] niveles(){
		logger.debug("Se genera listado de Niveles");
		NivelesDO[] niveles = new NivelesDO[6];
		niveles[0]=NivelesDO.NACIONAL;
		niveles[1]=NivelesDO.ENTIDAD;
		niveles[2]=NivelesDO.MUNICIPIO;
		niveles[3]=NivelesDO.DFEDERAL;
		niveles[4]=NivelesDO.DLOCAL;
		niveles[5]=NivelesDO.SECCION;
		niveles[5]=NivelesDO.GEOZONA;
		
		return niveles;
		
	}
	
	public List<JavaBeanT> consultaTerritorios(DependenciaEO dependencia){
		
		List<JavaBeanT> territorios;
		String llaves = "";
		
		territorios = new ArrayList<>();
		
		try{
			llaves = sqlSession.selectOne("catalogos.dependenciasLlaves.listadoStr", dependencia.getId());
		}catch(Exception e){
			logger.debug("No hay dependencias");
		}
		
		logger.debug("LLaves: {}", llaves);
		
		if(llaves!=null){
			switch (dependencia.getNivelGeografico()) {
			
			case ENTIDAD:
				territorios = sqlSession.selectList("catalogos.entidades.entidadInId",llaves);
				logger.debug("Listado Territorios: {}", territorios);
				return territorios;
			case DFEDERAL:
				territorios = sqlSession.selectList("catalogos.dFederales.dfederalInLlaves", llaves);
				logger.debug("Listado Territorios: {}", territorios);
				return territorios;
			case DLOCAL:
				territorios = sqlSession.selectList("catalogos.dLocales.dlocalInLlaves", llaves);
				logger.debug("Listado Territorios: {}", territorios);
				return territorios;
			case MUNICIPIO:
				territorios = sqlSession.selectList("catalogos.municipios.municipioInLlaves", llaves);
				logger.debug("Listado Territorios: {}", territorios);
				return territorios;
			case SECCION:
				territorios = sqlSession.selectList("catalogos.secciones.seccionInLlaves", llaves);
				logger.debug("Listado Territorios: {}", territorios);
				return territorios;
			case GEOZONA:
				//territorios = sqlSession.selectList("catalogos.secciones.seccionInLlaves", llaves);
				GeozonaEO geozona;
				geozona = sqlSession.selectOne("catalogos.geozonas.listadoByLlavesParticionesStr", llaves);
				logger.debug("GeozonaEO: {}", geozona);
				List<GeozonaParticionEO> territorios2 = geozona.getParticiones();
				for (GeozonaParticionEO geozonaParticionEO : territorios2) {
					List<JavaBeanT> listJavaBeanT;
					listJavaBeanT = new ArrayList<>();
					switch (geozona.getNivel()) {
					case ENTIDAD:
						listJavaBeanT = sqlSession.selectList("catalogos.entidades.listadoPorGeozonaParticionesLlave",geozonaParticionEO.getId());
						break;
					case MUNICIPIO:
						listJavaBeanT = sqlSession.selectList("catalogos.municipios.listadoPorGeozonaParticionesLlave",geozonaParticionEO.getId());
						break;
					default:
						break;
					}
					logger.debug("Listado de territorios de la particion {} es: {}",geozonaParticionEO,listJavaBeanT );
					geozonaParticionEO.setTerritorios(listJavaBeanT);
					territorios.add(geozonaParticionEO);
				}
				logger.debug("Listado Territorios: {}", territorios);
				return territorios;
			default:
				logger.debug("Listado Territorios: {}", territorios);
				return territorios;
			}
		}else{
			logger.debug("Listado Territorios: {}", territorios);
			return territorios;
		}
		
		
	}
	
	public Modelo<JavaBeanT> nuevoModelo(){
		Modelo<JavaBeanT> modelo;
		modelo = new Modelo<>();
		return modelo;
	}
	
	public Modelo<JavaBeanT> getModeloTerritorios(DependenciaEO dependencia){
		Modelo<JavaBeanT> modelo;
		modelo = new Modelo<>();
		
		//Consultamos_los_territorios
		dependencia.setTerritorios(consultaTerritorios(dependencia));
		//Lo_Pasamos_al_nuevo_modelo
		modelo.setListado(dependencia.getTerritorios());
		
		if(!dependencia.getTerritorios().isEmpty()){
			modelo.setSeleccionado(dependencia.getTerritorios().get(0));
			modelo.setSeleccionMultiple(modelo.getListado());
		}
		
		return modelo;
	}
	
	public void inhabilitarDependencia(DependenciaEO dependencia){
		logger.debug("Dependencia recibida para hinabiltar: {}", dependencia);
		HashMap<String, Object> params;
		params = new HashMap<>();
		params.put("idDependencia", dependencia.getId());
		params.put("estatus", 0);
		Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		params.put("nickActualizacion", usuario.getUsuario().getNick());
		
		sqlSession.update("catalogos.dependencias.estatusDependenciaChange", params);
		
		bitacorasC.insert(TiposAccionesDO.ELIMINAR, "Dependencias", "Se elimino la Dependencia: "+dependencia.getId()+" - "+dependencia.getDependencia(), getUsuario().getNick());
		
		logger.debug("Se actualizaron los siguientes parametros: {}", params);
	}
	
	public void quitarDependenciaDeModelo(Modelo<DependenciaEO> modelo, DependenciaEO dependencia){
		if (!modelo.getListado().isEmpty()) {
			modelo.getListado().remove(dependencia);
			if (!modelo.getListado().isEmpty()) {
				modelo.setSeleccionado(modelo.getListado().get(0));
			} else {
				modelo.setSeleccionado(null);
			}
		}
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
	public Modelo<DependenciaEO> modeloAdmin(){
		Modelo<DependenciaEO> modelo;
		List<DependenciaEO> listado;
		
		listado = new ArrayList<>();
		
		listado = sqlSession.selectList("catalogos.dependencias.listado");
		
		modelo = new Modelo<>();
		modelo.setListado(listado);
		
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<JavaBeanT> getModeloGenerico(List<JavaBeanT> listado){
		Modelo<JavaBeanT> modelo;
		modelo = new Modelo<>();
		if (listado==null) {
			listado= new ArrayList<>();
		}
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}else{
			modelo.setSeleccionado(null);
		}
		return modelo;
	}
	
	public Modelo<JavaBeanT> getModeloTerritoriosGeozona(JavaBeanT jbe){
		Modelo<JavaBeanT> modelo;
		modelo = new Modelo<>();
		if(jbe != null){
			if(jbe.getClass().getSimpleName().equals("GeozonaParticionEO")){
				GeozonaParticionEO particion = (GeozonaParticionEO) jbe;
				modelo.setListado(particion.getTerritorios());
				if(!particion.getTerritorios().isEmpty()){
					modelo.setSeleccionado(particion.getTerritorios().get(0));
				}
			}
		}
		
		return modelo;
		
	}
	
}