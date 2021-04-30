/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api.Controller;

import GetParametersPost.JsonParameters;
import com.example.Api.repository.CommentaireRepository;
import com.example.Api.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SAFIDY
 */
@RestController
@RequestMapping(path="/voiture",produces = {"application/json"})
@CrossOrigin(origins="*")
public class VoitureController {
    
    @Autowired
    VoitureRepository voitureRepository;
    
    @Autowired
    CommentaireRepository commentaireRepository;
    
    @PostMapping(value="/liste")
    public String getListeVoiture(@RequestBody String jsonParam) throws Exception{
        System.out.println("mandalo");
        String val="";
        try{
            JsonParameters jsonParametre = new JsonParameters(jsonParam);
            int page= Integer.parseInt(jsonParametre.getValue("page"));
            val=voitureRepository.findAllVoiture(page);
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    @PostMapping(value="/listeaveccommentaire")
    public String getListeVoitureAvecClientConnecte(@RequestBody String jsonParam) throws Exception{
        String val="";
        try{
            JsonParameters jsonParametre = new JsonParameters(jsonParam);
            int page= Integer.parseInt(jsonParametre.getValue("page"));
            val=commentaireRepository.findAllVoitureAvecCommentaire(page);
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }
    @PostMapping(value="/fiche")
    public String getFicheVoiture(@RequestBody String jsonParam) throws Exception{
        String val="";
        try{
            JsonParameters jsonParametre = new JsonParameters(jsonParam);
            int idVoiture= Integer.parseInt(jsonParametre.getValue("idVoiture"));
            val=commentaireRepository.findFicheVoiture(idVoiture);
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    @GetMapping(path="/getnombrepagination")
    public String getNombrePagination()throws Exception{
        String val="";
        val=this.voitureRepository.getNombrePagination();
        return val;
    }
}
