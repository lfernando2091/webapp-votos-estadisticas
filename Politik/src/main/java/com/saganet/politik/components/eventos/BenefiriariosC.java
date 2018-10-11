package com.saganet.politik.components.eventos;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.catalogos.DependenciaEO;
import com.saganet.politik.database.catalogos.ProgramaEO;
import com.saganet.politik.database.catalogos.ProgramaEjercicioEO;
import com.saganet.politik.database.eventos.BeneficiarioEO;
import com.saganet.politik.database.eventos.EventoEjercicioProgramaEO;
import com.saganet.politik.database.eventos.EventoSocialEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;


@Component("BenefiriariosC")
public class BenefiriariosC {
	private static final Logger logger = LoggerFactory.getLogger(BenefiriariosC.class);

	@Autowired
	SqlSession sqlSession;


	public Modelo <BeneficiarioEO> tablaBeneficiarios(EventoSocialEO evento , BeneficiarioEO beneficiario){
	    	Modelo<BeneficiarioEO> tabla=new Modelo<>();
	    	List<BeneficiarioEO> listado = new ArrayList<>();
	    	
	    	listado=sqlSession.selectList("eventos.benericiarios.listadoPorEvento", evento.getId());
	    	tabla.setListado(listado);
	    	logger.debug("El listado es {}",listado);
	    	if (beneficiario!=null) {
				tabla.setSeleccionado(beneficiario);
			}
	    	else if(!listado.isEmpty()){
	    		tabla.setSeleccionado(listado.get(0));
	    	}
	    	return tabla;
	}
	
	public BeneficiarioEO crearBeneficiario(EventoSocialEO evento, PersonaEO persona){
		logger.debug("evento a guardar ess {}",evento);
		logger.debug("persona a guardar es {}",persona);
			BeneficiarioEO beneficiario= new BeneficiarioEO();
			beneficiario.setEvento(evento);
			beneficiario.setPersona(persona);
		return beneficiario;			
	}	
	
	public BeneficiarioEO nuevoBeneficiario(BeneficiarioEO beneficiario) {
		logger.debug("beneficiario a guardar es: {}",beneficiario);
		Integer id= sqlSession.selectOne("eventos.benericiarios.nextID");
		logger.debug("beneficiario id es: {}",id);
		beneficiario.setId(id);
		sqlSession.insert("eventos.benericiarios.insertar", beneficiario);
		return beneficiario;
	}

	public void eliminarBeneficiario(BeneficiarioEO beneficiario) {
		if(beneficiario!=null){
					sqlSession.delete("eventos.benericiarios.eliminar",beneficiario);
		}
	}
	
	public Modelo<JavaBeanT> listadoEjercicios(JavaBeanT evento){
		logger.debug("entro a listado ejercicio");
    	Modelo<JavaBeanT> tabla=new Modelo<>();
    	List<JavaBeanT> listado = new ArrayList<>();
    	listado=sqlSession.selectList("eventos.eventosEjercicioPrograma.listadoPorEvento", evento.getId());
    	logger.debug("Mapeador es: {}", listado);
    	tabla.setListado(listado);
    	logger.debug("El listado es {}",listado);
    	if(!listado.isEmpty()){
    		tabla.setSeleccionado(listado.get(0));
    	}
    	return tabla;
	}
	
	public Modelo<DependenciaEO> listadoDependencias(EventoSocialEO evento) {
		Modelo<DependenciaEO> tabla= new Modelo<>();
		tabla.setListado(evento.getDependencias());
		if (!evento.getDependencias().isEmpty()) {
			tabla.setSeleccionado(evento.getDependencias().get(0));
		}
		return tabla;
	}
	
	public Modelo<ProgramaEO> listadoProgramas(EventoSocialEO evento, DependenciaEO dependencia) {
		Modelo<ProgramaEO> tabla= new Modelo<>();
		List<ProgramaEO> listado= new ArrayList<>();
		for (EventoEjercicioProgramaEO eventosProgramaEjercicio : evento.getTablaEjerciciosProgramas().getListado()) {
			ProgramaEjercicioEO programaEjercicio=eventosProgramaEjercicio.getProgramaEjercicio();
			if(dependencia.equals(programaEjercicio.getPrograma().getDependencia())){
				boolean band=true;
				for (ProgramaEO programa : listado) {
					if (programa.equals(programaEjercicio.getPrograma())) {
						band=false;
					}
				}
				if (band) {
					listado.add(programaEjercicio.getPrograma());
				}
			}
		}
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}
	

	public Modelo<ProgramaEjercicioEO> listadoEjercicios(EventoSocialEO evento, ProgramaEO programa) {
		Modelo<ProgramaEjercicioEO> tabla= new Modelo<>();
		List<ProgramaEjercicioEO> listado= new ArrayList<>();
		for (EventoEjercicioProgramaEO eventosProgramaEjercicio : evento.getTablaEjerciciosProgramas().getListado()) {
			ProgramaEjercicioEO programaEjercicioEvento=eventosProgramaEjercicio.getProgramaEjercicio();
			if(programa.equals(programaEjercicioEvento.getPrograma())){
				boolean band=true;
				for (ProgramaEjercicioEO programaEjercicio : listado) {
					if (programaEjercicio.equals(programaEjercicio)) {
						band=false;
					}
				}
				if (band) {
					listado.add(programaEjercicioEvento);
				}
			}
		}
		tabla.setListado(listado);
		if (!listado.isEmpty()) {
			tabla.setSeleccionado(listado.get(0));
		}
		return tabla;
	}
	
}
