package com.saganet.politik.database.encuestaTelefonica;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

import com.saganet.politik.database.encuestas.entrevistasTelefonicas.ContactoEO;
import com.saganet.politik.modelos.JavaBeanT;

@Alias("RespuestasEncuestaTelefonica2EO")
public class RespuestasEncuestaTelefonica2EO extends JavaBeanT implements Serializable {
	private static final long serialVersionUID = -2203909928382074053L;
	private Integer id;
	private String  p_1;
	private String  p_1_1;
	private String  p_2;
	private String  p_2_1;
	private String  p_3;
	private String  p_4;
	private String  p_5;
	private String  p_5_1;
	private String  p_6_1_1;
	private String  p_6_1_2;
	private String  p_6_2_1;
	private String  p_6_2_2;
	private String  p_6_3_1;
	private String  p_6_3_2;
	private String  p_6_4_1;
	private String  p_6_4_2;
	private String  p_6_5_1;
	private String  p_6_5_2;
	private String  p_7;
	private String  p_8;
	private String  p_9;
	private String  p_10;
	private String  p_10_1;
	private String nick;
	private ContactoEO contacto;
	@Override
	public String toString() {
		return "RespuestasEncuestaTelefonica2EO [id=" + id + ", p_1=" + p_1 + ", p_1_1=" + p_1_1 + ", p_2=" + p_2
				+ ", p_2_1=" + p_2_1 + ", p_3=" + p_3 + ", p_4=" + p_4 + ", p_5=" + p_5 + ", p_5_1=" + p_5_1
				+ ", p_6_1_1=" + p_6_1_1 + ", p_6_1_2=" + p_6_1_2 + ", p_6_2_1=" + p_6_2_1 + ", p_6_2_2=" + p_6_2_2
				+ ", p_6_3_1=" + p_6_3_1 + ", p_6_3_2=" + p_6_3_2 + ", p_6_4_1=" + p_6_4_1 + ", p_6_4_2=" + p_6_4_2
				+ ", p_6_5_1=" + p_6_5_1 + ", p_6_5_2=" + p_6_5_2 + ", p_7=" + p_7 + ", p_8=" + p_8 + ", p_9=" + p_9
				+ ", p_10=" + p_10 + ", p_10_1=" + p_10_1 + ", nick=" + nick + ", contacto=" + contacto + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getP_1() {
		return p_1;
	}
	public void setP_1(String p_1) {
		this.p_1 = p_1;
	}
	public String getP_1_1() {
		return p_1_1;
	}
	public void setP_1_1(String p_1_1) {
		this.p_1_1 = p_1_1;
	}
	public String getP_2() {
		return p_2;
	}
	public void setP_2(String p_2) {
		this.p_2 = p_2;
	}
	public String getP_2_1() {
		return p_2_1;
	}
	public void setP_2_1(String p_2_1) {
		this.p_2_1 = p_2_1;
	}
	public String getP_3() {
		return p_3;
	}
	public void setP_3(String p_3) {
		this.p_3 = p_3;
	}
	public String getP_4() {
		return p_4;
	}
	public void setP_4(String p_4) {
		this.p_4 = p_4;
	}
	public String getP_5() {
		return p_5;
	}
	public void setP_5(String p_5) {
		this.p_5 = p_5;
	}
	public String getP_5_1() {
		return p_5_1;
	}
	public void setP_5_1(String p_5_1) {
		this.p_5_1 = p_5_1;
	}
	public String getP_6_1_1() {
		return p_6_1_1;
	}
	public void setP_6_1_1(String p_6_1_1) {
		this.p_6_1_1 = p_6_1_1;
	}
	public String getP_6_1_2() {
		return p_6_1_2;
	}
	public void setP_6_1_2(String p_6_1_2) {
		this.p_6_1_2 = p_6_1_2;
	}
	public String getP_6_2_1() {
		return p_6_2_1;
	}
	public void setP_6_2_1(String p_6_2_1) {
		this.p_6_2_1 = p_6_2_1;
	}
	public String getP_6_2_2() {
		return p_6_2_2;
	}
	public void setP_6_2_2(String p_6_2_2) {
		this.p_6_2_2 = p_6_2_2;
	}
	public String getP_6_3_1() {
		return p_6_3_1;
	}
	public void setP_6_3_1(String p_6_3_1) {
		this.p_6_3_1 = p_6_3_1;
	}
	public String getP_6_3_2() {
		return p_6_3_2;
	}
	public void setP_6_3_2(String p_6_3_2) {
		this.p_6_3_2 = p_6_3_2;
	}
	public String getP_6_4_1() {
		return p_6_4_1;
	}
	public void setP_6_4_1(String p_6_4_1) {
		this.p_6_4_1 = p_6_4_1;
	}
	public String getP_6_4_2() {
		return p_6_4_2;
	}
	public void setP_6_4_2(String p_6_4_2) {
		this.p_6_4_2 = p_6_4_2;
	}
	public String getP_6_5_1() {
		return p_6_5_1;
	}
	public void setP_6_5_1(String p_6_5_1) {
		this.p_6_5_1 = p_6_5_1;
	}
	public String getP_6_5_2() {
		return p_6_5_2;
	}
	public void setP_6_5_2(String p_6_5_2) {
		this.p_6_5_2 = p_6_5_2;
	}
	public String getP_7() {
		return p_7;
	}
	public void setP_7(String p_7) {
		this.p_7 = p_7;
	}
	public String getP_8() {
		return p_8;
	}
	public void setP_8(String p_8) {
		this.p_8 = p_8;
	}
	public String getP_9() {
		return p_9;
	}
	public void setP_9(String p_9) {
		this.p_9 = p_9;
	}
	public String getP_10() {
		return p_10;
	}
	public void setP_10(String p_10) {
		this.p_10 = p_10;
	}
	public String getP_10_1() {
		return p_10_1;
	}
	public void setP_10_1(String p_10_1) {
		this.p_10_1 = p_10_1;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public ContactoEO getContacto() {
		return contacto;
	}
	public void setContacto(ContactoEO contacto) {
		this.contacto = contacto;
	}
}
