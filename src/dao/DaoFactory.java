package dao;

import dao.daoMysql.MysqlSessionFactory;
import modèle.Client;
import modèle.Crédit;
import modèle.Utilisateur;

public  abstract class DaoFactory {
    public static final
    int MYSQL_DATA_UNIT = 1,
            FILE_DATA_UNIT = 2,
            InMEMORY_DATA_UNIT = 3;

    public abstract IDao<Utilisateur, Long> getUtilisateurDao();

    public abstract IDao<Client, Long> getClientDao();

    public abstract IDao<Crédit, Long> getCréditDao();

    public static final DaoFactory getDaoFactory(int factoryType) {
        switch (factoryType) {
            case 1:
                return MysqlSessionFactory.getInstance();
                 default : return null;
        }

    }
}

