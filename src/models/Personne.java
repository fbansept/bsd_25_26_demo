package models;

public class Personne {

    private String nom;
    private String prenom;
    private int age = 18;

    public Personne() {
        this.nom = "DOE";
        this.prenom = "John";
    }

    public Personne(String nom){
        this.nom = nom;
        this.prenom = "";
    }


    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.age = age;
        this.prenom = prenom;
    }

    public String nomComplet() {

        return nom + " " + prenom;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
