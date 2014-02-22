// Type your Java code and click the "Run Code" button!
// Your code output will be shown on the left.
// Click on the "Show input" button to enter input data to be read (from stdin).

public class Interpreter {
    public static void main(String[] args) {
        // Start typing your code here...
        System.out.println(convertBinary(59.25));
        
    }
    static String convertBinary(double num)
    {
/*
learn how to seperate integer part and double part
*/
        int integerPart=(int)num;
        double floatPart=num-integerPart;
        String result=""; 
        while(integerPart/2>0)
        {
            result=integerPart%2+result;
            integerPart=integerPart/2; 
        }
        result=integerPart%2+result;
        if(floatPart!=0.0) result+=".";
        while(floatPart!=0.0)
        {
            floatPart*=2;
            result+=(int)floatPart;
            if(floatPart>=1) floatPart-=1; 
        }
        return result; 
    }
}


public String convertBinary(double num) {
	int integer = (int)num;
	int decimal = num - integer;
	StringBuilder result = new StringBuilder();
	while(integer > 0) {
		result.append(integer%2);
		integer /= 2;
	}
	result.reverse().append('.');
	while(decimal != 0.0) {
		decimal *= 2;
		result.append((int)decimal);
		if(decimal >= 1) decimal -= 1;
	}
	return result.toString();
}

































