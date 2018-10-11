package com.saganet.politik.database.gis;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("GeoData")
public class GeoDataEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -4970084130519038510L;

	private Integer id;
	private Double xMin;
	private Double yMin;
	private Double xMax;
	private Double yMax;
	private String bounds;
	
	public GeoDataEO(){
		id = (int) (Math.random() * 1000);
	}

	@Override
	public String toString() {
		return "GeoDataEO [xMin=" + xMin + ", yMin=" + yMin + ", xMax=" + xMax + ", yMax=" + yMax + ", bounds=" + bounds
				+ "]";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getxMin() {
		return xMin;
	}

	public void setxMin(Double xMin) {
		this.xMin = xMin;
	}

	public Double getyMin() {
		return yMin;
	}

	public void setyMin(Double yMin) {
		this.yMin = yMin;
	}

	public Double getxMax() {
		return xMax;
	}

	public void setxMax(Double xMax) {
		this.xMax = xMax;
	}

	public Double getyMax() {
		return yMax;
	}

	public void setyMax(Double yMax) {
		this.yMax = yMax;
	}

	public String getBounds() {
		if (bounds == null) {
			StringBuilder builder;
			builder = new StringBuilder();
			builder.append(xMin);
			builder.append(", ");
			builder.append(yMin);
			builder.append(", ");
			builder.append(xMax);
			builder.append(", ");
			builder.append(yMax);
			bounds = builder.toString();
		}

		return bounds;
	}

	public void setBounds(String bounds) {
		this.bounds = bounds;
	}

}
