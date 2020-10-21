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
 * 
 * Une safe Case est une case
 */
public class SafeCase extends Case{
    
    String espece;
    
    
    public SafeCase(int pX, int pY){
        
        super();
        
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Geters et Seters/////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    public String getEspece(){
        
        return this.espece;
        
    }
    
    
    public void setEspece(String pEspece){
        
        this.espece = pEspece;
        
    }    
    
}
