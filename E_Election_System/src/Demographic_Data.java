import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class Demographic_Data {
    // for demographic attributes
    private int t,m,p,q,j,f,l,a,n,b,g,c,d,e,h = 0;
    private int t1,m1,p1,q1,j1,f1,l1,a1,n1,b1,g1,c1,d1,e1,h1 = 0;
    private int t2,m2,p2,q2,j2,f2,l2,a2,n2,b2,g2,c2,d2,e2,h2 = 0;
    private String tempage = "";
    private String tempvote = "";
    private String tempage1 = "";
    private String tempvote1 = "";
    private String tempage2 = "";
    private String tempvote2 = "";
    private String youngesters[] = {"18","19","20","21","22","23","24","25","26","27","28","29"};
    private String middleages[] = {"30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
    private String SC[] = {"61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80"};
    private int[] Votes = new int[15];
    private int[] Votes1 = new int[15];
    private int[] Votes2 = new int[15];
    private String[] parties = new String[15];
    private String[] parties1 = new String[15];
    private String[] parties2 = new String[15];
    // for chart
    private DefaultCategoryDataset dod = new DefaultCategoryDataset();
    protected Demographic_Data(){}

    private final void Youngesters_Data(){  
        // to read data from file and calculatre youngestres age group demographs  
        try{
            File file = new File("Demographic data.txt");
            Scanner read = new Scanner(file);
            read.useDelimiter("[,\n]");
            while(read.hasNext()){
                tempage = read.next();
                for(String x: youngesters){
                    if(x.equals(tempage)){
                        tempvote =  read.next();
                         if(tempvote.trim().equals("T")){
                            t++;
                            Votes[0] = t;
                        }
                        parties[0] = "PTI";
                        if(tempvote.trim().equals("M")){
                            m++;
                            Votes[1] = m;
                            
                        }
                        parties[1] = "ML (N)";
                        if(tempvote.trim().equals("P")){
                            p++;
                            Votes[2] = p;
                            
                        }
                        parties[2] = "PP";
                        if(tempvote.trim().equals("Q")){
                            q++;
                            Votes[3] = q;
                        }
                        parties[3] = "MQM";
                        if(tempvote.trim().equals("J")){
                            j++;
                            Votes[4] = j;
                            
                        }
                        parties[4] = "JI";
                        if(tempvote.trim().equals("F")){
                            f++;
                            Votes[5] = f;
                            
                        }
                        parties[5] = "JUI-F";
                        if(tempvote.trim().equals("L")){
                            l++;
                            Votes[6] = l;
                            
                        }
                        parties[6] = "ML (Q)";
                        if(tempvote.trim().equals("A")){
                            a++;
                            Votes[7] = a;
                            
                        }
                        parties[7] = "ANP";
                        if(tempvote.trim().equals("N")){
                            n++;
                            Votes[8] = n;
                            
                        }
                        parties[8] = "NP";
                        if(tempvote.trim().equals("B")){
                            b++;
                            Votes[9] = b;
                            
                        }
                        parties[9] = "BNP";
                        if(tempvote.trim().equals("G")){
                            g++;
                            Votes[10] = g;
                            
                        }
                        parties[10] = "GDA";
                        if(tempvote.trim().equals("C")){
                            c++;
                            Votes[11] = c;
                            
                        }
                        parties[11] = "JWP";
                        if(tempvote.trim().equals("D")){
                            d++;
                            Votes[12] = d;
                            
                        }
                        parties[12] = "AMLP";
                        if(tempvote.trim().equals("E")){
                            e++;
                            Votes[13] = e;
                            
                        } 
                        parties[13] = "BAP";
                        if(tempvote.trim().equals("H")){
                            h++;
                            Votes[14] = h;
                            
                        }
                        parties[14] = "MAP";
                    }
                }
               
                

            }
            read.close();  
            }catch(IOException ee){ee.getStackTrace();}
            max_vote(Votes,parties, "18-29"); // find max vote   
    }
    private final void Middleages_Data(){
        // to calculate middle age demographs
        try{
            
            File file1 = new File("Demographic data.txt");
            Scanner read1 = new Scanner(file1);
            read1.useDelimiter("[,\n]");
            while(read1.hasNext()){
                tempage1 = read1.next();
                for(String y: middleages){
                    if(y.equals(tempage1)){
                        tempvote1 =  read1.next();
                         if(tempvote1.trim().equals("T")){
                            t1++;
                            Votes1[0] = t1;
                        }
                        parties1[0] = "PTI";
                        if(tempvote1.trim().equals("M")){
                            m1++;
                            Votes1[1] = m1;
                            
                        }
                        parties1[1] = "ML (N)";
                        if(tempvote1.trim().equals("P")){
                            p1++;
                            Votes1[2] = p1;
                            
                        }
                        parties1[2] = "PP";
                        if(tempvote1.trim().equals("Q")){
                            q1++;
                            Votes1[3] = q1;
                            
                        }
                        parties1[3] = "MQM";
                        if(tempvote1.trim().equals("J")){
                            j1++;
                            Votes1[4] = j1;
                            
                        }
                        parties1[4] = "JI";
                        if(tempvote1.trim().equals("F")){
                            f1++;
                            Votes1[5] = f1;
                            
                        }
                        parties1[5] = "JUI-F";
                        if(tempvote1.trim().equals("L")){
                            l1++;
                            Votes1[6] = l1;
                            
                        }
                        parties1[6] = "ML (Q)";
                        if(tempvote1.trim().equals("A")){
                            a1++;
                            Votes1[7] = a1;
                            
                        }
                        parties1[7] = "ANP";
                        if(tempvote1.trim().equals("N")){
                            n1++;
                            Votes1[8] = n1;
                            
                        }
                        parties1[8] = "NP";
                        if(tempvote1.trim().equals("B")){
                            b1++;
                            Votes1[9] = b1;
                            
                        }
                        parties1[9] = "BNP";
                        if(tempvote1.trim().equals("G")){
                            g1++;
                            Votes1[10] = g1;
                            
                        }
                        parties1[10] = "GDA";
                        if(tempvote1.trim().equals("C")){
                            c1++;
                            Votes1[11] = c1;
                            
                        }
                        parties1[11] = "JWP";
                        if(tempvote1.trim().equals("D")){
                            d1++;
                            Votes1[12] = d1;
                            
                        }
                        parties1[12] = "AMLP";
                        if(tempvote1.trim().equals("E")){
                            e1++;
                            Votes1[13] = e1;
                            
                        } 
                        parties1[13] = "BAP";
                        if(tempvote1.trim().equals("H")){
                            h1++;
                            Votes1[14] = h1;
                            
                        }
                        parties1[14] = "MAP"; 
        
                    }
                }
                
            }
            read1.close();
            }catch(IOException ee){ee.getStackTrace();}
            max_vote(Votes1, parties1, "29-60"); // find max vote
    }
    private final void Seniorcitizen_Data(){
        // to calculate senior citizen age group demographs
        try{
            
            File file2 = new File("Demographic data.txt");
            Scanner read2 = new Scanner(file2);
            read2.useDelimiter("[,\n]");
            while(read2.hasNext()){
                tempage2 = read2.next();
                for(String z: SC){
                    if(z.equals(tempage2)){
                        tempvote2 =  read2.next();                        
                         if(tempvote2.trim().equals("T")){
                            t2++;
                            Votes2[0] = t2;
                        }
                        parties2[0] = "PTI";
                        if(tempvote2.trim().equals("M")){
                            m2++;
                            Votes2[1] = m2;
                            
                        }
                        parties2[1] = "ML (N)";
                        if(tempvote2.trim().equals("P")){
                            p2++;
                            Votes2[2] = p2;
                            
                        }
                        parties2[2] = "PP";
                        if(tempvote2.trim().equals("Q")){
                            q2++;
                            Votes2[3] = q2;
                            
                        }
                        parties2[3] = "MQM";
                        if(tempvote2.trim().equals("J")){
                            j2++;
                            Votes2[4] = j2;
                            
                        }
                        parties2[4] = "JI";
                        if(tempvote2.trim().equals("F")){
                            f2++;
                            Votes2[5] = f2;
                            
                        }
                        parties2[5] = "JUI-F";
                        if(tempvote2.trim().equals("L")){
                            l2++;
                            Votes2[6] = l2;
                            
                        }
                        parties2[6] = "ML (Q)";
                        if(tempvote2.trim().equals("A")){
                            a2++;
                            Votes2[7] = a2;
                            
                        }
                        parties2[7] = "ANP";
                        if(tempvote2.trim().equals("N")){
                            n2++;
                            Votes2[8] = n2;
                            
                        }
                        parties2[8] = "NP";
                        if(tempvote2.trim().equals("B")){
                            b2++;
                            Votes2[9] = b2;
                            
                        }
                        parties2[9] = "BNP";
                        if(tempvote2.trim().equals("G")){
                            g2++;
                            Votes2[10] = g2;
                            
                        }
                        parties2[10] = "GDA";
                        if(tempvote2.trim().equals("C")){
                            c2++;
                            Votes2[11] = c2;
                            
                        }
                        parties2[11] = "JWP";
                        if(tempvote2.trim().equals("D")){
                            d2++;
                            Votes2[12] = d2;
                            
                        }
                        parties2[12] = "AMLP";
                        if(tempvote2.trim().equals("E")){
                            e2++;
                            Votes2[13] = e2;
                            
                        } 
                        parties2[13] = "BAP";
                        if(tempvote2.trim().equals("H")){
                            h2++;
                            Votes2[14] = h2;
                            
                        }
                        parties2[14] = "MAP"; 
                    }
                }
                

            }
            read2.close();
            }catch(IOException ee){ee.getStackTrace();}
            max_vote(Votes2, parties2, "Above 60"); // find max vote
    }

    private final void max_vote(int[] votes, String[] pv, String AG){
        // to calculate max vote
        int maxvalue = votes[0];
        int k = 0;
        for(int i=0; i<votes.length; i++){
            if(votes[i] > maxvalue){
                maxvalue = votes[i];
                k = i;
            }
        }
        // to find the max vote party
        String par = "";
        for(int j=0; j<=k; j++){
            par = pv[j];
        }
        // save it in chart
        dod.setValue(maxvalue, par, AG);
        
    }
    protected final void chart(){
        // to create chart
        Youngesters_Data();
        Middleages_Data();
        Seniorcitizen_Data();

        // chart setup
        JFreeChart jChart = ChartFactory.createBarChart3D("Vote Demographics", "Parties", "Party Votes", dod);
        CategoryPlot plot = jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        ChartFrame chartFrm = new ChartFrame("Vote Demographics", jChart, true);
        chartFrm.setVisible(true);
        chartFrm.setSize(1000,1000);
    }
}