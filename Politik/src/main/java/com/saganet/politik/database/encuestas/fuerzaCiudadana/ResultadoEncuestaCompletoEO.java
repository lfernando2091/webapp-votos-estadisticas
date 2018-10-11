package com.saganet.politik.database.encuestas.fuerzaCiudadana;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.apache.ibatis.type.Alias;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("FuerzaCiudadanaResultadoEncuestaCompletoEO")
public class ResultadoEncuestaCompletoEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 2198549554059215572L;

	private DecimalFormat f = new DecimalFormat("#0.00");
	
	private Integer id;
	private Integer entidad;
	private Integer numRegion;
	private Integer region;
	private String nombreRegion;
	private Integer numMunicipio;
	private Integer municipio;
	private String nombreMunicipio;
	private Integer seccion;
	private Integer numSeccion;

	///////////////////////////////////// Total //////////////////////////////////////////////////
	
	private Integer exitoso;
	private Integer noHuboQuienContestara;
	private Integer menorDeEdad;
	private Integer domicilioNoEncontrado;
	private Integer noQuisieronContestar;
	private Integer otro;

	private String porcentajeExitoso;
	private String porcentajeNoHuboQuienContestara;
	private String porcentajeMenorDeEdad;
	private String porcentajeDomicilioNoEncontrado;
	private String porcentajeNoQuisieronContestar;
	private String porcentajeOtro;
	
	private Integer total;
	private Integer totalTotal;
	private Integer meta;
	
	private String porcentajeTotal;
	private String porcentajeMeta;
	
	///////////////////////////////////// Negativo //////////////////////////////////////////////////

	private Integer exitosoNegativo;
	private Integer noHuboQuienContestaraNegativo;
	private Integer menorDeEdadNegativo;
	private Integer domicilioNoEncontradoNegativo;
	private Integer noQuisieronContestarNegativo;
	private Integer otroNegativo;

	private String porcentajeExitosoNegativo;
	private String porcentajeNoHuboQuienContestaraNegativo;
	private String porcentajeMenorDeEdadNegativo;
	private String porcentajeDomicilioNoEncontradoNegativo;
	private String porcentajeNoQuisieronContestarNegativo;
	private String porcentajeOtroNegativo;
	
	private Integer totalNegativo;
	private Integer totalTotalNegativo;
	private Integer metaNegativo;
	
	private String porcentajeTotalNegativo;
	private String porcentajeMetaNegativo;
	
	/////////////////////////////////////// Coordinadores ////////////////////////////////////////////////

	private Integer exitosoCoordinadores;
	private Integer noHuboQuienContestaraCoordinadores;
	private Integer menorDeEdadCoordinadores;
	private Integer domicilioNoEncontradoCoordinadores;
	private Integer noQuisieronContestarCoordinadores;
	private Integer otroCoordinadores;

	private String porcentajeExitosoCoordinadores;
	private String porcentajeNoHuboQuienContestaraCoordinadores;
	private String porcentajeMenorDeEdadCoordinadores;
	private String porcentajeDomicilioNoEncontradoCoordinadores;
	private String porcentajeNoQuisieronContestarCoordinadores;
	private String porcentajeOtroCoordinadores;
	
	private Integer totalCoordinadores;
	private Integer totalTotalCoordinadores;
	private Integer metaCoordinadores;
	
	private String porcentajeTotalCoordinadores;
	private String porcentajeMetaCoordinadores;
	
	@Override
	public String toString() {
		return "ResultadoEncuestaCompletoEO [id=" + id + ", entidad=" + entidad + ", numRegion=" + numRegion
				+ ", region=" + region + ", nombreRegion=" + nombreRegion + ", numMunicipio=" + numMunicipio
				+ ", municipio=" + municipio + ", nombreMunicipio=" + nombreMunicipio + ", seccion=" + seccion
				+ ", numSeccion=" + numSeccion + ", exitoso=" + exitoso + ", noHuboQuienContestara="
				+ noHuboQuienContestara + ", menorDeEdad=" + menorDeEdad + ", domicilioNoEncontrado="
				+ domicilioNoEncontrado + ", noQuisieronContestar=" + noQuisieronContestar + ", otro=" + otro
				+ ", porcentajeExitoso=" + porcentajeExitoso + ", porcentajeNoHuboQuienContestara="
				+ porcentajeNoHuboQuienContestara + ", porcentajeMenorDeEdad=" + porcentajeMenorDeEdad
				+ ", porcentajeDomicilioNoEncontrado=" + porcentajeDomicilioNoEncontrado
				+ ", porcentajeNoQuisieronContestar=" + porcentajeNoQuisieronContestar + ", porcentajeOtro="
				+ porcentajeOtro + ", total=" + total + ", totalTotal=" + totalTotal + ", meta=" + meta
				+ ", porcentajeTotal=" + porcentajeTotal + ", porcentajeMeta=" + porcentajeMeta + ", exitosoNegativo="
				+ exitosoNegativo + ", noHuboQuienContestaraNegativo=" + noHuboQuienContestaraNegativo
				+ ", menorDeEdadNegativo=" + menorDeEdadNegativo + ", domicilioNoEncontradoNegativo="
				+ domicilioNoEncontradoNegativo + ", noQuisieronContestarNegativo=" + noQuisieronContestarNegativo
				+ ", otroNegativo=" + otroNegativo + ", porcentajeExitosoNegativo=" + porcentajeExitosoNegativo
				+ ", porcentajeNoHuboQuienContestaraNegativo=" + porcentajeNoHuboQuienContestaraNegativo
				+ ", porcentajeMenorDeEdadNegativo=" + porcentajeMenorDeEdadNegativo
				+ ", porcentajeDomicilioNoEncontradoNegativo=" + porcentajeDomicilioNoEncontradoNegativo
				+ ", porcentajeNoQuisieronContestarNegativo=" + porcentajeNoQuisieronContestarNegativo
				+ ", porcentajeOtroNegativo=" + porcentajeOtroNegativo + ", totalNegativo=" + totalNegativo
				+ ", totalTotalNegativo=" + totalTotalNegativo + ", metaNegativo=" + metaNegativo
				+ ", porcentajeTotalNegativo=" + porcentajeTotalNegativo + ", porcentajeMetaNegativo="
				+ porcentajeMetaNegativo + ", exitosoCoordinadores=" + exitosoCoordinadores
				+ ", noHuboQuienContestaraCoordinadores=" + noHuboQuienContestaraCoordinadores
				+ ", menorDeEdadCoordinadores=" + menorDeEdadCoordinadores + ", domicilioNoEncontradoCoordinadores="
				+ domicilioNoEncontradoCoordinadores + ", noQuisieronContestarCoordinadores="
				+ noQuisieronContestarCoordinadores + ", otroCoordinadores=" + otroCoordinadores
				+ ", porcentajeExitosoCoordinadores=" + porcentajeExitosoCoordinadores
				+ ", porcentajeNoHuboQuienContestaraCoordinadores=" + porcentajeNoHuboQuienContestaraCoordinadores
				+ ", porcentajeMenorDeEdadCoordinadores=" + porcentajeMenorDeEdadCoordinadores
				+ ", porcentajeDomicilioNoEncontradoCoordinadores=" + porcentajeDomicilioNoEncontradoCoordinadores
				+ ", porcentajeNoQuisieronContestarCoordinadores=" + porcentajeNoQuisieronContestarCoordinadores
				+ ", porcentajeOtroCoordinadores=" + porcentajeOtroCoordinadores + ", totalCoordinadores="
				+ totalCoordinadores + ", totalTotalCoordinadores=" + totalTotalCoordinadores + ", metaCoordinadores="
				+ metaCoordinadores + ", porcentajeTotalCoordinadores=" + porcentajeTotalCoordinadores
				+ ", porcentajeMetaCoordinadores=" + porcentajeMetaCoordinadores + "]";
	}

	public Integer getExitosoNegativo() {
		return exitosoNegativo;
	}

	public void setExitosoNegativo(Integer exitosoNegativo) {
		this.exitosoNegativo = exitosoNegativo;
	}

	public Integer getNoHuboQuienContestaraNegativo() {
		return noHuboQuienContestaraNegativo;
	}

	public void setNoHuboQuienContestaraNegativo(Integer noHuboQuienContestaraNegativo) {
		this.noHuboQuienContestaraNegativo = noHuboQuienContestaraNegativo;
	}

	public Integer getMenorDeEdadNegativo() {
		return menorDeEdadNegativo;
	}

	public void setMenorDeEdadNegativo(Integer menorDeEdadNegativo) {
		this.menorDeEdadNegativo = menorDeEdadNegativo;
	}

	public Integer getDomicilioNoEncontradoNegativo() {
		return domicilioNoEncontradoNegativo;
	}

	public void setDomicilioNoEncontradoNegativo(Integer domicilioNoEncontradoNegativo) {
		this.domicilioNoEncontradoNegativo = domicilioNoEncontradoNegativo;
	}

	public Integer getNoQuisieronContestarNegativo() {
		return noQuisieronContestarNegativo;
	}

	public void setNoQuisieronContestarNegativo(Integer noQuisieronContestarNegativo) {
		this.noQuisieronContestarNegativo = noQuisieronContestarNegativo;
	}

	public Integer getOtroNegativo() {
		return otroNegativo;
	}

	public void setOtroNegativo(Integer otroNegativo) {
		this.otroNegativo = otroNegativo;
	}

	public String getPorcentajeExitosoNegativo() {
		return porcentajeExitosoNegativo;
	}

	public void setPorcentajeExitosoNegativo(String porcentajeExitosoNegativo) {
		this.porcentajeExitosoNegativo = porcentajeExitosoNegativo;
	}

	public String getPorcentajeNoHuboQuienContestaraNegativo() {
		return porcentajeNoHuboQuienContestaraNegativo;
	}

	public void setPorcentajeNoHuboQuienContestaraNegativo(String porcentajeNoHuboQuienContestaraNegativo) {
		this.porcentajeNoHuboQuienContestaraNegativo = porcentajeNoHuboQuienContestaraNegativo;
	}

	public String getPorcentajeMenorDeEdadNegativo() {
		return porcentajeMenorDeEdadNegativo;
	}

	public void setPorcentajeMenorDeEdadNegativo(String porcentajeMenorDeEdadNegativo) {
		this.porcentajeMenorDeEdadNegativo = porcentajeMenorDeEdadNegativo;
	}

	public String getPorcentajeDomicilioNoEncontradoNegativo() {
		return porcentajeDomicilioNoEncontradoNegativo;
	}

	public void setPorcentajeDomicilioNoEncontradoNegativo(String porcentajeDomicilioNoEncontradoNegativo) {
		this.porcentajeDomicilioNoEncontradoNegativo = porcentajeDomicilioNoEncontradoNegativo;
	}

	public String getPorcentajeNoQuisieronContestarNegativo() {
		return porcentajeNoQuisieronContestarNegativo;
	}

	public void setPorcentajeNoQuisieronContestarNegativo(String porcentajeNoQuisieronContestarNegativo) {
		this.porcentajeNoQuisieronContestarNegativo = porcentajeNoQuisieronContestarNegativo;
	}

	public String getPorcentajeOtroNegativo() {
		return porcentajeOtroNegativo;
	}

	public void setPorcentajeOtroNegativo(String porcentajeOtroNegativo) {
		this.porcentajeOtroNegativo = porcentajeOtroNegativo;
	}

	public String getPorcentajeTotalNegativo() {
		return porcentajeTotalNegativo;
	}

	public void setPorcentajeTotalNegativo(String porcentajeTotalNegativo) {
		this.porcentajeTotalNegativo = porcentajeTotalNegativo;
	}

	public String getPorcentajeMetaNegativo() {
		return porcentajeMetaNegativo;
	}

	public void setPorcentajeMetaNegativo(String porcentajeMetaNegativo) {
		this.porcentajeMetaNegativo = porcentajeMetaNegativo;
	}

	public Integer getExitosoCoordinadores() {
		return exitosoCoordinadores;
	}

	public void setExitosoCoordinadores(Integer exitosoCoordinadores) {
		this.exitosoCoordinadores = exitosoCoordinadores;
	}

	public Integer getNoHuboQuienContestaraCoordinadores() {
		return noHuboQuienContestaraCoordinadores;
	}

	public void setNoHuboQuienContestaraCoordinadores(Integer noHuboQuienContestaraCoordinadores) {
		this.noHuboQuienContestaraCoordinadores = noHuboQuienContestaraCoordinadores;
	}

	public Integer getMenorDeEdadCoordinadores() {
		return menorDeEdadCoordinadores;
	}

	public void setMenorDeEdadCoordinadores(Integer menorDeEdadCoordinadores) {
		this.menorDeEdadCoordinadores = menorDeEdadCoordinadores;
	}

	public Integer getDomicilioNoEncontradoCoordinadores() {
		return domicilioNoEncontradoCoordinadores;
	}

	public void setDomicilioNoEncontradoCoordinadores(Integer domicilioNoEncontradoCoordinadores) {
		this.domicilioNoEncontradoCoordinadores = domicilioNoEncontradoCoordinadores;
	}

	public Integer getNoQuisieronContestarCoordinadores() {
		return noQuisieronContestarCoordinadores;
	}

	public void setNoQuisieronContestarCoordinadores(Integer noQuisieronContestarCoordinadores) {
		this.noQuisieronContestarCoordinadores = noQuisieronContestarCoordinadores;
	}

	public Integer getOtroCoordinadores() {
		return otroCoordinadores;
	}

	public void setOtroCoordinadores(Integer otroCoordinadores) {
		this.otroCoordinadores = otroCoordinadores;
	}

	public String getPorcentajeExitosoCoordinadores() {
		return porcentajeExitosoCoordinadores;
	}

	public void setPorcentajeExitosoCoordinadores(String porcentajeExitosoCoordinadores) {
		this.porcentajeExitosoCoordinadores = porcentajeExitosoCoordinadores;
	}

	public String getPorcentajeNoHuboQuienContestaraCoordinadores() {
		return porcentajeNoHuboQuienContestaraCoordinadores;
	}

	public void setPorcentajeNoHuboQuienContestaraCoordinadores(String porcentajeNoHuboQuienContestaraCoordinadores) {
		this.porcentajeNoHuboQuienContestaraCoordinadores = porcentajeNoHuboQuienContestaraCoordinadores;
	}

	public String getPorcentajeMenorDeEdadCoordinadores() {
		return porcentajeMenorDeEdadCoordinadores;
	}

	public void setPorcentajeMenorDeEdadCoordinadores(String porcentajeMenorDeEdadCoordinadores) {
		this.porcentajeMenorDeEdadCoordinadores = porcentajeMenorDeEdadCoordinadores;
	}

	public String getPorcentajeDomicilioNoEncontradoCoordinadores() {
		return porcentajeDomicilioNoEncontradoCoordinadores;
	}

	public void setPorcentajeDomicilioNoEncontradoCoordinadores(String porcentajeDomicilioNoEncontradoCoordinadores) {
		this.porcentajeDomicilioNoEncontradoCoordinadores = porcentajeDomicilioNoEncontradoCoordinadores;
	}

	public String getPorcentajeNoQuisieronContestarCoordinadores() {
		return porcentajeNoQuisieronContestarCoordinadores;
	}

	public void setPorcentajeNoQuisieronContestarCoordinadores(String porcentajeNoQuisieronContestarCoordinadores) {
		this.porcentajeNoQuisieronContestarCoordinadores = porcentajeNoQuisieronContestarCoordinadores;
	}

	public String getPorcentajeOtroCoordinadores() {
		return porcentajeOtroCoordinadores;
	}

	public void setPorcentajeOtroCoordinadores(String porcentajeOtroCoordinadores) {
		this.porcentajeOtroCoordinadores = porcentajeOtroCoordinadores;
	}

	public String getPorcentajeTotalCoordinadores() {
		return porcentajeTotalCoordinadores;
	}

	public void setPorcentajeTotalCoordinadores(String porcentajeTotalCoordinadores) {
		this.porcentajeTotalCoordinadores = porcentajeTotalCoordinadores;
	}

	public String getPorcentajeMetaCoordinadores() {
		return porcentajeMetaCoordinadores;
	}

	public void setPorcentajeMetaCoordinadores(String porcentajeMetaCoordinadores) {
		this.porcentajeMetaCoordinadores = porcentajeMetaCoordinadores;
	}
	
	public Integer getNumRegion() {
		return numRegion;
	}

	public void setNumRegion(Integer numRegion) {
		this.numRegion = numRegion;
	}

	public Integer getNumMunicipio() {
		return numMunicipio;
	}

	public void setNumMunicipio(Integer numMunicipio) {
		this.numMunicipio = numMunicipio;
	}

	public Integer getNumSeccion() {
		return numSeccion;
	}

	public void setNumSeccion(Integer numSeccion) {
		this.numSeccion = numSeccion;
	}
	
	public Integer getEntidad() {
		return entidad;
	}
	public void setEntidad(Integer entidad) {
		this.entidad = entidad;
	}
	public Integer getRegion() {
		return region;
	}
	public void setRegion(Integer region) {
		this.region = region;
	}
	public String getNombreRegion() {
		return nombreRegion;
	}
	public void setNombreRegion(String nombre_region) {
		this.nombreRegion = nombre_region;
	}
	public Integer getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombre_municipio) {
		this.nombreMunicipio = nombre_municipio;
	}
	public Integer getSeccion() {
		return seccion;
	}
	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}
	public String getExitosoF() {
		return String.format("%,d", exitoso);
	}
	public Integer getExitoso() {
		return exitoso;
	}
	public void setExitoso(Integer exitoso) {
		this.exitoso = exitoso;
	}
	public String getNoHuboQuienContestaraF() {
		return String.format("%,d", noHuboQuienContestara);
	}
	public Integer getNoHuboQuienContestara() {
		return noHuboQuienContestara;
	}
	public void setNoHuboQuienContestara(Integer noHuboQuienContestara) {
		this.noHuboQuienContestara = noHuboQuienContestara;
	}
	public String getMenorDeEdadF() {
		return String.format("%,d", menorDeEdad);
	}
	public Integer getMenorDeEdad() {
		return menorDeEdad;
	}
	public void setMenorDeEdad(Integer menorDeEdad) {
		this.menorDeEdad = menorDeEdad;
	}
	public String getDomicilioNoEncontradoF() {
		return String.format("%,d", domicilioNoEncontrado);
	}
	public Integer getDomicilioNoEncontrado() {
		return domicilioNoEncontrado;
	}
	public void setDomicilioNoEncontrado(Integer domicilioNoEncontrado) {
		this.domicilioNoEncontrado = domicilioNoEncontrado;
	}
	public String getNoQuisieronContestarF() {
		return String.format("%,d", noQuisieronContestar);
	}
	public Integer getNoQuisieronContestar() {
		return noQuisieronContestar;
	}
	public void setNoQuisieronContestar(Integer noQuisieronContestar) {
		this.noQuisieronContestar = noQuisieronContestar;
	}
	public String getOtroF() {
		return String.format("%,d", otro);
	}
	public Integer getOtro() {
		return otro;
	}
	public void setOtro(Integer otro) {
		this.otro = otro;
	}
	public Integer setId() {
		return id;
	}

	public String getPorcentajeTotal() {
		return porcentajeTotal;
	}

	public void setPorcentajeTotal(String porcentajeTotal) {
		this.porcentajeTotal = porcentajeTotal;
	}

	public String getPorcentajeMeta() {
		return porcentajeMeta;
	}

	public void setPorcentajeMeta(String porcentajeMeta) {
		this.porcentajeMeta = porcentajeMeta;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPorcentajeExitoso() {
		return porcentajeExitoso;
	}

	public void setPorcentajeExitoso(String porcentajeExitoso) {
		this.porcentajeExitoso = porcentajeExitoso;
	}

	public String getPorcentajeNoHuboQuienContestara() {
		return porcentajeNoHuboQuienContestara;
	}

	public void setPorcentajeNoHuboQuienContestara(String porcentajeNoHuboQuienContestara) {
		this.porcentajeNoHuboQuienContestara = porcentajeNoHuboQuienContestara;
	}

	public String getPorcentajeMenorDeEdad() {
		return porcentajeMenorDeEdad;
	}

	public void setPorcentajeMenorDeEdad(String porcentajeMenorDeEdad) {
		this.porcentajeMenorDeEdad = porcentajeMenorDeEdad;
	}

	public String getPorcentajeDomicilioNoEncontrado() {
		return porcentajeDomicilioNoEncontrado;
	}

	public void setPorcentajeDomicilioNoEncontrado(String porcentajeDomicilioNoEncontrado) {
		this.porcentajeDomicilioNoEncontrado = porcentajeDomicilioNoEncontrado;
	}

	public String getPorcentajeNoQuisieronContestar() {
		return porcentajeNoQuisieronContestar;
	}

	public void setPorcentajeNoQuisieronContestar(String porcentajeNoQuisieronContestar) {
		this.porcentajeNoQuisieronContestar = porcentajeNoQuisieronContestar;
	}

	public String getPorcentajeOtro() {
		return porcentajeOtro;
	}

	public void setPorcentajeOtro(String porcentajeOtro) {
		this.porcentajeOtro = porcentajeOtro;
	}

	public String getTotalF() {
		return String.format("%,d", total);
	}
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
		if (this.total!=0) {
				this.porcentajeNoHuboQuienContestara=f.format((double)Math.round(((this.noHuboQuienContestara.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
				this.porcentajeExitoso=f.format((double)Math.round(((this.exitoso.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
				this.porcentajeDomicilioNoEncontrado=f.format((double)Math.round(((this.domicilioNoEncontrado.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
				this.porcentajeMenorDeEdad=f.format((double)Math.round(((this.menorDeEdad/this.total)*100)*100)/100)+"%";
				this.porcentajeNoQuisieronContestar=f.format((double)Math.round(((this.noQuisieronContestar.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
				this.porcentajeOtro=f.format((double)Math.round(((this.otro.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
		}
		else{
			this.porcentajeNoHuboQuienContestara=new String("0.00%");
			this.porcentajeExitoso=new String("0.00%");
			this.porcentajeDomicilioNoEncontrado=new String("0.00%");
			this.porcentajeMenorDeEdad=new String("0.00%");
			this.porcentajeNoQuisieronContestar=new String("0.00%");
			this.porcentajeOtro=new String("0.00%");
		}
	}

	public String getTotalTotalF() {
		return String.format("%,d", totalTotal);
	}
	public Integer getTotalTotal() {
		return totalTotal;
	}

	public void setTotalTotal(Integer totalTotal) {
		this.totalTotal = totalTotal;
		if (this.totalTotal!=0) {
			this.porcentajeTotal=f.format((double)Math.round(((this.total.doubleValue()/this.totalTotal.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeTotal=new String("0.00%");
		}
	}

	public String getMetaF() {
		return String.format("%,d", meta);
	}
	public Integer getMeta() {
		return meta;
	}

	public void setMeta(Integer meta) {
		this.meta = meta;
		if (this.meta!=0) {
			this.porcentajeMeta=f.format((double)Math.round(((this.total.doubleValue()/this.meta.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeMeta=new String("0.00%");
		}
	}
	

	public String getTotalCoordinadoresF() {
		return String.format("%,d", totalCoordinadores);
	}
	public Integer getTotalCoordinadores() {
		return totalCoordinadores;
	}

	public void setTotalCoordinadores(Integer totalCoordinadores) {
		this.totalCoordinadores = totalCoordinadores;
		if (this.totalCoordinadores!=0) {
			this.porcentajeNoHuboQuienContestaraCoordinadores=f.format((double)Math.round(((this.noHuboQuienContestaraCoordinadores.doubleValue()/this.totalCoordinadores.doubleValue())*100)*100)/100)+"%";
			this.porcentajeExitosoCoordinadores=f.format((double)Math.round(((this.exitosoCoordinadores.doubleValue()/this.totalCoordinadores.doubleValue())*100)*100)/100)+"%";
			this.porcentajeDomicilioNoEncontradoCoordinadores=f.format((double)Math.round(((this.domicilioNoEncontradoCoordinadores.doubleValue()/this.totalCoordinadores.doubleValue())*100)*100)/100)+"%";
			this.porcentajeMenorDeEdadCoordinadores=f.format((double)Math.round(((this.menorDeEdadCoordinadores/this.totalCoordinadores)*100)*100)/100)+"%";
			this.porcentajeNoQuisieronContestarCoordinadores=f.format((double)Math.round(((this.noQuisieronContestarCoordinadores.doubleValue()/this.totalCoordinadores.doubleValue())*100)*100)/100)+"%";
			this.porcentajeOtroCoordinadores=f.format((double)Math.round(((this.otroCoordinadores.doubleValue()/this.totalCoordinadores.doubleValue())*100)*100)/100)+"%";
		}
		else{
			this.porcentajeNoHuboQuienContestaraCoordinadores=new String("0.00%");
			this.porcentajeExitosoCoordinadores=new String("0.00%");
			this.porcentajeDomicilioNoEncontradoCoordinadores=new String("0.00%");
			this.porcentajeMenorDeEdadCoordinadores=new String("0.00%");
			this.porcentajeNoQuisieronContestarCoordinadores=new String("0.00%");
			this.porcentajeOtroCoordinadores=new String("0.00%");
		}
	}

	public String getTotalTotalCoordinadoresF() {
		return String.format("%,d", totalTotalCoordinadores);
	}
	public Integer getTotalTotalCoordinadores() {
		return totalTotalCoordinadores;
	}

	public void setTotalTotalCoordinadores(Integer totalTotalCoordinadores) {
		this.totalTotalCoordinadores = totalTotalCoordinadores;
		if (this.totalTotalCoordinadores!=0) {
			this.porcentajeTotalCoordinadores=f.format((double)Math.round(((this.totalCoordinadores.doubleValue()/this.totalTotalCoordinadores.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeTotalCoordinadores=new String("0.00%");
		}
	}

	public String getMetaCoordinadoresF() {
		return String.format("%,d", metaCoordinadores);
	}
	public Integer getMetaCoordinadores() {
		return metaCoordinadores;
	}

	public void setMetaCoordinadores(Integer metaCoordinadores) {
		this.metaCoordinadores = metaCoordinadores;
		if (this.metaCoordinadores!=0) {
			this.porcentajeMetaCoordinadores=f.format((double)Math.round(((this.totalCoordinadores.doubleValue()/this.metaCoordinadores.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeMetaCoordinadores=new String("0.00%");
		}
	}
	public String getTotalNegativoF() {
		return String.format("%,d", totalNegativo);
	}
	public Integer getTotalNegativo() {
		return totalNegativo;
	}

	public void setTotalNegativo(Integer totalNegativo) {
		this.totalNegativo = totalNegativo;
		if (this.totalNegativo!=0) {
			this.porcentajeNoHuboQuienContestaraNegativo=f.format((double)Math.round(((this.noHuboQuienContestaraNegativo.doubleValue()/this.totalNegativo.doubleValue())*100)*100)/100)+"%";
			this.porcentajeExitosoNegativo=f.format((double)Math.round(((this.exitosoNegativo.doubleValue()/this.totalNegativo.doubleValue())*100)*100)/100)+"%";
			this.porcentajeDomicilioNoEncontradoNegativo=f.format((double)Math.round(((this.domicilioNoEncontradoNegativo.doubleValue()/this.totalNegativo.doubleValue())*100)*100)/100)+"%";
			this.porcentajeMenorDeEdadNegativo=f.format((double)Math.round(((this.menorDeEdadNegativo/this.totalNegativo)*100)*100)/100)+"%";
			this.porcentajeNoQuisieronContestarNegativo=f.format((double)Math.round(((this.noQuisieronContestarNegativo.doubleValue()/this.totalNegativo.doubleValue())*100)*100)/100)+"%";
			this.porcentajeOtroNegativo=f.format((double)Math.round(((this.otroNegativo.doubleValue()/this.totalNegativo.doubleValue())*100)*100)/100)+"%";
		}
		else{
			this.porcentajeNoHuboQuienContestaraNegativo=new String("0.00%");
			this.porcentajeExitosoNegativo=new String("0.00%");
			this.porcentajeDomicilioNoEncontradoNegativo=new String("0.00%");
			this.porcentajeMenorDeEdadNegativo=new String("0.00%");
			this.porcentajeNoQuisieronContestarNegativo=new String("0.00%");
			this.porcentajeOtroNegativo=new String("0.00%");
		}
	}

	public String getTotalTotalNegativoF() {
		return String.format("%,d", totalTotalNegativo);
	}
	public Integer getTotalTotalNegativo() {
		return totalTotalNegativo;
	}

	public void setTotalTotalNegativo(Integer totalTotalNegativo) {
		this.totalTotalNegativo = totalTotalNegativo;
		if (this.totalTotalNegativo!=0) {
			this.porcentajeTotalNegativo=f.format((double)Math.round(((this.totalNegativo.doubleValue()/this.totalTotalNegativo.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeTotalNegativo=new String("0.00%");
		}
	}

	public String getMetaNegativoF() {
		return String.format("%,d", metaNegativo);
	}
	public Integer getMetaNegativo() {
		return metaNegativo;
	}

	public void setMetaNegativo(Integer metaNegativo) {
		this.metaNegativo = metaNegativo;
		if (this.metaNegativo!=0) {
			this.porcentajeMetaNegativo=f.format((double)Math.round(((this.totalNegativo.doubleValue()/this.metaNegativo.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeMetaNegativo=new String("0.00%");
		}
	}
}
