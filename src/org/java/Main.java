package org.java;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
//    	Richiesta dati all'utente
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci un nuovo evento.");
		try {

			System.out.print("Nome evento --> ");
			String title = in.nextLine();

			System.out.print("Data evento (yyyy-MM-dd) --> ");
			String date = in.nextLine();

			System.out.print("Posti disponibili --> ");
			String strSeats = in.nextLine();
			int totSeats = Integer.valueOf(strSeats);

			Evento e1 = new Evento(title, date, totSeats);

			System.out.print("Vuoi prenotare dei posti? (y/n) --> ");
			String value = in.nextLine();
			if (value.equals("y")) {
				System.out.print("Quanti posti vuoi prenotare? (max = " + e1.getTotSeats() + ") --> ");

				while (true) {
					String strReserSeats = in.nextLine();
					int nSeats = Integer.valueOf(strReserSeats);

					try {
						if (nSeats > e1.getTotSeats()) {
							System.out.println("Hai richiesto troppi posti, non ce ne sono più così tanti disponibili");
							System.out.print("Inserisci di nuovo il numero di posti --> ");
						} else {
							e1.reserveSeat(nSeats);
							break;
						}
					} catch (NumberFormatException e) {
						System.out.println("Inserisci un numero valido di posti");
						System.out.print("Inserisci di nuovo il numero di posti --> ");
					}
				}

				System.out.println("------------------------------");
				System.out.println("Posti prenotati --> " + e1.getReservedSeats() + "\n" + "Posti disponibili --> "
						+ (e1.getTotSeats() - e1.getReservedSeats()));
				System.out.println("------------------------------");

				if (e1.getReservedSeats() > 0) {
					System.out.println("");
					System.out.print("Vuoi disdire dei posti? (y/n) --> ");
					String value2 = in.nextLine();
					if (value2.equals("y")) {
						System.out.print("Quanti posti vuoi disdire? (max = " + e1.getReservedSeats() + ") --> ");

						while (true) {
							String strCancSeats = in.nextLine();
							int nSeats = Integer.valueOf(strCancSeats);

							try {
								if (nSeats > e1.getReservedSeats()) {
									System.out.println("Vuoi cancellare troppi posti");
									System.out.print("Inserisci di nuovo il numero di posti --> ");
								} else {
									e1.cancelSeat(nSeats);
									break;
								}
							} catch (NumberFormatException e) {
								System.out.println("Inserisci un numero valido di posti");
								System.out.print("Inserisci di nuovo il numero di posti --> ");
							}
						}
					}
					System.out.println("------------------------------");
					System.out.println("Posti prenotati --> " + e1.getReservedSeats() + "\n" + "Posti disponibili --> "
							+ (e1.getTotSeats() - e1.getReservedSeats()));
					System.out.println("------------------------------");
				}

			} else {
				System.out.println("------------------------------");
				System.out.println("Posti prenotati --> " + e1.getReservedSeats() + "\n" + "Posti disponibili --> "
						+ (e1.getTotSeats() - e1.getReservedSeats()));
				System.out.println("------------------------------");
			}

		} catch (ParseException | IllegalArgumentException e) {
			System.out.println("Errore durante la creazione dell'evento --> " + e.getMessage());
		}
		
		
		
//		Concerto e1 = new Concerto("poland", "2024-12-20", 500, LocalTime.parse("19:30:00"), new BigDecimal("20.00"));
//		System.out.println(e1);
	}
}