package model;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private int structureId;
    private String structureNom;
    private String structureAdresse;
    private String mail;
    private double categorieTarif;

    public Utilisateur(int id, String nom, String prenom, int structureId, String structureNom, String structureAdresse, String mail, double categorieTarif) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.structureId = structureId;
        this.structureNom = structureNom;
        this.structureAdresse = structureAdresse;
        this.mail = mail;
        this.categorieTarif = categorieTarif;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getStructureId() {
        return structureId;
    }

    public String getStructureNom() {
        return structureNom;
    }

    public String getStructureAdresse() {
        return structureAdresse;
    }

    public String getMail() {
        return mail;
    }

    public double getCategorieTarif() {
        return categorieTarif;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", structureId=" + structureId +
                ", structureNom='" + structureNom + '\'' +
                ", structureAdresse='" + structureAdresse + '\'' +
                ", mail='" + mail + '\'' +
                ", categorieTarif=" + categorieTarif +
                '}';
    }
}
