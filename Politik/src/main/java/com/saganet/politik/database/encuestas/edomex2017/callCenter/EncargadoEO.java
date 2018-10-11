package com.saganet.politik.database.encuestas.edomex2017.callCenter;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("Edomex2017CallcenterEncargadoEO")
public class EncargadoEO extends JavaBeanT implements Serializable {
	
	private static final long serialVersionUID = -6147451553202869253L;
	private Integer id;
	private UsuarioEO usuario;
	private ProgramasEdoMexDO progama;
		
	@Override
	public String toString() {
		return "EncargadoEO [id=" + id + ", usuario=" + usuario + ", progama=" + progama + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UsuarioEO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEO nick) {
		this.usuario = nick;
	}
	public ProgramasEdoMexDO getProgama() {
		return progama;
	}
	public void setProgama(ProgramasEdoMexDO progama) {
		this.progama = progama;
	}
	
	
}
