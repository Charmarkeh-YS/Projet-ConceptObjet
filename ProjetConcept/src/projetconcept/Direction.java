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
    OUEST("Ouest", -1, 0),
    FIXE("Fixe", 0, 0);
    
    
    private final String nom;  
    private final int difX;     //Coordonnées du vecteur correspondant à la direction
    private final int difY;

    Direction(String nom, int pDifX, int pDifY){
        
        this.nom = nom;
        this.difX = pDifX;
        this.difY = pDifY;
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Méthode revoyant l'opposé d'une direction
    */
    
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
            
            case NORDOUEST : oppose = Direction.SUDEST;
            break;
            
            case SUDOUEST : oppose = Direction.NORDEST;
            break;          
      
        }
 
        return oppose;
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Méthode renvoyant les directions voisines
    */

    public Direction[] voisins(){
        
        Direction[] voisins = {Direction.FIXE, Direction.FIXE};
        
        switch(this){
            
            case EST : 
                voisins[0] = Direction.NORDEST;
                voisins[1] = Direction.SUDEST;                        
            break;
            
            case OUEST :
                voisins[0] = Direction.NORDOUEST;
                voisins[1] = Direction.SUDOUEST; 
            break;
            
            case NORD :
                voisins[0] = Direction.NORDEST;
                voisins[1] = Direction.NORDOUEST; 
            break;
            
            case SUD :
                voisins[0] = Direction.SUDEST;
                voisins[1] = Direction.SUDOUEST; 
            break;
            
            case NORDEST : 
                voisins[0] = Direction.NORD;
                voisins[1] = Direction.EST; 
            break;
            
            case SUDEST : 
                voisins[0] = Direction.EST;
                voisins[1] = Direction.SUD; 
            break;
            
            case NORDOUEST : 
                voisins[0] = Direction.NORD;
                voisins[1] = Direction.OUEST; 
            break;
            
            case SUDOUEST : 
                voisins[0] = Direction.OUEST;
                voisins[1] = Direction.SUD; 
            break;          
      
        }
 
        return voisins;
    
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
