package service;

import model.Client;
import model.Compte;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Service pour la logique métier des comptes bancaires.
 */
public class CompteService {
    private final Map<String, Compte> comptes = new HashMap<>();

    public void ajouterCompte(Compte compte) {
        comptes.put(compte.getIdCompte(), compte);
        // Associer le compte au client
        Client client = compte.getClient();
        if (client != null && !client.getComptes().contains(compte)) {
            client.ajouterCompte(compte);
        }
    }

    public void modifierCompte(Compte compte) {
        comptes.put(compte.getIdCompte(), compte);
    }

    public void supprimerCompte(String idCompte) {
        comptes.remove(idCompte);
    }

    public Optional<Compte> rechercherCompte(String idCompte) {
        return Optional.ofNullable(comptes.get(idCompte));
    }

    public Map<String, Compte> getComptes() {
        return comptes;
    }
}