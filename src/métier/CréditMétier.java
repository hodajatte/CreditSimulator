package métier;
import dao.daoVolatile.CréditDao;
import lombok.*;
 import modèle.Crédit;
 @Data
 @AllArgsConstructor
 @NoArgsConstructor

public class CréditMétier {
    CréditDao creditDao;
    public Crédit calculer_Mensualité(Long idCrédit) throws Exception{
        var crédit = creditDao.trouverParId(idCrédit);
        if (crédit == null)
            throw new Exception("L'id du crédit est incorrecte::[Crédit non trouvé]");
        else {
            double taux  = crédit.getTaux_mensuel();
            taux =taux/1200;
            double capitale = crédit.getCapitale_Emprunte();
            int nbr_Mois = crédit.getNbre_mois();
            double mensualité = (capitale*taux)/(1- (Math.pow((1+taux), -1 *nbr_Mois)));
            mensualité = Math.round(mensualité*100)/100;
            crédit.setMensualité(mensualité);
            return crédit;


        }
    }



}
