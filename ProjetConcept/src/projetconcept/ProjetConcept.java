/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetconcept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
    public static void main(String[] args) throws InterruptedException {
        
        int PAS_DE_TEMPS = -1;
        int NOMBRE_ETRE_PAR_EQUIPE = 0; 
        final int NOMBRE_ETRE_MAX = 5;
        final int NOMBRE_ETRE_MIN = 2;
        
        /////Demande utilisateur
        
        Scanner scan = new Scanner(System.in);
        
        while (NOMBRE_ETRE_PAR_EQUIPE < NOMBRE_ETRE_MIN || NOMBRE_ETRE_PAR_EQUIPE > NOMBRE_ETRE_MAX){
                        
            System.out.println("Veuillez le nombre d'individus par équipe(Min 2 ; Max 5): ");
        
            NOMBRE_ETRE_PAR_EQUIPE = Integer.parseInt(scan.nextLine());            
            
        }
        
        while (PAS_DE_TEMPS < 0){
                        
            System.out.println("Veuillez un pas de temps en millisecondes: ");
        
            PAS_DE_TEMPS = Integer.parseInt(scan.nextLine());            
            
        }
                
        
        /////Création Carte/////
        
        Dimensions dim = new Dimensions(12, 12);
        
        Carte carte = new Carte(dim);
        
        /////Creation des EtreVivant/////
                
        ArrayList<EtreVivant> liste = new ArrayList();  //Liste des EtreVivant (non Maitre)        
        
        for (int e = 0; e < NOMBRE_ETRE_PAR_EQUIPE; e++){
            
            Humain humain = new Humain(carte);
            liste.add(humain);
            Elfe elfe = new Elfe(carte);
            liste.add(elfe);
            Orque orque = new Orque(carte);
            liste.add(orque);
            Gobelin gobelin = new Gobelin(carte);
            liste.add(gobelin);
            
        }
        
        
        MaitreElfe maitreElfe = MaitreElfe.getInstance(carte);
        MaitreHumain maitreHumain = MaitreHumain.getInstance(carte);
        MaitreOrque maitreOrque = MaitreOrque.getInstance(carte);
        MaitreGobelin maitreGobelin = MaitreGobelin.getInstance(carte);
        
        /////Création des Obstacle/////
        
        Obstacle pierre = new Obstacle("Pierre");
        Obstacle trou = new Obstacle("Trou");
        
        ArrayList<Obstacle> listeOb = new ArrayList();  //Liste des Obstacle
        
        listeOb.add(pierre);    //Ajout à la liste
        listeOb.add(trou);  
        
        /////Création des Message/////
                       
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
        Message m11 = new Message("When you're out of the blue",11);
        Message m12 = new Message("and into the black.",12);
        Message m13 = new Message("Two shots of happy, one shot of sad ",13);
        Message m14 = new Message("You think I'm no good, I know I've been bad",14);
        Message m15 = new Message("Took you to a place, now you can't get back ",15);
        Message m16 = new Message("Walked together down a dead end street ",16);
        Message m17 = new Message("We were mixing the bitter with the sweet ",17);
        Message m18 = new Message("I don't try to figure out what we might of had",18);
        Message m19 = new Message("I'm just a singer, some say a sinner ",19);
        Message m20 = new Message("Rolling the dice, not always a winner",20);
        Message m21 = new Message("Not part of the crowd, but not feeling alone",21);
        Message m22 = new Message("Under pressure, but not bent out of shape ",22);
        Message m23 = new Message("You drove me to drink, but hey that's not all bad",23);
        Message m24 = new Message("The chairs are all stacked, the swinging's stopped swinging",24);        
        Message m25 = new Message("Rolling the dice, not always a winner",25);
        Message m26 = new Message("Not part of the crowd, but not feeling alone",26);
        Message m27 = new Message("Under pressure, but not bent out of shape ",27);
        Message m28 = new Message("You drove me to drink, but hey that's not all bad",28);
        Message m29 = new Message("The chairs are all stacked, the swinging's stopped swinging",29);
        Message m30 = new Message("you can never come back",30);
        Message m31 = new Message("When you're out of the blue",31);
        Message m32 = new Message("and into the black.",32);
        Message m33 = new Message("Two shots of happy, one shot of sad ",33);
        Message m34 = new Message("You think I'm no good, I know I've been bad",34);
        Message m35 = new Message("Took you to a place, now you can't get back ",35);
        Message m36 = new Message("Walked together down a dead end street ",36);
        Message m37 = new Message("We were mixing the bitter with the sweet ",37);
        Message m38 = new Message("I don't try to figure out what we might of had",38);
        Message m39 = new Message("I'm just a singer, some say a sinner ",39);
        Message m40 = new Message("Rolling the dice, not always a winner",40);
        
        ArrayList<Message> BDD_MESSAGES = new ArrayList();
        
        BDD_MESSAGES.add(m1);
        BDD_MESSAGES.add(m2);
        BDD_MESSAGES.add(m3);
        BDD_MESSAGES.add(m4);
        BDD_MESSAGES.add(m5);
        BDD_MESSAGES.add(m6);
        BDD_MESSAGES.add(m7);
        BDD_MESSAGES.add(m8);
        BDD_MESSAGES.add(m9);
        BDD_MESSAGES.add(m10);
        BDD_MESSAGES.add(m11);
        BDD_MESSAGES.add(m12);
        BDD_MESSAGES.add(m13);
        BDD_MESSAGES.add(m14);
        BDD_MESSAGES.add(m15);
        BDD_MESSAGES.add(m16);
        BDD_MESSAGES.add(m17);
        BDD_MESSAGES.add(m18);
        BDD_MESSAGES.add(m19);
        BDD_MESSAGES.add(m20);
        BDD_MESSAGES.add(m21);
        BDD_MESSAGES.add(m22);
        BDD_MESSAGES.add(m23);
        BDD_MESSAGES.add(m24);
        BDD_MESSAGES.add(m25);
        BDD_MESSAGES.add(m26);
        BDD_MESSAGES.add(m27);
        BDD_MESSAGES.add(m28);
        BDD_MESSAGES.add(m29);
        BDD_MESSAGES.add(m30);
        BDD_MESSAGES.add(m31);
        BDD_MESSAGES.add(m32);
        BDD_MESSAGES.add(m33);
        BDD_MESSAGES.add(m34);
        BDD_MESSAGES.add(m35);
        BDD_MESSAGES.add(m36);
        BDD_MESSAGES.add(m37);
        BDD_MESSAGES.add(m38);
        BDD_MESSAGES.add(m39);
        BDD_MESSAGES.add(m40);
        
        /////Distribution Savoir de départ
        
        for (int a = 0; a < liste.size(); a++){
            
            ArrayList<Message> messages = new ArrayList();
                messages.add(BDD_MESSAGES.get(a*2));
                messages.add(BDD_MESSAGES.get(a*2 + 1));
                
            Savoir savoir = new Savoir(messages);
            
            liste.get(a).setSavoir(savoir);
            
        }
        
        
        int nombreMessages = NOMBRE_ETRE_PAR_EQUIPE * 8;
        
        /////Initialisation de la Carte (Attention ordre des actions important)/////
        
        carte.ajoutMaitres(maitreHumain, maitreElfe, maitreGobelin, maitreOrque);
        carte.ajoutObstacle(listeOb);
        carte.ajoutEtresVivants(liste);
        
        ArrayList<EtreVivant> listeEtresVivants = new ArrayList();
        
        for (int i = 0; i < liste.size(); i++){
            
            listeEtresVivants.add(liste.get(i));
            
        }
        
        listeEtresVivants.add(maitreHumain);
        listeEtresVivants.add(maitreElfe);
        listeEtresVivants.add(maitreGobelin);
        listeEtresVivants.add(maitreOrque);
        
        Collections.shuffle(listeEtresVivants);
        
        /////Affichage de la situation de départ (Possession des Message + Carte)/////
        
                 
        carte.afficherCarte();
        
        /////Simulation/////
        
        int indiceListe = 0;
        int nombreTours = 0;
        
        while (maitreElfe.getSavoir().getMessages().size() < nombreMessages && maitreHumain.getSavoir().getMessages().size() < nombreMessages && maitreOrque.getSavoir().getMessages().size() < nombreMessages && maitreGobelin.getSavoir().getMessages().size() < nombreMessages){
                                                          
            listeEtresVivants.get(indiceListe).move();                        
            
            for (int k = 0; k < carte.getsafeCases().size(); k++){
                
                carte.getsafeCases().get(k).rechargePe();
                carte.getsafeCases().get(k).recolteSavoir();
                
            }
            
            Thread.sleep(PAS_DE_TEMPS);
        
            if (indiceListe == listeEtresVivants.size() - 1){
                
                indiceListe = 0;
                
                Collections.shuffle(listeEtresVivants);
                
                nombreTours++;
            }
            
            else{
                
                indiceListe++;
                
            }
            
            
           
        }
        
        /////Affichage final de la possession des Message/////
        
        System.out.println("Etats des Savoirs à la fin de la partie : \n");
        
        for (int s = 0; s < listeEtresVivants.size(); s++){
            
            System.out.println("Savoir de : " + listeEtresVivants.get(s) + " -> " + listeEtresVivants.get(s).getSavoir());            
            
        }
        
        /////Affichage des vainqueurs/////
        
        System.out.println("\n");
        
        if (maitreElfe.getSavoir().getMessages().size() == nombreMessages){
            
            System.out.println("Les Elfes ont gagné");
            
        }
        
        if (maitreHumain.getSavoir().getMessages().size() == nombreMessages){
            
            System.out.println("Les Humains ont gagné");
            
        }
        
        if (maitreOrque.getSavoir().getMessages().size() == nombreMessages){
            
            System.out.println("Les Orques ont gagné");
            
        }
        
        if (maitreGobelin.getSavoir().getMessages().size() == nombreMessages){
            
            System.out.println("Les Gobelins ont gagné");
            
        }
        
        System.out.println("Nombre de tours: " + nombreTours);
        
    }
    
    
}
