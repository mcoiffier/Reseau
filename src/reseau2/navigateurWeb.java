/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau2;

import java.io.*;
import java.net.*;

/**
 *
 * @author Morgan
 */
public class navigateurWeb {
    public static void main(String[] args) {
        String l =null;
        Socket soc =null;
        BufferedReader lect =null;
        PrintWriter ecr = null;
        
        try {
            soc = new Socket("amazon.fr",80);
        } catch (UncheckedIOException e) {
            System.out.println("Hôte inconnu !!!\n");
        }
        catch(IOException e){
            System.out.println("Erreur à l'ouverture de la socket !!! \n");
        }
        try {
            lect = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            ecr = new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
        } catch (Exception e) {
            System.out.println("erreur à l'ouverture de la socket !!! \n");
        }
        ecr.print("GET /index.html HTTP/1.0\n\n");
        ecr.flush();
        try {
            for(l=null;(l=lect.readLine())!=null;){
             System.out.println(l);
            }
            lect.close();
            ecr.close();
            soc.close();
        } catch (Exception e) {
            System.out.println("Erreur à l'ouverture de la socket !!! \n");
        }
              
    }
            
}
