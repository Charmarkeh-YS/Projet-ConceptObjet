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
abstract class EtreVivant {
    
    private final int PE_DE_BASE = 0;
    
    private Savoir savoir;
    private int pE;
    private Direction derniereDirection;
    private Alliance alliance;
    private Case caseCourante;
    private Carte carte;
        
    public EtreVivant(){      
        
        savoir = new Savoir();
        pE = PE_DE_BASE;
        derniereDirection = Direction.FIXE;
          
    }    
    
    public void move(){
        
                
        
    }
    
    public void changerCase(Case caseApres){
        
        this.caseCourante.vider();
        
        this.caseCourante = caseApres;
        
        this.caseCourante.setContenu(this);
        
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
    
}
