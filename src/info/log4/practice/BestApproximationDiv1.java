package info.log4.practice;

/**
 * 483 DIV 1
 * @author kate
 * 
 * 
 */
public class BestApproximationDiv1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
	BestApproximationDiv1 div = new BestApproximationDiv1();
	int maxDen = 42;
	String number = "0.141592";
	String s = div.findFraction(maxDen, number);
	System.out.println(s);
    }

    public String findFraction(int maxDen, String number) {
	String bestS = "";
	int maxLCP = -1;
	int minDenominator = 1;
	int minNumerator = 1;

	String ss = "";
	double s = 1.0;
	int lcp = -1;
	int numerator = 1;
	double tempNumerator = 1.0;
	int denominator = 1;
	boolean equalForLCP = true;
	// check number
	int length = number.length();
	if (length > 8) {
	    number = number.substring(0, 8);
	}
	double num = Double.parseDouble(number);

	for (int i = 1; i <= maxDen; i++) {
	    lcp = -1;
	    equalForLCP = true;
	    denominator = i;
	    tempNumerator = denominator * num;
	    numerator = (int) Math.round(tempNumerator);
	    s = (double) numerator / denominator;
	    ss = String.valueOf(s);
	    int ssLength = ss.length();
	    if (ssLength > 8) {
		ss = ss.substring(0, 8);
	    } else if (ssLength < 8) {
		for (int k = 0; k < 8 - ssLength; k++) {
		    ss += "0";
		}
	    }
	    // compare
	    for (int j = 0; j < 8; j++) {
		if (equalForLCP && ss.charAt(j) == number.charAt(j)) {
		    lcp++;
		} else {
		    equalForLCP = false;
		    break;
		}
	    }
	    if (lcp > maxLCP) {
		maxLCP = lcp;
		bestS = ss;
		minDenominator = denominator;
		minNumerator = numerator;
	    } else if (lcp == maxLCP) {
		if (denominator < minDenominator) {
		    bestS = ss;
		    minDenominator = denominator;
		    minNumerator = numerator;
		} else if (denominator == minDenominator) {
		    if (numerator < minNumerator) {
			bestS = ss;
			minNumerator = numerator;
		    }
		}
	    }

	}
	return (minNumerator + "/" + minDenominator + " has " + maxLCP + " exact digits");
    }
}
