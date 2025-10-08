package ui;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(JTabbedPane tabbedPane) {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnCharger = new JButton("Charger les données");
        JButton btnSauvegarder = new JButton("Sauvegarder");
        JButton btnPDF = new JButton("Générer PDF");

        add(btnCharger);
        add(btnSauvegarder);
        add(btnPDF);

        // Recharge les tableaux
        btnCharger.addActionListener(e -> {
            ((ReservationPanel) tabbedPane.getComponentAt(0)).refreshTable();
            ((SallePanel) tabbedPane.getComponentAt(1)).refreshTable();
            ((UtilisateurPanel) tabbedPane.getComponentAt(2)).refreshTable();
        });

        // Sauvegarde les données
        btnSauvegarder.addActionListener(e -> {
            ((ReservationPanel) tabbedPane.getComponentAt(0)).saveData();
            ((SallePanel) tabbedPane.getComponentAt(1)).saveData();
            ((UtilisateurPanel) tabbedPane.getComponentAt(2)).saveData();
            JOptionPane.showMessageDialog(this, "✅ Données sauvegardées !");
        });

        // Bouton PDF (placeholder)
        btnPDF.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "📄 PDF généré !");
        });
    }
}
