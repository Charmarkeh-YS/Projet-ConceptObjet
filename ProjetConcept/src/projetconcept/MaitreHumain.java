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
 * Un MaitreHumain est un Humain (Singleton)
 */
public class MaitreHumain extends Humain{
    
    private static MaitreHumain maitreHumain;
    
    private MaitreHumain(Carte pCarte){
        
        super(pCarte);
        
    }
    
    public static MaitreHumain getInstance(Carte pCarte){
        
        if (maitreHumain == null){
            
            maitreHumain = new MaitreHumain(pCarte);
            
        }
        
        return maitreHumain;
        
    }
    
}
