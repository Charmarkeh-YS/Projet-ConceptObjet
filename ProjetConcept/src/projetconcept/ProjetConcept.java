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
     */
    public static void main(String[] args) {
        
        Dimensions dim = new Dimensions(7, 5);
        
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
        
        carte.afficherCarte();
        
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
