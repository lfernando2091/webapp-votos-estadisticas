package com.saganet.politik.components.diaD.prep;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.faces.context.FacesContext;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.utilidades.Poligono;
import mx.com.saganet.peon.database.dominios.TiposPoligonoDO;
import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.map.MapModel;
import javax.faces.application.FacesMessage;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;
import com.saganet.politik.database.diaD.prep.PrepEO;
import com.saganet.politik.database.diaD.prep.PrepReporteEO;
import com.saganet.politik.database.diaD.prep.PrepReporteMunicipioEO;
import com.saganet.politik.components.catalogos.MunicipiosC;
import com.saganet.politik.components.diaD.MovilizadosC;
import com.saganet.politik.components.sig.PoligonosC;
import com.saganet.politik.database.catalogos.SeccionEO;
import org.springframework.beans.factory.annotation.Autowired;


@Component("DiaDPrepC")
public class PrepC {

	private static final Logger logger = LoggerFactory.getLogger(MovilizadosC.class);
	
	@Autowired SqlSession sqlSession;
	@Autowired PoligonosC poligonosC;
	@Autowired MunicipiosC municipiosC;
	
	public Modelo<PrepEO> modelo(SeccionEO seccion){
		List<PrepEO> listado=sqlSession.selectList("diaD.prep.prep.listado",seccion);
		return new Modelo<>(listado);
	}

	public void actualizar(PrepEO prep) {
		FacesContext context = FacesContext.getCurrentInstance();
		logger.debug("actualizar : {}",prep);
		if(prep.getListadoNominal()<prep.getVotosTotales()){		
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:", "LA CASILLA NO SE PUEDE ACTUALIZAR, LOS VOTOS SOBRE PASAN EL LISTADO NOMINAL"));
		}
		else {
			context.addMessage(null, new FacesMessage("Actualizada:", "LA CASILLA SE ACTUALIZO CORRECTAMENTE"));
			sqlSession.update("diaD.prep.prep.actualizar", prep);	
		}		
	}
	
	public PrepReporteEO reporte(){
		PrepReporteEO reporte=sqlSession.selectOne("diaD.prep.prep.listadoReporte");
		return reporte;
	}
	
	

	public BarChartModel generaGrafica(PrepReporteEO seleccionado){
		BarChartModel model = new BarChartModel();
		if (seleccionado.getPan()!=null) {
			ChartSeries pan = new ChartSeries();
			pan.setLabel("PAN");
			pan.set("Partido", seleccionado.getPan());  
			ChartSeries total_pri_pvem_panal_pes = new ChartSeries();
			total_pri_pvem_panal_pes.setLabel("PRI-PVEM-PANAL-PES");
			total_pri_pvem_panal_pes.set("Partido", seleccionado.getTotal_pri_pvem_panal_pes());  
			ChartSeries prd = new ChartSeries();
			prd.setLabel("PRD");
			prd.set("Partido", seleccionado.getPrd()); 
			ChartSeries pt = new ChartSeries();
			pt.setLabel("PT");
			pt.set("Partido", seleccionado.getPt()); 
			ChartSeries morena = new ChartSeries();
			morena.setLabel("MORENA");
			morena.set("Partido", seleccionado.getMorena()); 
			ChartSeries independiente = new ChartSeries();
			independiente.setLabel("INDEPENDIENTE");
			independiente.set("Partido", seleccionado.getIndependiente()); 
			
	        model.addSeries(pan);  
	        model.addSeries(total_pri_pvem_panal_pes);   
	        model.addSeries(prd);  
	        model.addSeries(pt);  
	        model.addSeries(morena);  
	        model.addSeries(independiente);  
	        
	        model.setLegendPosition("ne");       
	        model.setAnimate(true);
	        model.setShowPointLabels(true);
	        model.setMouseoverHighlight(false);
	        model.setShowDatatip(false);
		    model.setTitle("AVANCE DE VOTACION ENTIDAD"); 			
				
	        /*  Axis xAxis = model.getAxis(AxisType.X);
	        xAxis.setLabel("Gender");*/
	        model.setSeriesColors("2C44BC,D90404,E4BE28,E48C28,7D1290,B6B9BA");
	        Axis yAxis = model.getAxis(AxisType.Y);
	        yAxis.setLabel("N� Votos");
	        yAxis.setTickFormat("%01d");
	        yAxis.setMin(0);
	        if (seleccionado.getPan()>=seleccionado.getTotal_pri_pvem_panal_pes() && seleccionado.getPan()>=seleccionado.getPrd() && seleccionado.getPan()>=seleccionado.getPt()
	        	 && seleccionado.getPan()>=seleccionado.getMorena() && seleccionado.getPan()>=seleccionado.getIndependiente()) {
	            yAxis.setMax(seleccionado.getPan()+(seleccionado.getPan()*.10));
			}
	        else if(seleccionado.getTotal_pri_pvem_panal_pes()>=seleccionado.getPrd() && seleccionado.getTotal_pri_pvem_panal_pes()>=seleccionado.getPt()
	        	 && seleccionado.getTotal_pri_pvem_panal_pes()>=seleccionado.getMorena() && seleccionado.getTotal_pri_pvem_panal_pes()>=seleccionado.getIndependiente()) {
	            yAxis.setMax(seleccionado.getTotal_pri_pvem_panal_pes()+(seleccionado.getTotal_pri_pvem_panal_pes()*.10));
			}
	        else if(seleccionado.getPrd()>=seleccionado.getPt() && seleccionado.getPrd()>=seleccionado.getMorena() && seleccionado.getPrd()>=seleccionado.getIndependiente()) {
	               yAxis.setMax(seleccionado.getPrd()+(seleccionado.getPrd()*.10));
	   		}
	        else if(seleccionado.getPt()>=seleccionado.getMorena() && seleccionado.getPt()>=seleccionado.getIndependiente()) {
	            yAxis.setMax(seleccionado.getPt()+(seleccionado.getPt()*.10));
			}
	        else if(seleccionado.getMorena()>=seleccionado.getIndependiente()) {
	            yAxis.setMax(seleccionado.getMorena()+(seleccionado.getMorena()*.10));
			}
	        else{
	            yAxis.setMax(seleccionado.getIndependiente()+(seleccionado.getIndependiente()*.10));
	        }
		}
		return model;
	}
	
	
	public Modelo<PrepReporteMunicipioEO> modeloMunicipios(){
		List<PrepReporteMunicipioEO> listado=sqlSession.selectList("diaD.prep.prep.listadoMunicipios");
		logger.debug("Listado : {} ",listado);
		return new Modelo<>(listado);
	}
	

	public void generarMapa(RequestContext rc){
		HashMap<String, Object> 		viewScope;
		Modelo<PrepReporteMunicipioEO> 	modelo;
		MapModel 						modeloMapa;
		List<Poligono> 					poligonos;
		Poligono 						poligono;
		
		viewScope = (HashMap<String, Object>) rc.getViewScope().asMap();
		modelo = modeloMunicipios();
		viewScope.put("modelo", modelo);

		logger.debug("modelo : {} ",modelo);
		poligonos = new ArrayList<>();
		
		poligono = new Poligono();
		poligono.setTipo(TiposPoligonoDO.ENTIDAD);
		poligono.setLlave("15");
		poligono.setOpacidadRelleno(0);
		poligono.setGrosorLinea(2);
		poligono.setOpacidadLinea(1);
		poligonos.add(poligono);
		
		for(PrepReporteMunicipioEO resultado : modelo.getListado()){
			if (resultado.getIndependiente()+resultado.getMorena()+resultado.getPan()+resultado.getPrd()+resultado.getPri()+resultado.getPt()!=0) {
				poligono = new Poligono();
				poligono.setTipo(TiposPoligonoDO.MUNICIPIO);
				poligono.setLlave(resultado.getMunicipio().getLlave());
				poligono.setOpacidadRelleno(0.5);
				switch (resultado.getGanador()) {
					case PAN:
						poligono.setColorRelleno("BLUE");
					break;
					case PRI:
						poligono.setColorRelleno("RED");
					break;
					case PRD:
						poligono.setColorRelleno("YELLOW");
					break;
					case PT:
						poligono.setColorRelleno("ORANGE");
					break;
					case MORENA:
						poligono.setColorRelleno("PURPLE");
					break;
					case INDEPENDIENTE:
						poligono.setColorRelleno("GRAY");
					break;
					default:break;
				}

				poligonos.add(poligono);
			}
		}
		modeloMapa = poligonosC.modeloMapa(poligonos);		
		viewScope.put("modeloMapa", modeloMapa);		
		viewScope.put("width", 500);
		viewScope.put("height", 500);
	}
}
