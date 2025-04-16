package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {
        try {
            //Injection de dependance par instanciation dynamique cad via reflection
            //on va lire le nom de la classe dao et metier depuis un fichier config.txt
            //le fichier doit contenir le nom de la classe dao et metier
            //Avec constructeur
            Scanner sc = new Scanner(new File("config.txt"));
            String daoClassName = sc.nextLine();
            Class<?> cDao = Class.forName(daoClassName);
            Constructor<?> daoConstructor = cDao.getDeclaredConstructor();
            IDao dao = (IDao) daoConstructor.newInstance();

            String metierClassName = sc.nextLine();
            Class<?> cMetierClass = Class.forName(metierClassName);
            Constructor<?> metierConstructor = cMetierClass.getDeclaredConstructor(IDao.class);
            IMetier metier = (IMetier) metierConstructor.newInstance(dao);

            // avec setter
            Method setDao = cMetierClass.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier, dao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

