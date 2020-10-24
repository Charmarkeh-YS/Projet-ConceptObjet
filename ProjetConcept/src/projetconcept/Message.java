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
public class Message {
    
    private int iD; /*id unique permetant de différencier les messages sans les comparer*/
    
    private String contenu;
    
    public Message(String pContenu, int pID){
        
        this.contenu = pContenu;
        this.iD = pID;
        
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Geters et Seters/////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    public int getID(){
        
        return this.iD;
        
    }
    
    public void setID(int pID){
        
        this.iD = pID;
        
    }
    
    public String getContenu(){
        
        return this.contenu;
        
    }
    
    public void setContenu(String pContenu){
        
        this.contenu = pContenu;
        
    }
    
}
