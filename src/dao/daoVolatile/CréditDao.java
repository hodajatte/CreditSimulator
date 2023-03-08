package dao.daoVolatile;

import modèle.Crédit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CréditDao {
    public static Set<Crédit> BDCrédits() {
        return new HashSet<Crédit>(
                Arrays.asList(
                        new Crédit(1L, 300000.0, 120, 2.5, "Hoda", 0.0),
                        new Crédit(2L, 85000.0, 240, 2.5, "Jatte", 0.0),
                        new Crédit(3L, 0200000.0, 030, 1.5, "Nouran", 0.0),
                        new Crédit(4L, 065000.0, 060, 2.0, "Nissrine", 0.0)
                ));
    }
    public Crédit trouverParId (Long id)
    {
        System.out.println("[DAO -DS volatile] trouver le crédit num :" +id );
         return
                 BDCrédits()
                         .stream()
                         .filter(credi->credi.getId()== id)
                         .findFirst()
                         .orElse(null);

    }
}
