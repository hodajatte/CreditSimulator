package présentation;

import métier.IMétierCrédit;

public interface ICréditControleur {
    IMétierCrédit creditMetier = null;

    void afficher_Mensualité(Long idCrédit) throws Exception;


}
