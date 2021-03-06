package com.saganet.politik.components.estadisticas;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.DLocalEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.GeozonaEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.estadisticas.VariableEO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.TiposCampoDO;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.modelos.catalogos.DFederalesT;
import com.saganet.politik.modelos.catalogos.DLocalesT;
import com.saganet.politik.modelos.catalogos.EntidadesT;
import com.saganet.politik.modelos.catalogos.MunicipiosT;
import com.saganet.politik.modelos.estadisticas.VariablesT;
import com.saganet.politik.utilidades.Formateador;

@Component("EstadisticasReportesC")
public class ReportesC {
	private static final Logger logger = LoggerFactory.getLogger(ReportesC.class);

	@Autowired
	SqlSession sqlSession;

	@Autowired
	ServletContext servletContext;

	@SuppressWarnings("unchecked")
	public String generarReporte(RequestContext context) {
		StringBuilder rutaArchivo;
		File archivo;
		Formateador formateador;
		Date fecha;
		FileOutputStream fos;
		Workbook libro;
		Sheet hoja;
		Row fila;
		int iCelda, iFila;
		HashMap<String, Object> viewScope;
		NivelesDO nivel;
		EntidadesT listadoEntidades;
		List<EntidadEO> entidades;
		DFederalesT listadoDFederales;
		List<DFederalEO> dFederales;
		DLocalesT listadoDLocales;
		List<DLocalEO> dLocales;
		MunicipiosT listadoMunicipios;
		List<MunicipioEO> municipios;
		Modelo<GeozonaEO> modeloGeozonas;
		GeozonaEO geozona;
		Boolean agruparTerritorios;
		VariablesT listadoVariables;
		List<VariableEO> variables;
		HashMap<String, Object> parametros;
		List<HashMap<String, Object>> reporte;
		List<String> headers;
		LinkedHashMap<String, TiposCampoDO> campos;
		StringBuilder mapper;
		String auxCampo;
		boolean esGeozona;

		reporte = new ArrayList<HashMap<String, Object>>();
		parametros = new HashMap<String, Object>();
		campos = new LinkedHashMap<String, TiposCampoDO>();
		headers = new ArrayList<String>();
		mapper = new StringBuilder();

		viewScope = (HashMap<String, Object>) context.getViewScope().asMap();
		
		formateador = new Formateador();
		fecha = new Date(new java.util.Date().getTime());
		nivel = (NivelesDO) viewScope.get("nivel");
		agruparTerritorios = (Boolean) viewScope.get("agruparTerritorios");
		parametros.put("agruparTerritorios", agruparTerritorios);
		
		rutaArchivo = new StringBuilder("resources/reportesGenerados/");
		rutaArchivo.append(nivel.name());
		rutaArchivo.append("_");
		rutaArchivo.append(formateador.fechaArchivo(fecha));
		rutaArchivo.append(".xlsx");
		archivo = new File(servletContext.getRealPath(rutaArchivo.toString()));

		listadoEntidades = (EntidadesT) viewScope.get("listadoEntidades");
		entidades = listadoEntidades.getSeleccionMultiple();
		parametros.put("entidades", entidades);
		logger.debug("Se obtiene listado de Entidades: {}", entidades);

		listadoDFederales = (DFederalesT) viewScope.get("listadoDFederales");
		dFederales = listadoDFederales.getSeleccionMultiple();
		parametros.put("dFederales", dFederales);
		logger.debug("Se obtiene listado de DFederales: {}", dFederales);

		listadoDLocales = (DLocalesT) viewScope.get("listadoDLocales");
		dLocales = listadoDLocales.getSeleccionMultiple();
		parametros.put("dLocales", dLocales);
		logger.debug("Se obtiene listado de DLocales: {}", dLocales);

		listadoMunicipios = (MunicipiosT) viewScope.get("listadoMunicipios");
		municipios = listadoMunicipios.getSeleccionMultiple();
		parametros.put("municipios", municipios);
		logger.debug("Se obtiene listado de Municipios: {}", municipios);
		
		modeloGeozonas = (Modelo<GeozonaEO>) viewScope.get("modeloGeozonas");
		geozona = modeloGeozonas.getSeleccionado();
		parametros.put("geozona", geozona);
		logger.debug("Se obtiene Geozona: {}", geozona);

		listadoVariables = (VariablesT) viewScope.get("listadoVariables");
		variables = listadoVariables.getSeleccionMultiple();
		parametros.put("variables", variables);
		logger.debug("Se obtiene listado de Variables: {}", variables);

		try {
			fos = new FileOutputStream(archivo);
			libro = new XSSFWorkbook();
			hoja = libro.createSheet(nivel.getNombre());
			
			if(nivel.equals(NivelesDO.GEOZONA)){
				esGeozona = true;
				nivel = geozona.getNivel();
				headers.add("GeoZona");
				headers.add("Partici�n");
			} else {
				esGeozona = false;
			}
			
			switch (nivel) {
			case DFEDERAL:
				campos.put("id_entidad", TiposCampoDO.INTEGER);
				campos.put("entidad", TiposCampoDO.TEXT);
				campos.put("id_dfederal", TiposCampoDO.INTEGER);
				campos.put("dfederal", TiposCampoDO.TEXT);
				campos.put("llave", TiposCampoDO.TEXT);
				headers.add("id Entidad");
				headers.add("Entidad");
				headers.add("id Dtto. Federal");
				headers.add("Dtto. Federal");
				headers.add("Dtto. Federal LLave");
				mapper.append("estadisticas.reportes.dFederales");
				break;
			case DLOCAL:
				campos.put("id_entidad", TiposCampoDO.INTEGER);
				campos.put("entidad", TiposCampoDO.TEXT);
				campos.put("id_dlocal", TiposCampoDO.INTEGER);
				campos.put("dlocal", TiposCampoDO.TEXT);
				campos.put("llave", TiposCampoDO.TEXT);
				headers.add("id Entidad");
				headers.add("Entidad");
				headers.add("id Dtto. Local");
				headers.add("Dtto. Local");
				headers.add("Dtto. Local LLave");
				mapper.append("estadisticas.reportes.dLocales");
				break;
			case ENTIDAD:
				if(!esGeozona || !agruparTerritorios){
					campos.put("id_entidad", TiposCampoDO.INTEGER);
					campos.put("entidad", TiposCampoDO.TEXT);
					headers.add("id Entidad");
					headers.add("Entidad");
				}
				mapper.append("estadisticas.reportes.entidades");
				break;
			case LOCALIDAD:
				campos.put("EstadisticasLocalidades.id_entidad", TiposCampoDO.INTEGER);
				campos.put("CatalogosEntidades.entidad", TiposCampoDO.TEXT);
				campos.put("EstadisticasLocalidades.id_municipio", TiposCampoDO.INTEGER);
				campos.put("CatalogosMunicipios.municipio", TiposCampoDO.TEXT);
				campos.put("EstadisticasLocalidades.id_localidad", TiposCampoDO.INTEGER);
				campos.put("CatalogosLocalidades.localidad", TiposCampoDO.TEXT);
				campos.put("CatalogosLocalidades.llave", TiposCampoDO.TEXT);
				
				headers.add("id Entidad");
				headers.add("Entidad");
				headers.add("id Municipio");
				headers.add("Municipio");
				headers.add("id Localidad");
				headers.add("Localidad");
				headers.add("Localidad LLave");
				mapper.append("estadisticas.reportes.localidades");
				break;
			case MANZANA:
				campos.put("EstadisticasManzanas.id_entidad", TiposCampoDO.INTEGER);
				campos.put("CatalogosEntidades.entidad", TiposCampoDO.TEXT);
				campos.put("EstadisticasManzanas.id_seccion", TiposCampoDO.INTEGER);
				campos.put("CatalogosSecciones.id_dfederal", TiposCampoDO.INTEGER);
				campos.put("CatalogosDFederales.dfederal", TiposCampoDO.TEXT);
				campos.put("CatalogosSecciones.id_dlocal", TiposCampoDO.INTEGER);
				campos.put("CatalogosDlocales.dlocal", TiposCampoDO.TEXT);
				campos.put("EstadisticasManzanas.id_municipio", TiposCampoDO.INTEGER);
				campos.put("CatalogosMunicipios.municipio", TiposCampoDO.TEXT);
				campos.put("EstadisticasManzanas.id_localidad", TiposCampoDO.INTEGER);
				campos.put("CatalogosLocalidades.localidad", TiposCampoDO.TEXT);
				campos.put("CatalogosManzanas.llave", TiposCampoDO.TEXT);
				
				headers.add("id Entidad");
				headers.add("Entidad");
				headers.add("Secci�n");
				headers.add("id Dtto. Federal");
				headers.add("Dtto. Federal");
				headers.add("id Dtto. Local");
				headers.add("Dtto. Local");
				headers.add("id Municipio");
				headers.add("Municipio");
				headers.add("id Localidad");
				headers.add("Localidad");
				headers.add("Manzana LLave");
				mapper.append("estadisticas.reportes.manzanas");
				break;
			case MUNICIPIO:
				if(!esGeozona || !agruparTerritorios){
					campos.put("id_entidad", TiposCampoDO.INTEGER);
					campos.put("entidad", TiposCampoDO.TEXT);
					campos.put("id_municipio", TiposCampoDO.INTEGER);
					campos.put("municipio", TiposCampoDO.TEXT);
					campos.put("CatalogosMunicipios.llave", TiposCampoDO.TEXT);
					headers.add("id Entidad");
					headers.add("Entidad");
					headers.add("id Municipio");
					headers.add("Municipio");
					headers.add("Municipio LLave");
				}
				mapper.append("estadisticas.reportes.municipios");
				break;
			case SECCION:
				campos.put("EstadisticasSecciones.id_entidad", TiposCampoDO.INTEGER);
				campos.put("CatalogosEntidades.entidad", TiposCampoDO.TEXT);
				campos.put("EstadisticasSecciones.id_seccion", TiposCampoDO.INTEGER);
				campos.put("EstadisticasSecciones.id_dfederal", TiposCampoDO.INTEGER);
				campos.put("CatalogosDFederales.dfederal", TiposCampoDO.TEXT);
				campos.put("EstadisticasSecciones.id_dlocal", TiposCampoDO.INTEGER);
				campos.put("CatalogosDlocales.dlocal", TiposCampoDO.TEXT);
				campos.put("EstadisticasSecciones.id_municipio", TiposCampoDO.INTEGER);
				campos.put("CatalogosMunicipios.municipio", TiposCampoDO.TEXT);
				campos.put("CatalogosSecciones.llave", TiposCampoDO.TEXT);
				
				headers.add("id Entidad");
				headers.add("Entidad");
				headers.add("Secci�n");
				headers.add("id Dtto. Federal");
				headers.add("Dtto. Federal");
				headers.add("id Dtto. Local");
				headers.add("Dtto. Local");
				headers.add("id Municipio");
				headers.add("Municipio");
				headers.add("Secci�n LLave");
				mapper.append("estadisticas.reportes.secciones");
				break;
			case NACIONAL:
				mapper.append("estadisticas.reportes.nacional");
				break;
			default:
				break;
			}
			
			for (VariableEO variable : variables) {
				campos.put(variable.getCampo(), variable.getTipo());
				headers.add(variable.getCampo());
			}
			parametros.put("campos", campos);

			if(entidades.isEmpty())
				entidades.add(new EntidadEO(-1, "Ninguno"));
			
			if(esGeozona)
				mapper.append("Geozona");
			reporte = sqlSession.selectList(mapper.toString(), parametros);
			logger.debug("Se obtiene Mapa de Reporte: {}", reporte);

			// Llenar Reporte
			// Headers
			iFila = 0;
			fila = hoja.createRow(iFila++);
			iCelda = 0;
			for (String header : headers) {
				fila.createCell(iCelda++).setCellValue(header);
			}

			// Datos
			for (HashMap<String, Object> dato : reporte) {
				fila = hoja.createRow(iFila++);
				iCelda = 0;
				
				if(esGeozona){
					fila.createCell(iCelda++).setCellValue((String) dato.get("geozona"));
					fila.createCell(iCelda++).setCellValue((String) dato.get("particion"));
				}
				
				for (Map.Entry<String, TiposCampoDO> campo : campos.entrySet()) {
					
					if(campo.getKey().indexOf(".") != -1){
						auxCampo = campo.getKey().substring(campo.getKey().indexOf(".")+1);
					} else {
						auxCampo = campo.getKey();
					}

					switch (campo.getValue()) {
					case INTEGER:
					case NUMERIC:
						switch(dato.get(auxCampo).getClass().toString()){
						default:
						case "class java.lang.Integer":
							fila.createCell(iCelda++).setCellValue((Integer) dato.get(auxCampo));
							break;
						case "class java.lang.Long":
							fila.createCell(iCelda++).setCellValue((Long) dato.get(auxCampo));
						}
						break;
					case TEXT:
						fila.createCell(iCelda++).setCellValue((String) dato.get(auxCampo));
						break;
					}
				}
			}

			libro.write(fos);
			libro.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.debug("Archivo de Descarga Generado: {}", archivo.getAbsolutePath());
		
		return archivo.getName();
	}
}
