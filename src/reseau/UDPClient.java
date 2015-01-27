/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseau;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author Morgan Coiffier
 */
public class UDPClient {

    public void transferFile(ArrayList<byte[]> fileByte,String target,int port) {
        // args give message contents and destination host  
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            InetAddress aHost = InetAddress.getByName(target);
            byte[] buffer = new byte[1000];
            
            for (byte[] byteTab : fileByte) {
                DatagramPacket request = new DatagramPacket(byteTab, byteTab.length, aHost, port);
                aSocket.send(request);     
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(reply);
                System.out.println("Reply: " + new String(reply.getData()));
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
