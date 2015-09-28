import java.util.HashMap

final String VOWELS = "aeiouAEIOU";

public class CryptoUtils {
    public static void main (String[] args) {
        System.out.println("Hello, world!");
    }
    
    public static float getVowelPercentage (String message) {
        int messageLength = message.length()
        
        int vowelCount = 0
        for (int i = 0; i < messageLength; i++) {
            if (VOWELS.indexOf(message.charAt(i)) >= 0) {
                vowelCount += 1   
            }
        }
        
        return ((float)vowelCount / messageLength) * 100.0
    }
}
