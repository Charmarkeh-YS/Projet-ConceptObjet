/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetconcept;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Toine
 * 
 * Boite à outils du Hasard
 */
public class Aleatoire {
    
    public boolean pileOuFace(){
        
        boolean bool = true;
        
        if (Math.random() < 0.5){
            
            bool = false;
            
        }
        
        return bool;
        
    }
    
    public int piocheCase(ArrayList<Case> liste){
        
        int taille = liste.size();
        
        Random random = new Random();
        
        return random.nextInt(taille - 1);
        
    }
    
}
