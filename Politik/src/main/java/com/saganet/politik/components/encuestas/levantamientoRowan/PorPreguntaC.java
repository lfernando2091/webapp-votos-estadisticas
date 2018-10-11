package com.saganet.politik.components.encuestas.levantamientoRowan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.saganet.politik.beans.seguridad.Usuario;
import com.saganet.politik.components.catalogos.MunicipiosC;
import com.saganet.politik.components.sig.PoligonosC;
import com.saganet.politik.database.administracion.UsuarioEO;
import com.saganet.politik.database.catalogos.MunicipioEO;
import com.saganet.politik.database.catalogos.GeozonaParticionEO;
import com.saganet.politik.dominios.NivelesReporteVerticalDO;
import com.saganet.politik.modelos.Modelo;

@Component("LevantamientoRowanPorPreguntaC")
public class PorPreguntaC {
	@Autowired
	SqlSession sqlSession;
	
	@Autowired PoligonosC poligonosC;
	@Autowired MunicipiosC municipiosC;
	
	private static final Logger logger = LoggerFactory.getLogger(PorPreguntaC.class);

	public HashMap<String, Object> resultado(NivelesReporteVerticalDO nivel, GeozonaParticionEO region, MunicipioEO municipio, Integer pregunta) {
		HashMap<String, Object> resultado=new HashMap<>();
		HashMap<String, Object> mapa=new HashMap<>();
		switch (nivel) {
			case REGION:
				mapa.put("region", region);
			break;
			case MUNICIPIO:
				mapa.put("region", region);
				mapa.put("municipio", municipio);
			break;
			case ESTATAL:
			break;
		}
		logger.debug("Mapa : {} ",mapa);
		switch (pregunta) {
			case 1:
				resultado=sqlSession.selectOne("encuestas.levantamientoRowan.porPregunta.p1",mapa);
			break;
			case 2:
				resultado=sqlSession.selectOne("encuestas.levantamientoRowan.porPregunta.p2",mapa);
			break;
			case 3:
				resultado=sqlSession.selectOne("encuestas.levantamientoRowan.porPregunta.p3",mapa);
			break;
			case 4:
				resultado=sqlSession.selectOne("encuestas.levantamientoRowan.porPregunta.p4",mapa);
			break;
			case 5:
				resultado=sqlSession.selectOne("encuestas.levantamientoRowan.porPregunta.p5",mapa);
			break;
			case 6:
				resultado=sqlSession.selectOne("encuestas.levantamientoRowan.porPregunta.p6",mapa);
			break;
			case 7:
				resultado=sqlSession.selectOne("encuestas.levantamientoRowan.porPregunta.p7",mapa);
			break;
			case 8:
				resultado=sqlSession.selectOne("encuestas.levantamientoRowan.porPregunta.p8",mapa);
			break;
			case 9:
				resultado=sqlSession.selectOne("encuestas.levantamientoRowan.porPregunta.p9",mapa);
			break;
		}
		logger.debug("resultado : {} ",resultado);
		return resultado;
	}
	
	public Modelo<HashMap<String, Object>> modelo(NivelesReporteVerticalDO nivel, GeozonaParticionEO region, MunicipioEO municipio, Integer pregunta) {
		List<HashMap<String, Object>> resultado=new ArrayList<>();
		HashMap<String, Object> mapa=new HashMap<>();
		switch (nivel) {
			case REGION:
				mapa.put("columna", "b.entidad , b.region_edomex_2017, b.nombre_region , b.municipio, b.nombre_municipio");
				mapa.put("region", region);
			break;
			case MUNICIPIO:
				mapa.put("columna", "b.entidad , b.region_edomex_2017, b.nombre_region, b.municipio, b.nombre_municipio, b.seccion");
				mapa.put("region", region);
				mapa.put("municipio", municipio);
			break;
			case ESTATAL:
				mapa.put("columna", "b.entidad , b.region_edomex_2017, b.nombre_region");
			break;
		}
		logger.debug("Mapa : {} ",mapa);
		switch (pregunta) {
			case 1:
				resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.p1_2",mapa);
			break;
			case 2:
				resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.p2_2",mapa);
			break;
			case 3:
				resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.p3_2",mapa);
			break;
			case 4:
				resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.p4_2",mapa);
			break;
			case 5:
				resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.p5_2",mapa);
			break;
			case 6:
				resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.p6_2",mapa);
			break;
			case 7:
				resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.p7_2",mapa);
			break;
			case 8:
				resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.p8_2",mapa);
			break;
			case 9:
				resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.p9_2",mapa);
			break;
		}
		logger.debug("resultado : {} ",resultado);
		return new Modelo<>(resultado);
	}
	public HashMap<String, Object> modeloTotal(Integer pregunta, Modelo<HashMap<String, Object>> modelo) {
		HashMap<String, Object> mapa=new HashMap<>();
//		DecimalFormat f = new DecimalFormat("#0.00");
		Integer si=0;
		Integer no=0;
		Integer ns_nc=0;
		Integer _3_primer_corte=0;
		Integer _3_segundo_corte=0;
		Integer _3_tercer_corte=0;
		Integer _7_alfredo=0;
		Integer _7_josefina=0;
		Integer _7_delfina=0;
		Integer _7_oscar=0;
		Integer _7_isidro=0;
		Integer _7_otro=0;
		Integer _7_ns_nc=0;
		Integer _9_finado=0;
		Integer _9_menor=0;
		Integer _9_no_vive=0;
		Integer _9_no_quisieron=0;
		Integer _9_no_hubo=0;
		Integer _9_no_localizado=0;
		Integer _9_domicilio=0;
		Integer _9_otro=0;
		for (HashMap<String, Object> fila : modelo.getListado()) {
			switch (pregunta) {
				case 3:
					_3_primer_corte=_3_primer_corte+Integer.parseInt((fila.get("_3_primer_corte").toString()));
					_3_segundo_corte=_3_segundo_corte+Integer.parseInt((fila.get("_3_segundo_corte").toString()));
					_3_tercer_corte=_3_tercer_corte+Integer.parseInt((fila.get("_3_tercer_corte").toString()));
				break;
				case 7:
					_7_alfredo=_7_alfredo+Integer.parseInt((fila.get("_7_alfredo").toString()));
					_7_josefina=_7_josefina+Integer.parseInt((fila.get("_7_josefina").toString()));
					_7_delfina=_7_delfina+Integer.parseInt((fila.get("_7_delfina").toString()));
					_7_oscar=_7_oscar+Integer.parseInt((fila.get("_7_oscar").toString()));
					_7_isidro=_7_isidro+Integer.parseInt((fila.get("_7_isidro").toString()));
					_7_otro=_7_otro+Integer.parseInt((fila.get("_7_otro").toString()));
					_7_ns_nc=_7_ns_nc+Integer.parseInt((fila.get("_7_ns_nc").toString()));
				break;
				case 9:
					_9_finado=_9_finado+Integer.parseInt((fila.get("_9_finado").toString()));
					_9_menor=_9_menor+Integer.parseInt((fila.get("_9_menor").toString()));
					_9_no_vive=_9_no_vive+Integer.parseInt((fila.get("_9_no_vive").toString()));
					_9_no_quisieron=_9_no_quisieron+Integer.parseInt((fila.get("_9_no_quisieron").toString()));
					_9_no_hubo=_9_no_hubo+Integer.parseInt((fila.get("_9_no_hubo").toString()));
					_9_no_localizado=_9_no_localizado+Integer.parseInt((fila.get("_9_no_localizado").toString()));
					_9_domicilio=_9_domicilio+Integer.parseInt((fila.get("_9_domicilio").toString()));
					_9_otro=_9_otro+Integer.parseInt((fila.get("_9_otro").toString()));
				break;
				default:
					si=si+Integer.parseInt((fila.get("si").toString()));
					no=no+Integer.parseInt((fila.get("r_no").toString()));
					ns_nc=ns_nc+Integer.parseInt((fila.get("ns_nc").toString()));
				break;
			}
		}
		switch (pregunta) {
			case 3:
				mapa.put("_3_primer_corte",String.format("%,d", _3_primer_corte));
				mapa.put("_3_segundo_corte",String.format("%,d", _3_segundo_corte));
				mapa.put("_3_tercer_corte",String.format("%,d", _3_tercer_corte));
			break;
			case 7:
				mapa.put("_7_alfredo",String.format("%,d", _7_alfredo));
				mapa.put("_7_josefina",String.format("%,d", _7_josefina));
				mapa.put("_7_delfina",String.format("%,d", _7_delfina));
				mapa.put("_7_oscar",String.format("%,d", _7_oscar));
				mapa.put("_7_isidro",String.format("%,d", _7_isidro));
				mapa.put("_7_otro",String.format("%,d", _7_otro));
				mapa.put("_7_ns_nc",String.format("%,d", _7_ns_nc));
			break;
			case 9:
				mapa.put("_9_finado",String.format("%,d", _9_finado));
				mapa.put("_9_menor",String.format("%,d", _9_menor));
				mapa.put("_9_no_vive",String.format("%,d", _9_no_vive));
				mapa.put("_9_no_quisieron",String.format("%,d", _9_no_quisieron));
				mapa.put("_9_no_hubo",String.format("%,d", _9_no_hubo));
				mapa.put("_9_no_localizado",String.format("%,d", _9_no_localizado));
				mapa.put("_9_domicilio",String.format("%,d", _9_domicilio));
				mapa.put("_9_otro",String.format("%,d", _9_otro));
			break;
			default:
				mapa.put("si",String.format("%,d", si));
				mapa.put("r_no",String.format("%,d", no));
				mapa.put("ns_nc",String.format("%,d", ns_nc));
			break;
		}
		return mapa;
	}
	
	

	public Modelo<HashMap<String, Object>> modeloCompleto(NivelesReporteVerticalDO nivel, GeozonaParticionEO region, MunicipioEO municipio) {
		List<HashMap<String, Object>> resultado=new ArrayList<>();
		HashMap<String, Object> mapa=new HashMap<>();
		switch (nivel) {
			case REGION:
				mapa.put("columna", "b.entidad , b.region_edomex_2017, b.nombre_region , b.municipio, b.nombre_municipio");
				mapa.put("columna2", "entidad , region_edomex_2017, nombre_region , municipio, nombre_municipio");
				mapa.put("region", region);
			break;
			case MUNICIPIO:
				mapa.put("columna", "b.entidad , b.region_edomex_2017, b.nombre_region, b.municipio, b.nombre_municipio, b.seccion");
				mapa.put("columna2", "entidad , region_edomex_2017, nombre_region , municipio, nombre_municipio, seccion");
				mapa.put("region", region);
				mapa.put("municipio", municipio);
			break;
			case ESTATAL:
				mapa.put("columna", "b.entidad , b.region_edomex_2017, b.nombre_region");
				mapa.put("columna2", "entidad , region_edomex_2017, nombre_region");
			break;
		}
		logger.debug("Mapa : {} ",mapa);
		resultado=sqlSession.selectList("encuestas.levantamientoRowan.porPregunta.todas",mapa);
		logger.debug("resultado : {} ",resultado);
		return new Modelo<>(resultado);
	}
	
	
	public HashMap<String, Object> filaTotal(Modelo<HashMap<String, Object>> modelo) {
		HashMap<String, Object> mapa=new HashMap<>();
//		DecimalFormat f = new DecimalFormat("#0.00");
		Integer _1_si=0;
		Integer _1_no=0;
		Integer _1_ns_nc=0;
		Integer _2_si=0;
		Integer _2_no=0;
		Integer _2_ns_nc=0;
		Integer _3_primer_corte=0;
		Integer _3_segundo_corte=0;
		Integer _3_tercer_corte=0;
		Integer _4_si=0;
		Integer _4_no=0;
		Integer _4_ns_nc=0;
		Integer _5_si=0;
		Integer _5_no=0;
		Integer _5_ns_nc=0;
		Integer _6_si=0;
		Integer _6_no=0;
		Integer _6_ns_nc=0;
		Integer _7_alfredo=0;
		Integer _7_josefina=0;
		Integer _7_delfina=0;
		Integer _7_oscar=0;
		Integer _7_juan=0;
		Integer _7_isidro=0;
		Integer _7_otro=0;
		Integer _7_ns_nc=0;
		Integer _8_si=0;
		Integer _8_no=0;
		Integer _8_ns_nc=0;
		Integer _9_finado=0;
		Integer _9_menor=0;
		Integer _9_no_vive=0;
		Integer _9_no_quisieron=0;
		Integer _9_no_hubo=0;
		Integer _9_no_localizado=0;
		Integer _9_domicilio=0;
		Integer _9_otro=0;
		for (HashMap<String, Object> fila : modelo.getListado()) {
			_1_si=_1_si+Integer.parseInt((fila.get("si_1").toString()));
			_1_no=_1_no+Integer.parseInt((fila.get("no_1").toString()));
			_1_ns_nc=_1_ns_nc+Integer.parseInt((fila.get("ns_nc_1").toString()));
			_2_si=_2_si+Integer.parseInt((fila.get("si_2").toString()));
			_2_no=_2_no+Integer.parseInt((fila.get("no_2").toString()));
			_2_ns_nc=_2_ns_nc+Integer.parseInt((fila.get("ns_nc_2").toString()));
			
			_3_primer_corte=_3_primer_corte+Integer.parseInt((fila.get("primer_corte_3").toString()));
			_3_segundo_corte=_3_segundo_corte+Integer.parseInt((fila.get("segundo_corte_3").toString()));
			_3_tercer_corte=_3_tercer_corte+Integer.parseInt((fila.get("tercer_corte_3").toString()));

			_4_si=_4_si+Integer.parseInt((fila.get("si_4").toString()));
			_4_no=_4_no+Integer.parseInt((fila.get("no_4").toString()));
			_4_ns_nc=_4_ns_nc+Integer.parseInt((fila.get("ns_nc_4").toString()));
			_5_si=_5_si+Integer.parseInt((fila.get("si_5").toString()));
			_5_no=_5_no+Integer.parseInt((fila.get("no_5").toString()));
			_5_ns_nc=_5_ns_nc+Integer.parseInt((fila.get("ns_nc_5").toString()));
			_6_si=_6_si+Integer.parseInt((fila.get("si_6").toString()));
			_6_no=_6_no+Integer.parseInt((fila.get("no_6").toString()));
			_6_ns_nc=_6_ns_nc+Integer.parseInt((fila.get("ns_nc_6").toString()));
			
			_7_alfredo=_7_alfredo+Integer.parseInt((fila.get("alfredo_7").toString()));
			_7_josefina=_7_josefina+Integer.parseInt((fila.get("josefina_7").toString()));
			_7_delfina=_7_delfina+Integer.parseInt((fila.get("delfina_7").toString()));
			_7_oscar=_7_oscar+Integer.parseInt((fila.get("oscar_7").toString()));
			_7_isidro=_7_isidro+Integer.parseInt((fila.get("isidro_7").toString()));
			_7_juan=_7_juan+Integer.parseInt((fila.get("juan_7").toString()));
			_7_otro=_7_otro+Integer.parseInt((fila.get("otro_7").toString()));
			_7_ns_nc=_7_ns_nc+Integer.parseInt((fila.get("ns_nc_7").toString()));

			_8_si=_8_si+Integer.parseInt((fila.get("si_8").toString()));
			_8_no=_8_no+Integer.parseInt((fila.get("no_8").toString()));
			_8_ns_nc=_8_ns_nc+Integer.parseInt((fila.get("ns_nc_8").toString()));
			
			_9_finado=_9_finado+Integer.parseInt((fila.get("finado_9").toString()));
			_9_menor=_9_menor+Integer.parseInt((fila.get("menor_9").toString()));
			_9_no_vive=_9_no_vive+Integer.parseInt((fila.get("no_vive_9").toString()));
			_9_no_quisieron=_9_no_quisieron+Integer.parseInt((fila.get("no_quisieron_9").toString()));
			_9_no_hubo=_9_no_hubo+Integer.parseInt((fila.get("no_hubo_9").toString()));
			_9_no_localizado=_9_no_localizado+Integer.parseInt((fila.get("no_localizado_9").toString()));
			_9_domicilio=_9_domicilio+Integer.parseInt((fila.get("domicilio_9").toString()));
			_9_otro=_9_otro+Integer.parseInt((fila.get("otro_9").toString()));
		}
		mapa.put("si_1",String.format("%,d", _1_si));
		mapa.put("no_1",String.format("%,d", _1_no));
		mapa.put("ns_nc_1",String.format("%,d", _1_ns_nc));
		
		mapa.put("si_2",String.format("%,d", _2_si));
		mapa.put("no_2",String.format("%,d", _2_no));
		mapa.put("ns_nc_2",String.format("%,d", _2_ns_nc));
		
		mapa.put("primer_corte_3",String.format("%,d", _3_primer_corte));
		mapa.put("segundo_corte_3",String.format("%,d", _3_segundo_corte));
		mapa.put("tercer_corte_3",String.format("%,d", _3_tercer_corte));
		
		mapa.put("si_4",String.format("%,d", _4_si));
		mapa.put("no_4",String.format("%,d", _4_no));
		mapa.put("ns_nc_4",String.format("%,d", _4_ns_nc));
		
		mapa.put("si_5",String.format("%,d", _5_si));
		mapa.put("no_5",String.format("%,d", _5_no));
		mapa.put("ns_nc_5",String.format("%,d", _5_ns_nc));
		
		mapa.put("si_6",String.format("%,d", _6_si));
		mapa.put("no_6",String.format("%,d", _6_no));
		mapa.put("ns_nc_6",String.format("%,d", _6_ns_nc));
		
		mapa.put("alfredo_7",String.format("%,d", _7_alfredo));
		mapa.put("josefina_7",String.format("%,d", _7_josefina));
		mapa.put("delfina_7",String.format("%,d", _7_delfina));
		mapa.put("oscar_7",String.format("%,d", _7_oscar));
		mapa.put("juan_7",String.format("%,d", _7_juan));
		mapa.put("isidro_7",String.format("%,d", _7_isidro));
		mapa.put("otro_7",String.format("%,d", _7_otro));
		mapa.put("ns_nc_7",String.format("%,d", _7_ns_nc));
		
		mapa.put("si_8",String.format("%,d", _8_si));
		mapa.put("no_8",String.format("%,d", _8_no));
		mapa.put("ns_nc_8",String.format("%,d", _8_ns_nc));
		
		mapa.put("finado_9",String.format("%,d", _9_finado));
		mapa.put("menor_9",String.format("%,d", _9_menor));
		mapa.put("no_vive_9",String.format("%,d", _9_no_vive));
		mapa.put("no_quisieron_9",String.format("%,d", _9_no_quisieron));
		mapa.put("no_hubo_9",String.format("%,d", _9_no_hubo));
		mapa.put("no_localizado_9",String.format("%,d", _9_no_localizado));
		mapa.put("domicilio_9",String.format("%,d", _9_domicilio));
		mapa.put("otro_9",String.format("%,d", _9_otro));
		return mapa;
	}
	
	
	public UsuarioEO getUsuario() {
		return ((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsuario();
	}

}
