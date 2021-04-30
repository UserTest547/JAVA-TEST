/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api.Controller;

import GetParametersPost.JsonParameters;
import com.example.Api.repository.UtilisateurRepository;
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
@RequestMapping(path="/utilisateur",produces={"application/json"})
@CrossOrigin(origins="*")
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @PostMapping(value="/login")
    public String login(@RequestBody String jsonParam)throws Exception{
        String val="";
        try{
            JsonParameters jsonParametre = new JsonParameters(jsonParam);
            String login= jsonParametre.getValue("login");
            String mdp= jsonParametre.getValue("motDePasse");
            val=this.utilisateurRepository.login(login, mdp);
            return val;
        }
        catch(Exception e){
            throw e;
        }
    }         
}
