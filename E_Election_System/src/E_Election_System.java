import java.util.Scanner;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
public class E_Election_System implements ActionListener {

    private String Participating_Parties;
    private int Graph;
    private int Demographic_Data;
    public String Election_Type;

    E_Election_System(){}

    public void Total_Votes(){
        int sum = 0;
        try{
            Scanner file = new Scanner(new File("Pakistan Tehreek-e-Insaf vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Pakistan Tehreek-e-Insaf = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum =0;
        try{
            Scanner file = new Scanner(new File("Awami Muslim League Pakistan vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Awami Muslim League Pakistan = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum =0;
        try{
            Scanner file = new Scanner(new File("Awami National Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Awami National Party = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Balochistan Awami Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Balochistan Awami Party = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Balochistan National Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Balochistan National Party = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Grand Democratic Alliance vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Grand Democratic Alliance = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Jamaat-e-Islami vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Jamaat-e-Islami = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Jamhoori Wattan Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Jamhoori Wattan Party = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("JUI-F vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("JUI-F = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Milli Awami Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Milli Awami Party = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Muslim League (Q) vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Muslim League (Q) = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Muslim League N vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Muslim League N = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Muttahida Qaumi Moment vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Muttahida Qaumi Moment = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("National Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("National Party = "+sum);

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Peoples Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            System.out.println("Peoples Party = "+sum);

        }catch(IOException e){e.getStackTrace();}
        
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton Vote = new JButton("Vote");
        JTextField user_NIC_Field = new JTextField();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }}
