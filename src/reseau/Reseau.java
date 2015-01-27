/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Morgan Coiffier
 */
public class Reseau {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
       int bufferSize = 3;
       ArrayList<byte[]> tab = FileManager.convertFileToArray("test.txt",bufferSize);

       //LANCE LE CLIENT
       UDPClient client = new UDPClient();
       client.transferFile(tab, "localhost", 6789);
    }
}
