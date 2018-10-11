package com.saganet.politik.component_dm.estadisticas;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database_dm.estadisticas.ResultadosEncuestasEO;
import com.saganet.politik.modelos.Modelo;

@Component("ResultadosEncuestasC")
public class ResultadosEncuestasC {
	
	@Autowired
	SqlSession sqlSessionDM;
	
	@Autowired
	SqlSession sqlSession;

	@Autowired
	ServletContext servletContext;
	
	private static final Logger logger = LoggerFactory.getLogger(ResultadosEncuestasC.class);
	
	public Modelo<ResultadosEncuestasEO> listado(String fechaInicio, String fechaFin){
		Modelo<ResultadosEncuestasEO> modelo=new Modelo<>();
		List<ResultadosEncuestasEO> listado=new ArrayList<>();
		HashMap<String, Object> params = new HashMap<>();
		logger.debug("Fecha Inicio: {} Fecha Fin: {}",fechaInicio,fechaFin);
		if (fechaInicio!=null && fechaFin!=null) {
			params.put("fechaInicio", fechaInicio);
			params.put("fechaFin", fechaFin);
		}
		logger.debug("MAPA : {}",params);
		listado = sqlSessionDM.selectList("estadisticas.resultados_encuestas.selectContestadas", params);
		if (!listado.isEmpty()) {
			modelo.setSeleccionado(listado.get(0));
			logger.debug("Seleccionado de Resultados Encuestas: {}", listado.get(0));
		}
		modelo.setListado(listado);
		return modelo;
	}
	
	public Date getFecha(){
		return new Date();
	}
	
	public String combierteDateToString(Date fecha){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String result = df.format(fecha);
		logger.debug("fecha: {}", result);
		return result;
	}
	
	public UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	

	public String generarReporteCOPY(String fechaInicio, String fechaFin) {
		StringBuilder rutaArchivo;
		StringBuilder rutaArchivo2;
		String primeraNombre;
		
		HashMap<String, Object> parametros;
		parametros = new HashMap<String, Object>();

		if (fechaFin!=null && fechaInicio!=null) {
			parametros.put("fechaInicio", fechaInicio);
			parametros.put("fechaFin", fechaFin);
			logger.debug("fechaInicio: {}, fechaFin: {}", fechaInicio,fechaFin);
			primeraNombre=new String("Reporte_Encuestas_del_"+fechaInicio.replace("-", "_")+"_al_"+fechaFin.replace("-", "_"));
		}
		else {
			primeraNombre=new String("Reporte_Encuestas_Completo");
		}
		
		rutaArchivo = new StringBuilder("E:/ReporteEncuestas/");
		rutaArchivo.append(primeraNombre);
		rutaArchivo.append("_");
		rutaArchivo.append(getUsuario().getNick());
		rutaArchivo.append(".csv");
		parametros.put("ruta", rutaArchivo.toString());
		


		logger.debug("ruta: {}",rutaArchivo.toString());
		
		sqlSessionDM.update("estadisticas.resultados_encuestas.copyReporte", parametros);
		

		rutaArchivo2 = new StringBuilder("resources/reportesGenerados/");
		rutaArchivo2.append(primeraNombre);
		rutaArchivo2.append("_");
		rutaArchivo2.append(getUsuario().getNick());
		rutaArchivo2.append(".csv"); 
		
		File archivo=new File(rutaArchivo.toString());
		archivo.renameTo(new File(servletContext.getRealPath(rutaArchivo2.toString())));

		return archivo.getName();
	}
	
	
	public String generarReporte(String fechaInicio, String fechaFin) {
		StringBuilder rutaArchivo;
		String primeraNombre;
		File archivo;
		//Formateador formateador;
		//java.sql.Date fecha;
		FileOutputStream fos;
		Workbook libro;
		Sheet hoja;
		Row fila;
		int iCelda, iFila;
		HashMap<String, Object> parametros;
		List<ResultadosEncuestasEO> reporte;
		List<String> headers;
		reporte = new ArrayList<>();
		parametros = new HashMap<String, Object>();
		headers = new ArrayList<String>();
		//formateador = new Formateador();
		//fecha = new java.sql.Date(new java.util.Date().getTime());

		if (fechaFin!=null && fechaInicio!=null) {
			parametros.put("fechaInicio", fechaInicio);
			parametros.put("fechaFin", fechaFin);
			logger.debug("fechaInicio: {}, fechaFin: {}", fechaInicio,fechaFin);
			primeraNombre=new String("Reporte_Encuestas_del_"+fechaInicio.replace("-", "_")+"_al_"+fechaFin.replace("-", "_"));
		}
		else {

			primeraNombre=new String("Reporte_Encuestas_Completo");
		}
		
		rutaArchivo = new StringBuilder("resources/reportesGenerados/");
		rutaArchivo.append(primeraNombre);
		rutaArchivo.append("_");
		rutaArchivo.append(getUsuario().getNick());
		rutaArchivo.append(".xlsx");
		archivo = new File(servletContext.getRealPath(rutaArchivo.toString()));


		try {
			fos = new FileOutputStream(archivo);
			libro = new XSSFWorkbook();
			hoja = libro.createSheet(primeraNombre);

			headers.add("fecha_enc");
			headers.add("validador");
			headers.add("region");
			headers.add("dtto");
			headers.add("mpio");
			headers.add("zona");
			headers.add("secc");
			headers.add("id");
			headers.add("programa");
			headers.add("sexo");
			headers.add("edad");
			headers.add("Se_enc?");
			headers.add("1_Cred_Elec");
			headers.add("2_Pa�s");
			headers.add("2_Edo_Mex");
			headers.add("2_Mpio");
			headers.add("3_calf_econ_act");
			headers.add("4_calf_pol_act");
			headers.add("5_sit_econ_prx");
			headers.add("6_sit_pol_prx");
			headers.add("7_med_not");
			headers.add("8_med_utilz");
			headers.add("9_part_identf");
			headers.add("10_gem_dif");
			headers.add("11_part_nunc_vot");
			headers.add("12_gem_vot");
			headers.add("13_gem_pri_pan");
			headers.add("14_gem_pri_prd");
			headers.add("15_apy_gfed");
			headers.add("16_EPN_cump");
			headers.add("17_satfapy_EPN");
			headers.add("18_apy_mej_ing");
			headers.add("19_solc_otr_apy");
			headers.add("20_inf_prog_fed_?");
			headers.add("21_cel");
			headers.add("21_correo");
			headers.add("22_pte_mx");
			headers.add("22_gob");
			headers.add("22_pte_mpal");
			headers.add("23_anavp_esc");
			headers.add("23_anavp_opin");
			headers.add("23_aencinr_esc");
			headers.add("23_aencinr_opin");
			headers.add("23_enema_esc");
			headers.add("23_enema_opin");
			headers.add("23_jvzqzm_esc");
			headers.add("23_jvzqzm_opin");
			headers.add("23_jmanzq_esc");
			headers.add("23_jmanzq_opin");
			headers.add("23_ypolvnk_esc");
			headers.add("23_ypolvnk_opin");
			headers.add("23_lvidgy_esc");
			headers.add("23_lvidgy_opin");
			headers.add("23_amazom_esc");
			headers.add("23_amazom_opin");
			headers.add("23_alilha_esc");
			headers.add("23_alilha_opin");
			headers.add("23_carmm_esc");
			headers.add("23_carmm_opin");

			reporte = sqlSessionDM.selectList("estadisticas.resultados_encuestas.selectSinLimit", parametros);

			// Llenar Reporte
			// Headers
			iFila = 0;
			fila = hoja.createRow(iFila++);
			iCelda = 0;
			for (String header : headers) {
				fila.createCell(iCelda++).setCellValue(header);
			}

			// Datos
			for (ResultadosEncuestasEO dato : reporte) {
				fila = hoja.createRow(iFila++);
				iCelda = 0;
				fila.createCell(iCelda++).setCellValue(dato.getFechaEnc());
				fila.createCell(iCelda++).setCellValue(dato.getValidador());
				fila.createCell(iCelda++).setCellValue(dato.getRegion());
				fila.createCell(iCelda++).setCellValue(dato.getDtto());
				fila.createCell(iCelda++).setCellValue(dato.getMpio());
				fila.createCell(iCelda++).setCellValue(dato.getZona());
				fila.createCell(iCelda++).setCellValue(dato.getSecc());
				fila.createCell(iCelda++).setCellValue(dato.getId());
				fila.createCell(iCelda++).setCellValue(dato.getPrograma());
				fila.createCell(iCelda++).setCellValue(dato.getSexo());
				fila.createCell(iCelda++).setCellValue(dato.getEdad());
				fila.createCell(iCelda++).setCellValue(dato.getSeEnc());
				fila.createCell(iCelda++).setCellValue(dato.get_1CredElec());
				fila.createCell(iCelda++).setCellValue(dato.get_2Pa�s());	
				fila.createCell(iCelda++).setCellValue(dato.get_2EdoMex());	
				fila.createCell(iCelda++).setCellValue(dato.get_2Mpio());	
				fila.createCell(iCelda++).setCellValue(dato.get_3CalfEconAct());
				fila.createCell(iCelda++).setCellValue(dato.get_4CalfPolAct());
				fila.createCell(iCelda++).setCellValue(dato.get_5SitEconPrx());
				fila.createCell(iCelda++).setCellValue(dato.get_6SitPolPrx());
				fila.createCell(iCelda++).setCellValue(dato.get_7MedNot());
				fila.createCell(iCelda++).setCellValue(dato.get_8MedUtilz());
				fila.createCell(iCelda++).setCellValue(dato.get_9PartIdentf());
				fila.createCell(iCelda++).setCellValue(dato.get_10GemDif());
				fila.createCell(iCelda++).setCellValue(dato.get_11PartNuncVot());
				fila.createCell(iCelda++).setCellValue(dato.get_12GemVot());	
				fila.createCell(iCelda++).setCellValue(dato.get_13GemPRI_PAN());
				fila.createCell(iCelda++).setCellValue(dato.get_14GemPRI_PRD());
				fila.createCell(iCelda++).setCellValue(dato.get_15ApyGfed());
				fila.createCell(iCelda++).setCellValue(dato.get_16EPNcump());
				fila.createCell(iCelda++).setCellValue(dato.get_17SatfapyEPN());
				fila.createCell(iCelda++).setCellValue(dato.get_18ApyMejIng());
				fila.createCell(iCelda++).setCellValue(dato.get_19SolcOtrApy());
				fila.createCell(iCelda++).setCellValue(dato.get_20InfProgFed());
				fila.createCell(iCelda++).setCellValue(dato.get_21Cel());
				fila.createCell(iCelda++).setCellValue(dato.get_21Correo());
				fila.createCell(iCelda++).setCellValue((dato.get_22PteMx()!=null?dato.get_22PteMx().toString():""));
				fila.createCell(iCelda++).setCellValue((dato.get_22Gob()!=null?dato.get_22Gob().toString():""));
				fila.createCell(iCelda++).setCellValue((dato.get_22PteMpal()!=null?dato.get_22PteMpal().toString():""));
				fila.createCell(iCelda++).setCellValue(dato.get_23AnavpEsc());
				fila.createCell(iCelda++).setCellValue(dato.get_23AnavpOpin());
				fila.createCell(iCelda++).setCellValue(dato.get_23AencinrEsc());
				fila.createCell(iCelda++).setCellValue(dato.get_23AencinrOpin());
				fila.createCell(iCelda++).setCellValue(dato.get_23EnemaEsc());	
				fila.createCell(iCelda++).setCellValue(dato.get_23EnemaOpin());
				fila.createCell(iCelda++).setCellValue(dato.get_23JvzqzmEsc());
				fila.createCell(iCelda++).setCellValue(dato.get_23JvzqzmOpin());
				fila.createCell(iCelda++).setCellValue(dato.get_23JmanzqEsc());
				fila.createCell(iCelda++).setCellValue(dato.get_23JmanzqOpin());
				fila.createCell(iCelda++).setCellValue(dato.get_23YpolvnkEsc());
				fila.createCell(iCelda++).setCellValue(dato.get_23YpolvnkOpin());
				fila.createCell(iCelda++).setCellValue(dato.get_23LvidgyEsc());
				fila.createCell(iCelda++).setCellValue(dato.get_23LvidgyOpin());
				fila.createCell(iCelda++).setCellValue(dato.get_23AmazomEsc());
				fila.createCell(iCelda++).setCellValue(dato.get_23AmazomOpin());
				fila.createCell(iCelda++).setCellValue(dato.get_23AlilhaEsc());
				fila.createCell(iCelda++).setCellValue(dato.get_23AlilhaOpin());
				fila.createCell(iCelda++).setCellValue(dato.get_23CarmmEsc());
				fila.createCell(iCelda++).setCellValue(dato.get_23CarmmOpin());
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
