//@author Jason Ji
//Version March 6,2019
//

package textExcel;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		TestsAll.Helper th = new TestsAll.Helper();
		System.out.println(th.getText());
		    	Scanner console = new Scanner(System.in);
		    	boolean test = false;
		    	System.out.println("Welcome to TextExcel. Please type a command.");
				String input = console.nextLine();
				test = input.equalsIgnoreCase("quit");
				
				//Create a new Spreadsheet object.
				Spreadsheet s = new Spreadsheet();
				//command loop
		    	while( test == false) {
		    		String output = s.processCommand(input);
		    		System.out.println(output);
		    		System.out.println("Do you want to continue?");
		    		input = console.nextLine();
		    		test = input.equalsIgnoreCase("quit");	
		    }
		    	/*SpreadsheetLocation a = new SpreadsheetLocation("L20");
		    	System.out.println("row" + a.getRow() );
		    	System.out.println("row" + a.getCol() );
		    	TextCell n = new TextCell("givemeakiss");
		    	System.out.println(n.fullCellText());*/
	}
}
