import model.Utilisateur;
import repository.UtilisateurRepository;
import repository.SalleRepository;
import model.Salle;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}