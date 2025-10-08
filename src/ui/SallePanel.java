package ui;

import model.Salle;
import repository.SalleRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SallePanel extends JPanel {
    private JTable table;

    public SallePanel() {
        setLayout(new BorderLayout());

        String[] columns = {"ID", "Nom", "Catégorie"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        refreshTable();
    }

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try {
            List<Salle> salles = SalleRepository.loadSalles();
            for (Salle s : salles) {
                model.addRow(new Object[]{
                        s.getId(),
                        s.getNom(),
                        s.getCategorie()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erreur lors du chargement des salles : " + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveData() {
        try {
            List<Salle> salles = SalleRepository.loadSalles();
            SalleRepository.saveSalles(salles);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
