package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner console = new Scanner(System.in);
    	boolean test = false;
    	System.out.println("Please type the calculation.");
		String input = console.nextLine();
		test = input.equals("quit");
    	while( test == false) {
    		
    		
    		String output = produceAnswer(input);
    		System.out.println(output);
    		System.out.println("Do you want to continue?");
    		input = console.nextLine();
    		test = input.equals("quit");
    	}

    }

    public static String produceAnswer(String input)
    { 
        // split the input string into three parts: operand1, operator, operand2
	    String[] threeParts = input.split(" ");
	    
	    String operator = threeParts[1];
	    Fraction operand1 = new Fraction(threeParts[0]);
	    Fraction operand2 = new Fraction(threeParts[2]);
	    Fraction operand3 = new Fraction();
	    answer = operand1.doMath(operator, operand2);
	    return answer.toString();
	    
	    
	    
	    int[] firstOperand = new int [3];
	    int[] secondOperand = new int [3];
	    //checkpoint2, which is split the first and second operand and store them in two integer arrays.
	    secondOperand = checkpoint2(threeParts[2],secondOperand);
	    firstOperand = checkpoint2(threeParts[0],firstOperand);
	    // convert to improper fraction
	    toImproper(firstOperand);
	    toImproper(secondOperand);  
	    
	    int[] result = new int [3];
	    //calculations
	    if (threeParts[1].equals("+")) {
	    	toCommonDenominator(firstOperand, secondOperand);
	      	result[1] = firstOperand[1] + secondOperand[1];
	    	result[2] = firstOperand[2];
	    }
	    else if(threeParts[1].equals("-")) {
	    	toCommonDenominator(firstOperand, secondOperand);
	    	result[1] = firstOperand[1] - secondOperand[1];
	    	result[2] = firstOperand[2];
	
	    }
	    else if(threeParts[1].equals("*")) {
	    	result[1] = firstOperand[1] * secondOperand[1];
	    	result[2] = firstOperand[2] * secondOperand[2];
	    } 
	    else {
	    	result[1] = firstOperand[1] * secondOperand[2];
	    	result[2] = firstOperand[2] * secondOperand[1];
	    	
	    }
	    
	
	
		// reduce fraction
	    if (result[1]<0 &&result[2]<0) {
	    	result[1] = -result[1];
	    	result[2] = -result[2];
	    }
	    int i = 0;
	    while (i != 1) {
	    	i = greatestCommonFactor(result[1], result[2]);
	    	result[1] = result[1]/i;
	    	result[2] = result[2]/i;
	    }
	    
	    result[0] = result[1]/result[2];
	    result[1] = result[1]%result[2];
	    //change the sign of result fraction part if it's negative.
	   
	  
	    if (result[1] <0) {
	    	if (result[0]<0) {
	        	result[1] = -result[1];
	        	
	        } 
	    	else if (result[0]>0){
	    		result[0] = -result[0];
	    		result[1] = -result[1];
	    	}
	   
	    	}
	    
	    else if(result[2]<0) {
	    	if (result[0]<0) {
	        	result[2] = -result[2];
	        	
	        }
	    	else if (result[0]>0){
	    		result[0] = -result[0];
	    		result[2] = -result[2];
	    	}
	    	else if (result[0]==0 && result[1]>0) {
	    		result[1]=-result[1];
	    		result[2]=-result[2];
	    	}
	    }
	    
	    //return the answer
	    if (result[1] == 0) {
	    	 return (result[0] +"");
	    }
	    else if(result[0]==0) {
	    	return (result[1]+ "/" + result[2]);
	    }
	    else {
	    	return ( result[0] + "_" + result[1] + "/" + result[2]) ;
	    }
	    
		
    }
}
    

