package com.saganet.politik.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.saganet.politik.components.catalogos.EntidadesC;
import com.saganet.politik.modelos.catalogos.EntidadesT;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/webflow-config.xml", })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogosTest {
	
	@Autowired
	EntidadesC entidadesC;
	
	@Test
	public void testListadoEntidades(){
		EntidadesT tabla;
		
		tabla = entidadesC.tabla();
		
		assertNotNull("listado no nulo", tabla.getListado());
		assertNotNull("Seleccionado no nulo", tabla.getSeleccionado());
	}
}
