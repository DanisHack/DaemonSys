/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daemonsys;

import java.net.Socket;

/**
 *
 * @author Haseeb
 */

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class DaemonServerCon implements Runnable {
           String ClientMSG;
           String CapMSG;
           char x;
           InputStreamReader instream = null;
           DataOutputStream outstream = null;
           Socket ClientSoc;
           TCPServer s;
           int d;
    DaemonServerCon(Socket ClientSoc, int i, TCPServer s) {
         this.ClientSoc = ClientSoc;
         this.s = s;
         this.d=i;
    }
public void run() {
        
            System.out.println("current thread is:" + Thread.currentThread());
        try {
            instream = new InputStreamReader(ClientSoc.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(DaemonServerCon.class.getName()).log(Level.SEVERE, null, ex);
        }
            BufferedReader inFromClient = new BufferedReader(instream);
        try {
            outstream = new DataOutputStream(ClientSoc.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(DaemonServerCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ClientMSG = inFromClient.readLine();
        } catch (IOException ex) {
            Logger.getLogger(DaemonServerCon.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Recieved:" + ClientMSG);
            CapMSG = ClientMSG.toUpperCase() + "\n";
        try {
            outstream.writeBytes(CapMSG);
        } catch (IOException ex) {
            Logger.getLogger(DaemonServerCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
