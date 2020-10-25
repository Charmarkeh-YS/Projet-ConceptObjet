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
 * Un MaitreElfe est un Elfe (Singleton)
 */
public class MaitreElfe extends Elfe{
    
    private static MaitreElfe maitreElfe;
    
    private MaitreElfe(Carte pCarte){
        
        super(pCarte);
        
    }
    
    public static MaitreElfe getInstance(Carte pCarte){
        
        if (maitreElfe == null){        
            
            maitreElfe = new MaitreElfe(pCarte);
            
        }                
        
        return maitreElfe;
        
    }
    
}
