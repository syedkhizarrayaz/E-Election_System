import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.awt.image.*;

public class Admin_Settings_Page implements ActionListener, Serializable {
    // class attributes
    protected JFrame frame = new JFrame("Voter");

    private JButton CNA_Button = new JButton("Create New Admin");
    private JButton SET_Button = new JButton("Set up Election Type");
    private JButton VI_Buton = new JButton("Voters Details");

    private JPanel panel1;

    private JTextArea Text_Area;

    private JComboBox Election_Type;

    private JLabel Election_Type_Label;
    private JLabel message;

    private JButton Save_Changes;
    private JButton Demographic_Button;
    private JButton Back = new JButton("Back");

    private JScrollPane sp;

protected Admin_Settings_Page(){
    // attributes intilization and setups
    String [] Elections = {"National Assembly","Provincial Assembly","Senate","Local Body"};

    panel1 = new JPanel();

    Text_Area = new JTextArea();

    Election_Type_Label = new JLabel("Choose the Election Type: ");
    message = new JLabel();

    Election_Type = new JComboBox(Elections);

    Save_Changes = new JButton("Save Changes");
    Demographic_Button = new JButton("Demographic Data");
    
    sp = new JScrollPane();
    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    // for location of buttons, comboxes, textarea, scrollpanes, labels
    Election_Type.setBounds(160, 45, 150, 25);

    Election_Type_Label.setBounds(160, 20, 150, 25);

    panel1.setBounds(0, 25, 150, 640);

    CNA_Button.setBounds(0,50,140,25);
    SET_Button.setBounds(0, 100, 160, 25);
    VI_Buton.setBounds(0,150,150,25);

    Text_Area.setBounds(160,25,250,640);
    Text_Area.setBorder(new LineBorder(new Color(51,153,255))); // textarea colour

    message.setBounds(190, 400, 250, 35);
    Save_Changes.setBounds(265, 460, 125, 25);
    Demographic_Button.setBounds(0, 200, 160, 25);

    Text_Area.setLineWrap(true);
    Text_Area.setWrapStyleWord(true);

    panel1.setBackground(new Color(150,150,150)); // panel colour

    Back.setBounds(0, 0, 25, 15);
    Back.setBackground(Color.WHITE);
    Back.setFocusable(false);

    sp.setBounds(160,25,250,640); // scrollpane colour
    sp.getViewport().setBackground(Color.white);
    sp.getViewport().add(Text_Area); // add text area to scrollpane

    Text_Area.setBackground(Color.WHITE); // textarea colour
 
    // panel setup
    panel1.add(CNA_Button);
    panel1.add(SET_Button);
    panel1.add(VI_Buton);
    panel1.add(Demographic_Button);
   

    // add action
    VI_Buton.addActionListener(this);
    SET_Button.addActionListener(this);
    Save_Changes.addActionListener(this);
    CNA_Button.addActionListener(this);
    Election_Type.addActionListener(this);
    Demographic_Button.addActionListener(this);
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

    // frame additon of panel, buttons, labels
    frame.add(panel1);
    frame.add(Back);
    frame.add(message);

    // characteristics of buttons
    VI_Buton.setFocusable(false);
    SET_Button.setFocusable(false);
    Save_Changes.setFocusable(false);
    CNA_Button.setFocusable(false);
    Election_Type.setFocusable(false);
    Demographic_Button.setFocusable(false);

    // color setup of buttons and labels
    VI_Buton.setBackground(new Color(51,153,255));
    VI_Buton.setForeground(Color.white);
    SET_Button.setBackground(new Color(51,153,255));
    SET_Button.setForeground(Color.white);
    Save_Changes.setBackground(new Color(51,153,255));
    Save_Changes.setForeground(Color.white);
    CNA_Button.setBackground(new Color(51,153,255));
    CNA_Button.setForeground(Color.white);
    Election_Type.setBackground(new Color(51,153,255));
    Election_Type.setForeground(Color.white);
    Demographic_Button.setBackground(new Color(51,153,255));
    Demographic_Button.setForeground(Color.white);

    // frame setup
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(450,640);
    frame.setLayout(null);
    frame.setVisible(true);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        // to read voter details
        if(e.getSource() == VI_Buton){
            frame.remove(Election_Type_Label);
            frame.remove(Election_Type);
            frame.remove(Save_Changes);
            frame.add(sp);
            String tempnic = "";
            String tempfirstname = "";
            String templastname = "";
            String tempmothersfirstname = "";
            String tempmotherslastname = "";
            String tempage = "";
                try{
                    File fil = new File("Voters.txt");
                    if(fil.length() != 0){
                        Scanner read = new Scanner(fil);
                        read.useDelimiter("[,\n]");
                        while(read.hasNext()){
                            tempnic = read.next();
                            tempfirstname= read.next();
                            templastname = read.next();
                            tempmothersfirstname = read.next();
                            tempmotherslastname = read.next();
                            tempage = read.next();
                            Text_Area.append("NIC: "+tempnic+"\n"+"Name: "+tempfirstname+" "+templastname+"\n"+" Mother's Name: "+tempmothersfirstname+" "+tempmotherslastname+"\n"+" Age: "+tempage+"\n");
                            }
                            read.close();
                        }else{
                            Text_Area.append("File is empty");
                        }
                    }catch(IOException ee){ee.getStackTrace();}
        } 
        if(e.getSource() ==  SET_Button){
            // for election type setup
            frame.remove(sp);
            frame.add(Election_Type_Label);
            frame.add(Election_Type);
            frame.add(Save_Changes);

        }
        if(e.getSource() == Election_Type){
            try{
                // saving election type
                FileOutputStream f = new FileOutputStream("Election_Type.dat");
                ObjectOutputStream writer = new ObjectOutputStream(f);
                writer.writeUTF(Election_Type.getSelectedItem()+" Elections");
                writer.close();
            }catch(Exception ee){ee.getStackTrace();}
            }
        if(e.getSource() == Save_Changes){
            Election_Type.setEnabled(false);
            message.setText("Election Type Changed Successfully");
        }
        if(e.getSource() == CNA_Button){
            // for new admin 
            frame.dispose();
            frame.toBack();
            Sign_Up_Page sup = new Sign_Up_Page();
            sup.frame.setVisible(true);
            sup.frame.toFront();
        }
        if(e.getSource() == Demographic_Button){
            // diplay demographic data chart
            Demographic_Data dd = new Demographic_Data();
            dd.chart();
        }
        if(e.getSource() == Back){
            // back to previous frame
            frame.dispose();
            frame.toBack();
            Admin_Page ap = new Admin_Page();
            ap.frame.setVisible(true);
            ap.frame.toFront();
        }
    }
}