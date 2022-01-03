import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
public class People implements Serializable  {

    protected People(){
        
        
    }
    protected boolean vote(String NIC, String FN, String LN, String MFN, String MLN, int Age ){
        String tempnic = "";
        boolean found = false;              
            try{
                File file = new File("Voters.txt");
                if(file.length() != 0){
                    Scanner read = new Scanner(file);
                    read.useDelimiter("[,\n]");
                    while(read.hasNext()){
                        tempnic = read.next();
                        if(tempnic.trim().equals(NIC)){found = true;}
                                
                        }
                        read.close();    
                    }
                if(found == false){
                    try{
                        File fil = new File("Voters.txt");
                        FileWriter writer  = new FileWriter(fil,true);
                        writer.append(NIC+","+FN+","+LN+","+MFN+","+MLN+","+Age);
                        writer.append("\n");
                        writer.close();
                        }catch(IOException ee){ee.getStackTrace();}
                        
                    } 
                }catch(IOException ee){ee.getStackTrace();}
                
            
            return found;
        }
            
   public static void main(String[] args) {
       //People p = new People();
       //p.vote(NIC, FN, MN, LN, MFN, MMN, MLN, Age)
   } 
   
   
}
