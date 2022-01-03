import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import java.awt.Color;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import java.awt.image.*;

public class Vote_Page implements ActionListener{
    // class attributes
    protected JFrame frame = new JFrame("Voter");
    private JRadioButton PTI_Button;
    private JRadioButton PMLN_Button;
    private JRadioButton PP_Button;
    private JRadioButton MQM_Button;
    private JRadioButton JI_Button;
    private JRadioButton JUIF_Button;
    private JRadioButton MLQ_Button;
    private JRadioButton ANP_Button;
    private JRadioButton NP_Button;
    private JRadioButton BNP_Button;
    private JRadioButton GDA_Button;
    private JRadioButton JWP_Button;
    private JRadioButton AMLP_Button;
    private JRadioButton BAP_Button;
    private JRadioButton MAP_Button;
    private JButton Submit_Button;
    private JButton Back = new JButton("Back");

    protected Vote_Page(){
        // frame setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // radiobutton intialization
        PTI_Button = new JRadioButton("Pakistan Tehreek-e-Insaf");
        PMLN_Button = new JRadioButton("Muslim League (N)");
        PP_Button = new JRadioButton("Peoples Party)");
        MQM_Button = new JRadioButton("Muttahida Qaumi Movement");
        JI_Button = new JRadioButton("Jamaat-e-Islami");
        JUIF_Button = new JRadioButton("JUI-F");
        MLQ_Button = new JRadioButton("Muslim League (Q))");
        ANP_Button = new JRadioButton("Awami National Party");
        NP_Button = new JRadioButton("National Party");
        BNP_Button = new JRadioButton("Balochistan National Party");
        GDA_Button = new JRadioButton("Grand Democratic Alliance");
        JWP_Button = new JRadioButton("Jamhoori Wattan Party");
        AMLP_Button = new JRadioButton("Awami Muslim League Pakistan");
        BAP_Button = new JRadioButton("Balochistan Awami Party");
        MAP_Button = new JRadioButton("Milli Awami Party");
        Submit_Button = new JButton("Submit");

        // for location of radiobuttons and buttons on frame 
        PTI_Button.setBounds(60, 100, 250, 25);
        PMLN_Button.setBounds(60, 120, 250, 25);
        PP_Button.setBounds(60, 140, 250, 25);
        MQM_Button.setBounds(60, 160, 250, 25);
        JI_Button.setBounds(60, 180, 250, 25);
        JUIF_Button.setBounds(60, 200, 250, 25);
        MLQ_Button.setBounds(60, 220, 250, 25);
        ANP_Button.setBounds(60, 240, 250, 25);
        NP_Button.setBounds(60, 260, 250, 25);
        BNP_Button.setBounds(60, 280, 250, 25);
        GDA_Button.setBounds(60, 300, 250, 25);
        JWP_Button.setBounds(60, 320, 250, 25);
        AMLP_Button.setBounds(60, 340, 250, 25);
        BAP_Button.setBounds(60, 360, 250, 25);
        MAP_Button.setBounds(60, 380, 250, 25);

        Submit_Button.setBounds(250, 460, 100, 25);
        Back.setBounds(0, 0, 25, 15);
        Back.setBackground(Color.WHITE); // back button colour
        Back.setFocusable(false);
        Submit_Button.setBackground(new Color(51,153,255)); // submit button colour
        Submit_Button.setForeground(Color.white);

        // radio button cutomization
        Submit_Button.setFocusable(false);
        PTI_Button.setFocusable(false);
        PMLN_Button.setFocusable(false);
        PP_Button.setFocusable(false);
        MQM_Button.setFocusable(false);
        JI_Button.setFocusable(false);
        JUIF_Button.setFocusable(false);
        MLQ_Button.setFocusable(false);
        ANP_Button.setFocusable(false);
        NP_Button.setFocusable(false);
        BNP_Button.setFocusable(false);
        GDA_Button.setFocusable(false);
        JWP_Button.setFocusable(false);
        AMLP_Button.setFocusable(false);
        BAP_Button.setFocusable(false);
        MAP_Button.setFocusable(false);

        // jradiobutton group
        ButtonGroup group = new ButtonGroup();
        group.add(PTI_Button);
        group.add(PMLN_Button);
        group.add(PP_Button);
        group.add(MQM_Button);
        group.add(JI_Button);
        group.add(JUIF_Button);
        group.add(MLQ_Button);
        group.add(ANP_Button);
        group.add(NP_Button);
        group.add(BNP_Button);
        group.add(GDA_Button);
        group.add(JWP_Button);
        group.add(AMLP_Button);
        group.add(BAP_Button);
        group.add(MAP_Button);

        // add action
        PTI_Button.addActionListener(this);
        PMLN_Button.addActionListener(this);
        PP_Button.addActionListener(this);
        MQM_Button.addActionListener(this);
        JI_Button.addActionListener(this);
        JUIF_Button.addActionListener(this);
        MLQ_Button.addActionListener(this);
        ANP_Button.addActionListener(this);
        NP_Button.addActionListener(this);
        BNP_Button.addActionListener(this);
        GDA_Button.addActionListener(this);
        JWP_Button.addActionListener(this);
        AMLP_Button.addActionListener(this);
        BAP_Button.addActionListener(this);
        MAP_Button.addActionListener(this);
        Submit_Button.addActionListener(this);
        Back.addActionListener(this);

        //for back arrow image
        File file = new File("back arrow.png");
    try{
        BufferedImage img = null;
        img = ImageIO.read(file);
        Image img1 = img.getScaledInstance(Back.getWidth(), Back.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(img1);
        Back.setIcon(icon);
    }catch(Exception e){e.getStackTrace();}

        // frame additon of attributes
        frame.add(PTI_Button);
        frame.add(PMLN_Button);
        frame.add(PP_Button);
        frame.add(MQM_Button);
        frame.add(JI_Button);
        frame.add(JUIF_Button);
        frame.add(MLQ_Button);
        frame.add(ANP_Button);
        frame.add(NP_Button);
        frame.add(BNP_Button);
        frame.add(GDA_Button);
        frame.add(JWP_Button);
        frame.add(AMLP_Button);
        frame.add(BAP_Button);
        frame.add(MAP_Button);
        frame.add(Submit_Button);
        frame.add(Back);



    // frame setup
    frame.setSize(400,640);
    frame.setVisible(true);
    }
    private final void Total_Votes(){
        // for vote chart display and calculation
        int sum = 0;
        DefaultCategoryDataset dod = new DefaultCategoryDataset();
        // read files for vote calculation and add it to cahrt
        try{
            Scanner file = new Scanner(new File("Pakistan Tehreek-e-Insaf vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
           dod.setValue(sum, "Votes", "PTI");

        }catch(IOException e){e.getStackTrace();}
        sum =0;
        try{
            Scanner file = new Scanner(new File("Awami Muslim League Pakistan vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "AMLP");
        }catch(IOException e){e.getStackTrace();}
        sum =0;
        try{
            Scanner file = new Scanner(new File("Awami National Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "ANP");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Balochistan Awami Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "BAP");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Balochistan National Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes","BNP");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Grand Democratic Alliance vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes","GDA");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Jamaat-e-Islami vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes","JI");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Jamhoori Wattan Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "JWP");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("JUI-F vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "JUI-F");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Milli Awami Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "MAP");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Muslim League (Q) vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "ML(Q)");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Muslim League N vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "ML (N)");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Muttahida Qaumi Moment vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "MQM");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("National Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "NP");

        }catch(IOException e){e.getStackTrace();}
        sum = 0;
        try{
            Scanner file = new Scanner(new File("Peoples Party vote.txt"));
            file.useDelimiter("[\n]");
            while(file.hasNext()){
                file.next();
                sum++;
            }
            dod.setValue(sum, "Votes", "PP");

        }catch(IOException e){e.getStackTrace();}

        // setup chart 
        JFreeChart jChart = ChartFactory.createBarChart3D("Live Votes", "Parties", "Party Votes", dod);
        CategoryPlot plot = jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        ChartFrame chartFrm = new ChartFrame("Live Votes", jChart, true);
        chartFrm.setVisible(true);
        chartFrm.setSize(1000,1000);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // for selcting and saving jradio button choice
        if(e.getSource() == Submit_Button){
            if(PTI_Button.isSelected()){
                try{
                    File file = new File("Pakistan Tehreek-e-Insaf vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("T");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("T"+"\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(PMLN_Button.isSelected()){
                try{
                    File file = new File("Muslim League N vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("M");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("M");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(PP_Button.isSelected()){
                try{
                    File file = new File("Peoples Party vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("P");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("P");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(MQM_Button.isSelected()){
                try{
                    File file = new File("Muttahida Qaumi Moment vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("Q");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("Q");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(JI_Button.isSelected()){
                try{
                    File file = new File("Jamaat-e-Islami vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("J");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("J");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(JUIF_Button.isSelected()){
                try{
                    File file = new File("JUI-F vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("F");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("F");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(MLQ_Button.isSelected()){
                try{
                    File file = new File("Muslim League (Q) vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("L");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("L");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(ANP_Button.isSelected()){
                try{
                    File file = new File("Awami National Party vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("A");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("A");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(NP_Button.isSelected()){
                try{
                    File file = new File("National Party vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("N");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("N");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(BNP_Button.isSelected()){
                try{
                    File file = new File("Balochistan National Party vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("B");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("B");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(GDA_Button.isSelected()){
                try{
                    File file = new File("Grand Democratic Alliance vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("G");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("G");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(JWP_Button.isSelected()){
                try{
                    File file = new File("Jamhoori Wattan Party vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("C");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("C");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(AMLP_Button.isSelected()){
                try{
                    File file = new File("Awami Muslim League Pakistan vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("D");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("D");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(BAP_Button.isSelected()){
                try{
                    File file = new File("Balochistan Awami Party vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("E");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("E");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            if(MAP_Button.isSelected()){
                try{
                    File file = new File("Milli Awami Party vote.txt");
                    FileWriter write = new FileWriter(file,true);
                    write.append("H");
                    write.append("\n");
                    write.close();
                }catch(IOException ee){ee.getStackTrace();}
                try{
                    File fil = new File("Demographic data.txt");
                    FileWriter wri = new FileWriter(fil,true);
                    wri.append("H");
                    wri.append("\n");
                    wri.close();
                }catch(IOException ee){ee.getStackTrace();}
            }
            // for unhighlighting jardio buttons after submissions
            PTI_Button.setEnabled(false);
            PMLN_Button.setEnabled(false);
            PP_Button.setEnabled(false);
            MQM_Button.setEnabled(false);
            JI_Button.setEnabled(false);
            JUIF_Button.setEnabled(false);
            MLQ_Button.setEnabled(false);
            ANP_Button.setEnabled(false);
            NP_Button.setEnabled(false);
            BNP_Button.setEnabled(false);
            GDA_Button.setEnabled(false);
            JWP_Button.setEnabled(false);
            AMLP_Button.setEnabled(false);
            BAP_Button.setEnabled(false);
            MAP_Button.setEnabled(false);

            Total_Votes();
        }
        if(e.getSource() == Back){
            // back to previous frame
            frame.dispose();
            frame.toBack();
            People_Page pp = new People_Page();
            pp.frame.setVisible(true);
            pp.frame.toFront();
        }
    }
}
