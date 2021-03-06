package com.saganet.politik.database.estructuras;

import java.io.Serializable;
import java.sql.Date;

import com.saganet.politik.database.catalogos.ComisionCongresoUnionEO;
import com.saganet.politik.database.catalogos.PartidoEO;
import com.saganet.politik.dominios.CargosComisionCongresoUnionDO;
import com.saganet.politik.dominios.FiguraAtributosDO;
import com.saganet.politik.dominios.TiposSenadorDO;
import com.saganet.politik.modelos.JavaBeanT;

public class FiguraAtributoEO extends JavaBeanT implements Serializable {
	@Override
	public String toString() {
		return "FiguraAtributoEO [id=" + id + ", idPolitikPadre=" + idPolitikPadre + ", atributo=" + atributo
				+ ", programaPromocion=" + programaPromocion + ", partidoPolitico=" + partidoPolitico + ", fechaInicio="
				+ fechaInicio + ", fechaTermino=" + fechaTermino + ", vigente=" + vigente + ", legislatura="
				+ legislatura + ", tipoSenador=" + tipoSenador + "]";
	}

	private static final long serialVersionUID = 4292563589047384094L;

	private Integer id;
	private Integer idPolitikPadre;
	private FiguraAtributosDO atributo;

	// Atributo: Programa de Promocion
	private ProgramaPromocionEO programaPromocion;

	// Atributo: Partido Politico	
	private PartidoEO partidoPolitico;
	
	//Atributo: Periodo
	private Date fechaInicio;
	private Date fechaTermino;
	private Boolean vigente;
	
	//Atributo: Legislatura
	private LegislaturaEO legislatura;
	
	//Atributo: Tipo de Senador
	private TiposSenadorDO tipoSenador;
	
	//Atributo: Comision Congreso Union
	private ComisionCongresoUnionEO comision;
	private CargosComisionCongresoUnionDO comisionCargo;
	//Nota: Se utilizaran tambien los atributos de periodo
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPolitikPadre() {
		return idPolitikPadre;
	}

	public void setIdPolitikPadre(Integer idPolitikPadre) {
		this.idPolitikPadre = idPolitikPadre;
	}

	public FiguraAtributosDO getAtributo() {
		return atributo;
	}

	public void setAtributo(FiguraAtributosDO atributo) {
		this.atributo = atributo;
	}

	public ProgramaPromocionEO getProgramaPromocion() {
		return programaPromocion;
	}

	public void setProgramaPromocion(ProgramaPromocionEO programaPromocion) {
		this.programaPromocion = programaPromocion;
	}

	public PartidoEO getPartidoPolitico() {
		return partidoPolitico;
	}

	public void setPartidoPolitico(PartidoEO partidoPolitico) {
		this.partidoPolitico = partidoPolitico;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	public LegislaturaEO getLegislatura() {
		return legislatura;
	}

	public void setLegislatura(LegislaturaEO legislatura) {
		this.legislatura = legislatura;
	}

	public TiposSenadorDO getTipoSenador() {
		return tipoSenador;
	}

	public void setTipoSenador(TiposSenadorDO tipoSenador) {
		this.tipoSenador = tipoSenador;
	}

	public ComisionCongresoUnionEO getComision() {
		return comision;
	}

	public void setComision(ComisionCongresoUnionEO comision) {
		this.comision = comision;
	}

	public CargosComisionCongresoUnionDO getComisionCargo() {
		return comisionCargo;
	}

	public void setComisionCargo(CargosComisionCongresoUnionDO comisionCargo) {
		this.comisionCargo = comisionCargo;
	}

}
