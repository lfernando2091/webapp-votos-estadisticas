package com.saganet.politik.beans.reportes;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

@ManagedBean
public class DescargarArchivosBean {

	 private StreamedContent file;
	 private static final String rutaFuentesReportes="E:\\Politik\\FuentesReportes";
	 
	 
	 public DescargarArchivosBean() { 
		 JasperReport jasperReport;
		 try {
			jasperReport = JasperCompileManager.compileReport(rutaFuentesReportes+"\\graficaEstadisticas.jrxml");
			
			
			 InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/botones/AGREGAR.png");
				file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		}

	    public StreamedContent getEventosPDF() {
	        return file;
	    }
}
