package model;

import java.util.ArrayList;
import java.util.List;

public class Client extends Personne {
    private String idClient;
    private List<Compte> comptes;

    public Client(String idClient, String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.idClient = idClient;
        this.comptes = new ArrayList<>();
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }

    public void supprimerCompte(Compte compte) {
        comptes.remove(compte);
    }

}