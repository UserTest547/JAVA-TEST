/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api.Controller;

import GetParametersPost.JsonParameters;
import com.example.Api.repository.CommentaireRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SAFIDY
 */
@RestController
@RequestMapping(path="/commentaire",produces={"application/json"})
@CrossOrigin(origins="*")
public class CommentaireController {
    @Autowired
    CommentaireRepository commentaireRepository;
    
    @PostMapping(value="/ajout")
    public String commenterDansListe(@RequestBody String jsonParam) throws JsonProcessingException, Exception{
        JsonParameters jsonParametre = new JsonParameters(jsonParam);
        int idVoiture= Integer.parseInt(jsonParametre.getValue("idVoiture"));
        int idUtilisateur= Integer.parseInt(jsonParametre.getValue("idUtilisateur"));
        String commentaire= jsonParametre.getValue("commentaire");
        int page= Integer.parseInt(jsonParametre.getValue("page"));
        String val=commentaireRepository.commenterDansListe(idVoiture, idUtilisateur, commentaire, page);
        return val;
    }
    
    @PostMapping(value="/ajoutcf")
    public String commenterDansFiche(@RequestBody String jsonParam) throws JsonProcessingException, Exception{
        JsonParameters jsonParametre = new JsonParameters(jsonParam);
        int idVoiture= Integer.parseInt(jsonParametre.getValue("idVoiture"));
        int idUtilisateur= Integer.parseInt(jsonParametre.getValue("idUtilisateur"));
        String commentaire= jsonParametre.getValue("commentaire");
        String val=commentaireRepository.commenterDansFiche(idVoiture, idUtilisateur, commentaire);
        return val;
    }
}
