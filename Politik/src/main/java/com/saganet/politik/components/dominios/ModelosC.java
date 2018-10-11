package com.saganet.politik.components.dominios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.dominios.BuenaRegularMaloDO;
import com.saganet.politik.dominios.BuenaRegularMaloNoReciboDO;
import com.saganet.politik.dominios.BuenaRegularNadaDO;
import com.saganet.politik.dominios.CandidatosEdomex2017DO;
import com.saganet.politik.dominios.CandidatosPartidosEedomex2017DO;
import com.saganet.politik.dominios.CargosEstructuraDO;
import com.saganet.politik.dominios.DiaDBusquedasDO;
import com.saganet.politik.dominios.GenerosDO;
import com.saganet.politik.dominios.GobiernosDO;
import com.saganet.politik.dominios.HorariosDO;
import com.saganet.politik.dominios.IncidenciasEstatusDO;
import com.saganet.politik.dominios.IncidenciasPrioridadDO;
import com.saganet.politik.dominios.MuchoRegularNadaDO;
import com.saganet.politik.dominios.NivelReporteCompletoDO;
import com.saganet.politik.dominios.NivelesReporteDO;
import com.saganet.politik.dominios.NivelesReporteVerticalDO;
import com.saganet.politik.dominios.PartidosEleccionEdomex2017DO;
import com.saganet.politik.dominios.ProgramaFuerzaCiudadanaDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.dominios.ResultadoEncuestaEdomexDO;
import com.saganet.politik.dominios.ResultadoEntrevistaEntrevistadorDO;
import com.saganet.politik.dominios.SiNoDO;
import com.saganet.politik.dominios.SiNoNSNCDO;
import com.saganet.politik.modelos.Modelo;



@Component("DominiosModelosC")
public class ModelosC {

	
	private static final Logger logger = LoggerFactory.getLogger(ModelosC.class);

	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

	public IncidenciasEstatusDO incidenciasEstatusResuelta(){
		return IncidenciasEstatusDO.RESUELTO;
	}
	public Modelo<IncidenciasEstatusDO> incidenciasEstatus2(){
		return new Modelo<>(Arrays.asList(IncidenciasEstatusDO.values()));
	}
	
	public Modelo<IncidenciasEstatusDO> incidenciasEstatus(){
		IncidenciasEstatusDO[] arreglo=new IncidenciasEstatusDO[3];
		arreglo[0]=IncidenciasEstatusDO.PENDIENTE;
		arreglo[1]=IncidenciasEstatusDO.XINFORMATIVA;
		arreglo[2]=IncidenciasEstatusDO.RESUELTO;
		return new Modelo<>(Arrays.asList(arreglo));
	}
	
	public Modelo<IncidenciasPrioridadDO> incidenciasPrioridad(){
		IncidenciasPrioridadDO[] arreglo=new IncidenciasPrioridadDO[3];
		arreglo[0]=IncidenciasPrioridadDO.XBAJA;
		arreglo[1]=IncidenciasPrioridadDO.MEDIA;
		arreglo[2]=IncidenciasPrioridadDO.ALTA;
		return new Modelo<>(Arrays.asList(arreglo));
	}

	public Modelo<DiaDBusquedasDO> diaDBusquedas(){
		return new Modelo<>(Arrays.asList(DiaDBusquedasDO.values()));
	}
	
	public Modelo<NivelesReporteDO> nivelesReporte(){
		switch (getUsuario().getNivel()) {
			case MUNICIPIO:
				NivelesReporteDO[] arreglo=new NivelesReporteDO[2];
				arreglo[0]=NivelesReporteDO.MUNICIPIO;
				arreglo[1]=NivelesReporteDO.SECCION;
				return new Modelo<>(Arrays.asList(arreglo));
			case GEOZONA:
				return  new Modelo<>(Arrays.asList(NivelesReporteDO.values()));
			case ENTIDAD:
				return  new Modelo<>(Arrays.asList(NivelesReporteDO.values()));
			case NACIONAL:
				return  new Modelo<>(Arrays.asList(NivelesReporteDO.values()));
			default:
				return  new Modelo<>(new ArrayList<NivelesReporteDO>());
		}		
	}
	
	
	public Modelo<NivelesReporteDO> nivelesReporte2(){
		switch (getUsuario().getNivel()) {
		case MUNICIPIO:
			NivelesReporteDO[] arreglo=new NivelesReporteDO[1];
			arreglo[0]=NivelesReporteDO.MUNICIPIO;
			return new Modelo<>(Arrays.asList(arreglo));
		case GEOZONA:
			NivelesReporteDO[] arreglo2=new NivelesReporteDO[2];
			arreglo2[0]=NivelesReporteDO.REGION;
			arreglo2[1]=NivelesReporteDO.MUNICIPIO;
			return new Modelo<>(Arrays.asList(arreglo2));
		case NACIONAL:
			NivelesReporteDO[] arreglo3=new NivelesReporteDO[2];
			arreglo3[0]=NivelesReporteDO.REGION;
			arreglo3[1]=NivelesReporteDO.MUNICIPIO;
			return new Modelo<>(Arrays.asList(arreglo3));
		default:
			return  new Modelo<>(new ArrayList<NivelesReporteDO>());
		}
	}

	
	public Modelo<NivelesReporteVerticalDO> nivelesReporte5(){
		switch (getUsuario().getNivel()) {
		case MUNICIPIO:
			NivelesReporteVerticalDO[] arreglo=new NivelesReporteVerticalDO[1];
			arreglo[0]=NivelesReporteVerticalDO.MUNICIPIO;
			return new Modelo<>(Arrays.asList(arreglo));
		case GEOZONA:
			NivelesReporteVerticalDO[] arreglo3=new NivelesReporteVerticalDO[2];
			arreglo3[0]=NivelesReporteVerticalDO.REGION;
			arreglo3[1]=NivelesReporteVerticalDO.MUNICIPIO;
			return new Modelo<>(Arrays.asList(arreglo3));
		default:
			NivelesReporteVerticalDO[] arreglo1=new NivelesReporteVerticalDO[3];
			arreglo1[0]=NivelesReporteVerticalDO.ESTATAL;
			arreglo1[1]=NivelesReporteVerticalDO.REGION;
			arreglo1[2]=NivelesReporteVerticalDO.MUNICIPIO;
			return new Modelo<>(Arrays.asList(arreglo1));
		}
	}

	public Modelo<NivelReporteCompletoDO> nivelesReporte3(){
		switch (getUsuario().getNivel()) {
			case MUNICIPIO:
				NivelReporteCompletoDO[] arreglo=new NivelReporteCompletoDO[2];
				arreglo[0]=NivelReporteCompletoDO.MUNICIPIO;
				arreglo[1]=NivelReporteCompletoDO.SECCION;
				return new Modelo<>(Arrays.asList(arreglo));
			case GEOZONA:
				return  new Modelo<>(Arrays.asList(NivelReporteCompletoDO.values()));
			case ENTIDAD:
				return  new Modelo<>(Arrays.asList(NivelReporteCompletoDO.values()));
			case NACIONAL:
				return  new Modelo<>(Arrays.asList(NivelReporteCompletoDO.values()));
			default:
				return  new Modelo<>(new ArrayList<NivelReporteCompletoDO>());
		}		
	}
	
	public Modelo<ProgramaFuerzaCiudadanaDO> programasFuerzaCiudadana(){
		return  new Modelo<>(getUsuario().getProgamas2());
	}
	
	public Modelo<ProgramasEdoMexDO> programasEdoMex(){
		logger.debug("listado ProgramasEdoMexDO�USER : {}",getUsuario().getProgamas());
		return  new Modelo<>(getUsuario().getProgamas());
	}
	
	public Modelo<ProgramasEdoMexDO> programasEdoMex2(){
		logger.debug("listado ProgramasEdoMexDO�USER : {}",getUsuario().getProgamas());
		List<ProgramasEdoMexDO> listado=new ArrayList<>();
		if(getUsuario().getProgamas()!=null){
		for (ProgramasEdoMexDO programa : getUsuario().getProgamas()) {
			if (!programa.equals(ProgramasEdoMexDO.PROSPERA)) {
				listado.add(programa);
			}
		}
		}
		return new Modelo<>(listado);
	}
	public Modelo<ProgramasEdoMexDO> programasEdoMex3(){
		logger.debug("listado ProgramasEdoMexDO�USER : {}",getUsuario().getProgamas());
		List<ProgramasEdoMexDO> listado=new ArrayList<>();
		if(getUsuario().getProgamas()!=null){
		for (ProgramasEdoMexDO programa : getUsuario().getProgamas()) {
			
				listado.add(programa);
			
		}
		}
		return new Modelo<>(listado);
	}
	
	
	public Modelo<SiNoDO>  sino(){
		 Modelo<SiNoDO> modelo;
		 List<SiNoDO> listado;
		 listado= Arrays.asList(SiNoDO.values());	
		 logger.debug("Listado {}",listado);
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	
	
	public Modelo<MuchoRegularNadaDO>  muchoRegularNada(){
		 Modelo<MuchoRegularNadaDO> modelo;
		 List<MuchoRegularNadaDO> listado;
		 listado= Arrays.asList(MuchoRegularNadaDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	public Modelo<BuenaRegularNadaDO>  buenaRegularNada(){
		 Modelo<BuenaRegularNadaDO> modelo;
		 List<BuenaRegularNadaDO> listado;
		 listado= Arrays.asList(BuenaRegularNadaDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	public Modelo<ResultadoEncuestaEdomexDO>  modeloResultadoEncuesta(){
		 Modelo<ResultadoEncuestaEdomexDO> modelo;
		 List<ResultadoEncuestaEdomexDO> listado;
		 listado= Arrays.asList(ResultadoEncuestaEdomexDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	public Modelo<ResultadoEncuestaEdomexDO>  modeloResultadoEncuestaNo(){
		 List<ResultadoEncuestaEdomexDO> listado= new ArrayList<>();	
		 for (ResultadoEncuestaEdomexDO resultadoEncuestaEdomexDO : Arrays.asList(ResultadoEncuestaEdomexDO.values())) {
			if (!resultadoEncuestaEdomexDO.equals(ResultadoEncuestaEdomexDO.EXITOSO)) {
				listado.add(resultadoEncuestaEdomexDO);
			}
		}
		return new Modelo<>(listado);
	}
	
	public Modelo<ResultadoEntrevistaEntrevistadorDO>  modeloResultadoEntrevistaEntrevistador(){
		 Modelo<ResultadoEntrevistaEntrevistadorDO> modelo;
		 List<ResultadoEntrevistaEntrevistadorDO> listado;
		 listado= Arrays.asList(ResultadoEntrevistaEntrevistadorDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	
	public Modelo<GobiernosDO>  modeloGobierno(){
		 Modelo<GobiernosDO> modelo;
		 List<GobiernosDO> listado;
		 listado= Arrays.asList(GobiernosDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	public Modelo<BuenaRegularMaloDO>  modeloBuenoRegularMalo(){
		 Modelo<BuenaRegularMaloDO> modelo;
		 List<BuenaRegularMaloDO> listado;
		 listado= Arrays.asList(BuenaRegularMaloDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	public Modelo<BuenaRegularMaloNoReciboDO>  modeloBuenoRegularMaloNoRecibo(){
		 Modelo<BuenaRegularMaloNoReciboDO> modelo;
		 List<BuenaRegularMaloNoReciboDO> listado;
		 listado= Arrays.asList(BuenaRegularMaloNoReciboDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	
	public Modelo<SiNoNSNCDO>  modeloSiNoNsNc(){
		 Modelo<SiNoNSNCDO> modelo;
		 List<SiNoNSNCDO> listado;
		 listado= Arrays.asList(SiNoNSNCDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	public Modelo<PartidosEleccionEdomex2017DO>  modeloPartidosEdomex(){
		 Modelo<PartidosEleccionEdomex2017DO> modelo;
		 List<PartidosEleccionEdomex2017DO> listado;
		 listado= Arrays.asList(PartidosEleccionEdomex2017DO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	
	public Modelo<CandidatosEdomex2017DO>  modeloCandidatosEdomex(){
		 Modelo<CandidatosEdomex2017DO> modelo;
		 List<CandidatosEdomex2017DO> listado;
		 listado= Arrays.asList(CandidatosEdomex2017DO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	
	
	public Modelo<CandidatosPartidosEedomex2017DO>  modeloCandidadtosPartidosEdomex(){
		 Modelo<CandidatosPartidosEedomex2017DO> modelo;
		 List<CandidatosPartidosEedomex2017DO> listado;
		 listado= Arrays.asList(CandidatosPartidosEedomex2017DO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	
	public Modelo<GenerosDO>  modeloGenero(){
		 Modelo<GenerosDO> modelo;
		 List<GenerosDO> listado;
		 listado= Arrays.asList(GenerosDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	
	
	public Modelo<CargosEstructuraDO>  modeloCargoEstructura(){
		 Modelo<CargosEstructuraDO> modelo;
		 List<CargosEstructuraDO> listado;
		 listado= Arrays.asList(CargosEstructuraDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	
	public Modelo<HorariosDO>  modeloHorarios(){
		 Modelo<HorariosDO> modelo;
		 List<HorariosDO> listado;
		 listado= Arrays.asList(HorariosDO.values());			
		 modelo =  new Modelo<>(listado);
		return modelo;
	}
	
	
	
}
