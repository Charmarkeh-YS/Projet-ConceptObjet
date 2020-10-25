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
    private ArrayList<EtreVivant> dernieresRencontres;      //Derniers EtreVivants croisés, mis à jour à la fin de chaque tours
    private Direction directionSafeZone;        //Direction à suivre pour rejoindre la safe-zone
    
        
    
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
        
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&Debut tour de : " + this + " Reste PE : " + this.pE + " X : " + this.caseCourante.getX() + " Y : " + this.caseCourante.getY() + this.directionSafeZone + "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");        
        
        
        int nombreRencontres = this.dernieresRencontres.size();     //Variable qui servira à mettre à jour la liste des dernieres rencontres
        
        this.carte.afficherCarte();     //on affiche la carte de début de tour
        
        boolean flag = false;       //quand ce flag est true on arrete le tour, on ne change plus de case
        
        Case tempCase = this.caseCourante;      //Ces deux variables        
        int tourneEnRond = 0;                   //Servent à savoir si on stagne, si c'est le cas on arretera le tour en ce disant que la situation aura évoluée au tour suivant
        
        while(!flag){                                  
            
            flag = this.changerCase(this.prochaineCase());      //Action principale de cette méthode, on change de case
            
            if (tempCase == caseCourante){
                
                tourneEnRond++;
                
                if (tourneEnRond > 10){     //Si on stagne pendant 10 essais on s'arrete là
                    
                    flag = true;
                    
                }
                
            }
            
            else{
                
                tempCase = caseCourante;
                
            }
           
        }       
                
        if (nombreRencontres < this.dernieresRencontres.size()){
            
            //Les rencontres effectuées au tour précédent son éffacées
            
            for (int i = 0; i < this.dernieresRencontres.size() - nombreRencontres; i++){
                
                this.dernieresRencontres.remove(i);
                i = i - 1;
                
            }
            
        }
        
        //on afiche la carte en fin de tour
        
        this.carte.afficherCarte();
        
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
        
        this.carte.afficherCarte();
        
        System.out.println("Rencontre avec : " + autre);
        System.out.println("Savoir avant Rencontre : ");
        System.out.println(this + " " + this.savoir.toString());
        System.out.println(autre + " " + autre.getSavoir().toString());
        
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
        
        //On ajoute la rencontre à la liste des dernieres rencontres
        this.dernieresRencontres.add(autre);
        
        System.out.println("Savoirs aprés rencontre :");
        System.out.println(this + " " + this.savoir.toString());
        System.out.println(autre + " " + autre.getSavoir().toString());
        
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
        
        //System.out.println("Tour de : " + this + " Reste PE : " + this.pE + " X : " + this.caseCourante.getX() + " Y : " + this.caseCourante.getY());
        
        //System.out.println("Tentative pour atteindre : " + caseApres.getX() + " / " + caseApres.getY());
        
        if(!(caseApres.getClass() == SafeCase.class)){
            
            if (caseApres.isEmpty()){
        
                this.caseCourante.vider();
            
                this.caseCourante.occupee = false;
        
                this.caseCourante = caseApres;
        
                this.caseCourante.setContenu(this);
            
                this.caseCourante.occupee = true;
            
                this.pE = pE - 1;            
                
                   
            }
        
            else{         
            
                    if (caseApres.occupee && notInDernieresRencontres((EtreVivant) caseApres.getContenu())){
                
                        rencontrer((EtreVivant) caseApres.getContenu());                        
                        flag = true;
                        //System.out.println("Déjà Rencontré");
                
                    }
                    
                    if (!caseApres.occupee){
                        
                        flag = true;
                        
                    }
            
                }
            
            
        }
        
        else{
            
            SafeCase convertSafe = (SafeCase) caseApres;
            
            if (convertSafe.getEspece() == this.getClass()){
                
                if (caseApres.isEmpty()){
        
                this.caseCourante.vider();
            
                this.caseCourante.occupee = false;
        
                this.caseCourante = caseApres;
        
                this.caseCourante.setContenu(this);
            
                this.caseCourante.occupee = true;
            
                this.pE = pE - 1;
            
                if (this.pE < PE_CRITIQUE){
                    
                    flag = true;
                    
                }
                              
            }
        
            else{

                    if (caseApres.occupee && notInDernieresRencontres((EtreVivant) caseApres.getContenu())){
                
                        rencontrer((EtreVivant) caseApres.getContenu());
                        flag = true;
                        //System.out.println("Déjà Rencontré");                
                    }
            
                    if (!caseApres.occupee){
                        
                        flag = true;
                        
                    }
                    
                }                
                
            }            
            
            else{
                
                //System.out.println("Tentavite Intrusion SafeZone Adverse Rejetée");
                                
            }
            
        }
        
        //System.out.println("Nouvelle Case : " + this.caseCourante.getX() + " / " + this.caseCourante.getY());
                
        return flag;
        
    }
    
    
    
    
        /**
    *
    * @author Toine
    * 
    * Methode choisissant la prochaine case 
    */
    
    public Case prochaineCase(){
  
        Case prochaineCase = new Case();
        
        if (pE >= PE_CRITIQUE){     //Si on a assez de PE on cherche une case au hasard
        
            Random random = new Random();
        
            ArrayList<Case> voisins = this.carte.voisins(this.caseCourante, derniereDirection);
            
            prochaineCase = voisins.get(random.nextInt(voisins.size()));
        
        }
        
        else{                       //Si on a pas assez de PE on rejoin la SafeZone
            
            prochaineCase = this.carte.cheminDirection(this.caseCourante, this.directionSafeZone);
            
        }
        
        return prochaineCase;
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Methode vérifiant si un EtreVivant a déjà été rencontré
    */
    
    
    public boolean notInDernieresRencontres(EtreVivant pEtreVivant){
        
        boolean bool = true;
        
        for (int i = 0; i < dernieresRencontres.size(); i++){
            
            if (pEtreVivant == dernieresRencontres.get(i)){
                
                bool = false;
                
            }
            
            
        }      
        
        return bool;
        
    }
    
    
        /**
    *
    * @author Toine
    * 
    * Methode ajout un EtreVivant à la liste des rencontres
    */
    
    
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
