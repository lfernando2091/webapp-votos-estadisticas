package com.saganet.politik.database.estructuras;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.saganet.politik.modelos.JavaBeanT;

@Alias("GenericoEO")
public class GenericoEO extends JavaBeanT implements Serializable {
	private Integer id;
}
