package org.java;

import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		setTitolo(titolo);
		this.eventi = new ArrayList<>();
	}
//	GETTERS AND SETTERS 
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}
	
//	CUSTOM
	
	public void addEvent(Evento e) {
		eventi.add(e);
	}
	
	public int countEvents() {
		return eventi.size();
	}
	
	public void clearEvents() {
		eventi.clear();
	}
}
