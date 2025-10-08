import model.Reservation;
import model.Salle;
import model.Utilisateur;
import repository.ReservationRepository;
import repository.SalleRepository;
import repository.UtilisateurRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // 🔹 1. Charger depuis les fichiers XML
            List<Reservation> reservations = ReservationRepository.getToutesLesReservations();
            List<Salle> salles = SalleRepository.getToutesLesSalles();
            List<Utilisateur> utilisateurs = UtilisateurRepository.getTousLesUtilisateurs();

            // 🔹 2. Sérialiser ces listes vers le dossier data/
            ReservationRepository.saveReservations(reservations);
            SalleRepository.saveSalles(salles);
            UtilisateurRepository.saveUtilisateurs(utilisateurs);

            System.out.println("✅ Sérialisation terminée avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
