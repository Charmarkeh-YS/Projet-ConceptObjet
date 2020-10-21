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
    
    Aleatoire AJE;       /*Instance de la classe Aléatoire qui nous servira pour tous nos bessoins en terme de hasard*/
    
    ArrayList<Message> messages;        /*Liste des messages qui constituent le Savoir*/
    
    int nombreMessages;             /*Nombre de Messages contenus*/
    
    
    /**
    *
    * @author Toine
    * 
    * Constructeur
    */
    
    
    public Savoir(){
        
        messages = new ArrayList();
        
        nombreMessages = 0;
        
    }
    
    
    /**
    *
    * @author Toine
    * 
    * Methode permettant de se cumuler à un autre savoir
    */
    
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
    
    
    /**
    *
    * @author Toine
    * 
    * Methode permetant de se cumuler partiellement à un autre Savoir
    */
    
    
    public void partagePartielDesSavoir(Savoir pSavoir){
        
        for (int i = 0; i<pSavoir.messages.size(); i++){
            
            if (notIn(pSavoir.messages.get(i)) && AJE.pileOuFace()){
                
                this.messages.add(pSavoir.messages.get(i));
                
            }
            
        }
        
        for (int j = 0; j<this.messages.size(); j++){
            
            if (pSavoir.notIn(this.messages.get(j)) && AJE.pileOuFace()){
                
                pSavoir.messages.add(this.messages.get(j));
                
            }
            
        }
        
        
    }
    
    
    /**
    *
    * @author Toine
    * 
    * Methode permettant transferer des messages d'un Savoir à un autre aléatoirement
    */
    
    public void confrontationDesSavoir(Savoir pSavoir){
        
        
        if (AJE.pileOuFace()){
            
            for (int i = 0; i<pSavoir.messages.size(); i++){
            
                if (notIn(pSavoir.messages.get(i)) && AJE.pileOuFace()){
                
                    this.messages.add(pSavoir.messages.get(i));
                    pSavoir.perdreMessage(pSavoir.messages.get(i).getID());
                
                }
            
            }
            
        }
        
        else{
            
            for (int j = 0; j<this.messages.size(); j++){
            
            if (pSavoir.notIn(this.messages.get(j)) && AJE.pileOuFace()){
                
                pSavoir.messages.add(this.messages.get(j));
                this.perdreMessage(this.messages.get(j).getID());
                
            }
            
        }
            
        }
        
        
    }
    
    
    /**
    *
    * @author Toine
    * 
    * Methode permetant de retirer un message du savoir
    */
    
    public void perdreMessage(int messageID){
        
        for (int i = 0; i < this.messages.size(); i++){
            
            if (this.messages.get(i).getID() == messageID){
                
                this.messages.remove(i);
                
            }
            
        }        
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Méthode permetant de savoir si un message n'est PAS présent dans le Savoir
    */
    
    public boolean notIn(Message pMessage){
        
        boolean bool = true;
        
        for (int i = 0; i<this.messages.size(); i++){
            
            if (this.messages.get(i).getID() == pMessage.getID()){
                
                bool = false;
                
            }
        }
     
        return bool;
        
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Geters et Seters/////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
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
