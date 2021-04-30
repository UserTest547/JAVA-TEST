/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//------------------------------------------
//classe pour la reponse des donnees en json
//-----------------------------------------
package ReponseService;

import com.google.gson.Gson;

/**
 *
 * @author SAFIDY
 */
public class ReponseService{
    private String statut;
    private String message;
    private Object donnee;
    
    public String valiny;

    public ReponseService(String statut, String message, Object donnee) {
        this.statut = statut;
        this.message = message;
        this.donnee = donnee;
    }

    public ReponseService() {
        
    }
    
    //pour convertir les reponses en json
    public String getReponseJson()
    {
        Gson json = new Gson();
        if(this.donnee==null)
        {
            this.donnee="empty";
        }
        this.valiny = json.toJson(this);
        return this.valiny;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDonnee() {
        return donnee;
    }

    public void setDonnee(Object donnee) {
        this.donnee = donnee;
    }
    
    
}
