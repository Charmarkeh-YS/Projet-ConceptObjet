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
enum Direction {
    
    NORD("Nord"),
    NORDEST("Nord-Est"),
    NORDOUEST("Nord-Ouest"),
    SUD("Sud"),
    SUDEST("Sud-Est"),
    SUDOUEST("Sud-Ouest"),
    EST("Est"),
    OUEST("Ouest"),
    FIXE("Fixe");
    
    
    private final String nom;  

    Direction(String nom){
        
        this.nom = nom;    
        
    }

    public String getNom(){
        
        return this.nom; 
        
    }
    
}
