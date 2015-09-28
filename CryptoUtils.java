import java.util.HashMap

final String VOWELS = "aeiouAEIOU";

public class CryptoUtils {
    public static void main (String[] args) {
        System.out.println("Hello, world!");
    }
    
    public static float get_vowel_percentage (String message) {
        int message_length = message.length()
        
        int vowel_count = 0
        for (int i = 0; i < message_length; i++) {
            if (VOWELS.indexOf(message.charAt(i)) >= 0) {
                vowel_count += 1   
            }
        }
        
        return ((float)vowel_count / message_length) * 100.0
    }
}
