package model;

public class Client extends Personne {
    private String idClient;

    public Client(String idClient, String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.idClient = idClient;
    }

    public String getIdClient() {
        return idClient;
    }
    
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

}