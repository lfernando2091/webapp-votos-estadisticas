package com.saganet.politik.utilidades;

import java.io.File;
import java.net.URI;

public class FilePolitik extends File{
	private static final long serialVersionUID = 3844260706739978433L;
   
	private String extencion;
   
	@Override
	public String toString(){
		return "FilePolitik [extension="+extencion+" " + super.toString()+ " ]";
	}
   

	public FilePolitik(File file) {
		super(file, "");
	}


	public FilePolitik(String pathname) {
		super(pathname);
		// TODO Auto-generated constructor stub
	}


	public FilePolitik(File parent, String child) {
		super(parent, child);
		// TODO Auto-generated constructor stub
	}


	public FilePolitik(String parent, String child) {
		super(parent, child);
		// TODO Auto-generated constructor stub
	}


	public FilePolitik(URI uri) {
		super(uri);
		// TODO Auto-generated constructor stub
	}


	public String getExtencion() {
		return extencion;
	}
	public void setExtencion(String extencion) {
		this.extencion = extencion;
	}
	
	
}
