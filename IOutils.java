import java.io.*

public class IOutils throws IOException{
    public static String parseFile (String fileName) {
        Scanner sc = null;
        
        try {
            sc = new Scanner(fileName);
            
            while (sc.hasNextLine()) {
                line = sc.nextLine();
            }
        }
        finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
