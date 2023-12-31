package org.java;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
//    	Richiesta dati all'utente
		Scanner in = new Scanner(System.in);
		ProgrammEventi programma = new ProgrammEventi("Eventi fantastici");

		while (true) {
			System.out.println("Inserisci un nuovo evento o premi 0 per uscire.");

			try {

				System.out.print("Nome evento --> ");
				String title = in.nextLine();
				if (title.equals("0")) {
					break;
				}

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
								System.out.println(
										"Hai richiesto troppi posti, non ce ne sono più così tanti disponibili");
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
						System.out.println("Posti prenotati --> " + e1.getReservedSeats() + "\n"
								+ "Posti disponibili --> " + (e1.getTotSeats() - e1.getReservedSeats()));
						System.out.println("------------------------------");
						programma.addEvent(e1);
					}

				} else {
					System.out.println("------------------------------");
					System.out.println("Posti prenotati --> " + e1.getReservedSeats() + "\n" + "Posti disponibili --> "
							+ (e1.getTotSeats() - e1.getReservedSeats()));
					System.out.println("------------------------------");
					programma.addEvent(e1);
				}

			} catch (ParseException | IllegalArgumentException e) {
				System.out.println("Errore durante la creazione dell'evento --> " + e.getMessage());
			}
		}

//		Eventi Hardcodati per evitare sbatti ogni volta
		Evento e1 = new Evento("evento 1 prova", "2024-08-02", 500);
		Evento e2 = new Evento("evento 2 prova", "2025-10-10", 500);
		Evento e3 = new Evento("evento 3 prova", "2024-08-02", 500);
		programma.addEvent(e3);
		programma.addEvent(e2);
		programma.addEvent(e1);

//		Output milestone 4 --> con metodo search
		System.out.println("\n" + "Output da metodo search by date");
		System.out.println("------------------------------");
		programma.printSearchedEvents("2024-08-02");
		
		
//		Output milestone 4 --> toString
		System.out.println("\n" + "------------------------------");
		System.out.println("Output da metodo toString");
		System.out.println("------------------------------");
		System.out.println(programma);
		System.out.println("------------------------------");

//		Concerto e1 = new Concerto("poland", "2024-12-20", 500, LocalTime.parse("19:30:00"), new BigDecimal("20.00"));
//		System.out.println(e1);
	}
}