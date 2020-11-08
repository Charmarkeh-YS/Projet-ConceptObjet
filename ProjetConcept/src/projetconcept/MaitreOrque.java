/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetconcept;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Toine
 * 
 * Un MaitreOrque est un Orque (Singleton)
 */
public class MaitreOrque extends Orque{
    
    private static MaitreOrque maitreOrque;
    
    private MaitreOrque(Carte pCarte){
        
        super(pCarte);
        
    }
    
    public static MaitreOrque getInstance(Carte pCarte){
        
        if (maitreOrque == null){
            
            maitreOrque = new MaitreOrque(pCarte);
            
        }
        
        return maitreOrque;
        
    }
    
    @Override
    public void move(){
        
        System.out.println("-------------------------------------------------Debut tour de : " + this + " Reste PE : " + this.getPE() + " X : " + this.getCaseCourante().getX() + " Y : " + this.getCaseCourante().getY() + this.getDerniereDirection() + "--------------------------------------------------------------");        
        
        this.getCarte().afficherCarte();
        
        boolean flag = false;
        
        Case tempCase = this.getCaseCourante();
        
        int tours = 0;
        
        while(!flag && tours < 10){                      
        
            flag = this.changerCase(this.prochaineCase());
            
            tours++;
           
        }       
                
        
        
        this.getCarte().afficherCarte();       
        
        System.out.println("----------------------------------------------------------------------------Fin Tour----------------------------------------------------------------------------\n");
        
    }
    
    
    @Override
    public boolean changerCase(Case caseApres){     
        
        boolean flag = false;
        
        if (!caseApres.occupee){
        
            this.getCaseCourante().vider();
            
            this.getCaseCourante().occupee = false;
        
            this.setCaseCourante(caseApres);
        
            this.getCaseCourante().setContenu(this);
            
            this.getCaseCourante().occupee = true;
            
            this.setPE(this.getPE() - 1);            
                
            recupererSavoir(this.getCaseCourante());
                   
        }
        
        else{
            
            flag = true;
            
        }
        
        
        return flag;
        
    }
    
    @Override
    public Case prochaineCase(){
  
        Case prochaineCase = this.getCaseCourante();
                
        boolean bool = true;
        
        Random random = new Random();
        
        while (bool){
        
            ArrayList<Case> voisins = this.getCarte().voisins(this.getCaseCourante(), Direction.FIXE);
            
            int idCase = random.nextInt(voisins.size());
            
            if (voisins.get(idCase).getClass() == SafeCase.class){
                            
                prochaineCase = voisins.get(idCase);
                
                bool = false;
            
            }       
        
        }
        
        return prochaineCase;
        
    }
    
    public void recupererSavoir(Case pCase){
        
        SafeCase tempSC = (SafeCase) pCase;
            
        tempSC.getSavoir().donnerSavoir(this.getSavoir());
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////
    
    @Override
    public String toString(){
        
        return "O";
        
    }
    
}
