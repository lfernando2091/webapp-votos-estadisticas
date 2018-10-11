package com.saganet.politik.database.encuestas.syncdm;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.dominios.syncdm.TipoPreguntaDO;
import com.saganet.politik.modelos.JavaBeanT;
@Alias("SyncDMPreguntaEO")
public class PreguntaEO extends JavaBeanT implements Serializable {

	private static final long serialVersionUID = -6228019128742004564L;
	private Integer id;
	private TipoPreguntaDO tipoPregunta;
	private String pregunta;
	private List<RespuestaEO> respuestas;
	@Override
	public String toString() {
		return "PreguntaEO [id=" + id + ", tipoPregunta=" + tipoPregunta + ", pregunta=" + pregunta + ", respuestas="
				+ respuestas + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TipoPreguntaDO getTipoPregunta() {
		return tipoPregunta;
	}
	public void setTipoPregunta(TipoPreguntaDO tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public List<RespuestaEO> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<RespuestaEO> respuestas) {
		this.respuestas = respuestas;
	}
	
	
	
}
