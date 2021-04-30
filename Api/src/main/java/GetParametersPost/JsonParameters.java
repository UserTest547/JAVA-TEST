/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetParametersPost;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//classe pour la prise en main des parametres donnee en json

/**
 *
 * @author SAFIDY
 */
public class JsonParameters {
    String json;
    public JsonParameters(String json)
    {
        this.json=json;
    }
    public String getValue(String attribut) throws JsonProcessingException
    {
        String val ="";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(this.json);
        val = jsonNode.path(attribut).asText();
        return val;
    }
}
