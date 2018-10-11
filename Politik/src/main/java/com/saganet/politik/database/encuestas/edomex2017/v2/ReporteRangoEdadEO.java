package com.saganet.politik.database.encuestas.edomex2017.v2;

import java.io.Serializable;
import java.text.DecimalFormat;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("EncuestaEdomex2017V2ReporteRangoEdadEO")
public class ReporteRangoEdadEO extends JavaBeanT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6741911914893566665L;
	
	
	private DecimalFormat f = new DecimalFormat("#0.00");
	private Integer id;
	private Integer idRegion;
	private String nombreRegion;
	private Integer idMunicipio;
	private String nombreMunicipio;
	private Integer seccion;
	
	// campos de concentrado
	
	private Integer edad1830Exitosas;
	private Integer edad1830aFavor;
	private String edad1830aFavorPorcentaje;
	private Integer edad1830IndecisosAFavor;
	private String edad1830IndecisosAFavorPorcentaje;
	private Integer edad1830Indecisos;
	private String edad1830IndecisosPorcentaje;
	private Integer edad1830IndecisosEnContra;
	private String edad1830IndecisosEnContraPorcentaje;
	private Integer edad1830EnContra;
	private String edad1830EnContraPorcentaje;

	private Integer edad3164Exitosas;
	private Integer edad3164aFavor;
	private String edad3164aFavorPorcentaje;
	private Integer edad3164IndecisosAFavor;
	private String edad3164IndecisosAFavorPorcentaje;
	private Integer edad3164Indecisos;
	private String edad3164IndecisosPorcentaje;
	private Integer edad3164IndecisosEnContra;
	private String edad3164IndecisosEnContraPorcentaje;
	private Integer edad3164EnContra;
	private String edad3164EnContraPorcentaje;

	private Integer edad65masExitosas;
	private Integer edad65masaFavor;
	private Integer edad65masIndecisosAFavor;
	private Integer edad65masIndecisos;
	private Integer edad65masIndecisosEnContra;
	private Integer edad65masEnContra;
	

	private String edad65masEnContraPorcentaje;
	private String edad65masIndecisosEnContraPorcentaje;
	private String edad65masIndecisosPorcentaje;
	private String edad65masIndecisosAFavorPorcentaje;
	private String edad65masaFavorPorcentaje;
	
	

	
	
	@Override
	public String toString() {
		return "ReporteRangoEdadEO [id=" + id + ", idRegion=" + idRegion + ", nombreRegion=" + nombreRegion
				+ ", idMunicipio=" + idMunicipio + ", nombreMunicipio=" + nombreMunicipio + ", seccion=" + seccion
				+ ", edad1830Exitosas=" + edad1830Exitosas + ", edad1830aFavor=" + edad1830aFavor
				+ ", edad1830aFavorPorcentaje=" + edad1830aFavorPorcentaje + ", edad1830IndecisosAFavor="
				+ edad1830IndecisosAFavor + ", edad1830IndecisosAFavorPorcentaje=" + edad1830IndecisosAFavorPorcentaje
				+ ", edad1830Indecisos=" + edad1830Indecisos + ", edad1830IndecisosPorcentaje="
				+ edad1830IndecisosPorcentaje + ", edad1830IndecisosEnContra=" + edad1830IndecisosEnContra
				+ ", edad1830IndecisosEnContraPorcentaje=" + edad1830IndecisosEnContraPorcentaje + ", edad1830EnContra="
				+ edad1830EnContra + ", edad1830EnContraPorcentaje=" + edad1830EnContraPorcentaje
				+ ", edad3164Exitosas=" + edad3164Exitosas + ", edad3164aFavor=" + edad3164aFavor
				+ ", edad3164aFavorPorcentaje=" + edad3164aFavorPorcentaje + ", edad3164IndecisosAFavor="
				+ edad3164IndecisosAFavor + ", edad3164IndecisosAFavorPorcentaje=" + edad3164IndecisosAFavorPorcentaje
				+ ", edad3164Indecisos=" + edad3164Indecisos + ", edad3164IndecisosPorcentaje="
				+ edad3164IndecisosPorcentaje + ", edad3164IndecisosEnContra=" + edad3164IndecisosEnContra
				+ ", edad3164IndecisosEnContraPorcentaje=" + edad3164IndecisosEnContraPorcentaje + ", edad3164EnContra="
				+ edad3164EnContra + ", edad3164EnContraPorcentaje=" + edad3164EnContraPorcentaje
				+ ", edad65masExitosas=" + edad65masExitosas + ", edad65masaFavor=" + edad65masaFavor
				+ ", edad65masaFavorPorcentaje=" + edad65masaFavorPorcentaje + ", edad65masIndecisosAFavor="
				+ edad65masIndecisosAFavor + ", edad65masIndecisosAFavorPorcentaje="
				+ edad65masIndecisosAFavorPorcentaje + ", edad65masIndecisos=" + edad65masIndecisos
				+ ", edad65masIndecisosPorcentaje=" + edad65masIndecisosPorcentaje + ", edad65masIndecisosEnContra="
				+ edad65masIndecisosEnContra + ", edad65masIndecisosEnContraPorcentaje="
				+ edad65masIndecisosEnContraPorcentaje + ", edad65masEnContra=" + edad65masEnContra
				+ ", edad65masEnContraPorcentaje=" + edad65masEnContraPorcentaje + "]";
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
		System.out.println("ID REGION : {}"+idRegion);
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
	public Integer getEdad1830aFavor() {
		return edad1830aFavor;
	}
	public void setEdad1830aFavor(Integer edad1830aFavor) {
		this.edad1830aFavor = edad1830aFavor;
	}
	public String getEdad1830aFavorPorcentaje() {
		return edad1830aFavorPorcentaje;
	}
	public void setEdad1830aFavorPorcentaje(String edad1830aFavorPorcentaje) {
		this.edad1830aFavorPorcentaje = edad1830aFavorPorcentaje;
	}
	public Integer getEdad1830IndecisosAFavor() {
		return edad1830IndecisosAFavor;
	}
	public void setEdad1830IndecisosAFavor(Integer edad1830IndecisosAFavor) {
		this.edad1830IndecisosAFavor = edad1830IndecisosAFavor;
	}
	public String getEdad1830IndecisosAFavorPorcentaje() {
		return edad1830IndecisosAFavorPorcentaje;
	}
	public void setEdad1830IndecisosAFavorPorcentaje(String edad1830IndecisosAFavorPorcentaje) {
		this.edad1830IndecisosAFavorPorcentaje = edad1830IndecisosAFavorPorcentaje;
	}
	public Integer getEdad1830Indecisos() {
		return edad1830Indecisos;
	}
	public void setEdad1830Indecisos(Integer edad1830Indecisos) {
		this.edad1830Indecisos = edad1830Indecisos;
	}
	public String getEdad1830IndecisosPorcentaje() {
		return edad1830IndecisosPorcentaje;
	}
	public void setEdad1830IndecisosPorcentaje(String edad1830IndecisosPorcentaje) {
		this.edad1830IndecisosPorcentaje = edad1830IndecisosPorcentaje;
	}
	public Integer getEdad1830IndecisosEnContra() {
		return edad1830IndecisosEnContra;
	}
	public void setEdad1830IndecisosEnContra(Integer edad1830IndecisosEnContra) {
		this.edad1830IndecisosEnContra = edad1830IndecisosEnContra;
	}
	public String getEdad1830IndecisosEnContraPorcentaje() {
		return edad1830IndecisosEnContraPorcentaje;
	}
	public void setEdad1830IndecisosEnContraPorcentaje(String edad1830IndecisosEnContraPorcentaje) {
		this.edad1830IndecisosEnContraPorcentaje = edad1830IndecisosEnContraPorcentaje;
	}
	public Integer getEdad1830EnContra() {
		return edad1830EnContra;
	}
	public void setEdad1830EnContra(Integer edad1830EnContra) {
		this.edad1830EnContra = edad1830EnContra;
	}
	public String getEdad1830EnContraPorcentaje() {
		return edad1830EnContraPorcentaje;
	}
	public void setEdad1830EnContraPorcentaje(String edad1830EnContraPorcentaje) {
		this.edad1830EnContraPorcentaje = edad1830EnContraPorcentaje;
	}
	public Integer getEdad3164aFavor() {
		return edad3164aFavor;
	}
	public void setEdad3164aFavor(Integer edad3164aFavor) {
		this.edad3164aFavor = edad3164aFavor;
	}
	public String getEdad3164aFavorPorcentaje() {
		return edad3164aFavorPorcentaje;
	}
	public void setEdad3164aFavorPorcentaje(String edad3164aFavorPorcentaje) {
		this.edad3164aFavorPorcentaje = edad3164aFavorPorcentaje;
	}
	public Integer getEdad3164IndecisosAFavor() {
		return edad3164IndecisosAFavor;
	}
	public void setEdad3164IndecisosAFavor(Integer edad3164IndecisosAFavor) {
		this.edad3164IndecisosAFavor = edad3164IndecisosAFavor;
	}
	public String getEdad3164IndecisosAFavorPorcentaje() {
		return edad3164IndecisosAFavorPorcentaje;
	}
	public void setEdad3164IndecisosAFavorPorcentaje(String edad3164IndecisosAFavorPorcentaje) {
		this.edad3164IndecisosAFavorPorcentaje = edad3164IndecisosAFavorPorcentaje;
	}
	public Integer getEdad3164Indecisos() {
		return edad3164Indecisos;
	}
	public void setEdad3164Indecisos(Integer edad3164Indecisos) {
		this.edad3164Indecisos = edad3164Indecisos;
	}
	public String getEdad3164IndecisosPorcentaje() {
		return edad3164IndecisosPorcentaje;
	}
	public void setEdad3164IndecisosPorcentaje(String edad3164IndecisosPorcentaje) {
		this.edad3164IndecisosPorcentaje = edad3164IndecisosPorcentaje;
	}
	public Integer getEdad3164IndecisosEnContra() {
		return edad3164IndecisosEnContra;
	}
	public void setEdad3164IndecisosEnContra(Integer edad3164IndecisosEnContra) {
		this.edad3164IndecisosEnContra = edad3164IndecisosEnContra;
	}
	public String getEdad3164IndecisosEnContraPorcentaje() {
		return edad3164IndecisosEnContraPorcentaje;
	}
	public void setEdad3164IndecisosEnContraPorcentaje(String edad3164IndecisosEnContraPorcentaje) {
		this.edad3164IndecisosEnContraPorcentaje = edad3164IndecisosEnContraPorcentaje;
	}
	public Integer getEdad3164EnContra() {
		return edad3164EnContra;
	}
	public void setEdad3164EnContra(Integer edad3164EnContra) {
		this.edad3164EnContra = edad3164EnContra;
	}
	public String getEdad3164EnContraPorcentaje() {
		return edad3164EnContraPorcentaje;
	}
	public void setEdad3164EnContraPorcentaje(String edad3164EnContraPorcentaje) {
		this.edad3164EnContraPorcentaje = edad3164EnContraPorcentaje;
	}
	public Integer getEdad65masaFavor() {
		return edad65masaFavor;
	}
	public void setEdad65masaFavor(Integer edad65masaFavor) {
		this.edad65masaFavor = edad65masaFavor;
	}
	public String getEdad65masaFavorPorcentaje() {
		return edad65masaFavorPorcentaje;
	}
	public void setEdad65masaFavorPorcentaje(String edad65masaFavorPorcentaje) {
		this.edad65masaFavorPorcentaje = edad65masaFavorPorcentaje;
	}
	public Integer getEdad65masIndecisosAFavor() {
		return edad65masIndecisosAFavor;
	}
	public void setEdad65masIndecisosAFavor(Integer edad65masIndecisosAFavor) {
		this.edad65masIndecisosAFavor = edad65masIndecisosAFavor;
	}
	public String getEdad65masIndecisosAFavorPorcentaje() {
		return edad65masIndecisosAFavorPorcentaje;
	}
	public void setEdad65masIndecisosAFavorPorcentaje(String edad65masIndecisosAFavorPorcentaje) {
		this.edad65masIndecisosAFavorPorcentaje = edad65masIndecisosAFavorPorcentaje;
	}
	public Integer getEdad65masIndecisos() {
		return edad65masIndecisos;
	}
	public void setEdad65masIndecisos(Integer edad65masIndecisos) {
		this.edad65masIndecisos = edad65masIndecisos;
	}
	public String getEdad65masIndecisosPorcentaje() {
		return edad65masIndecisosPorcentaje;
	}
	public void setEdad65masIndecisosPorcentaje(String edad65masIndecisosPorcentaje) {
		this.edad65masIndecisosPorcentaje = edad65masIndecisosPorcentaje;
	}
	public Integer getEdad65masIndecisosEnContra() {
		return edad65masIndecisosEnContra;
	}
	public void setEdad65masIndecisosEnContra(Integer edad65masIndecisosEnContra) {
		this.edad65masIndecisosEnContra = edad65masIndecisosEnContra;
	}
	public String getEdad65masIndecisosEnContraPorcentaje() {
		return edad65masIndecisosEnContraPorcentaje;
	}
	public void setEdad65masIndecisosEnContraPorcentaje(String edad65masIndecisosEnContraPorcentaje) {
		this.edad65masIndecisosEnContraPorcentaje = edad65masIndecisosEnContraPorcentaje;
	}
	public Integer getEdad65masEnContra() {
		return edad65masEnContra;
	}
	public void setEdad65masEnContra(Integer edad65masEnContra) {
		this.edad65masEnContra = edad65masEnContra;
	}
	public String getEdad65masEnContraPorcentaje() {
		return edad65masEnContraPorcentaje;
	}
	public void setEdad65masEnContraPorcentaje(String edad65masEnContraPorcentaje) {
		this.edad65masEnContraPorcentaje = edad65masEnContraPorcentaje;
	}
	


	public Integer getEdad1830Exitosas() {
		return edad1830Exitosas;
	}
	public void setEdad1830Exitosas(Integer edad1830Exitosas) {
		this.edad1830Exitosas = edad1830Exitosas;
		if(edad1830Exitosas>0){
			this.edad1830aFavorPorcentaje=f.format((double)Math.round(((this.edad1830aFavor.doubleValue()/this.edad1830Exitosas.doubleValue())*100)*100)/100)+"%";
			this.edad1830IndecisosAFavorPorcentaje=f.format((double)Math.round(((this.edad1830IndecisosAFavor.doubleValue()/this.edad1830Exitosas.doubleValue())*100)*100)/100)+"%";
			this.edad1830IndecisosPorcentaje=f.format((double)Math.round(((this.edad1830Indecisos.doubleValue()/this.edad1830Exitosas.doubleValue())*100)*100)/100)+"%";
			this.edad1830IndecisosEnContraPorcentaje=f.format((double)Math.round(((this.edad1830IndecisosEnContra.doubleValue()/this.edad1830Exitosas.doubleValue())*100)*100)/100)+"%";
			this.edad1830EnContraPorcentaje=f.format((double)Math.round(((this.edad1830EnContra.doubleValue()/this.edad1830Exitosas.doubleValue())*100)*100)/100)+"%";
		}else{
			this.edad1830aFavorPorcentaje=new String("0.00%");
			this.edad1830IndecisosAFavorPorcentaje=new String("0.00%");
			this.edad1830IndecisosPorcentaje=new String("0.00%");
			this.edad1830IndecisosEnContraPorcentaje=new String("0.00%");
			this.edad1830EnContraPorcentaje=new String("0.00%");
		}
	}
	public Integer getEdad3164Exitosas() {
		return edad3164Exitosas;
	}
	public void setEdad3164Exitosas(Integer edad3164Exitosas) {
		this.edad3164Exitosas = edad3164Exitosas;
		if(edad3164Exitosas>0){
			this.edad3164aFavorPorcentaje=f.format((double)Math.round(((this.edad3164aFavor.doubleValue()/this.edad3164Exitosas.doubleValue())*100)*100)/100)+"%";
			this.edad3164IndecisosAFavorPorcentaje=f.format((double)Math.round(((this.edad3164IndecisosAFavor.doubleValue()/this.edad3164Exitosas.doubleValue())*100)*100)/100)+"%";
			this.edad3164IndecisosPorcentaje=f.format((double)Math.round(((this.edad3164Indecisos.doubleValue()/this.edad3164Exitosas.doubleValue())*100)*100)/100)+"%";
			this.edad3164IndecisosEnContraPorcentaje=f.format((double)Math.round(((this.edad3164IndecisosEnContra.doubleValue()/this.edad3164Exitosas.doubleValue())*100)*100)/100)+"%";
			this.edad3164EnContraPorcentaje=f.format((double)Math.round(((this.edad3164EnContra.doubleValue()/this.edad3164Exitosas.doubleValue())*100)*100)/100)+"%";
		}else{
			this.edad3164aFavorPorcentaje=new String("0.00%");
			this.edad3164IndecisosAFavorPorcentaje=new String("0.00%");
			this.edad3164IndecisosPorcentaje=new String("0.00%");
			this.edad3164IndecisosEnContraPorcentaje=new String("0.00%");
			this.edad3164EnContraPorcentaje=new String("0.00%");

		}
	}
	public Integer getEdad65masExitosas() {
		return edad65masExitosas;
	}
	public void setEdad65masExitosas(Integer edad65masExitosas) {
		this.edad65masExitosas = edad65masExitosas;
		if(edad65masExitosas>0){
			this.edad65masaFavorPorcentaje=f.format((double)Math.round(((this.edad65masaFavor.doubleValue()/this.edad65masExitosas.doubleValue())*100)*100)/100)+"%";
			this.edad65masIndecisosAFavorPorcentaje=f.format((double)Math.round(((this.edad65masIndecisosAFavor.doubleValue()/this.edad65masExitosas.doubleValue())*100)*100)/100)+"%";
			this.edad65masIndecisosPorcentaje=f.format((double)Math.round(((this.edad65masIndecisos.doubleValue()/this.edad65masExitosas.doubleValue())*100)*100)/100)+"%";
			this.edad65masIndecisosEnContraPorcentaje=f.format((double)Math.round(((this.edad65masIndecisosEnContra.doubleValue()/this.edad65masExitosas.doubleValue())*100)*100)/100)+"%";
			this.edad65masEnContraPorcentaje=f.format((double)Math.round(((this.edad65masEnContra.doubleValue()/this.edad65masExitosas.doubleValue())*100)*100)/100)+"%";
		}else{
			this.edad65masaFavorPorcentaje=new String("0.00%");
			this.edad65masIndecisosAFavorPorcentaje=new String("0.00%");
			this.edad65masIndecisosPorcentaje=new String("0.00%");
			this.edad65masIndecisosEnContraPorcentaje=new String("0.00%");
			this.edad65masEnContraPorcentaje=new String("0.00%");

		}
	}
}
