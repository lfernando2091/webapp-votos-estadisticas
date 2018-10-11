package com.saganet.politik.database.diaD.prep;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.dominios.PartidosEleccionEdomex2017DO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("DiaDPrepReporteMunicipioEO")
public class PrepReporteMunicipioEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 4478618896727896234L;
	
	private	Integer								id;
	private MunicipioEO         				municipio;
	private	Integer								pan;
	private Integer								pri;
	private	Integer								prd;
	private	Integer								pt;
	private	Integer								morena;
	private	Integer								independiente;
	private PartidosEleccionEdomex2017DO 		ganador;
		
	@Override
	public String toString() {
		return "PrepReporteMunicipioEO [id=" + id + ", municipio=" + municipio + ", pan=" + pan + ", pri=" + pri
				+ ", prd=" + prd + ", pt=" + pt + ", morena=" + morena + ", independiente=" + independiente
				+ ", ganador=" + ganador + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MunicipioEO getMunicipio() {
		return municipio;
	}
	public void setMunicipio(MunicipioEO municipio) {
		this.municipio = municipio;
	}
	public Integer getPan() {
		return pan;
	}
	public void setPan(Integer pan) {
		this.pan = pan;
	}
	public Integer getPri() {
		return pri;
	}
	public void setPri(Integer pri) {
		this.pri = pri;
	}
	public Integer getPrd() {
		return prd;
	}
	public void setPrd(Integer prd) {
		this.prd = prd;
	}
	public Integer getPt() {
		return pt;
	}
	public void setPt(Integer pt) {
		this.pt = pt;
	}
	public Integer getMorena() {
		return morena;
	}
	public void setMorena(Integer morena) {
		this.morena = morena;
	}
	public Integer getIndependiente() {
		return independiente;
	}
	public void setIndependiente(Integer independiente) {
		this.independiente = independiente;
	}
	public PartidosEleccionEdomex2017DO getGanador() {
		return ganador;
	}
	public void setGanador(PartidosEleccionEdomex2017DO ganador) {
		this.ganador = ganador;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getPriF() {
		return String.format("%,d", pri);
	}
	public String getPanF() {
		return String.format("%,d", pan);
	}
	public String getPrdF() {
		return String.format("%,d", prd);
	}
	public String getPtF() {
		return String.format("%,d", pt);
	}
	public String getMorenaF() {
		return String.format("%,d", morena);
	}
	public String getIndependienteF() {
		return String.format("%,d", independiente);
	}
}
