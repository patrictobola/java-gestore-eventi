package org.java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evento {

	private String title;
	private String date;
	private int totSeats;
	private int reservedSeats;
	

	public Evento(String title, String date, int totSeats) throws ParseException {
		setTitle(title);
		setDate(date);
		this.totSeats = totSeats;
		this.reservedSeats = 0;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		
		
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = sdf.parse(date);
		
		if(newDate.before(new Date())) {
			throw new IllegalArgumentException("La data inserita non può essere precedente a quella odierna.");
		}
		
		this.date = date;
	}

	public int getTotSeats() {
		return totSeats;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}
	
	@Override
	public String toString() {
		return "Questo evento si intitola: " + getTitle() + "\n"
				+ "Si terrà in data: " + getDate() + "\n"
				+ "Numero posti totali: " + getTotSeats() + "\n"
				+ "Numero posti prenotati: " + getReservedSeats();
	}
}
