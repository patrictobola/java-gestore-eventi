package org.java;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        try {
            Evento e1 = new Evento("festa", "2023-11-20", 500);
            e1.reserveSeat();
            System.out.println(e1);
        } catch (ParseException | IllegalArgumentException e) {
            System.out.println("Errore durante la creazione dell'evento --> " + e.getMessage());
        }
    }
}