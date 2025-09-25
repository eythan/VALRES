package model;

public class Reservation {
    private int id;
    private Utilisateur utilisateur;
    private Salle salle;
    private String date;
    private int periode;
    private double montant;

    public Reservation(int id, Utilisateur utilisateur, Salle salle, String date, int periode) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.salle = salle;
        this.date = date;
        this.periode = periode;
        this.montant = calculerMontant();
    }

    public int getId() {
        return id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Salle getSalle() {
        return salle;
    }

    public double getMontant() {
        return montant;
    }

    public int getPeriode() {
        return periode;
    }

    public String getDate() {
        return date;
    }

    public double calculerMontant() {
        return salle.getTarifBase() * utilisateur.getCategorieTarif();
    }


}
