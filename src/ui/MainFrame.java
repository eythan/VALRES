package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Gestion M2L");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Onglets
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Réservations", new ReservationPanel());
        tabbedPane.addTab("Salles", new SallePanel());
        tabbedPane.addTab("Utilisateurs", new UtilisateurPanel());

        add(tabbedPane, BorderLayout.CENTER);
        add(new MenuPanel(tabbedPane), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
