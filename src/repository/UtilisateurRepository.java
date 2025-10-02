package repository;

import model.Utilisateur;
import model.Utilisateur_Niveau1;
import model.Utilisateur_Niveau2;
import model.Utilisateur_Niveau3;
import model.Utilisateur_Niveau4;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurRepository {

    public static List<Utilisateur> getTousLesUtilisateurs() throws Exception {

        List<Utilisateur> lesUtilisateurs = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("\\\\sio-fic\\LeNAS\\Perso\\francee\\Documents\\VALRES\\src\\ressource\\utilisateur.xml"));

        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                int id = Integer.parseInt(elem.getAttribute("id"));
                String nom = elem.getElementsByTagName("nom").item(0).getChildNodes().item(0).getNodeValue();
                String prenom = elem.getElementsByTagName("prenom").item(0).getChildNodes().item(0).getNodeValue();
                int structureId = Integer.parseInt(elem.getElementsByTagName("structure_id").item(0).getChildNodes().item(0).getNodeValue());
                String structureNom = elem.getElementsByTagName("structure_nom").item(0).getChildNodes().item(0).getNodeValue();
                String structureAdresse = elem.getElementsByTagName("structure_adresse").item(0).getChildNodes().item(0).getNodeValue();
                String mail = elem.getElementsByTagName("mail").item(0).getChildNodes().item(0).getNodeValue();

                if (structureId == 1 || structureId == 2) {
                    // Ligues / Comités départementaux
                    lesUtilisateurs.add(new Utilisateur_Niveau1(id, nom, prenom, structureId, structureNom, structureAdresse, mail));
                } else if (structureId == 3 || structureId == 4) {
                    // Clubs sportifs
                    lesUtilisateurs.add(new Utilisateur_Niveau2(id, nom, prenom, structureId, structureNom, structureAdresse, mail));
                } else if (structureId == 5 || structureId == 6) {
                    // Associations/ Lycées
                    lesUtilisateurs.add(new Utilisateur_Niveau3(id, nom, prenom, structureId, structureNom, structureAdresse, mail));
                } else {
                    // Sociétés privées / Autres organismes
                    lesUtilisateurs.add(new Utilisateur_Niveau4(id, nom, prenom, structureId, structureNom, structureAdresse, mail));
                }
            }
        }
        return lesUtilisateurs;
    }
}
