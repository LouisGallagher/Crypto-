import java.util.HashMap;
import java.util.Dictionary;
import java.util.Hashtable;

public class CryptoUtils {

	static final String VOWELS = "aeiouAEIOU";
	       
    public static float getVowelPercentage (String message) {
        int messageLength = message.length();
        
        int vowelCount = 0;
        for (int i = 0; i < messageLength; i++) {
            if (VOWELS.indexOf(message.charAt(i)) >= 0) {
                vowelCount += 1;   
            }
        }
        
        return ((float)vowelCount / (float)messageLength) * 100.0f;
    }
    /*
    Can be used for both decryption and encryption i.e. pass in +/- shift value
    Currently doesn't handle punctuation
    */
    public static String ApplyShift(String message, int shift)
    {
    	StringBuilder builder = new StringBuilder();
    	String normalisedMessage = message.toLowerCase();
    	
    	for(char c : normalisedMessage.toCharArray())
    	{
    		char delta = ((int)c < 124 && (int)c > 96 ) ? (char)(((((int)c - 97) + shift) % 26) + 97) : c;
    		builder.append(delta);
    	}

    	return builder.toString();
    }


}
