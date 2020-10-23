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
 */
abstract class EtreVivant {
    
    Aleatoire AJE;      /*Instance de la classe Aléatoire qui nous servira pour tous nos bessoins en terme de hasard*/
    
    private final int PE_DE_BASE = 100;     /*Nombre de PE  à la création d'un etre vivant*/
    private final int PE_CRITIQUE = 10;     /*Nombre de PE e dessous duquel l'etre vivant retoure à sa safezone*/
    
    private Savoir savoir;      /*Instance d'un objet Savoir qui contient les messages connus par l'etre vivant*/
    private int pE;             /*Nombre de PE actuel*/
    private Direction derniereDirection;    /*Derniere direction prise*/
    private Alliance alliance;              /*Alliance à laquelle apartient l'etre vivant*/
    private Case caseCourante;              /*Case actuelle occupé par l'etre vivant*/
    private Carte carte;                    /*Carte du jeu sur lequel se trouve l'etre vivant*/
    private ArrayList<EtreVivant> dernieresRencontres;
    private Direction directionSafeZone;
    
        
    
    /**
    *
    * @author Toine
    * 
    * Constructeur, un etre vivant doit etre sur une carte
    */
    
    public EtreVivant(Carte pCarte, Direction pDirectionSafeZone){      
        
        savoir = new Savoir();
        pE = PE_DE_BASE;
        derniereDirection = Direction.FIXE;
        carte = pCarte;
        caseCourante = new Case();
        dernieresRencontres = new ArrayList<>();
        directionSafeZone = pDirectionSafeZone;  
        
    }    
    
    /**
    *
    * @author Toine
    * 
    * Methode lance le tour d'un etre vivant
    */
    
    public void move(){
        
        System.out.println("Reste PE" + this.pE);
        
        boolean flag = false;
        
        int tours = 0;
        
        while(!flag){
            
            flag = this.changerCase(this.prochaineCase());
            tours++;
            
        }       
         
       System.out.println("Nb tours RecercheMessage" + tours);
    }
    
    
    /**
    *
    * @author Toine
    * @param autre Etre vivant que l'on rencontre
    * 
    * 
    * Methode définissant la rencontre avec un autre etre vivant, trois cas possible:
    *
    *   - Meme espece : On cumul nos savoirs
    *   - Autre Expece Meme alliance : On partage un peu de savoir 
    *   - Autre Espece autre Alliance : Un des deux prend du savoir de l'autre
    *
    */
    
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
            
            this.savoir.confrontationDesSavoir(autre.getSavoir());
            
        }
        
        autre.addRencontre(this);
        this.dernieresRencontres.add(autre);
        
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////Méthodes Secondaires/////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
    *
    * @author Toine
    * @param caseApres Case sur laquelle on veut se rendre
    * @return On retourne un flage true si on a pas pu effectuer le changement
    * 
    * Cette méthode effectue le changement de case, on libere notre case puis on se met sur une autre
    */
    
    public boolean changerCase(Case caseApres){     
        
        boolean flag = false;
        this.derniereDirection = this.caseCourante.directionAPrendre(caseApres);
        
        if (caseApres.isEmpty()){
        
            this.caseCourante.vider();
            
            this.caseCourante.occupee = false;
        
            this.caseCourante = caseApres;
        
            this.caseCourante.setContenu(this);
            
            this.caseCourante.occupee = true;
            
            this.pE = pE - 1;
            
            if (this.caseCourante.getClass() == SafeCase.class && this.pE < PE_CRITIQUE){
                
                flag = true;
                
            }
                   
        }
        
        else{
            
            flag = true;
            
            if (caseApres.occupee && notInDernieresRencontres((EtreVivant) caseApres.getContenu())){
                
                rencontrer((EtreVivant) caseApres.getContenu());
                
            }
            
        }
        
        return flag;
        
    }
    
    
    
    
        /**
    *
    * @author Toine
    * 
    * Methode choisissant aléatoirement la prochaine case sur laquelle on va essayer de se rendre
    */
    
    public Case prochaineCase(){
  
        Case prochaineCase = new Case();
        
        if (pE >= PE_CRITIQUE){
        
            Random random = new Random();
        
            ArrayList<Case> voisins = this.carte.voisins(this.caseCourante, derniereDirection);
              
            prochaineCase = voisins.get(random.nextInt(voisins.size()));
        
        }
        
        else{
            
            prochaineCase = this.carte.cheminDirection(this.caseCourante, this.directionSafeZone);
            
        }
        
        return prochaineCase;
        
    }
    
     
    
    public boolean notInDernieresRencontres(EtreVivant pEtreVivant){
        
        boolean bool = true;
        
        for (int i = 0; i < dernieresRencontres.size(); i++){
            
            if (pEtreVivant == dernieresRencontres.get(i)){
                
                bool = false;
                
            }
            
            
        }      
        
        return bool;
        
    }
    
    public void addRencontre(EtreVivant autre){
        
        this.dernieresRencontres.add(autre);
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Geters et Seters/////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
     
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
    
        
    ////////////////////////////////////////////////////////////////////////////
    //////////Redefinission des fonctions de base (Equal, toString...)//////////
    ////////////////////////////////////////////////////////////////////////////
    
    @Override
    public abstract String toString();
    
}
