package com.saganet.politik.database.estadisticas;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.CampoTablaEO;
import com.saganet.politik.dominios.OperadoresDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("VariableImportacionEO")
public class VariableImportacionEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 3009369926949964961L;

	private Integer id;
	private Integer idVariable;
	private String tabla;
	private String esquema;
	private CampoTablaEO campo;
	private OperadoresDO operador;
	private String campoEntidad;
	private String campoDFederal;
	private String campoDLocal;
	private String campoMunicipio;
	private String campoSeccion;
	private String campoLocalidad;
	private String campoManzana;
	
	
	
	@Override
	public String toString() {
		return "VariableImportacionEO [id=" + id + ", idVariable=" + idVariable + ", tabla=" + tabla + ", esquema="
				+ esquema + ", campo=" + campo + ", operador=" + operador + ", campoEntidad=" + campoEntidad
				+ ", campoDFederal=" + campoDFederal + ", campoDLocal=" + campoDLocal + ", campoMunicipio="
				+ campoMunicipio + ", campoSeccion=" + campoSeccion + ", campoLocalidad=" + campoLocalidad
				+ ", campoManzana=" + campoManzana + "]";
	}


	public VariableImportacionEO() {
		operador = OperadoresDO.COUNT;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdVariable() {
		return idVariable;
	}

	public void setIdVariable(Integer idVariable) {
		this.idVariable = idVariable;
	}

	public CampoTablaEO getCampo() {
		return campo;
	}

	public void setCampo(CampoTablaEO campo) {
		this.campo = campo;
	}

	public OperadoresDO getOperador() {
		return operador;
	}

	public void setOperador(OperadoresDO operador) {
		this.operador = operador;
	}

	public String getCampoEntidad() {
		return campoEntidad;
	}

	public void setCampoEntidad(String campoEntidad) {
		this.campoEntidad = campoEntidad;
	}

	public String getCampoDFederal() {
		return campoDFederal;
	}

	public void setCampoDFederal(String campoDFederal) {
		this.campoDFederal = campoDFederal;
	}

	public String getCampoDLocal() {
		return campoDLocal;
	}

	public void setCampoDLocal(String campoDLocal) {
		this.campoDLocal = campoDLocal;
	}

	public String getCampoMunicipio() {
		return campoMunicipio;
	}

	public void setCampoMunicipio(String campoMunicipio) {
		this.campoMunicipio = campoMunicipio;
	}

	public String getCampoSeccion() {
		return campoSeccion;
	}

	public void setCampoSeccion(String campoSeccion) {
		this.campoSeccion = campoSeccion;
	}

	public String getCampoLocalidad() {
		return campoLocalidad;
	}

	public void setCampoLocalidad(String campoLocalidad) {
		this.campoLocalidad = campoLocalidad;
	}

	public String getCampoManzana() {
		return campoManzana;
	}

	public void setCampoManzana(String campoManzana) {
		this.campoManzana = campoManzana;
	}


	public String getTabla() {
		return tabla;
	}


	public void setTabla(String tabla) {
		this.tabla = tabla;
	}


	public String getEsquema() {
		return esquema;
	}


	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}


}
