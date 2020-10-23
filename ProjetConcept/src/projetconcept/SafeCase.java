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
        
        super(pX, pY);
        
    }
    
    public void rechargePe(){
        
        if (super.occupee){
            
            EtreVivant contenu = (EtreVivant) super.getContenu();
            
            contenu.setPE(contenu.getPE() + 10);
            
        }
        
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
    
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////    
    
    @Override
    public String toString(){
        
        String string = new String();
        
        if (this.isEmpty()){
            
            string = (String) super.getContenu();
            
            if (string == "-"){
                
                string = "=";
                
            }
            
        }
        
        if (this.occupee){
            
            EtreVivant temp = (EtreVivant) super.getContenu();
            
            string = temp.toString();
            
        }
        
        return string;
        
    }
    
}
