package com.saganet.politik.database.eventos;

import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.dominios.EstatusEventoDO;
import com.saganet.politik.dominios.NivelesDO;
import com.saganet.politik.dominios.TipoEventoDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.Serializable;
import org.apache.ibatis.type.Alias;

@Alias("EventoSocialEO")
public class EventoSocialEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 2958149825338022635L;
	private Integer id;
	private String nombre;
	private String descripcionLugar;
	private EstatusEventoDO estatus;
	private TipoEventoDO tipo;
	private List<JavaBeanT> territorios;
	private NivelesDO nivel;
	private Integer numeroAsistentes;
	private Timestamp fecha;
	private Timestamp fechaFin;
	private java.util.Date fechaStringFin;
	private java.util.Date fechaString;
	private String fechaFormateada;
	private String fechaFinFormateada;
	private String descripcionLogistica;
	private String nick;
	private String nickActualizacion;
	private Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas;
	private List<DependenciaEO> dependencias;
	private List<DependenciaEO> dependenciasUsuario;
	private boolean sinDependencias;

	@Override
	public String toString() {
		return "EventoSocialEO [id=" + id + ", nombre=" + nombre + ", descripcionLugar=" + descripcionLugar
				+ ", estatus=" + estatus + ", tipo=" + tipo + ", territorios=" + territorios + ", nivel=" + nivel
				+ ", numeroAsistentes=" + numeroAsistentes + ", fecha=" + fecha + ", fechaFin=" + fechaFin
				+ ", fechaStringFin=" + fechaStringFin + ", fechaString=" + fechaString + ", fechaFormateada="
				+ fechaFormateada + ", fechaFinFormateada=" + fechaFinFormateada + ", descripcionLogistica="
				+ descripcionLogistica + ", nick=" + nick + ", nickActualizacion=" + nickActualizacion
				+ ", tablaEjerciciosProgramas=" + tablaEjerciciosProgramas + ", dependencias=" + dependencias
				+ ", dependenciasUsuario=" + dependenciasUsuario + ", sinDependencias=" + sinDependencias + "]";
	}
	
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fechaFormateada= new SimpleDateFormat("dd/MM/yyyy HH:mm").format(fecha);
		this.fecha = fecha;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public NivelesDO getNivel() {
		return nivel;
	}
	public void setNivel(NivelesDO nivel) {
		this.nivel = nivel;
	}

	public List<JavaBeanT> getTerritorios() {
		return territorios;
	}

	public void setTerritorios(List<JavaBeanT> territorios) {
		this.territorios = territorios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcionLugar() {
		return descripcionLugar;
	}
	public void setDescripcionLugar(String descripcionLugar) {
		this.descripcionLugar = descripcionLugar;
	}
	public EstatusEventoDO getEstatus() {
		return estatus;
	}
	public void setEstatus(EstatusEventoDO estatus) {
		this.estatus = estatus;
	}
	public TipoEventoDO getTipo() {
		return tipo;
	}
	public void setTipo(TipoEventoDO tipo) {
		this.tipo = tipo;
	}
	public Integer getNumeroAsistentes() {
		return numeroAsistentes;
	}
	public void setNumeroAsistentes(Integer numeroAsistentes) {
		this.numeroAsistentes = numeroAsistentes;
	}
	public String getFechaFormateada() {
		return fechaFormateada;
	}
	public void setFechaFormateada(String fechaFormateada) {
		this.fechaFormateada = fechaFormateada;
	}
	public java.util.Date getFechaStringFin() {
		return fechaStringFin;
	}
	public java.util.Date getFechaString() {
		return fechaString;
	}
	public void setFechaString(java.util.Date fechaString) {
		this.fechaString = fechaString;
		this.fecha =new java.sql.Timestamp(fechaString.getTime());
	}
	public void setFechaStringFin(java.util.Date fechaStringFin) {
		this.fechaStringFin = fechaStringFin;
		this.fechaFin =new java.sql.Timestamp(fechaStringFin.getTime());
	}
	public Timestamp getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFinFormateada= new SimpleDateFormat("dd/MM/yyyy HH:mm").format(fechaFin);
		this.fechaFin = fechaFin;
	}
	public String getFechaFinFormateada() {
		return fechaFinFormateada;
	}
	public void setFechaFinFormateada(String fechaFinFormateada) {
		this.fechaFinFormateada = fechaFinFormateada;
	}
	public String getDescripcionLogistica() {
		return descripcionLogistica;
	}
	public void setDescripcionLogistica(String descripcionLogistica) {
		this.descripcionLogistica = descripcionLogistica;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Modelo<EventoEjercicioProgramaEO> getTablaEjerciciosProgramas() {
		return tablaEjerciciosProgramas;
	}
	public void setTablaEjerciciosProgramas(Modelo<EventoEjercicioProgramaEO> tablaEjerciciosProgramas) {
		this.tablaEjerciciosProgramas = tablaEjerciciosProgramas;
	}
	public List<DependenciaEO> getDependencias() {
		return dependencias;
	}
	public void setDependencias(List<DependenciaEO> dependencias) {
		this.dependencias = dependencias;
	}
	public boolean isSinDependencias() {
		return sinDependencias;
	}

	public void setSinDependencias(boolean sinDependencias) {
		this.sinDependencias = sinDependencias;
	}

	public List<DependenciaEO> getDependenciasUsuario() {
		return dependenciasUsuario;
	}

	public void setDependenciasUsuario(List<DependenciaEO> dependenciasUsuario) {
		this.dependenciasUsuario = dependenciasUsuario;
	}

	public String getNickActualizacion() {
		return nickActualizacion;
	}

	public void setNickActualizacion(String nickActualizacion) {
		this.nickActualizacion = nickActualizacion;
	}

}
