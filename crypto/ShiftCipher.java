package crypto;

import java.util.HashMap;
import java.util.Dictionary;
import java.util.Hashtable;

public class ShiftCipher
{
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
