/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author Morgan
 */
public class SimpleServer {

    public static void main(String[] args) {
        ServerSocket ecoute = null;
        Socket s = null;
        Statuts leStatuts = new Statuts(0, "");
        int number = 0;
        int somme = 0;
        try {
            ecoute = new ServerSocket(12000);
            s = ecoute.accept();
            ObjectOutputStream ecr = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream lect = new ObjectInputStream(s.getInputStream());

            while (true) {
                Statuts leStatutsRecu = (Statuts) lect.readObject();
                leStatuts.setCounter(leStatutsRecu.getCounter());

                if (leStatuts.getCounter() >= 10) {
                    System.out.println("Joueur GAGNE");
                    s.close();
                    break;
                }
                number = choix(leStatuts.getCounter());
                somme = number + leStatuts.getCounter();
                leStatuts.setCounter(somme);
                if (somme >= 10) {
                    System.out.println("L'ordinateur joue: " + number);
                    System.out.println("ORDINATEUR GAGNE");
                    ecr.writeUnshared(leStatuts);
                    
                    ecr.flush();
                    s.close();
                    break;
                } else {
                    System.out.println("L'ordinateur joue: " + number);
                    System.out.println("La somme: " + somme);
                    ecr.writeUnshared(leStatuts);
                    ecr.flush();
                }
            }

        } catch (Exception e) {
            System.out.println("Erreur !!! :" + e.getMessage() + "\n" + e.getStackTrace());
        }

    }

    public static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public static int choix(int somme) {
        if ((somme + 1 == 1) || (somme + 1 == 4) || (somme + 1 == 7) || (somme + 1 == 10)) {
            return 1;
        }
        if ((somme + 2 == 4) || (somme + 2 == 7) || (somme + 2 == 10)) {
            return 2;
        }
        return generateRandomNumber(1, 2);
    }

}
