package com.saganet.politik.components.encuestas.edomex2017.v2;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.encuestas.edomex2017.v2.AvanceNickEO;
import com.saganet.politik.dominios.ProgramasEdoMexDO;
import com.saganet.politik.modelos.Modelo;

@Component("Edomex2017V2AvanceNickC")
public class AvanceNickC {

	@Autowired
	SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(AvanceNickC.class);
	public HashMap<String, Object> modelo(ProgramasEdoMexDO programa){
		HashMap<String, Object> mapa;
		List<AvanceNickEO> listado;
		Integer t1,t2,t3,t4,t5,t6,t7;
		t1=0;t2=0;	t3=0;	t4=0;	t5=0;	t6=0;t7=0;
		mapa = new HashMap<>();
		listado = sqlSession.selectList("encuestas.edomex2017.v2.avanceNick.listadoPrograma", programa);
		mapa.put("modelo", new Modelo<>(listado));
		for (AvanceNickEO avanceNickEO : listado) {
			t1=(t1+avanceNickEO.getExitoso());
			t2=(t2+avanceNickEO.getNo_hubo());
			t3=(t3+avanceNickEO.getNo_quisieron());
			t4=(t4+avanceNickEO.getDomicilio_no_encontrado());
			t5=(t5+avanceNickEO.getMenor_edad());
			t6=(t6+avanceNickEO.getOtro());
			t7=(t7+avanceNickEO.getTotal());
		}
		mapa.put("programa", programa.getNombre());
		mapa.put("t1", t1);
		mapa.put("t2", t2);
		mapa.put("t3", t3);
		mapa.put("t4", t4);
		mapa.put("t5", t5);
		mapa.put("t6", t6);
		mapa.put("t7", t7);
		return mapa;
	}
	
}
