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
public class Savoir {
    
    ArrayList<Message> messages;
    
    int nombreMessages;   
    
    
    public Savoir(){
        
                
        
    }
    
    
    public ArrayList<Message> getMessages(){
        
        return this.messages;
        
    }
    
    public int getNombreMessages(){
        
        return this.nombreMessages;
        
    }
    
    public void setMessages(ArrayList<Message> pMessages){
        
        this.messages = pMessages;
        
        
    }
    
    public void setNombreMessages(int pNombreMessages){
        
        this.nombreMessages = pNombreMessages;
        
    }
    
}
