package presentation;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        //Injection de dependance par instanciation statique cad via new et setter ou constructeur
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao); // ajout de parametre dao car linjection ici est avec constructeur
        //metier.setDao(dao); //injection avec setter
        System.out.println("Res="+metier.calcul());
    }
}
