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
 * Un Humain est un EtreVivant
 */
public class Humain extends EtreVivant {
    
    
    /**
    *
    * @author Toine
    * 
    * Constructeur
    */
    
    public Humain(Carte pCarte){
        
        super(pCarte, Direction.NORDEST);   //La SafeZone des Humains est localisée au Nord Est
        super.setAlliance(Alliance.ATEAM);
        
    }
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////
    
    @Override
    public String toString(){
        
        return "@";
        
    }
    
}
