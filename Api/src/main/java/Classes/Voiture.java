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
public class Voiture {
    private int idVoiture;
    private String type;
    private String categorie;
    private String numero;
    private String image;
    private int etat;

    public Voiture(int idVoiture, String type, String categorie, String numero, String image, int etat) {
        this.idVoiture = idVoiture;
        this.type = type;
        this.categorie = categorie;
        this.numero = numero;
        this.image = image;
        this.etat = etat;
    }

    
    public RowMapper<Voiture> mapperVoiture = (ResultSet rs, int i) -> {
            Voiture vv;
            vv = new Voiture(rs.getInt("IDVOITURE"),rs.getString("TYPEVOITURE"),rs.getString("CATEGORIE"),rs.getString("NUMERO"),rs.getString("IMAGE"),rs.getInt("ETAT"));
            return vv;  
    };

    public Voiture() {
       
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

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the categorie
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    
}
