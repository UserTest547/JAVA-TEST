/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Api.repository;

import Classes.CommentaireLib;
import Classes.CommentaireVoiture;
import Classes.Utilisateur;
import Classes.Voiture;
import ReponseService.ReponseService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SAFIDY
 */
@Repository
public class CommentaireRepository {
    @Autowired 
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    VoitureRepository voitureRepository;
    
    //les dernier commentaire dans la liste des voiture
    public ArrayList<CommentaireLib> findAllCommentaireVoitureListeLimitee(int idVoiture){
        ArrayList<CommentaireLib> val=new ArrayList<>();
        int limitCommentaire=3;
        try{
            String requete="select*from"
                    + "("
                    + "select commentaire.id as ID,commentaire.idutilisateur as IDUTILISATEUR,commentaire.idvoiture as IDVOITURE,commentaire.commentaire as COMMENTAIRE,commentaire.dateCOMMENTAIRE as DATECOMMENTAIRE,commentaire.etat as ETAT,utilisateur.NOM as NOMUTILISATEUR,utilisateur.prenom as PRENOMUTILISATEUR"
                    + " from commentaire join utilisateur on commentaire.idutilisateur=utilisateur.idutilisateur"
                    + " where commentaire.idvoiture="+idVoiture+" "
                    + "order by datecommentaire DESC limit "+limitCommentaire
                    + ")"
                    + " as commentaire order by datecommentaire ASC";
            CommentaireLib commentLib=new CommentaireLib();
            List<CommentaireLib> lc = jdbcTemplate.query(requete, commentLib.mapperCommentaireLib);
            val = new ArrayList<>(lc);
            return val;
        }
        catch(Exception e){
            System.out.println("erreur getDernierCommentaireVoiture="+e.getMessage());
            throw e;
        }
    }
    //tous les commentaire d'une voiture
    public ArrayList<CommentaireLib> findAllCommentaireVoiture(int idVoiture){
        ArrayList<CommentaireLib> val=new ArrayList<>();
        try{
            String requete="select commentaire.id as ID,commentaire.idutilisateur as IDUTILISATEUR,commentaire.idvoiture as IDVOITURE,commentaire.commentaire as COMMENTAIRE,commentaire.dateCOMMENTAIRE as DATECOMMENTAIRE,commentaire.etat as ETAT,utilisateur.NOM as NOMUTILISATEUR,utilisateur.prenom as PRENOMUTILISATEUR"
                    + " from commentaire join utilisateur on commentaire.idutilisateur=utilisateur.idutilisateur"
                    + " where commentaire.idvoiture="+idVoiture+" order by commentaire.datecommentaire";
            CommentaireLib commentLib=new CommentaireLib();
            List<CommentaireLib> lc = jdbcTemplate.query(requete, commentLib.mapperCommentaireLib);
            val = new ArrayList<>(lc);
            return val;
        }
        catch(Exception e){
            System.out.println("erreur getAllCommentaireVoiture="+e.getMessage());
            throw e;
        }
    }
    //    commenter une voiture
    private void commenterVoiture(int idVoiture,int idUtilisateur,String commentaire){
        try{
        Utilisateur val = new Utilisateur();
        String requetes = "insert into commentaire values(null,"+idUtilisateur+","+idVoiture+",'"+commentaire+"',NOW(),0)";
        jdbcTemplate.execute(requetes);
        }
        catch(Exception e){
            System.out.println("erreur commentert="+e.getMessage());
            throw e;
        }
    }
    
    public String commenterDansListe(int idVoiture,int idUtilisateur,String commentaire,int page) throws Exception{
        String val="";
        try{
            ReponseService res=new ReponseService();
            if("".equals(commentaire)||commentaire==null){
                res.setMessage("Votre commentaire est vide!");
                throw new Exception("commentaire vide");
            }
            else{
                this.commenterVoiture(idVoiture, idUtilisateur, commentaire);
                ArrayList<CommentaireVoiture> lv=this.findAllVoitureAvecCommentaireP(page);
                res.setDonnee(lv);
                val=res.getReponseJson();
            }
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }
    public String commenterDansFiche(int idVoiture,int idUtilisateur,String commentaire) throws Exception{
        String val="";
        try{
            ReponseService res=new ReponseService();
            if("".equals(commentaire)||commentaire==null){
                res.setMessage("Votre commentaire est vide!");
                throw new Exception("commentaire vide");
            }
            else{
                this.commenterVoiture(idVoiture, idUtilisateur, commentaire);
                Voiture voi=this.voitureRepository.findVoitureById(idVoiture);
                ArrayList<CommentaireLib> lc =this.findAllCommentaireVoiture(idVoiture);
                CommentaireVoiture cm = new CommentaireVoiture(voi,lc,lc.size());
                res.setDonnee(cm);
                val=res.getReponseJson();
            }
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }
    //    liste des voitures client connecte,avec des commentaire
    public String findAllVoitureAvecCommentaire(int page) throws Exception{
        ReponseService res=new ReponseService();
        ArrayList<CommentaireVoiture> lv=this.findAllVoitureAvecCommentaireP(page);
        res.setDonnee(lv);
        String val=res.getReponseJson();
        return val;
    }
    
    public ArrayList<CommentaireVoiture> findAllVoitureAvecCommentaireP(int page) throws Exception{
        ArrayList<CommentaireVoiture> val=new ArrayList<>();
        try{
            ArrayList<Voiture> lVoiture=this.voitureRepository.findAllVoitureP(page);
            for(int i=0;i<lVoiture.size();i++){
                int idVoiture=lVoiture.get(i).getIdVoiture();
                ArrayList<CommentaireLib> listeCommentaireParVoiture=this.findAllCommentaireVoitureListeLimitee(idVoiture);
                int nombreDeTousLesCommentaire=this.findAllCommentaireVoiture(idVoiture).size();
                CommentaireVoiture commentaireVoiture=new CommentaireVoiture(lVoiture.get(i),listeCommentaireParVoiture,nombreDeTousLesCommentaire);
                val.add(commentaireVoiture);
            }
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }
    //    fiche d'une voiture
    public String findFicheVoiture(int idVoiture) throws Exception{
        ReponseService res=new ReponseService();
        CommentaireVoiture fiche=this.findFicheVoitureP(idVoiture);
        res.setDonnee(fiche);
        String val=res.getReponseJson();
        return val;
    }
    public CommentaireVoiture findFicheVoitureP(int idVoiture)throws Exception{
        CommentaireVoiture val= new CommentaireVoiture();
        Voiture voiture=this.voitureRepository.findVoitureById(idVoiture);
        ArrayList<CommentaireLib> listeCommentaireVoiture=this.findAllCommentaireVoiture(idVoiture);
        val.setVoiture(voiture);
        val.setListeCommentaire(listeCommentaireVoiture);
        return val;
    }
    
    
}
