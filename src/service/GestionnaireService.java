package service;

import model.Gestionnaire;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Service pour la logique métier des gestionnaires.
 */
public class GestionnaireService {
    private final Map<String, Gestionnaire> gestionnaires = new HashMap<>();

    public void ajouterGestionnaire(Gestionnaire gestionnaire) {
        gestionnaires.put(gestionnaire.getIdGestionnaire(), gestionnaire);
    }

    public void modifierGestionnaire(Gestionnaire gestionnaire) {
        gestionnaires.put(gestionnaire.getIdGestionnaire(), gestionnaire);
    }

    public void supprimerGestionnaire(String idGestionnaire) {
        gestionnaires.remove(idGestionnaire);
    }

    public Optional<Gestionnaire> rechercherGestionnaire(String idGestionnaire) {
        return Optional.ofNullable(gestionnaires.get(idGestionnaire));
    }

    public Map<String, Gestionnaire> getGestionnaires() {
        return gestionnaires;
    }
}