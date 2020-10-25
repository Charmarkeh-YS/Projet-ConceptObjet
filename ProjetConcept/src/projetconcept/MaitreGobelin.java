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
 * Un MaitreGobelin est un Gobelin (Singleton)
 */
public class MaitreGobelin extends Gobelin{
    
    private static MaitreGobelin maitreGobelin;
    
    private MaitreGobelin(Carte pCarte){
        
        super(pCarte);
        
    }
    
    public static MaitreGobelin getInstance(Carte pCarte){
        
        if (maitreGobelin == null){
            
            maitreGobelin = new MaitreGobelin(pCarte);
            
        }
        
        return maitreGobelin;
        
    }
    
}
