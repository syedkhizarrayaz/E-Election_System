import java.io.*;
import java.util.Scanner;
public class Admin implements Serializable{
    protected Admin(){
        
    }

    protected boolean login(String Username ,String Password){
        boolean found = false;
        String tempun = "";
        String temppas = "";
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
        
    protected void sign_Up(String fn, String ln, String dob, String Un, String Pas){
        String tempun = "";
        boolean found = false;
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
            FileWriter write = new FileWriter(file, true);
            write.append(Un);
            write.append(",");
            write.append(Pas);
            write.append("\n");
            write.close();
            try{
                File fil = new File("Admin details.txt");
                FileWriter writer = new FileWriter(fil);
                writer.append(fn+","+ln+","+dob+"\n");
                writer.close();
            }catch(IOException e){e.getStackTrace();}
        }
        
        }
        catch(IOException e){e.getStackTrace();}
    }

    public static void main(String[] args) {
        Admin AD = new Admin();
        //AD.sign_Up("kk", "ff");
        AD.login("kk" ,"ff");
        
    }
       
}


