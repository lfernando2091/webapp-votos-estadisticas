package com.saganet.politik.components.estructurasEdoMex;

import java.util.List;
import org.slf4j.Logger;
import java.util.HashMap;
import org.slf4j.LoggerFactory;

import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.estructurasEdoMex.CoordinadorMunicipalEO;
import com.saganet.politik.database.estructurasEdoMex.CoordinadorRegionalEO;
import com.saganet.politik.database.estructurasEdoMex.SupervisorEO;
import com.saganet.politik.database.estructurasEdoMex.VisitadorEO;
import com.saganet.politik.database.mdm.PersonaEO;
import com.saganet.politik.dominios.EstructurasEdoMexDO;

@Component("EstructurasEdoMexEstructurasEdoMexC")
public class EstructurasEdoMexC {
	private static final Logger logger = LoggerFactory.getLogger(EstructurasEdoMexC.class);

	@Autowired
	SqlSession sqlSession;
	
	public HashMap<String, Object> modelo(EstructurasEdoMexDO estructura, GeozonaParticionEO region, MunicipioEO municipio) {
		HashMap<String, Object> resultado=new HashMap<>();
		HashMap<String, Object> mapa=new HashMap<>();
		mapa.put("region", region);
		mapa.put("municipio", municipio);
		mapa.put("programas", getUsuario().getProgamas());
		mapa.put("usuario", getUsuario());
		logger.debug("Mapa Recibida : {}",mapa);
		switch (estructura) {
			case COORDINADOR_REGIONAL:
				List<CoordinadorRegionalEO> listado1=sqlSession.selectList("estructurasEdoMex.coordinadorRegional.listado",mapa);
				Modelo<CoordinadorRegionalEO> modelo1=new Modelo<>(listado1) ;
				resultado.put("modelo", modelo1);
			break;	
			case COORDINADOR_MUNICIPAL:
				List<CoordinadorMunicipalEO> listado2=sqlSession.selectList("estructurasEdoMex.coordinadorMunicipal.listado",mapa);
				Modelo<CoordinadorMunicipalEO> modelo2=new Modelo<>(listado2) ;
				resultado.put("modelo", modelo2);
			break;
			case SUPERVISOR:
				List<SupervisorEO> listado3=sqlSession.selectList("estructurasEdoMex.supervisor.listado",mapa);
				Modelo<SupervisorEO> modelo3=new Modelo<>(listado3) ;
				resultado.put("modelo", modelo3);
			break;	
			case VISITADOR:
				List<VisitadorEO> listado4=sqlSession.selectList("estructurasEdoMex.visitador.listado",mapa);
				Modelo<VisitadorEO> modelo4=new Modelo<>(listado4) ;
				resultado.put("modelo", modelo4);
			break;	
		}
		return resultado;		
	}
	
	public void guardar(EstructurasEdoMexDO estructura, GeozonaParticionEO region, MunicipioEO municipio, PersonaEO persona) {
		switch (estructura) {
			case COORDINADOR_REGIONAL:
				CoordinadorRegionalEO coordRegional=new CoordinadorRegionalEO();
				coordRegional.setPersona(persona);
				coordRegional.setRegion(region);
				coordRegional.setUsuario(getUsuario());
				coordRegional.setPrograma(getUsuario().getProgamas().get(0));
				sqlSession.insert("estructurasEdoMex.coordinadorRegional.insertar",coordRegional);
			break;	
			case COORDINADOR_MUNICIPAL:
				CoordinadorMunicipalEO coordMunicipal=new CoordinadorMunicipalEO();
				coordMunicipal.setMunicipio(municipio);
				coordMunicipal.setRegion(region);
				coordMunicipal.setPersona(persona);
				coordMunicipal.setUsuario(getUsuario());
				coordMunicipal.setPrograma(getUsuario().getProgamas().get(0));
				sqlSession.insert("estructurasEdoMex.coordinadorMunicipal.insertar",coordMunicipal);
			break;
			case SUPERVISOR:
				SupervisorEO supervisor=new SupervisorEO();
				supervisor.setMunicipio(municipio);
				supervisor.setRegion(region);
				supervisor.setPersona(persona);
				supervisor.setUsuario(getUsuario());
				supervisor.setPrograma(getUsuario().getProgamas().get(0));
				sqlSession.insert("estructurasEdoMex.supervisor.insertar",supervisor);
			break;
			case VISITADOR:
			break;	
		}
	}
	
	public void eliminar(EstructurasEdoMexDO estructura, JavaBeanT resultado) {
		switch (estructura) {
			case COORDINADOR_REGIONAL:
				sqlSession.delete("estructurasEdoMex.coordinadorRegional.eliminar",(CoordinadorRegionalEO)resultado);
			break;	
			case COORDINADOR_MUNICIPAL:
				sqlSession.delete("estructurasEdoMex.coordinadorMunicipal.eliminar",(CoordinadorMunicipalEO)resultado);				
			break;
			case SUPERVISOR:
				sqlSession.delete("estructurasEdoMex.supervisor.eliminar",(SupervisorEO)resultado);
			break;
			case VISITADOR:
			break;	
		}
	}
	
	
	private UsuarioEO getUsuario(){
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}
	
}
