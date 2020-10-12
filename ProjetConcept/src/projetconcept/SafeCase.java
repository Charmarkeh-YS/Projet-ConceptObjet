/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetconcept;

import java.util.ArrayList;

/**
 *
 * @author Toine
 */
public class SafeCase extends Case{
    
    String espece;
    
    
    public SafeCase(){
        
        super();
        
    }
    
    public String getEspece(){
        
        return this.espece;
        
    }
    
    
    public void setEspece(String pEspece){
        
        this.espece = pEspece;
        
    }    
    
}
