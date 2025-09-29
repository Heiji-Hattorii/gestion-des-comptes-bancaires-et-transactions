package controller;

import model.Transaction;
import service.TransactionService;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void creerTransaction(Transaction transaction) {
        transactionService.ajouterTransaction(transaction);
    }

    public Optional<Transaction> lireTransaction(String idTransaction) {
        return transactionService.rechercherTransaction(idTransaction);
    }

    public void mettreAJourTransaction(Transaction transaction) {
        transactionService.modifierTransaction(transaction);
    }

    public void supprimerTransaction(String idTransaction) {
        transactionService.supprimerTransaction(idTransaction);
    }

    public List<Transaction> filtrerTransactions(Predicate<Transaction> predicate) {
        return transactionService.filtrerTransactions(predicate);
    }

    public void afficherToutesLesTransactions() {
        transactionService.getTransactions().forEach(System.out::println);
    }
}