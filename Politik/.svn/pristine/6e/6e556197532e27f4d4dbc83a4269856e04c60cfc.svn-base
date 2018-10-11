package com.saganet.politik.database.importaciones;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.TablaEO;
import com.saganet.politik.database.catalogos.TablaParticionEO;
import com.saganet.politik.dominios.TiposDelimitadorColumnasDO;
import com.saganet.politik.dominios.TiposDelimitadorTextoDO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("MapeoImportacionesEO")
public class MapeoImportacionEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = -1653680623834553080L;
	
	private File archivo;
	private String nombreTablaImportacion;
	private List<ImportacionTablaEO> tablaImportacion;
	private TablaEO tablaSeleccionada;
	private TablaParticionEO tablaParticionSeleccionada;
	private TiposDelimitadorColumnasDO delimitador;
	private TiposDelimitadorTextoDO quote;
	
	@Override
	public String toString() {
		return "MapeoImportacionEO [archivo=" + archivo + ", nombreTablaImportacion=" + nombreTablaImportacion
				+ ", tablaImportacion=" + tablaImportacion + ", tablaSeleccionada=" + tablaSeleccionada
				+ ", tablaParticionSeleccionada=" + tablaParticionSeleccionada + ", delimitador=" + delimitador
				+ ", quote=" + quote  + "]";
	}
	
	public TiposDelimitadorColumnasDO getDelimitador() {
		return delimitador;
	}
	public void setDelimitador(TiposDelimitadorColumnasDO delimitador) {
		this.delimitador = delimitador;
	}
	public TiposDelimitadorTextoDO getQuote() {
		return quote;
	}
	public void setQuote(TiposDelimitadorTextoDO quote) {
		this.quote = quote;
	}
	public TablaEO getTablaSeleccionada() {
		return tablaSeleccionada;
	}
	public void setTablaSeleccionada(TablaEO tablaSeleccionada) {
		this.tablaSeleccionada = tablaSeleccionada;
	}
	public TablaParticionEO getTablaParticionSeleccionada() {
		return tablaParticionSeleccionada;
	}
	public void setTablaParticionSeleccionada(TablaParticionEO tablaParticionSeleccionada) {
		this.tablaParticionSeleccionada = tablaParticionSeleccionada;
	}
	public List<ImportacionTablaEO> getTablaImportacion() {
		return tablaImportacion;
	}
	public void setTablaImportacion(List<ImportacionTablaEO> tablaImportacion) {
		this.tablaImportacion = tablaImportacion;
	}
	public File getArchivo() {
		return archivo;
	}
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	public String getNombreTablaImportacion() {
		return nombreTablaImportacion;
	}
	public void setNombreTablaImportacion(String nombreTablaImportacion) {
		this.nombreTablaImportacion = nombreTablaImportacion;
	}
}
