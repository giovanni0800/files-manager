package files_manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ReadTxtCsvFile {
	private static String extention = "";

	public static void read() throws FileNotFoundException {
		
		int option;
		String userName = System.getProperty("user.name");
		
		do {
			
			try {
				option = Integer.valueOf( JOptionPane.showInputDialog( "Which kind of file would you like to read?\n"
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

		FileInputStream inputStream = new FileInputStream( new File( "/home/"+ userName + "/my-projects/"
				+ "eclipse-workspace-java-web/files_manager/src/files/myUsersInfos." + extention ) );
				
		List<Person> people = new ArrayList<Person>();
		
		try ( Scanner scan = new Scanner( inputStream, "UTF-8" ) ) {
			int fileLineNumber = 0;
			
			while ( scan.hasNext() ) {
				String currentLine = scan.nextLine();
				
				if (currentLine != null && !currentLine.isEmpty() ) {
					
					if (fileLineNumber == 0) {
						fileLineNumber++;
						continue;
					}
					
					String[] peopleArray = currentLine.split("\\;");
					Person currentPersonInformations = new Person();
					currentPersonInformations.setId( Integer.valueOf( peopleArray[0] ) );
					currentPersonInformations.setName( peopleArray[1] );
					currentPersonInformations.setEmail( peopleArray[2] );
					currentPersonInformations.setProgrammingLanguageProficiense( peopleArray[3] );
					currentPersonInformations.setAge( Integer.valueOf( peopleArray[4] ) );
					
					people.add(currentPersonInformations);
				}
				
			}
			
			for( Person p : people ) {
				System.out.println( p.toString() );
				Thread.sleep(1000);
			}
		
		} catch (Exception e) {
			//
		}
		
	}
	
}
