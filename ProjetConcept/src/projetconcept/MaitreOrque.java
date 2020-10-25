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
 * Un MaitreOrque est un Orque (Singleton)
 */
public class MaitreOrque extends Orque{
    
    private static MaitreOrque maitreOrque;
    
    private MaitreOrque(Carte pCarte){
        
        super(pCarte);
        
    }
    
    public static MaitreOrque getInstance(Carte pCarte){
        
        if (maitreOrque == null){
            
            maitreOrque = new MaitreOrque(pCarte);
            
        }
        
        return maitreOrque;
        
    }
    
}
