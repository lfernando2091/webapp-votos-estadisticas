package com.saganet.politik.database.mdm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.warehouse.EmailEO;
import com.saganet.politik.database.warehouse.RedSocialEO;
import com.saganet.politik.database.warehouse.TelefonoEO;
import com.saganet.politik.dominios.MesDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;

@Alias("PersonaEO")
public class PersonaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -5972016857695721896L;

	private Integer id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Integer dia;
	private MesDO mes;
	private Integer anho;
	private EntidadEO entidadNacimiento;
	private List<PersonaClaveEO> claves;
	private List<TablaPersonaEO> tablas;
	private List<TablaPersonaEO> tablasEstructuras;
	private List<TelefonoEO> telefonos;
	private List<EmailEO> eMails;
	private List<RedSocialEO> redesSociales;

	private Modelo<PersonaClaveEO> modeloClaves;
	private Modelo<TablaPersonaEO> modeloTablas;
	private Modelo<TablaPersonaEO> modeloTablasEstructuras;
	private Modelo<TelefonoEO> modeloTelefonos;
	private Modelo<EmailEO> modeloEMails;
	private Modelo<RedSocialEO> modeloRedesSociales;
	private Modelo<TablaPersonaEO> modeloTablasAgrupado;
	private Modelo<TablaPersonaEO> modeloTablasEstructurasAgrupado;

	@Override
	public String toString() {
		return "PersonaEO [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", dia=" + dia + ", mes=" + mes + ", anho=" + anho
				+ ", entidadNacimiento=" + entidadNacimiento + ", claves=" + claves + ", tablas=" + tablas
				+ ", telefonos=" + telefonos + ", eMails=" + eMails + ", redesSociales=" + redesSociales + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public MesDO getMes() {
		return mes;
	}

	public void setMes(MesDO mes) {
		this.mes = mes;
	}

	public Integer getAnho() {
		return anho;
	}

	public void setAnho(Integer anho) {
		this.anho = anho;
	}

	public EntidadEO getEntidadNacimiento() {
		return entidadNacimiento;
	}

	public void setEntidadNacimiento(EntidadEO entidadNacimiento) {
		this.entidadNacimiento = entidadNacimiento;
	}

	public List<PersonaClaveEO> getClaves() {
		return claves;
	}
	
	public List<TelefonoEO> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<TelefonoEO> telefonos) {
		this.telefonos = telefonos;
		
		modeloTelefonos = new Modelo<TelefonoEO>();
		
		if (this.telefonos != null) {
			modeloTelefonos.setListado(this.telefonos);
			if (!this.telefonos.isEmpty()) {
				modeloTelefonos.setSeleccionado(this.telefonos.get(0));
			}
		} else
			modeloTelefonos.setListado(new ArrayList<TelefonoEO>());
	}

	public void setClaves(List<PersonaClaveEO> claves) {
		this.claves = claves;
		
		modeloClaves = new Modelo<PersonaClaveEO>();

		if (this.claves != null) {
			modeloClaves.setListado(this.claves);
			if (!this.claves.isEmpty()) {
				modeloClaves.setSeleccionado(this.claves.get(0));
			}
		} else
			modeloClaves.setListado(new ArrayList<PersonaClaveEO>());
	}

	public List<TablaPersonaEO> getTablas() {
		return tablas;
	}

	public void setTablas(List<TablaPersonaEO> tablas) {
		List<Integer> ids;
		
		this.tablas = tablas;
		
		modeloTablas = new Modelo<TablaPersonaEO>();
		
		if (this.tablas != null) {
			modeloTablas.setListado(this.tablas);
			if (!this.tablas.isEmpty()) {
				modeloTablas.setSeleccionado(this.tablas.get(0));
			}
		} else
			modeloTablas.setListado(new ArrayList<TablaPersonaEO>());
		
		modeloTablasAgrupado = new Modelo<>();
		modeloTablasAgrupado.setListado(new ArrayList<TablaPersonaEO>());
		ids = new ArrayList<>();
		
		if(!modeloTablas.getListado().isEmpty()){
			for(TablaPersonaEO tabla : modeloTablas.getListado()){
				if(!ids.contains(tabla.getTabla().getId())){
					modeloTablasAgrupado.getListado().add(tabla);
					ids.add(tabla.getTabla().getId());
				}
			}
			if(!modeloTablasAgrupado.getListado().isEmpty()){
				modeloTablasAgrupado.setSeleccionado(modeloTablasAgrupado.getListado().get(0));
			}
		}
	}

	public List<EmailEO> getEMails() {
		return eMails;
	}

	public void setEMails(List<EmailEO> eMails) {
		this.eMails = eMails;
		
		modeloEMails = new Modelo<EmailEO>();
		
		if (this.eMails != null) {
			modeloEMails.setListado(this.eMails);
			if (!this.eMails.isEmpty()) {
				modeloEMails.setSeleccionado(this.eMails.get(0));
			}
		} else
			modeloEMails.setListado(new ArrayList<EmailEO>());
	}

	public List<RedSocialEO> getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(List<RedSocialEO> redesSociales) {
		this.redesSociales = redesSociales;
		
		modeloRedesSociales = new Modelo<RedSocialEO>();
		
		if (this.redesSociales != null) {
			modeloRedesSociales.setListado(this.redesSociales);
			if (!this.redesSociales.isEmpty()) {
				modeloRedesSociales.setSeleccionado(this.redesSociales.get(0));
			}
		} else
			modeloRedesSociales.setListado(new ArrayList<RedSocialEO>());
	}

	public Modelo<PersonaClaveEO> getModeloClaves() {
		return modeloClaves;
	}

	public Modelo<TablaPersonaEO> getModeloTablas() {
		return modeloTablas;
	}

	public Modelo<TelefonoEO> getModeloTelefonos() {
		return modeloTelefonos;
	}

	public Modelo<EmailEO> getModeloEMails() {
		return modeloEMails;
	}

	public void setModeloMails(Modelo<EmailEO> modeloMails) {
		this.modeloEMails = modeloMails;
	}

	public Modelo<RedSocialEO> getModeloRedesSociales() {
		return modeloRedesSociales;
	}

	public void setModeloRedesSociales(Modelo<RedSocialEO> modeloRedesSociales) {
		this.modeloRedesSociales = modeloRedesSociales;
	}

	public List<TablaPersonaEO> getTablasEstructuras() {
		return tablasEstructuras;
	}

	public void setTablasEstructuras(List<TablaPersonaEO> tablasEstructuras) {
		List<Integer> ids;
		
		this.tablasEstructuras = tablasEstructuras;
		
		modeloTablasEstructuras = new Modelo<TablaPersonaEO>();
		
		if (this.tablasEstructuras != null) {
			modeloTablasEstructuras.setListado(this.tablasEstructuras);
			if (!this.tablasEstructuras.isEmpty()) {
				modeloTablasEstructuras.setSeleccionado(this.tablasEstructuras.get(0));
			}
		} else
			modeloTablasEstructuras.setListado(new ArrayList<TablaPersonaEO>());
		
		modeloTablasEstructurasAgrupado = new Modelo<>();
		modeloTablasEstructurasAgrupado.setListado(new ArrayList<TablaPersonaEO>());
		ids = new ArrayList<>();
		
		if(!modeloTablasEstructuras.getListado().isEmpty()){
			for(TablaPersonaEO tabla : modeloTablasEstructuras.getListado()){
				if(!ids.contains(tabla.getTabla().getId())){
					modeloTablasEstructurasAgrupado.getListado().add(tabla);
					ids.add(tabla.getTabla().getId());
				}
			}
			if(!modeloTablasEstructurasAgrupado.getListado().isEmpty()){
				modeloTablasEstructurasAgrupado.setSeleccionado(modeloTablasEstructurasAgrupado.getListado().get(0));
			}
		}
	}

	public Modelo<TablaPersonaEO> getModeloTablasEstructuras() {
		return modeloTablasEstructuras;
	}

	public void setModeloTablasEstructuras(Modelo<TablaPersonaEO> modeloTablasEstructuras) {
		this.modeloTablasEstructuras = modeloTablasEstructuras;
	}

	public Modelo<TablaPersonaEO> getModeloTablasAgrupado() {
		return modeloTablasAgrupado;
	}

	public void setModeloTablasAgrupado(Modelo<TablaPersonaEO> modeloTablasAgrupado) {
		this.modeloTablasAgrupado = modeloTablasAgrupado;
	}

	public Modelo<TablaPersonaEO> getModeloTablasEstructurasAgrupado() {
		return modeloTablasEstructurasAgrupado;
	}

	public void setModeloTablasEstructurasAgrupado(Modelo<TablaPersonaEO> modeloTablasEstructurasAgrupado) {
		this.modeloTablasEstructurasAgrupado = modeloTablasEstructurasAgrupado;
	}
}