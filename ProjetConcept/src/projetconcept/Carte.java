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
public class Carte {
    
    Aleatoire AJE;          /*Instance de la classe Aléatoire qui nous servira pour tous nos bessoins en terme de hasard*/
    
    private ArrayList<Case> cases;
    private Dimensions dimensions;
    
    /**
    *
    * @author Toine
    * 
    * Constructeur, une carte a bession de dimensions
    */
    
    public Carte(Dimensions pDimenssions){
        
        dimensions = pDimenssions;
        
        cases = creationCases(dimensions);
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Création des cases qui forment la carte, exemple de la répartion des coordonnées pour Dimenssions -> x=2 ; y=3
    * 
    * [(0,0)(1,0)(0,1)(1,1)(0,2)(1,2)]
    */
    
    public ArrayList<Case> creationCases(Dimensions pDimenssionsCarte){
        
        ArrayList<Case> listeCases = new ArrayList<>();
        
        for (int i = 0; i < pDimenssionsCarte.getLongueurY(); i++){
            
            for (int j = 0; j < pDimenssionsCarte.getLongueurX(); j++){
                
                Case tempCase = new Case(j, i);
                
                listeCases.add(tempCase);
                                              
            }
            
        }
        
        return listeCases;      
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Retourne les cases voisines d'une case passée en parametre
    */
    
    
    public ArrayList<Case> voisons(Case pCase){
        
        ArrayList<Case> voisins = new ArrayList<>();
        
        int[][] coor =
            {
                { -1, -1},
                { -1, 0 },
                { -1, 1}, 
                { 0, -1}, 
                { 0, 1}, 
                { 1, -1}, 
                { 1, 0}, 
                { 1, 1} 
            }; 
        
        for (int i = 0; i < 8; i++){
            
            if (pCase.getX() + coor[i][0] > 0 && pCase.getY() + coor[i][1] > 0 && pCase.getX() + coor[i][0] < this.dimensions.getLongueurX() - 1 && pCase.getY() + coor[i][1] < this.dimensions.getLongueurY()){
                
                voisins.add(this.chercherCase(pCase.getX() + coor[i][0], pCase.getY() + coor[i][1]));                
            }
            
        }
        
        return voisins;
        
    }
    
    
        /**
    *
    * @author Toine
    * 
    * Retourne une case à partir de ses coordonnées
    */
    
    public Case chercherCase(int pX, int pY){
        
        int idCase = -1;
        
        
        
        for (int i = 0; i < this.cases.size(); i++){
            
            if (this.cases.get(i).getX() == pX && this.cases.get(i).getY() == pY){
                
                idCase = i;
                
            }
            
        }
        
        return this.cases.get(idCase);
        
    }
    
    
        /**
    *
    * @author Toine
    * 
    * Ajoute des EtreVivant sur la carte aléatoirement
    */
    
        
    public void ajoutEtresVivants(ArrayList<EtreVivant> liste){
        
        Random random = new Random();
        
        boolean bool = true;
        int idCase = -1;
        
        for (int i = 0; i < liste.size(); i++){
            
            bool = true;
            
            while (bool){
                
                idCase = random.nextInt(this.cases.size() - 1);
                       
                if (this.cases.get(idCase).isEmpty()){
                
                    liste.get(i).changerCase(this.cases.get(idCase));
                
                    bool = false;
                
                }
            
            }
            
    }
        
        
    }
    
    
        /**
    *
    * @author Toine
    * 
    * Affiche la carte 
    */
    
    public void afficherCarte(){
        
        String ligne = new String();
        
        System.out.println("Cases : " + this.cases);
        
        System.out.println("Carte : ");
        
        int k = this.dimensions.getLongueurX();
        
        for (int i = 0; i < this.dimensions.getLongueurY(); i++){
            
            ligne = "";
            
            for (int j = 0; j < this.dimensions.getLongueurX(); j++){
                
                ligne = ligne + this.cases.get(i*k + j).toString() + " ";                        
                
            }
            
            System.out.println(ligne);
            
        }
        
        
        System.out.println("\nLégende : Humain = @ ; Elfe =  + ; Gobelin = O ; Orque = #");
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Geters et Seters/////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    
    public ArrayList<Case> getCases(){
        
        return this.cases;
        
    }
    
    public Dimensions getDimensions(){
        
        
        return this.dimensions;
        
    }
    
    public void setCases( ArrayList<Case> pCases){
        
        this.cases = pCases;
        
    }
    
    public void setDimensions(Dimensions pDimensions){
        
        this.dimensions = pDimensions;
        
    }
}
