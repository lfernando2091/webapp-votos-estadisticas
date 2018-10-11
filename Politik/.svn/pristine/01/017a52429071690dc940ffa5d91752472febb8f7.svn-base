package com.saganet.politik.database.encuestas.sujetosSociales.v2;

import java.io.Serializable;
import java.text.DecimalFormat;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("EncuestaSujetosSocialesV2ReporteGeneroEO")
public class ReporteGeneroEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = 4153383211580365532L;

	private DecimalFormat f = new DecimalFormat("#0.00");
	
	private Integer id;
	private Integer idRegion;
	private String nombreRegion;
	private Integer idMunicipio;
	private String nombreMunicipio;
	private Integer seccion;
	private Integer hombresEnContra;
	private Integer hombresIndecisoEnContra;
	private Integer hombresIndeciso;
	private Integer hombresIndecisoAFavor;
	private Integer hombresAFavor;
	private Integer hombresExitosas;
	private Integer mujeresEnContra;
	private Integer mujeresIndecisoEnContra;
	private Integer mujeresIndeciso;
	private Integer mujeresIndecisoAFavor;
	private Integer mujeresAFavor;
	private Integer mujeresExitosas;
	
	private String hombresEnContraPorcentaje;
	private String hombresIndecisoEnContraPorcentaje;
	private String hombresIndecisoPorcentaje;
	private String hombresIndecisoAFavorPorcentaje;
	private String hombresAFavorPorcentaje;
	private String hombresExitosasPorcentaje;
	private String mujeresEnContraPorcentaje;
	private String mujeresIndecisoEnContraPorcentaje;
	private String mujeresIndecisoPorcentaje;
	private String mujeresIndecisoAFavorPorcentaje;
	private String mujeresAFavorPorcentaje;
	private String mujeresExitosasPorcentaje;
	
	@Override
	public String toString() {
		return "ReporteGeneroEO [id=" + id + ", idRegion=" + idRegion + ", nombreRegion=" + nombreRegion
				+ ", idMunicipio=" + idMunicipio + ", nombreMunicipio=" + nombreMunicipio + ", seccion=" + seccion
				+ ", hombresEnContra=" + hombresEnContra + ", hombresIndecisoEnContra=" + hombresIndecisoEnContra
				+ ", hombresIndeciso=" + hombresIndeciso + ", hombresIndecisoAFavor=" + hombresIndecisoAFavor
				+ ", hombresAFavor=" + hombresAFavor + ", hombresExitosas=" + hombresExitosas + ", mujeresEnContra="
				+ mujeresEnContra + ", mujeresIndecisoEnContra=" + mujeresIndecisoEnContra + ", mujeresIndeciso="
				+ mujeresIndeciso + ", mujeresIndecisoAFavor=" + mujeresIndecisoAFavor + ", mujeresAFavor="
				+ mujeresAFavor + ", mujeresExitosas=" + mujeresExitosas + ", hombresEnContraPorcentaje="
				+ hombresEnContraPorcentaje + ", hombresIndecisoEnContraPorcentaje=" + hombresIndecisoEnContraPorcentaje
				+ ", hombresIndecisoPorcentaje=" + hombresIndecisoPorcentaje + ", hombresIndecisoAFavorPorcentaje="
				+ hombresIndecisoAFavorPorcentaje + ", hombresAFavorPorcentaje=" + hombresAFavorPorcentaje
				+ ", hombresExitosasPorcentaje=" + hombresExitosasPorcentaje + ", mujeresEnContraPorcentaje="
				+ mujeresEnContraPorcentaje + ", mujeresIndecisoEnContraPorcentaje=" + mujeresIndecisoEnContraPorcentaje
				+ ", mujeresIndecisoPorcentaje=" + mujeresIndecisoPorcentaje + ", mujeresIndecisoAFavorPorcentaje="
				+ mujeresIndecisoAFavorPorcentaje + ", mujeresAFavorPorcentaje=" + mujeresAFavorPorcentaje
				+ ", mujeresExitosasPorcentaje=" + mujeresExitosasPorcentaje + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}
	public String getNombreRegion() {
		return nombreRegion;
	}
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
	public Integer getSeccion() {
		return seccion;
	}
	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}
	public Integer getHombresEnContra() {
		return hombresEnContra;
	}
	public void setHombresEnContra(Integer hombresEnContra) {
		this.hombresEnContra = hombresEnContra;
	}
	public Integer getHombresIndecisoEnContra() {
		return hombresIndecisoEnContra;
	}
	public void setHombresIndecisoEnContra(Integer hombresIndecisoEnContra) {
		this.hombresIndecisoEnContra = hombresIndecisoEnContra;
	}
	public Integer getHombresIndeciso() {
		return hombresIndeciso;
	}
	public void setHombresIndeciso(Integer hombresIndeciso) {
		this.hombresIndeciso = hombresIndeciso;
	}
	public Integer getHombresIndecisoAFavor() {
		return hombresIndecisoAFavor;
	}
	public void setHombresIndecisoAFavor(Integer hombresIndecisoAFavor) {
		this.hombresIndecisoAFavor = hombresIndecisoAFavor;
	}
	public Integer getHombresAFavor() {
		return hombresAFavor;
	}
	public void setHombresAFavor(Integer hombresAFavor) {
		this.hombresAFavor = hombresAFavor;
	}
	public Integer getHombresExitosas() {
		return hombresExitosas;
	}
	public void setHombresExitosas(Integer hombresExitosas) {
		this.hombresExitosas = hombresExitosas;
		if(hombresExitosas>0){
			this.hombresEnContraPorcentaje=f.format((double)Math.round(((this.hombresEnContra.doubleValue()/this.hombresExitosas.doubleValue())*100)*100)/100)+"%";
			this.hombresIndecisoEnContraPorcentaje=f.format((double)Math.round(((this.hombresIndecisoEnContra.doubleValue()/this.hombresExitosas.doubleValue())*100)*100)/100)+"%";
			this.hombresIndecisoPorcentaje=f.format((double)Math.round(((this.hombresIndeciso.doubleValue()/this.hombresExitosas.doubleValue())*100)*100)/100)+"%";
			this.hombresIndecisoAFavorPorcentaje=f.format((double)Math.round(((this.hombresIndecisoAFavor.doubleValue()/this.hombresExitosas.doubleValue())*100)*100)/100)+"%";
			this.hombresAFavorPorcentaje=f.format((double)Math.round(((this.hombresAFavor.doubleValue()/this.hombresExitosas.doubleValue())*100)*100)/100)+"%";
			this.hombresExitosasPorcentaje=f.format((double)Math.round(((this.hombresExitosas.doubleValue()/this.hombresExitosas.doubleValue())*100)*100)/100)+"%";
			
		}else{
			this.hombresEnContraPorcentaje=new String("0.00%");
			this.hombresIndecisoEnContraPorcentaje=new String("0.00%");
			this.hombresIndecisoPorcentaje=new String("0.00%");
			this.hombresIndecisoAFavorPorcentaje=new String("0.00%");
			this.hombresAFavorPorcentaje=new String("0.00%");
			this.hombresExitosasPorcentaje=new String("0.00%");
		}
	}
	public Integer getMujeresEnContra() {
		return mujeresEnContra;
	}
	public void setMujeresEnContra(Integer mujeresEnContra) {
		this.mujeresEnContra = mujeresEnContra;
	}
	public Integer getMujeresIndecisoEnContra() {
		return mujeresIndecisoEnContra;
	}
	public void setMujeresIndecisoEnContra(Integer mujeresIndecisoEnContra) {
		this.mujeresIndecisoEnContra = mujeresIndecisoEnContra;
	}
	public Integer getMujeresIndeciso() {
		return mujeresIndeciso;
	}
	public void setMujeresIndeciso(Integer mujeresIndeciso) {
		this.mujeresIndeciso = mujeresIndeciso;
	}
	public Integer getMujeresIndecisoAFavor() {
		return mujeresIndecisoAFavor;
	}
	public void setMujeresIndecisoAFavor(Integer mujeresIndecisoAFavor) {
		this.mujeresIndecisoAFavor = mujeresIndecisoAFavor;
	}
	public Integer getMujeresAFavor() {
		return mujeresAFavor;
	}
	public void setMujeresAFavor(Integer mujeresAFavor) {
		this.mujeresAFavor = mujeresAFavor;
	}
	public Integer getMujeresExitosas() {
		return mujeresExitosas;
	}
	public void setMujeresExitosas(Integer mujeresExitosas) {
		this.mujeresExitosas = mujeresExitosas;
		
		if(mujeresExitosas>0){
			this.mujeresEnContraPorcentaje=f.format((double)Math.round(((this.mujeresEnContra.doubleValue()/this.mujeresExitosas.doubleValue())*100)*100)/100)+"%";
			this.mujeresIndecisoEnContraPorcentaje=f.format((double)Math.round(((this.mujeresIndecisoEnContra.doubleValue()/this.mujeresExitosas.doubleValue())*100)*100)/100)+"%";
			this.mujeresIndecisoPorcentaje=f.format((double)Math.round(((this.mujeresIndeciso.doubleValue()/this.mujeresExitosas.doubleValue())*100)*100)/100)+"%";
			this.mujeresIndecisoAFavorPorcentaje=f.format((double)Math.round(((this.mujeresIndecisoAFavor.doubleValue()/this.mujeresExitosas.doubleValue())*100)*100)/100)+"%";
			this.mujeresAFavorPorcentaje=f.format((double)Math.round(((this.mujeresAFavor.doubleValue()/this.mujeresExitosas.doubleValue())*100)*100)/100)+"%";
			this.mujeresExitosasPorcentaje=f.format((double)Math.round(((this.mujeresExitosas.doubleValue()/this.mujeresExitosas.doubleValue())*100)*100)/100)+"%";
		}else{
			this.mujeresEnContraPorcentaje=new String("0.00%");
			this.mujeresIndecisoEnContraPorcentaje=new String("0.00%");
			this.mujeresIndecisoPorcentaje=new String("0.00%");
			this.mujeresIndecisoAFavorPorcentaje=new String("0.00%");
			this.mujeresAFavorPorcentaje=new String("0.00%");
			this.mujeresExitosasPorcentaje=new String("0.00%");
		}
	}
	public String getHombresEnContraPorcentaje() {
		return hombresEnContraPorcentaje;
	}
	public void setHombresEnContraPorcentaje(String hombresEnContraPorcentaje) {
		this.hombresEnContraPorcentaje = hombresEnContraPorcentaje;
	}
	public String getHombresIndecisoEnContraPorcentaje() {
		return hombresIndecisoEnContraPorcentaje;
	}
	public void setHombresIndecisoEnContraPorcentaje(String hombresIndecisoEnContraPorcentaje) {
		this.hombresIndecisoEnContraPorcentaje = hombresIndecisoEnContraPorcentaje;
	}
	public String getHombresIndecisoPorcentaje() {
		return hombresIndecisoPorcentaje;
	}
	public void setHombresIndecisoPorcentaje(String hombresIndecisoPorcentaje) {
		this.hombresIndecisoPorcentaje = hombresIndecisoPorcentaje;
	}
	public String getHombresIndecisoAFavorPorcentaje() {
		return hombresIndecisoAFavorPorcentaje;
	}
	public void setHombresIndecisoAFavorPorcentaje(String hombresIndecisoAFavorPorcentaje) {
		this.hombresIndecisoAFavorPorcentaje = hombresIndecisoAFavorPorcentaje;
	}
	public String getHombresAFavorPorcentaje() {
		return hombresAFavorPorcentaje;
	}
	public void setHombresAFavorPorcentaje(String hombresAFavorPorcentaje) {
		this.hombresAFavorPorcentaje = hombresAFavorPorcentaje;
	}
	public String getHombresExitosasPorcentaje() {
		return hombresExitosasPorcentaje;
	}
	public void setHombresExitosasPorcentaje(String hombresExitosasPorcentaje) {
		this.hombresExitosasPorcentaje = hombresExitosasPorcentaje;
	}
	public String getMujeresEnContraPorcentaje() {
		return mujeresEnContraPorcentaje;
	}
	public void setMujeresEnContraPorcentaje(String mujeresEnContraPorcentaje) {
		this.mujeresEnContraPorcentaje = mujeresEnContraPorcentaje;
	}
	public String getMujeresIndecisoEnContraPorcentaje() {
		return mujeresIndecisoEnContraPorcentaje;
	}
	public void setMujeresIndecisoEnContraPorcentaje(String mujeresIndecisoEnContraPorcentaje) {
		this.mujeresIndecisoEnContraPorcentaje = mujeresIndecisoEnContraPorcentaje;
	}
	public String getMujeresIndecisoPorcentaje() {
		return mujeresIndecisoPorcentaje;
	}
	public void setMujeresIndecisoPorcentaje(String mujeresIndecisoPorcentaje) {
		this.mujeresIndecisoPorcentaje = mujeresIndecisoPorcentaje;
	}
	public String getMujeresIndecisoAFavorPorcentaje() {
		return mujeresIndecisoAFavorPorcentaje;
	}
	public void setMujeresIndecisoAFavorPorcentaje(String mujeresIndecisoAFavorPorcentaje) {
		this.mujeresIndecisoAFavorPorcentaje = mujeresIndecisoAFavorPorcentaje;
	}
	public String getMujeresAFavorPorcentaje() {
		return mujeresAFavorPorcentaje;
	}
	public void setMujeresAFavorPorcentaje(String mujeresAFavorPorcentaje) {
		this.mujeresAFavorPorcentaje = mujeresAFavorPorcentaje;
	}
	public String getMujeresExitosasPorcentaje() {
		return mujeresExitosasPorcentaje;
	}
	public void setMujeresExitosasPorcentaje(String mujeresExitosasPorcentaje) {
		this.mujeresExitosasPorcentaje = mujeresExitosasPorcentaje;
	}
}
