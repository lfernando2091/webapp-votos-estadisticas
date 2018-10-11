package com.saganet.politik.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saganet.politik.database.diaD.MovilizadoEO;
import com.saganet.politik.database.diaD.MovilizadorEO;
import com.saganet.politik.utilidades.ParametrosPDF;

import net.sf.jasperreports.engine.JRException;
@Controller
public class AsignacionesController {
@Autowired ParametrosPDF parametros;
	
	private static final Logger logger = LoggerFactory.getLogger(AsignacionesController.class);
	
	@RequestMapping(value = "/reportes/promovidos.xls", method = { RequestMethod.POST, RequestMethod.GET })
	public void listadoMovilizados(HttpServletRequest request, HttpServletResponse response) throws JRException, FileNotFoundException{
		MovilizadoEO movilizado;
		MovilizadorEO activista;
		 HSSFWorkbook workbook = new HSSFWorkbook();
		 HSSFSheet sheet = workbook.createSheet();
		 workbook.setSheetName(0, "Hoja excel");
		 
		 movilizado = parametros.getModeloPromovidos().getSeleccionado();
		 activista = parametros.getActivista();
		 Class clase = MovilizadoEO.class;
		 Field[] atributos = clase.getFields();
		 logger.debug("Atributos: {}", parametros.getModeloPromovidos().getSeleccionado());
		 String[] headers = new String[]{
				    "Sección",
		            "Folio",
		            "Nombre",
		            "Apellido Paterno",
		            "Apellido Materno",
		            "Domicilio",
		            "Telefono",
		            "Email",
		            "R",
		            "C"
		        };
		        CellStyle headerStyle = workbook.createCellStyle();
		        Font font = workbook.createFont();
		        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		        headerStyle.setFont(font);

		        CellStyle style = workbook.createCellStyle();
		        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		        style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		        HSSFRow headerRow = sheet.createRow(0);
		        for (int i = 0; i < headers.length; ++i) {
		            String header = headers[i];
		            HSSFCell cell = headerRow.createCell(i);
		            cell.setCellStyle(headerStyle);
		            cell.setCellValue(header);
		        }
           int f;
           f=0;
           for(MovilizadoEO mov : parametros.getModeloPromovidos().getListado()){
        	   HSSFRow dataRow = sheet.createRow(f + 1); 
        	   dataRow.createCell(0).setCellValue(activista.getNombre());
        	   dataRow.createCell(1).setCellValue(activista.getCalle());
        	   dataRow.createCell(2).setCellValue(activista.getSeccion().toString());
        	   dataRow.createCell(3).setCellValue("");
        	   dataRow.createCell(4).setCellValue(mov.getSeccion());
        	   dataRow.createCell(5).setCellValue(mov.getFolio());
	           dataRow.createCell(6).setCellValue(mov.getNombre()+ " " + mov.getPrimerApellido() + " "  + mov.getSegundoApellido());
	           dataRow.createCell(7).setCellValue(mov.getPrimerApellido());
	           dataRow.createCell(8).setCellValue(mov.getSegundoApellido());
	           dataRow.createCell(9).setCellValue(mov.getDomicilio());
	           dataRow.createCell(10).setCellValue(mov.getTelefono());
	           dataRow.createCell(11).setCellValue(mov.getEmail());
	           dataRow.createCell(12).setCellValue(mov.getCalificacion()==null?"":mov.getCalificacion().getNombre());
	           dataRow.createCell(13).setCellValue(mov.getPadron()==false&&mov.isDirecto()==false?"E":mov.getPadron()==true?"P":mov.isDirecto()==true?"D":"");
	           f++;
           }
		       /* for (int i = 0; i < data.length; ++i) {
		            HSSFRow dataRow = sheet.createRow(i + 1);

		            Object[] d = data[i];
		            String product = (String) d[0];
		            BigDecimal price = (BigDecimal) d[1];
		            String link = (String) d[2];

		            dataRow.createCell(0).setCellValue(product);
		            dataRow.createCell(1).setCellValue(price.doubleValue());
		            dataRow.createCell(2).setCellValue(link);
		        }*/

		        HSSFRow dataRow = sheet.createRow(1 + parametros.getModeloPromovidos().getListado().size());
		       // HSSFCell total = dataRow.createCell(1);
		      ////  total.setCellType(Cell.CELL_TYPE_FORMULA);
		      //  total.setCellStyle(style);
		      //  total.setCellFormula(String.format("SUM(B2:B%d)", 1 + data.length));

		        FileOutputStream file;
				try {
					file = new FileOutputStream("E:\\workbook.xls");
					  workbook.write(file);
					  file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
		       
	}
}
