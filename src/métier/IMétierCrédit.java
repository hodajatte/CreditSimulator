package métier;

import modèle.Crédit;

public interface IMétierCrédit {
    Crédit calculer_Mensualité(Long idCrédit)
        throws Exception;
}
