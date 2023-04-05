package présentation;

import dao.IDao;
import dao.daoVolatile.CréditDao;
import lombok.var;
import modèle.Crédit;
import métier.CréditMétier;
import métier.IMétierCrédit;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;


public class SimulateurDeCredit_App {
    static ICréditControleur créditControleur;
    static Scanner clavier = new Scanner(System.in);
    private static boolean estUnNombre(String input){
        try
        {
            Integer.parseInt(input);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    ////*****Instanciation des différents composants de l'application ******////
    public static void test1(){
        var dao = new CréditDao();
        var métier = new CréditMétier();
        var controleur = new CréditControleur();
        ///******** Injections des dépendances*********///
        métier.setCreditDao(dao);
        controleur.setCreditMetier(métier);
        ///*****Tester******///
        String rep ="";
        do {
            System.out.println("=>[Test 1 ] Calcule de Mensualité de crédit <=\n");
            try {
                String input = "";
                while (true){
                    System.out.println("=> Veuillez entrer l'id du crédit:!!!!");
                    input = clavier.nextLine();
                    if(estUnNombre(input)) break;
                    System.err.println("Entréé non valide!!!!");
                }
                long id =Long.parseLong(input);
                controleur.afficher_Mensualité(id);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Voulez vous quittez (OUI/NON)? ");
            rep =clavier.nextLine();
        } while (!rep.equalsIgnoreCase("OUI"));
          System.out.println(" Au revoir ^_^ ");
          }
    public static void main(String[] args ) throws Exception {
        test1();

    }


 public static void test2() throws Exception {

        String daoClass;
        String serviceClass;
        String controllerClass;
        Properties properties = new Properties();
        ClassLoader classLoader =Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream("présentation/config.properties");
        if (propertiesFile==null) throw new Exception("fichier config introuvable !!!");
        else {
            try {
                properties.load(propertiesFile);
                daoClass = properties.getProperty("DAO");
                serviceClass= properties.getProperty("SERVICE");
                controllerClass= properties.getProperty("CONTROLLLER");
                propertiesFile.close();
            }
            catch (IOException e){
                throw new Exception("Problème de chargement des propriétés du fichier config");
            }
            finally {
                properties.clear();
            }
        }
        try {
            Class cDao = Class.forName(daoClass);
            Class cMetier = Class.forName(serviceClass);
           Class cControleur =Class.forName(controllerClass);


           var dao =(IDao< Crédit, Long>)cDao.getDeclaredConstructor().newInstance();
           var metier = (IMétierCrédit) cMetier.getDeclaredConstructor().newInstance();
           créditControleur = (ICréditControleur)  cControleur.getDeclaredConstructor().newInstance();

            Method setDao = cMetier.getMethod("setCréditDao",IDao.class);
            setDao.invoke(créditControleur, metier);
            créditControleur.afficher_Mensualité(1L);
                }
        catch (Exception e){
            e.printStackTrace();
            }
        }



 }


