import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class IOutils {
    public static void main (String[] args) {
        String ciphertext = parseFile("Group1_Problem1.txt", true);
        System.out.println(ciphertext);
    }
    
    public static String parseFile (String fileName,
            Boolean hasCharCount) throws IOException {
        /** 
         * Takes filename, reads it in as one block of characters without
         * spaces/newlines.
         */
        
        String finalString = "";
        
        Scanner sc = null;
        
        try {
            sc = new Scanner(fileName);
            
            ArrayList<String> lines = new ArrayList<String>();
            
            int linesProcessed = 0;
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                linesProcessed++;
                
                if (!(hasCharCount && linesProcessed % 2 == 0)) {
                    lines.add(line);
                }
            }
            
            StringBuilder sbuild = new StringBuilder();
            for (String line : lines) {
                sbuild.append(line);
            }
            
            finalString = sbuild.toString();
            finalString = finalString.replace(" ", "");
        }
        finally {
            if (sc != null) {
                sc.close();
            }
        }
        
        return finalString;
    }
}
