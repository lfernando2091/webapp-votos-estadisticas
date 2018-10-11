package com.saganet.politik.modelos;


public class JavaBeanT {
	public Integer getId(){
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		JavaBeanT check;
		
		check = (JavaBeanT) obj;
		
		if(this.getClass().equals(obj.getClass()))
			if(this.getId().equals(check.getId()))
				return true;

		return false;
	}
}
