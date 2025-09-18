import model.Utilisateur;

public class Main {
    public static void main(String[] args) {
        Utilisateur utilisateur1 = new Utilisateur(
                1,
                "BANDILELLA",
                "CLEMENT",
                1,
                "Ligue Volley Ball Lorraine",
                "30, rue Widric 1er 54600 Villers lès Nancy",
                "cbandilella@llgvolleyball.fr",
                0.0
        );

        System.out.println(utilisateur1);
    }
}