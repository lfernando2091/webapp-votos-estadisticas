package com.saganet.politik.dominios;

public enum CalificacionEncuestaDO {
	_111("111","A favor"),
	_112("112","Indeciso en contra"),
	_113("113","Indeciso a favor"),
	_121("121","Indeciso a favor"),
	_122("122","En contra"),
	_123("123","Indeciso en contra"),
	_131("131","Indeciso a favor"),
	_132("132","Indeciso en contra"),
	_133("133","Indeciso"),
	_211("211","Indeciso a favor"),
	_212("212","Indeciso en contra"),
	_213("213","Indeciso a favor"),
	_221("221","Indeciso a favor"),
	_222("222","En contra"),
	_223("223","Indeciso en contra"),
	_231("231","Indeciso a favor"),
	_232("232","Indeciso en contra"),
	_233("233","Indeciso"),
	_311("311","Indeciso a favor"),
	_312("312","Indeciso en contra"),
	_313("313","Indeciso a favor"),
	_321("321","Indeciso a favor"),
	_322("322","En contra"),
	_323("323","Indeciso en contra"),
	_331("331","Indeciso a favor"),
	_332("332","Indeciso en contra"),
	_333("333","Indeciso");

	private final String codigo;
	private final String calificacion;
	private CalificacionEncuestaDO(String codigo, String calificacion) {
		this.codigo = codigo;
		this.calificacion = calificacion;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getCalificacion() {
		return calificacion;
	}
	
	
}
