package com.saganet.politik.components.encuestas.sujetosSociales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
/*import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.dominios.NivelesReporteDO;
import com.saganet.politik.modelos.JavaBeanT;
import com.saganet.politik.modelos.Modelo;
import com.saganet.politik.database.encuestas.sujetosSociales.AvanceEncuestadoresEO;

@Component("SujetosSocialesAvanceEncuestadores")
public class AvanceEncuestadoresC {
	@Autowired
	SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(AvanceEncuestadoresC.class);

	public Modelo<AvanceEncuestadoresEO> modelo(NivelesReporteDO nivel) {
		Modelo<AvanceEncuestadoresEO> tabla;
		List<AvanceEncuestadoresEO> listado=new ArrayList<>();
		HashMap<String, Object> mapa=new HashMap<>();
		UsuarioEO usuario=getUsuario();
		if (usuario.getTerritorios()!=null) {
			switch (usuario.getNivel()) {
				case GEOZONA:
					List<GeozonaParticionEO> geozonasParticiones=new ArrayList<>();
					logger.debug("Territorio : {} ", usuario.getTerritorios());
					for (JavaBeanT geozona : usuario.getTerritorios()) {
						geozonasParticiones.add((GeozonaParticionEO)geozona);
					} 
					mapa.put("regiones",geozonasParticiones);
				break;
				case MUNICIPIO:
					mapa.put("municipios",usuario.getTerritorios());
				break;
				default:
				break;
			}
		}
		if (nivel!=null) {
			switch (nivel) {
				case REGION:
					listado=sqlSession.selectList("encuestas.sujetosSociales.avanceEncuestadores.avanceEncuestadoresRegion",mapa);			
				break;
				case MUNICIPIO:
					listado=sqlSession.selectList("encuestas.sujetosSociales.avanceEncuestadores.avanceEncuestadoresMunicipio",mapa);
				break;
				default:
				break;
			}
		}
		//logger.debug("Listado {}",listado);
		tabla=new Modelo<>(listado);
		return tabla;
	}
	
	public AvanceEncuestadoresEO filaTotales(Modelo<AvanceEncuestadoresEO> modelo){
		AvanceEncuestadoresEO total=new AvanceEncuestadoresEO();		
		total.setEncuestadoresGem(0);
		total.setEncuestadoresLiconsa(0);
		total.setEncuestadoresProspera(0);
		total.setEncuestadoresGemMeta(0);
		total.setEncuestadoresLiconsaMeta(0);
		total.setEncuestadoresProsperaMeta(0);
		for (AvanceEncuestadoresEO actual : modelo.getListado()) {
			total.setEncuestadoresGem(total.getEncuestadoresGem()+actual.getEncuestadoresGem());
			total.setEncuestadoresLiconsa(total.getEncuestadoresLiconsa()+actual.getEncuestadoresLiconsa());
			total.setEncuestadoresProspera(total.getEncuestadoresProspera()+actual.getEncuestadoresProspera());
			total.setEncuestadoresGemMeta(total.getEncuestadoresGemMeta()+actual.getEncuestadoresGemMeta());
			total.setEncuestadoresLiconsaMeta(total.getEncuestadoresLiconsaMeta()+actual.getEncuestadoresLiconsaMeta());
			total.setEncuestadoresProsperaMeta(total.getEncuestadoresProsperaMeta()+actual.getEncuestadoresProsperaMeta());
		}
		return total;
	}
	
	
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

}
