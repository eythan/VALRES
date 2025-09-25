package repository;

import model.Salle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SalleRepository {

    public static List<Salle> getToutesLesSalles() throws Exception {
        List<Salle> LesSalles = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("\\\\sio-fic\\LeNAS\\Perso\\francee\\Documents\\VALRES\\src\\ressource\\salle.xml"));

        NodeList nodeList = document.getElementsByTagName("table");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                int id = Integer.parseInt(elem.getElementsByTagName("column").item(0).getTextContent());
                String nom = elem.getElementsByTagName("column").item(1).getTextContent();
                int categorie = Integer.parseInt(elem.getElementsByTagName("column").item(2).getTextContent());

                double tarifBase = 10.0;
                LesSalles.add(new Salle(id, nom, categorie, tarifBase));
            }
        }
        return LesSalles;
    }
}
