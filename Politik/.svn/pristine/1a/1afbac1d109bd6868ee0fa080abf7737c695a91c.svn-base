package com.saganet.politik.database.biblioteca;


import java.io.File;
import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;
@Alias("BibliotecaEO")
public class BibliotecaEO extends JavaBeanT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private File archivo;
	@Override
	public String toString() {
		return "BibliotecaEO [archivo=" + archivo + "]";
		
	}
	public File getArchivo() {
		return archivo;
	}
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	
	
	

}
