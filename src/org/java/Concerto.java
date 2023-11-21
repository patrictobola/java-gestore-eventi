package org.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalTime ora;
	private BigDecimal prezzo;

	public Concerto(String title, String date, int totSeats, LocalTime ora, BigDecimal prezzo) throws ParseException {
		super(title, date, totSeats);
		setOra(ora);
		setPrezzo(prezzo);

	}

	// GETTER AND SETTERS
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

//	CUSTOM 
	public String getFormattedDate() {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(super.getDate(), inputFormatter);

		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.of(date, getOra());

		return dateTime.format(outputFormatter);
	}

	public String getFormattedPrice() {
		NumberFormat currencyFormatter = new DecimalFormat("##,##0.00€");
		return currencyFormatter.format(prezzo); 
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Data e ora --> " + getFormattedDate() + "\n" 
				+ "Titolo evento --> " + super.getTitle() + "\n"
				+ "Prezzo evento --> " + getFormattedPrice();

	}
}
