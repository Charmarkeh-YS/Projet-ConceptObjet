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
public class ProjetConcept {

    /**
     * @param args the command line arguments
     * 
     * Pour l'instant TESTS
     * 
     */
    public static void main(String[] args) {
        
        Dimensions dim = new Dimensions(20, 12);
        
        Carte carte = new Carte(dim);
        
        Humain hu = new Humain(carte);
        Elfe el = new Elfe(carte);
        Orque oc = new Orque(carte);
        Gobelin go = new Gobelin(carte);
        
        ArrayList<EtreVivant> liste = new ArrayList();
        
        liste.add(el);
        liste.add(hu);
        liste.add(oc);
        liste.add(go);
        
        carte.ajoutEtresVivants(liste);
        
        /*On a créé une carte avec 4 EtreVivant dessus*/
        
        
        /*On affiche la carte*/
        
        carte.afficherCarte();
        
        /*4 fois de suite on bouge un EtreVivant puis on affiche la carte*/
        
        for (int i = 0; i < 10; i++){
            
            hu.move();
        
            carte.afficherCarte();
        
            el.move();
        
            carte.afficherCarte();
        
            oc.move();
        
            carte.afficherCarte();
        
            go.move();
        
            carte.afficherCarte();
            
            
        }
        
        
        
    }
    
}
