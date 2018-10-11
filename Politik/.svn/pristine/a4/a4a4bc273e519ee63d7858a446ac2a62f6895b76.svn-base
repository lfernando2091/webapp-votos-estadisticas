package com.saganet.politik.components.encuestas.edomex2017;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.encuestas.edomex2017.RespuestasRegionesSonoraEO;
import com.saganet.politik.modelos.Modelo;


@Component("Edomex2017RespuestasRegionesSonora")
public class RespuestasRegionesSonoraC {
	@Autowired
	SqlSession sqlSession;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(RespuestasRegionesSonoraC.class);
	
	public Modelo<RespuestasRegionesSonoraEO> modelo() {
		List<RespuestasRegionesSonoraEO> listado=sqlSession.selectList("encuestas.edomex2017.respuestasRegionesSonora.listado");
		return new Modelo<>(listado); 
	}
	
	
	
	public RespuestasRegionesSonoraEO filaTotales(List<RespuestasRegionesSonoraEO> listado){
		RespuestasRegionesSonoraEO total=new RespuestasRegionesSonoraEO();
		total.setId(21);
		total.setNombre("TOTAL");
		total.setExitoso(0);
		total.setNoPermitioMinutos(0);
		total.setNumeroInvalido(0);
		total.setNumeroNoExiste(0);
		total.setNumeroOcupado(0);
		total.setNumeroHaCambiado(0);
		total.setNumeroFueraServicio(0);
		total.setNumeroEquivocado(0);
		total.setNoEstaApoyando(0);
		total.setPersonaNoEncontrada(0);
		total.setPendienteTotal(0);
		total.setPendiente(0);
		total.setTotal(0);

		for (RespuestasRegionesSonoraEO RespuestasRegionesSonoraEO : listado) {


			
			total.setExitoso(total.getExitoso()+RespuestasRegionesSonoraEO.getExitoso());
			total.setNoPermitioMinutos(total.getNoPermitioMinutos()+RespuestasRegionesSonoraEO.getNoPermitioMinutos());
			total.setNumeroInvalido(total.getNumeroInvalido()+RespuestasRegionesSonoraEO.getNumeroInvalido());
			total.setNumeroNoExiste(total.getNumeroNoExiste()+RespuestasRegionesSonoraEO.getNumeroNoExiste());
			total.setNumeroOcupado(total.getNumeroOcupado()+RespuestasRegionesSonoraEO.getNumeroOcupado());
			total.setNumeroHaCambiado(total.getNumeroHaCambiado()+RespuestasRegionesSonoraEO.getNumeroHaCambiado());
			total.setNumeroFueraServicio(total.getNumeroFueraServicio()+RespuestasRegionesSonoraEO.getNumeroFueraServicio());
			total.setNumeroEquivocado(total.getNumeroEquivocado()+RespuestasRegionesSonoraEO.getNumeroEquivocado());
			total.setNoEstaApoyando(total.getNoEstaApoyando()+RespuestasRegionesSonoraEO.getNoEstaApoyando());
			total.setPersonaNoEncontrada(total.getPersonaNoEncontrada()+RespuestasRegionesSonoraEO.getPersonaNoEncontrada());
			total.setPendienteTotal(total.getPendienteTotal()+RespuestasRegionesSonoraEO.getPendienteTotal());
			total.setPendiente(total.getPendiente()+RespuestasRegionesSonoraEO.getPendiente  ());
			total.setTotal(total.getTotal()+RespuestasRegionesSonoraEO.getTotal());

		}
		return total;
	}
	

}
