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
 * Un Orque est un EtreVivant
 */
public class Orque extends EtreVivant{
    
    
    
    /**
    *
    * @author Toine
    * 
    * Constructeur
    */
    
    
    public Orque(Carte pCarte){
        
        super(pCarte);
        
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////
    
    @Override
    public String toString(){
        
        return "#";
        
    }
    
}
