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
        
        Dimensions dim = new Dimensions(12, 12);
        
        Carte carte = new Carte(dim);
        
        Humain hu = new Humain(carte);
        Elfe el = new Elfe(carte);
        Orque oc = new Orque(carte);
        Gobelin go = new Gobelin(carte);
        
        MaitreElfe maitreElfe = MaitreElfe.getInstance(carte);
        MaitreHumain maitreHumain = MaitreHumain.getInstance(carte);
        MaitreOrque maitreOrque = MaitreOrque.getInstance(carte);
        MaitreGobelin maitreGobelin = MaitreGobelin.getInstance(carte);
                       
        Message m1 = new Message("My my, hey hey",1);
        Message m2 = new Message("Rock and roll is here to stay",2);
        Message m3 = new Message("It's better to burn out",3);
        Message m4 = new Message("Than to fade away",4);
        Message m5 = new Message("Out of the blue",5);
        Message m6 = new Message("and into the black",6);
        Message m7 = new Message("They give you this,",7);
        Message m8 = new Message("but you pay for that",8);
        Message m9 = new Message("And once you're gone,",9);
        Message m10 = new Message("you can never come back",10);
        Message m11 = new Message("When you're out of the bluev",11);
        Message m12 = new Message("and into the black.",12);
        
        ArrayList<Message> lH = new ArrayList();
        lH.add(m1);
        lH.add(m2);
        lH.add(m3);
        ArrayList<Message> lE = new ArrayList();
        lE.add(m4);
        lE.add(m5);
        lE.add(m6);
        ArrayList<Message> lG = new ArrayList();
        lG.add(m7);
        lG.add(m8);
        lG.add(m9);
        ArrayList<Message> lO = new ArrayList();
        lO.add(m10);
        lO.add(m11);
        lO.add(m12);
                 
        Savoir sH = new Savoir(lH);
        Savoir sE = new Savoir(lE);
        Savoir sG = new Savoir(lG);
        Savoir sO = new Savoir(lO);
        
        hu.setSavoir(sH);
        el.setSavoir(sE);
        oc.setSavoir(sO);
        go.setSavoir(sG);        
        
        ArrayList<EtreVivant> liste = new ArrayList();
        
        liste.add(el);
        liste.add(hu);
        liste.add(oc);
        liste.add(go);
        
        Obstacle pierre = new Obstacle("Pierre");
        Obstacle trou = new Obstacle("Trou");
        
        ArrayList<Obstacle> listeOb = new ArrayList();
        
        listeOb.add(pierre);
        listeOb.add(trou);        
        
        carte.ajoutMaitres(maitreHumain, maitreElfe, maitreGobelin, maitreOrque);
        carte.ajoutObstacle(listeOb);
        carte.ajoutEtresVivants(liste);
        
        /*On a créé une carte avec 4 EtreVivant dessus*/
        
        System.out.println("Savoir Humain : " + hu.getSavoir().toString());
        System.out.println("Savoir Elfe : " + el.getSavoir().toString());
        System.out.println("Savoir Orque : " + oc.getSavoir().toString());
        System.out.println("Savoir Gobelin : " + go.getSavoir().toString());
                
        
        /*On affiche la carte*/
        
        carte.afficherCarte();
        
        /*4 fois de suite on bouge un EtreVivant puis on affiche la carte*/
        
        for (int i = 0; i < 5; i++){
            
            hu.move();
            
            for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                carte.getsafeCases().get(k).rechargePe();
                carte.getsafeCases().get(k).recolteSavoir();
                
            }
        
            el.move();
            
            for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                carte.getsafeCases().get(k).rechargePe();
                carte.getsafeCases().get(k).recolteSavoir();
                
            }
        
            oc.move();
            
            for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                carte.getsafeCases().get(k).rechargePe();
                carte.getsafeCases().get(k).recolteSavoir();
                
            }
        
            go.move();
        
            for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                carte.getsafeCases().get(k).rechargePe();
                carte.getsafeCases().get(k).recolteSavoir();
                
            }
            
            maitreElfe.move();
        
            for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                carte.getsafeCases().get(k).rechargePe();
                carte.getsafeCases().get(k).recolteSavoir();
                
            }
            
            maitreHumain.move();
        
            for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                carte.getsafeCases().get(k).rechargePe();
                carte.getsafeCases().get(k).recolteSavoir();
                
            }
            
            maitreOrque.move();
        
            for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                carte.getsafeCases().get(k).rechargePe();
                carte.getsafeCases().get(k).recolteSavoir();
                
            }
            
            maitreGobelin.move();
        
            for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                carte.getsafeCases().get(k).rechargePe();
                carte.getsafeCases().get(k).recolteSavoir();
                
            }
        }
        
        
        System.out.println("Savoir Humain : " + hu.getSavoir().toString());
        System.out.println("Savoir Elfe : " + el.getSavoir().toString());
        System.out.println("Savoir Orque : " + oc.getSavoir().toString());
        System.out.println("Savoir Gobelin : " + go.getSavoir().toString());
        System.out.println("Savoir MaitreElfe : " + maitreElfe.getSavoir().toString());
        System.out.println("Savoir MaitreHumain : " + maitreHumain.getSavoir().toString());
        System.out.println("Savoir MaitreOrque : " + maitreOrque.getSavoir().toString());
        System.out.println("Savoir MaitreGobelin : " + maitreGobelin.getSavoir().toString());
        
        
        for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                System.out.println(carte.getsafeCases().get(k).getX() + " / " + carte.getsafeCases().get(k).getY() + " : " + carte.getsafeCases().get(k).getSavoir().toString());
                
            }
        
        
    }
    
}
