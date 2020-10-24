package projetconcept;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Toine
 * 
 * Un Elfe est un EtreVivant
 */
public class Elfe extends EtreVivant{
    
     /**
    *
    * @author Toine
    * 
    * Constructeur
    */
    
    public Elfe(Carte pCarte){
        
        super(pCarte, Direction.SUDEST);        //La SafeZone des Elfes est localisée au Sud Est
        
    }
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////
    
    @Override
    public String toString(){
        
        return "+";
        
    }
    
}
