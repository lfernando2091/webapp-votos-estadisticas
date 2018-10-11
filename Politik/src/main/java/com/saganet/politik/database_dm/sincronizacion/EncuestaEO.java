package com.saganet.politik.database_dm.sincronizacion;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios_dm.CatComunicacionDO;
import com.saganet.politik.dominios_dm.CatMPINNDO;
import com.saganet.politik.dominios_dm.CatMapnDO;
import com.saganet.politik.dominios_dm.CatMedioDO;
import com.saganet.politik.dominios_dm.CatPartidoDO;
import com.saganet.politik.dominios_dm.CatPriPanDO;
import com.saganet.politik.dominios_dm.CatPriPrdDO;
import com.saganet.politik.dominios_dm.CatSNDO;
import com.saganet.politik.dominios_dm.CatSNNCDO;
@Alias("SincronizacionEncuestaEO")
public class EncuestaEO implements Serializable {

	private static final long serialVersionUID = -4326898621514785257L;
	private Integer id;
	private Integer idMunicipio;
	private PrecargaEO precarga;
	private CatSNDO tieneIne;
	private String problemaPais;
	private String problemaEstado;
	private String problemaMunicipio;
	private CatMPINNDO actualEconomico;
	private CatMPINNDO actualPolitico;
	private CatMPINNDO futuroEconomico;
	private CatMPINNDO futuroPolitico;
	private List<CatMedioDO> medios;
	private List<CatComunicacionDO> medioComunicacion;
	private List<CatPartidoDO> partidoIdentifica;
	private CatSNNCDO gobEstatalDifPRI;
	private CatPartidoDO noVotariaPor;
	private CatPartidoDO votariaPorEstatal;
	private CatPriPanDO votoPriPanEstatal;
	private CatPriPrdDO votoPriPrdEstatal;
	private CatSNNCDO beneficiarioProgramaSocial;
	private CatMapnDO calificacionEpn;
	private CatMapnDO calificacionGobEpn;
	private CatMapnDO calificacionIngresoFamiliarEpn;
	private String otrosApoyos;
	private CatSNNCDO recibirInformacionProgramas;
	private String telefono;
	private String email;
	private Integer calificacionNumPresidente;
	private Integer calificacionNumGobernador;
	private Integer calificacionNumPresidenteMun;	
	private List<ConocePersonajeEO> conocePersonaje;
	private List<OpinionPersonajeEO> opinionPersonaje;
	private UsuarioEO usuario;
	private String imei;
	private Timestamp fechaCreacion;
	private Timestamp fechaActualizacion;
	
	
	@Override
	public String toString() {
		return "EncuestaEO [id=" + id + ", idMunicipio=" + idMunicipio + ", precarga=" + precarga + ", tieneIne="
				+ tieneIne + ", problemaPais=" + problemaPais + ", problemaEstado=" + problemaEstado
				+ ", problemaMunicipio=" + problemaMunicipio + ", actualEconomico=" + actualEconomico
				+ ", actualPolitico=" + actualPolitico + ", futuroEconomico=" + futuroEconomico + ", futuroPolitico="
				+ futuroPolitico + ", medios=" + medios + ", medioComunicacion=" + medioComunicacion
				+ ", partidoIdentifica=" + partidoIdentifica + ", gobEstatalDifPRI=" + gobEstatalDifPRI
				+ ", noVotariaPor=" + noVotariaPor + ", votariaPorEstatal=" + votariaPorEstatal + ", votoPriPanEstatal="
				+ votoPriPanEstatal + ", votoPriPrdEstatal=" + votoPriPrdEstatal + ", beneficiarioProgramaSocial="
				+ beneficiarioProgramaSocial + ", calificacionEpn=" + calificacionEpn + ", calificacionGobEpn="
				+ calificacionGobEpn + ", calificacionIngresoFamiliarEpn=" + calificacionIngresoFamiliarEpn
				+ ", otrosApoyos=" + otrosApoyos + ", recibirInformacionProgramas=" + recibirInformacionProgramas
				+ ", telefono=" + telefono + ", email=" + email + ", calificacionNumPresidente="
				+ calificacionNumPresidente + ", calificacionNumGobernador=" + calificacionNumGobernador
				+ ", calificacionNumPresidenteMun=" + calificacionNumPresidenteMun + ", conocePersonaje="
				+ conocePersonaje + ", opinionPersonaje=" + opinionPersonaje + ", usuario=" + usuario + ", imei=" + imei
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion=" + fechaActualizacion + "]";
	}
	
	public Timestamp getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public PrecargaEO getPrecarga() {
		return precarga;
	}
	public void setPrecarga(PrecargaEO precarga) {
		this.precarga = precarga;
	}
	public CatSNDO getTieneIne() {
		return tieneIne;
	}
	public void setTieneIne(CatSNDO tieneIne) {
		this.tieneIne = tieneIne;
	}
	public String getProblemaPais() {
		return problemaPais;
	}
	public void setProblemaPais(String problemaPais) {
		this.problemaPais = problemaPais;
	}
	public String getProblemaEstado() {
		return problemaEstado;
	}
	public void setProblemaEstado(String problemaEstado) {
		this.problemaEstado = problemaEstado;
	}
	public String getProblemaMunicipio() {
		return problemaMunicipio;
	}
	public void setProblemaMunicipio(String problemaMunicipio) {
		this.problemaMunicipio = problemaMunicipio;
	}
	public CatMPINNDO getActualEconomico() {
		return actualEconomico;
	}
	public void setActualEconomico(CatMPINNDO actualEconomico) {
		this.actualEconomico = actualEconomico;
	}
	public CatMPINNDO getActualPolitico() {
		return actualPolitico;
	}
	public void setActualPolitico(CatMPINNDO actualPolitico) {
		this.actualPolitico = actualPolitico;
	}
	public CatMPINNDO getFuturoEconomico() {
		return futuroEconomico;
	}
	public void setFuturoEconomico(CatMPINNDO futuroEconomico) {
		this.futuroEconomico = futuroEconomico;
	}
	public CatMPINNDO getFuturoPolitico() {
		return futuroPolitico;
	}
	public void setFuturoPolitico(CatMPINNDO futuroPolitico) {
		this.futuroPolitico = futuroPolitico;
	}
	public List<CatMedioDO> getMedios() {
		return medios;
	}
	public void setMedios(List<CatMedioDO> medios) {
		this.medios = medios;
	}
	public List<CatComunicacionDO> getMedioComunicacion() {
		return medioComunicacion;
	}
	public void setMedioComunicacion(List<CatComunicacionDO> medioComunicacion) {
		this.medioComunicacion = medioComunicacion;
	}
	public List<CatPartidoDO> getPartidoIdentifica() {
		return partidoIdentifica;
	}
	public void setPartidoIdentifica(List<CatPartidoDO> partidoIdentifica) {
		this.partidoIdentifica = partidoIdentifica;
	}
	public CatSNNCDO getGobEstatalDifPRI() {
		return gobEstatalDifPRI;
	}
	public void setGobEstatalDifPRI(CatSNNCDO gobEstatalDifPRI) {
		this.gobEstatalDifPRI = gobEstatalDifPRI;
	}
	public CatPartidoDO getNoVotariaPor() {
		return noVotariaPor;
	}
	public void setNoVotariaPor(CatPartidoDO noVotariaPor) {
		this.noVotariaPor = noVotariaPor;
	}
	public CatPartidoDO getVotariaPorEstatal() {
		return votariaPorEstatal;
	}
	public void setVotariaPorEstatal(CatPartidoDO votariaPorEstatal) {
		this.votariaPorEstatal = votariaPorEstatal;
	}
	public CatPriPanDO getVotoPriPanEstatal() {
		return votoPriPanEstatal;
	}
	public void setVotoPriPanEstatal(CatPriPanDO votoPriPanEstatal) {
		this.votoPriPanEstatal = votoPriPanEstatal;
	}
	public CatPriPrdDO getVotoPriPrdEstatal() {
		return votoPriPrdEstatal;
	}
	public void setVotoPriPrdEstatal(CatPriPrdDO votoPriPrdEstatal) {
		this.votoPriPrdEstatal = votoPriPrdEstatal;
	}
	public CatSNNCDO getBeneficiarioProgramaSocial() {
		return beneficiarioProgramaSocial;
	}
	public void setBeneficiarioProgramaSocial(CatSNNCDO beneficiarioProgramaSocial) {
		this.beneficiarioProgramaSocial = beneficiarioProgramaSocial;
	}
	public CatMapnDO getCalificacionEpn() {
		return calificacionEpn;
	}
	public void setCalificacionEpn(CatMapnDO calificacionEpn) {
		this.calificacionEpn = calificacionEpn;
	}
	public CatMapnDO getCalificacionGobEpn() {
		return calificacionGobEpn;
	}
	public void setCalificacionGobEpn(CatMapnDO calificacionGobEpn) {
		this.calificacionGobEpn = calificacionGobEpn;
	}
	public CatMapnDO getCalificacionIngresoFamiliarEpn() {
		return calificacionIngresoFamiliarEpn;
	}
	public void setCalificacionIngresoFamiliarEpn(CatMapnDO calificacionIngresoFamiliarEpn) {
		this.calificacionIngresoFamiliarEpn = calificacionIngresoFamiliarEpn;
	}
	public String getOtrosApoyos() {
		return otrosApoyos;
	}
	public void setOtrosApoyos(String otrosApoyos) {
		this.otrosApoyos = otrosApoyos;
	}
	public CatSNNCDO getRecibirInformacionProgramas() {
		return recibirInformacionProgramas;
	}
	public void setRecibirInformacionProgramas(CatSNNCDO recibirInformacionProgramas) {
		this.recibirInformacionProgramas = recibirInformacionProgramas;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCalificacionNumPresidente() {
		return calificacionNumPresidente;
	}
	public void setCalificacionNumPresidente(Integer calificacionNumPresidente) {
		this.calificacionNumPresidente = calificacionNumPresidente;
	}
	public Integer getCalificacionNumGobernador() {
		return calificacionNumGobernador;
	}
	public void setCalificacionNumGobernador(Integer calificacionNumGobernador) {
		this.calificacionNumGobernador = calificacionNumGobernador;
	}
	public Integer getCalificacionNumPresidenteMun() {
		return calificacionNumPresidenteMun;
	}
	public void setCalificacionNumPresidenteMun(Integer calificacionNumPresidenteMun) {
		this.calificacionNumPresidenteMun = calificacionNumPresidenteMun;
	}
	public List<ConocePersonajeEO> getConocePersonaje() {
		return conocePersonaje;
	}
	public void setConocePersonaje(List<ConocePersonajeEO> conocePersonaje) {
		this.conocePersonaje = conocePersonaje;
	}
	public List<OpinionPersonajeEO> getOpinionPersonaje() {
		return opinionPersonaje;
	}
	public void setOpinionPersonaje(List<OpinionPersonajeEO> opinionPersonaje) {
		this.opinionPersonaje = opinionPersonaje;
	}
	public UsuarioEO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEO usuario) {
		this.usuario = usuario;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	
}
