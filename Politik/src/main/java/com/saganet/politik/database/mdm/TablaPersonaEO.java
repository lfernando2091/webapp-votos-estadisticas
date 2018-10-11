package com.saganet.politik.database.mdm;

import java.io.Serializable;
import java.util.HashMap;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.catalogos.TablaEO;
import com.saganet.politik.database.catalogos.TablaParticionEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("TablaPersonaEO")
public class TablaPersonaEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 6499078755500873199L;

	private Integer id;
	private TablaEO tabla;
	private Integer idPolitik;
	private TablaParticionEO particion;
	private HashMap<String, Object> datos;

	@Override
	public String toString() {
		return "TablaPersonaEO [id=" + id + ", tabla=" + tabla + ", idPolitik=" + idPolitik + ", particion=" + particion
				+ ", datos=" + datos + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TablaEO getTabla() {
		return tabla;
	}

	public void setTabla(TablaEO tabla) {
		this.tabla = tabla;
	}

	public Integer getIdPolitik() {
		return idPolitik;
	}

	public void setIdPolitik(Integer idPolitik) {
		this.idPolitik = idPolitik;
	}

	public TablaParticionEO getParticion() {
		return particion;
	}

	public void setParticion(TablaParticionEO particion) {
		this.particion = particion;
	}

	public HashMap<String, Object> getDatos() {
		return datos;
	}

	public void setDatos(HashMap<String, Object> datos) {
		this.datos = datos;
	}

}
