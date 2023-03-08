package présentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import métier.CréditMétier;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CréditControleur implements ICréditControleur {
    CréditMétier creditMetier;
    public void afficher_Mensualité(Long idCrédit) throws Exception{

        var creditAvecMensualité = creditMetier.calculer_Mensualité(idCrédit);
        System.out.println(creditAvecMensualité);
    }
}
