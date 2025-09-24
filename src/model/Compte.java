package model;

import java.util.ArrayList;
import java.util.List;

public class Compte {
    private String idCompte;
    private TypeCompte typeCompte;
    private double solde;
    private Client client;
    private List<Transaction> transactions;

    public Compte(String idCompte, TypeCompte typeCompte, double solde, Client client) {
        this.idCompte = idCompte;
        this.typeCompte = typeCompte;
        this.solde = solde;
        this.client = client;
        this.transactions = new ArrayList<>();
    }

    public String getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(String idCompte) {
        this.idCompte = idCompte;
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void ajouterTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void supprimerTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }
}