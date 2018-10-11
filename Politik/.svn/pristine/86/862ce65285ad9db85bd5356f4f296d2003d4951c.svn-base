package com.saganet.politik.components.encuestas.edomex2017.respuestas;

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
import com.saganet.politik.database.catalogos.GeozonaEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;

@Component("Edomex2017EncuestasRespuestasC")
public class RespuestasC {

	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(RespuestasC.class);

	public HashMap<String, Object> modeloPregunta(HashMap<String, Object> fila, String pregunta, String programa) {
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> mapa, retorno;
		NivelesDO nivel;
		String filtroTerritorio;

		mapa = new HashMap<>();
		retorno = new HashMap<>();
		filtroTerritorio = "";
		mapa.put("pregunta", pregunta);
		mapa.put("programa", programa);
		switch (pregunta) {
		case "1":
			retorno.put("nombre_pregunta", "¿Sabía usted que habrá elecciones para gobernador el próximo 4 de junio?");
			break;
		case "2":
			retorno.put("nombre_pregunta",
					"¿Piensa usted ir a votar?");
			break;
		case "3":
			retorno.put("nombre_pregunta",
					"Independientemente de su afinidad partidista, si hoy fueran las elecciones para Gobernador, ¿Por cuál Partido votaría?");
			break;
		case "4":
			retorno.put("nombre_pregunta",
					"Independientemente de su afinidad partidista, si hoy fueran las elecciones para Gobernador, ¿Por cuál candidato votaría?");
			break;
		case "5":
			retorno.put("nombre_pregunta",
					"¿Le gustaría participar el día de la elección en su colonia?");
			break;

		}
		//buscar nivel y sus territorios
		nivel = getUsuario().getNivel();
		logger.debug("nivel: {}",nivel);
		//logger.debug("Territorios: {}",(GeozonaEO)getUsuario().getTerritorios());
		mapa.put("nivel", nivel.getNombre());
		switch (nivel) {
		case GEOZONA:
			logger.debug("Territorios: {} ", getUsuario().getTerritorios());
			List<GeozonaParticionEO> geozonaParticiones;
			geozonaParticiones =  new ArrayList<>();
			for (JavaBeanT geozona : getUsuario().getTerritorios()) {
				geozonaParticiones.add((GeozonaParticionEO)geozona);
			}
			mapa.put("territorios", geozonaParticiones);
			break;
		case MUNICIPIO:
			logger.debug("Territorios: {} ", getUsuario().getTerritorios());
			List<MunicipioEO> geozonaParticiones2;
			geozonaParticiones2 =  new ArrayList<>();
			for (JavaBeanT geozona : getUsuario().getTerritorios()) {
				geozonaParticiones2.add((MunicipioEO)geozona);
			}
			mapa.put("territorios", geozonaParticiones2);
			break;
		default:
			break;
					}
		mapa.put("filtroTerritorio", filtroTerritorio);
		//fin de la busqueda
		logger.debug("Valor Ingreso: {}", fila);logger.debug("Pregunta: {}", pregunta);logger.debug("PROGRAMA: {}", programa);
		if (fila == null) {
			mapa.put("tipo", "REGION");
			mapa.put("listado",
					"select id_particion id,particion nombre, 'REGION'::text tipo, pkey from catalogos.geozonas_particiones	where id_geozona = 4");
			try{
			listado = sqlSession.selectList("mencuestas.edomex2017.respuestas.otros.respuestas.listadoRegion", mapa);
			modelo = new Modelo<>(listado);
			retorno.put("anterior", modelo.getSeleccionado());
			retorno.put("actual", modelo);
			}catch(Exception e){
				logger.debug("Error: {}",e.getMessage());
			}
			logger.debug("mapa :{} ",mapa);

			logger.debug("retorno :{} ", retorno);

			logger.debug("Listado :{} ", retorno.get("actual"));
		} else if (fila.get("tipo").equals("REGION")) {
			mapa.put("listado",
					"select id_municipio id, municipio nombre,'MUNICIPIO'::text tipo  from catalogos.geozonas_llaves a join catalogos.municipios b on (a.llave = b.llave) where id_geozona = 4 and id_geozona_particion = "
							+ fila.get("pkey") + " order by id_municipio");
			mapa.put("tipo", "MUNICIPIO");
			mapa.put("id", fila.get("id"));
			listado = sqlSession.selectList("mencuestas.edomex2017.respuestas.otros.respuestas.listadoRegion", mapa);
			modelo = new Modelo<>(listado);
			retorno.put("actual", modelo);
			retorno.put("anterior", fila);
		} else if (fila.get("tipo").equals("MUNICIPIO")) {
			mapa.put("listado",
					"select id_seccion id, id_seccion nombre,'SECCION'::text tipo from catalogos.secciones where id_entidad = 15 and id_municipio = "
							+ fila.get("id"));
			mapa.put("tipo", "SECCION");
			mapa.put("id", fila.get("id"));
			listado = sqlSession.selectList("mencuestas.edomex2017.respuestas.otros.respuestas.listadoRegion", mapa);
			modelo = new Modelo<>(listado);
			retorno.put("actual", modelo);
			retorno.put("anterior", fila);
		} else if (fila.get("tipo").equals("SECCION")) {
			mapa.put("tipo", "PERSONA");
			mapa.put("seccion", fila.get("id"));
			logger.debug("Entro en persona: {}", mapa);
			try {
				listado = sqlSession.selectList("mencuestas.edomex2017.respuestas.otros.respuestas.listadoRegion",
						mapa);
				logger.debug("Listado Personas: {}", listado);
				modelo = new Modelo<>(listado);
				retorno.put("actual", modelo);
				retorno.put("anterior", fila);
				
				
			} catch (Exception e) {
				logger.debug("Error: {}", e.getMessage());
			}

		} else {
			retorno.put("actual", null);
		}

		return retorno;
	}
	
	public HashMap<String, Object> subtotal(Modelo<HashMap<String, Object>> modelo, String pregunta){
		HashMap<String, Object> mapa;
	    mapa = new HashMap<>();
	    logger.debug("modelo: {} ", modelo);
	    if(pregunta.equals("1") || pregunta.equals("2") || pregunta.equals("5")){
		mapa.put("ns_nc_hombres_total", sumar(modelo.getListado(),"ns_nc_hombres"));
		mapa.put("ns_nc_mujeres_total", sumar(modelo.getListado(),"ns_nc_mujeres"));
		mapa.put("ns_nc_total_total", sumar(modelo.getListado(),"ns_nc_total"));
		mapa.put("si_hombres_total", sumar(modelo.getListado(),"si_hombres"));
		mapa.put("si_mujeres_total", sumar(modelo.getListado(),"si_mujeres"));
		mapa.put("si_total_total", sumar(modelo.getListado(),"si_total"));
		mapa.put("no_hombres_total", sumar(modelo.getListado(),"no_hombres"));
		mapa.put("no_mujeres_total", sumar(modelo.getListado(),"no_mujeres"));
		mapa.put("no_total_total", sumar(modelo.getListado(),"no_total"));
		mapa.put("hombres_total", sumar(modelo.getListado(),"hombres"));
		mapa.put("mujeres_total", sumar(modelo.getListado(),"mujeres"));
		mapa.put("total_total", sumar(modelo.getListado(),"total"));
	    }else if(pregunta.equals("3"))
	    {
	    	mapa.put("ns_nc_hombres_total", sumar(modelo.getListado(),"ns_nc_hombres"));
			mapa.put("ns_nc_mujeres_total", sumar(modelo.getListado(),"ns_nc_mujeres"));
			mapa.put("ns_nc_total_total", sumar(modelo.getListado(),"ns_nc_total"));
			mapa.put("pan_hombres_total", sumar(modelo.getListado(),"pan_hombres"));
			mapa.put("pan_mujeres_total", sumar(modelo.getListado(),"pan_mujeres"));
			mapa.put("pan_total_total", sumar(modelo.getListado(),"pan_total"));
			mapa.put("pri_hombres_total", sumar(modelo.getListado(),"pri_hombres"));
			mapa.put("pri_mujeres_total", sumar(modelo.getListado(),"pri_mujeres"));
			mapa.put("pri_total_total", sumar(modelo.getListado(),"pri_total"));
			mapa.put("prd_hombres_total", sumar(modelo.getListado(),"prd_hombres"));
			mapa.put("prd_mujeres_total", sumar(modelo.getListado(),"prd_mujeres"));
			mapa.put("prd_total_total", sumar(modelo.getListado(),"prd_total"));
			mapa.put("pt_hombres_total", sumar(modelo.getListado(),"pt_hombres"));
			mapa.put("pt_mujeres_total", sumar(modelo.getListado(),"pt_mujeres"));
			mapa.put("pt_total_total", sumar(modelo.getListado(),"pt_total"));
			mapa.put("pvem_hombres_total", sumar(modelo.getListado(),"pvem_hombres"));
			mapa.put("pvem_mujeres_total", sumar(modelo.getListado(),"pvem_mujeres"));
			mapa.put("pvem_total_total", sumar(modelo.getListado(),"pvem_total"));
			mapa.put("panal_hombres_total", sumar(modelo.getListado(),"panal_hombres"));
			mapa.put("panal_mujeres_total", sumar(modelo.getListado(),"panal_mujeres"));
			mapa.put("panal_total_total", sumar(modelo.getListado(),"panal_total"));
			mapa.put("pes_hombres_total", sumar(modelo.getListado(),"pes_hombres"));
			mapa.put("pes_mujeres_total", sumar(modelo.getListado(),"pes_mujeres"));
			mapa.put("pes_total_total", sumar(modelo.getListado(),"pes_total"));
			mapa.put("morena_hombres_total", sumar(modelo.getListado(),"morena_hombres"));
			mapa.put("morena_mujeres_total", sumar(modelo.getListado(),"morena_mujeres"));
			mapa.put("morena_total_total", sumar(modelo.getListado(),"morena_total"));
			mapa.put("independiente_hombres_total", sumar(modelo.getListado(),"independiente_hombres"));
			mapa.put("independiente_mujeres_total", sumar(modelo.getListado(),"independiente_mujeres"));
			mapa.put("independiente_total_total", sumar(modelo.getListado(),"independiente_total"));
			mapa.put("no_hombres_total", sumar(modelo.getListado(),"no_hombres"));
			mapa.put("no_mujeres_total", sumar(modelo.getListado(),"no_mujeres"));
			mapa.put("no_total_total", sumar(modelo.getListado(),"no_total"));
			mapa.put("hombres_total", sumar(modelo.getListado(),"hombres"));
			mapa.put("mujeres_total", sumar(modelo.getListado(),"mujeres"));
			mapa.put("total_total", sumar(modelo.getListado(),"total"));
			
	    }else if(pregunta.equals("4")){
	    	mapa.put("ns_nc_hombres_total", sumar(modelo.getListado(),"ns_nc_hombres"));
			mapa.put("ns_nc_mujeres_total", sumar(modelo.getListado(),"ns_nc_mujeres"));
			mapa.put("ns_nc_total_total", sumar(modelo.getListado(),"ns_nc_total"));
			mapa.put("josefina_vazquez_mota_hombres_total", sumar(modelo.getListado(),"josefina_vazquez_mota_hombres"));
			mapa.put("josefina_vazquez_mota_mujeres_total", sumar(modelo.getListado(),"josefina_vazquez_mota_mujeres"));
			mapa.put("josefina_vazquez_mota_total_total", sumar(modelo.getListado(),"josefina_vazquez_mota_total"));
			mapa.put("alfredo_del_mazo_maza_hombres_total", sumar(modelo.getListado(),"alfredo_del_mazo_maza_hombres"));
			mapa.put("alfredo_del_mazo_maza_mujeres_total", sumar(modelo.getListado(),"alfredo_del_mazo_maza_mujeres"));
			mapa.put("alfredo_del_mazo_maza_total_total", sumar(modelo.getListado(),"alfredo_del_mazo_maza_total"));
			mapa.put("juan_zepeda_hernandez_hombres_total", sumar(modelo.getListado(),"juan_zepeda_hernandez_hombres"));
			mapa.put("juan_zepeda_hernandez_mujeres_total", sumar(modelo.getListado(),"juan_zepeda_hernandez_mujeres"));
			mapa.put("juan_zepeda_hernandez_total_total", sumar(modelo.getListado(),"juan_zepeda_hernandez_total"));
			mapa.put("delfina_gomez_alvarez_hombres_total", sumar(modelo.getListado(),"delfina_gomez_alvarez_hombres"));
			mapa.put("delfina_gomez_alvarez_mujeres_total", sumar(modelo.getListado(),"delfina_gomez_alvarez_mujeres"));
			mapa.put("delfina_gomez_alvarez_total_total", sumar(modelo.getListado(),"delfina_gomez_alvarez_total"));
			mapa.put("oscar_gonzalez_yanez_hombres_total", sumar(modelo.getListado(),"oscar_gonzalez_yanez_hombres"));
			mapa.put("oscar_gonzalez_yanez_mujeres_total", sumar(modelo.getListado(),"oscar_gonzalez_yanez_mujeres"));
			mapa.put("oscar_gonzalez_yanez_total_total", sumar(modelo.getListado(),"oscar_gonzalez_yanez_total"));
			mapa.put("isidro_pastor_medrano_hombres_total", sumar(modelo.getListado(),"isidro_pastor_medrano_hombres"));
			mapa.put("isidro_pastor_medrano_mujeres_total", sumar(modelo.getListado(),"isidro_pastor_medrano_mujeres"));
			mapa.put("isidro_pastor_medrano_total_total", sumar(modelo.getListado(),"isidro_pastor_medrano_total"));
			mapa.put("hombres_total", sumar(modelo.getListado(),"hombres"));
			mapa.put("mujeres_total", sumar(modelo.getListado(),"mujeres"));
			mapa.put("total_total", sumar(modelo.getListado(),"total"));
			
	    }else{
	    	mapa.put("nc_hombres_total", sumar(modelo.getListado(),"ns_nc_hombres"));
			mapa.put("nc_mujeres_total", sumar(modelo.getListado(),"nc_mujeres"));
			mapa.put("nc_total_total", sumar(modelo.getListado(),"nc_total"));
			mapa.put("si_hombres_total", sumar(modelo.getListado(),"si_hombres"));
			mapa.put("si_mujeres_total", sumar(modelo.getListado(),"si_mujeres"));
			mapa.put("si_total_total", sumar(modelo.getListado(),"si_total"));
			mapa.put("no_hombres_total", sumar(modelo.getListado(),"no_hombres"));
			mapa.put("no_mujeres_total", sumar(modelo.getListado(),"no_mujeres"));
			mapa.put("no_total_total", sumar(modelo.getListado(),"no_total"));
			mapa.put("hombres_total", sumar(modelo.getListado(),"hombres"));
			mapa.put("mujeres_total", sumar(modelo.getListado(),"mujeres"));
			mapa.put("total_total", sumar(modelo.getListado(),"total"));
	    }
	    
		return mapa;
	}
	
	private Integer sumar(List<HashMap<String, Object>> listado, String campo){
		Integer resultado;
		resultado = 0;
		for (HashMap<String, Object> fila : listado) {
			if(fila.containsKey(campo)){
			resultado = resultado + Integer.parseInt(fila.get(campo).toString());
			}else{
				resultado=resultado+0;
			}
		}
		return resultado;
	}
	
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
}
