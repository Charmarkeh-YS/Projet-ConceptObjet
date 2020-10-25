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
 * Un Gobelin est un EtreVivant
 */
public class Gobelin extends EtreVivant{
    
    
    /**
    *
    * @author Toine
    * 
    * Constructeur
    */
    
    public Gobelin(Carte pCarte){
        
        super(pCarte, Direction.SUDOUEST);      //La SafeZone des Gobelins est localisée au Sud Ouest
        super.setAlliance(Alliance.BTEAM);
        
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////
    
    @Override
    public String toString(){
        
        return "€";
        
    }
    
}
