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

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getTarifBase() {
        return tarifBase;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setTarifBase(double tarifBase) {
        this.tarifBase = tarifBase;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", categorie=" + categorie +
                ", tarifBase=" + tarifBase +
                '}';
    }
}
