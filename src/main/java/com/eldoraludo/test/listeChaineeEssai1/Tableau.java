package com.eldoraludo.test.listeChaineeEssai1;

public class Tableau {

    private String codeTableau;
    private Lignes lignes = new Lignes();

    /*package*/ Tableau() {
    }

    public Tableau(String codeTableau) {
        this.codeTableau = codeTableau;
    }

    public String getCodeTableau() {
        return codeTableau;
    }

    public Lignes getLignes() {
        return lignes;
    }

    public static class Builder {

        private Tableau tableauPartiel;

        public Builder(String codeTableau) {
            tableauPartiel = new Tableau(codeTableau);
        }

        public Builder ajouterLigne(Ligne ligne) {
            tableauPartiel.lignes.ajouter(ligne);
            return this;
        }

        public Tableau build() {
            tableauPartiel.getLignes().validationDesLignes();
            return tableauPartiel;
        }
    }
}
