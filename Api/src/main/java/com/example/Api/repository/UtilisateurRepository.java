/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Api.repository;

import Classes.Utilisateur;
import ReponseService.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SAFIDY
 */
@Repository
public class UtilisateurRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
//    connexion
    private int countlogin(String utilisateur,String mdp)throws Exception
    {
        String requetes = "select count(*) as nombre from utilisateur where LOGIN='"+utilisateur+"' and MOTDEPASSE='"+mdp+"'";
        int query = jdbcTemplate.queryForObject(requetes,Integer.class);
        return query;
    }
    private boolean existelogin(String utilisateur)throws Exception
    {   boolean val = false;
        String requetes = "select count(*) as nombre from utilisateur where LOGIN='"+utilisateur+"'";
        int query = jdbcTemplate.queryForObject(requetes,Integer.class);
        int nb = query;
        if(nb==1)
        {
            val=true;
        }
        else if(nb==0)
        {
            val=false;
        }
        return val;
    }
    public String login(String login, String mdp) throws Exception {
        String reponse="";
        ReponseService reponseService = new ReponseService("","",null);
        boolean val=false;
        boolean existeLogin = existelogin(login);
        System.out.println("");
        if(existeLogin==false)
        {
            reponseService.setStatut("not_ok");
            reponseService.setDonnee(val);
            reponseService.setMessage("Verifier le nom d'utilisateur et/ou mot de passe");
        }
        else if(existeLogin==true){
            int testLogin = countlogin(login, mdp);
            if(testLogin==1)
            {
                reponseService.setStatut("ok");
                reponseService.setMessage("Connexion reussie");
                Utilisateur detailUserSession = this.findUtilisateurByLogin(login, mdp);
                reponseService.setDonnee(detailUserSession);
            }
            if(testLogin==0)
            {
                val=false;
                reponseService.setStatut("not_ok");
                reponseService.setDonnee(val);
                
                if("".equals(mdp))
                {
                    reponseService.setMessage("Tapez le mot de passe");
                }
                else{   
                reponseService.setMessage("Mot de passe incorrecte!");
                }
            }
        }
        //convertir les donnee en json
        reponse = reponseService.getReponseJson();
        return reponse;
    }
    private Utilisateur findUtilisateurByLogin(String login,String mdp)throws Exception{
        Utilisateur val = new Utilisateur();
        String requetes = "select*from utilisateur where LOGIN='"+login+"' and MOTDEPASSE='"+mdp+"'";
        System.out.println("requetes findutilisateurByLogin= "+requetes);
        val = jdbcTemplate.queryForObject(requetes, val.mapperUtilisateur);
        return val;
    }
}
