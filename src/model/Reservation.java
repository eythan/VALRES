package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Salle;

public class Reservation {
    private int id;
    private int utilisateurId;
    private String nom;
    private String prenom;
    private int structureId;
    private String structureNom;
    private String structureAdresse;
    private String mail;
    private int salleId;
    private LocalDateTime date;
    private int periode;
    private double montant;

    public Reservation(int id, int utilisateurId, String nom, String prenom, int structureId, String structureNom,
                       String structureAdresse, String mail, int salleId, LocalDateTime date, int periode) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.nom = nom;
        this.prenom = prenom;
        this.structureId = structureId;
        this.structureNom = structureNom;
        this.structureAdresse = structureAdresse;
        this.mail = mail;
        this.salleId = salleId;
        this.date = date;
        this.periode = periode;
    }

    public double calculerMontant(Salle salle) {
        this.montant = salle.calculerTarifFinal() * periode;
        return this.montant;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Reservation{" +
                "id=" + id +
                ", utilisateurId=" + utilisateurId +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", structureId=" + structureId +
                ", structureNom='" + structureNom + '\'' +
                ", structureAdresse='" + structureAdresse + '\'' +
                ", mail='" + mail + '\'' +
                ", salleId=" + salleId +
                ", date=" + date.format(formatter) +
                ", periode=" + periode +
                '}';
    }
}
