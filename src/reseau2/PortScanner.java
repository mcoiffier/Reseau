/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau2;
import java.io.IOException;
import java.net.*;
/**
 *
 * @author Morgan
 */
public class PortScanner {
    public static void main(String[] args) {
        try {
            InetAddress remote = null;
            InetSocketAddress soRemote = null;
            remote=InetAddress.getByName("www.univ-reims.fr");
            for (int port = 80; port < 110; port++) {
                soRemote = new InetSocketAddress(remote,port);
                System.out.println("Test sur le port " + port);
                Socket s = new Socket();
                try {
                    s.connect(soRemote,500);
                    System.out.println(remote.getHostName() + " est à l'écoute sur le port "+port);
                    s.close();
                } catch (IOException e) {
                    System.out.println("Une erreur s'est produite (port pas à l'écoute ?)");
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Le nom de l'hôte indiqué n'existe pas");
        }
    }
    
}
