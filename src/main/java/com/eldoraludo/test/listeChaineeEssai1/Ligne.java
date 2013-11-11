package com.eldoraludo.test.listeChaineeEssai1;


public class Ligne {

    private String code;
    private String codePere;

    public Ligne(String code) {
        this.code = code;
    }

    public Ligne(String code, String codePere) {
        this.code = code;
        this.codePere = codePere;
    }

    public String getCodePere() {
        return codePere;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Ligne{" +
                "code='" + code + '\'' +
                ", codePere='" + codePere + '\'' +
                '}';
    }

    public boolean estPremiereLigne() {
        return this.codePere == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ligne ligne = (Ligne) o;

        if (code != null ? !code.equals(ligne.code) : ligne.code != null) return false;
        if (codePere != null ? !codePere.equals(ligne.codePere) : ligne.codePere != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (codePere != null ? codePere.hashCode() : 0);
        return result;
    }
}
