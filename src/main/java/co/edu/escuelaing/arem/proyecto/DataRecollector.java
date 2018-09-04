package co.edu.escuelaing.arem.proyecto;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;

/**
 *
 * @author Nicolás
 */
public class DataRecollector {
    
    public String readResource(String direction){
        
        // Read a txt document and convert to MyLinkedList Class
        
        
        
        if(direction.toLowerCase().contains(".png".toLowerCase())||direction.toLowerCase().contains(".jpg".toLowerCase())){
            
            Image outputFile = new ImageIcon("./resources/"+direction).getImage();
            
            System.out.println("CAMINO:  " +outputFile.toString());
            return ("<!DOCTYPE html>"
                    +"<?php"
                    +"$contents = all_bytes_from_created_image();"
                    // Get the bytes from the created image.
                    +"$base64 = base64_encode($contents);"
                    + "?>"
                    +"<html>"
                    +"<head>"
                    +"<title>Page Title</title>"
                    +"</head>"
                    +"<body>"  
                    + "<img src=\"data:image/png;base64,<?php echo $base64; ?>\" alt="" />"
                    +"<html>");
 
            
            
            
            
        }
        
        String resource="";
        try{
            BufferedReader bf = new BufferedReader(new FileReader("resources/"+direction));
            String temp = "";
            String bfRead;
            while( (bfRead = bf.readLine())!=null){
                temp=temp+bfRead;                
            }
            resource = temp;
            
        }catch(Exception e){
            System.err.println("No se ha encontrado el archivo");
                
        }
        System.out.println(resource);
        return resource;
    }
    
}