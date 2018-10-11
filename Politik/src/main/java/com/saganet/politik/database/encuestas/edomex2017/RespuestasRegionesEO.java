package com.saganet.politik.database.encuestas.edomex2017;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("RespuestasRegionesEO")

public class RespuestasRegionesEO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = 2634997978060913932L;
	
	private Integer id;
	private String nombre;
	
	private Integer p1Si;
	private Integer p1NO;
	private Integer p1NS;
	
	private Integer p2Josefina;
	private Integer p2Alfredo;
	private Integer p2Juan;
	private Integer p2Delfina;
	private Integer p2Oscar;
	private Integer p2Isidro;
	private Integer p2nsNc;
	
	private Integer p3Si;
	private Integer p3NO;
	private Integer p3NS;
	
	private Integer p4sabe;
	private Integer p4noSabe;
	
	private Integer p5pan;
	private Integer p5pri;
	private Integer p5prd;
	private Integer p5pt;
	private Integer p5pvem;
	private Integer p5pes;
	private Integer p5morena;
	private Integer p5independiente;
	private Integer p5no;
	private Integer p5nsNc;
	
	private Integer p6Si;
	private Integer p6NO;
	private Integer p6NS;	
	
	private Integer p7pan;
	private Integer p7pri;
	private Integer p7prd;
	private Integer p7pt;
	private Integer p7pvem;
	private Integer p7pes;
	private Integer p7morena;
	private Integer p7independiente;
	private Integer p7no;
	private Integer p7nsNc;
	
	private Integer p8pan;
	private Integer p8pri;
	private Integer p8prd;
	private Integer p8pt;
	private Integer p8pvem;
	private Integer p8pes;
	private Integer p8morena;
	private Integer p8independiente;
	private Integer p8no;
	private Integer p8nsNc;
	
	private Integer p9Josefina;
	private Integer p9Alfredo;
	private Integer p9Juan;
	private Integer p9Delfina;
	private Integer p9Oscar;
	private Integer p9Isidro;
	private Integer p9nsNc;
	
	
	@Override
	public String toString() {
		return "RespuestasRegionesEO [id=" + id + ", nombre=" + nombre + ", p1Si=" + p1Si + ", p1NO=" + p1NO + ", p1NS="
				+ p1NS + ", p2Josefina=" + p2Josefina + ", p2Alfredo=" + p2Alfredo + ", p2Juan=" + p2Juan
				+ ", p2Delfina=" + p2Delfina + ", p2Oscar=" + p2Oscar + ", p2Isidro=" + p2Isidro + ", p2nsNc=" + p2nsNc
				+ ", p3Si=" + p3Si + ", p3NO=" + p3NO + ", p3NS=" + p3NS + ", p4sabe=" + p4sabe + ", p4noSabe="
				+ p4noSabe + ", p5pan=" + p5pan + ", p5pri=" + p5pri + ", p5prd=" + p5prd + ", p5pt=" + p5pt
				+ ", p5pvem=" + p5pvem + ", p5pes=" + p5pes + ", p5morena=" + p5morena + ", p5independiente="
				+ p5independiente + ", p5no=" + p5no + ", p5nsNc=" + p5nsNc + ", p6Si=" + p6Si + ", p6NO=" + p6NO
				+ ", p6NS=" + p6NS + ", p7pan=" + p7pan + ", p7pri=" + p7pri + ", p7prd=" + p7prd + ", p7pt=" + p7pt
				+ ", p7pvem=" + p7pvem + ", p7pes=" + p7pes + ", p7morena=" + p7morena + ", p7independiente="
				+ p7independiente + ", p7no=" + p7no + ", p7nsNc=" + p7nsNc + ", p8pan=" + p8pan + ", p8pri=" + p8pri
				+ ", p8prd=" + p8prd + ", p8pt=" + p8pt + ", p8pvem=" + p8pvem + ", p8pes=" + p8pes + ", p8morena="
				+ p8morena + ", p8independiente=" + p8independiente + ", p8no=" + p8no + ", p8nsNc=" + p8nsNc
				+ ", p9Josefina=" + p9Josefina + ", p9Alfredo=" + p9Alfredo + ", p9Juan=" + p9Juan + ", p9Delfina="
				+ p9Delfina + ", p9Oscar=" + p9Oscar + ", p9Isidro=" + p9Isidro + ", p9nsNc=" + p9nsNc + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getP1Si() {
		return p1Si;
	}
	public void setP1Si(Integer p1Si) {
		this.p1Si = p1Si;
	}
	public Integer getP1NO() {
		return p1NO;
	}
	public void setP1NO(Integer p1no) {
		p1NO = p1no;
	}
	public Integer getP1NS() {
		return p1NS;
	}
	public void setP1NS(Integer p1ns) {
		p1NS = p1ns;
	}
	public Integer getP2Josefina() {
		return p2Josefina;
	}
	public void setP2Josefina(Integer p2Josefina) {
		this.p2Josefina = p2Josefina;
	}
	public Integer getP2Alfredo() {
		return p2Alfredo;
	}
	public void setP2Alfredo(Integer p2Alfredo) {
		this.p2Alfredo = p2Alfredo;
	}
	public Integer getP2Juan() {
		return p2Juan;
	}
	public void setP2Juan(Integer p2Juan) {
		this.p2Juan = p2Juan;
	}
	public Integer getP2Delfina() {
		return p2Delfina;
	}
	public void setP2Delfina(Integer p2Delfina) {
		this.p2Delfina = p2Delfina;
	}
	public Integer getP2Oscar() {
		return p2Oscar;
	}
	public void setP2Oscar(Integer p2Oscar) {
		this.p2Oscar = p2Oscar;
	}
	public Integer getP2Isidro() {
		return p2Isidro;
	}
	public void setP2Isidro(Integer p2Isidro) {
		this.p2Isidro = p2Isidro;
	}
	public Integer getP2nsNc() {
		return p2nsNc;
	}
	public void setP2nsNc(Integer p2nsNc) {
		this.p2nsNc = p2nsNc;
	}
	public Integer getP3Si() {
		return p3Si;
	}
	public void setP3Si(Integer p3Si) {
		this.p3Si = p3Si;
	}
	public Integer getP3NO() {
		return p3NO;
	}
	public void setP3NO(Integer p3no) {
		p3NO = p3no;
	}
	public Integer getP3NS() {
		return p3NS;
	}
	public void setP3NS(Integer p3ns) {
		p3NS = p3ns;
	}
	public Integer getP4sabe() {
		return p4sabe;
	}
	public void setP4sabe(Integer p4sabe) {
		this.p4sabe = p4sabe;
	}
	public Integer getP4noSabe() {
		return p4noSabe;
	}
	public void setP4noSabe(Integer p4noSabe) {
		this.p4noSabe = p4noSabe;
	}
	public Integer getP5pan() {
		return p5pan;
	}
	public void setP5pan(Integer p5pan) {
		this.p5pan = p5pan;
	}
	public Integer getP5pri() {
		return p5pri;
	}
	public void setP5pri(Integer p5pri) {
		this.p5pri = p5pri;
	}
	public Integer getP5prd() {
		return p5prd;
	}
	public void setP5prd(Integer p5prd) {
		this.p5prd = p5prd;
	}
	public Integer getP5pt() {
		return p5pt;
	}
	public void setP5pt(Integer p5pt) {
		this.p5pt = p5pt;
	}
	public Integer getP5pvem() {
		return p5pvem;
	}
	public void setP5pvem(Integer p5pvem) {
		this.p5pvem = p5pvem;
	}
	public Integer getP5pes() {
		return p5pes;
	}
	public void setP5pes(Integer p5pes) {
		this.p5pes = p5pes;
	}
	public Integer getP5morena() {
		return p5morena;
	}
	public void setP5morena(Integer p5morena) {
		this.p5morena = p5morena;
	}
	public Integer getP5independiente() {
		return p5independiente;
	}
	public void setP5independiente(Integer p5independiente) {
		this.p5independiente = p5independiente;
	}
	public Integer getP5no() {
		return p5no;
	}
	public void setP5no(Integer p5no) {
		this.p5no = p5no;
	}
	public Integer getP5nsNc() {
		return p5nsNc;
	}
	public void setP5nsNc(Integer p5nsNc) {
		this.p5nsNc = p5nsNc;
	}
	public Integer getP6Si() {
		return p6Si;
	}
	public void setP6Si(Integer p6Si) {
		this.p6Si = p6Si;
	}
	public Integer getP6NO() {
		return p6NO;
	}
	public void setP6NO(Integer p6no) {
		p6NO = p6no;
	}
	public Integer getP6NS() {
		return p6NS;
	}
	public void setP6NS(Integer p6ns) {
		p6NS = p6ns;
	}
	public Integer getP7pan() {
		return p7pan;
	}
	public void setP7pan(Integer p7pan) {
		this.p7pan = p7pan;
	}
	public Integer getP7pri() {
		return p7pri;
	}
	public void setP7pri(Integer p7pri) {
		this.p7pri = p7pri;
	}
	public Integer getP7prd() {
		return p7prd;
	}
	public void setP7prd(Integer p7prd) {
		this.p7prd = p7prd;
	}
	public Integer getP7pt() {
		return p7pt;
	}
	public void setP7pt(Integer p7pt) {
		this.p7pt = p7pt;
	}
	public Integer getP7pvem() {
		return p7pvem;
	}
	public void setP7pvem(Integer p7pvem) {
		this.p7pvem = p7pvem;
	}
	public Integer getP7pes() {
		return p7pes;
	}
	public void setP7pes(Integer p7pes) {
		this.p7pes = p7pes;
	}
	public Integer getP7morena() {
		return p7morena;
	}
	public void setP7morena(Integer p7morena) {
		this.p7morena = p7morena;
	}
	public Integer getP7independiente() {
		return p7independiente;
	}
	public void setP7independiente(Integer p7independiente) {
		this.p7independiente = p7independiente;
	}
	public Integer getP7no() {
		return p7no;
	}
	public void setP7no(Integer p7no) {
		this.p7no = p7no;
	}
	public Integer getP7nsNc() {
		return p7nsNc;
	}
	public void setP7nsNc(Integer p7nsNc) {
		this.p7nsNc = p7nsNc;
	}
	public Integer getP8pan() {
		return p8pan;
	}
	public void setP8pan(Integer p8pan) {
		this.p8pan = p8pan;
	}
	public Integer getP8pri() {
		return p8pri;
	}
	public void setP8pri(Integer p8pri) {
		this.p8pri = p8pri;
	}
	public Integer getP8prd() {
		return p8prd;
	}
	public void setP8prd(Integer p8prd) {
		this.p8prd = p8prd;
	}
	public Integer getP8pt() {
		return p8pt;
	}
	public void setP8pt(Integer p8pt) {
		this.p8pt = p8pt;
	}
	public Integer getP8pvem() {
		return p8pvem;
	}
	public void setP8pvem(Integer p8pvem) {
		this.p8pvem = p8pvem;
	}
	public Integer getP8pes() {
		return p8pes;
	}
	public void setP8pes(Integer p8pes) {
		this.p8pes = p8pes;
	}
	public Integer getP8morena() {
		return p8morena;
	}
	public void setP8morena(Integer p8morena) {
		this.p8morena = p8morena;
	}
	public Integer getP8independiente() {
		return p8independiente;
	}
	public void setP8independiente(Integer p8independiente) {
		this.p8independiente = p8independiente;
	}
	public Integer getP8no() {
		return p8no;
	}
	public void setP8no(Integer p8no) {
		this.p8no = p8no;
	}
	public Integer getP8nsNc() {
		return p8nsNc;
	}
	public void setP8nsNc(Integer p8nsNc) {
		this.p8nsNc = p8nsNc;
	}
	public Integer getP9Josefina() {
		return p9Josefina;
	}
	public void setP9Josefina(Integer p9Josefina) {
		this.p9Josefina = p9Josefina;
	}
	public Integer getP9Alfredo() {
		return p9Alfredo;
	}
	public void setP9Alfredo(Integer p9Alfredo) {
		this.p9Alfredo = p9Alfredo;
	}
	public Integer getP9Juan() {
		return p9Juan;
	}
	public void setP9Juan(Integer p9Juan) {
		this.p9Juan = p9Juan;
	}
	public Integer getP9Delfina() {
		return p9Delfina;
	}
	public void setP9Delfina(Integer p9Delfina) {
		this.p9Delfina = p9Delfina;
	}
	public Integer getP9Oscar() {
		return p9Oscar;
	}
	public void setP9Oscar(Integer p9Oscar) {
		this.p9Oscar = p9Oscar;
	}
	public Integer getP9Isidro() {
		return p9Isidro;
	}
	public void setP9Isidro(Integer p9Isidro) {
		this.p9Isidro = p9Isidro;
	}
	public Integer getP9nsNc() {
		return p9nsNc;
	}
	public void setP9nsNc(Integer p9nsNc) {
		this.p9nsNc = p9nsNc;
	}
	
	
	
	
	
}
