package jdbc;

import lombok.var;
import modèle.Client;
import modèle.Crédit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class JDBC_Test {
    public static void main(String[] args)
    {
        Connection connection=null;
        var crédits =new ArrayList<Crédit>();
        try {
            ClassLoader cl=Thread.currentThread()
                    .getContextClassLoader();
            var config =cl.getResourceAsStream("applocation.properties");
            if (config==null)throw new IOException("fichier properties introuvable");
            Properties propertiesFile=new Properties();
            propertiesFile.load(config);
            var url =propertiesFile.getProperty("URL");
            var user =propertiesFile.getProperty("USERNAME");
            var pass =propertiesFile.getProperty("PASSWORD");
            connection =
                    DriverManager.getConnection(url,user,pass);
            System.out.println("Connection établit avec succès ");
            var statement =connection.createStatement();
            var rs=statement.executeQuery(
                    "SELECT cr.id,cr.capital,cr.nbrMois,cr.taux,cr.demandeur,cr.mensualité," +
                            "u.nom,u.prenom "+" FROM credit cr,client cl ," +
                            "utilisateur u" + "WHERE cr.demandeur =cl.id and  " + "cl.id=u.id and  " + "cr.capital='30000'");
            while(rs.next()){
                var id =rs.getLong("id");
                var capital= rs.getDouble("capital");
                var nbrMois =rs.getInt("nbrMois");
                var taux =rs.getDouble("taux");
                var nomdemandeur=rs.getString("nom");
                var prenomDemandeur= rs.getString("prenom ");
                var mensualité =rs.getDouble("mensualité");
                var client =new Client(); client.setNomComplet(nomdemandeur,prenomDemandeur);
                crédits.add(new Crédit(id,capital,nbrMois,taux,client,mensualité));

            }
            if (crédits.isEmpty()) throw new SQLException("Aucun crédit trouvé");
            else crédits.forEach(System.out::println);





        } catch (IOException | SQLException e) {
            e.printStackTrace();
            System.err.println("Connecion échoué!!");

        }
        finally {
            if (connection!=null){
                try {
                    connection.close();System.out.println("Fermeture de session avec succès ");

                }
                catch (SQLException e){
                    System.err.println("Fermeture de session échoué");
                }
            }
        }

    }
}
