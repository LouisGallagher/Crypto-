import java.util.HashMap;
import java.util.Dictionary;
import java.util.Hashtable;

public class CryptoUtils {
    /*
    Can be used for both decryption and encryption i.e. pass in +/- shift value
    Currently doesn't handle punctuation i.e. will map punctuation back onto itself 
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
