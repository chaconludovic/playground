package com.eldoraludo.test.listeChaineeEssai2;


import org.junit.Test;

public class TableauTest {


    @Test
    public void afficher_le_tableau() {
        Tableau tableau = new Tableau.Builder("tab_dep_fonc").
                ajouterLigne(new Ligne("titre_depense_de_fonctionnement")).
                ajouterLigne(new Ligne("VAR_TOTDEXP", "VAR_CHAEXPL")).
                ajouterLigne(new Ligne("VAR_CHAEXPL", "VAR_CHARPER")).
                ajouterLigne(new Ligne("VAR_CHARPER", "titre_depense_de_fonctionnement")).
                ajouterLigne(new Ligne("VAR_TOT", "VAR_TOTDEXP")).build();
        for (Ligne ligne : tableau.getLignes().getLignes()) {
            System.out.println(ligne);
        }
 for (Ligne ligne : tableau.getLignes().getLignes()) {
            System.out.println(ligne);
        }
    }
}
