package CalendarAppointments;

import java.io.*;

public class Helper {
    
    public static void main(String[] args) {
        
        checkFilesForParseError();
    }
    
    public static void checkFilesForParseError() {
        
        FileReader fr;
        BufferedReader br;
        String path = "src/CalendarAppointments/";
        String filename = path + "GUI.java";
        
        String fileInString = "";
        
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            while (br.readLine() != null) {
                //System.out.println(br.readLine());
                fileInString += br.readLine() + "\n";
            }
            //System.out.println(fileInString);
            br.close();
        }
        catch (IOException e) {
            System.out.println("IO Error: ==> " + e);
        }
        System.out.println(bracketsAreBalanced(fileInString));
    }
    
    public static boolean bracketsAreBalanced(String line) {
        
        int open = 0;
        int close = 0;
        for (int i=0; i<line.length(); i++) {
            if (line.charAt(i) == '(')
                open++;
            else if (line.charAt(i) == ')')
                close++;
            if (open < close)
                return false;
        }
        if (open == close)
            return true;
        return false;
    }
    
}
