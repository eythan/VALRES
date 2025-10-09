// src/util/PDFGenerator.java
package util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import model.Bordereau;

import java.io.FileOutputStream;

public class PDFGenerator {
    public static void genererPDF(Bordereau bordereau, String cheminFichier) {
        Document document = new Document();
        try {
            // Initialisation du document
            PdfWriter.getInstance(document, new FileOutputStream(cheminFichier));
            document.open();

            // Ajouté les informations du bordereau au PDF
            document.add(new Paragraph("Bordereau récapitulatif - Semaine " + bordereau.getSemaine()));
            document.add(new Paragraph("Montant total des réservations : " + String.format("%.2f", bordereau.getMontantTotal()) + " €"));
            document.add(new Paragraph("\nRéservations :\n"));
            document.add(new Paragraph(bordereau.getReservationsDetails()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close(); // Fermeture du document
        }
    }
}
