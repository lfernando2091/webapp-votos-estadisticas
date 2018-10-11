package com.saganet.politik.components.encuestas.hermanos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
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
import com.saganet.politik.dominios.NivelesReporteDO;
import com.saganet.politik.dominios.NivelesReporteVerticalDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.database.encuestas.hermanos.ResultadoEncuestaCompletoEO;
import com.saganet.politik.database.encuestas.hermanos.ResultadoEncuestaCompletoVerticalEO;

@Component("HermanosResultadoEncuestasCompleto")
public class ResultadoEncuestasCompletoC {
	@Autowired
	SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(ResultadoEncuestasCompletoC.class);

	public Modelo<ResultadoEncuestaCompletoEO> modelo(NivelesReporteDO nivel) {
		Modelo<ResultadoEncuestaCompletoEO> tabla;
		List<ResultadoEncuestaCompletoEO> listado=new ArrayList<>();
		HashMap<String, Object> mapa=new HashMap<>();
		mapa.put("programas", getUsuario().getProgamas2());
		UsuarioEO usuario=getUsuario();
		if (usuario.getTerritorios()!=null) {
			switch (usuario.getNivel()) {
				case GEOZONA:
					List<GeozonaParticionEO> geozonasParticiones=new ArrayList<>();
					logger.debug("Territorio : {} ", usuario.getTerritorios());
					for (JavaBeanT geozona : usuario.getTerritorios()) {
						geozonasParticiones.add((GeozonaParticionEO)geozona);
					} 
					mapa.put("regiones",geozonasParticiones);
				break;
				default:
				break;
			}
		}
		if (nivel!=null) {
			switch (nivel) {
				case REGION:
					listado=sqlSession.selectList("encuestas.hermanos.resultadoEncuestasCompletos.resultadoRegionPrograma",mapa);			
				break;
				case MUNICIPIO:
					listado=sqlSession.selectList("encuestas.hermanos.resultadoEncuestasCompletos.resultadoMunicipioPrograma",mapa);
				break;
				case SECCION:
					listado=sqlSession.selectList("encuestas.hermanos.resultadoEncuestasCompletos.resultadoSeccionPrograma",mapa);
				break;
			}
		}
		tabla=new Modelo<>(listado);
		return tabla;
	}
		
	public ResultadoEncuestaCompletoEO filaTotales(Modelo<ResultadoEncuestaCompletoEO> modelo){
		ResultadoEncuestaCompletoEO total=new ResultadoEncuestaCompletoEO();		
		total.setExitoso(0);
		total.setMenorDeEdad(0);
		total.setNoHuboQuienContestara(0);
		total.setNoQuisieronContestar(0);
		total.setDomicilioNoEncontrado(0);
		total.setOtro(0);		
		total.setTotal(0);
		total.setTotalTotal(0);
		total.setMeta(0);
		
		for (ResultadoEncuestaCompletoEO actual : modelo.getListado()) {
			total.setExitoso(total.getExitoso()+actual.getExitoso());
			total.setMenorDeEdad(total.getMenorDeEdad()+actual.getMenorDeEdad());
			total.setNoHuboQuienContestara(total.getNoHuboQuienContestara()+actual.getNoHuboQuienContestara());
			total.setNoQuisieronContestar(total.getNoQuisieronContestar()+actual.getNoQuisieronContestar());
			total.setDomicilioNoEncontrado(total.getDomicilioNoEncontrado()+actual.getDomicilioNoEncontrado());
			total.setOtro(total.getOtro()+actual.getOtro());			
			total.setTotal(total.getTotal()+actual.getTotal());
			total.setTotalTotal(total.getTotalTotal()+actual.getTotalTotal());
			total.setMeta(total.getMeta()+actual.getMeta());			
		}
		return total;
	}
	
	public BarChartModel generaGrafica(ResultadoEncuestaCompletoEO seleccionado, NivelesReporteDO nivel){
		BarChartModel model = new BarChartModel();
		ChartSeries completadas = new ChartSeries();
        completadas.setLabel("Completadas");
        completadas.set("Estatus", (seleccionado!=null?seleccionado.getExitoso():0));
        ChartSeries noHuboQuienContestara = new ChartSeries();
        noHuboQuienContestara.setLabel("No Hubo Quien Contestara");
        noHuboQuienContestara.set("Estatus", (seleccionado!=null?seleccionado.getNoHuboQuienContestara():0));
        ChartSeries menorDeEdad = new ChartSeries();
        menorDeEdad.setLabel("Menor De Edad");
        menorDeEdad.set("Estatus", (seleccionado!=null?seleccionado.getMenorDeEdad():0));
        ChartSeries domicilioNoEncontrado = new ChartSeries();
        domicilioNoEncontrado.setLabel("Domicilio No Encontrado");
        domicilioNoEncontrado.set("Estatus", (seleccionado!=null?seleccionado.getDomicilioNoEncontrado():0));
        ChartSeries noQuisieronContestar = new ChartSeries();
        noQuisieronContestar.setLabel("No Quisieron Contestar");
        noQuisieronContestar.set("Estatus", (seleccionado!=null?seleccionado.getNoQuisieronContestar():0));
        ChartSeries otro = new ChartSeries();
        otro.setLabel("Otro");
        otro.set("Estatus", (seleccionado!=null?seleccionado.getOtro():0));
        model.addSeries(completadas); 
        model.addSeries(noHuboQuienContestara);  
        model.addSeries(menorDeEdad);  
        model.addSeries(domicilioNoEncontrado);  
        model.addSeries(noQuisieronContestar);  
        model.addSeries(otro);        
        model.setLegendPosition("ne");
        switch (nivel) {
			case REGION:
		        model.setTitle("Región : "+(seleccionado!=null?seleccionado.getNombreRegion():"")); 			
			break;
			case MUNICIPIO:
		        model.setTitle("Municipio : "+(seleccionado!=null?seleccionado.getNombreMunicipio():"")); 			
			break;
			case SECCION:
		        model.setTitle("Sección :"+(seleccionado!=null?seleccionado.getSeccion():"")); 			
			break;
		} 
        model.setSeriesColors("3DC946,D5AC15,549F8E,103769,AA0B08,B6B9BA");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("N° Encuestas");
        yAxis.setMin(0);
        Integer maximo=0;
        if (seleccionado!=null) {
            if (maximo<seleccionado.getExitoso()) {
    			maximo=seleccionado.getExitoso();
    		}
            if (maximo<seleccionado.getNoHuboQuienContestara()) {
    			maximo=seleccionado.getNoHuboQuienContestara();
    		}
            if (maximo<seleccionado.getMenorDeEdad()) {
    			maximo=seleccionado.getMenorDeEdad();
    		}
            if (maximo<seleccionado.getDomicilioNoEncontrado()) {
    			maximo=seleccionado.getDomicilioNoEncontrado();
    		}
            if (maximo<seleccionado.getNoQuisieronContestar()) {
    			maximo=seleccionado.getNoQuisieronContestar();
    		}
            if (maximo<seleccionado.getOtro()) {
    			maximo=seleccionado.getOtro();
    		}   
		}  
        yAxis.setMax(maximo);
		return model;
	}
	
	public Modelo<ResultadoEncuestaCompletoVerticalEO> modeloVertical(NivelesReporteVerticalDO nivel, GeozonaParticionEO region, MunicipioEO municipio) {
		List<ResultadoEncuestaCompletoEO> listado=new ArrayList<>();
		if (nivel!=null) {
			HashMap<String, Object> mapa=new HashMap<>();
			mapa.put("programas", getUsuario().getProgamas2());
			if (nivel.equals(NivelesReporteVerticalDO.REGION)) {
				List<GeozonaParticionEO> geozonasParticiones=new ArrayList<>();
				geozonasParticiones.add(region);
				mapa.put("regiones",geozonasParticiones);
			}
			if (nivel.equals(NivelesReporteVerticalDO.MUNICIPIO)) {
				List<MunicipioEO> municipios=new ArrayList<>();
				municipios.add(municipio);
				mapa.put("municipios",municipios);
			}
			listado=sqlSession.selectList("encuestas.hermanos.resultadoEncuestasCompletos.resultadoRegionPrograma",mapa);	
		}
		List<ResultadoEncuestaCompletoVerticalEO> listadoVertical=new ArrayList<>();
		DecimalFormat numero = new DecimalFormat("#,##0");
		
		ResultadoEncuestaCompletoEO total=new ResultadoEncuestaCompletoEO();				
		total.setExitoso(0);
		total.setMenorDeEdad(0);
		total.setNoHuboQuienContestara(0);
		total.setNoQuisieronContestar(0);
		total.setDomicilioNoEncontrado(0);
		total.setOtro(0);		
		total.setTotal(0);
		total.setTotalTotal(0);
		total.setMeta(0);		
		
		for (ResultadoEncuestaCompletoEO actual : listado) {	
			total.setTotal(total.getTotal()+actual.getTotal());
			total.setTotalTotal(total.getTotalTotal()+actual.getTotalTotal());
			total.setMeta(total.getMeta()+actual.getMeta());			
		}
		ResultadoEncuestaCompletoVerticalEO nuevo=new ResultadoEncuestaCompletoVerticalEO();
		nuevo.setId(0);
		nuevo.setNombre("Meta de Levantamiento");		
		nuevo.setCantidadTotal(numero.format(total.getTotalTotal()));
		nuevo.setPorcentajeTotal("100%");
		listadoVertical.add(nuevo);
		
		nuevo=new ResultadoEncuestaCompletoVerticalEO();
		nuevo.setId(1);
		nuevo.setNombre("Encuestas Esperadas");
		nuevo.setCantidadTotal(numero.format(total.getMeta()));
		nuevo.setPorcentajeTotal(total.getPorcentajeMeta());
		listadoVertical.add(nuevo);
		
		nuevo=new ResultadoEncuestaCompletoVerticalEO();
		nuevo.setId(2);
		nuevo.setNombre("Encuestas Aplicadas");
		nuevo.setCantidadTotal(numero.format(total.getTotal()));
		nuevo.setPorcentajeTotal(total.getPorcentajeTotal());
		listadoVertical.add(nuevo);
		
		return new Modelo<>(listadoVertical);
	}
	
	public Modelo<NivelesReporteVerticalDO> modeloNiveles() {
		List<NivelesReporteVerticalDO> listado=new ArrayList<>();
		switch (getUsuario().getNivel()) {
			case ENTIDAD:
				 listado.add(NivelesReporteVerticalDO.ESTATAL);
				 listado.add(NivelesReporteVerticalDO.REGION);
				 listado.add(NivelesReporteVerticalDO.MUNICIPIO);	
			break;
			case NACIONAL:
				 listado.add(NivelesReporteVerticalDO.ESTATAL);
				 listado.add(NivelesReporteVerticalDO.REGION);
				 listado.add(NivelesReporteVerticalDO.MUNICIPIO);				
			break;
			case GEOZONA:
				 listado.add(NivelesReporteVerticalDO.REGION);	
				 listado.add(NivelesReporteVerticalDO.MUNICIPIO);			
			break;
			case MUNICIPIO:
				 listado.add(NivelesReporteVerticalDO.MUNICIPIO);		
			break;
			default:
			break;
		}
		return new Modelo<>(listado);
	}

	
	public Modelo<GeozonaParticionEO> modeloRegiones() {
		List<GeozonaParticionEO> listado=new ArrayList<>();
		switch (getUsuario().getNivel()) {
			case ENTIDAD:
				GeozonaEO geozona=sqlSession.selectOne("catalogos.geozonas.porId",4);
				listado.addAll(geozona.getParticiones());
			break;
			case NACIONAL:
				GeozonaEO geozona2=sqlSession.selectOne("catalogos.geozonas.porId",4);
				listado.addAll(geozona2.getParticiones());
			break;
			case GEOZONA:
				logger.debug("Territorio : {} ", getUsuario().getTerritorios());
				for (JavaBeanT geozonap : getUsuario().getTerritorios()) {
					listado.add((GeozonaParticionEO)geozonap);
				} 		
			break;
			default:
			break;
		}
		
		return new Modelo<>(listado);
	}
	
	
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

}
