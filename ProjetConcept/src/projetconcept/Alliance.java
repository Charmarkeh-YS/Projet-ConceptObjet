/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetconcept;

/**
 *
 * @author Toine
 * 
 * Enumération des Alliances
 */
enum Alliance {
    
    ATEAM("Equipe A"),
    BTEAM("Equipe B");      
    
    private final String nom;  

    Alliance(String nom){
        
        this.nom = nom;    
        
    }

    public String getNom(){
        
        return this.nom; 
        
    }
    
}
