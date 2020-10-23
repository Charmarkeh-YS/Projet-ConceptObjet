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
 * Enumération des directions possibles
 */
enum Direction {
    
    NORD("Nord", 0, 1),
    NORDEST("Nord-Est", 1, 1),
    NORDOUEST("Nord-Ouest", -1, 1),
    SUD("Sud", 0, -1),
    SUDEST("Sud-Est", 1, -1),
    SUDOUEST("Sud-Ouest", -1, -1),
    EST("Est", 1, 0),
    OUEST("Ouest", -1, -1),
    FIXE("Fixe", 0, 0);
    
    
    private final String nom;  
    private final int difX;
    private final int difY;

    Direction(String nom, int pDifX, int pDifY){
        
        this.nom = nom;
        this.difX = pDifY;
        this.difY = pDifX;
        
    }
    
    public Direction oppose(){
        
        Direction oppose = Direction.FIXE;
        
        switch(this){
            
            case EST : oppose = Direction.OUEST;
            break;
            
            case OUEST : oppose = Direction.EST;
            break;
            
            case NORD : oppose = Direction.SUD;
            break;
            
            case SUD : oppose = Direction.NORD;
            break;
            
            case NORDEST : oppose = Direction.SUDOUEST;
            break;
            
            case SUDEST : oppose = Direction.NORDOUEST;
            break;
            
            case NORDOUEST : oppose = Direction.NORDEST;
            break;
            
            case SUDOUEST : oppose = Direction.SUDEST;
            break;          
      
        }
 
        return oppose;
        
    }

    public String getNom(){
        
        return this.nom; 
        
    }
    
    public int getDifX(){
        
        return this.difX; 
        
    }
    
    public int getDifY(){
        
        return this.difY; 
        
    }
}
