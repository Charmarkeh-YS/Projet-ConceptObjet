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
    
    private int x;      /*Coordonnées en X et en Y*/
    private int y;
    
    boolean occupee;    /*Boolean indiquant si la case est occupée par un ETRE VIVANT, ainsi si un obstacle est dessous, occupee = false*/
    
    private Object contenu;     /*contenu de la case*/
    
    /**
    *
    * @author Toine
    * 
    * Constructeur
    */
    
    public Case(){
        
        this.vider();
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Constructeur
    */
    
    public Case(int pX, int pY){
               
        this.x = pX;
        this.y = pY;
        this.vider();
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Méthode permettant de vider la case, on remarque qu'on ne change pas l'occupation (pour l'instant ?)
    */
    
    public void vider(){
        
        this.contenu = VIDE;
        
    }
    
    
    /**
    *
    * @author Toine
    * 
    * Méthode permetant de savoir si une case est vide
    */
    
    public boolean isEmpty(){
        
        boolean bool = false;
        
        if (this.contenu == VIDE){
            
            bool = true;
            
        }
        
        return bool;
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Méthode La direction dans la laquelle se trouve la case cible (La cible doit etre voisine)
    */
    
    public Direction directionAPrendre(Case caseCible){
        
        Direction direction = Direction.FIXE;
        
        int difX = caseCible.getX() - this.getX();
        int difY = caseCible.getY() - this.getY();
        
        for (int i = 0; i < Direction.values().length; i++){
            
            if (Direction.values()[i].getDifX() == difX && Direction.values()[i].getDifY() == difY)            
            
                direction = Direction.values()[i];
                
        }        
     
        return direction;     
  
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Geters et Seters/////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
        
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
    
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////
    
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
