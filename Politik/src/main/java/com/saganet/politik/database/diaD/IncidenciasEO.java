package com.saganet.politik.database.diaD;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.dominios.IncidenciasEstatusDO;
import com.saganet.politik.dominios.IncidenciasPrioridadDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("DiaDIncidenciasEO")
public class IncidenciasEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = -6147451553202869253L;
	private Integer id;
	private String nombre;
	private String telefono;
	private SeccionEO seccion;
	private String casilla;
	private String observaciones;
	private Timestamp fecha;
	private String fechaS;
	private Date fechaDate;
	private IncidenciasPrioridadDO prioridad;
	private IncidenciasEstatusDO estatus;
	private TiposIncidenciasEO tipo;
	private UsuarioEO usuario;
		
	@Override
	public String toString() {
		return "IncidenciasEO [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", seccion=" + seccion
				+ ", casilla=" + casilla + ", observaciones=" + observaciones + ", fecha=" + fecha + ", prioridad="
				+ prioridad + ", estatus=" + estatus + ", tipo=" + tipo + ", usuario=" + usuario + "]";
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public SeccionEO getSeccion() {
		return seccion;
	}
	public void setSeccion(SeccionEO seccion) {
		this.seccion = seccion;
	}
	public String getCasilla() {
		return casilla;
	}
	public void setCasilla(String casilla) {
		this.casilla = casilla;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		fechaS=dateFormat.format(fecha);
		this.fecha = fecha;
	}
	public IncidenciasPrioridadDO getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(IncidenciasPrioridadDO prioridad) {
		this.prioridad = prioridad;
	}
	public IncidenciasEstatusDO getEstatus() {
		return estatus;
	}
	public void setEstatus(IncidenciasEstatusDO estatus) {
		this.estatus = estatus;
	}
	public TiposIncidenciasEO getTipo() {
		return tipo;
	}
	public void setTipo(TiposIncidenciasEO tipo) {
		this.tipo = tipo;
	}
	public UsuarioEO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEO usuario) {
		this.usuario = usuario;
	}
	public Date getFechaDate() {
		return fechaDate;
	}
	public void setFechaDate(Date fechaDate) {
		fecha=new Timestamp((fechaDate).getTime());
		this.fechaDate = fechaDate;
	}

	public String getFechaS() {
		return fechaS;
	}

	public void setFechaS(String fechaS) {
		this.fechaS = fechaS;
	}
}
