package com.saganet.politik.utilidades.diagram;

import java.util.ArrayList;
import java.util.UUID;

import org.primefaces.model.diagram.Element;

@SuppressWarnings("serial")
class ElementList extends ArrayList<Element> {

	@Override
	    public boolean add(Element e) {
	        if(e.getId() == null) {
	            e.setId(UUID.randomUUID().toString());
	        }
	        
	        return super.add(e);
	    }
}
