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
    
    public void cumulDesSavoirs(Savoir pSavoir){
        
        for (int i = 0; i<pSavoir.messages.size(); i++){
            
            if (notIn(pSavoir.messages.get(i))){
                
                this.messages.add(pSavoir.messages.get(i));
                
            }
            
        }
        
        for (int j = 0; j<this.messages.size(); j++){
            
            if (pSavoir.notIn(this.messages.get(j))){
                
                pSavoir.messages.add(this.messages.get(j));
                
            }
            
        }
        
        
    }
    
    public boolean notIn(Message pMessage){
        
        boolean bool = true;
        
        for (int i = 0; i<this.messages.size(); i++){
            
            if (this.messages.get(i).getID() == pMessage.getID()){
                
                bool = false;
                
            }
        }
     
        return bool;
        
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
