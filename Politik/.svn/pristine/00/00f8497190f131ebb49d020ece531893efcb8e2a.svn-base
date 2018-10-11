package com.saganet.politik.components.encuestas.edomex2017.v2;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.saganet.politik.database.encuestas.edomex2017.v2.CalificacionEntrevistaEO;
import com.saganet.politik.dominios.NivelesReporteDO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.Modelo;

@Component("Edomex2017V2CalificacionEncuestaC")
public class CalificacionEntrevistaC {
@Autowired
SqlSession sqlSession;
private static final Logger logger = LoggerFactory.getLogger(CalificacionEntrevistaC.class);

	public HashMap<String, Object> modelo(ProgramasEdoMexDO programa, NivelesReporteDO nivel) {
		HashMap<String, Object> mapa;
		mapa = new HashMap<>();
		List<CalificacionEntrevistaEO> listado;
		Integer t1,t2,t3,t4,t5;
		
		t1=0;t2=0;	t3=0;	t4=0;	t5=0;
		
		
		mapa.put("programa", programa);
		mapa.put("nivel",nivel);
		listado = sqlSession.selectList("encuestas.edomex2017.v2.calificacionEntrevista.listadoPrograma", mapa);
		for (CalificacionEntrevistaEO calificacionEntrevistaEO : listado) {
			t1=(t1+calificacionEntrevistaEO.getaFavor());
			t2=(t2+calificacionEntrevistaEO.getIndecisoAFavor());
			t3=(t3+calificacionEntrevistaEO.getIndeciso());
			t4=(t4+calificacionEntrevistaEO.getIndecisoEnContra());
			t5=(t5+calificacionEntrevistaEO.getEnContra());
		}
		mapa.put("t1", t1);
		mapa.put("t2", t2);
		mapa.put("t3", t3);
		mapa.put("t4", t4);
		mapa.put("t5", t5);
		mapa.put("modelo", new Modelo<>(listado));
		return mapa;
	}
}
