/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author SAFIDY
 */
public class Utilisateur {
    private int idutilisateur;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private int etat;

    public Utilisateur(int idutilisateur, String nom, String prenom, String login, String mdp, int etat) {
        this.idutilisateur = idutilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
        this.etat = etat;
    }

    public Utilisateur() {
    }


    public RowMapper<Utilisateur> mapperUtilisateur = (ResultSet rs, int i) -> {
            Utilisateur vv;
            vv = new Utilisateur(rs.getInt("IDUTILISATEUR"),rs.getString("NOM"),rs.getString("PRENOM"),rs.getString("LOGIN"),rs.getString("MOTDEPASSE"),rs.getInt("ETAT"));
            return vv;  
    };
    
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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
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
    
    
    
}
