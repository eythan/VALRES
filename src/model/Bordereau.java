// src/model/Bordereau.java
package model;

import java.io.Serializable;
import java.util.List;

public class Bordereau implements Serializable {
    private List<Reservation> reservations;
    private List<Salle> salles;
    private int semaine;
    private double montantTotal;

    public Bordereau(List<Reservation> reservations, List<Salle> salles, int semaine) {
        this.reservations = reservations;
        this.salles = salles;
        this.semaine = semaine;
        this.montantTotal = calculerMontantTotal();
    }

    // Trouve une salle par l'ID
    private Salle getSalleById(int salleId) {
        for (Salle s : salles) {
            if (s.getId() == salleId) return s;
        }
        return null;
    }

    // Calcule le montant total des réservations
    private double calculerMontantTotal() {
        double total = 0.0;
        for (Reservation r : reservations) {
            Salle salle = getSalleById(r.getSalleId());
            if (salle != null) {
                total += r.calculerMontant(salle);
            }
        }
        return total;
    }

    public int getSemaine() {
        return semaine;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    // Pour PDFGenerator : retourne les info
    public String getReservationsDetails() {
        String detail = "";
        for (Reservation r : reservations) {
            Salle salle = getSalleById(r.getSalleId());
            detail += "ID : " + r.getId() + " | Utilisateur : " + r.getNom() + " " + r.getPrenom()
                    + " | Structure : " + r.getStructureNom()
                    + " | Salle : " + (salle != null ? salle.getNom() : "Inconnue")
                    + " | Date : " + r.getDate()
                    + " | Période : " + r.getPeriode()
                    + " | Montant : " + String.format("%.2f", r.getMontant()) + " €\n";
        }
        return detail;
    }
}