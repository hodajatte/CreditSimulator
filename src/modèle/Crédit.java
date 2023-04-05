package modèle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Crédit {
    private long id;
    private Double capitale_Emprunte;
    private Integer nbre_mois;
    private Double taux_mensuel;
    private Client demandeur;
    private Double mensualité;



    public long getId() {

        return id;
    }

    @Override
    public  String toString()
    {
        var créditStr = "voilà votre crédit !!!!!!!!!!!  \n";
        créditStr += " => Crédit num "+ getId()+"             \n";
        créditStr += " => Nom du demandeur de crédit "+ getDemandeur()+"             \n";
        créditStr +="--------------------------------------------\n";
        créditStr += " => Capitale emprunté"+ getCapitale_Emprunte()+"    DH    \n";
        créditStr += " => Nombre de mois " + getNbre_mois() + "Mois \n";
        créditStr += " => Taux mensuel " + getTaux_mensuel() + "%\n";
        créditStr += "******************************************\n";
        créditStr+= "=> Mensualité est : " + (getMensualité()==0.0 ? "NON-CALCULE": getMensualité() + "DH/Mois" )+" \n";
        créditStr+= " &&&&&&&&&&&& HODA JATTE &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&!!!! \n";
                return créditStr;

    }



}
