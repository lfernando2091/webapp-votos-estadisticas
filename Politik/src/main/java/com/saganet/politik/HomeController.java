package com.saganet.politik;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saganet.politik.database.diaD.ParametrosMuncipios;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.components.administracion.AvisosC;
import com.saganet.politik.components.encuestas.admin.ReglasResultadosC;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.biblioteca.ReportesParametros;
import com.saganet.politik.database.diaD.MovilizadoEO;
import com.saganet.politik.database.diaD.MovilizadorEO;
import com.saganet.politik.database.encuestas.admin.ParametrosActivistas;
import com.saganet.politik.database.encuestas.admin.ParametrosEstadisticas;
import com.saganet.politik.database.encuestas.admin.ParametrosPromovidos;
import com.saganet.politik.database.encuestas.admin.PreguntaEO;
import com.saganet.politik.database.encuestas.admin.ReglaEncuestaEO;
import com.saganet.politik.database.encuestas.admin.ReglaRE;
import com.saganet.politik.database.encuestas.admin.ReglaResultadoEO;
import com.saganet.politik.database.encuestas.admin.ValoresRE;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String rutaFuentesReportes="E:\\Politik\\FuentesReportes";

	@Autowired ParametrosMuncipios parametrosReportesMunicipios;
	
	@Autowired
	private ReportesParametros parametrosReportes;
	@Autowired
	private ParametrosEstadisticas parametrosEstadisticas;
	
	@Autowired
	ReglasResultadosC reglasResultadosC;
	
	@Autowired
	ParametrosEstadisticas parametros;
	
	@Autowired
	ParametrosActivistas parametrosActivistas;
	
	@Autowired
	ParametrosPromovidos parametrosPromovidos;
	
	@Autowired AvisosC avisosC;
	
	@Autowired
	SqlSession sqlSession;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		HashMap<String, Object> mapa;

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
		mapa = new HashMap<>();
		
		mapa.put("mensaje", avisosC.getMensaje());

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("AvisosC", mapa);

		return "home";
	}

	@RequestMapping(value = "/descargaArchivo.saga", method = { RequestMethod.POST, RequestMethod.GET })
	public void generateReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nombreArchivo;
		StringTokenizer st;
		logger.debug("Hola desde descargaArchivo.htm");

		String filePathToBeServed;
		File fileToDownload;
		InputStream inputStream;

		nombreArchivo = parametrosReportes.getAr().getName();
		st = new StringTokenizer(parametrosReportes.getAr().getName(), ".");

		try {

			// logger.debug("Ruta {} " + ruta);

			filePathToBeServed = parametrosReportes.getAr().getAbsolutePath();// complete
																				// file
																				// name
																				// with
																				// path;
			fileToDownload = new File(filePathToBeServed);

			inputStream = new FileInputStream(fileToDownload);
			if (st.countTokens() > 1) {
				st.nextToken();
				String token = st.nextToken();
				switch (token) {
				case "pdf":

					response.setHeader("Content-Type", "application/pdf");
					break;
				case "txt":
					response.setHeader("Content-Type", "text/plain");
					break;
				case "png":
					response.setHeader("Content-Type", "image/png");
					break;

				case "jpg":
					response.setHeader("Content-Type", "image/jpg");
					break;
				default:
					response.setHeader("Content-Type", "application/force-download");

				}
			}
			response.setHeader("Content-Disposition", "inline; filename=\"" + nombreArchivo + "\"");
			/*
			 * response.setContentType("application/pdf");
			 * response.setHeader("Content-Disposition",
			 * "attachment; filename=listado_1_2.pdf");
			 */
			IOUtils.copy(inputStream, response.getOutputStream());
			response.flushBuffer();
			inputStream.close();
		} catch (Exception e) {
			filePathToBeServed = "C:\\reportes\\no_encontrado.png";
			fileToDownload = new File(filePathToBeServed);
			try {
				inputStream = new FileInputStream(fileToDownload);
				response.setHeader("Content-Type", "image/png");
				response.setHeader("Content-Disposition", "inline; filename=\"error.png");
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
				inputStream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// logger.debug("Request could not be completed at this moment.
			// Please try again.");
			e.printStackTrace();
			e.getCause();
		}

	}

	@RequestMapping(value = "/estadisticaEncuesta.saga", method = { RequestMethod.POST, RequestMethod.GET })
	public void mostrarEstadisticaEncuesta(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HashMap<String, Object> parametros, variables;
		String filePathToBeServed;
		File fileToDownload;
		String nombreArchivo;
		InputStream inputStream;
		List<File> li;
		JasperReport jasperReport;
		li = new ArrayList<>();
		try {

			jasperReport = JasperCompileManager
					.compileReport(rutaFuentesReportes+"\\graficaEstadisticas.jrxml");
			logger.debug("recibido", parametrosEstadisticas);
			
			parametros = new HashMap<String, Object>();
			for (ReglaEncuestaEO regla : parametrosEstadisticas.getCampania().getEncuesta().getReglasEncuestas()) {
				
				ReglaRE reglaa;
				
				
				
				reglaa = new ReglaRE();
				for (ReglaResultadoEO resultado : regla.getReglasResultados()) {
					List<ReglaRE> lista;
					lista = new ArrayList<ReglaRE>();
					StringTokenizer  st,st1;
					String cadena;
					Double universoAvance;
					
					st = new StringTokenizer(resultado.getResultado(),"@");
					List<ValoresRE> listaValores;
					ValoresRE valor;
					universoAvance = 0.0;
					
					listaValores = new ArrayList<ValoresRE>();
					while (st.hasMoreTokens()){
						cadena =  st.nextToken();
						logger.debug(" Token: {}",cadena);
						valor = new ValoresRE();
						st1 = new StringTokenizer(cadena, "|");
						//valor.setId(variableContador);
						valor.setCampo(st1.nextToken());
						valor.setValor(Double.parseDouble(st1.nextToken()));
						valor.setPorcentajeContactos((valor.getValor()/parametrosEstadisticas.getCampania().getUniversoContactos())*100);
						valor.setPorcentaje((valor.getValor()/parametrosEstadisticas.getCampania().getAvanceContactos())*100);
						logger.debug("Porcentaje: {}", valor.getPorcentaje());
						universoAvance = universoAvance + valor.getValor();
						listaValores.add(valor);
					}
					
					variables = new HashMap<String, Object>();
					variables.put("campania", parametrosEstadisticas.getCampania().getNombre());
					variables.put("encuesta", parametrosEstadisticas.getCampania().getEncuesta().getDescripcion());
					variables.put("regla", regla.getDescripcion() + " (" + regla.getRegla() + ")");
					parametros.put("mapaVariables", variables);
				
					
					reglaa.setId(regla.getId());
					reglaa.setValoresRegla(listaValores);
					reglaa.setParametros(variables);
					reglaa.setFechaActualizacion(resultado.getFecha());
					reglaa.setUniverso(universoAvance);
					logger.debug("Valores : {}", lista);
					lista.add(reglaa);
					JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(lista, false);

					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, beanCollection);
					JasperExportManager.exportReportToPdfFile(jasperPrint,
							rutaFuentesReportes+"\\" + regla.getDescripcion().replaceAll("[-+.^:,?]","")  + ".pdf");
					File ar = new File(
							rutaFuentesReportes+"\\" + regla.getDescripcion().replaceAll("[-+.^:,?]","") + ".pdf");
					li.add(ar);
					
					logger.debug("tamanio: {}", li.size());
									}
			
				
			}
			
			///codigo para generar archivo
			
			reglasResultadosC.estadisticas(parametrosEstadisticas.getCampania());
			
			//se crea libro
			HSSFWorkbook libro;
			libro = new HSSFWorkbook();
			//Se crea una hoja
			HSSFSheet hoja = libro.createSheet(parametrosEstadisticas.getCampania().getNombre());
			
			HSSFCell celda;
			HSSFRow fila;
			
			Integer contadorEncabezado = -1;
			
			fila = hoja.createRow(0);
			
			//Se crea una celda-pkey
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("pkey");
			
			//Se crea una celda-idContacto
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("id_contacto");
			
			//Se crea una celda-idContacto
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("id_persona");
			
			//Obtenemos respuestas y preguntas de la encuesta
			StringBuilder preguntas;
			StringBuilder reglas;
			preguntas = new StringBuilder();
			reglas = new StringBuilder();
			
			logger.debug("Preguntas: {}", parametrosEstadisticas.getCampania().getEncuesta().getPreguntas());
			
			for(PreguntaEO pregunta : parametrosEstadisticas.getCampania().getEncuesta().getPreguntas()){
				preguntas.append("_");
				preguntas.append(pregunta.getConsecutivoPregunta());
				preguntas.append(",");
				
				//Se crea una celda preguntas
				contadorEncabezado++;
				celda = fila.createCell(contadorEncabezado);
				//Se asigna contenido a la celda
				celda.setCellValue(pregunta.getPregunta());
				
			}
			
			//Se crea una celda-pkey
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("estatus");
			
			//Se crea una celda-pkey
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("dato1");
			
			//Se crea una celda-pkey
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("dato2");
			
			//Se crea una celda-pkey
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("dato3");
			
			//Se crea una celda-pkey
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("dato4");
			
			//Se crea una celda-idContacto
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("nick");
			
			//Se crea una celda-idContacto
			contadorEncabezado++;
			celda = fila.createCell(contadorEncabezado);
			//Se asigna contenido a la celda
			celda.setCellValue("fecha");
			
			reglas.append(",");
			for(ReglaEncuestaEO regla : parametrosEstadisticas.getCampania().getEncuesta().getReglasEncuestas()){
				if(regla.getTipo().equals("COMBINADA")){
					reglas.append("r");
					reglas.append(regla.getId());
					reglas.append(",");
					
					//Se crea una celda reglas
					contadorEncabezado++;
					celda = fila.createCell(contadorEncabezado);
					//Se asigna contenido a la celda
					celda.setCellValue(regla.getDescripcion().replaceAll("[-+.^:,?]",""));
				}
			}
			
			if(reglas.length()>0){
				reglas = reglas.deleteCharAt(reglas.length() - 1);
			}else{
				reglas = new StringBuilder();
			}
				
			
			//Realizamos la consulta a la tabla de la campa�a
			HashMap<String, Object> mapa;
			mapa = new HashMap<>();
			
			List<HashMap<String, Object>> map;
			map = new ArrayList<>();
			
			mapa.put("tablaCampania", parametrosEstadisticas.getCampania().getId());
			mapa.put("preguntas", preguntas);
			mapa.put("reglas", reglas);
			
			logger.debug("Mapa de la consulta a la tabla de la campa�a: {}", mapa);
			
			map = sqlSession.selectList("encuestas.captura.cuestionario.resultadosEncuestaListado", mapa);
			
			for(HashMap<String, Object> mapita : map){
				//Se crea una fila
				fila = hoja.createRow((Integer)mapita.get("pkey"));
				
				//Se crea una celda-pkey
				celda = fila.createCell(0);
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("pkey").toString());
				
				//Se crea una celda-idContacto
				celda = fila.createCell(1);
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("id_contacto").toString());
				
				//Se crea una celda-idContacto
				celda = fila.createCell(2);
				
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("id_persona").toString());
				
				Integer contador = 2;
				for(PreguntaEO pregunta : parametrosEstadisticas.getCampania().getEncuesta().getPreguntas()){
					contador++;
					//Se crea una celda-idContacto
					celda = fila.createCell(contador);
					//Se asigna contenido a la celda
					celda.setCellValue(mapita.get("_"+pregunta.getConsecutivoPregunta()).toString());
				}
				
				contador++;
				celda = fila.createCell(contador);
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("estatus").toString());
				
				contador++;
				celda = fila.createCell(contador);
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("dato1").toString());
				
				contador++;
				celda = fila.createCell(contador);
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("dato2").toString());
				
				contador++;
				celda = fila.createCell(contador);
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("dato3").toString());
				
				contador++;
				celda = fila.createCell(contador);
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("dato4").toString());
				
				contador++;
				//Se crea una celda-idContacto
				celda = fila.createCell(contador);
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("nick").toString());
				
				contador++;
				//Se crea una celda-idContacto
				celda = fila.createCell(contador);
				//Se asigna contenido a la celda
				celda.setCellValue(mapita.get("fecha").toString());
				
				for(ReglaEncuestaEO regla : parametrosEstadisticas.getCampania().getEncuesta().getReglasEncuestas()){
					if(regla.getTipo().equals("COMBINADA")){
						contador++;
						//Se crea una celda-idContacto
						celda = fila.createCell(contador);
						//Se asigna contenido a la celda
						celda.setCellValue(mapita.get("r"+regla.getId()).toString());
					}
				}
				
				
			}
			
			
			//Guardamos el excel generado
			try {
				OutputStream out = new FileOutputStream("E:\\Politik\\ListadosEstadisticas\\ListadoEstadisticas_"+parametrosEstadisticas.getCampania().getNick()+".xls");
				libro.write(out);
				li.add(new File("E:\\Politik\\ListadosEstadisticas\\ListadoEstadisticas_"+parametrosEstadisticas.getCampania().getNick()+".xls"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.debug("Error al guardar el listado: {}", e.toString());
				e.printStackTrace();
			}
			
			libro.close();

			//
			
			
			zipFile(li, rutaFuentesReportes+"\\"+parametrosEstadisticas.getCampania().getNombre()+".zip");
			filePathToBeServed = rutaFuentesReportes+"\\"+parametrosEstadisticas.getCampania().getNombre()+".zip";// complete
			nombreArchivo = parametrosEstadisticas.getCampania().getNombre()+".zip";
			fileToDownload = new File(filePathToBeServed);
			inputStream = new FileInputStream(fileToDownload);
			response.setHeader("Content-Type", "application/force-download");
			response.setHeader("Content-Disposition", "inline; filename=\"" + nombreArchivo + "\"");
			IOUtils.copy(inputStream, response.getOutputStream());
			inputStream.close();
			filePathToBeServed = "";
			nombreArchivo = "";
			response.flushBuffer();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void zipFile(List<File> inputFile, String zipFilePath) {
		try {
			logger.debug("dddd:{}", inputFile);
			FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
			ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

			for (File inputFil : inputFile) {
				ZipEntry zipEntry = new ZipEntry(inputFil.getName());
				zipOutputStream.putNextEntry(zipEntry);
				FileInputStream fileInputStream = new FileInputStream(inputFil);
				byte[] buf = new byte[1024000];
				int bytesRead;
				while ((bytesRead = fileInputStream.read(buf)) > 0) {
					zipOutputStream.write(buf, 0, bytesRead);
					zipOutputStream.closeEntry();
				}

			}
			zipOutputStream.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	@RequestMapping(value = "/reportes/MetasResultados.c++", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado(HttpServletRequest request, HttpServletResponse response) throws JRException{
	
		JasperReport jasperReport;
		HashMap<String, Object> mapa;
		List<Object> listado;
		List<HashMap<String, Object>> descuentos, listadoEnvio;
		
		//String rutaFuentesReportes;
		
	//	rutaFuentesReportes=request.getSession().getServletContext().getRealPath("/resources/fuentesReportes/");
		//rutaFuentesReportes=rutaFuentesReportes;
		mapa = new HashMap<>();
		listado = new ArrayList<>();
		 Connection connection = null;
		/*crear conexion a la base */
		 try {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
	       
		/**/
		
		/**/
		HashMap<String, Object> map;	
		
		listadoEnvio = new ArrayList<>();
		//int val=0;
		if(getUsuario().getProgamas().size()>1){
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Primera\\Reporte_Entrevistas_Por_Dia.jrxml");
		}else{
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Reporte_Entrevistas_Por_Dia_"+getUsuario().getProgamas().get(0).getNombre().toUpperCase()+".jrxml");
		}
		
			
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					//JasperExportManager.exportReportToPdfFile(jasperPrint,
					//		rutaFuentesReportes+"\\" + parametrosRecibo.getBoleta().getId()  + ".pdf");
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@RequestMapping(value = "/reportes/MetasResultados2.c++", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado3(HttpServletRequest request, HttpServletResponse response) throws JRException{
	
		JasperReport jasperReport;
		HashMap<String, Object> mapa;
		List<Object> listado;
		List<HashMap<String, Object>> descuentos, listadoEnvio;
		
		//String rutaFuentesReportes;
		
	//	rutaFuentesReportes=request.getSession().getServletContext().getRealPath("/resources/fuentesReportes/");
		//rutaFuentesReportes=rutaFuentesReportes;
		mapa = new HashMap<>();
		listado = new ArrayList<>();
		 Connection connection = null;
		/*crear conexion a la base */
		 try {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
	       
		/**/
		
		/**/
		HashMap<String, Object> map;	
		
		listadoEnvio = new ArrayList<>();
		//int val=0;
		if(getUsuario().getProgamas().size()>1){
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Primera\\Reporte_Entrevistas_Por_Dia4Pasteles.jrxml");
		}else{
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Reporte_Entrevistas_Por_Dia_"+getUsuario().getProgamas().get(0).getNombre().toUpperCase()+".jrxml");
		}
		
			
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					//JasperExportManager.exportReportToPdfFile(jasperPrint,
					//		rutaFuentesReportes+"\\" + parametrosRecibo.getBoleta().getId()  + ".pdf");
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@RequestMapping(value = "/reportes/MetasResultados.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado2(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> mapa= new HashMap<>();
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		 try {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		HashMap<String, Object> map;
		if(getUsuario().getProgamas().size()>1){
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Segunda\\Reporte_Entrevistas_Por_Dia.jrxml");
		}else{
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\v2\\Reporte_Entrevistas_Por_Dia_"+getUsuario().getProgamas().get(0).getNombre().toUpperCase()+".jrxml");
		}
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(value = "/reportes/MetasResultados2.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado4(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> mapa= new HashMap<>();
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		 try {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		HashMap<String, Object> map;
		if(getUsuario().getProgamas().size()>1){
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Segunda\\Reporte_Entrevistas_Por_Dia4Pasteles.jrxml");
		}else{
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\v2\\Reporte_Entrevistas_Por_Dia_"+getUsuario().getProgamas().get(0).getNombre().toUpperCase()+".jrxml");
		}
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	

	@RequestMapping(value = "/reportes/MetasResultados3.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado5(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> mapa= new HashMap<>();
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		 try {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		HashMap<String, Object> map;
		//if(getUsuario().getProgamas().size()>1){
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Tercera\\Reporte_Entrevistas_Por_Dia1.jrxml");
		/*}else{
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Tercera\\Reporte_Entrevistas_Por_Dia_"+getUsuario().getProgamas2().get(0).getNombre().toUpperCase()+".jrxml");
		}*/
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(value = "/reportes/MetasResultados23.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado6(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> mapa= new HashMap<>();
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		 try {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		HashMap<String, Object> map;
		//if(getUsuario().getProgamas().size()>1){
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Tercera\\Reporte_Entrevistas_Por_Dia2.jrxml");
		/*}else{
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Tercera\\Reporte_Entrevistas_Por_Dia_"+getUsuario().getProgamas2().get(0).getNombre().toUpperCase()+".jrxml");
		}*/
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	@RequestMapping(value = "/reportes/MetasResultados4.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado7(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> mapa= new HashMap<>();
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		 try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		 	HashMap<String, Object> map;
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\hermanos\\Reporte_Entrevistas_Por_Dia1.jrxml");
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(value = "/reportes/MetasResultados24.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado8(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> mapa= new HashMap<>();
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		 try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		 	HashMap<String, Object> map;
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\hermanos\\Reporte_Entrevistas_Por_Dia2.jrxml");
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

	
	
	
	@RequestMapping(value = "/reportes/MetasResultados5.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado9(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> mapa= new HashMap<>();
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		 try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		 	HashMap<String, Object> map;
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\levantamientoROWAN\\Reporte_Entrevistas_Por_Dia1.jrxml");
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(value = "/reportes/MetasResultados25.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void metasResultado10(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> mapa= new HashMap<>();
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		 try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		 	HashMap<String, Object> map;
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\levantamientoROWAN\\Reporte_Entrevistas_Por_Dia2.jrxml");
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public Connection conexion(){
		Connection connection = null;
		 try {
				
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
				return connection;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	@RequestMapping(value = "/reportes/desglose30Abril.aspx", method = { RequestMethod.POST, RequestMethod.GET })
	public void desglose30Abril(HttpServletRequest request, HttpServletResponse response) throws JRException, SQLException{
		Connection connection;
		JasperReport jasperReport;
		HashMap<String, Object> mapa;
		List<File> li;
		
		String filePathToBeServed;
		File fileToDownload;
		String nombreArchivo;
		InputStream inputStream;
		
		connection=  conexion();
		mapa = new HashMap<>();
		li = new ArrayList<>();
		jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\desglose30Abril\\edoMex desglose_30_abril.jrxml");
		//response.setContentType("application/x-download");
	    //response.setHeader("Content-Disposition", "attachment; filename=Desglose30Abril5.pdf");
		try {
			 OutputStream outStream = response.getOutputStream();
			//JasperExportManager.exportReportToPdfFile(jasperPrint,
			//		rutaFuentesReportes+"\\" + parametrosRecibo.getBoleta().getId()  + ".pdf");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,mapa, connection);
			//JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
			JasperExportManager.exportReportToPdfFile(jasperPrint,rutaFuentesReportes+"\\desglose30Abril\\pdf\\Desglose30Abril5.pdf");
			li.add(new File(rutaFuentesReportes+"\\desglose30Abril\\pdf\\Desglose30Abril5.pdf"));
			logger.debug("Valor: {}", li);
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\desglose30Abril\\edoMex desglose_30_abril_3_rubros.jrxml");
			outStream = response.getOutputStream();
			jasperPrint = JasperFillManager.fillReport(jasperReport,mapa, connection);
			JasperExportManager.exportReportToPdfFile(jasperPrint,rutaFuentesReportes+"\\desglose30Abril\\pdf\\Desglose30Abril3.pdf");
			li.add(new File(rutaFuentesReportes+"\\desglose30Abril\\pdf\\Desglose30Abril3.pdf"));
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\desglose30Abril\\edoMex reporte a favor.jrxml");
			outStream = response.getOutputStream();
			jasperPrint = JasperFillManager.fillReport(jasperReport,mapa, connection);
			JasperExportManager.exportReportToPdfFile(jasperPrint,rutaFuentesReportes+"\\desglose30Abril\\pdf\\ReporteAFavor.pdf");
			li.add(new File(rutaFuentesReportes+"\\desglose30Abril\\pdf\\ReporteAFavor.pdf"));
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\desglose30Abril\\CalificacionEquipo.jrxml");
			outStream = response.getOutputStream();
			jasperPrint = JasperFillManager.fillReport(jasperReport,mapa, connection);
			JasperExportManager.exportReportToPdfFile(jasperPrint,rutaFuentesReportes+"\\desglose30Abril\\pdf\\CalificacionEquipo.pdf");
			//li.add(new File(rutaFuentesReportes+"\\desglose30Abril\\pdf\\CalificacionEquipo.pdf"));
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\desglose30Abril\\edoMex reporte a favor indecisos.jrxml");
			outStream = response.getOutputStream();
			jasperPrint = JasperFillManager.fillReport(jasperReport,mapa, connection);
			JasperExportManager.exportReportToPdfFile(jasperPrint,rutaFuentesReportes+"\\desglose30Abril\\pdf\\ReporteAFavorIndecisos.pdf");
			li.add(new File(rutaFuentesReportes+"\\desglose30Abril\\pdf\\ReporteAFavorIndecisos.pdf"));
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\desglose30Abril\\edoMex reporte en Contra.jrxml");
			outStream = response.getOutputStream();
			jasperPrint = JasperFillManager.fillReport(jasperReport,mapa, connection);
			JasperExportManager.exportReportToPdfFile(jasperPrint,rutaFuentesReportes+"\\desglose30Abril\\pdf\\ReporteEnContra.pdf");
			li.add(new File(rutaFuentesReportes+"\\desglose30Abril\\pdf\\ReporteEnContra.pdf"));
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\desglose30Abril\\edoMex reporte indecisos en Contra.jrxml");
			outStream = response.getOutputStream();
			jasperPrint = JasperFillManager.fillReport(jasperReport,mapa, connection);
			JasperExportManager.exportReportToPdfFile(jasperPrint,rutaFuentesReportes+"\\desglose30Abril\\pdf\\ReporteIndecisosEnContra.pdf");
			li.add(new File(rutaFuentesReportes+"\\desglose30Abril\\pdf\\ReporteIndecisosEnContra.pdf"));
			
			logger.debug("Antes de comprimir: {}", li.toString());
			zipFile(li, rutaFuentesReportes+"\\desglose30Abril\\Desglose30Abril.zip");
			filePathToBeServed =rutaFuentesReportes+"\\desglose30Abril\\Desglose30Abril.zip";// complete
			nombreArchivo = "Desglose30Abril.zip";
			fileToDownload = new File(filePathToBeServed);
			inputStream = new FileInputStream(fileToDownload);
			response.setHeader("Content-Type", "application/force-download");
			response.setHeader("Content-Disposition", "inline; filename=\"" + nombreArchivo + "\"");
			IOUtils.copy(inputStream, response.getOutputStream());
			inputStream.close();
			filePathToBeServed = "";
			nombreArchivo = "";
			response.flushBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.close();
	}
	
	@RequestMapping(value = "/reportes/promotores.aspx", method = { RequestMethod.POST, RequestMethod.GET })
	public void promotores(HttpServletRequest request, HttpServletResponse response) throws JRException{
	
		JasperReport jasperReport;
		HashMap<String, Object> mapa;
		List<Object> listado;
		List<HashMap<String, Object>> descuentos, listadoEnvio;
		jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Promotores.jrxml");
		//String rutaFuentesReportes;
		
		//rutaFuentesReportes=request.getSession().getServletContext().getRealPath("/resources/fuentesReportes/");
		
		mapa = new HashMap<>();
		listado = new ArrayList<>();
		 Connection connection = null;
		/*crear conexion a la base */
		 try {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
	       
		/**/
		
		/**/
		HashMap<String, Object> map;	
		
		listadoEnvio = new ArrayList<>();
		//int val=0;
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Promotores.jrxml");
		
			
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapa, connection);
			 
				response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ResultadoRespuestasAvance.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					//JasperExportManager.exportReportToPdfFile(jasperPrint,
					//		rutaFuentesReportes+"\\" + parametrosRecibo.getBoleta().getId()  + ".pdf");
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	//@RequestMapping(value = "/reportes/Promovidos.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoMovilizados2(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
	
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		logger.debug("parametros : {}", parametros);
		 try {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		HashMap<String, Object> map;
		 map = new HashMap<>();

		 map.put("movilizador", parametros.getMovilizador().getId());
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Promovidos.jrxml");
			logger.debug("MAP : {}",  map);
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ListadoPromovidos.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	@RequestMapping(value = "/reportes/Promovidos.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoMovilizados(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> map;
		MovilizadorEO movilizador;
		List<MovilizadoEO> listado;
		map = new HashMap<>();	
		
		movilizador = new MovilizadorEO();
		movilizador =  parametrosPromovidos.getMovilizador();
		logger.debug("Promovidos : {}"+movilizador);
		listado =  new ArrayList<>();
		listado=sqlSession.selectList("diaD.movilizado.listadoPorMovilizador2", movilizador.getId());
		
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Promovidos.jrxml");
			logger.debug("Promovidos : {}"+listado);
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, beanCollection);
			 
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=ListadoPromovidos.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					logger.debug(e.getMessage());
					e.printStackTrace();
				}
			   parametrosPromovidos.setMovilizador(null);; 
	}
	
	@RequestMapping(value = "/reportes/PromovidosOrdenFolio.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoMovilizadosPorFolio(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> map;
		 map = new HashMap<>();	
	
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Promovidos_Orden.jrxml");
			//logger.debug("MAP : {}",  parametrosPromovidos.getMovilizador());
			logger.debug("MAPa : "+parametrosPromovidos.getMovilizador());
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(parametrosPromovidos.getMovilizador().getListadoMovilizado(), false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, beanCollection);
			 
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=ListadoPromovidosPorFolio.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					logger.debug(e.getMessage());
					e.printStackTrace();
				}
	}
	
	
	@RequestMapping(value = "/reportes/PromovidosOrdenNombre.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoMovilizadosPorNombre(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> map;
		 map = new HashMap<>();	
	
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\Promovidos_Orden.jrxml");
			//logger.debug("MAP : {}",  parametrosPromovidos.getMovilizador());
			logger.debug("MAPa : "+parametrosPromovidos.getMovilizador());
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(parametrosPromovidos.getMovilizador().getListadoMovilizado(), false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, beanCollection);
			 
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=ListadoPromovidosPorNombre.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					logger.debug(e.getMessage());
					e.printStackTrace();
				}
	}
	
	@RequestMapping(value = "/reportes/PromovidosFoliosOrdenFolio.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoMovilizadosFoliosPorFolio(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> map;
		 map = new HashMap<>();	
	
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\PromovidosFolio.jrxml");
			//logger.debug("MAP : {}",  parametrosPromovidos.getMovilizador());
			logger.debug("MAPa : "+parametrosPromovidos.getMovilizador());
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(parametrosPromovidos.getMovilizador().getListadoMovilizado(), false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, beanCollection);
			 
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=ListadoPromovidosFoliosPorFolio.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					logger.debug(e.getMessage());
					e.printStackTrace();
				}
	}
	
	@RequestMapping(value = "/reportes/PromovidosFoliosOrdenNombre.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoMovilizadosFoliosPorNombre(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> map;
		 map = new HashMap<>();	
	
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\PromovidosFolio.jrxml");
			//logger.debug("MAP : {}",  parametrosPromovidos.getMovilizador());
			logger.debug("MAPa : "+parametrosPromovidos.getMovilizador());
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(parametrosPromovidos.getMovilizador().getListadoMovilizado(), false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, beanCollection);
			 
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=ListadoPromovidosFoliosPorNombre.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					logger.debug(e.getMessage());
					e.printStackTrace();
				}
	}
	
	
	@RequestMapping(value = "/reportes/activistas.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoActivistas(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
		HashMap<String, Object> map;
		 map = new HashMap<>();	
	
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\ActivistasNuevo.jrxml");
			logger.debug("MAP : {}",  parametrosActivistas.getListadoMovilizador());
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(parametrosActivistas.getListadoMovilizador(), false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, beanCollection);
			 
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=ListadoActivistas.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					logger.debug(e.getMessage());
					e.printStackTrace();
				}
		
	}
	
	
	
	@RequestMapping(value = "/reportes/movilizadores.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoMovilizadores(HttpServletRequest request, HttpServletResponse response) throws JRException{
		JasperReport jasperReport;
	
		List<Object> listado = new ArrayList<>();
		Connection connection = null;
		logger.debug("parametros : {}", parametros);
		 try {
			
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
		HashMap<String, Object> map;
		 	map = new HashMap<>();

		 	map.put("nombre", parametros.getSeccional().getNombre()+" "+parametros.getSeccional().getPrimerApellido()+" "+parametros.getSeccional().getSegundoApellido());
		 	map.put("direccion", parametros.getSeccional().getCalle()+" "+parametros.getSeccional().getNumeroExterior()+" "+parametros.getSeccional().getNumeroInterior()+" "+parametros.getSeccional().getColonia()+" "+parametros.getSeccional().getCodigoPostal());
		 	map.put("seccion", parametros.getSeccional().getSeccion().getIdSeccion());
		 	
		 	jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\movilizador.jrxml");
			logger.debug("MAP : {}",  map);
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(listado, false); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, connection);
			 
			response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "inline; filename=ListadoMovilizadores.pdf");

			    try {
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	

	@RequestMapping(value = "/reportes/municipiosPendientes.pdf", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoPendientes(HttpServletRequest request, HttpServletResponse response) throws JRException{
			JasperReport jasperReport;
			Connection connection = null;
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://189.206.156.140:5432/politik?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", "politik", "re6UFruC_eDr");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return;
			}
			HashMap<String, Object> map  = new HashMap<>();	
			if (parametrosReportesMunicipios.getSeccion()!=null) {
				jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\faltan_por_votar_seccion.jrxml");
				map.put("seccion", parametrosReportesMunicipios.getSeccion());
			}
			else{
				jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\faltan_por_votar.jrxml");
			}
			map.put("id_municipio", parametrosReportesMunicipios.getMunicipio().getIdMunicipio());
			map.put("programa", parametrosReportesMunicipios.getPrograma());
			logger.debug("MAP : {}",  map);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, connection);
			 
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=ListadoPendientesPorMunicipios.pdf");
		    try {
				final OutputStream outStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);				
			} catch (IOException e) {
				logger.debug(e.getMessage());
				e.printStackTrace();
			}		
	}
}
