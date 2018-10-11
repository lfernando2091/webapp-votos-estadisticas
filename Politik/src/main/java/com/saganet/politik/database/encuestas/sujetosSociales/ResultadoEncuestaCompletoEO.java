package com.saganet.politik.database.encuestas.sujetosSociales;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.apache.ibatis.type.Alias;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("SujetosSocialesResultadoEncuestaCompletoEO")
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
	
	///////////////////////////////////// Prospera //////////////////////////////////////////////////

	private Integer exitosoProspera;
	private Integer noHuboQuienContestaraProspera;
	private Integer menorDeEdadProspera;
	private Integer domicilioNoEncontradoProspera;
	private Integer noQuisieronContestarProspera;
	private Integer otroProspera;

	private String porcentajeExitosoProspera;
	private String porcentajeNoHuboQuienContestaraProspera;
	private String porcentajeMenorDeEdadProspera;
	private String porcentajeDomicilioNoEncontradoProspera;
	private String porcentajeNoQuisieronContestarProspera;
	private String porcentajeOtroProspera;
	
	private Integer totalProspera;
	private Integer totalTotalProspera;
	private Integer metaProspera;
	
	private String porcentajeTotalProspera;
	private String porcentajeMetaProspera;
	
	/////////////////////////////////////// Liconsa ////////////////////////////////////////////////

	private Integer exitosoLiconsa;
	private Integer noHuboQuienContestaraLiconsa;
	private Integer menorDeEdadLiconsa;
	private Integer domicilioNoEncontradoLiconsa;
	private Integer noQuisieronContestarLiconsa;
	private Integer otroLiconsa;

	private String porcentajeExitosoLiconsa;
	private String porcentajeNoHuboQuienContestaraLiconsa;
	private String porcentajeMenorDeEdadLiconsa;
	private String porcentajeDomicilioNoEncontradoLiconsa;
	private String porcentajeNoQuisieronContestarLiconsa;
	private String porcentajeOtroLiconsa;
	
	private Integer totalLiconsa;
	private Integer totalTotalLiconsa;
	private Integer metaLiconsa;
	
	private String porcentajeTotalLiconsa;
	private String porcentajeMetaLiconsa;
	
	/////////////////////////////////////// Gem ////////////////////////////////////////////////

	private Integer exitosoGem;
	private Integer noHuboQuienContestaraGem;
	private Integer menorDeEdadGem;
	private Integer domicilioNoEncontradoGem;
	private Integer noQuisieronContestarGem;
	private Integer otroGem;

	private String porcentajeExitosoGem;
	private String porcentajeNoHuboQuienContestaraGem;
	private String porcentajeMenorDeEdadGem;
	private String porcentajeDomicilioNoEncontradoGem;
	private String porcentajeNoQuisieronContestarGem;
	private String porcentajeOtroGem;
	
	private Integer totalGem;
	private Integer totalTotalGem;
	private Integer metaGem;
	
	private String porcentajeTotalGem;
	private String porcentajeMetaGem;
	
	
	
	
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
				+ ", porcentajeTotal=" + porcentajeTotal + ", porcentajeMeta=" + porcentajeMeta + ", exitosoProspera="
				+ exitosoProspera + ", noHuboQuienContestaraProspera=" + noHuboQuienContestaraProspera
				+ ", menorDeEdadProspera=" + menorDeEdadProspera + ", domicilioNoEncontradoProspera="
				+ domicilioNoEncontradoProspera + ", noQuisieronContestarProspera=" + noQuisieronContestarProspera
				+ ", otroProspera=" + otroProspera + ", porcentajeExitosoProspera=" + porcentajeExitosoProspera
				+ ", porcentajeNoHuboQuienContestaraProspera=" + porcentajeNoHuboQuienContestaraProspera
				+ ", porcentajeMenorDeEdadProspera=" + porcentajeMenorDeEdadProspera
				+ ", porcentajeDomicilioNoEncontradoProspera=" + porcentajeDomicilioNoEncontradoProspera
				+ ", porcentajeNoQuisieronContestarProspera=" + porcentajeNoQuisieronContestarProspera
				+ ", porcentajeOtroProspera=" + porcentajeOtroProspera + ", totalProspera=" + totalProspera
				+ ", totalTotalProspera=" + totalTotalProspera + ", metaProspera=" + metaProspera
				+ ", porcentajeTotalProspera=" + porcentajeTotalProspera + ", porcentajeMetaProspera="
				+ porcentajeMetaProspera + ", exitosoLiconsa=" + exitosoLiconsa + ", noHuboQuienContestaraLiconsa="
				+ noHuboQuienContestaraLiconsa + ", menorDeEdadLiconsa=" + menorDeEdadLiconsa
				+ ", domicilioNoEncontradoLiconsa=" + domicilioNoEncontradoLiconsa + ", noQuisieronContestarLiconsa="
				+ noQuisieronContestarLiconsa + ", otroLiconsa=" + otroLiconsa + ", porcentajeExitosoLiconsa="
				+ porcentajeExitosoLiconsa + ", porcentajeNoHuboQuienContestaraLiconsa="
				+ porcentajeNoHuboQuienContestaraLiconsa + ", porcentajeMenorDeEdadLiconsa="
				+ porcentajeMenorDeEdadLiconsa + ", porcentajeDomicilioNoEncontradoLiconsa="
				+ porcentajeDomicilioNoEncontradoLiconsa + ", porcentajeNoQuisieronContestarLiconsa="
				+ porcentajeNoQuisieronContestarLiconsa + ", porcentajeOtroLiconsa=" + porcentajeOtroLiconsa
				+ ", totalLiconsa=" + totalLiconsa + ", totalTotalLiconsa=" + totalTotalLiconsa + ", metaLiconsa="
				+ metaLiconsa + ", porcentajeTotalLiconsa=" + porcentajeTotalLiconsa + ", porcentajeMetaLiconsa="
				+ porcentajeMetaLiconsa + ", exitosoGem=" + exitosoGem + ", noHuboQuienContestaraGem="
				+ noHuboQuienContestaraGem + ", menorDeEdadGem=" + menorDeEdadGem + ", domicilioNoEncontradoGem="
				+ domicilioNoEncontradoGem + ", noQuisieronContestarGem=" + noQuisieronContestarGem + ", otroGem="
				+ otroGem + ", porcentajeExitosoGem=" + porcentajeExitosoGem + ", porcentajeNoHuboQuienContestaraGem="
				+ porcentajeNoHuboQuienContestaraGem + ", porcentajeMenorDeEdadGem=" + porcentajeMenorDeEdadGem
				+ ", porcentajeDomicilioNoEncontradoGem=" + porcentajeDomicilioNoEncontradoGem
				+ ", porcentajeNoQuisieronContestarGem=" + porcentajeNoQuisieronContestarGem + ", porcentajeOtroGem="
				+ porcentajeOtroGem + ", totalGem=" + totalGem + ", totalTotalGem=" + totalTotalGem + ", metaGem="
				+ metaGem + ", porcentajeTotalGem=" + porcentajeTotalGem + ", porcentajeMetaGem=" + porcentajeMetaGem
				+ "]";
	}

	public Integer getExitosoProspera() {
		return exitosoProspera;
	}

	public void setExitosoProspera(Integer exitosoProspera) {
		this.exitosoProspera = exitosoProspera;
	}

	public Integer getNoHuboQuienContestaraProspera() {
		return noHuboQuienContestaraProspera;
	}

	public void setNoHuboQuienContestaraProspera(Integer noHuboQuienContestaraProspera) {
		this.noHuboQuienContestaraProspera = noHuboQuienContestaraProspera;
	}

	public Integer getMenorDeEdadProspera() {
		return menorDeEdadProspera;
	}

	public void setMenorDeEdadProspera(Integer menorDeEdadProspera) {
		this.menorDeEdadProspera = menorDeEdadProspera;
	}

	public Integer getDomicilioNoEncontradoProspera() {
		return domicilioNoEncontradoProspera;
	}

	public void setDomicilioNoEncontradoProspera(Integer domicilioNoEncontradoProspera) {
		this.domicilioNoEncontradoProspera = domicilioNoEncontradoProspera;
	}

	public Integer getNoQuisieronContestarProspera() {
		return noQuisieronContestarProspera;
	}

	public void setNoQuisieronContestarProspera(Integer noQuisieronContestarProspera) {
		this.noQuisieronContestarProspera = noQuisieronContestarProspera;
	}

	public Integer getOtroProspera() {
		return otroProspera;
	}

	public void setOtroProspera(Integer otroProspera) {
		this.otroProspera = otroProspera;
	}

	public String getPorcentajeExitosoProspera() {
		return porcentajeExitosoProspera;
	}

	public void setPorcentajeExitosoProspera(String porcentajeExitosoProspera) {
		this.porcentajeExitosoProspera = porcentajeExitosoProspera;
	}

	public String getPorcentajeNoHuboQuienContestaraProspera() {
		return porcentajeNoHuboQuienContestaraProspera;
	}

	public void setPorcentajeNoHuboQuienContestaraProspera(String porcentajeNoHuboQuienContestaraProspera) {
		this.porcentajeNoHuboQuienContestaraProspera = porcentajeNoHuboQuienContestaraProspera;
	}

	public String getPorcentajeMenorDeEdadProspera() {
		return porcentajeMenorDeEdadProspera;
	}

	public void setPorcentajeMenorDeEdadProspera(String porcentajeMenorDeEdadProspera) {
		this.porcentajeMenorDeEdadProspera = porcentajeMenorDeEdadProspera;
	}

	public String getPorcentajeDomicilioNoEncontradoProspera() {
		return porcentajeDomicilioNoEncontradoProspera;
	}

	public void setPorcentajeDomicilioNoEncontradoProspera(String porcentajeDomicilioNoEncontradoProspera) {
		this.porcentajeDomicilioNoEncontradoProspera = porcentajeDomicilioNoEncontradoProspera;
	}

	public String getPorcentajeNoQuisieronContestarProspera() {
		return porcentajeNoQuisieronContestarProspera;
	}

	public void setPorcentajeNoQuisieronContestarProspera(String porcentajeNoQuisieronContestarProspera) {
		this.porcentajeNoQuisieronContestarProspera = porcentajeNoQuisieronContestarProspera;
	}

	public String getPorcentajeOtroProspera() {
		return porcentajeOtroProspera;
	}

	public void setPorcentajeOtroProspera(String porcentajeOtroProspera) {
		this.porcentajeOtroProspera = porcentajeOtroProspera;
	}

	public String getPorcentajeTotalProspera() {
		return porcentajeTotalProspera;
	}

	public void setPorcentajeTotalProspera(String porcentajeTotalProspera) {
		this.porcentajeTotalProspera = porcentajeTotalProspera;
	}

	public String getPorcentajeMetaProspera() {
		return porcentajeMetaProspera;
	}

	public void setPorcentajeMetaProspera(String porcentajeMetaProspera) {
		this.porcentajeMetaProspera = porcentajeMetaProspera;
	}

	public Integer getExitosoLiconsa() {
		return exitosoLiconsa;
	}

	public void setExitosoLiconsa(Integer exitosoLiconsa) {
		this.exitosoLiconsa = exitosoLiconsa;
	}

	public Integer getNoHuboQuienContestaraLiconsa() {
		return noHuboQuienContestaraLiconsa;
	}

	public void setNoHuboQuienContestaraLiconsa(Integer noHuboQuienContestaraLiconsa) {
		this.noHuboQuienContestaraLiconsa = noHuboQuienContestaraLiconsa;
	}

	public Integer getMenorDeEdadLiconsa() {
		return menorDeEdadLiconsa;
	}

	public void setMenorDeEdadLiconsa(Integer menorDeEdadLiconsa) {
		this.menorDeEdadLiconsa = menorDeEdadLiconsa;
	}

	public Integer getDomicilioNoEncontradoLiconsa() {
		return domicilioNoEncontradoLiconsa;
	}

	public void setDomicilioNoEncontradoLiconsa(Integer domicilioNoEncontradoLiconsa) {
		this.domicilioNoEncontradoLiconsa = domicilioNoEncontradoLiconsa;
	}

	public Integer getNoQuisieronContestarLiconsa() {
		return noQuisieronContestarLiconsa;
	}

	public void setNoQuisieronContestarLiconsa(Integer noQuisieronContestarLiconsa) {
		this.noQuisieronContestarLiconsa = noQuisieronContestarLiconsa;
	}

	public Integer getOtroLiconsa() {
		return otroLiconsa;
	}

	public void setOtroLiconsa(Integer otroLiconsa) {
		this.otroLiconsa = otroLiconsa;
	}

	public String getPorcentajeExitosoLiconsa() {
		return porcentajeExitosoLiconsa;
	}

	public void setPorcentajeExitosoLiconsa(String porcentajeExitosoLiconsa) {
		this.porcentajeExitosoLiconsa = porcentajeExitosoLiconsa;
	}

	public String getPorcentajeNoHuboQuienContestaraLiconsa() {
		return porcentajeNoHuboQuienContestaraLiconsa;
	}

	public void setPorcentajeNoHuboQuienContestaraLiconsa(String porcentajeNoHuboQuienContestaraLiconsa) {
		this.porcentajeNoHuboQuienContestaraLiconsa = porcentajeNoHuboQuienContestaraLiconsa;
	}

	public String getPorcentajeMenorDeEdadLiconsa() {
		return porcentajeMenorDeEdadLiconsa;
	}

	public void setPorcentajeMenorDeEdadLiconsa(String porcentajeMenorDeEdadLiconsa) {
		this.porcentajeMenorDeEdadLiconsa = porcentajeMenorDeEdadLiconsa;
	}

	public String getPorcentajeDomicilioNoEncontradoLiconsa() {
		return porcentajeDomicilioNoEncontradoLiconsa;
	}

	public void setPorcentajeDomicilioNoEncontradoLiconsa(String porcentajeDomicilioNoEncontradoLiconsa) {
		this.porcentajeDomicilioNoEncontradoLiconsa = porcentajeDomicilioNoEncontradoLiconsa;
	}

	public String getPorcentajeNoQuisieronContestarLiconsa() {
		return porcentajeNoQuisieronContestarLiconsa;
	}

	public void setPorcentajeNoQuisieronContestarLiconsa(String porcentajeNoQuisieronContestarLiconsa) {
		this.porcentajeNoQuisieronContestarLiconsa = porcentajeNoQuisieronContestarLiconsa;
	}

	public String getPorcentajeOtroLiconsa() {
		return porcentajeOtroLiconsa;
	}

	public void setPorcentajeOtroLiconsa(String porcentajeOtroLiconsa) {
		this.porcentajeOtroLiconsa = porcentajeOtroLiconsa;
	}

	public String getPorcentajeTotalLiconsa() {
		return porcentajeTotalLiconsa;
	}

	public void setPorcentajeTotalLiconsa(String porcentajeTotalLiconsa) {
		this.porcentajeTotalLiconsa = porcentajeTotalLiconsa;
	}

	public String getPorcentajeMetaLiconsa() {
		return porcentajeMetaLiconsa;
	}

	public void setPorcentajeMetaLiconsa(String porcentajeMetaLiconsa) {
		this.porcentajeMetaLiconsa = porcentajeMetaLiconsa;
	}

	public Integer getExitosoGem() {
		return exitosoGem;
	}

	public void setExitosoGem(Integer exitosoGem) {
		this.exitosoGem = exitosoGem;
	}

	public Integer getNoHuboQuienContestaraGem() {
		return noHuboQuienContestaraGem;
	}

	public void setNoHuboQuienContestaraGem(Integer noHuboQuienContestaraGem) {
		this.noHuboQuienContestaraGem = noHuboQuienContestaraGem;
	}

	public Integer getMenorDeEdadGem() {
		return menorDeEdadGem;
	}

	public void setMenorDeEdadGem(Integer menorDeEdadGem) {
		this.menorDeEdadGem = menorDeEdadGem;
	}

	public Integer getDomicilioNoEncontradoGem() {
		return domicilioNoEncontradoGem;
	}

	public void setDomicilioNoEncontradoGem(Integer domicilioNoEncontradoGem) {
		this.domicilioNoEncontradoGem = domicilioNoEncontradoGem;
	}

	public Integer getNoQuisieronContestarGem() {
		return noQuisieronContestarGem;
	}

	public void setNoQuisieronContestarGem(Integer noQuisieronContestarGem) {
		this.noQuisieronContestarGem = noQuisieronContestarGem;
	}

	public Integer getOtroGem() {
		return otroGem;
	}

	public void setOtroGem(Integer otroGem) {
		this.otroGem = otroGem;
	}

	public String getPorcentajeExitosoGem() {
		return porcentajeExitosoGem;
	}

	public void setPorcentajeExitosoGem(String porcentajeExitosoGem) {
		this.porcentajeExitosoGem = porcentajeExitosoGem;
	}

	public String getPorcentajeNoHuboQuienContestaraGem() {
		return porcentajeNoHuboQuienContestaraGem;
	}

	public void setPorcentajeNoHuboQuienContestaraGem(String porcentajeNoHuboQuienContestaraGem) {
		this.porcentajeNoHuboQuienContestaraGem = porcentajeNoHuboQuienContestaraGem;
	}

	public String getPorcentajeMenorDeEdadGem() {
		return porcentajeMenorDeEdadGem;
	}

	public void setPorcentajeMenorDeEdadGem(String porcentajeMenorDeEdadGem) {
		this.porcentajeMenorDeEdadGem = porcentajeMenorDeEdadGem;
	}

	public String getPorcentajeDomicilioNoEncontradoGem() {
		return porcentajeDomicilioNoEncontradoGem;
	}

	public void setPorcentajeDomicilioNoEncontradoGem(String porcentajeDomicilioNoEncontradoGem) {
		this.porcentajeDomicilioNoEncontradoGem = porcentajeDomicilioNoEncontradoGem;
	}

	public String getPorcentajeNoQuisieronContestarGem() {
		return porcentajeNoQuisieronContestarGem;
	}

	public void setPorcentajeNoQuisieronContestarGem(String porcentajeNoQuisieronContestarGem) {
		this.porcentajeNoQuisieronContestarGem = porcentajeNoQuisieronContestarGem;
	}

	public String getPorcentajeOtroGem() {
		return porcentajeOtroGem;
	}

	public void setPorcentajeOtroGem(String porcentajeOtroGem) {
		this.porcentajeOtroGem = porcentajeOtroGem;
	}

	public String getPorcentajeTotalGem() {
		return porcentajeTotalGem;
	}

	public void setPorcentajeTotalGem(String porcentajeTotalGem) {
		this.porcentajeTotalGem = porcentajeTotalGem;
	}

	public String getPorcentajeMetaGem() {
		return porcentajeMetaGem;
	}

	public void setPorcentajeMetaGem(String porcentajeMetaGem) {
		this.porcentajeMetaGem = porcentajeMetaGem;
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
	public Integer getExitoso() {
		return exitoso;
	}
	public void setExitoso(Integer exitoso) {
		this.exitoso = exitoso;
	}
	public Integer getNoHuboQuienContestara() {
		return noHuboQuienContestara;
	}
	public void setNoHuboQuienContestara(Integer noHuboQuienContestara) {
		this.noHuboQuienContestara = noHuboQuienContestara;
	}
	public Integer getMenorDeEdad() {
		return menorDeEdad;
	}
	public void setMenorDeEdad(Integer menorDeEdad) {
		this.menorDeEdad = menorDeEdad;
	}
	public Integer getDomicilioNoEncontrado() {
		return domicilioNoEncontrado;
	}
	public void setDomicilioNoEncontrado(Integer domicilioNoEncontrado) {
		this.domicilioNoEncontrado = domicilioNoEncontrado;
	}
	public Integer getNoQuisieronContestar() {
		return noQuisieronContestar;
	}
	public void setNoQuisieronContestar(Integer noQuisieronContestar) {
		this.noQuisieronContestar = noQuisieronContestar;
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
	
	
	/////////////////////


	public Integer getTotalGem() {
		return totalGem;
	}

	public void setTotalGem(Integer totalGem) {
		this.totalGem = totalGem;
		if (this.totalGem!=0) {
			this.porcentajeNoHuboQuienContestaraGem=f.format((double)Math.round(((this.noHuboQuienContestaraGem.doubleValue()/this.totalGem.doubleValue())*100)*100)/100)+"%";
			this.porcentajeExitosoGem=f.format((double)Math.round(((this.exitosoGem.doubleValue()/this.totalGem.doubleValue())*100)*100)/100)+"%";
			this.porcentajeDomicilioNoEncontradoGem=f.format((double)Math.round(((this.domicilioNoEncontradoGem.doubleValue()/this.totalGem.doubleValue())*100)*100)/100)+"%";
			this.porcentajeMenorDeEdadGem=f.format((double)Math.round(((this.menorDeEdadGem/this.totalGem)*100)*100)/100)+"%";
			this.porcentajeNoQuisieronContestarGem=f.format((double)Math.round(((this.noQuisieronContestarGem.doubleValue()/this.totalGem.doubleValue())*100)*100)/100)+"%";
			this.porcentajeOtroGem=f.format((double)Math.round(((this.otroGem.doubleValue()/this.totalGem.doubleValue())*100)*100)/100)+"%";
		}
		else{
			this.porcentajeNoHuboQuienContestaraGem=new String("0.00%");
			this.porcentajeExitosoGem=new String("0.00%");
			this.porcentajeDomicilioNoEncontradoGem=new String("0.00%");
			this.porcentajeMenorDeEdadGem=new String("0.00%");
			this.porcentajeNoQuisieronContestarGem=new String("0.00%");
			this.porcentajeOtroGem=new String("0.00%");
		}
	}

	public Integer getTotalTotalGem() {
		return totalTotalGem;
	}

	public void setTotalTotalGem(Integer totalTotalGem) {
		this.totalTotalGem = totalTotalGem;
		if (this.totalTotalGem!=0) {
			this.porcentajeTotalGem=f.format((double)Math.round(((this.totalGem.doubleValue()/this.totalTotalGem.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeTotalGem=new String("0.00%");
		}
	}

	public Integer getMetaGem() {
		return metaGem;
	}

	public void setMetaGem(Integer metaGem) {
		this.metaGem = metaGem;
		if (this.metaGem!=0) {
			this.porcentajeMetaGem=f.format((double)Math.round(((this.totalGem.doubleValue()/this.metaGem.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeMetaGem=new String("0.00%");
		}
	}

	public Integer getTotalLiconsa() {
		return totalLiconsa;
	}

	public void setTotalLiconsa(Integer totalLiconsa) {
		this.totalLiconsa = totalLiconsa;
		if (this.totalLiconsa!=0) {
			this.porcentajeNoHuboQuienContestaraLiconsa=f.format((double)Math.round(((this.noHuboQuienContestaraLiconsa.doubleValue()/this.totalLiconsa.doubleValue())*100)*100)/100)+"%";
			this.porcentajeExitosoLiconsa=f.format((double)Math.round(((this.exitosoLiconsa.doubleValue()/this.totalLiconsa.doubleValue())*100)*100)/100)+"%";
			this.porcentajeDomicilioNoEncontradoLiconsa=f.format((double)Math.round(((this.domicilioNoEncontradoLiconsa.doubleValue()/this.totalLiconsa.doubleValue())*100)*100)/100)+"%";
			this.porcentajeMenorDeEdadLiconsa=f.format((double)Math.round(((this.menorDeEdadLiconsa/this.totalLiconsa)*100)*100)/100)+"%";
			this.porcentajeNoQuisieronContestarLiconsa=f.format((double)Math.round(((this.noQuisieronContestarLiconsa.doubleValue()/this.totalLiconsa.doubleValue())*100)*100)/100)+"%";
			this.porcentajeOtroLiconsa=f.format((double)Math.round(((this.otroLiconsa.doubleValue()/this.totalLiconsa.doubleValue())*100)*100)/100)+"%";
		}
		else{
			this.porcentajeNoHuboQuienContestaraLiconsa=new String("0.00%");
			this.porcentajeExitosoLiconsa=new String("0.00%");
			this.porcentajeDomicilioNoEncontradoLiconsa=new String("0.00%");
			this.porcentajeMenorDeEdadLiconsa=new String("0.00%");
			this.porcentajeNoQuisieronContestarLiconsa=new String("0.00%");
			this.porcentajeOtroLiconsa=new String("0.00%");
		}
	}

	public Integer getTotalTotalLiconsa() {
		return totalTotalLiconsa;
	}

	public void setTotalTotalLiconsa(Integer totalTotalLiconsa) {
		this.totalTotalLiconsa = totalTotalLiconsa;
		if (this.totalTotalLiconsa!=0) {
			this.porcentajeTotalLiconsa=f.format((double)Math.round(((this.totalLiconsa.doubleValue()/this.totalTotalLiconsa.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeTotalLiconsa=new String("0.00%");
		}
	}

	public Integer getMetaLiconsa() {
		return metaLiconsa;
	}

	public void setMetaLiconsa(Integer metaLiconsa) {
		this.metaLiconsa = metaLiconsa;
		if (this.metaLiconsa!=0) {
			this.porcentajeMetaLiconsa=f.format((double)Math.round(((this.totalLiconsa.doubleValue()/this.metaLiconsa.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeMetaLiconsa=new String("0.00%");
		}
	}
	public Integer getTotalProspera() {
		return totalProspera;
	}

	public void setTotalProspera(Integer totalProspera) {
		this.totalProspera = totalProspera;
		if (this.totalProspera!=0) {
			this.porcentajeNoHuboQuienContestaraProspera=f.format((double)Math.round(((this.noHuboQuienContestaraProspera.doubleValue()/this.totalProspera.doubleValue())*100)*100)/100)+"%";
			this.porcentajeExitosoProspera=f.format((double)Math.round(((this.exitosoProspera.doubleValue()/this.totalProspera.doubleValue())*100)*100)/100)+"%";
			this.porcentajeDomicilioNoEncontradoProspera=f.format((double)Math.round(((this.domicilioNoEncontradoProspera.doubleValue()/this.totalProspera.doubleValue())*100)*100)/100)+"%";
			this.porcentajeMenorDeEdadProspera=f.format((double)Math.round(((this.menorDeEdadProspera/this.totalProspera)*100)*100)/100)+"%";
			this.porcentajeNoQuisieronContestarProspera=f.format((double)Math.round(((this.noQuisieronContestarProspera.doubleValue()/this.totalProspera.doubleValue())*100)*100)/100)+"%";
			this.porcentajeOtroProspera=f.format((double)Math.round(((this.otroProspera.doubleValue()/this.totalProspera.doubleValue())*100)*100)/100)+"%";
		}
		else{
			this.porcentajeNoHuboQuienContestaraProspera=new String("0.00%");
			this.porcentajeExitosoProspera=new String("0.00%");
			this.porcentajeDomicilioNoEncontradoProspera=new String("0.00%");
			this.porcentajeMenorDeEdadProspera=new String("0.00%");
			this.porcentajeNoQuisieronContestarProspera=new String("0.00%");
			this.porcentajeOtroProspera=new String("0.00%");
		}
	}

	public Integer getTotalTotalProspera() {
		return totalTotalProspera;
	}

	public void setTotalTotalProspera(Integer totalTotalProspera) {
		this.totalTotalProspera = totalTotalProspera;
		if (this.totalTotalProspera!=0) {
			this.porcentajeTotalProspera=f.format((double)Math.round(((this.totalProspera.doubleValue()/this.totalTotalProspera.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeTotalProspera=new String("0.00%");
		}
	}

	public Integer getMetaProspera() {
		return metaProspera;
	}

	public void setMetaProspera(Integer metaProspera) {
		this.metaProspera = metaProspera;
		if (this.metaProspera!=0) {
			this.porcentajeMetaProspera=f.format((double)Math.round(((this.totalProspera.doubleValue()/this.metaProspera.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.porcentajeMetaProspera=new String("0.00%");
		}
	}
}
