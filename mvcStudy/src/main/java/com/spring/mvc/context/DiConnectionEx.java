package com.spring.mvc.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DiConnectionEx {
	
	@Autowired
	@Qualifier("diex2")
	private DiContext diex;
	
	public DiConnectionEx() {
	}

	public DiConnectionEx(DiContext diex) {
		super();
		this.diex = diex;
	}
	
	public DiContext getDiex() {
		return diex;
	}
	
	public void setDiex(DiContext diex) {
		this.diex = diex;
	}

	@Override
	public String toString() {
		return diex.diConnection();
	}
	
}
