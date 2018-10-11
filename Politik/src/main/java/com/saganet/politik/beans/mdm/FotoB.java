package com.saganet.politik.beans.mdm;

import java.io.IOException;
import java.io.Serializable;


import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FotoB implements Serializable {
	private static final long serialVersionUID = 4921001645121152008L;
	private static final Logger logger = LoggerFactory.getLogger(FotoB.class);
	
	private byte[] archivo;
	private String nombre;
	
	public void handleFileUpload(FileUploadEvent evento) throws IOException{
		archivo = evento.getFile().getContents();
		nombre = evento.getFile().getFileName();
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public String getNombre() {
		return nombre;
	}

}
