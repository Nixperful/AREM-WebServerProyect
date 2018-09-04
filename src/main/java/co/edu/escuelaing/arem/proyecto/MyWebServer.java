
package co.edu.escuelaing.arem.proyecto;

/**
 *
 * @author Nicolás
 */
import java.net.*;

import java.io.*;

public class MyWebServer {

    public static void main(String[] args) throws IOException {
        
        SocketConnection sC= new SocketConnection();        
        ServerSocket serverSocket = sC.getServerConnection();
        
        boolean isCompleted=false;
        
        try{           
        
            while(!isCompleted){ 

                Socket clientSocket = sC.getClientConnection(serverSocket);
                RequestHandler rH = new RequestHandler(clientSocket);
                
                DataRecollector dR = new DataRecollector();
                String finalResource = dR.readResource(rH.getRequest());
                
                

            }

            
                    
                    
                    

            out.println(outputLine);



                in.close(); 
                out.close();   
                clientSocket.close();
            
            
             
        }finally{
            serverSocket.close();
        }
        
    }
    
    static int getPort() {
            if (System.getenv("PORT") != null) {
                return new Integer(System.getenv("PORT"));
            }
            return 35000; //returns default port if heroku-port isn't set (i.e. on localhost)
    } 

}
