package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Client extends Personne {
    private String idClient;
    private List<Compte> comptes;
    private static final AtomicInteger compteur = new AtomicInteger(1);

    public Client( String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.idClient = "C" + compteur.getAndIncrement();
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

    public Optional<Compte> rechercherCompteParId(String idCompte) {
        return comptes.stream()
                .filter(c -> c.getIdCompte().equals(idCompte))
                .findFirst();
    }

    public String toString() {
        return "Client { " +
                "ID = '" + idClient + '\'' +
                ", Nom = '" + getNom() + '\'' +
                ", Prénom = '" + getPrenom() + '\'' +
                ", Email = '" + getEmail() + '\'' +
                ", Nombre de comptes = " + comptes.size() +
                " }";
    }

}