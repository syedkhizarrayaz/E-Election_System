import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class E_Election_System_Page implements ActionListener {

    //class attributes
    protected JFrame frame = new JFrame("Voter");

    private JButton Voter = new JButton("Vote");
    private JButton Admin = new JButton("Admin");

    private JLabel Name = new JLabel("Voter");
protected E_Election_System_Page(){
    //location of attributes in frames and chracteristics
    Voter.setBounds(130, 250, 100, 25);
    Admin.setBounds(130, 300, 100, 25);

    Name.setBounds(130, 50, 100, 25);
    Name.setFont(new Font("Times New Roman", Font.BOLD, 40)); // font of header

    Voter.setFocusable(false);
    Admin.setFocusable(false);
    // add action
    Voter.addActionListener(this);
    Admin.addActionListener(this);

    //frame colour
    frame.setBackground(new Color(255,255,255));
    frame.setForeground(Color.WHITE);

    // buttons colour
    Voter.setBackground(new Color(51,153,255));
    Voter.setForeground(Color.white);
    Admin.setBackground(new Color(51,153,255));
    Admin.setForeground(Color.white);

    //addition of buttons and labels to frame
    frame.add(Voter);
    frame.add(Admin);
    frame.add(Name);
    // frame setup
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,640);
    frame.setLayout(null);
    frame.setVisible(true);
}    
    @Override
    public void actionPerformed(ActionEvent e) {
        // voter button action
        if(e.getSource() == Voter){
            frame.dispose();
            frame.toBack();
            // proceed to people class
            People_Page pp = new People_Page();
            pp.frame.setVisible(true);
            pp.frame.toFront();
        }
        // admin button action
        if(e.getSource() == Admin){
            frame.dispose();
            frame.toBack();
            // proceed to admin class
            Admin_Page ap = new Admin_Page();
            ap.frame.setVisible(true);
            ap.frame.toFront();  
        }
    }
    public static void main(String[] args) {
        E_Election_System_Page e = new E_Election_System_Page();
    }
    
}
