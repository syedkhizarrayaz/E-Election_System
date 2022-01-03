import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.*;
import java.awt.image.*;
public class Admin_Page implements ActionListener{
    // class attributes and intilization
    protected JFrame frame = new JFrame("Voter");

    private JTextField User_Name_Field = new JTextField();
    private JTextField User_Password_Field = new JTextField();

    private JLabel User_Name_Label = new JLabel("User Name: ");
    private JLabel User_Passwrod_Label = new JLabel("Password: ");

    private JButton Login_Button = new JButton("Login");

    private JLabel message_label = new JLabel();
    private JLabel message_label1 = new JLabel();

    private JButton Back = new JButton("Back");

    protected Admin_Page(){
        // frame properties setup and location on frmae
        User_Name_Label.setBounds(50, 200, 100, 50);
        User_Passwrod_Label.setBounds(50, 250, 100, 50);
        message_label.setBounds(120, 400, 250, 35);
        message_label1.setBounds(70, 400, 250, 35);

        User_Name_Field.setBounds(125, 215, 200, 25);
        User_Password_Field.setBounds(125, 265, 200, 25);
        
        Login_Button.setBounds(130, 350, 100, 25);
        Login_Button.setFocusable(false);
        Login_Button.setBackground(new Color(51,153,255));
        Login_Button.setForeground(Color.white);
        Back.setBounds(0, 0, 25, 15);
        Back.setBackground(Color.WHITE);
        Back.setFocusable(false);

        // action
        Login_Button.addActionListener(this);
        Back.addActionListener(this);

        // back button icon
        File file = new File("back arrow.png");
        try{
            BufferedImage img = null;
            img = ImageIO.read(file);
            Image img1 = img.getScaledInstance(Back.getWidth(), Back.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img1);
            Back.setIcon(icon);
        }catch(Exception e){e.getStackTrace();}

        // farme addition of buttons, labels, fields
        frame.add(User_Name_Label);
        frame.add(User_Passwrod_Label);
        frame.add(message_label);
        frame.add(message_label1);
        frame.add(User_Name_Field);
        frame.add(User_Password_Field);
        frame.add(Login_Button);
        frame.add(Back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,640);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private final boolean login(String Username ,String Password){
        boolean found = false;
        String tempun = "";
        String temppas = "";
        // to verify admin
        try{
            Scanner file = new Scanner(new File("Admin.txt"));
            file.useDelimiter("[,\n]");
            while(file.hasNext() && !found){
                tempun = file.next();
                temppas = file.next();
                if(tempun.trim().equals(Username.trim()) && temppas.trim().equals(Password.trim())){
                    found = true;
                }
            }
           file.close();     
        }catch(IOException e){e.getStackTrace();}
        return found;
        
}

    @Override
    public void actionPerformed(ActionEvent e) {
        // for login data collection
        String UN = User_Name_Field.getText();
        String Pas = User_Password_Field.getText();
        if(e.getSource() == Login_Button){
            boolean ln = login(UN, Pas);
            if(ln == true){
                //if logged in then setting class proceed
                message_label.setText("Loggedin Sucessful");
                frame.dispose();
                frame.toBack();
                Admin_Settings_Page asp = new Admin_Settings_Page();
                asp.frame.setVisible(true);
                asp.frame.toFront();
            }else{
                message_label1.setText("Username and Password do not match");
            }
        }
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