package com.saganet.politik.components.encuestas.syncdm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saganet.politik.database.encuestas.syncdm.PersonaImjuveEO;
import com.saganet.politik.modelos.Modelo;


@Component("SyncDMResultadoEncuestasC")
public class ResultadoEncuestasC {
	@Autowired
	SqlSession sqlSession;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ResultadoEncuestasC.class);
	
	public List<HashMap<String, Object>> buscar(String folio){
		List<HashMap<String, Object>> listado;
		
		listado = new ArrayList<>();
		listado = sqlSession.selectList("encuestas.syncdm.resultadoEncuestas.resultado", Integer.parseInt(folio));
		logger.debug("Tamaño: ", listado.size());
		if(listado.size()<0){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "No se encotró datos de folio encuesta"));
			return listado;
		}else{
		return listado;
		}
	}
	
	public List<HashMap<String, Object>> encuestasUsuario(String folio){
		List<HashMap<String, Object>> listado;
		listado = new ArrayList<>();
		
		listado = sqlSession.selectList("encuestas.syncdm.resultadoEncuestas.resultadoUsuario", Integer.parseInt(folio));
		logger.debug("Tamaño: ", listado.size());
		return listado;
	}
	
	public PersonaImjuveEO nuevaPersona(HashMap<String, Object> mapa){
		PersonaImjuveEO persona;
		
		persona = new PersonaImjuveEO();
		if(mapa.get("p_3").equals("NO") || mapa.get("p_3").equals("-")){
		persona.setId(1);
		}
		else if(mapa.get("p_20").equals("NO") || mapa.get("p_3").equals("-")){
			persona.setId(2);
			}
		else if(mapa.get("p_37").equals("NO") || mapa.get("p_37").equals("-")){
			persona.setId(3);
			}
		else if(mapa.get("p_54").equals("NO") || mapa.get("p_54").equals("-")){
			persona.setId(4);
			}
		else  if(mapa.get("p_71").equals("NO") || mapa.get("p_71").equals("-")){
			persona.setId(5);
			}
		else if(mapa.get("p_88").equals("NO") || mapa.get("p_88").equals("-")){
			persona.setId(6);
			}
		else if(mapa.get("p_105").equals("NO") || mapa.get("p_105").equals("-")){
			persona.setId(7);
			}
		else if(mapa.get("p_122").equals("NO") || mapa.get("p_122").equals("-")){
			persona.setId(8);
			}
		else if(mapa.get("p_139").equals("NO") || mapa.get("p_139").equals("-")){
			persona.setId(9);
			}
		else if(mapa.get("p_156").equals("NO") || mapa.get("p_156").equals("-")){
			persona.setId(10);
			}
		return  persona;
	}
  public Modelo<PersonaImjuveEO> modeloPersonas(HashMap<String, Object> mapa){
	  Modelo<PersonaImjuveEO> modelo;
	 
	  List<PersonaImjuveEO> listado;
	  
	  modelo = new Modelo<>();
	  listado = new ArrayList<>();
	  logger.debug("Mapa Entrada: {}", mapa);
	  
	  if(!mapa.get("p_3").equals("NO") && !mapa.get("p_3").equals("-")){
		  PersonaImjuveEO persona;
			persona = new PersonaImjuveEO();
			persona.setId(1);
			persona.setNombre(mapa.get("p_4").toString());
			persona.setPaterno(mapa.get("p_5").toString());
			persona.setMaterno(mapa.get("p_6").toString());
			persona.setSexo(mapa.get("p_7").toString());
			persona.setEdad(mapa.get("p_8").toString());
			persona.setNivelEstudios(mapa.get("p_9").toString());
			persona.setEstudia(mapa.get("p_10").toString());
			persona.setOcupacion(mapa.get("p_11").toString());
			persona.setAfiliado(mapa.get("p_12").toString());
			persona.setEstado(mapa.get("p_13").toString());
			persona.setFechaNacimiento(mapa.get("p_14").toString());
			persona.setJefe(mapa.get("p_15").toString());
			persona.setNoCelular(mapa.get("p_16").toString());
			persona.setDonado(mapa.get("p_17").toString());
			persona.setCelular(mapa.get("p_18").toString());
			persona.setSaldo(mapa.get("p_19").toString());
			listado.add(persona);
			}
	  logger.debug("Persona 1: {}", listado);
	  if(!mapa.get("p_20").equals("NO") && !mapa.get("p_20").equals("-")){
		  PersonaImjuveEO persona;
		  persona = new PersonaImjuveEO();
			persona.setId(2);
			persona.setNombre(mapa.get("p_21").toString());
			persona.setPaterno(mapa.get("p_22").toString());
			persona.setMaterno(mapa.get("p_23").toString());
			persona.setSexo(mapa.get("p_24").toString());
			persona.setEdad(mapa.get("p_25").toString());
			
			persona.setNivelEstudios(mapa.get("p_26").toString());
			logger.debug("uno: {}", persona);
			persona.setEstudia(mapa.get("p_27").toString());
		
			persona.setOcupacion(mapa.get("p_28").toString());
			persona.setAfiliado(mapa.get("p_29").toString());
			persona.setEstado(mapa.get("p_30").toString());
			
			persona.setFechaNacimiento(mapa.get("p_31").toString());
			persona.setJefe(mapa.get("p_32").toString());
			persona.setNoCelular(mapa.get("p_33").toString());
			persona.setDonado(mapa.get("p_34").toString());
			persona.setCelular(mapa.get("p_35").toString());
			persona.setSaldo(mapa.get("p_36").toString());
			listado.add(persona);
			}
	  logger.debug("Persona 2: {}", listado);
		if(!mapa.get("p_37").equals("NO") && !mapa.get("p_37").equals("-")){
			 PersonaImjuveEO persona;
			persona = new PersonaImjuveEO();
			persona.setId(3);
			persona.setNombre(mapa.get("p_38").toString());
			persona.setPaterno(mapa.get("p_39").toString());
			persona.setMaterno(mapa.get("p_40").toString());
			persona.setSexo(mapa.get("p_41").toString());
			persona.setEdad(mapa.get("p_42").toString());
			persona.setNivelEstudios(mapa.get("p_43").toString());
			persona.setEstudia(mapa.get("p_44").toString());
			persona.setOcupacion(mapa.get("p_45").toString());
			persona.setAfiliado(mapa.get("p_46").toString());
			persona.setEstado(mapa.get("p_47").toString());
			persona.setFechaNacimiento(mapa.get("p_48").toString());
			persona.setJefe(mapa.get("p_49").toString());
			persona.setNoCelular(mapa.get("p_50").toString());
			persona.setDonado(mapa.get("p_51").toString());
			persona.setCelular(mapa.get("p_52").toString());
			persona.setSaldo(mapa.get("p_53").toString());
			listado.add(persona);
			}
		logger.debug("Persona 3: {}", listado);
		 if(!mapa.get("p_54").equals("NO") && !mapa.get("p_54").equals("-")){
			 PersonaImjuveEO persona;
			 persona = new PersonaImjuveEO();
				persona.setId(4);
				persona.setNombre(mapa.get("p_55").toString());
				persona.setPaterno(mapa.get("p_56").toString());
				persona.setMaterno(mapa.get("p_57").toString());
				persona.setSexo(mapa.get("p_58").toString());
				persona.setEdad(mapa.get("p_59").toString());
				persona.setNivelEstudios(mapa.get("p_60").toString());
				persona.setEstudia(mapa.get("p_61").toString());
				persona.setOcupacion(mapa.get("p_62").toString());
				persona.setAfiliado(mapa.get("p_63").toString());
				persona.setEstado(mapa.get("p_64").toString());
				persona.setFechaNacimiento(mapa.get("p_65").toString());
				persona.setJefe(mapa.get("p_66").toString());
				persona.setNoCelular(mapa.get("p_67").toString());
				persona.setDonado(mapa.get("p_68").toString());
				persona.setCelular(mapa.get("p_69").toString());
				persona.setSaldo(mapa.get("p_70").toString());
				listado.add(persona);
			}
		 logger.debug("Persona 4: {}", listado);
		 if(!mapa.get("p_71").equals("NO") && !mapa.get("p_71").equals("-")){
			 PersonaImjuveEO persona;
			 persona = new PersonaImjuveEO();
				persona.setId(5);
				persona.setNombre(mapa.get("p_72").toString());
				persona.setPaterno(mapa.get("p_73").toString());
				persona.setMaterno(mapa.get("p_74").toString());
				persona.setSexo(mapa.get("p_75").toString());
				persona.setEdad(mapa.get("p_76").toString());
				persona.setNivelEstudios(mapa.get("p_77").toString());
				persona.setEstudia(mapa.get("p_78").toString());
				persona.setOcupacion(mapa.get("p_79").toString());
				persona.setAfiliado(mapa.get("p_80").toString());
				persona.setEstado(mapa.get("p_81").toString());
				persona.setFechaNacimiento(mapa.get("p_82").toString());
				persona.setJefe(mapa.get("p_83").toString());
				persona.setNoCelular(mapa.get("p_84").toString());
				persona.setDonado(mapa.get("p_85").toString());
				persona.setCelular(mapa.get("p_86").toString());
				persona.setSaldo(mapa.get("p_87").toString());
				listado.add(persona);
			}
		 logger.debug("Persona5: {}", listado);
		 if(!mapa.get("p_88").equals("NO") && !mapa.get("p_88").equals("-")){
			 PersonaImjuveEO persona;
			 persona = new PersonaImjuveEO();
				persona.setId(6);
				persona.setNombre(mapa.get("p_89").toString());
				persona.setPaterno(mapa.get("p_90").toString());
				persona.setMaterno(mapa.get("p_91").toString());
				persona.setSexo(mapa.get("p_92").toString());
				persona.setEdad(mapa.get("p_93").toString());
				persona.setNivelEstudios(mapa.get("p_94").toString());
				persona.setEstudia(mapa.get("p_95").toString());
				persona.setOcupacion(mapa.get("p_96").toString());
				persona.setAfiliado(mapa.get("p_97").toString());
				persona.setEstado(mapa.get("p_98").toString());
				persona.setFechaNacimiento(mapa.get("p_99").toString());
				persona.setJefe(mapa.get("p_100").toString());
				persona.setNoCelular(mapa.get("p_101").toString());
				persona.setDonado(mapa.get("p_102").toString());
				persona.setCelular(mapa.get("p_103").toString());
				persona.setSaldo(mapa.get("p_104").toString());
				listado.add(persona);
			}
		 logger.debug("Persona 6: {}", listado);
		 if(!mapa.get("p_105").equals("NO") && !mapa.get("p_105").equals("-")){
			 PersonaImjuveEO persona;
			 persona = new PersonaImjuveEO();
				persona.setId(7);
				persona.setNombre(mapa.get("p_106").toString());
				persona.setPaterno(mapa.get("p_107").toString());
				persona.setMaterno(mapa.get("p_108").toString());
				persona.setSexo(mapa.get("p_109").toString());
				persona.setEdad(mapa.get("p_110").toString());
				persona.setNivelEstudios(mapa.get("p_111").toString());
				persona.setEstudia(mapa.get("p_112").toString());
				persona.setOcupacion(mapa.get("p_113").toString());
				persona.setAfiliado(mapa.get("p_114").toString());
				persona.setEstado(mapa.get("p_115").toString());
				persona.setFechaNacimiento(mapa.get("p_116").toString());
				persona.setJefe(mapa.get("p_117").toString());
				persona.setNoCelular(mapa.get("p_118").toString());
				persona.setDonado(mapa.get("p_119").toString());
				persona.setCelular(mapa.get("p_120").toString());
				persona.setSaldo(mapa.get("p_121").toString());
				listado.add(persona);
			}
		 logger.debug("Persona 7: {}", listado);
		 if(!mapa.get("p_122").equals("NO") && !mapa.get("p_122").equals("-")){
			 PersonaImjuveEO persona;
			 persona = new PersonaImjuveEO();
				persona.setId(8);
				persona.setNombre(mapa.get("p_123").toString());
				persona.setPaterno(mapa.get("p_124").toString());
				persona.setMaterno(mapa.get("p_125").toString());
				persona.setSexo(mapa.get("p_126").toString());
				persona.setEdad(mapa.get("p_127").toString());
				persona.setNivelEstudios(mapa.get("p_128").toString());
				persona.setEstudia(mapa.get("p_129").toString());
				persona.setOcupacion(mapa.get("p_130").toString());
				persona.setAfiliado(mapa.get("p_131").toString());
				persona.setEstado(mapa.get("p_132").toString());
				persona.setFechaNacimiento(mapa.get("p_133").toString());
				persona.setJefe(mapa.get("p_134").toString());
				persona.setNoCelular(mapa.get("p_135").toString());
				persona.setDonado(mapa.get("p_136").toString());
				persona.setCelular(mapa.get("p_137").toString());
				persona.setSaldo(mapa.get("p_138").toString());
				listado.add(persona);
			}
		 logger.debug("Persona 8: {}", listado);
		 if(!mapa.get("p_139").equals("NO") && !mapa.get("p_139").equals("-")){
			 PersonaImjuveEO persona;
			 persona = new PersonaImjuveEO();
				persona.setId(9);
				persona.setNombre(mapa.get("p_140").toString());
				persona.setPaterno(mapa.get("p_141").toString());
				persona.setMaterno(mapa.get("p_142").toString());
				persona.setSexo(mapa.get("p_143").toString());
				persona.setEdad(mapa.get("p_144").toString());
				persona.setNivelEstudios(mapa.get("p_145").toString());
				persona.setEstudia(mapa.get("p_146").toString());
				persona.setOcupacion(mapa.get("p_147").toString());
				persona.setAfiliado(mapa.get("p_148").toString());
				persona.setEstado(mapa.get("p_149").toString());
				persona.setFechaNacimiento(mapa.get("p_150").toString());
				persona.setJefe(mapa.get("p_151").toString());
				persona.setNoCelular(mapa.get("p_152").toString());
				persona.setDonado(mapa.get("p_153").toString());
				persona.setCelular(mapa.get("p_154").toString());
				persona.setSaldo(mapa.get("p_155").toString());
				listado.add(persona);
			}
		 logger.debug("Persona 9: {}", listado);
		 if(!mapa.get("p_156").equals("NO") && !mapa.get("p_156").equals("-")){
			 PersonaImjuveEO persona;
			 persona = new PersonaImjuveEO();
				persona.setId(10);
				persona.setNombre(mapa.get("p_157").toString());
				persona.setPaterno(mapa.get("p_158").toString());
				persona.setMaterno(mapa.get("p_159").toString());
				persona.setSexo(mapa.get("p_160").toString());
				persona.setEdad(mapa.get("p_161").toString());
				persona.setNivelEstudios(mapa.get("p_162").toString());
				persona.setEstudia(mapa.get("p_163").toString());
				persona.setOcupacion(mapa.get("p_163").toString());
				persona.setAfiliado(mapa.get("p_164").toString());
				persona.setEstado(mapa.get("p_165").toString());
				persona.setFechaNacimiento(mapa.get("p_166").toString());
				persona.setJefe(mapa.get("p_167").toString());
				persona.setNoCelular(mapa.get("p_168").toString());
				persona.setDonado(mapa.get("p_169").toString());
				persona.setCelular(mapa.get("p_170").toString());
				persona.setSaldo(mapa.get("p_171").toString());
				listado.add(persona);
			}
		 
	  logger.debug("Listado 10: {} ", listado);
	  modelo.setListado(listado);
	  if(!listado.isEmpty())
	  {
		  modelo.setSeleccionado(listado.get(0));
	  }
	  return modelo;
  }
	public void guardarPersona(String folio, PersonaImjuveEO persona, Integer idEncuesta){
		HashMap<String, Object> mapa;
		Integer inicioPersona;
		
		logger.debug("folio: {}", folio);
		logger.debug("Racibo: {}", persona);
		logger.debug("encuesta: {}", idEncuesta);
		
		inicioPersona= 0;
		mapa = new HashMap<>();
		inicioPersona=0;
		switch(persona.getId()){
		case 1:
			inicioPersona = 3;
			mapa.put("c1","p_3");mapa.put("c2","p_4");
			mapa.put("c3","p_5");mapa.put("c4","p_6");
			mapa.put("c5","p_7");mapa.put("c6","p_8");
			mapa.put("c7","p_9");mapa.put("c8","p_10");
			mapa.put("c9","p_11");mapa.put("c10","p_12");
			mapa.put("c11","p_13");	mapa.put("c12","p_14");
			mapa.put("c13","p_15");	mapa.put("c14","p_16");
			mapa.put("c15","p_17");mapa.put("c16","p_18");
			mapa.put("c17","p_19");
			break;
			case 2:
				inicioPersona = 20;
				mapa.put("c1","p_20");
				mapa.put("c2","p_21");
				mapa.put("c3","p_22");
				mapa.put("c4","p_23");
				mapa.put("c5","p_24");
				mapa.put("c6","p_25");
				mapa.put("c7","p_26");
				mapa.put("c8","p_27");
				mapa.put("c9","p_28");
				mapa.put("c10","p_29");
				mapa.put("c11","p_30");
				mapa.put("c12","p_31");
				mapa.put("c13","p_32");
				mapa.put("c14","p_33");
				mapa.put("c15","p_34");
				mapa.put("c16","p_35");
				mapa.put("c17","p_36");

				break;
			case 3:
				inicioPersona = 37;
				mapa.put("c1","p_37");
				mapa.put("c2","p_38");
				mapa.put("c3","p_39");
				mapa.put("c4","p_40");
				mapa.put("c5","p_41");
				mapa.put("c6","p_42");
				mapa.put("c7","p_43");
				mapa.put("c8","p_44");
				mapa.put("c9","p_45");
				mapa.put("c10","p_46");
				mapa.put("c11","p_47");
				mapa.put("c12","p_48");
				mapa.put("c13","p_49");
				mapa.put("c14","p_50");
				mapa.put("c15","p_51");
				mapa.put("c16","p_52");
				mapa.put("c17","p_53");

				break;
			case 4:
				inicioPersona = 54;
				mapa.put("c1","p_54");
				mapa.put("c2","p_55");
				mapa.put("c3","p_56");
				mapa.put("c4","p_57");
				mapa.put("c5","p_58");
				mapa.put("c6","p_59");
				mapa.put("c7","p_60");
				mapa.put("c8","p_61");
				mapa.put("c9","p_62");
				mapa.put("c10","p_63");
				mapa.put("c11","p_64");
				mapa.put("c12","p_65");
				mapa.put("c13","p_66");
				mapa.put("c14","p_67");
				mapa.put("c15","p_68");
				mapa.put("c16","p_69");
				mapa.put("c17","p_70");

				break;
			case 5:
				inicioPersona = 71;
				mapa.put("c1","p_71");
				mapa.put("c2","p_72");
				mapa.put("c3","p_73");
				mapa.put("c4","p_74");
				mapa.put("c5","p_75");
				mapa.put("c6","p_76");
				mapa.put("c7","p_77");
				mapa.put("c8","p_78");
				mapa.put("c9","p_79");
				mapa.put("c10","p_80");
				mapa.put("c11","p_81");
				mapa.put("c12","p_82");
				mapa.put("c13","p_83");
				mapa.put("c14","p_84");
				mapa.put("c15","p_85");
				mapa.put("c16","p_86");
				mapa.put("c17","p_87");

				break;
			case 6:
				inicioPersona = 88;
				mapa.put("c1","p_88");
				mapa.put("c2","p_89");
				mapa.put("c3","p_90");
				mapa.put("c4","p_91");
				mapa.put("c5","p_92");
				mapa.put("c6","p_93");
				mapa.put("c7","p_94");
				mapa.put("c8","p_95");
				mapa.put("c9","p_96");
				mapa.put("c10","p_97");
				mapa.put("c11","p_98");
				mapa.put("c12","p_99");
				mapa.put("c13","p_100");
				mapa.put("c14","p_101");
				mapa.put("c15","p_102");
				mapa.put("c16","p_103");
				mapa.put("c17","p_104");

				break;
			case 7:
				inicioPersona = 105;
				mapa.put("c1","p_105");
				mapa.put("c2","p_106");
				mapa.put("c3","p_107");
				mapa.put("c4","p_108");
				mapa.put("c5","p_109");
				mapa.put("c6","p_110");
				mapa.put("c7","p_111");
				mapa.put("c8","p_112");
				mapa.put("c9","p_113");
				mapa.put("c10","p_114");
				mapa.put("c11","p_115");
				mapa.put("c12","p_116");
				mapa.put("c13","p_117");
				mapa.put("c14","p_118");
				mapa.put("c15","p_119");
				mapa.put("c16","p_120");
				mapa.put("c17","p_121");
				break;
			case 8:
				inicioPersona = 122;
				mapa.put("c1","p_122");
				mapa.put("c2","p_123");
				mapa.put("c3","p_124");
				mapa.put("c4","p_125");
				mapa.put("c5","p_126");
				mapa.put("c6","p_127");
				mapa.put("c7","p_128");
				mapa.put("c8","p_129");
				mapa.put("c9","p_130");
				mapa.put("c10","p_131");
				mapa.put("c11","p_132");
				mapa.put("c12","p_133");
				mapa.put("c13","p_134");
				mapa.put("c14","p_135");
				mapa.put("c15","p_136");
				mapa.put("c16","p_137");
				mapa.put("c17","p_138");
				break;
			case 9:
				inicioPersona = 139;
				mapa.put("c1","p_139");
				mapa.put("c2","p_140");
				mapa.put("c3","p_141");
				mapa.put("c4","p_142");
				mapa.put("c5","p_143");
				mapa.put("c6","p_144");
				mapa.put("c7","p_145");
				mapa.put("c8","p_146");
				mapa.put("c9","p_147");
				mapa.put("c10","p_148");
				mapa.put("c11","p_149");
				mapa.put("c12","p_150");
				mapa.put("c13","p_151");
				mapa.put("c14","p_152");
				mapa.put("c15","p_153");
				mapa.put("c16","p_154");
				mapa.put("c17","p_155");

				break;
			case 10:
				inicioPersona = 156;
				mapa.put("c1","p_156");
				mapa.put("c2","p_157");
				mapa.put("c3","p_158");
				mapa.put("c4","p_159");
				mapa.put("c5","p_160");
				mapa.put("c6","p_161");
				mapa.put("c7","p_162");
				mapa.put("c8","p_163");
				mapa.put("c9","p_164");
				mapa.put("c10","p_165");
				mapa.put("c11","p_166");
				mapa.put("c12","p_167");
				mapa.put("c13","p_168");
				mapa.put("c14","p_169");
				mapa.put("c15","p_170");
				mapa.put("c16","p_171");
				mapa.put("c17","p_172");

				break;
		}
		mapa.put("persona", persona);
		mapa.put("id_encuesta", idEncuesta);
		sqlSession.update("encuestas.syncdm.resultadoEncuestas.insertarPersona", mapa);
		
		logger.debug("Persona:{}", persona);
	}
	public void eliminar(PersonaImjuveEO persona, Integer idEncuesta){
		logger.debug("Persona recibida eliminar: {}", idEncuesta);
		HashMap<String, Object> mapa;
		Integer inicioPersona;
		inicioPersona = 0;
		mapa = new HashMap<>();
		
		switch(persona.getId()){
		case 1:
			inicioPersona = 3;
			mapa.put("c1","p_3");mapa.put("c2","p_4");
			mapa.put("c3","p_5");mapa.put("c4","p_6");
			mapa.put("c5","p_7");mapa.put("c6","p_8");
			mapa.put("c7","p_9");mapa.put("c8","p_10");
			mapa.put("c9","p_11");mapa.put("c10","p_12");
			mapa.put("c11","p_13");	mapa.put("c12","p_14");
			mapa.put("c13","p_15");	mapa.put("c14","p_16");
			mapa.put("c15","p_17");mapa.put("c16","p_18");
			mapa.put("c17","p_19");
			break;
			case 2:
				inicioPersona = 20;
				mapa.put("c1","p_20");
				mapa.put("c2","p_21");
				mapa.put("c3","p_22");
				mapa.put("c4","p_23");
				mapa.put("c5","p_24");
				mapa.put("c6","p_25");
				mapa.put("c7","p_26");
				mapa.put("c8","p_27");
				mapa.put("c9","p_28");
				mapa.put("c10","p_29");
				mapa.put("c11","p_30");
				mapa.put("c12","p_31");
				mapa.put("c13","p_32");
				mapa.put("c14","p_33");
				mapa.put("c15","p_34");
				mapa.put("c16","p_35");
				mapa.put("c17","p_36");

				break;
			case 3:
				inicioPersona = 37;
				mapa.put("c1","p_37");
				mapa.put("c2","p_38");
				mapa.put("c3","p_39");
				mapa.put("c4","p_40");
				mapa.put("c5","p_41");
				mapa.put("c6","p_42");
				mapa.put("c7","p_43");
				mapa.put("c8","p_44");
				mapa.put("c9","p_45");
				mapa.put("c10","p_46");
				mapa.put("c11","p_47");
				mapa.put("c12","p_48");
				mapa.put("c13","p_49");
				mapa.put("c14","p_50");
				mapa.put("c15","p_51");
				mapa.put("c16","p_52");
				mapa.put("c17","p_53");

				break;
			case 4:
				inicioPersona = 54;
				mapa.put("c1","p_54");
				mapa.put("c2","p_55");
				mapa.put("c3","p_56");
				mapa.put("c4","p_57");
				mapa.put("c5","p_58");
				mapa.put("c6","p_59");
				mapa.put("c7","p_60");
				mapa.put("c8","p_61");
				mapa.put("c9","p_62");
				mapa.put("c10","p_63");
				mapa.put("c11","p_64");
				mapa.put("c12","p_65");
				mapa.put("c13","p_66");
				mapa.put("c14","p_67");
				mapa.put("c15","p_68");
				mapa.put("c16","p_69");
				mapa.put("c17","p_70");

				break;
			case 5:
				inicioPersona = 71;
				mapa.put("c1","p_71");
				mapa.put("c2","p_72");
				mapa.put("c3","p_73");
				mapa.put("c4","p_74");
				mapa.put("c5","p_75");
				mapa.put("c6","p_76");
				mapa.put("c7","p_77");
				mapa.put("c8","p_78");
				mapa.put("c9","p_79");
				mapa.put("c10","p_80");
				mapa.put("c11","p_81");
				mapa.put("c12","p_82");
				mapa.put("c13","p_83");
				mapa.put("c14","p_84");
				mapa.put("c15","p_85");
				mapa.put("c16","p_86");
				mapa.put("c17","p_87");

				break;
			case 6:
				inicioPersona = 88;
				mapa.put("c1","p_88");
				mapa.put("c2","p_89");
				mapa.put("c3","p_90");
				mapa.put("c4","p_91");
				mapa.put("c5","p_92");
				mapa.put("c6","p_93");
				mapa.put("c7","p_94");
				mapa.put("c8","p_95");
				mapa.put("c9","p_96");
				mapa.put("c10","p_97");
				mapa.put("c11","p_98");
				mapa.put("c12","p_99");
				mapa.put("c13","p_100");
				mapa.put("c14","p_101");
				mapa.put("c15","p_102");
				mapa.put("c16","p_103");
				mapa.put("c17","p_104");

				break;
			case 7:
				inicioPersona = 105;
				mapa.put("c1","p_105");
				mapa.put("c2","p_106");
				mapa.put("c3","p_107");
				mapa.put("c4","p_108");
				mapa.put("c5","p_109");
				mapa.put("c6","p_110");
				mapa.put("c7","p_111");
				mapa.put("c8","p_112");
				mapa.put("c9","p_113");
				mapa.put("c10","p_114");
				mapa.put("c11","p_115");
				mapa.put("c12","p_116");
				mapa.put("c13","p_117");
				mapa.put("c14","p_118");
				mapa.put("c15","p_119");
				mapa.put("c16","p_120");
				mapa.put("c17","p_121");
				break;
			case 8:
				inicioPersona = 122;
				mapa.put("c1","p_122");
				mapa.put("c2","p_123");
				mapa.put("c3","p_124");
				mapa.put("c4","p_125");
				mapa.put("c5","p_126");
				mapa.put("c6","p_127");
				mapa.put("c7","p_128");
				mapa.put("c8","p_129");
				mapa.put("c9","p_130");
				mapa.put("c10","p_131");
				mapa.put("c11","p_132");
				mapa.put("c12","p_133");
				mapa.put("c13","p_134");
				mapa.put("c14","p_135");
				mapa.put("c15","p_136");
				mapa.put("c16","p_137");
				mapa.put("c17","p_138");
				break;
			case 9:
				inicioPersona = 139;
				mapa.put("c1","p_139");
				mapa.put("c2","p_140");
				mapa.put("c3","p_141");
				mapa.put("c4","p_142");
				mapa.put("c5","p_143");
				mapa.put("c6","p_144");
				mapa.put("c7","p_145");
				mapa.put("c8","p_146");
				mapa.put("c9","p_147");
				mapa.put("c10","p_148");
				mapa.put("c11","p_149");
				mapa.put("c12","p_150");
				mapa.put("c13","p_151");
				mapa.put("c14","p_152");
				mapa.put("c15","p_153");
				mapa.put("c16","p_154");
				mapa.put("c17","p_155");

				break;
			case 10:
				inicioPersona = 156;
				mapa.put("c1","p_156");
				mapa.put("c2","p_157");
				mapa.put("c3","p_158");
				mapa.put("c4","p_159");
				mapa.put("c5","p_160");
				mapa.put("c6","p_161");
				mapa.put("c7","p_162");
				mapa.put("c8","p_163");
				mapa.put("c9","p_164");
				mapa.put("c10","p_165");
				mapa.put("c11","p_166");
				mapa.put("c12","p_167");
				mapa.put("c13","p_168");
				mapa.put("c14","p_169");
				mapa.put("c15","p_170");
				mapa.put("c16","p_171");
				mapa.put("c17","p_172");

				break;
		}
		mapa.put("idEncuesta", idEncuesta);
		logger.debug("Persona: {}", persona);
		sqlSession.update("encuestas.syncdm.resultadoEncuestas.eliminar",mapa);
	}
}
