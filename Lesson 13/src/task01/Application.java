package task01;

import java.util.List;
import java.util.Scanner;

public class Application {

	static void menu() {
		System.out.println("Enter 1 to add a faction." + 
				"\nEnter 2 to delete a specific faction."+
				"\nEnter 3 to output all factions." + 
				"\nEnter 4 to clear a specific faction." + 
				"\nEnter 5 to output a specific faction." + 
				"\nEnter 6 to add a deputy to the faction."+
				"\nEnter 7 to remove an deputy from a faction." + 
				"\nEnter 8 to display the list of bribe takers."+
				"\nEnter 9 to show the biggest bribe taker.");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			menu();

			switch (scanner.next()) {

			case "1": {
				SupremeCouncil.getInstance().addFaction();
				break;
			}

			case "2": {
				SupremeCouncil.getInstance().removeFaction();
				break;
			}

			case "3": {
				SupremeCouncil.getInstance().showAllFactions();
				break;
			}

			case "4": {
				SupremeCouncil.getInstance().clearSpecificFaction();
				break;
			}

			case "5": {
				SupremeCouncil.getInstance().showSpecificFactions();
				break;
			}

			case "6": {
				SupremeCouncil.getInstance().addDeputyToFaction();
				break;
			}

			case "7": {
				SupremeCouncil.getInstance().removeDeputyFromFaction();
				break;
			}
			case "8": {
				SupremeCouncil.getInstance().showAllBribersFromFaction();
				break;
			}

			case "9": {
				SupremeCouncil.getInstance().showBiggestBribeTakerOfFaction();
				break;
			}
			}
		}
	}
}