package com.saganet.politik.database.eventos;

import com.saganet.politik.modelos.JavaBeanT;
import java.io.Serializable;
import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("CalendarioEventoSocialEO")
public class CalendarioEventoSocialEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = 2958149825338022635L;
	private Integer id;
	private Date fecha;
	private Date fechaFin;
	private Integer conteo;
	private String dependencias;
	
	@Override
	public String toString() {
		return "CalendarioEventoSocialEO [id=" + id + ", fecha=" + fecha + ", fechaFin=" + fechaFin + ", conteo="
				+ conteo + ", dependencias=" + dependencias + "]";
	} 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getConteo() {
		return conteo;
	}

	public void setConteo(Integer conteo) {
		this.conteo = conteo;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDependencias() {
		return dependencias;
	}

	public void setDependencias(String dependencias) {
		this.dependencias = dependencias;
	}
	
	
}
