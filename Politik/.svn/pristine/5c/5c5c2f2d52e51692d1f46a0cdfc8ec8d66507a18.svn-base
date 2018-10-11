package com.saganet.politik.components.encuestas.edomex2017.respuestas;

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
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.modelos.Modelo;

@Component("Edomex2017EncuestasRespuestasProsperaC")
public class RespuestasProsperaC {

	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(RespuestasProsperaC.class);
	
	public HashMap<String, Object> modeloPregunta(HashMap<String, Object> fila, String pregunta) {
		Modelo<HashMap<String, Object>> modelo;
		List<HashMap<String, Object>> listado;
		HashMap<String, Object> mapa, retorno;
		NivelesDO nivel;

		mapa = new HashMap<>();
		retorno = new HashMap<>();
		mapa.put("pregunta", pregunta);
		switch (pregunta) {
		case "1":
			retorno.put("nombre_pregunta", "Sabe si el apoyo de PROSPERA que usted recibe es de..");
			break;
		case "2":
			retorno.put("nombre_pregunta",
					"¿Se siente usted apoyado por el Gobierno de la República a través de sus Programas Sociales?");
			break;
		case "3":
			retorno.put("nombre_pregunta",
					"¿Cómo calificaría el desempeño del Gobierno de la República con PROSPERA en su Estado?");
			break;
		case "4":
			retorno.put("nombre_pregunta",
					"¿Cómo calificaría los Programas Sociales que recibe por parte del Gobierno del Estado?");
			break;
		case "5":
			retorno.put("nombre_pregunta",
					"¿Le gustaría que los Programas se mantengan coomo hasta ahora lo han hecho?");
			break;

		}
		//consulta de territorios usuario
		nivel = getUsuario().getNivel();
		//
		logger.debug("Valor Ingreso: {}", fila);logger.debug("Pregunta: {}", pregunta);
		if (fila == null) {
			mapa.put("tipo", "REGION");
			mapa.put("listado",
					"select id_particion id,particion nombre, 'REGION'::text tipo, pkey from catalogos.geozonas_particiones	where id_geozona = 4");
			listado = sqlSession.selectList("mencuestas.edomex2017.respuestas.prospera.respuestas.listadoRegion", mapa);
			
			
			
			modelo = new Modelo<>(listado);
			retorno.put("anterior", modelo.getSeleccionado());
			retorno.put("actual", modelo);
		} else if (fila.get("tipo").equals("REGION")) {
			mapa.put("listado",
					"select id_municipio id, municipio nombre,'MUNICIPIO'::text tipo  from catalogos.geozonas_llaves a join catalogos.municipios b on (a.llave = b.llave) where id_geozona = 4 and id_geozona_particion = "
							+ fila.get("pkey") + " order by id_municipio");
			mapa.put("tipo", "MUNICIPIO");
			mapa.put("id", fila.get("id"));
			listado = sqlSession.selectList("mencuestas.edomex2017.respuestas.prospera.respuestas.listadoRegion", mapa);
			modelo = new Modelo<>(listado);
			retorno.put("actual", modelo);
			retorno.put("anterior", fila);
		} else if (fila.get("tipo").equals("MUNICIPIO")) {
			mapa.put("listado",
					"select id_seccion id, id_seccion nombre,'SECCION'::text tipo from catalogos.secciones where id_entidad = 15 and id_municipio = "
							+ fila.get("id"));
			mapa.put("tipo", "SECCION");
			mapa.put("id", fila.get("id"));
			listado = sqlSession.selectList("mencuestas.edomex2017.respuestas.prospera.respuestas.listadoRegion", mapa);
			modelo = new Modelo<>(listado);
			retorno.put("actual", modelo);
			retorno.put("anterior", fila);
		} else if (fila.get("tipo").equals("SECCION")) {
			mapa.put("tipo", "PERSONA");
			mapa.put("seccion", fila.get("id"));
			try {
				listado = sqlSession.selectList("mencuestas.edomex2017.respuestas.prospera.respuestas.listadoRegion",
						mapa);
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
	
	public HashMap<String, Object> subtotal(Modelo<HashMap<String, Object>> modelo){
		HashMap<String, Object> mapa;
	    mapa = new HashMap<>();
		mapa.put("nc_hombres_total", sumar(modelo.getListado(),"nc_hombres"));
		mapa.put("nc_mujeres_total", sumar(modelo.getListado(),"nc_mujeres"));
		mapa.put("nc_total_total", sumar(modelo.getListado(),"nc_total"));
		mapa.put("gobierno_federal_hombres_total", sumar(modelo.getListado(),"gobierno_federal_hombres"));
		mapa.put("gobierno_federal_mujeres_total", sumar(modelo.getListado(),"gobierno_federal_mujeres"));
		mapa.put("gobierno_federal_total_total", sumar(modelo.getListado(),"gobierno_federal_total"));
		mapa.put("gobierno_estatal_hombres_total", sumar(modelo.getListado(),"gobierno_estatal_hombres"));
		mapa.put("gobierno_estatal_mujeres_total", sumar(modelo.getListado(),"gobierno_estatal_mujeres"));
		mapa.put("gobierno_estatal_total_total", sumar(modelo.getListado(),"gobierno_estatal_total"));
		mapa.put("gobierno_municipal_hombres_total", sumar(modelo.getListado(),"gobierno_municipal_hombres"));
		mapa.put("gobierno_municipal_mujeres_total", sumar(modelo.getListado(),"gobierno_municipal_mujeres"));
		mapa.put("gobierno_municipal_total_total", sumar(modelo.getListado(),"gobierno_municipal_total"));
		mapa.put("no_sabe_hombres_total", sumar(modelo.getListado(),"no_sabe_hombres"));
		mapa.put("no_sabe_mujeres_total", sumar(modelo.getListado(),"no_sabe_mujeres"));
		mapa.put("no_sabe_total_total", sumar(modelo.getListado(),"no_sabe_total"));
		mapa.put("hombres_total", sumar(modelo.getListado(),"hombres"));
		mapa.put("mujeres_total", sumar(modelo.getListado(),"mujeres"));
		mapa.put("total_total", sumar(modelo.getListado(),"total"));
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
