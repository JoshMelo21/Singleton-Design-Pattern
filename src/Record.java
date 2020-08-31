import java.util.*;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josh
 */
public class Record {
    // Name of the associated file
    private String fileName;
    private static Record instance;
    private File f;
    private Scanner s;
    
    private Record(String n){
        fileName = n;
    }
    
    public static Record getInstance(){
        if(instance== null){
            instance = new Record("record.txt");
        }
        return instance;
    }
    
    //Effects: Reads and prints the contents of the associated 
    // file to the standard output
    
    public void read(){
            
           try{ 
         File f = new File(fileName);
               
        s = new Scanner(new File(fileName));
                  
              while(s.hasNext())   {
                  System.out.println(s.next());
              }
                 s.close(); 
    } catch(IOException e){
    System.out.println("An error occured");
    e.printStackTrace();
}
    }
    
    //Effects: Appends the specified message, msg, to the
    // associated file.
    public void write(String msg){
        try{
            File f = new File(fileName);
             if(!f.exists()){
            f.createNewFile();
        }
               
          FileWriter writer = new FileWriter(f, true);
          writer.write(msg);                
                  writer.close();

            
        }catch(IOException e){
    System.out.println("An error occured");
    e.printStackTrace();
    }
}
    
    public static void main(String [] args){
        //Fill the blank below that obtains the sole instance
        //of the Record class
        // (You should not invoke the Record constructor here
        
        Record r = Record.getInstance();
        
        //Do not modify the code below
        r.write("Hello-1\n");
        r.write("Hello-2\n");
        
        System.out.println("Currently the file record.txt contains the following lines:");
        r.read();
    }
    
    
    
}
