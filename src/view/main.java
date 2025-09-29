package view;

import controller.ClientController;
import controller.CompteController;
import controller.GestionnaireController;
import controller.TransactionController;
import model.Client;
import model.Compte;
import model.TypeCompte;
import model.Transaction;
import service.ClientService;
import service.CompteService;
import service.GestionnaireService;
import service.TransactionService;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        CompteService compteService = new CompteService();
        GestionnaireService gestionnaireService = new GestionnaireService();
        TransactionService transactionService = new TransactionService();

        ClientController clientController = new ClientController(clientService);
        CompteController compteController = new CompteController(compteService);
        GestionnaireController gestionnaireController = new GestionnaireController(gestionnaireService);
        TransactionController transactionController = new TransactionController(transactionService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            afficherMenuPrincipal();
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    menuGestionnaire(clientController, compteController, gestionnaireController, transactionController, scanner);
                    break;
                case 2:
                    menuClient(clientController, transactionController, scanner);
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

    // Menu principal
    public static void afficherMenuPrincipal() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1. Espace Gestionnaire");
        System.out.println("2. Espace Client");
        System.out.println("3. Quitter");
        System.out.print("Votre choix : ");
    }

    // Sous-menu gestionnaire avec sous-menus précis
    public static void menuGestionnaire(ClientController clientController, CompteController compteController,
                                        GestionnaireController gestionnaireController, TransactionController transactionController, Scanner scanner) {
        boolean retour = false;
        while (!retour) {
            System.out.println("\n--- Espace Gestionnaire ---");
            System.out.println("1. Gestion des clients");
            System.out.println("2. Gestion des comptes");
            System.out.println("3. Gestion des transactions");
            System.out.println("4. Gestion des gestionnaires");
            System.out.println("5. Retour");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    sousMenuClients(clientController, scanner);
                    break;
                case 2:
                    sousMenuComptes(clientController, compteController, scanner);
                    break;
                case 3:
                    sousMenuTransactions(transactionController, scanner);
                    break;
                case 4:
                    sousMenuGestionnaires(gestionnaireController, scanner);
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // Sous-menu gestion des clients
    public static void sousMenuClients(ClientController clientController, Scanner scanner) {
        boolean retour = false;
        while (!retour) {
            System.out.println("\n--- Gestion des Clients ---");
            System.out.println("1. Afficher tous les clients");
            System.out.println("2. Consulter les informations d'un client");
            System.out.println("3. Créer un client");
            System.out.println("4. Modifier un client");
            System.out.println("5. Supprimer un client");
            System.out.println("6. Retour");
            System.out.print("Votre choix : ");
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
                    creerClient(clientController, scanner);
                    break;
                case 4:
                    modifierClient(clientController, scanner);
                    break;
                case 5:
                    supprimerClient(clientController, scanner);
                    break;
                case 6:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // Sous-menu gestion des comptes
    public static void sousMenuComptes(ClientController clientController, CompteController compteController, Scanner scanner) {
        boolean retour = false;
        while (!retour) {
            System.out.println("\n--- Gestion des Comptes ---");
            System.out.println("1. Ajouter un compte à un client");
            System.out.println("2. Afficher l'historique des transactions d'un compte");
            System.out.println("3. Retour");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    ajouterCompteAuClient(clientController, compteController, scanner);
                    break;
                case 2:
                    afficherTransactionsCompte(clientController, scanner);
                    break;
                case 3:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // Sous-menu gestion des transactions
    public static void sousMenuTransactions(TransactionController transactionController, Scanner scanner) {
        boolean retour = false;
        while (!retour) {
            System.out.println("\n--- Gestion des Transactions ---");
            System.out.println("1. Afficher toutes les transactions");
            System.out.println("2. Filtrer et trier les transactions");
            System.out.println("3. Afficher les transactions suspectes");
            System.out.println("4. Retour");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    afficherToutesLesTransactions(transactionController);
                    break;
                case 2:
                    filtrerEtTrierTransactions(transactionController, scanner);
                    break;
                case 3:
                    afficherTransactionsSuspectes(transactionController);
                    break;
                case 4:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // Sous-menu gestion des gestionnaires
    public static void sousMenuGestionnaires(GestionnaireController gestionnaireController, Scanner scanner) {
        boolean retour = false;
        while (!retour) {
            System.out.println("\n--- Gestion des Gestionnaires ---");
            System.out.println("1. Afficher tous les gestionnaires");
            System.out.println("2. Retour");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    afficherTousLesGestionnaires(gestionnaireController);
                    break;
                case 2:
                    retour = true;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // Connexion client par email et mot de passe
    public static void menuClient(ClientController clientController, TransactionController transactionController, Scanner scanner) {
        System.out.print("Entrez votre email : ");
        String email = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        String mdp = scanner.nextLine();

        Optional<Client> clientOpt = clientController.getAllClients().stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email) && c.getMotDePasse().equals(mdp))
                .findFirst();

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            boolean retour = false;
            while (!retour) {
                System.out.println("\n--- Espace Client ---");
                System.out.println("1. Mes informations personnelles");
                System.out.println("2. Mes comptes bancaires");
                System.out.println("3. Historique de mes transactions");
                System.out.println("4. Filtrer/trier mes transactions");
                System.out.println("5. Calculer mon solde total");
                System.out.println("6. Retour");
                System.out.print("Votre choix : ");
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        System.out.println("Nom : " + client.getNom());
                        System.out.println("Prénom : " + client.getPrenom());
                        System.out.println("Email : " + client.getEmail());
                        break;
                    case 2:
                        client.getComptes().forEach(compte -> {
                            System.out.println("Compte ID : " + compte.getIdCompte() +
                                    ", Type : " + compte.getTypeCompte() +
                                    ", Solde : " + compte.getSolde());
                        });
                        break;
                    case 3:
                        client.getComptes().forEach(compte -> {
                            System.out.println("Transactions du compte " + compte.getIdCompte() + " :");
                            compte.getTransactions().forEach(System.out::println);
                        });
                        break;
                    case 4:
                        filtrerEtTrierTransactionsClient(client, scanner);
                        break;
                    case 5:
                        double total = client.getComptes().stream().mapToDouble(Compte::getSolde).sum();
                        System.out.println("Solde total de tous vos comptes : " + total);
                        break;
                    case 6:
                        retour = true;
                        break;
                    default:
                        System.out.println("Choix invalide.");
                }
            }
        } else {
            System.out.println("Identifiants incorrects.");
        }
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

    public static void ajouterCompteAuClient(ClientController clientController, CompteController compteController, Scanner scanner) {
        System.out.print("Entrez l'ID du client : ");
        String idClient = scanner.nextLine();
        Optional<Client> clientOpt = clientController.lireClient(idClient);

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            System.out.print("ID du compte : ");
            String idCompte = scanner.nextLine();
            System.out.print("Type de compte (COURANT, EPARGNE, DEPOTATERME) : ");
            String typeStr = scanner.nextLine().toUpperCase();
            System.out.print("Solde initial : ");
            double solde = scanner.nextDouble();
            scanner.nextLine();

            TypeCompte typeCompte;
            try {
                typeCompte = TypeCompte.valueOf(typeStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Type de compte invalide.");
                return;
            }

            Compte compte = new Compte(idCompte, typeCompte, solde, client);
            compteController.creerCompte(compte);
            System.out.println("Compte ajouté au client.");
        } else {
            System.out.println("Client introuvable.");
        }
    }

    public static void afficherTousLesGestionnaires(GestionnaireController gestionnaireController) {
        System.out.println("--- Liste des gestionnaires ---");
        gestionnaireController.afficherTousLesGestionnaires();
    }

    public static void afficherToutesLesTransactions(TransactionController transactionController) {
        System.out.println("--- Liste des transactions ---");
        transactionController.afficherToutesLesTransactions();
    }

    public static void afficherTransactionsCompte(ClientController clientController, Scanner scanner) {
        System.out.print("Entrez l'ID du client : ");
        String idClient = scanner.nextLine();
        Optional<Client> clientOpt = clientController.lireClient(idClient);

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            System.out.print("Entrez l'ID du compte : ");
            String idCompte = scanner.nextLine();
            Optional<Compte> compteOpt = client.getComptes().stream()
                    .filter(c -> c.getIdCompte().equals(idCompte))
                    .findFirst();
            if (compteOpt.isPresent()) {
                Compte compte = compteOpt.get();
                System.out.println("--- Transactions du compte " + compte.getIdCompte() + " ---");
                compte.getTransactions().forEach(System.out::println);
            } else {
                System.out.println("Compte introuvable.");
            }
        } else {
            System.out.println("Client introuvable.");
        }
    }

    public static void filtrerEtTrierTransactions(TransactionController transactionController, Scanner scanner) {
        System.out.print("Filtrer par (TYPE/MONTANT/DATE) : ");
        String critere = scanner.nextLine().toUpperCase();

        Predicate<Transaction> predicate = t -> true;
        Comparator<Transaction> comparator = Comparator.comparing(Transaction::getDate);

        switch (critere) {
            case "TYPE":
                System.out.print("Type (DEPOT, RETRAIT, VIREMENT) : ");
                String type = scanner.nextLine().toUpperCase();
                predicate = t -> t.getTypeTransaction().name().equals(type);
                break;
            case "MONTANT":
                System.out.print("Montant minimum : ");
                double min = scanner.nextDouble();
                System.out.print("Montant maximum : ");
                double max = scanner.nextDouble();
                scanner.nextLine();
                predicate = t -> t.getMontant() >= min && t.getMontant() <= max;
                comparator = Comparator.comparing(Transaction::getMontant);
                break;
            case "DATE":
                comparator = Comparator.comparing(Transaction::getDate).reversed();
                break;
            default:
                System.out.println("Critère inconnu, affichage par défaut.");
        }

        System.out.println("--- Transactions filtrées/triées ---");
        transactionController.filtrerTransactions(predicate).stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    // Pour le client connecté : filtrer/trier ses transactions
    public static void filtrerEtTrierTransactionsClient(Client client, Scanner scanner) {
        System.out.print("Filtrer par (TYPE/MONTANT/DATE) : ");
        String critere = scanner.nextLine().toUpperCase();

        Predicate<Transaction> predicate = t -> true;
        Comparator<Transaction> comparator = Comparator.comparing(Transaction::getDate);

        switch (critere) {
            case "TYPE":
                System.out.print("Type (DEPOT, RETRAIT, VIREMENT) : ");
                String type = scanner.nextLine().toUpperCase();
                predicate = t -> t.getTypeTransaction().name().equals(type);
                break;
            case "MONTANT":
                System.out.print("Montant minimum : ");
                double min = scanner.nextDouble();
                System.out.print("Montant maximum : ");
                double max = scanner.nextDouble();
                scanner.nextLine();
                predicate = t -> t.getMontant() >= min && t.getMontant() <= max;
                comparator = Comparator.comparing(Transaction::getMontant);
                break;
            case "DATE":
                comparator = Comparator.comparing(Transaction::getDate).reversed();
                break;
            default:
                System.out.println("Critère inconnu, affichage par défaut.");
        }

        System.out.println("--- Vos transactions filtrées/triées ---");
        client.getComptes().stream()
                .flatMap(c -> c.getTransactions().stream())
                .filter(predicate)
                .sorted(comparator)
                .forEach(System.out::println);
    }

    public static void afficherTransactionsSuspectes(TransactionController transactionController) {
        System.out.println("--- Transactions suspectes (montant > 10000 ou opérations répétées) ---");
        transactionController.filtrerTransactions(t -> t.getMontant() > 10000)
                .forEach(System.out::println);
        // Pour les opérations répétées, il faudrait une logique plus avancée
    }

    public static void creerClient(ClientController clientController, Scanner scanner) {
        System.out.print("ID du client : ");
        String id = scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String mdp = scanner.nextLine();

        Client client = new Client(id, nom, prenom, email, mdp);
        clientController.creerClient(client);
        System.out.println("Client créé avec succès.");
    }

    public static void modifierClient(ClientController clientController, Scanner scanner) {
        System.out.print("ID du client à modifier : ");
        String id = scanner.nextLine();
        Optional<Client> clientOpt = clientController.lireClient(id);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            System.out.print("Nouveau nom (" + client.getNom() + ") : ");
            String nom = scanner.nextLine();
            System.out.print("Nouveau prénom (" + client.getPrenom() + ") : ");
            String prenom = scanner.nextLine();
            System.out.print("Nouvel email (" + client.getEmail() + ") : ");
            String email = scanner.nextLine();
            System.out.print("Nouveau mot de passe : ");
            String mdp = scanner.nextLine();

            if (!nom.isEmpty()) client.setNom(nom);
            if (!prenom.isEmpty()) client.setPrenom(prenom);
            if (!email.isEmpty()) client.setEmail(email);
            if (!mdp.isEmpty()) client.setMotDePasse(mdp);

            clientController.mettreAJourClient(client);
            System.out.println("Client modifié avec succès.");
        } else {
            System.out.println("Client introuvable.");
        }
    }

    public static void supprimerClient(ClientController clientController, Scanner scanner) {
        System.out.print("ID du client à supprimer : ");
        String id = scanner.nextLine();
        clientController.supprimerClient(id);
        System.out.println("Client supprimé (si existait).");
    }
}
