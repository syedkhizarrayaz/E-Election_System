import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.image.*;
public class People_Page implements ActionListener{
    // class attributes and intialization
    protected JFrame frame = new JFrame("Voter");

    private JButton Vote = new JButton("Vote");

    private JTextField User_NIC_Field = new JTextField();
    private JTextField User_First_Name_Field = new JTextField();
    private JTextField User_Last_Name_Field = new JTextField();
    private JTextField User_Mothers_First_Name_Field = new JTextField();
    private JTextField User_Mothers_Last_Name_Field = new JTextField();
    private JTextField User_Age_Field = new JTextField();

    private JLabel User_NIC_Label = new JLabel("NIC: ");
    private JLabel User_First_Name_Label = new JLabel("First Name: ");
    private JLabel User_Last_Name_Label = new JLabel("Last Name: ");
    private JLabel User_Mothers_First_Name_Label = new JLabel("Mother's First Name: ");
    private JLabel User_Mothers_Last_Name_Label = new JLabel("Mother's Last Name: ");
    private JLabel User_Age_Label = new JLabel("Age: ");
    private JLabel message_label = new JLabel();
    private JLabel message_label1 = new JLabel();
    private JLabel ET_Label = new JLabel();

    private JButton Back = new JButton("Back");

    protected People_Page(){
        // for election type label read
        try{
            FileInputStream fil = new FileInputStream("Election_Type.dat");
            ObjectInputStream in = new ObjectInputStream(fil);
            String a = in.readUTF();
            ET_Label.setText(a);
            in.close();
         }catch(Exception e){e.getStackTrace();}  

        // set locations and properties of buttons, labels and textfields
        User_NIC_Label.setBounds(25, 100, 100, 50);
        User_First_Name_Label.setBounds(25,150,100,50);
        User_Last_Name_Label.setBounds(25, 200, 200, 50);
        User_Mothers_First_Name_Label.setBounds(25, 250, 200, 50);
        User_Mothers_Last_Name_Label.setBounds(25, 300, 200, 50);
        User_Age_Label.setBounds(25, 350, 75, 50);
        message_label.setBounds(125, 400, 250, 35);
        message_label1.setBounds(125, 400, 250, 35);
        ET_Label.setBounds(100, 25, 250, 50);
        ET_Label.setFont(new Font("Calibri Light ",Font.BOLD,15)); // font

        Back.setBounds(0, 0, 25, 15);
        Back.setBackground(Color.white); // color of back button

        User_NIC_Field.setBounds(160, 116, 200, 25);
        User_First_Name_Field.setBounds(160, 167, 200, 25);   
        User_Last_Name_Field.setBounds(160, 215, 200, 25);
        User_Mothers_First_Name_Field.setBounds(160, 265, 200, 25);
        User_Mothers_Last_Name_Field.setBounds(160, 315, 200, 25);
        User_Age_Field.setBounds(160, 363, 200, 25);

        Vote.setBounds(125, 435, 100, 25);
        Vote.setFocusable(false);
        Vote.setBackground(new Color(51,153,255)); // button colour
        Vote.setForeground(Color.white); // button colour
        Back.setFocusable(false);
        // add action
        Vote.addActionListener(this);
        Back.addActionListener(this);
        
        //for back button picture arrow
        File file = new File("back arrow.png");
        try{
            BufferedImage img = null;
            img = ImageIO.read(file);
            Image img1 = img.getScaledInstance(Back.getWidth(), Back.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img1);
            Back.setIcon(icon);
        }catch(Exception e){e.getStackTrace();}

        // frame additon of labels, buttons, textfileds
        frame.add(User_NIC_Field);
        frame.add(User_First_Name_Field);
        frame.add(User_Last_Name_Field);
        frame.add(User_Mothers_First_Name_Field);
        frame.add(User_Mothers_Last_Name_Field);
        frame.add(User_Age_Field);
        frame.add(message_label);
        frame.add(User_NIC_Label);
        frame.add(User_First_Name_Label);
        frame.add(User_Last_Name_Label);
        frame.add(User_Mothers_First_Name_Label);
        frame.add(User_Mothers_Last_Name_Label);
        frame.add(User_Age_Label);
        frame.add(message_label1);
        frame.add(Vote);
        frame.add(ET_Label);
        frame.add(Back);

        //frame setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,640);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private final boolean vote(String NIC, String FN, String LN, String MFN, String MLN, int Age ){
        String tempnic = "";
        boolean found = false;
        // check nic if nic found in database              
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
                    // if nic not found then add details
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Vote){
            // user data collection from frame
            String NIC = User_NIC_Field.getText();
            String First_Name = User_First_Name_Field.getText();
            String Last_Name = User_Last_Name_Field.getText();
            String Mothers_First_Name = User_Mothers_First_Name_Field.getText();
            String Mothers_Last_Name = User_Mothers_Last_Name_Field.getText();
            int Age = Integer.parseInt(User_Age_Field.getText());
            // check age
            if(Age >= 18){
                // vote function
            boolean v = vote(NIC, First_Name, Last_Name, Mothers_First_Name, Mothers_Last_Name, Age);
            if(v == false){
                // if user available for vote proceed to vote class
                frame.dispose();
                frame.toBack();
                Vote_Page vp = new Vote_Page();
                vp.frame.setVisible(true);
                vp.frame.toFront();
                // for demographic data
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter write = new FileWriter(fil,true);
                    write.append(""+Age+",");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
            }else{
                message_label.setText("You have already Voted");
            }  
        }else{
            message_label1.setText("You are not eligible");
        }}
        if(e.getSource() == Back){
            // back to previous frame
            frame.dispose();
            frame.toBack();
            E_Election_System_Page eesp = new E_Election_System_Page();
            eesp.frame.setVisible(true);
            eesp.frame.toFront();
        }
    }    
}