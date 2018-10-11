package com.saganet.politik.database.encuestas.admin;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("TablaContactoEO")
public class TablaContactoEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -5059134810857043806L;
	
	private Integer id;
	private String tabla;
	
	@Override
	public String toString() {
		return "TablaContactoEO [id=" + id + ", tabla=" + tabla + "]";
	}

	public Integer getId() {
		return id;
	}
	
	public String getTabla() {
		return tabla;
	}
	
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	
}
