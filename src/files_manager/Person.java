package files_manager;

import javax.swing.JOptionPane;

public class Person {
	
	private int id;
	private String name;
	private String email;
	private String programmingLanguageProficiense;
	private int age;
	
	private static final String FOREGROUND_COLOR_CYAN = "\u001B[36m";
	private static final String FOREGROUND_COLOR_GREEN = "\u001B[32m";
	private static final String FOREGROUND_COLOR_YELLOW = "\u001B[33m";
	private static final String FOREGROUND_COLOR_RED = "\u001B[31m";
	private static final String FOREGROUND_COLOR_RESET = "\u001B[0m";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgrammingLanguageProficiense() {
		return programmingLanguageProficiense;
	}
	public void setProgrammingLanguageProficiense(String programmingLanguageProficiense) {
		this.programmingLanguageProficiense = programmingLanguageProficiense;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static int setHowManyPeopleAdd () {
		int howManyPeopleAdd;
		
		do {
			
			try {
				
				howManyPeopleAdd = Integer.valueOf( JOptionPane.showInputDialog("How many people would you like to"
						+ " add in file?") );
				
				if ( howManyPeopleAdd <= 0 ) {
					JOptionPane.showMessageDialog(null, "Please, enter a number starting in 1...", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "OOPS! You typed a invalid value... Please, enter a valid integer number", "Error!", JOptionPane.ERROR_MESSAGE);
				howManyPeopleAdd = 0;
				
			}
		
		} while (howManyPeopleAdd <= 0);
		
		return howManyPeopleAdd;
	}
	
	@Override
	public String toString() {
		return " --> Person --: Id: " + FOREGROUND_COLOR_CYAN + getId() + FOREGROUND_COLOR_RESET
		+ "| Name: " + FOREGROUND_COLOR_GREEN + getName() + FOREGROUND_COLOR_RESET
		+ "| e-Mail: " + FOREGROUND_COLOR_GREEN + getEmail() + FOREGROUND_COLOR_RESET
		+ "| Programming Language Proficiense: " + FOREGROUND_COLOR_RED + getProgrammingLanguageProficiense().toUpperCase() + FOREGROUND_COLOR_RESET
		+ "| Age: " + FOREGROUND_COLOR_YELLOW + getAge() + FOREGROUND_COLOR_RESET + "\n\n";
	}
	
}
