import model.Reservation;
import model.Salle;
import model.Utilisateur;
import repository.ReservationRepository;
import repository.SalleRepository;
import repository.UtilisateurRepository;
import ui.*;

import javax.swing.*;
import java.awt.*;
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

            // 🔹 3. Lancer l'interface graphique
            javax.swing.SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("VALRES");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(900, 600);

                JTabbedPane tabbedPane = new JTabbedPane();
                tabbedPane.addTab("Réservations", new ui.ReservationPanel());
                tabbedPane.addTab("Salles", new ui.SallePanel());
                tabbedPane.addTab("Utilisateurs", new ui.UtilisateurPanel());

                frame.setLayout(new BorderLayout());
                frame.add(new ui.MenuPanel(tabbedPane), BorderLayout.NORTH);
                frame.add(tabbedPane, BorderLayout.CENTER);

                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });

            System.out.println("✅ Sérialisation terminée avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
