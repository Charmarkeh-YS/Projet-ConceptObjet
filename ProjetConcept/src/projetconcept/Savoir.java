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
    
    Aleatoire AJE = new Aleatoire();       /*Instance de la classe Aléatoire qui nous servira pour tous nos bessoins en terme de hasard*/
    
    private ArrayList<Message> messages;        /*Liste des messages qui constituent le Savoir*/
    
    
    /**
    *
    * @author Toine
    * 
    * Constructeur
    */
    
    
    public Savoir(){
        
        messages = new ArrayList();
        
    }
    
    public Savoir(ArrayList<Message> liste){
        
        messages = new ArrayList();
        messages = liste;
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Methode permettant de se cumuler à un autre savoir
    */
    
    public void cumulDesSavoirs(Savoir pSavoir){
        
        System.out.println("Cumul");       
        
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
    * Methode permettant de donner ton son savoir (En le conservant)
    */
    
    public void donnerSavoir(Savoir pSavoir){
        
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
        
        System.out.println("Partage partiel");       
        
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
        
        System.out.println("Confrontation");        
        
        if (AJE.pileOuFace()){
            
            for (int i = 0; i<pSavoir.messages.size(); i++){
            
                if (notIn(pSavoir.messages.get(i))){
                
                    this.messages.add(pSavoir.messages.get(i));
                    pSavoir.perdreMessage(pSavoir.messages.get(i).getID());
                
                }
            
            }
            
        }
        
        else{
            
            for (int j = 0; j<this.messages.size(); j++){
            
            if (pSavoir.notIn(this.messages.get(j))){
                
                pSavoir.messages.add(this.messages.get(j));
                this.perdreMessage(this.messages.get(j).getID());
                
            }
            
        }
            
        }
        
        
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    //////////////////////////Méthodes Secondaires//////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    
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
                i = i - 1;
                
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
    
    
    public void setMessages(ArrayList<Message> pMessages){
        
        this.messages = pMessages;
        
        
    }   
    
    
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////    
    
    @Override
    public String toString(){
        
        String savoir = "Nombre de messages : " + this.messages.size() + "  ";
        
        for (int i = 0; i < this.messages.size(); i++){
            
            savoir = savoir + this.messages.get(i).getContenu() + " | ";
            
        }
        
        return savoir;
        
    }
    
}
