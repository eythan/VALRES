package ui;

import model.Utilisateur;
import repository.UtilisateurRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UtilisateurPanel extends JPanel {
    private JTable table;

    public UtilisateurPanel() {
        setLayout(new BorderLayout());

        String[] columns = {"ID", "Nom", "Prénom", "Structure", "Adresse", "Mail"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        refreshTable();
    }

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try {
            List<Utilisateur> utilisateurs = UtilisateurRepository.loadUtilisateurs();
            for (Utilisateur u : utilisateurs) {
                model.addRow(new Object[]{
                        u.getId(),
                        u.getNom(),
                        u.getPrenom(),
                        u.getStructureNom(),
                        u.getStructureAdresse(),
                        u.getMail()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erreur lors du chargement des utilisateurs : " + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveData() {
        try {
            List<Utilisateur> utilisateurs = UtilisateurRepository.loadUtilisateurs();
            UtilisateurRepository.saveUtilisateurs(utilisateurs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
