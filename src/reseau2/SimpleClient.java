package reseau2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Morgan
 */
public class SimpleClient {

    InetAddress server;

    public static void main(String[] args) {
        Socket s = null;
        Statuts leStatuts = new Statuts(0, "Salut");
        Statuts leStatutsRecu = null;
        int somme = 0;

        try {
            s = new Socket("localhost", 12000);

            Scanner keyBoard = new Scanner(System.in);
            String message = "";
            int start = 0;

            ObjectOutputStream ecr = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream lect = new ObjectInputStream(s.getInputStream());

            System.out.print("Qui commence ?(1,2 pour commencer , sinon 0): ");
            try {
                start = keyBoard.nextInt();
                keyBoard.nextLine();
                if (start == 0) {
                    ecr.writeUnshared(leStatuts);
                    ecr.flush();
                    leStatutsRecu = (Statuts)lect.readObject();
                    leStatuts.setCounter(leStatutsRecu.getCounter());
                    System.out.println("L'ordi joue......Somme: " + leStatuts.getCounter());
                    
                }
            } catch (Exception e) {
            }

            while (true) {
                
                //L'ordi renvoi un somme supérieur ou égal à 10 il a gagné
                if (leStatuts.getCounter() >= 10) {
                    System.out.println("ORDINATEUR GAGNE");
                    break;
                }

                System.out.print("Le joueur joue: ");
                message = keyBoard.nextLine();

                somme = Integer.parseInt(message) +leStatuts.getCounter();
                leStatuts.setCounter(somme);
                
                System.out.println("Nouvelle somme: " + leStatuts.getCounter());
                //Le joueur a une somme supérieur ou égal à 10 il a gagné
                if (somme >= 10) {
                    System.out.println("JOUEUR GAGNE");
                    ecr.writeUnshared(leStatuts);
                    ecr.flush();
                    break;

                } else {
                    ecr.writeUnshared(leStatuts);
                    ecr.flush();
                    leStatutsRecu = (Statuts)lect.readObject();
                    leStatuts.setCounter(leStatutsRecu.getCounter());
                    System.out.println("L'ordi joue......Somme: " + leStatuts.getCounter());
                }

            }

        } catch (Exception e) {
            System.out.println("erreur");
        }

    }

}
