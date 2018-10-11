package com.saganet.politik.database.encuestas.sujetosSociales;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.apache.ibatis.type.Alias;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("SujetosSocialesResultadoEncuestaEO")
public class ResultadoEncuestaEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 2198549554059215572L;
	
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
	private ProgramasEdoMexDO programa;
	
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
	
	@Override
	public String toString() {
		return "ResultadoEncuestaEO [id=" + id + ", entidad=" + entidad + ", numRegion=" + numRegion + ", region="
				+ region + ", nombreRegion=" + nombreRegion + ", numMunicipio=" + numMunicipio + ", municipio="
				+ municipio + ", nombreMunicipio=" + nombreMunicipio + ", seccion=" + seccion + ", numSeccion="
				+ numSeccion + ", programa=" + programa + ", exitoso=" + exitoso + ", noHuboQuienContestara="
				+ noHuboQuienContestara + ", menorDeEdad=" + menorDeEdad + ", domicilioNoEncontrado="
				+ domicilioNoEncontrado + ", noQuisieronContestar=" + noQuisieronContestar + ", otro=" + otro
				+ ", porcentajeExitoso=" + porcentajeExitoso + ", porcentajeNoHuboQuienContestara="
				+ porcentajeNoHuboQuienContestara + ", porcentajeMenorDeEdad=" + porcentajeMenorDeEdad
				+ ", porcentajeDomicilioNoEncontrado=" + porcentajeDomicilioNoEncontrado
				+ ", porcentajeNoQuisieronContestar=" + porcentajeNoQuisieronContestar + ", porcentajeOtro="
				+ porcentajeOtro + ", total=" + total + ", totalTotal=" + totalTotal + ", meta=" + meta
				+ ", porcentajeTotal=" + porcentajeTotal + ", porcentajeMeta=" + porcentajeMeta + "]";
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
	public ProgramasEdoMexDO getPrograma() {
		return programa;
	}
	public void setPrograma(ProgramasEdoMexDO programa) {
		this.programa = programa;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
		 DecimalFormat f = new DecimalFormat("#0.00");
		 if (this.total!=0 && this.total!=null) {
				this.porcentajeNoHuboQuienContestara=f.format((double)Math.round(((this.noHuboQuienContestara.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
				this.porcentajeExitoso=f.format((double)Math.round(((this.exitoso.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
				this.porcentajeDomicilioNoEncontrado=f.format((double)Math.round(((this.domicilioNoEncontrado.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
				this.porcentajeMenorDeEdad=f.format((double)Math.round(((this.menorDeEdad/this.total)*100)*100)/100)+"%";
				this.porcentajeNoQuisieronContestar=f.format((double)Math.round(((this.noQuisieronContestar.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
				this.porcentajeOtro=f.format((double)Math.round(((this.otro.doubleValue()/this.total.doubleValue())*100)*100)/100)+"%";
		}
		else {
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
		DecimalFormat f = new DecimalFormat("#0.00");
		this.totalTotal = totalTotal;
		if (this.totalTotal!=0 && this.totalTotal!=null) {
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
		DecimalFormat f = new DecimalFormat("#0.00");
		this.meta = meta;
		if (this.meta!=0 && this.meta!=null) {
			this.porcentajeMeta=f.format((double)Math.round(((this.total.doubleValue()/this.meta.doubleValue())*100)*100)/100)+"%";			
		}
		else {
			this.porcentajeMeta=new String("0.00%");
		}
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
}
