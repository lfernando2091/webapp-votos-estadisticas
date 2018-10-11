package com.saganet.politik.controllers.mdm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonasController {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired ServletContext servletContext;
	
	@RequestMapping(value = "/mdm/foto", method = { RequestMethod.GET })
	public void obtenerFoto(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Integer idPersona, idEntidadNacimiento, tipoFoto;
		HashMap<String, Object> parametros;
		byte[] foto;
		File sinFoto;
		FileInputStream fis;
		OutputStream os;

		
		parametros = new HashMap<>();
		
		idPersona = Integer.parseInt(request.getParameter("idPersona").equals("") ? "0" : request.getParameter("idPersona"));
		idEntidadNacimiento = Integer.parseInt(request.getParameter("idEntidadNacimiento").equals("") ? "0" : request.getParameter("idEntidadNacimiento"));
		tipoFoto = Integer.parseInt(request.getParameter("tipoFoto"));
		
		parametros.put("idPersona", idPersona);
		parametros.put("idEntidadNacimiento", idEntidadNacimiento);
		
		foto = null;
		switch(tipoFoto){
		case 1: //Original
			foto = sqlSession.selectOne("warehouse.fotos.fotoAsBytes", parametros);
			break;
		case 2: //Escalada
			foto = sqlSession.selectOne("warehouse.fotos.fotoEscaladaAsBytes", parametros);
			break;
		}
		
		
		if(foto == null){
			sinFoto = new File(servletContext.getRealPath("resources/imagenes/sin_foto.jpg"));
			fis = new FileInputStream(sinFoto);
			foto = new byte[fis.available()];
			fis.read(foto);
			fis.close();
		}
		
		response.setContentType("image/jpeg");
		response.setContentLength(foto.length);
		
		os = response.getOutputStream();
		os.write(foto);
		
		os.close();
	}
}
