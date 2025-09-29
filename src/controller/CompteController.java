package controller;

import model.Compte;
import service.CompteService;

import java.util.Optional;

public class CompteController {
    private final CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    public void creerCompte(Compte compte) {
        compteService.ajouterCompte(compte);
    }

    public Optional<Compte> lireCompte(String idCompte) {
        return compteService.rechercherCompte(idCompte);
    }

    public void mettreAJourCompte(Compte compte) {
        compteService.modifierCompte(compte);
    }

    public void supprimerCompte(String idCompte) {
        compteService.supprimerCompte(idCompte);
    }

    public void afficherTousLesComptes() {
        compteService.getComptes().values().forEach(System.out::println);
    }
}