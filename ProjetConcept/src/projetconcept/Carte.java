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
    private ArrayList<SafeCase> safeCases;
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
    * 
    * Les SafeCase sont placés aux coins de la carte
    * 
    */
    
    public ArrayList<Case> creationCases(Dimensions pDimenssionsCarte){
        
        safeCases = new ArrayList();
        
        ArrayList<Case> listeCases = new ArrayList<>();
        
        int xSafeZone = pDimenssionsCarte.getLongueurX() / 4;       //Proportion des safe-zones par rapport à la carte
        int ySafeZone = pDimenssionsCarte.getLongueurY() / 4;
        
        for (int i = 0; i < pDimenssionsCarte.getLongueurY(); i++){
            
            for (int j = 0; j < pDimenssionsCarte.getLongueurX(); j++){
                
                if (!((j < xSafeZone && i < ySafeZone) || (j > pDimenssionsCarte.getLongueurX() - xSafeZone - 1 && i > pDimenssionsCarte.getLongueurY() - ySafeZone - 1) || (j < xSafeZone && i > pDimenssionsCarte.getLongueurY() - ySafeZone - 1) ||(j > pDimenssionsCarte.getLongueurX() - xSafeZone - 1 && i < ySafeZone))){
                    
                    //On place des objets Case partout sur la carte sauf dans les coins
                    
                    Case tempCase = new Case(j, i);
                
                    listeCases.add(tempCase);
                    
                }
                
                else{                    
                    
                    //On place les SafeCase dans les coins
                    
                    SafeCase tempSafeCase = new SafeCase(j,i);     
                    
                    if (j < xSafeZone && i < ySafeZone){
                        
                        tempSafeCase.setEspece(Gobelin.class);
                        
                    }
                    
                    if (j > pDimenssionsCarte.getLongueurX() - xSafeZone - 1 && i > pDimenssionsCarte.getLongueurY() - ySafeZone - 1){
                        
                        tempSafeCase.setEspece(Humain.class);
                        
                    }
                    
                    if (j < xSafeZone && i > pDimenssionsCarte.getLongueurY() - ySafeZone - 1){
                        
                        tempSafeCase.setEspece(Orque.class);
                        
                    }
                    
                    if (j > pDimenssionsCarte.getLongueurX() - xSafeZone - 1 && i < ySafeZone){
                        
                        tempSafeCase.setEspece(Elfe.class);
                        
                    }                    
                    
                    listeCases.add(tempSafeCase);
                    
                    //Pour retrouver facilement les SafeCase on les place dans une liste à part
                    
                    safeCases.add(tempSafeCase);
                    
                }             
                                                              
            }
            
        }
        
        return listeCases;      
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Cette Méthode place les maitres sur la carte.
    * Ils sont placés dans les coins de leurs safe-zones respectives
    * 
    */
    
    public void ajoutMaitres(MaitreHumain maitreHumain, MaitreElfe maitreElfe, MaitreGobelin maitreGobelin, MaitreOrque maitreOrque){
        
        for (int i = 0; i < this.cases.size(); i++){
            
            if (this.cases.get(i).getX() == 0 && this.cases.get(i).getY() == 0){
                
                maitreGobelin.changerCase(this.cases.get(i));
                
            }
            
            if (this.cases.get(i).getX() == this.dimensions.getLongueurX() - 1 && this.cases.get(i).getY() == this.dimensions.getLongueurY() - 1){
                
                maitreHumain.changerCase(this.cases.get(i));
                
            }
            
            if (this.cases.get(i).getX() == 0 && this.cases.get(i).getY() == this.dimensions.getLongueurY() - 1){
                
                maitreOrque.changerCase(this.cases.get(i));
                
            }
            
            
            if (this.cases.get(i).getX() == this.dimensions.getLongueurX() - 1 && this.cases.get(i).getY() == 0){
                
                maitreElfe.changerCase(this.cases.get(i));
                
            }
        }
        
    }
    
    /**
    *
    * @author Toine
    * 
    * Cette Méthode ajoute des obstacle aléatoirement sur la carte.
    * Sauf dans les safe-zones.
    * 
    */
    
    public void ajoutObstacle(ArrayList<Obstacle> liste){
        
        Random random = new Random();
        
        int idCase = -1;
        
        for (int i = 0; i < liste.size(); i++){
            
            idCase = random.nextInt(this.cases.size());
            
            if (this.cases.get(idCase).getClass() != SafeCase.class){
            
                System.out.println("Obstacle : " + this.cases.get(idCase).getX() + " / " +this.cases.get(idCase).getY());
                
                this.cases.get(idCase).setContenu(liste.get(i));
            
            }
            
        }
        
        
    }
    
        /**
    *
    * @author Toine
    * 
    * Ajoute des EtreVivant sur la carte aléatoirement.
    * Sauf dans les safe-zones.
    */
    
        
    public void ajoutEtresVivants(ArrayList<EtreVivant> liste){
        
        Random random = new Random();
        
        boolean bool = true;
        int idCase = -1;
        
        for (int i = 0; i < liste.size(); i++){
            
            bool = true;
            
            while (bool){
                
                idCase = random.nextInt(this.cases.size());
                       
                if (this.cases.get(idCase).isEmpty() && this.cases.get(idCase).getClass() != SafeCase.class){
                
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
        
        //System.out.println("Cases : " + this.cases);
        
        System.out.println("Carte : ");
        
        int k = this.dimensions.getLongueurX();
        
        ArrayList<String> bufferLigne = new ArrayList();
        
        for (int i = 0; i < this.dimensions.getLongueurY(); i++){
            
            ligne = "";
            
            for (int j = 0; j < this.dimensions.getLongueurX(); j++){
                
                ligne = ligne + this.cases.get(i*k + j).toString() + " ";                        
                
            }
            
            bufferLigne.add(ligne);
            
        }
        
        for (int l = bufferLigne.size() - 1; l > -1 ; l--){
            
            System.out.println(bufferLigne.get(l));
            
        }
        
        System.out.println("\nLégende : Humain = @ ; Elfe =  + ; Gobelin = € ; Orque = # ; Obstacle = %");
        
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////Méthodes Scondaires/////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
    *
    * @author Toine
    * 
    * Méthode renvoyant la case à choisir quand on souhaite se diriger vers une direction
    */
    
    public Case cheminDirection(Case position, Direction direction){
        
        ArrayList<Direction> directions = new ArrayList();
        
        Direction chemin = Direction.FIXE;
        
        Random random = new Random();
        
        //on liste nos "voeux" de direction, en effet on considere que si on souhaite aller vers le nord
        //on acceptera d'aller au Nord, au NordEst ou bien vers le NordOuest
        
        directions.add(direction);
        directions.add(direction.voisins()[0]);
        directions.add(direction.voisins()[1]);
                        
        for (int i = 0; i < directions.size(); i++){
            
            //On élimine les voeux qui nous sortent de la carte
            
            if(!(position.getX() + directions.get(i).getDifX() > 0 && position.getY() + directions.get(i).getDifY() > 0 && position.getX() + directions.get(i).getDifX() < this.dimensions.getLongueurX() - 1 && position.getY() + directions.get(i).getDifY() < this.dimensions.getLongueurY())){
            
                directions.remove(i);
                i = i - 1;
                               
            }            
            
        }
        
                
        if (!directions.isEmpty()){
            
            //On choisi le premier voeux qui est possible
            
            chemin = directions.get(random.nextInt(directions.size()));
            
        }
                
        else{
            
            //Si aucun voeux n'est possible alors on recule
            
            if(position.getX() + direction.oppose().getDifX() > 0 && position.getY() + direction.oppose().getDifY() > 0 && position.getX() + direction.oppose().getDifX() < this.dimensions.getLongueurX() - 1 && position.getY() + direction.oppose().getDifY() < this.dimensions.getLongueurY()){
            
                            chemin = direction.oppose();
                                           
            }
            
        }           
  
        //Si on ne peut pas reculer alors on ne bouge pas (La variable chemin est initialisée à "Fixe")
                
        return chercherCase(position.getX() + chemin.getDifX(), position.getY() + chemin.getDifY());
        
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
    * Retourne les cases voisines d'une case passée en parametre.
    * Sauf la case étant dans la direction prohibee.
    * Si on ne veut prohiber aucune direction on indique la direction "Fixe" 
    */
    
    
    public ArrayList<Case> voisins(Case pCase, Direction directionProhibee){
        
        ArrayList<Case> voisinsListe = new ArrayList<>();
        
        Direction[] direction = {Direction.EST, Direction.NORD, Direction.NORDEST, Direction.NORDOUEST, Direction.OUEST, Direction.SUD, Direction.SUDEST, Direction.SUDOUEST}; 
        
        for (int i = 0; i < 8; i++){
            
            if (pCase.getX() + direction[i].getDifX() > 0 && pCase.getY() + direction[i].getDifY() > 0 && pCase.getX() + direction[i].getDifX() < this.dimensions.getLongueurX() - 1 && pCase.getY() + direction[i].getDifY() < this.dimensions.getLongueurY() && direction[i] != directionProhibee){
                
                voisinsListe.add(this.chercherCase(pCase.getX() + direction[i].getDifX(), pCase.getY() + direction[i].getDifY()));                
            }
            
        }
        
        return voisinsListe;
        
    } 
    
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Geters et Seters/////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    
    public ArrayList<Case> getCases(){
        
        return this.cases;
        
    }
    
    public ArrayList<SafeCase> getsafeCases(){
        
        return this.safeCases;
        
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
