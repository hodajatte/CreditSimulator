package dao.daoMysql;

import dao.DaoFactory;
import dao.IDao;
import modèle.Client;
import modèle.Crédit;
import modèle.Utilisateur;

public class MysqlSessionFactory extends DaoFactory {
    public static DaoFactory getInstance() {
        return null;
    }

    @Override
    public IDao<Utilisateur, Long> getUtilisateurDao() {
        return null;
    }

    @Override
    public IDao<Client, Long> getClientDao() {
        return null;
    }

    @Override
    public IDao<Crédit, Long> getCréditDao() {
        return null;
    }
}
