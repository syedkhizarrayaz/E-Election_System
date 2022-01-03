import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;

public class Sign_Up_Page implements ActionListener{
    // class attributes
    protected JFrame frame = new JFrame("Voter");

    private JTextField First_Name;
    private JTextField Last_Name;
    private JTextField user_Name;
    private JTextField Password;
    private JTextField Confirm_Password;

    private JComboBox Date; 
    private JComboBox Month;
    private JComboBox Year;

    private JLabel First_Name_label;
    private JLabel Last_name_label;
    private JLabel Username_label;
    private JLabel Password_label;
    private JLabel CP_Label;
    private JLabel Dob;

    private JButton Finish;
    private JButton Back = new JButton("Back");

    private JLabel message;
    private JLabel message1;

    protected Sign_Up_Page(){
    // intialization and setup of attributes
    String days[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String months[] = {"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
    String years[] = {"2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987","1986","1985","1984","1983","1982","1981","1980","1979","1978","1977","1976","1975","1974","1973","1972","1971","1970","1969","1968","1967","1966","1965","1964","1963","1962","1961","1960"};
    
    First_Name = new JTextField();
    Last_Name = new JTextField();
    user_Name = new JTextField();
    Password = new JTextField();
    Confirm_Password = new JTextField();

    Date = new JComboBox(days);
    Month = new JComboBox(months);
    Year = new JComboBox(years);

    Dob = new JLabel("Date of Birth: ");
    First_Name_label = new JLabel("First Name: ");
    Last_name_label = new JLabel("Lats Name: ");
    Password_label = new JLabel("Password: ");
    CP_Label = new JLabel("Confirm Password: ");
    Username_label =  new JLabel("Username: ");

    Finish = new JButton("Finish");

    message = new JLabel();
    message1 = new JLabel();

    // loactions of buttons, labels, comboboxes, textfields
    First_Name_label.setBounds(25, 30, 75, 50);
    Last_name_label.setBounds(25, 80, 75, 50);
    Username_label.setBounds(25, 180, 75, 50);
    Password_label.setBounds(25, 230, 125, 50);
    CP_Label.setBounds(25, 280, 125, 50);

    First_Name.setBounds(138, 44, 200, 25);
    Last_Name.setBounds(138, 94, 200, 25);
    user_Name.setBounds(138, 192, 200, 25);
    Password.setBounds(138, 244, 200, 25);
    Confirm_Password.setBounds(138, 294, 200, 25);

    Date.setBounds(138, 142, 40, 25);
    Date.setBackground(new Color(51,153,255));
    Date.setForeground(Color.white);
    Month.setBounds(200, 142, 50, 25);
    Month.setBackground(new Color(51,153,255));
    Month.setForeground(Color.white);
    Year.setBounds(270, 142, 55, 25);
    Year.setBackground(new Color(51,153,255));
    Year.setForeground(Color.white);

    Dob.setBounds(25, 142, 100, 25);
    Finish.setBounds(270, 400, 100, 25);
    Finish.setBackground(new Color(51,153,255));
    Finish.setForeground(Color.white);
    Back.setBounds(0, 0, 25, 15);
    Back.setBackground(Color.WHITE);
    Back.setFocusable(false);

    message.setBounds(115, 400, 250, 35);
    message1.setBounds(115, 400, 250, 35);

    // frame addition of attributes
    frame.add(First_Name_label);
    frame.add(Last_name_label);
    frame.add(Username_label);
    frame.add(Password_label);
    frame.add(CP_Label);
    frame.add(First_Name);
    frame.add(Last_Name);
    frame.add(user_Name);
    frame.add(Password);
    frame.add(Confirm_Password);
    frame.add(Date);
    frame.add(Month);
    frame.add(Year);
    frame.add(Dob);
    frame.add(Finish);
    frame.add(Back);
    frame.add(message);
    frame.add(message1);

    // add action
    Finish.addActionListener(this);
    Date.addActionListener(this);
    Month.addActionListener(this);
    Year.addActionListener(this);
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

    // characteristics
    Finish.setFocusable(false);
    Date.setFocusable(false);
    Month.setFocusable(false);
    Year.setFocusable(false);

    // frame setup
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420,640);
    frame.setLayout(null);
    frame.setVisible(true);
    
    }

    private final void sign_Up(String fn, String ln, String dob, String Un, String Pas){
        String tempun = "";
        boolean found = false;
        // check if admin already exist with username selected
        try{
        File file = new File("admin.txt");
        if(file.length() != 0){
        Scanner read = new Scanner(file);
        read.useDelimiter("[,\n]");
        while(read.hasNext()){
            tempun = read.next();
            if(tempun.trim().equals(Un.trim())){found = true;}
        }
        read.close();
    }
        if(found == false){
            // if not exist add details of new admin
            FileWriter write = new FileWriter(file, true);
            write.append(Un);
            write.append(",");
            write.append(Pas);
            write.append("\n");
            write.close();
            try{
                File fil = new File("Admin details.txt");
                FileWriter writer = new FileWriter(fil,true);
                writer.append(fn+","+ln+","+dob+"\n");
                writer.close();
            }catch(IOException e){e.getStackTrace();}
            message.setText("Admin Created Sucessfully");
        }else{
            message.setText("Admin already exist");
        }
        
        }catch(IOException e){e.getStackTrace();}
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == Finish){
           // get field data
           String fn = First_Name.getText();
           String ln = Last_Name.getText();
           String un = user_Name.getText();
           String pas = Password.getText();
           String cpas = Confirm_Password.getText();
           String dob = Date.getSelectedItem() + "," + Month.getSelectedItem()+ ","+ Year.getSelectedItem();
           // if pasword and confrim passowrd matches signup
           if(pas.trim().equals(cpas.trim())){
           sign_Up(fn,ln,dob,un,cpas);
           }else{
               message1.setText("Passwords do not match");
           }
       }
       if(e.getSource() == Back){
        // back to previous frame
        frame.dispose();
        frame.toBack();
        Admin_Settings_Page asp = new Admin_Settings_Page();
        asp.frame.setVisible(true);
        asp.frame.toFront();
    }
}
}