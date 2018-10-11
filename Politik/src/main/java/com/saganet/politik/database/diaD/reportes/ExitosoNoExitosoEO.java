package com.saganet.politik.database.diaD.reportes;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;
@Alias("DiaDReportesExitosoNoExitoso")
public class ExitosoNoExitosoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 4572445362672054804L;
	private Integer id;
	private ProgramasEdoMexDO programa;
	private Integer idRegion;
	private String region;
	private Integer idMunicipio;
	private String municipio;
	private Integer seccion;
	private Integer contactos;
	private Integer aFavor;
	private Integer aFavorIndeciso;
	private Integer indeciso;
	private Integer indecisoEnContra;
	private Integer enContra;
	private Integer totalExitosas;
	
	private Integer dne;
	private Integer nhqc;
	private Integer me;
	private Integer nqc;
	private Integer nva;
	private Integer f;
	private Integer o;
	private Integer totalNoExitosas;
	@Override
	public String toString() {
		return "ExitosoNoExitosoEO [id=" + id + ", programa=" + programa + ", idRegion=" + idRegion + ", region="
				+ region + ", idMunicipio=" + idMunicipio + ", municipio=" + municipio + ", seccion=" + seccion
				+ ", contactos=" + contactos + ", aFavor=" + aFavor + ", aFavorIndeciso=" + aFavorIndeciso
				+ ", indeciso=" + indeciso + ", indecisoEnContra=" + indecisoEnContra + ", enContra=" + enContra
				+ ", totalExitosas=" + totalExitosas + ", dne=" + dne + ", nhqc=" + nhqc + ", me=" + me + ", nqc=" + nqc
				+ ", nva=" + nva + ", f=" + f + ", o=" + o + ", totalNoExitosas=" + totalNoExitosas + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProgramasEdoMexDO getPrograma() {
		return programa;
	}
	public void setPrograma(ProgramasEdoMexDO programa) {
		this.programa = programa;
	}
	public Integer getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public Integer getSeccion() {
		return seccion;
	}
	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}
	public Integer getContactos() {
		return contactos;
	}
	public void setContactos(Integer contactos) {
		this.contactos = contactos;
	}
	public Integer getaFavor() {
		return aFavor;
	}
	public void setaFavor(Integer aFavor) {
		this.aFavor = aFavor;
	}
	public Integer getaFavorIndeciso() {
		return aFavorIndeciso;
	}
	public void setaFavorIndeciso(Integer aFavorIndeciso) {
		this.aFavorIndeciso = aFavorIndeciso;
	}
	public Integer getIndeciso() {
		return indeciso;
	}
	public void setIndeciso(Integer indeciso) {
		this.indeciso = indeciso;
	}
	public Integer getIndecisoEnContra() {
		return indecisoEnContra;
	}
	public void setIndecisoEnContra(Integer indecisoEnContra) {
		this.indecisoEnContra = indecisoEnContra;
	}
	public Integer getEnContra() {
		return enContra;
	}
	public void setEnContra(Integer enContra) {
		this.enContra = enContra;
	}
	public Integer getTotalExitosas() {
		return totalExitosas;
	}
	public void setTotalExitosas(Integer totalExitosas) {
		this.totalExitosas = totalExitosas;
	}
	public Integer getDne() {
		return dne;
	}
	public void setDne(Integer dne) {
		this.dne = dne;
	}
	public Integer getNhqc() {
		return nhqc;
	}
	public void setNhqc(Integer nhqc) {
		this.nhqc = nhqc;
	}
	public Integer getMe() {
		return me;
	}
	public void setMe(Integer me) {
		this.me = me;
	}
	public Integer getNqc() {
		return nqc;
	}
	public void setNqc(Integer nqc) {
		this.nqc = nqc;
	}
	public Integer getNva() {
		return nva;
	}
	public void setNva(Integer nva) {
		this.nva = nva;
	}
	public Integer getF() {
		return f;
	}
	public void setF(Integer f) {
		this.f = f;
	}
	public Integer getO() {
		return o;
	}
	public void setO(Integer o) {
		this.o = o;
	}
	public Integer getTotalNoExitosas() {
		return totalNoExitosas;
	}
	public void setTotalNoExitosas(Integer totalNoExitosas) {
		this.totalNoExitosas = totalNoExitosas;
	}
	
	
}
