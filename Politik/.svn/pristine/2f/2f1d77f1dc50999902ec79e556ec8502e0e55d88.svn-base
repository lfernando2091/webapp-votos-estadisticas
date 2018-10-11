package com.saganet.politik.components.encuestas.edomex2017.v2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.encuestas.edomex2017.v2.ReporteRangoEdadEO;
import com.saganet.politik.dominios.NivelesReporteDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.Modelo;

@Component("EncuestaEdomex2017V2ReporteRangoEdadC")
public class ReporteRangoEdadC {
@Autowired
SqlSession sqlSession;

private static final Logger logger = LoggerFactory.getLogger(ReporteRangoEdadC.class);

	public Modelo<ReporteRangoEdadEO> modelo(NivelesReporteDO nivel, ProgramasEdoMexDO programa){
		List<ReporteRangoEdadEO> listado;
		HashMap<String, Object> variables;
		listado =  new ArrayList<>();
		variables =  new HashMap<>();
		variables.put("nivel", nivel.toString());
		variables.put("programa", programa.toString());
		logger.debug("variables: {}",variables);
		listado = sqlSession.selectList("encuestas.edomex2017.rangoEdades.listado", variables);

		return new Modelo<>(listado);
	}
	
	public HashMap<String, Object> subtotal(List<ReporteRangoEdadEO> rangos){
		HashMap<String, Object> mapa;
		DecimalFormat f = new DecimalFormat("#0.00");
		
		mapa = new HashMap<>();
		Integer tedad3164Exitosas=0;
		Integer tedad3164aFavor=0;
		String tedad3164aFavorPorcentaje="";
		Integer tedad3164IndecisosAFavor=0;
		String tedad3164IndecisosAFavorPorcentaje="";
		Integer tedad3164Indecisos=0;
		String tedad3164IndecisosPorcentaje="";
		Integer tedad3164IndecisosEnContra=0;
		String tedad3164IndecisosEnContraPorcentaje="";
		Integer tedad3164EnContra=0;
		String tedad3164EnContraPorcentaje="";

		
		Integer tedad1830Exitosas=0;
		Integer tedad1830aFavor=0;
		String tedad1830aFavorPorcentaje="";
		Integer tedad1830IndecisosAFavor=0;
		String tedad1830IndecisosAFavorPorcentaje="";
		Integer tedad1830Indecisos=0;
		String tedad1830IndecisosPorcentaje="";
		Integer tedad1830IndecisosEnContra=0;
		String tedad1830IndecisosEnContraPorcentaje="";
		Integer tedad1830EnContra=0;
		String tedad1830EnContraPorcentaje="";

		Integer tedad65masExitosas=0;
		Integer tedad65masaFavor=0;
		String tedad65masaFavorPorcentaje="";
		Integer tedad65masIndecisosAFavor=0;
		String tedad65masIndecisosAFavorPorcentaje="";
		Integer tedad65masIndecisos=0;
		String tedad65masIndecisosPorcentaje="";
		Integer tedad65masIndecisosEnContra=0;
		String tedad65masIndecisosEnContraPorcentaje="";
		Integer tedad65masEnContra=0;
		String tedad65masEnContraPorcentaje="";

		
		for (ReporteRangoEdadEO reporte : rangos) {
			tedad1830Exitosas = tedad1830Exitosas + reporte.getEdad1830Exitosas();
			
			tedad1830aFavor = tedad1830aFavor + reporte.getEdad1830aFavor();
			tedad1830IndecisosAFavor = tedad1830IndecisosAFavor + reporte.getEdad1830IndecisosAFavor();
			tedad1830Indecisos = tedad1830Indecisos + reporte.getEdad1830Indecisos();
			tedad1830IndecisosEnContra = tedad1830IndecisosEnContra + reporte.getEdad1830IndecisosEnContra();
			tedad1830EnContra = tedad1830EnContra + reporte.getEdad1830EnContra();
		
			
			tedad3164Exitosas = tedad3164Exitosas + reporte.getEdad1830Exitosas();
			
			tedad3164aFavor = tedad3164aFavor + reporte.getEdad1830aFavor();
			tedad3164aFavorPorcentaje = f.format((double)Math.round(((tedad3164aFavor.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
			tedad3164IndecisosAFavor = tedad3164IndecisosAFavor + reporte.getEdad1830IndecisosAFavor();
			tedad3164IndecisosAFavorPorcentaje = f.format((double)Math.round(((tedad3164IndecisosAFavor.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
			tedad3164Indecisos = tedad3164Indecisos + reporte.getEdad1830Indecisos();
			tedad3164IndecisosPorcentaje = f.format((double)Math.round(((tedad3164Indecisos.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
			tedad3164IndecisosEnContra = tedad3164IndecisosEnContra + reporte.getEdad1830IndecisosEnContra();
			tedad3164IndecisosEnContraPorcentaje = f.format((double)Math.round(((tedad3164IndecisosEnContra.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
			tedad3164EnContra = tedad3164EnContra + reporte.getEdad1830EnContra();
			tedad3164EnContraPorcentaje = f.format((double)Math.round(((tedad3164EnContra.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
			
			
			tedad65masExitosas = tedad65masExitosas + reporte.getEdad1830Exitosas();
			
			tedad65masaFavor = tedad65masaFavor + reporte.getEdad1830aFavor();
			tedad65masaFavorPorcentaje = f.format((double)Math.round(((tedad65masaFavor.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
			tedad65masIndecisosAFavor = tedad65masIndecisosAFavor + reporte.getEdad1830IndecisosAFavor();
			tedad65masIndecisosAFavorPorcentaje = f.format((double)Math.round(((tedad65masIndecisosAFavor.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
			tedad65masIndecisos = tedad65masIndecisos + reporte.getEdad1830Indecisos();
			tedad65masIndecisosPorcentaje = f.format((double)Math.round(((tedad65masIndecisos.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
			tedad65masIndecisosEnContra = tedad65masIndecisosEnContra + reporte.getEdad1830IndecisosEnContra();
			tedad65masIndecisosEnContraPorcentaje = f.format((double)Math.round(((tedad65masIndecisosEnContra.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
			tedad65masEnContra = tedad65masEnContra + reporte.getEdad1830EnContra();
			tedad65masEnContraPorcentaje = f.format((double)Math.round(((tedad65masEnContra.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
		}
		
		tedad1830aFavorPorcentaje = f.format((double)Math.round(((tedad1830aFavor.doubleValue()/tedad1830Exitosas.doubleValue())*100)*100)/100)+"%";
		tedad1830IndecisosAFavorPorcentaje = f.format((double)Math.round(((tedad1830IndecisosAFavor.doubleValue()/tedad1830Exitosas.doubleValue())*100)*100)/100)+"%";
		tedad1830IndecisosPorcentaje = f.format((double)Math.round(((tedad1830Indecisos.doubleValue()/tedad1830Exitosas.doubleValue())*100)*100)/100)+"%";
		tedad1830IndecisosEnContraPorcentaje = f.format((double)Math.round(((tedad1830IndecisosEnContra.doubleValue()/tedad1830Exitosas.doubleValue())*100)*100)/100)+"%";
		tedad1830EnContraPorcentaje = f.format((double)Math.round(((tedad1830EnContra.doubleValue()/tedad1830Exitosas.doubleValue())*100)*100)/100)+"%";
		
		tedad3164aFavorPorcentaje = f.format((double)Math.round(((tedad3164aFavor.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
		tedad3164IndecisosAFavorPorcentaje = f.format((double)Math.round(((tedad3164IndecisosAFavor.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
		tedad3164IndecisosPorcentaje = f.format((double)Math.round(((tedad3164Indecisos.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
		tedad3164IndecisosEnContraPorcentaje = f.format((double)Math.round(((tedad3164IndecisosEnContra.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
		tedad3164EnContraPorcentaje = f.format((double)Math.round(((tedad3164EnContra.doubleValue()/tedad3164Exitosas.doubleValue())*100)*100)/100)+"%";
		
		
		tedad65masaFavorPorcentaje = f.format((double)Math.round(((tedad65masaFavor.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
		tedad65masIndecisosAFavorPorcentaje = f.format((double)Math.round(((tedad65masIndecisosAFavor.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
		tedad65masIndecisosPorcentaje = f.format((double)Math.round(((tedad65masIndecisos.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
		tedad65masIndecisosEnContraPorcentaje = f.format((double)Math.round(((tedad65masIndecisosEnContra.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
		tedad65masEnContraPorcentaje = f.format((double)Math.round(((tedad65masEnContra.doubleValue()/tedad65masExitosas.doubleValue())*100)*100)/100)+"%";
		
		mapa.put("tedad1830aFavorPorcentaje", tedad1830aFavorPorcentaje);
		mapa.put("tedad1830IndecisosAFavorPorcentaje", tedad1830IndecisosAFavorPorcentaje);
		mapa.put("tedad1830IndecisosPorcentaje", tedad1830IndecisosPorcentaje);
		mapa.put("tedad1830IndecisosEnContraPorcentaje",tedad1830IndecisosEnContraPorcentaje );
		mapa.put("tedad1830EnContraPorcentaje", tedad1830EnContraPorcentaje);
		
		mapa.put("tedad1830aFavor", tedad1830aFavor);
		mapa.put("tedad1830IndecisosAFavor", tedad1830IndecisosAFavor);
		mapa.put("tedad1830Indecisos", tedad1830Indecisos);
		mapa.put("tedad1830IndecisosEnContra",tedad1830IndecisosEnContra);
		mapa.put("tedad1830EnContra", tedad1830EnContra);
		
		mapa.put("tedad3164aFavorPorcentaje", tedad3164aFavorPorcentaje);
		mapa.put("tedad3164IndecisosAFavorPorcentaje", tedad3164IndecisosAFavorPorcentaje);
		mapa.put("tedad3164IndecisosPorcentaje", tedad3164IndecisosPorcentaje);
		mapa.put("tedad3164IndecisosEnContraPorcentaje",tedad3164IndecisosEnContraPorcentaje);
		mapa.put("tedad3164EnContraPorcentaje", tedad3164EnContraPorcentaje);
		
		mapa.put("tedad3164aFavor", tedad3164aFavor);
		mapa.put("tedad3164IndecisosAFavor", tedad3164IndecisosAFavor);
		mapa.put("tedad3164Indecisos", tedad3164Indecisos);
		mapa.put("tedad3164IndecisosEnContra",tedad3164IndecisosEnContra);
		mapa.put("tedad3164EnContra", tedad3164EnContra);
		
		
		mapa.put("tedad65masaFavorPorcentaje", tedad65masaFavorPorcentaje);
		mapa.put("tedad65masIndecisosAFavorPorcentaje", tedad65masIndecisosAFavorPorcentaje);
		mapa.put("tedad65masIndecisosPorcentaje", tedad65masIndecisosPorcentaje);
		mapa.put("tedad65masIndecisosEnContraPorcentaje",tedad65masIndecisosEnContraPorcentaje );
		mapa.put("tedad65masEnContraPorcentaje", tedad65masEnContraPorcentaje);
		
		mapa.put("tedad65masaFavor", tedad65masaFavor);
		mapa.put("tedad65masIndecisosAFavor", tedad65masIndecisosAFavor);
		mapa.put("tedad65masIndecisos", tedad65masIndecisos);
		mapa.put("tedad65masIndecisosEnContra",tedad65masIndecisosEnContra);
		mapa.put("tedad65masEnContra", tedad65masEnContra);
		
		mapa.put("tedad1830Exitosas", tedad1830Exitosas);
		mapa.put("tedad3164Exitosas", tedad3164Exitosas);
		mapa.put("tedad65masExitosas", tedad65masExitosas);
		logger.debug("Mapa de Resultados: {}", mapa);
		return mapa;
	}
}
