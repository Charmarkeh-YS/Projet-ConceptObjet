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
abstract class EtreVivant {
    
    Aleatoire AJE;
    
    private final int PE_DE_BASE = 100;
    private final int PE_CRITIQUE = 10;
    
    private Savoir savoir;
    private int pE;
    private Direction derniereDirection;
    private Alliance alliance;
    private Case caseCourante;
    private Carte carte;
        
    public EtreVivant(Carte pCarte){      
        
        savoir = new Savoir();
        pE = PE_DE_BASE;
        derniereDirection = Direction.FIXE;
        carte = pCarte;
        caseCourante = new Case();
          
    }    
    
    public void move(){
        
        if (pE > PE_CRITIQUE){
            
            this.rechercheMessages();
            
        }
        
        else{
            
            this.retourSafeZone();
            
        }                
        
    }
    
    public boolean changerCase(Case caseApres){
        
        boolean flag = false;
        
        if (caseApres.isEmpty()){
        
            this.caseCourante.vider();
            
            this.caseCourante.occupee = false;
        
            this.caseCourante = caseApres;
        
            this.caseCourante.setContenu(this);
            
            this.caseCourante.occupee = true;
        
        }
        
        else{
            
            flag = true;
            
        }
        
        return flag;
        
    }
    
    public void rencontrer(EtreVivant autre){
        
        if (this.alliance == autre.alliance){
            
            if(autre.getClass().getName() == this.getClass().getName()){
                
                this.savoir.cumulDesSavoirs(autre.getSavoir());
            }
            
            else{
                
                this.savoir.partagePartielDesSavoir(autre.getSavoir());
                
            }
            
        }
        
        else{
            
            this.savoir.cumulDesSavoirs(autre.getSavoir());
            
        }
        
    }
    
    public void retourSafeZone(){
        
        
        
    }
    
    public void rechercheMessages(){
        
        boolean flag = false;
        
        while(scanAlentours().isEmpty() && flag){
            
            flag = this.changerCase(this.prochaineCase());
            
        }
        
        for (int i = 0; i < scanAlentours().size(); i++){
            
            rencontrer((EtreVivant) scanAlentours().get(i).getContenu());
            
        }       
        
    }
    
    public Case prochaineCase(){
  
        ArrayList<Case> voisins = this.carte.voisons(this.caseCourante);
              
        return voisins.get(AJE.piocheCase(voisins));
        
    }
    
    public ArrayList<Case> scanAlentours(){
        
        ArrayList<Case> voisins = this.carte.voisons(this.caseCourante);
        
        ArrayList<Case> casesOccupees = new ArrayList<>();
        
        for (int i = 0; i< voisins.size(); i++){
            
            if (voisins.get(i).occupee){
                
                casesOccupees.add(voisins.get(i));
                
            }
            
        }
        
        return casesOccupees;
        
    }
   
     
    public int getPE(){
        
        return this.pE;
        
    }
    
    public Savoir getSavoir(){
        
        return this.savoir;
        
    }
    
    public Direction getDerniereDirection(){
        
        return this.derniereDirection;
        
    }
    
    public Alliance getAlliance(){
        
        return this.alliance;
        
    }
    
    public Case getCaseCourante(){
        
        return this.caseCourante;
        
    }
    
    public Carte getCarte(){
        
        return this.carte;
        
    }
    
    public void setPE(int pPE){
        
        this.pE = pPE;
        
    }
    
    public void setSavoir(Savoir pSavoir){
        
        this.savoir = pSavoir;
        
    }
    
    public void setDerniereDirection(Direction pDerniereDirection){
        
        this.derniereDirection = pDerniereDirection;
        
    }
    
    public void setAlliance(Alliance pAlliance){
        
        this.alliance = pAlliance;
        
    }
    
    public void setCaseCourante(Case pCaseCourante){
        
        this.caseCourante = pCaseCourante;
        
    }
    
    public void setCarte(Carte pCarte){
        
        this.carte = pCarte;
        
    }
    
    @Override
    public abstract String toString();
    
}
