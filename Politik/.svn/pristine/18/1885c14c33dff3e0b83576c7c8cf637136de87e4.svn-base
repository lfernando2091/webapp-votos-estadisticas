package com.saganet.politik.components.administracion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Component("AdministracionTareasProgramadasC")
public class TareasProgramadasC {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	VelocityEngine velocityEngine;
	
	//@Scheduled(cron="*/10 * * * * *")
	public void mailPrueba(){
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				List<String> usuarios;
				
				usuarios = new ArrayList<>();
				
				usuarios.add("001");
				usuarios.add("002");
				usuarios.add("003");
				usuarios.add("004");
				usuarios.add("005");
				usuarios.add("006");
				usuarios.add("007");
				
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage); 
				message.setTo(new InternetAddress("erick_saga@hotmail.com", "Erick SaGa"));
				message.setFrom(new InternetAddress("cgf@saganet.com.mx", "CGF"));
				message.setSubject("Mensaje de Prueba");
				
				HashMap<String, Object> model = new HashMap<>();
				
				model.put("nombre", "Erick SaGa");
				model.put("email", "erick_saga@hotmail.com");
				model.put("usuarios", usuarios);
				
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "com/saganet/politik/velocity/templates/pruebaMail.vm", "UTF8", model);
				message.setText(text, true);
			}
		};
		
		try {
			mailSender.send(preparator);
			System.out.println("Mensaje enviado Exitosamente");
		} catch(MailException e) {
			e.printStackTrace();
		}
	}
}
