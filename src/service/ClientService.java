package service;

import model.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Service pour la gestion métier des clients.
 */
public class ClientService {
    private Map<String, Client> clients = new HashMap<>();

    // Ajouter un client
    public void ajouterClient(Client client) {
        clients.put(client.getIdClient(), client);
    }

    // Modifier un client
    public void modifierClient(Client client) {
        clients.put(client.getIdClient(), client);
    }

    // Supprimer un client
    public void supprimerClient(String idClient) {
        clients.remove(idClient);
    }

    // Rechercher un client par ID
    public Optional<Client> rechercherClient(String idClient) {
        return Optional.ofNullable(clients.get(idClient));
    }

    // Retourner tous les clients
    public Map<String, Client> getClients() {
        return clients;
    }
}