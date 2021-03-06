package com.saganet.politik.database.encuestas.edomex2017;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.apache.ibatis.type.Alias;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("Edomex2017AvanceEncuestadoresEO")
public class AvanceEncuestadoresEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 2198549554059215572L;

	private Integer id;
	private Integer region;
	private String nombreRegion;
	private Integer municipio;
	private Integer numMunicipio;
	private String nombreMunicipio;
	
	private Integer encuestadoresProspera;
	private Integer encuestadoresLiconsa;
	private Integer encuestadoresGem;
	private Integer encuestadoresProsperaMeta;
	private Integer encuestadoresLiconsaMeta;
	private Integer encuestadoresGemMeta;
	
	private String porcentajeEncuestadoresProspera;
	private String porcentajeEncuestadoresLiconsa;
	private String porcentajeEncuestadoresGem;

	@Override
	public String toString() {
		return "AvanceEncuestadoresEO [id=" + id + ", region=" + region + ", nombreRegion=" + nombreRegion
				+ ", municipio=" + municipio + ", numMunicipio=" + numMunicipio + ", nombreMunicipio=" + nombreMunicipio
				+ ", encuestadoresProspera=" + encuestadoresProspera + ", encuestadoresLiconsa=" + encuestadoresLiconsa
				+ ", encuestadoresGem=" + encuestadoresGem + ", encuestadoresProsperaMeta=" + encuestadoresProsperaMeta
				+ ", encuestadoresLiconsaMeta=" + encuestadoresLiconsaMeta + ", encuestadoresGemMeta="
				+ encuestadoresGemMeta + ", porcentajeEncuestadoresProspera=" + porcentajeEncuestadoresProspera
				+ ", porcentajeEncuestadoresLiconsa=" + porcentajeEncuestadoresLiconsa + ", porcentajeEncuestadoresGem="
				+ porcentajeEncuestadoresGem + "]";
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

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getEncuestadoresProspera() {
		return encuestadoresProspera;
	}

	public void setEncuestadoresProspera(Integer encuestadoresProspera) {
		this.encuestadoresProspera = encuestadoresProspera;
	}

	public Integer getEncuestadoresLiconsa() {
		return encuestadoresLiconsa;
	}

	public void setEncuestadoresLiconsa(Integer encuestadoresLiconsa) {
		this.encuestadoresLiconsa = encuestadoresLiconsa;
	}

	public Integer getEncuestadoresGem() {
		return encuestadoresGem;
	}

	public void setEncuestadoresGem(Integer encuestadoresGem) {
		this.encuestadoresGem = encuestadoresGem;
	}

	public Integer getEncuestadoresProsperaMeta() {
		return encuestadoresProsperaMeta;
	}

	public void setEncuestadoresProsperaMeta(Integer encuestadoresProsperaMeta) {
		DecimalFormat f = new DecimalFormat("#0.00");
		this.encuestadoresProsperaMeta = encuestadoresProsperaMeta;
		if (this.encuestadoresProsperaMeta!=0) {
			this.porcentajeEncuestadoresProspera=f.format((double)Math.round(((this.encuestadoresProspera.doubleValue()/this.encuestadoresProsperaMeta.doubleValue())*100)*100)/100)+"%";
		}
		else{
			this.porcentajeEncuestadoresProspera=new String("0.00%");
		}
	}

	public Integer getEncuestadoresLiconsaMeta() {
		return encuestadoresLiconsaMeta;
	}

	public void setEncuestadoresLiconsaMeta(Integer encuestadoresLiconsaMeta) {
		DecimalFormat f = new DecimalFormat("#0.00");
		this.encuestadoresLiconsaMeta = encuestadoresLiconsaMeta;
		if (this.encuestadoresLiconsaMeta!=0) {
			this.porcentajeEncuestadoresLiconsa=f.format((double)Math.round(((this.encuestadoresLiconsa.doubleValue()/this.encuestadoresLiconsaMeta.doubleValue())*100)*100)/100)+"%";
		}
		else{
			this.porcentajeEncuestadoresLiconsa=new String("0.00%");
		}
	}

	public Integer getEncuestadoresGemMeta() {
		return encuestadoresGemMeta;
	}

	public void setEncuestadoresGemMeta(Integer encuestadoresGemMeta) {
		DecimalFormat f = new DecimalFormat("#0.00");
		this.encuestadoresGemMeta = encuestadoresGemMeta;
		if (this.encuestadoresGemMeta!=0) {
			this.porcentajeEncuestadoresGem=f.format((double)Math.round(((this.encuestadoresGem.doubleValue()/this.encuestadoresGemMeta.doubleValue())*100)*100)/100)+"%";
		}
		else{
			this.porcentajeEncuestadoresGem=new String("0.00%");
		}
	}

	public String getPorcentajeEncuestadoresProspera() {
		return porcentajeEncuestadoresProspera;
	}

	public void setPorcentajeEncuestadoresProspera(String porcentajeEncuestadoresProspera) {
		this.porcentajeEncuestadoresProspera = porcentajeEncuestadoresProspera;
	}

	public String getPorcentajeEncuestadoresLiconsa() {
		return porcentajeEncuestadoresLiconsa;
	}

	public void setPorcentajeEncuestadoresLiconsa(String porcentajeEncuestadoresLiconsa) {
		this.porcentajeEncuestadoresLiconsa = porcentajeEncuestadoresLiconsa;
	}

	public String getPorcentajeEncuestadoresGem() {
		return porcentajeEncuestadoresGem;
	}

	public void setPorcentajeEncuestadoresGem(String porcentajeEncuestadoresGem) {
		this.porcentajeEncuestadoresGem = porcentajeEncuestadoresGem;
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

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public Integer getNumMunicipio() {
		return numMunicipio;
	}

	public void setNumMunicipio(Integer numMunicipio) {
		this.numMunicipio = numMunicipio;
	}

}
