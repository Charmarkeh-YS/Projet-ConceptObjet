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
 * 
 * Une safe Case est une case
 */
public class SafeCase extends Case{
    
    private Object espece;
    private Savoir reservoir;
    
    
    public SafeCase(int pX, int pY){
        
        super(pX, pY);
        reservoir = new Savoir();
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Méthode permetant de recharger en Pe l'EtreVivant étant sur la SafeCase
    */
    
    public void rechargePe(){
        
        if (super.occupee){
            
            EtreVivant contenu = (EtreVivant) super.getContenu();
            
            contenu.setPE(contenu.getPE() + 5);
            
        }
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Méthode permetant de recolter le savoir des "non-maitre"
    */
    
    public void recolteSavoir(){
        
        if (this.occupee){
            
            EtreVivant tempEV = (EtreVivant) this.getContenu();
            
            tempEV.getSavoir().donnerSavoir(reservoir);
            
            
        }
        
        
    }
    
            
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Geters et Seters/////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    public Object getEspece(){
        
        return this.espece;
        
    }
    
    public Savoir getSavoir(){
        
        return this.reservoir;
        
    }
    
    
    public void setEspece(Object pEspece){
        
        this.espece = pEspece;
        
    }    
    
    public void setReservoir(Savoir pReservoir){
        
        this.reservoir = pReservoir;
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////    
    
    @Override
    public String toString(){
        
        String string = new String();
        
        if (this.isEmpty()){
            
            string = (String) super.getContenu();
            
            if (string == "-"){
                
                string = "=";
                
            }
            
        }
        
        if (this.occupee){
            
            EtreVivant temp = (EtreVivant) super.getContenu();
            
            string = temp.toString();
            
        }
        
        return string;
        
    }
    
}
