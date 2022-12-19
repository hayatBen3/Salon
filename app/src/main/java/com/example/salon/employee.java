package com.example.salon;

public class employee {
    private String nom;
    private String prenom;
    private Double salaire;

    public void setnom(String n) {
        this.nom = n;
    }

    public String getnom() {
        return nom;
    }

    public void setprenom(String n) {
        this.prenom = n;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setsalaire(double n) {
        this.salaire = n;
    }

    public double getsalaire() {
        return salaire;
    }

    public employee(String n,String m, double k){
        this.nom=n;
        this.prenom=m;
        this.salaire=k;
    }

}