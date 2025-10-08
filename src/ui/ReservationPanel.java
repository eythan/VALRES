package ui;

import model.Reservation;
import model.Salle;
import repository.ReservationRepository;
import repository.SalleRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ReservationPanel extends JPanel {
    private JTable table;

    public ReservationPanel() {
        setLayout(new BorderLayout());

        String[] columns = {"ID", "Nom", "Prénom", "Salle ID", "Date", "Période", "Montant"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        refreshTable();
    }

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try {
            List<Reservation> reservations = ReservationRepository.loadReservations();
            List<Salle> salles = SalleRepository.loadSalles();

            for (Reservation r : reservations) {
                Salle salle = salles.stream()
                        .filter(s -> s.getId() == r.getSalleId())
                        .findFirst()
                        .orElse(null);

                double montant = salle != null ? r.calculerMontant(salle) : 0;

                model.addRow(new Object[]{
                        r.getId(),
                        r.getNom(),
                        r.getPrenom(),
                        r.getSalleId(),
                        r.getDate(),
                        r.getPeriode(),
                        montant
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erreur lors du chargement des réservations : " + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveData() {
        try {
            List<Reservation> reservations = ReservationRepository.loadReservations();
            ReservationRepository.saveReservations(reservations);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
