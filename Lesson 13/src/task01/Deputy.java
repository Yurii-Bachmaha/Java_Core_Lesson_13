package task01;

import java.util.Scanner;

public class Deputy extends Human {

	private String name;
	private String surname;
	private int age;
	private boolean briber;
	private int bribeSize;

	public Deputy(double weight, double height, String name, String surname, int age, boolean briber) {
		super(weight, height);
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.briber = briber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBriber() {
		return briber;
	}

	public void setBriber(boolean briber) {
		this.briber = briber;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	@Override
	public String toString() {
		return "Deputy name=" + name + ", surname=" + surname + ", age=" + age + ", briber=" + briber + ", bribeSize="
				+ bribeSize + "";
	}

	public void giveBribe() {

		if (briber = false) {
			System.out.println("This deputy does not take bribes");
		} else if (briber = true) {
			System.out.println("Enter the amount of the bribe");
			Scanner scanner = new Scanner(System.in);
			int temp = 0;
			try {
				temp = scanner.nextInt();
				this.bribeSize += temp;
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
			if (temp > 5000) {
				System.out.println("Police will imprison a deputy");
			}
		}
	}
}