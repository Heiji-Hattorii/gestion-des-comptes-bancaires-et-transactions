package controller;

import model.Gestionnaire;
import service.GestionnaireService;

import java.util.Optional;

/**
 * Contrôleur pour gérer les interactions liées aux gestionnaires.
 */
public class GestionnaireController {
    private final GestionnaireService gestionnaireService;

    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }

    public void creerGestionnaire(Gestionnaire gestionnaire) {
        gestionnaireService.ajouterGestionnaire(gestionnaire);
    }

    public Optional<Gestionnaire> lireGestionnaire(String idGestionnaire) {
        return gestionnaireService.rechercherGestionnaire(idGestionnaire);
    }

    public void mettreAJourGestionnaire(Gestionnaire gestionnaire) {
        gestionnaireService.modifierGestionnaire(gestionnaire);
    }

    public void supprimerGestionnaire(String idGestionnaire) {
        gestionnaireService.supprimerGestionnaire(idGestionnaire);
    }

    public void afficherTousLesGestionnaires() {
        gestionnaireService.getGestionnaires().values().forEach(System.out::println);
    }
}