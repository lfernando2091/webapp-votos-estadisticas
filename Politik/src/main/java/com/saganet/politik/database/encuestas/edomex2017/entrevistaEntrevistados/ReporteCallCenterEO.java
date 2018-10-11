package com.saganet.politik.database.encuestas.edomex2017.entrevistaEntrevistados;

import java.io.Serializable;
import java.text.DecimalFormat;
import org.apache.ibatis.type.Alias;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("Edomex2017EntrevistadosReporteCallCenterEO")
public class ReporteCallCenterEO extends JavaBeanT implements Serializable {


	private static final long serialVersionUID = 4297439159722469278L;
	private DecimalFormat f = new DecimalFormat("#0.00");
	private Integer id;
	private String lugar;
	private Integer meta;
	private Integer realizadas;
	private String realizadasProcentaje;
	
	@Override
	public String toString() {
		return "ReporteCallCenterEO [id=" + id + ", lugar=" + lugar + ", meta=" + meta + ", realizadas=" + realizadas
				+ ", realizadasProcentaje=" + realizadasProcentaje + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public Integer getRealizadas() {
		return realizadas;
	}
	public void setRealizadas(Integer realizadas) {
		this.realizadas = realizadas;
	}
	public String getRealizadasProcentaje() {
		return realizadasProcentaje;
	}
	public void setRealizadasProcentaje(String realizadasProcentaje) {
		this.realizadasProcentaje = realizadasProcentaje;
	}
	public Integer getMeta() {
		return meta;
	}
	public void setMeta(Integer meta) {
		this.meta = meta;
		if (this.meta!=0) {
			this.realizadasProcentaje=f.format((double)Math.round(((this.realizadas.doubleValue()/this.meta.doubleValue())*100)*100)/100)+"%";			
		}
		else{
			this.realizadasProcentaje=new String("0.00%");
		}
	}
	
	
}
