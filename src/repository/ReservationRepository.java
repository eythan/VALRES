package repository;

import model.Reservation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {

    public static List<Reservation> getToutesLesReservations() throws Exception {
        List<Reservation> reservations = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/ressource/reservation.xml"));

        NodeList nodeList = document.getElementsByTagName("reservation");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                int id = Integer.parseInt(elem.getAttribute("id"));
                int utilisateurId = Integer.parseInt(elem.getElementsByTagName("utilisateur_id").item(0).getTextContent());
                String nom = elem.getElementsByTagName("nom").item(0).getTextContent();
                String prenom = elem.getElementsByTagName("prenom").item(0).getTextContent();
                int structureId = Integer.parseInt(elem.getElementsByTagName("structure_id").item(0).getTextContent());
                String structureNom = elem.getElementsByTagName("structure_nom").item(0).getTextContent();
                String structureAdresse = elem.getElementsByTagName("structure_adresse").item(0).getTextContent();
                String mail = elem.getElementsByTagName("mail").item(0).getTextContent();
                int salleId = Integer.parseInt(elem.getElementsByTagName("salle_id").item(0).getTextContent());
                LocalDateTime date = LocalDateTime.parse(elem.getElementsByTagName("date").item(0).getTextContent(), formatter);
                int periode = Integer.parseInt(elem.getElementsByTagName("periode").item(0).getTextContent());

                reservations.add(new Reservation(id, utilisateurId, nom, prenom, structureId, structureNom, structureAdresse, mail, salleId, date, periode));
            }
        }

        return reservations;
    }
    public static void saveReservations(List<Reservation> reservations) throws IOException, IOException {
        SerializationManager.saveList(reservations, "data/reservations.ser");
    }

    public static List<Reservation> loadReservations() throws IOException, ClassNotFoundException {
        return SerializationManager.loadList("data/reservations.ser");
    }

}
