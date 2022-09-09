package task01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Faction {

	private String name;
	List<Deputy> list = new ArrayList<Deputy>();

	public Faction(String name, List<Deputy> deputy) {
		super();
		this.name = name;
		this.list = deputy;
	}

	public Faction(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Deputy> getDeputy() {
		return list;
	}

	public void setDeputy(List<Deputy> deputy) {
		this.list = deputy;
	}

	@Override
	public String toString() {
		return "" + name + "";
	}

	public void addDeputy() {
		String surname = "";
		String name = "";
		int age = 0;
		double weight = 0;
		double height = 0;
		boolean briber = false;
		int bribeSize = 0;

		System.out.println("We add Deputy to the faction");

		System.out.println("Enter name");
		Scanner scanner = new Scanner(System.in);

		if (scanner.hasNext()) {
			name = scanner.next();
		}

		System.out.println("Enter Surname");
		scanner = new Scanner(System.in);

		if (scanner.hasNext()) {
			surname = scanner.next();
		}

		System.out.println("Enter age");
		scanner = new Scanner(System.in);

		if (scanner.hasNext()) {
			age = scanner.nextInt();
		}

		System.out.println("Enter weight");
		scanner = new Scanner(System.in);

		if (scanner.hasNext()) {
			weight = scanner.nextDouble();
		}

		System.out.println("Enter height");
		scanner = new Scanner(System.in);

		if (scanner.hasNext()) {
			height = scanner.nextDouble();
		}

		System.out.println("Is deputy bribe-taker (yes/no)?");
		scanner = new Scanner(System.in);
		String string = "yes";

		if (scanner.hasNext()) {
			if (scanner.next().equals(string)) {
				System.out.println("This deputy is bribe-taker");
				briber = true;
			} else {
				System.out.println("This deputy is not a bribe-taker");
				briber = false;
			}

		}

		Deputy deputy = new Deputy(weight, height, name, surname, age, briber);
		list.add(deputy);
	}

	public void removeDeputy() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name");
		String name = scanner.next();
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Enter surname");
		String surname = scanner2.next();

		boolean flag = isDeputyExists(list, name, surname);

		if (flag) {
			Iterator<Deputy> iterator = list.iterator();

			while (iterator.hasNext()) {
				Deputy next = iterator.next();
				if (next.getName().equalsIgnoreCase(name) && next.getSurname().equalsIgnoreCase(surname)) {
					iterator.remove();
					System.out.println(next.toString() + " removed");
				}
			}
		} else {
			System.out.println("There is no deputy with this name");
		}
	}

	public void showAllBribeTakersOfFaction() {
		System.out.println("List of all bribe-takers:");
		Iterator<Deputy> iterator = list.iterator();

		while (iterator.hasNext()) {
			Deputy deputy = iterator.next();

			if (deputy.isBriber()) {
				System.out.println(deputy);
			}
		}
	}

	public void biggestBribeTakerOfFaction() {
		System.out.println("The biggest bribe-taker in the faction");
		Iterator<Deputy> iterator = list.iterator();

		int max = 0;
		int n = 0;
		int biggest = 0;

		while (iterator.hasNext()) {
			Deputy deputy = iterator.next();
			if (deputy.getBribeSize() > max) {
				max = deputy.getBribeSize();
				biggest = n;
			}
			n++;
		}

		System.out.println(list.get(biggest).toString());
	}

	public void showAllDeputiesOfFaction() {
		Iterator<Deputy> iterator = list.iterator();

		if (!iterator.hasNext()) {
			System.out.println("There are no deputies in this faction");
		}

		while (iterator.hasNext()) {
			Deputy deputy = iterator.next();
			System.out.println("All deputies in faction:");
			System.out.println(deputy.toString() + "");
		}
	}

	public void clearFaction() {
		if (list.size() > 0) {
			list.clear();
			System.out.println("All deputies have been successfully removed from the faction");
		} else {
			System.out.println("There are no deputies in this faction");
		}
	}

	static boolean isDeputyExists(List<Deputy> list, String firstName, String lastName) {
		boolean flag = false;

		for (Deputy deputy : list) {
			if (deputy.getName().equalsIgnoreCase(firstName) && deputy.getSurname().equalsIgnoreCase(lastName)) {
				flag = true;
			}
		}
		return flag;
	}
}