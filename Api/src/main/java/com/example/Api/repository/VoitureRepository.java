/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Api.repository;

import Classes.CommentaireLib;
import Classes.CommentaireVoiture;
import Classes.Voiture;
import ReponseService.ReponseService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SAFIDY
 */

@Repository
public class VoitureRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
//    @Autowired
//    CommentaireRepository commentaireRepository;
    
//    liste des voitures
    public String findAllVoiture(int page) throws Exception{
        ReponseService res=new ReponseService();
        ArrayList<Voiture> lv=this.findAllVoitureP(page);
        res.setDonnee(lv);
        String val=res.getReponseJson();
        return val;
    }
    
    public ArrayList<Voiture> findAllVoitureP(int page) throws Exception{
        ArrayList<Voiture> val=new ArrayList<>();
        int limit=3;
        try{
            int offset=limit*(page-1);
            String requete="select*from voiture where etat=0 limit "+limit+" offset "+offset;
            Voiture v = new Voiture();
            List<Voiture> l = jdbcTemplate.query(requete,v.mapperVoiture);
            val=(ArrayList<Voiture>) l;
            if(val.isEmpty()){
                throw new Exception("Aucune voiture a afficher!");
            }
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }
    
//    nombre de pagination
    public String getNombrePagination(){
        ReponseService res=new ReponseService();
        int nombrePage=this.getNombrePaginationP();
        res.setDonnee(nombrePage);
        String val=res.getReponseJson();
        return val;
    }
    
    private int getNombrePaginationP(){
        int val=0;
        int limit=3;
        try{
            String requete="select count(*)from voiture";
            int va = jdbcTemplate.queryForObject(requete,Integer.class);
            int rest=va%limit;
            int nombreDivise=va/limit;
            if(rest>0){
                val=nombreDivise+1;
            }
            else if(rest==0){
                val=nombreDivise;
            }
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }
   
    public Voiture findVoitureById(int idVoiture){
        Voiture val=new Voiture();
        try{
            String requete="select* from voiture where idvoiture="+idVoiture;
            Voiture v = new Voiture();
            val = jdbcTemplate.queryForObject(requete,v.mapperVoiture);
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }
    
}
