package view;

import controller.ClientController;
import model.Client;
import service.ClientService;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        ClientController clientController = new ClientController(clientService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            afficherMenuPrincipal(); 
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    afficherTousLesClients(clientController); 
                    break;
                case 2:
                    afficherInfosClient(clientController, scanner); 
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }

    public static void afficherMenuPrincipal() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Afficher tous les clients");
        System.out.println("2. Consulter les informations d'un client");
        System.out.println("3. Quitter");
        System.out.print("Votre choix : ");
    }

    public static void afficherTousLesClients(ClientController clientController) {
        System.out.println("--- Liste des clients ---");
        clientController.afficherTousLesClients();
    }

    public static void afficherInfosClient(ClientController clientController, Scanner scanner) {
        System.out.print("Entrez l'ID du client : ");
        String idClient = scanner.nextLine();
        Optional<Client> clientOpt = clientController.lireClient(idClient);

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            System.out.println("Nom : " + client.getNom());
            System.out.println("Prénom : " + client.getPrenom());
            System.out.println("Email : " + client.getEmail());
            System.out.println("Nombre de comptes : " + client.getComptes().size());
            client.getComptes().forEach(compte -> {
                System.out.println("  - Compte ID : " + compte.getIdCompte() +
                        ", Type : " + compte.getTypeCompte() +
                        ", Solde : " + compte.getSolde());
            });
        } else {
            System.out.println("Client introuvable.");
        }
    }
}