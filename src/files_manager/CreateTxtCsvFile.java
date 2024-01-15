package files_manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CreateTxtCsvFile {
	private static String extention = "";
	private static String FOREGROUND_COLOR_GREEN = "\u001B[32m";
	private static String FOREGROUND_COLOR_RESET = "\u001B[0m";

	public static void create() throws IOException {
		int option;
		String userName = System.getProperty("user.name");
		
		do {
			
			try {
				option = Integer.valueOf( JOptionPane.showInputDialog( "Which kind of file would you like to write?\n"
						+ "1 - Txt;\n2 - Csv." ) );
				
				if (option == 1) {
					extention = "txt";
				} else if (option == 2) {
					extention = "csv";
				} else {
					JOptionPane.showMessageDialog(null, "Please, type a valid value...", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
			
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please, type a integer valid number to keep going...", "ERROR!", JOptionPane.ERROR_MESSAGE);
				option = 0;
			}
			
		} while ( option < 1 || option > 2 );
		
		int howManyPeople = Person.setHowManyPeopleAdd();
		
		List<Person> people = new ArrayList<Person>();
		
		File fileDirectory = new File ("/home/" + userName + "/my-projects/"
				+ "eclipse-workspace-java-web/files_manager/src/files/myUsersInfos." + extention);
		
		if ( !fileDirectory.exists() ) {
			fileDirectory.createNewFile();
		}
		
		FileWriter writer = new FileWriter( fileDirectory );
		
		for (int index = 1; index <= howManyPeople; index++) {
			Person person = new Person();
			person.setId( index );
			person.setName( JOptionPane.showInputDialog( "Enter the user " + index + " name" ) );
			person.setEmail( JOptionPane.showInputDialog( "Enter the user " + index + " e-mail" ) );
			person.setProgrammingLanguageProficiense( JOptionPane.showInputDialog( "Enter the user " + index + " Programming Language Proficiense" ) );
			person.setAge( Integer.valueOf( JOptionPane.showInputDialog( "Enter the user "+ index + " age" ) ) );
			
			people.add(person);
		}
		
		int headerLine = 0;
		
		for (Person currentPerson : people) {
			
			if(headerLine == 0) {
				writer.write( "Id;Name;e-Mail;Programming_LanguageProficiense;Age\n" );
				headerLine++;
			}
			
			writer.write(currentPerson.getId() + ";" + currentPerson.getName() + ";" + currentPerson.getEmail() + ";"
					+ currentPerson.getProgrammingLanguageProficiense() + ";" + currentPerson.getAge() + "\n" );
		}
		
		writer.flush();
		writer.close();
		
		System.out.println( FOREGROUND_COLOR_GREEN + "\n\n\t -->File created successfully!!!" + FOREGROUND_COLOR_RESET );
		
	}
	
}
