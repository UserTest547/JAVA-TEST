/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author SAFIDY
 */
public class CommentaireVoiture {
    private Voiture voiture;
    private ArrayList<CommentaireLib> listeCommentaire;
    private int nombreCommentaire;

    public CommentaireVoiture(Voiture voiture, ArrayList<CommentaireLib> listeCommentaire, int nombreCommentaire) {
        this.voiture = voiture;
        this.listeCommentaire = listeCommentaire;
        this.nombreCommentaire = nombreCommentaire;
    }

    public CommentaireVoiture() {
    }
    

    /**
     * @return the voiture
     */
    public Voiture getVoiture() {
        return voiture;
    }

    /**
     * @param voiture the voiture to set
     */
    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

  



    /**
     * @return the nombreCommentaire
     */
    public int getNombreCommentaire() {
        return nombreCommentaire;
    }

    /**
     * @param nombreCommentaire the nombreCommentaire to set
     */
    public void setNombreCommentaire(int nombreCommentaire) {
        this.nombreCommentaire = nombreCommentaire;
    }

    /**
     * @return the listeCommentaire
     */
    public ArrayList<CommentaireLib> getListeCommentaire() {
        return listeCommentaire;
    }

    /**
     * @param listeCommentaire the listeCommentaire to set
     */
    public void setListeCommentaire(ArrayList<CommentaireLib> listeCommentaire) {
        this.listeCommentaire = listeCommentaire;
    }
    
}
