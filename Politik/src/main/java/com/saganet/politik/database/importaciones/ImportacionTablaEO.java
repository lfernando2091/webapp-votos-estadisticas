package com.saganet.politik.database.importaciones;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.TiposCampoDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("ImportacionImportacionTablaEO")
public class ImportacionTablaEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = -1653680623834553080L;
	
	private  String nombreOriginal;
	private String nombreTabla;
	private TiposCampoDO tipoDatoTabla;
	
	@Override
	public String toString() {
		return "ImportacionTablaEO [nombreOriginal=" + nombreOriginal + ", nombreTabla=" + nombreTabla + ", tipoDatoTabla="
				+ tipoDatoTabla + "]";
	}
	
	public String getNombreOriginal() {
		return nombreOriginal;
	}
	public void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}
	public String getNombreTabla() {
		return nombreTabla;
	}
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	public TiposCampoDO getTipoDatoTabla() {
		return tipoDatoTabla;
	}
	public void setTipoDatoTabla(TiposCampoDO tipoDatoTabla) {
		this.tipoDatoTabla = tipoDatoTabla;
	}
	
}
