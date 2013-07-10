package info.log4.practice;

import java.util.Arrays;

/**
 * SRM 144 V1
 * 
 * @author kate
 * 
 */
public class BinaryCode {

    /**
     * @param args
     */
    public static void main(String[] args) {
	BinaryCode bc = new BinaryCode();
	// String message = "123210122";
	// String message = "11";
	// String message = "22111";
	// String message = "123210120";
	// String message = "3";
	String message = "12221112222221112221111111112221111";
	String[] result = bc.decode(message);
	System.out.println(result[0]);
	System.out.println(result[1]);
    }

    public String[] decode(String message) {
	String[] result = { "", "" };
	int length = message.length();
	char[] q = message.toCharArray();
	int[] p = new int[length];
	boolean fault = false;
	for (int i = 0; i < 2; i++) {
	    fault = false;
	    p[0] = i;
	    if (length > 1) {
		p[1] = Character.getNumericValue(q[0]) - p[0];
		if (p[1] != 0 && p[1] != 1) {
		    fault = true;
		    result[i] = "NONE";
		    continue;
		}

		for (int j = 2; j < q.length; j++) {
		    p[j] = Character.getNumericValue(q[j - 1]) - p[j - 1]
			    - p[j - 2];
		    if (p[j] != 0 && p[j] != 1) {
			fault = true;
			result[i] = "NONE";
			break;
		    }
		}
		if (p[length - 2] + p[length - 1] != Character
			.getNumericValue(q[length - 1])) {
		    result[i] = "NONE";
		    fault = true;
		}
	    } else {
		if (p[length - 1] != Character.getNumericValue(q[length - 1])) {
		    result[i] = "NONE";
		    fault = true;
		}
	    }
	    if (!fault) {
		result[i] = Arrays.toString(p);
	    }
	}
	return result;
    }

}
