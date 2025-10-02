package model;

public class Salle {
    private int id;
    private String nom;
    private int categorie;
    private double tarifBase;

    public Salle(int id, String nom, int categorie, double tarifBase) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.tarifBase = tarifBase;
    }

    public double getTarifBase() {
        return tarifBase;
    }

    public double calculerTarifFinal() {
        switch (categorie) {
            case 1: return tarifBase; // Tarif de base pour les salles
            case 2: return tarifBase * 1.5; // Majoré de 50% pour les salles multimédia / Informatique
            case 3: return tarifBase * 2.0; // Majoré de 100% pour l'amphithéâtre / Hall d'accueil
            default: return tarifBase;
        }
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", categorie=" + categorie +
                ", tarifBase=" + tarifBase +
                ", tarifFinal=" + calculerTarifFinal() +
                '}';
    }
}
