/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau;

import java.net.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Morgan Coiffier
 */
public class UDPServer {
    public static int bufferSize = 3;
    
    public static void main(String args[]) {
        DatagramSocket aSocket = null;
        try {
            // create socket at agreed port 
            aSocket = new DatagramSocket(6789);
            byte[] buffer = new byte[bufferSize];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                FileManager.writeToFile(request.getData(), "response.txt");
                String response = "Data receives";
                DatagramPacket reply = new DatagramPacket(response.getBytes(),response.length(),request.getAddress(), request.getPort());
                aSocket.send(reply);    
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
