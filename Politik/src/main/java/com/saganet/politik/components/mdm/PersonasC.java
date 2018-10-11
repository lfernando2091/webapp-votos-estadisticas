package com.saganet.politik.components.mdm;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.mdm.FotoB;
import com.saganet.politik.components.catalogos.DFederalesC;
import com.saganet.politik.components.catalogos.DLocalesC;
import com.saganet.politik.components.catalogos.EntidadesC;
import com.saganet.politik.components.catalogos.GeozonasC;
import com.saganet.politik.components.catalogos.MunicipiosC;
import com.saganet.politik.components.catalogos.SeccionesC;
import com.saganet.politik.components.estructuras.CapturaC;
import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.catalogos.EleccionEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.TipoClaveEO;
import com.saganet.politik.database.estructuras.CapturaEO;
import com.saganet.politik.database.estructuras.EstructuraEO;
import com.saganet.politik.database.estructuras.NodoEO;
import com.saganet.politik.database.mdm.PersonaClaveEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.database.mdm.TablaPersonaEO;
import com.saganet.politik.database.warehouse.EmailEO;
import com.saganet.politik.database.warehouse.RedSocialEO;
import com.saganet.politik.database.warehouse.TelefonoEO;
import com.saganet.politik.dominios.CargosDependenciaDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.utilidades.Diccionarios;

@Component("MDMPersonasC")
public class PersonasC {
	private static final Logger logger = LoggerFactory.getLogger(PersonasC.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired ServletContext servletContext;
	
	@Autowired EntidadesC entidadesC;
	@Autowired DFederalesC dFederalesC;
	@Autowired DLocalesC dLocalesC;
	@Autowired MunicipiosC municipiosC;
	@Autowired SeccionesC seccionesC;
	@Autowired GeozonasC geozonasC;
	@Autowired CapturaC capturaC;
	
	public Modelo<PersonaEO> modeloPorClave(EntidadEO entidad, TipoClaveEO tipoClave, String clave){
		Modelo<PersonaEO> modelo;
		HashMap<String, Object> parametros;
		List<PersonaEO> listado;
		
		modelo = new Modelo<PersonaEO>();
		parametros = new HashMap<String, Object>();
		listado = new ArrayList<PersonaEO>();
		
		switch(tipoClave.getId()){
		case 0: //idPersona
			parametros.put("idEntidad", entidad.getId());
			parametros.put("idPersona", Integer.parseInt(clave));
			listado = sqlSession.selectList("mdm.personas.buscarPorIdReg", parametros);
			break;
		case 1: //INE
			parametros.put("idEntidad", entidad.getId());
			parametros.put("idTipoClave", tipoClave.getId());
			parametros.put("clave", clave);
			listado = sqlSession.selectList("mdm.personas.buscarPorClaveReg", parametros);
			break;
		}
		
		logger.debug("Se obtiene listado de Personas: {}", listado);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<PersonaEO> modeloPorIdPersona(EntidadEO entidadNacimiento, Integer idPersona){
		Modelo<PersonaEO> modelo;
		HashMap<String, Object> parametros;
		List<PersonaEO> listado;
		
		modelo = new Modelo<PersonaEO>();
		parametros = new HashMap<String, Object>();
		listado = new ArrayList<PersonaEO>();
		parametros.put("idEntidad", entidadNacimiento.getId());
		parametros.put("idPersona", idPersona);
		
		listado = sqlSession.selectList("mdm.personas.buscarPorIdNac", parametros);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<PersonaEO> modeloPorDatos(EntidadEO entidad, PersonaEO persona){
		Modelo<PersonaEO> modelo;
		List<PersonaEO> listado;
		HashMap<String, Object> parametros;
		
		modelo = new Modelo<PersonaEO>();
		parametros = new HashMap<String, Object>();
		
		persona.setNombre(persona.getNombre() != null ? persona.getNombre().toUpperCase() : null);
		persona.setPrimerApellido(persona.getPrimerApellido() != null ? persona.getPrimerApellido().toUpperCase() : null);
		persona.setSegundoApellido(persona.getSegundoApellido() != null ? persona.getSegundoApellido().toUpperCase() : null);
		
		parametros.put("idEntidad", entidad.getId());
		parametros.put("persona", persona);
		
		listado = sqlSession.selectList("mdm.personas.buscarPorDatosReg", parametros);
		
		logger.debug("Se obtiene listado de Personas: {}", listado);
		
		modelo.setListado(listado);
		if(!listado.isEmpty()){
			modelo.setSeleccionado(listado.get(0));
		}
		
		return modelo;
	}
	
	public Modelo<PersonaEO> modeloVacio(){
		Modelo<PersonaEO> modelo;
		List<PersonaEO> listado;
		
		modelo = new Modelo<PersonaEO>();
		listado = new ArrayList<PersonaEO>();
		modelo.setListado(listado);
		
		return modelo;
	}
	
	public PersonaEO personaVacia(){
		PersonaEO persona;
		
		persona = new PersonaEO();
		
		return persona;
	}
	
	public void completarPersona(PersonaEO persona){
		//try {
		List<PersonaClaveEO> claves;
		List<TablaPersonaEO> tablas, tablasEstructuras, eliminar;
		List<TelefonoEO> telefonos;
		List<EmailEO> eMails;
		List<RedSocialEO> redesSociales;
		EstructuraEO estructura;
		NodoEO nodo;
		JavaBeanT territorio;
		CapturaEO captura;
		
		HashMap<String, Object> datos;
		tablasEstructuras = new ArrayList<>();
		eliminar = new ArrayList<>();
		
		claves = sqlSession.selectList("mdm.clavesPersonas.buscarPorPersona", persona);
		tablas = sqlSession.selectList("mdm.tablasPersonas.buscarPorPersona", persona);
		telefonos = sqlSession.selectList("warehouse.telefonos.buscarPorPersona", persona);
		eMails = sqlSession.selectList("warehouse.eMails.buscarPorPersona", persona);
		redesSociales = sqlSession.selectList("warehouse.redesSociales.buscarPorPersona", persona);
		
		persona.setClaves(claves);
		persona.setTelefonos(telefonos);
		persona.setEMails(eMails);
		persona.setRedesSociales(redesSociales);
		
		
		//Llenar Informacion de Tablas
		for(TablaPersonaEO tabla : tablas){
			datos = sqlSession.selectOne("mdm.tablasPersonas.datosPorTablaPersona", tabla);
			
			//Llenar Informacion de Estructuras
			estructura = sqlSession.selectOne("estructuras.estructuras.porTabla", tabla.getTabla());
			if(estructura != null){
				nodo = sqlSession.selectOne("estructuras.nodos.porId", datos.get("id_nodo"));
				
				captura = capturaC.recuperarCaptura(estructura, (Integer) datos.get("id_politik"));
				datos.put("captura", captura);
								
				switch(estructura.getAmbito()){
				case DEPENDENCIA:
					break;
				case DEPENDENCIAS:
					DependenciaEO dependencia;
					dependencia = sqlSession.selectOne("catalogos.dependencias.dependenciaById", datos.get("id_dependencia"));
					datos.put("dependencia", dependencia);
					datos.put("cargoEnum", CargosDependenciaDO.valueOf((String) datos.get("cargo")));
					break;
				case ELECCION:
					EleccionEO eleccion;
					eleccion = sqlSession.selectOne("catalogos.elecciones.porId", datos.get("id_eleccion"));
					territorio = null;
					switch(nodo.getFigura().getNivel()){
					case DFEDERAL:
						territorio = dFederalesC.buscarPorLlave((String) datos.get("llave"));
						break;
					case DLOCAL:
						territorio = dLocalesC.buscarPorLlave((String) datos.get("llave"));
						break;
					case ENTIDAD:
						territorio = entidadesC.buscarPorLlave((String) datos.get("llave"));
						break;
					case GEOZONA:
						territorio = geozonasC.buscarParticionPorLlave((String) datos.get("llave"));
						break;
					case LOCALIDAD:
						break;
					case MANZANA:
						break;
					case MUNICIPIO:
						territorio = municipiosC.buscarPorLlave((String) datos.get("llave"));
						break;
					case NACIONAL:
						break;
					case SECCION:
						territorio = seccionesC.buscarPorLlave((String) datos.get("llave"));
						break;
					case CASILLA:
						break;
					}
					datos.put("eleccion", eleccion);
					datos.put("nodo", nodo);
					datos.put("territorio", territorio);
					break;
				case GENERAL:
					territorio = null;
					switch(nodo.getFigura().getNivel()){
					case DFEDERAL:
						territorio = dFederalesC.buscarPorLlave((String) datos.get("llave"));
						break;
					case DLOCAL:
						territorio = dLocalesC.buscarPorLlave((String) datos.get("llave"));
						break;
					case ENTIDAD:
						territorio = entidadesC.buscarPorLlave((String) datos.get("llave"));
						break;
					case GEOZONA:
						territorio = geozonasC.buscarParticionPorLlave((String) datos.get("llave"));
						break;
					case LOCALIDAD:
						break;
					case MANZANA:
						break;
					case MUNICIPIO:
						territorio = municipiosC.buscarPorLlave((String) datos.get("llave"));
						break;
					case NACIONAL:
						break;
					case SECCION:
						territorio = seccionesC.buscarPorLlave((String) datos.get("llave"));
						break;
					case CASILLA:
						break;
					}
					datos.put("nodo", nodo);
					datos.put("territorio", territorio);
					break;
				}
				//Llenar Atributos
				
				
				datos.put("estructura", estructura);
				eliminar.add(tabla);
				tablasEstructuras.add(tabla);
			}
			
			//Agregar Datos
			tabla.setDatos(datos);
		}
		persona.setTablasEstructuras(tablasEstructuras);
		
		for(TablaPersonaEO tabla : eliminar){
			tablas.remove(tabla);
		}
		
		persona.setTablas(tablas);
		logger.debug("Se completa Persona: {}", persona);
		//} catch(Exception e){
			//e.printStackTrace();
		//}
	}
	
	public PersonaEO personaSimplePorId(Integer idPersona, Integer idEntidad){
		PersonaEO persona;
		HashMap<String, Object> parametros;
		
		parametros = new HashMap<>();
		
		parametros.put("idPersona", idPersona);
		parametros.put("idEntidad", idEntidad);
		persona = sqlSession.selectOne("mdm.personas.buscarPorIdNac", parametros);
		
		return persona;
	}
	
	public PersonaEO personaSimplePorId(String idPersona, String idEntidad){
		return personaSimplePorId(Integer.parseInt(idPersona), Integer.parseInt(idEntidad));		
	}
	
	public void insertarTablaPersona(TablaPersonaEO tablaPersona, PersonaEO persona){
		HashMap<String, Object> parametros;
		
		parametros = new HashMap<>();
		
		parametros.put("tablaPersona", tablaPersona);
		parametros.put("persona", persona);
		parametros.put("particion", Diccionarios.nombreEntidadTabla(persona.getEntidadNacimiento().getId()));
		
		sqlSession.insert("mdm.tablasPersonas.insertar", parametros);
	}
	
	public List<HashMap<String, Object>> desagruparTabla(Integer tipoTabla, PersonaEO persona){
		List<HashMap<String, Object>> datos;
		Integer idTabla;
		
		datos = new ArrayList<>();
		switch(tipoTabla){
		case 1: //Tabla General
			idTabla = persona.getModeloTablasAgrupado().getSeleccionado().getTabla().getId();
			for(TablaPersonaEO tabla : persona.getModeloTablas().getListado()){
				if(idTabla.equals(tabla.getTabla().getId())){
					datos.add(tabla.getDatos());
				}
			}
			break;
		case 2: //Tabla Estructuras
			idTabla = persona.getModeloTablasEstructurasAgrupado().getSeleccionado().getTabla().getId();
			for(TablaPersonaEO tabla : persona.getModeloTablasEstructuras().getListado()){
				if(idTabla.equals(tabla.getTabla().getId())){
					datos.add(tabla.getDatos());
				}
			}
			break;
		}
		
		logger.debug("Datos: {}", datos);
		return datos;
	}
	
	public void actualizarFoto(PersonaEO persona, FotoB fotoBean) throws IOException{
		byte[] foto, fotoResize;
		HashMap<String, Object> parametros;
		int cont, type;
		File archivoFoto, archivoFotoEscalada;
		FileOutputStream fos;
		FileInputStream fis;
		BufferedImage fotoOriginal, fotoEscalada;
		Graphics2D g;
		Dimension imgSize, boundary, tamanhoFinal;
		int ancho, alto;
		
		ancho = 200;
		alto = 200;
		
		parametros = new HashMap<>();
		
		foto = fotoBean.getArchivo();
		archivoFoto = new File(getPathBaseFotos() + fotoBean.getNombre());
		archivoFotoEscalada = new File(getPathBaseFotos() + fotoBean.getNombre() + "resize.png");
		fos = new FileOutputStream(archivoFoto);
		fos.write(foto);
		fos.close();
		
		fotoOriginal = ImageIO.read(archivoFoto);
		type = fotoOriginal.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : fotoOriginal.getType();
		
		imgSize = new Dimension(fotoOriginal.getWidth(), fotoOriginal.getHeight());
		boundary = new Dimension(ancho, alto);
		tamanhoFinal = getScaledDimension(imgSize, boundary);
		
		fotoEscalada = new BufferedImage(tamanhoFinal.width, tamanhoFinal.height, type);
		g = fotoEscalada.createGraphics();
		g.drawImage(fotoOriginal, 0, 0, tamanhoFinal.width, tamanhoFinal.height, null);
		g.dispose();
		//g.setComposite(AlphaComposite.Src);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		ImageIO.write(fotoEscalada, "png", archivoFotoEscalada);
		
		fis = new FileInputStream(archivoFoto);
		foto = new byte[fis.available()];
		fis.read(foto);
		fis.close();
		
		fis = new FileInputStream(archivoFotoEscalada);
		fotoResize = new byte[fis.available()];
		fis.read(fotoResize);
		fis.close();
		
		parametros.put("persona", persona);
		parametros.put("foto", foto);
		parametros.put("fotoEscalada", fotoResize);
		
		cont = sqlSession.update("warehouse.fotos.actualizar", parametros);
		if(cont == 0)
			sqlSession.insert("warehouse.fotos.insertar", parametros);
		
		archivoFoto.delete();
		archivoFotoEscalada.delete();
	}
	
	public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

	    int original_width = imgSize.width;
	    int original_height = imgSize.height;
	    int bound_width = boundary.width;
	    int bound_height = boundary.height;
	    int new_width = original_width;
	    int new_height = original_height;

	    // first check if we need to scale width
	    if (original_width > bound_width) {
	        //scale width to fit
	        new_width = bound_width;
	        //scale height to maintain aspect ratio
	        new_height = (new_width * original_height) / original_width;
	    }

	    // then check if we need to scale even with the new height
	    if (new_height > bound_height) {
	        //scale height to fit instead
	        new_height = bound_height;
	        //scale width to maintain aspect ratio
	        new_width = (new_height * original_width) / original_height;
	    }

	    return new Dimension(new_width, new_height);
	}
	
	public String getPathBaseFotos(){
		return servletContext.getRealPath("resources/tempFotos/");
	}
}
