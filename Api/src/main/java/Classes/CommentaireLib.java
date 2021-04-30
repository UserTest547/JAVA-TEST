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
public class CommentaireLib extends Commentaire{
    private String nomUtilisateur;
    private String prenomUtilisateur;

    public CommentaireLib(int id, int idutilisateur, int idVoiture, String commentaire, String date, int etat) {
        super(id, idutilisateur, idVoiture, commentaire, date, etat);
    }

    

    public CommentaireLib() {
    }
    public RowMapper<CommentaireLib> mapperCommentaireLib = (ResultSet rs, int i) -> {
            CommentaireLib vv;
            vv = new CommentaireLib(rs.getInt("ID"),rs.getInt("IDUTILISATEUR"),rs.getInt("IDVOITURE"),rs.getString("COMMENTAIRE"),rs.getString("DATECOMMENTAIRE"),rs.getInt("ETAT"));
            vv.setNomUtilisateur(rs.getString("NOMUTILISATEUR"));
            vv.setPrenomUtilisateur(rs.getString("PRENOMUTILISATEUR"));
            return vv;  
    };
    /**
     * @return the nomUtilisateur
     */
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    /**
     * @param nomUtilisateur the nomUtilisateur to set
     */
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    /**
     * @return the prenomUtilisateur
     */
    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    /**
     * @param prenomUtilisateur the prenomUtilisateur to set
     */
    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }
    
}
