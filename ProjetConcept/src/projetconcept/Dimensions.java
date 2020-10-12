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
public class Dimensions {
    
    private int longueurX;
    private int longueurY;
    
    public Dimensions(int pLongueurX, int pLongueurY){
        
        this.longueurX = pLongueurX;
        this.longueurY = pLongueurY;
        
    }
    
    public int getLongueurX(){
        
        return this.longueurX;
        
    }
    
    public int getLongueurY(){
        
        return this.longueurY;
        
    }
    
    public void setLongueurX(int pLongueurX){
        
        this.longueurX = pLongueurX;
        
    }
    
    public void setLongueurY(int pLongueurY){
        
        this.longueurY = pLongueurY;
        
    }
    
}
