package com.saganet.politik.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.saganet.politik.components.administracion.TareasProgramadasC;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/security-config.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/webflow-config.xml", })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ActualizarEstructuras {
	
	@Autowired
	TareasProgramadasC tareasProgramadasC;
	
	@Test
	public void enviarMailTest(){
		tareasProgramadasC.mailPrueba();
	}
}
