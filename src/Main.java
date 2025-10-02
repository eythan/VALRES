import model.Utilisateur;
import model.Salle;
import model.Reservation;
import repository.UtilisateurRepository;
import repository.SalleRepository;
import repository.ReservationRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Utilisateur> utilisateurs = UtilisateurRepository.getTousLesUtilisateurs();
            for (Utilisateur u : utilisateurs) {
                System.out.println(u);
            }

            List<Salle> salles = SalleRepository.getToutesLesSalles();
            for (Salle s : salles) {
                System.out.println(s);
            }

            List<Reservation> Reservations = ReservationRepository.getToutesLesReservations();
            for (Reservation r : Reservations) {
                System.out.println(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}