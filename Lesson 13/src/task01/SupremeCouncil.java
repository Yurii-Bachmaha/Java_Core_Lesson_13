package task01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SupremeCouncil {

	private static SupremeCouncil instance = new SupremeCouncil();

	private SupremeCouncil() {

	}

	public static SupremeCouncil getInstance() {
		if (instance == null) {
			instance = new SupremeCouncil();
		}

		return instance;
	}

	List<Faction> list = new ArrayList<Faction>();

	public void addFaction() {
		System.out.println("Enter faction name");
		Scanner scanner = new Scanner(System.in);
		String factionName = "";

		while (scanner.hasNext()) {
			factionName = scanner.next();
			Faction faction = new Faction(factionName);
			list.add(faction);

			System.out.println("Faction " + faction.toString() + " now in supreme council.");
			break;
		}

	}

	public void clearSpecificFaction() {
		System.out.println("Enter a faction name, all deputies of entered faction will be removed");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(name)) {
				list.get(i).clearFaction();
			} else {
				System.out.println("There is no faction with this name");
			}
		}
	}

	public void removeFaction() {
		System.out.println("Enter the name of the faction from the list");
		showAllFactions();
		Scanner scanner = new Scanner(System.in);
		String name = "";

		while (scanner.hasNext()) {
			name = scanner.next();
			if (list.size() > 0) {
				Iterator<Faction> iterator = list.iterator();

				while (iterator.hasNext()) {
					Faction faction = iterator.next();
					if (faction.getName().toString().equalsIgnoreCase(name)) {
						System.out.println("Faction " + faction.toString() + " was removed");
						iterator.remove();
					} else if (list.size() == 0) {
						System.out.println("There are no factions in supreme council");
						break;
					} else {
						System.out.println("There is no faction with this name in supreme council");
					}
				}
				break;
			}
		}

	}

	public void showAllFactions() {
		System.out.println("All factions in supreme council:\n");
		Iterator<Faction> iterator = list.iterator();

		while (iterator.hasNext()) {
			Faction faction = iterator.next();

			System.out.println(faction.getName().toString());
		}
	}

	public void showSpecificFactions() {
		System.out.println("Enter faction name");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Iterator<Faction> iterator = list.iterator();
		boolean find = false;

		while (iterator.hasNext()) {
			Faction faction = iterator.next();
			if (faction.getName().equalsIgnoreCase(name)) {
				find = true;
				System.out.println(faction.toString());
				faction.showAllDeputiesOfFaction();
			}

		}
		if (!find) {
			System.out.println("There is no such faction " + name);
		}
	}

	public void addDeputyToFaction() {
		System.out.println("Enter faction name");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Iterator<Faction> iterator = list.iterator();
		boolean find = false;

		while (iterator.hasNext()) {
			Faction faction = iterator.next();
			if (faction.getName().equalsIgnoreCase(name)) {
				find = true;
				faction.addDeputy();
			}
		}
		if (!find) {
			System.out.println("There is no such faction " + name);
		}
	}

	public void removeDeputyFromFaction() {
		System.out.println("Enter faction name");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Iterator<Faction> iterator = list.iterator();
		boolean find = false;

		while (iterator.hasNext()) {
			Faction faction = iterator.next();
			if (faction.getName().equalsIgnoreCase(name)) {
				find = true;
				faction.removeDeputy();
			} else {
				System.out.println("There is no faction with this name");
			}
		}
	}

	public void showAllBribersFromFaction() {
		System.out.println("Enter faction name");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();

		Iterator<Faction> iterator = list.iterator();

		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(name)) {
				next.showAllBribeTakersOfFaction();
			}
		}

	}

	public void showBiggestBribeTakerOfFaction() {
		System.out.println("Enter faction name");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();

		Iterator<Faction> iterator = list.iterator();

		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getName().equalsIgnoreCase(name)) {
				next.biggestBribeTakerOfFaction();
			}
		}
	}

	public void showAllDeputiesOfFaction() {
		System.out.println("Enter faction name");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(name)) {
				list.get(i).getDeputy();
			}
		}
	}
}