package com.eldoraludo.test.listeChaineeEssai1;

import com.eldoraludo.test.listeChaineeEssai1.Ligne;
import com.eldoraludo.test.listeChaineeEssai1.Tableau;
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
        for (Ligne ligne : tableau.getLignes()) {
            System.out.println(ligne);
        }
        for (Ligne ligne : tableau.getLignes().getLignes()) {
            System.out.println(ligne);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void on_ne_peut_ajouter_deux_premieres_lignes() {
        new Tableau.Builder("tab_dep_fonc").ajouterLigne(new Ligne("code1")).ajouterLigne(new Ligne("code2")).build();
    }

    @Test(expected = IllegalStateException.class)
    public void on_ne_peut_ajouter_une_ligne_avec_un_code_pere_inexistant() {
        new Tableau.Builder("tab_dep_fonc").ajouterLigne(new Ligne("code1")).ajouterLigne(new Ligne("code2", "code3")).build();
    }

}
