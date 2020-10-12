/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetconcept;

import java.util.ArrayList;

/**
 *
 * @author Toine
 */
public class Carte {
    
    private ArrayList<Case> cases;
    private Dimensions dimensions;
    
    public Carte(Dimensions pDimenssions){
        
        dimensions = pDimenssions;
        
        cases = creationCases(dimensions);
        
    }
    
    public ArrayList<Case> creationCases(Dimensions pDimenssionsCarte){
        
        ArrayList<Case> listeCases = new ArrayList<>();
        
        /*Reste à faire*/
        
        return listeCases;        
        
    }
    
    public ArrayList<Case> getCases(){
        
        return this.cases;
        
    }
    
    public Dimensions getDimensions(){
        
        
        return this.dimensions;
        
    }
}
