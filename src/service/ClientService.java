package service;

import model.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service pour la gestion métier des clients.
 */
public class ClientService {
    private Map<String, Client> clients = new HashMap<>();

    public void ajouterClient(Client client) {
        clients.put(client.getIdClient(), client);
    }

    public void modifierClient(Client client) {
        clients.put(client.getIdClient(), client);
    }

    public void supprimerClient(String idClient) {
        clients.remove(idClient);
    }

    public Optional<Client> rechercherClient(String idClient) {
        return Optional.ofNullable(clients.get(idClient));
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients.values());
    }
}