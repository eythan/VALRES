package model;

public class Utilisateur_Niveau4 extends Utilisateur {
    public Utilisateur_Niveau4(int id, String nom, String prenom, int structureId, String structureNom, String structureAdresse, String mail) {
        super(id, nom, prenom, structureId, structureNom, structureAdresse, mail, 3.0);
    }
}
