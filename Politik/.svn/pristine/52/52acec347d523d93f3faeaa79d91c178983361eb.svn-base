package com.saganet.politik.database.estadisticas;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.EstatusVariableDO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.TipoVariableDO;
import com.saganet.politik.dominios.TiposCampoDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("VariableEO")
public class VariableEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 5295316149357318768L;

	private Integer id;
	private String campo;
	private String descripcion;
	private TiposCampoDO tipo;
	private String valorDefault;
	private Boolean entidad;
	private Boolean dfederal;
	private Boolean dlocal;
	private Boolean municipio;
	private Boolean seccion;
	private Boolean localidad;
	private Boolean manzana;
	private ConsultaEO consulta;
	private EstatusVariableDO estatus;
	private TipoVariableDO tipoVariable;
	private NivelesDO nivelCalculo;
	private Boolean agruparGeozona;
	private VariableImportacionEO importacion;
	
	public VariableEO(){
		entidad = false;
		dfederal = false;
		dlocal = false;
		municipio = false;
		seccion = false;
		localidad = false;
		manzana = false;
		agruparGeozona = false;
		tipo = TiposCampoDO.INTEGER;
		consulta = new ConsultaEO();
		importacion = new VariableImportacionEO();
		estatus = EstatusVariableDO.PENDIENTE;
		setNivelCalculo(NivelesDO.ENTIDAD);
	}

	


	@Override
	public String toString() {
		return "VariableEO [id=" + id + ", campo=" + campo + ", descripcion=" + descripcion + ", tipo=" + tipo
				+ ", valorDefault=" + valorDefault + ", entidad=" + entidad + ", dfederal=" + dfederal + ", dlocal="
				+ dlocal + ", municipio=" + municipio + ", seccion=" + seccion + ", localidad=" + localidad
				+ ", manzana=" + manzana + ", consulta=" + consulta + ", estatus=" + estatus + ", tipoVariable="
				+ tipoVariable + ", nivelCalculo=" + nivelCalculo + ", agruparGeozona=" + agruparGeozona
				+ ", importacion=" + importacion + "]";
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TiposCampoDO getTipo() {
		return tipo;
	}

	public void setTipo(TiposCampoDO tipo) {
		this.tipo = tipo;
	}

	public String getValorDefault() {
		return valorDefault;
	}

	public void setValorDefault(String valorDefault) {
		this.valorDefault = valorDefault;
	}

	public Boolean getEntidad() {
		return entidad;
	}

	public void setEntidad(Boolean entidad) {
		this.entidad = entidad;
	}

	public Boolean getDfederal() {
		return dfederal;
	}

	public void setDfederal(Boolean dfederal) {
		this.dfederal = dfederal;
	}

	public Boolean getDlocal() {
		return dlocal;
	}

	public void setDlocal(Boolean dlocal) {
		this.dlocal = dlocal;
	}

	public Boolean getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Boolean municipio) {
		this.municipio = municipio;
	}

	public Boolean getSeccion() {
		return seccion;
	}

	public void setSeccion(Boolean seccion) {
		this.seccion = seccion;
	}

	public Boolean getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Boolean localidad) {
		this.localidad = localidad;
	}

	public Boolean getManzana() {
		return manzana;
	}

	public void setManzana(Boolean manzana) {
		this.manzana = manzana;
	}

	public ConsultaEO getConsulta() {
		return consulta;
	}

	public void setConsulta(ConsultaEO consulta) {
		this.consulta = consulta;
	}

	public EstatusVariableDO getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusVariableDO estatus) {
		this.estatus = estatus;
	}

	public NivelesDO getNivelCalculo() {
		return nivelCalculo;
	}

	public void setNivelCalculo(NivelesDO nivelCalculo) {
		this.nivelCalculo = nivelCalculo;
	}

	public Boolean getAgruparGeozona() {
		return agruparGeozona;
	}

	public void setAgruparGeozona(Boolean agruparGeozona) {
		this.agruparGeozona = agruparGeozona;
	}

	public TipoVariableDO getTipoVariable() {
		return tipoVariable;
	}
	public void setTipoVariable(TipoVariableDO tipoVariable) {
		this.tipoVariable = tipoVariable;
	}
	public VariableImportacionEO getImportacion() {
		return importacion;
	}
	public void setImportacion(VariableImportacionEO importacion) {
		this.importacion = importacion;
	}
	
}
