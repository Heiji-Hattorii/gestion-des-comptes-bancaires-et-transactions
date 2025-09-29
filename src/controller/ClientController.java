package controller;

import model.Client;
import service.ClientService;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur pour gérer les interactions liées aux clients.
 */
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public void creerClient(Client client) {
        clientService.ajouterClient(client);
    }

    public Optional<Client> lireClient(String idClient) {
        return clientService.rechercherClient(idClient);
    }

    public void mettreAJourClient(Client client) {
        clientService.modifierClient(client);
    }

    public void supprimerClient(String idClient) {
        clientService.supprimerClient(idClient);
    }

    public void afficherTousLesClients() {
        clientService.getClients().values().forEach(System.out::println);
    }

    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}