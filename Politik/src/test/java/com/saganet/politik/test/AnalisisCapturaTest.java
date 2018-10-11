package com.saganet.politik.test;

import java.sql.Timestamp;
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
public class AnalisisCapturaTest {
	
	@Autowired SqlSession sqlSession;
	
	@Test
	public void indiceCaptura(){
		List<String> nicks;
		List<Timestamp> accesos, capturas;
		HashMap<String, Object> parametros;
		int i;
		double promedioPorAcceso, accesosPorNick, promedioCapturaNick;
		
		parametros = new HashMap<>();
		nicks = sqlSession.selectList("pruebas.nicksPorPrograma", "LICONSA");
		
		System.out.println("nick\tpromedio");
		for(String nick : nicks){
			System.out.print(nick);
			
			accesos = sqlSession.selectList("pruebas.accesosPorNick", nick);
			
			promedioCapturaNick = 0;
			for(i=0; i<accesos.size()-1; i++){
				parametros.put("nick", nick);
				parametros.put("fi", accesos.get(i));
				parametros.put("ff", accesos.get(i+1));
				capturas = sqlSession.selectList("pruebas.capturasPorFechas", parametros);
				//System.out.println("Capturas: " + capturas.size());
				
				if(!capturas.isEmpty()){
					//System.out.println("1ra. captura: " + capturas.get(0));
					//System.out.println("Última captura: " + capturas.get(capturas.size()-1));
					promedioPorAcceso = (capturas.get(capturas.size()-1).getTime() - capturas.get(0).getTime())/1000.0/capturas.size();
					//System.out.println("Promedio por Captura: " +  promedioPorAcceso);
					promedioCapturaNick += promedioPorAcceso;
				}
			}
			promedioCapturaNick /= accesos.size();
			System.out.println("\t" + Math.round(promedioCapturaNick));
			//break;
		}
		
	}
}
