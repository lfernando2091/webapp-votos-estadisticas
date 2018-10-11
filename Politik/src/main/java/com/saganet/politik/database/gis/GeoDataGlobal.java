package com.saganet.politik.database.gis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.saganet.politik.database.catalogos.DFederalEO;
import com.saganet.politik.database.catalogos.DLocalEO;
import com.saganet.politik.database.catalogos.EntidadEO;
import com.saganet.politik.database.catalogos.LocalidadEO;
import com.saganet.politik.database.catalogos.ManzanaEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.SeccionEO;
import com.saganet.politik.modelos.JavaBeanT;

public class GeoDataGlobal implements Serializable {
	private static final long serialVersionUID = -258378218334176111L;

	private GeoDataEO geoData;
	private List<JavaBeanT> territorios;
	
	public GeoDataGlobal() {
		geoData = new GeoDataEO();
		territorios = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "GeoDataGlobal [geoData=" + geoData + ", territorios=" + territorios + "]";
	}
	
	public String getLlaves(){
		StringBuilder builder;
		String clase;
		String auxComa;
		
		builder = new StringBuilder();
		
		auxComa = "";
		if(!territorios.isEmpty()){
			clase = territorios.get(0).getClass().getSimpleName();
			for(JavaBeanT t : territorios){
				builder.append(auxComa);
				switch(clase){
				case "EntidadEO":
					builder.append(((EntidadEO)t).getLlave());
					break;
				case "MunicipioEO":
					builder.append("'");
					builder.append(((MunicipioEO)t).getLlave());
					builder.append("'");
					break;
				case "DFederalEO":
					builder.append("'");
					builder.append(((DFederalEO)t).getLlave());
					builder.append("'");
					break;
				case "DLocalEO":
					builder.append("'");
					builder.append(((DLocalEO)t).getLlave());
					builder.append("'");
					break;
				case "SeccionEO":
					builder.append("'");
					builder.append(((SeccionEO)t).getLlave());
					builder.append("'");
					break;
				case "LocalidadEO":
					builder.append("'");
					builder.append(((LocalidadEO)t).getLlave());
					builder.append("'");
					break;
				case "ManzanaEO":
					builder.append("'");
					builder.append(((ManzanaEO)t).getLlave());
					builder.append("'");
					break;
				}
				auxComa = ",";
			}
		}
		
		return builder.toString();
	}

	public GeoDataEO getGeoData() {
		return geoData;
	}

	public void setGeoData(GeoDataEO geoData) {
		this.geoData = geoData;
	}

	public List<JavaBeanT> getTerritorios() {
		return territorios;
	}

	public void setTerritorios(List<JavaBeanT> territorios) {
		this.territorios = territorios;
	}
}
