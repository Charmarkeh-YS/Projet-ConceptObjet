/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetconcept;

/**
 *
 * @author Toine
 */
public class Aleatoire {
    
    public boolean pileOuFace(){
        
        boolean bool = true;
        
        if (Math.random() < 0.5){
            
            bool = false;
            
        }
        
        return bool;
        
    }
    
}
