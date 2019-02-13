 import java.util.ArrayList;

public class ThereAndBackAgain 
{

	public static void main(String[] args) 
	{
		// Create a traveling party called party1 by creating an array of Travelers /
				// and filling it with frodo, sam, and gimli
		Hobbit frodo = new Hobbit("Frodo");
		Hobbit sam = new Hobbit("Sam");
		Dwarf gimli = new Dwarf("Gimli");
		Traveler[] party1 = {frodo, sam, gimli};
		
		// Then, use a loop to make all travelers go a distance of 50 miles  
		for (Traveler thisTraveler : party1) {
			thisTraveler.travel(50);
			// Then, for each Traveler in the travelingParty, print their name and how far they've
			//    traveled in miles.  (In the next piece, you'll do this in methods, but 
			//    for a first pass, just do it in main and print to the console.)
			// Expected output:  Frodo has traveled 50 miles.
			//                   Sam has traveled 50 miles.
			//                   Gimli has traveled 50 miles.
			
			System.out.println(thisTraveler.getName() + " has traveled " + thisTraveler.getDistanceTraveled() + " miles.");
		}
		
		
		//part2
		
		System.out.println("\n\n\nPART 2: \n");
		
		String[] dwarfNames = {"Fili", "Kili", "Dori", "Ori", "Nori", "Balin", "Dwalin", 
		"Oin", "Gloin", "Bifur", "Bofur", "Bombur", "Thorin"};
		
		// Make a new ArrayList to hold a 2nd party of Travelers called party2:
		ArrayList <Traveler> party2 = new ArrayList<Traveler>();
		
		// Make a new Hobbit called "Bilbo" and add him to party2
		// <Make a new Wizard called "Gandalf" and add him to party2.
		Hobbit bilbo = new Hobbit("Bilbo");
		Wizard gandalf = new Wizard("Gandalf","Grey") ;
		party2.add(bilbo);
		party2.add(gandalf);
		
		// Call the createParty method and pass it party2 and the dwarfNames array.
		createParty(party2,dwarfNames);
		
		// Finally, call the allTravel method passing it party2 and 100 (representing
		// the 100 miles that party2 has traveled together.
		//Make sure your code prints out the name and distances party2 has traveled.
		allTravel(party2,100);
		for (int i = 0; i < party2.size();i++) {
			System.out.println(party2.get(i).getName() + " has traveled " + party2.get(i).getDistanceTraveled() + " miles.");
		}
	}

	
		

		

		
		
	//write createParty
	// create party should add all the new dwarves to party2,
	public static void createParty(ArrayList<Traveler> party, String[] dwarf) {
		for (int i =0; i<dwarf.length ;i++) {
			Dwarf temp = new Dwarf(dwarf[i]);
			party.add(temp);
		}
	}
	
	//Write allTravel
	public static void allTravel(ArrayList<Traveler> travelers, int miles) {
		for (int i = 0;i<travelers.size();i++) {
			travelers.get(i).travel(miles);
		}
	}

	
}

