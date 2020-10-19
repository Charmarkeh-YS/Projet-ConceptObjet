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
    
    private final String VIDE = "-";
    
    private int x;
    private int y;
    
    boolean occupee;
    
    private Object contenu;
    
    public Case(){
        
        this.vider();
        
    }
    
    public Case(int pX, int pY){
               
        this.x = pX;
        this.y = pY;
        this.vider();
        
    }
    
    public void vider(){
        
        this.contenu = VIDE;
        
    }
    
    public boolean isEmpty(){
        
        boolean bool = false;
        
        if (this.contenu == VIDE){
            
            bool = true;
            
        }
        
        return bool;
        
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
    
    @Override
    public String toString(){
        
        String string = new String();
        
        if (this.isEmpty()){
            
            string = (String) this.contenu;
            
        }
        
        if (this.occupee){
            
            EtreVivant temp = (EtreVivant) this.contenu;
            
            string = temp.toString();
            
        }
        
        return string;
        
    }
    
}
