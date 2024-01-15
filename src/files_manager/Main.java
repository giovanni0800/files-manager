package files_manager;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		int  option;
		char repeat = 'Y';
		
		while (Character.toUpperCase(repeat) == 'Y') {
			try {
				
				do {
					option = Integer.valueOf( JOptionPane.showInputDialog( "What would you like to do (1 or 2)??\n\n"
							+ "1 - Create a new text or csv file with users;\n2 - Read an existing text or csv file;\n3 - Create a new xls file with users"
							+ "\n4 - Read an existing xls file." ) );
				} while (option < 1 || option > 4);
				
				if(option == 1) {
					CreateTxtCsvFile.create();
				
				} else if (option == 2) {
					ReadTxtCsvFile.read();
				
				} else if ( option == 3 ) {
					CreateXlsFile.create();
				
				} else if (option == 4) {
					ReadXlsFile.read();
					
				} else {
					JOptionPane.showMessageDialog(null, "Please, type a valid number!!", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				
				repeat = JOptionPane.showInputDialog( "Would you like to run app again [y/n]?\n\n" ).charAt(0);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Oh no!! You typed a invalid value to the previous field... "
						+ "Try enter a integer value (between 1 and 4)", "ERROR!!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		JOptionPane.showMessageDialog(null, "Thanks for use the *** Java Files Manager ***!");

	}

}
