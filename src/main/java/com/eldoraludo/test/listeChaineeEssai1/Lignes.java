package com.eldoraludo.test.listeChaineeEssai1;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.Set;

import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterables.find;

public class Lignes implements Iterable<Ligne> {

    private Set<Ligne> lignes = Sets.newHashSet();

    public void ajouter(Ligne ligne) {
        lignes.add(ligne);
    }

    public void validationDesLignes() {
        for (Ligne ligne : lignes) {
            Preconditions.checkState(verificationCodePereExiste(ligne));
            Preconditions.checkState(verificationPremiereLigneUnique(ligne));
        }
    }

    private Boolean verificationCodePereExiste(final Ligne ligne) {
        return ligne.estPremiereLigne() || any(lignes, new Predicate<Ligne>() {
            @Override
            public boolean apply(Ligne autreLigne) {
                return autreLigne.getCode().equals(ligne.getCodePere());
            }
        });
    }

    private Boolean verificationPremiereLigneUnique(final Ligne ligne) {
        return !ligne.estPremiereLigne() || ligne.estPremiereLigne() && !any(lignes, new Predicate<Ligne>() {
            @Override
            public boolean apply(Ligne autreLigne) {
                return !autreLigne.equals(ligne) && autreLigne.estPremiereLigne();
            }
        });
    }

    @Override
    public Iterator<Ligne> iterator() {
        return new LignesIterator(lignes);
    }

    public Set<Ligne> getLignes() {
        return Sets.newLinkedHashSet(this);
    }

    private class LignesIterator implements Iterator<Ligne> {
        private int position = 0;
        private int nombreDeLignes;
        private Ligne ligneCourante;
        private Set<Ligne> lignes;

        public LignesIterator(Set<Ligne> lignes) {
            this.lignes = Sets.newLinkedHashSet(lignes);
            this.nombreDeLignes = lignes.size();
        }

        @Override
        public boolean hasNext() {
            return position < nombreDeLignes;
        }

        @Override
        public Ligne next() {
            if (position++ == 0) {
                ligneCourante = find(lignes, new Predicate<Ligne>() {
                    @Override
                    public boolean apply(Ligne ligne) {
                        return ligne.estPremiereLigne();
                    }
                }, null);
            } else {
                ligneCourante = find(lignes, new Predicate<Ligne>() {
                    @Override
                    public boolean apply(Ligne ligneAChercher) {
                        return !ligneAChercher.estPremiereLigne() &&
                                ligneAChercher.getCodePere().equals(ligneCourante.getCode());
                    }
                });
            }
            lignes.remove(ligneCourante);
            return ligneCourante;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
