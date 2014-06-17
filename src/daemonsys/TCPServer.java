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
public class TCPServer
{

    /**
     * @param args the command line arguments
     */
          
           ServerSocket WelSoc = null;
           Socket ConnSoc = null;
           int i;
           
    public static void main(String[] args) throws Exception
    {
           
           System.out.println("please type d to deamonize server\n");
           
           if(System.in.read() == 'd')
           {
             TCPServer serv = new TCPServer();
             serv.DaemonServer();
                 
           }
           else
           { TCPServer serv = new TCPServer();
              serv.NormalServer();
           }
    }

    public void NormalServer()
    {
     try{
                 WelSoc = new ServerSocket(6789);
                 System.out.println("Client Connecting to port 6789...");
                 while(true)
                 {    ConnSoc = WelSoc.accept();
                      i++;
                      ServerCon serv2 = new ServerCon(ConnSoc,i,this);
                     Thread t = new Thread(serv2);
                     if(!t.isDaemon())
                         System.out.println("This is normal thread, not daemon :)");
                    t.start();
                    try {
                         Thread.sleep(500);
                        } catch (InterruptedException x) {
                          }
                 }
               } catch (Exception e){System.out.println("Exception:"+e);}
    }

   
    private void DaemonServer() {
            try{
                 WelSoc = new ServerSocket(6789);
                 System.out.println("Client Connecting to port 6789...");
                 while(true)
                 {    ConnSoc = WelSoc.accept();
                      i++;
                     DaemonServerCon serv2 = new DaemonServerCon(ConnSoc,i,this);
                     Thread t = new Thread(serv2);
                     t.setDaemon(true);
                     if(t.isDaemon())
                     System.out.println("This is Daemon :) :) ");
                     t.start();

                    try {
                         Thread.sleep(500);
                        } catch (InterruptedException x) {
                          }
                 }
               } catch (Exception e){System.out.println("Exception:"+e);}
    }
}


