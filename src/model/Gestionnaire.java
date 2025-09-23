package model;

import java.util.ArrayList;
import java.util.List;


public class Gestionnaire extends Personne {
    private String idGestionnaire;
    private String departement;
    private List<Client> listeClients;

    public Gestionnaire(String idGestionnaire, String nom, String prenom, String email, String motDePasse, String departement) {
        super(nom, prenom, email, motDePasse);
        this.idGestionnaire = idGestionnaire;
        this.departement = departement;
        this.listeClients = new ArrayList<>();
    }

    public String getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(String idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public List<Client> getListeClients() {
        return listeClients;
    }

    public void ajouterClient(Client client) {
        listeClients.add(client);
    }

    public void supprimerClient(Client client) {
        listeClients.remove(client);
    }
}