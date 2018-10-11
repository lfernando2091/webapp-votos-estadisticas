package com.saganet.politik.components.encuestas.edomex2017;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.saganet.politik.database.encuestas.edomex2017.RespuestasRegionesEO;
import com.saganet.politik.modelos.Modelo;


@Component("Edomex2017RespuestasRegiones")
public class RespuestasRegionesC {
	@Autowired
	SqlSession sqlSession;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(RespuestasRegionesC.class);
	
	public Modelo<RespuestasRegionesEO> modelo() {
		List<RespuestasRegionesEO> listado=sqlSession.selectList("encuestas.edomex2017.respuestasRegiones.listado");
		return new Modelo<>(listado);
	}
	
	public RespuestasRegionesEO filaTotales(List<RespuestasRegionesEO> listado){
		RespuestasRegionesEO total=new RespuestasRegionesEO();
		total.setId(21);
		total.setNombre("TOTAL");
		total.setP1Si(0);
		total.setP1NO(0);
		total.setP1NS(0);
		total.setP2Josefina(0);
		total.setP2Alfredo(0);
		total.setP2Juan(0);
		total.setP2Delfina(0);
		total.setP2Oscar(0);
		total.setP2Isidro(0);
		total.setP2nsNc(0);
		total.setP3Si(0);
		total.setP3NO(0);
		total.setP3NS(0);
		total.setP4sabe(0);
		total.setP4noSabe(0);
		total.setP5pan(0);
		total.setP5pri(0);
		total.setP5prd(0);
		total.setP5pt(0);
		total.setP5pvem(0);
		total.setP5pes(0);
		total.setP5morena(0);
		total.setP5independiente(0);
		total.setP5no(0);
		total.setP5nsNc(0);
		total.setP6Si(0);
		total.setP6NO(0);
		total.setP6NS(0);
		total.setP7pan(0);
		total.setP7pri(0);
		total.setP7prd(0);
		total.setP7pt(0);
		total.setP7pvem(0);
		total.setP7pes(0);
		total.setP7morena(0);
		total.setP7independiente(0);
		total.setP7no(0);
		total.setP7nsNc(0);
		total.setP8pan(0);
		total.setP8pri(0);
		total.setP8prd(0);
		total.setP8pt(0);
		total.setP8pvem(0);
		total.setP8pes(0);
		total.setP8morena(0);
		total.setP8independiente(0);
		total.setP8no(0);
		total.setP8nsNc(0);
		total.setP9Josefina(0);
		total.setP9Alfredo(0);
		total.setP9Juan(0);
		total.setP9Delfina(0);
		total.setP9Oscar(0);
		total.setP9Isidro(0);
		total.setP9nsNc(0);
		for (RespuestasRegionesEO respuestasRegionesEO : listado) {
			total.setP1Si(total.getP1Si()+respuestasRegionesEO.getP1Si());
			total.setP1NO(total.getP1NO()+respuestasRegionesEO.getP1NO());
			total.setP1NS(total.getP1NS()+respuestasRegionesEO.getP1NS());
			total.setP2Josefina(total.getP2Josefina()+respuestasRegionesEO.getP2Josefina());
			total.setP2Alfredo(total.getP2Alfredo()+respuestasRegionesEO.getP2Alfredo());
			total.setP2Juan(total.getP2Juan()+respuestasRegionesEO.getP2Juan());
			total.setP2Delfina(total.getP2Delfina()+respuestasRegionesEO.getP2Delfina());
			total.setP2Oscar(total.getP2Oscar()+respuestasRegionesEO.getP2Oscar());
			total.setP2Isidro(total.getP2Isidro()+respuestasRegionesEO.getP2Isidro());
			total.setP2nsNc(total.getP2nsNc()+respuestasRegionesEO.getP2nsNc());
			total.setP3Si(total.getP3Si()+respuestasRegionesEO.getP3Si());
			total.setP3NO(total.getP3NO()+respuestasRegionesEO.getP3NO());
			total.setP3NS(total.getP3NS()+respuestasRegionesEO.getP3NS());
			total.setP4sabe(total.getP4sabe()+respuestasRegionesEO.getP4sabe());
			total.setP4noSabe(total.getP4noSabe()+respuestasRegionesEO.getP4noSabe());
			total.setP5pan(total.getP5pan()+respuestasRegionesEO.getP5pan());
			total.setP5pri(total.getP5pri()+respuestasRegionesEO.getP5pri());
			total.setP5prd(total.getP5prd()+respuestasRegionesEO.getP5prd());
			total.setP5pt(total.getP5pt()+respuestasRegionesEO.getP5pt());
			total.setP5pvem(total.getP5pvem()+respuestasRegionesEO.getP5pvem());
			total.setP5pes(total.getP5pes()+respuestasRegionesEO.getP5pes());
			total.setP5morena(total.getP5morena()+respuestasRegionesEO.getP5morena());
			total.setP5independiente(total.getP5independiente()+respuestasRegionesEO.getP5independiente());
			total.setP5no(total.getP5no()+respuestasRegionesEO.getP5no());
			total.setP5nsNc(total.getP5nsNc()+respuestasRegionesEO.getP5nsNc());
			total.setP6Si(total.getP6Si()+respuestasRegionesEO.getP6Si());
			total.setP6NO(total.getP6NO()+respuestasRegionesEO.getP6NO());
			total.setP6NS(total.getP6NS()+respuestasRegionesEO.getP6NS());
			total.setP7pan(total.getP7pan()+respuestasRegionesEO.getP7pan());
			total.setP7pri(total.getP7pri()+respuestasRegionesEO.getP7pri());
			total.setP7prd(total.getP7prd()+respuestasRegionesEO.getP7prd());
			total.setP7pt(total.getP7pt()+respuestasRegionesEO.getP7pt());
			total.setP7pvem(total.getP7pvem()+respuestasRegionesEO.getP7pvem());
			total.setP7pes(total.getP7pes()+respuestasRegionesEO.getP7pes());
			total.setP7morena(total.getP7morena()+respuestasRegionesEO.getP7morena());
			total.setP7independiente(total.getP7independiente()+respuestasRegionesEO.getP7independiente());
			total.setP7no(total.getP7no()+respuestasRegionesEO.getP7no());
			total.setP7nsNc(total.getP7nsNc()+respuestasRegionesEO.getP7nsNc());
			total.setP8pan(total.getP8pan()+respuestasRegionesEO.getP8pan());
			total.setP8pri(total.getP8pri()+respuestasRegionesEO.getP8pri());
			total.setP8prd(total.getP8prd()+respuestasRegionesEO.getP8prd());
			total.setP8pt(total.getP8pt()+respuestasRegionesEO.getP8pt());
			total.setP8pvem(total.getP8pvem()+respuestasRegionesEO.getP8pvem());
			total.setP8pes(total.getP8pes()+respuestasRegionesEO.getP8pes());
			total.setP8morena(total.getP8morena()+respuestasRegionesEO.getP8morena());
			total.setP8independiente(total.getP8independiente()+respuestasRegionesEO.getP8independiente());
			total.setP8no(total.getP8no()+respuestasRegionesEO.getP8no());
			total.setP8nsNc(total.getP8nsNc()+respuestasRegionesEO.getP8nsNc());
			total.setP9Josefina(total.getP9Josefina()+respuestasRegionesEO.getP9Josefina());
			total.setP9Alfredo(total.getP9Alfredo()+respuestasRegionesEO.getP9Alfredo());
			total.setP9Juan(total.getP9Juan()+respuestasRegionesEO.getP9Juan());
			total.setP9Delfina(total.getP9Delfina()+respuestasRegionesEO.getP9Delfina());
			total.setP9Oscar(total.getP9Oscar()+respuestasRegionesEO.getP9Oscar());
			total.setP9Isidro(total.getP9Isidro()+respuestasRegionesEO.getP9Isidro());
			total.setP9nsNc(total.getP9nsNc()+respuestasRegionesEO.getP9nsNc());
		}
		return total;
	}
	

}
