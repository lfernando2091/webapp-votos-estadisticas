package com.saganet.politik.test;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/security-config.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/webflow-config.xml", })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class sustituir2doLevantamiento7 {

	@Autowired
	SqlSession sqlSession;

	@Test
	public void sustituir() {
		List<Integer> secciones;

		// obtener registros a sustituir
		secciones = sqlSession.selectList("sustituir.secciones7");
		procesarRegistros(secciones);
		
	}
	
	public void procesarRegistros(List<Integer> secciones){
		List<HashMap<String, Object>> porSustituir, paraSustituir;
		HashMap<String, Object> regParaSustituir, parametros;
		int registros, index;
		
		for(Integer seccion : secciones){
			porSustituir = sqlSession.selectList("sustituir.porSustituir", seccion);
			paraSustituir = sqlSession.selectList("sustituir.paraSustituir", seccion);
			registros = paraSustituir.size();
			index = 0;
			
			System.out.println("Procesando seccion: " + seccion);
			parametros = new HashMap<>();
			if(!paraSustituir.isEmpty()){
				for (HashMap<String, Object> reg : porSustituir) {
					if (index < registros) {
						regParaSustituir = paraSustituir.get(index++);
						
						//push - meter registro
						parametros.put("id_interno", regParaSustituir.get("id_interno"));
						sqlSession.update("sustituir.push", parametros);
						
						//pop1 - sacar registro y sustituirlo en encuesta_edomex
						parametros.put("id_interno", reg.get("id_interno"));
						parametros.put("id_interno_sustituido", regParaSustituir.get("id_interno"));
						sqlSession.update("sustituir.pop1", parametros);
						
						//pop2 - sacar registro y sustituirlo en e_edomex
						parametros.put("id_contacto", reg.get("id_interno").toString());
						parametros.put("id_contacto_sustituido", regParaSustituir.get("id_interno").toString());
						sqlSession.update("sustituir.pop2", parametros);
						
						//System.out.println("Registro: " + reg.get("id_interno") + " Sustituido por: " + regParaSustituir.get("id_interno"));
					}

				}
			}
		}
	}
}
