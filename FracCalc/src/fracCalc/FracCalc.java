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
	    
	    
	    
	  
	    
	    int[] result = new int [3];
	   
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
    

