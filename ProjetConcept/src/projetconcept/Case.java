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
public class Case {
    
    private int x;
    private int y;
    
    private Object contenu;
    
    public Case(){
               
        
    }
        
    public int getX(){
        
        return this.x;
        
    }
    
    public int getY(){
        
        return this.y;
        
    }
    
    public Object getContenu(){
        
        return this.contenu;
        
    }
    
    public void setX(int pX){
        
        this.x = pX;
        
    }
    
    public void setY(int pY){
        
        this.y = pY;
        
    }
    
    public void setContenu(Object pContenu){
        
        this.contenu = pContenu;
        
    }
    
}
