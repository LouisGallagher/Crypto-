import java.util.HashMap;
import java.util.Dictionary;
import java.util.Hashtable;

public class CryptoUtils {

	static final String VOWELS = "aeiouAEIOU";
	static final Dictionary<Integer, Character> LatinAlphabet;

	static
	{
		LatinAlphabet = new Hashtable<Integer, Character>();
		LatinAlphabet.put(0,'a');
		LatinAlphabet.put(1,'b');
		LatinAlphabet.put(2,'c');
		LatinAlphabet.put(3,'d');
		LatinAlphabet.put(4,'e');
		LatinAlphabet.put(5,'f');
		LatinAlphabet.put(6,'g');
		LatinAlphabet.put(7,'h');
		LatinAlphabet.put(8,'i');
		LatinAlphabet.put(9,'j');
		LatinAlphabet.put(10,'k');
		LatinAlphabet.put(11,'l');
		LatinAlphabet.put(12,'m');
		LatinAlphabet.put(13,'n');
		LatinAlphabet.put(14,'o');
		LatinAlphabet.put(15,'p');
		LatinAlphabet.put(16,'q');
		LatinAlphabet.put(17,'r');
		LatinAlphabet.put(18,'s');
		LatinAlphabet.put(19,'t');
		LatinAlphabet.put(20,'u');
		LatinAlphabet.put(21,'v');
		LatinAlphabet.put(22,'w');
		LatinAlphabet.put(23,'x');
		LatinAlphabet.put(24,'y');
		LatinAlphabet.put(25,'z');
	}

       
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

    public static String ApplyShift(String message, int shift)
    {
    	return "";
    }
}
