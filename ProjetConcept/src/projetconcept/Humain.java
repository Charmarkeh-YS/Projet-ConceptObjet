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
public class Humain extends EtreVivant {
    
    public Humain(Carte pCarte){
        
        super(pCarte);
        
    }
    
    
    @Override
    public String toString(){
        
        return "@";
        
    }
    
}
