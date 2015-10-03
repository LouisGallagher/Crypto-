package crypto;

import java.util.Scanner;
import java.io.File;

import java.util.ArrayList;
import java.lang.StringBuilder;

import java.io.IOException;

public class IOutils {
    public static void main (String[] args) throws IOException {
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
            sc = new Scanner(new File(fileName));
            
            ArrayList<String> lines = new ArrayList<String>();
            
            int linesProcessed = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                
                if (!(hasCharCount && linesProcessed % 2 == 0)) {
                    lines.add(line);
                }
                
                linesProcessed++;
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
