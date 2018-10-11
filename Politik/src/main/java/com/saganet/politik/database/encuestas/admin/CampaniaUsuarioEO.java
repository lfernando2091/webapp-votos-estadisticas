package com.saganet.politik.database.encuestas.admin;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("CampaniaUsuarioEO")
public class CampaniaUsuarioEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 2155363589272482417L;
	
	private Integer id;
	private Integer idCampania;
	private String nick;
	
	@Override
	public String toString() {
		return "CampaniaUsuarioEO [id=" + id + ", idCampania=" + idCampania + ", nick=" + nick + "]";
	}

	public Integer getId() {
		return id;
	}

	public Integer getIdCampania() {
		return idCampania;
	}

	public void setIdCampania(Integer idCampania) {
		this.idCampania = idCampania;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
}
