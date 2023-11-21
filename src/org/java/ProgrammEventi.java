package org.java;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<Evento> searchEvent(String data) {
		return eventi.stream().filter(evento -> evento.getDate().equals(data)).collect(Collectors.toList());
	}
	
	public void printSearchedEvents(String data) {
	    List<Evento> events = searchEvent(data);

	    if (events.isEmpty()) {
	        System.out.println("Nessun evento trovato per la data " + data);
	    } else {
	        System.out.println("Eventi trovati per la data " + data + ":");
	        for (Evento evento : events) {
	        	System.out.println("------------------------------");
	            System.out.println("Data: " + evento.getDate() + "\n"
	            		+ "Titolo: " + evento.getTitle());
	        }
	    }
	}	
	
	
	@Override
	 public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(titolo).append("\n");

        Collections.sort(eventi, (evento1, evento2) -> evento1.getDate().compareTo(evento2.getDate()));

        for (Evento evento : eventi) {
            try {
				result.append(evento.getFormattedDate()).append(" - ").append(evento.getTitle()).append("\n");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return result.toString();
    }
}
