/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package daemonsys;

/**
 *
 * @author Danish
 */
import java.net.*;
import java.io.*;
public class TCPClient {
 public static void main(String[] args) throws Exception {
         String ServerMSG;
         String toSendMSG;
         System.out.println("Please write what you want to send!! \n");
         InputStreamReader instreamclient = new InputStreamReader(System.in);
         BufferedReader inFromUser = new BufferedReader(instreamclient);
         Socket ClientSoc = new Socket("localhost",6789);
         DataOutputStream outToServer = new DataOutputStream(ClientSoc.getOutputStream());
         BufferedReader inFromServer = new BufferedReader(new InputStreamReader(ClientSoc.getInputStream()));
         toSendMSG = inFromUser.readLine();
         outToServer.writeBytes(toSendMSG + '\n');
         ServerMSG = inFromServer.readLine();
         System.out.println(ServerMSG);
         ClientSoc.close();

}


}
