package com.saganet.politik.components.catalogos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.DLocalEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.GeozonaEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.modelos.catalogos.DFederalesT;
import com.saganet.politik.modelos.catalogos.DLocalesT;
import com.saganet.politik.modelos.catalogos.EntidadesT;
import com.saganet.politik.modelos.catalogos.MunicipiosT;

@Component("CatalogosGeozonasC")
public class GeozonasC {
	private static final Logger logger = LoggerFactory.getLogger(GeozonasC.class);

	@Autowired
	SqlSession sqlSession;

	private UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	

	public Modelo<GeozonaParticionEO> modeloRegionesEdoMex() {
		HashMap<String, Object> mapa = new HashMap<>();
		mapa.put("region", getUsuario().getTerritorios());
		logger.debug("Debe traer Territorio del Usuario: {}", getUsuario().getTerritorios());
		
		switch (getUsuario().getNivel()) {
			case GEOZONA:
				List<GeozonaParticionEO>  listado= sqlSession.selectList("catalogos.geozonas.listadoParticionesPorUsuario",getUsuario());
				logger.debug("ENTRO TERRITORIO {}", getUsuario().getTerritorios());
				logger.debug("listado : {}",listado);
				return  new Modelo<>(listado);
		
			default:
				List<GeozonaParticionEO>  listado1= sqlSession.selectList("catalogos.geozonas.regionesEdoMex");	
				return  new Modelo<>(listado1);
		}
		
	}
	
	public Modelo<GeozonaParticionEO> modeloRegionesEdoMex(GeozonaParticionEO region) {
		logger.debug("Debe traer Territorio del Usuario:----->>>>> {}", getUsuario().getTerritorios());
		List<GeozonaParticionEO> listado= sqlSession.selectList("catalogos.geozonas.regionesEdoMex");
		Modelo<GeozonaParticionEO> modelo= new Modelo<>(listado);
		if (region!=null) {
			modelo.setSeleccionado(region);
		}
		logger.debug("listado : {}",listado);
		return modelo;
	}
	
	public Modelo<GeozonaEO> modelo() {
		Modelo<GeozonaEO> modelo;
		List<GeozonaEO> listado;

		modelo = new Modelo<>();

		listado = sqlSession.selectList("catalogos.geozonas.listado");

		// Llenar Territorios por Particion
		for (GeozonaEO geozona : listado) {
			cargarTerritorios(geozona);
		}

		modelo.setListado(listado);
		if (!listado.isEmpty()) {
			modelo.setSeleccionado(listado.get(0));
		}

		return modelo;
	}
	
	public void cargarTerritorios(GeozonaEO geozona){
		List<JavaBeanT> territorios;
		
		for (GeozonaParticionEO particion : geozona.getParticiones()) {
			territorios = new ArrayList<>();

			switch (geozona.getNivel()) {
			case DFEDERAL:
				// TODO territorios =
				// sqlSession.selectList("catalogos.dFederales.listadoPorGeozonaParticionLlave",
				// particion);
				break;
			case DLOCAL:
				// TODO territorios =
				// sqlSession.selectList("catalogos.dLocales.listadoPorGeozonaParticionLlave",
				// particion);
				break;
			case ENTIDAD:
				territorios = sqlSession.selectList("catalogos.entidades.listadoPorGeozonaParticionLlave",
						particion);
				break;
			case MUNICIPIO:
				territorios = sqlSession.selectList("catalogos.municipios.listadoPorGeozonaParticionLlave",
						particion);
				break;
			default:
				break;
			}

			particion.setTerritorios(territorios);
		}
	}
	
			
	
	public void cargarTerritoriosParticion(GeozonaParticionEO particion){
		GeozonaEO geozona;
		List<JavaBeanT> territorios;
		
		geozona = sqlSession.selectOne("catalogos.geozonas.geozonaPorParticion", particion);
		
		territorios = new ArrayList<>();

		switch (geozona.getNivel()) {
		case DFEDERAL:
			// TODO territorios =
			// sqlSession.selectList("catalogos.dFederales.listadoPorGeozonaParticionLlave",
			// particion);
			break;
		case DLOCAL:
			// TODO territorios =
			// sqlSession.selectList("catalogos.dLocales.listadoPorGeozonaParticionLlave",
			// particion);
			break;
		case ENTIDAD:
			territorios = sqlSession.selectList("catalogos.entidades.listadoPorGeozonaParticionLlave", particion);
			break;
		case MUNICIPIO:
			territorios = sqlSession.selectList("catalogos.municipios.listadoPorGeozonaParticionLlave", particion);
			break;
		default:
			break;
		}

		particion.setTerritorios(territorios);
	}

	public Modelo<GeozonaEO> modeloSinTerritorios() {
		Modelo<GeozonaEO> modelo;
		List<GeozonaEO> listado;

		modelo = new Modelo<>();

		listado = sqlSession.selectList("catalogos.geozonas.listado");

		modelo.setListado(listado);
		if (!listado.isEmpty()) {
			modelo.setSeleccionado(listado.get(0));
		}

		return modelo;
	}

	public GeozonaEO nuevo() {
		GeozonaEO geozona;

		geozona = new GeozonaEO();

		return geozona;
	}

	public List<JavaBeanT> listadoTerritorios(RequestContext context) {
		HashMap<String, Object> viewScope, flowScope;
		GeozonaEO geozona;
		EntidadesT listadoEntidades;
		DFederalesT listadoDFederales;
		DLocalesT listadoDLocales;
		MunicipiosT listadoMunicipios;
		List<EntidadEO> entidades;
		List<DFederalEO> dFederales;
		List<DLocalEO> dLocales;
		List<MunicipioEO> municipios;
		List<JavaBeanT> territorios;

		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		flowScope = (HashMap<String, Object>) context.getFlowScope().asMap();

		geozona = (GeozonaEO) flowScope.get("geozona");

		listadoEntidades = (EntidadesT) viewScope.get("listadoEntidades");
		entidades = listadoEntidades.getSeleccionMultiple();

		listadoDFederales = (DFederalesT) viewScope.get("listadoDFederales");
		dFederales = listadoDFederales.getSeleccionMultiple();

		listadoDLocales = (DLocalesT) viewScope.get("listadoDLocales");
		dLocales = listadoDLocales.getSeleccionMultiple();

		listadoMunicipios = (MunicipiosT) viewScope.get("listadoMunicipios");
		municipios = listadoMunicipios.getSeleccionMultiple();

		territorios = new ArrayList<JavaBeanT>();

		switch (geozona.getNivel()) {
		case DFEDERAL:
			for (DFederalEO fila : dFederales) {
				territorios.add(fila);
			}
			break;
		case DLOCAL:
			for (DLocalEO fila : dLocales) {
				territorios.add(fila);
			}
			break;
		case ENTIDAD:
			for (EntidadEO fila : entidades) {
				territorios.add(fila);
			}
			break;
		case MUNICIPIO:
			for (MunicipioEO fila : municipios) {
				territorios.add(fila);
			}
			break;
		default:
			break;
		}

		return territorios;
	}

	public Modelo<GeozonaParticionEO> modeloParticiones(GeozonaEO geozona) {
		Modelo<GeozonaParticionEO> modelo;

		modelo = new Modelo<>();

		modelo.setListado(geozona.getParticiones());
		if (!geozona.getParticiones().isEmpty()) {
			modelo.setSeleccionado(geozona.getParticiones().get(0));
		}

		return modelo;
	}

	public Modelo<JavaBeanT> modeloTerritorios(List<JavaBeanT> territorios, List<GeozonaParticionEO> particiones) {
		Modelo<JavaBeanT> modelo;
		DualListModel<JavaBeanT> modeloDual;

		modelo = new Modelo<>();

		for (GeozonaParticionEO p : particiones) {
			for (JavaBeanT t : p.getTerritorios()) {
				territorios.remove(t);
			}
		}

		modeloDual = new DualListModel<>(territorios, new ArrayList<JavaBeanT>());
		modelo.setModeloDual(modeloDual);

		return modelo;
	}

	public GeozonaParticionEO nuevaParticion(GeozonaEO geozona) {
		GeozonaParticionEO particion;
		int particiones;

		particion = new GeozonaParticionEO();

		particiones = geozona.getParticiones().size();
		particiones++;
		particion.setId(particiones);
		particion.setIdParticion(particiones);

		return particion;
	}

	public void agregarParticion(GeozonaEO geozona, GeozonaParticionEO particion, List<JavaBeanT> territorios) {
		if (!territorios.isEmpty()) {
			for (JavaBeanT t : territorios) {
				particion.getTerritorios().add(t);
			}
			geozona.getParticiones().add(particion);
		}
		logger.debug("Se Agrega Particion a Geozona: {}", geozona);
	}

	public String guardar(GeozonaEO geozona, List<JavaBeanT> territorios) {
		HashMap<String, Object> parametros;
		MessageContext messageContext;

		messageContext = RequestContextHolder.getRequestContext().getMessageContext();

		if (!territorios.isEmpty()) {
			messageContext
					.addMessage(new MessageBuilder().error().defaultText("Existen Territorios disponibles").build());
			return "error";
		}

		parametros = new HashMap<>();

		sqlSession.insert("catalogos.geozonas.insertarGeozona", geozona);

		parametros.put("geozona", geozona);

		for (GeozonaParticionEO particion : geozona.getParticiones()) {
			parametros.put("particion", particion);
			sqlSession.insert("catalogos.geozonas.insertarGeozonaParticion", parametros);
			parametros.put("territorios", particion.getTerritorios());
			sqlSession.insert("catalogos.geozonas.insertarGeozonaParticionLlaves", parametros);
		}

		return "success";
	}

	public GeozonaEO obtenerGeozona(Integer id) {
		GeozonaEO geozona;
		List<JavaBeanT> territorios;

		geozona = sqlSession.selectOne("catalogos.geozonas.porId", id);

		for (GeozonaParticionEO particion : geozona.getParticiones()) {
			territorios = new ArrayList<>();

			switch (geozona.getNivel()) {
			case DFEDERAL:
				// TODO territorios =
				// sqlSession.selectList("catalogos.dFederales.listadoPorGeozonaParticionLlave",
				// particion);
				break;
			case DLOCAL:
				// TODO territorios =
				// sqlSession.selectList("catalogos.dLocales.listadoPorGeozonaParticionLlave",
				// particion);
				break;
			case ENTIDAD:
				territorios = sqlSession.selectList("catalogos.entidades.listadoPorGeozonaParticionLlave", particion);
				break;
			case MUNICIPIO:
				territorios = sqlSession.selectList("catalogos.municipios.listadoPorGeozonaParticionLlave", particion);
				break;
			default:
				break;
			}

			particion.setTerritorios(territorios);
		}

		return geozona;
	}
	
	public Modelo<GeozonaParticionEO> modeloGeozonaParticiones(GeozonaEO geozona){
		Modelo<GeozonaParticionEO> modelo;
		modelo = new Modelo<>();
		modelo.setListado(geozona.getParticiones());
		
		return modelo;
	}
	
	public Modelo<GeozonaParticionEO> modeloGeozonaParticionesSinTerritorios(GeozonaEO geozona){
		Modelo<GeozonaParticionEO> modelo;
		modelo = new Modelo<>();
		
		for(GeozonaParticionEO particion : geozona.getParticiones()){
			particion.setTerritorios(null);
		}
		
		modelo.setListado(geozona.getParticiones());
		
		return modelo;
	}
	
	public GeozonaParticionEO buscarParticionPorLlave(String llave){
		GeozonaParticionEO particion;
		
		particion = sqlSession.selectOne("catalogos.geozonas.particionPorLlave", llave);
		
		return particion;
	}
	  
	
	public Modelo<GeozonaParticionEO> cargaRegionConIdMunicipio() {
		List<GeozonaParticionEO> listado= sqlSession.selectList("catalogos.geozonas.traeRegionConIdMunicipio");
		logger.debug("listado : {}",listado);
		return  new Modelo<>(listado);
	}
	
	
	public Modelo<GeozonaParticionEO> regionesPorUsuario(){
		logger.debug("Debe traer Territorio del Usuario:----->>>>> {}", getUsuario().getTerritorios());
		List<GeozonaParticionEO> listado = new ArrayList<>();
		switch (getUsuario().getNivel()) {
			case MUNICIPIO:
				listado= sqlSession.selectList("catalogos.geozonas.regionesEdoMexMunicipios", getUsuario().getTerritorios()); 
			break;
			default:
				listado= sqlSession.selectList("catalogos.geozonas.regionesEdoMex");
			break;
		}
		return new Modelo<GeozonaParticionEO>(listado);
	}
		
	
	
}
