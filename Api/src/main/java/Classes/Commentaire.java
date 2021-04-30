/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author SAFIDY
 */
public class Commentaire {
    private int id;
    private int idutilisateur;
    private int idVoiture;
    private String commentaire;
    private String date;
    private int etat;

    public Commentaire(int id, int idutilisateur, int idVoiture, String commentaire, String date, int etat) {
        this.id = id;
        this.idutilisateur = idutilisateur;
        this.idVoiture = idVoiture;
        this.commentaire = commentaire;
        this.date = date;
        this.etat = etat;
    }

    

    public Commentaire() {
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idutilisateur
     */
    public int getIdutilisateur() {
        return idutilisateur;
    }

    /**
     * @param idutilisateur the idutilisateur to set
     */
    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    /**
     * @return the Commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * @param Commentaire the Commentaire to set
     */
    public void setCommentaire(String Commentaire) {
        this.commentaire = Commentaire;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the etat
     */
    public int getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

    /**
     * @return the idVoiture
     */
    public int getIdVoiture() {
        return idVoiture;
    }

    /**
     * @param idVoiture the idVoiture to set
     */
    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }
    
}
