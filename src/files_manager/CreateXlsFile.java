package files_manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CreateXlsFile {
	
	public static void create () throws IOException {
		int howManyPeople = Person.setHowManyPeopleAdd();
		List<Person> people = new ArrayList<Person>();
		String userName = System.getProperty("user.name");
		
		File file = new File("/home/" + userName + "/my-projects/"
				+ "eclipse-workspace-java-web/files_manager/src/files/myUsersInfos.xls");
		
		if( !file.exists() ) {
			file.createNewFile();
		}
		
		for(int index = 1; index <= howManyPeople; index++) {
			Person person = new Person();
			person.setId( index );
			person.setName( JOptionPane.showInputDialog("What is the "+ index +" user name?") );
			person.setEmail( JOptionPane.showInputDialog("What is the "+ index +" user e-mail?") );
			person.setProgrammingLanguageProficiense( JOptionPane.showInputDialog( "What is the " + index + " user programming language proficiense?" ) );
			person.setAge( Integer.valueOf( JOptionPane.showInputDialog("How old is the "+ index +" user?") ) );
			people.add(person);
		}
		
		@SuppressWarnings("resource")
		HSSFWorkbook workBook = new HSSFWorkbook(); /* Will  be used to write the excel Spreadsheet - Planilha */
		HSSFSheet sheet = workBook.createSheet("Here is my First SpreadSheet with Apache Poi"); /*Make the spreadSheet */
		
		int lineNumber = 0;
		
		for(Person currentPerson : people) {
			
			Row row = sheet.createRow(lineNumber ++);
			
			int cell = 0;
			
			if (lineNumber == 1) {
				Cell idHeader = row.createCell( cell++ );
				idHeader.setCellValue( "Id" );
				
				Cell nameHeader = row.createCell( cell++  );
				nameHeader.setCellValue( "Name" );
				
				Cell emailHeader = row.createCell( cell++ );
				emailHeader.setCellValue( "e-Mail" );
				
				Cell programmingLanguageProficienseHeader = row.createCell( cell++ );
				programmingLanguageProficienseHeader.setCellValue( "Programming Language Proficiense" );
				
				Cell ageHeader = row.createCell( cell++ );
				ageHeader.setCellValue( "Age" );
				
				cell = 0;
				row = sheet.createRow(lineNumber++ );
			}
			
			Cell cellId = row.createCell(cell ++); //Inside Row - Cell 1
			cellId.setCellValue( currentPerson.getId() );
			
			Cell cellName = row.createCell(cell ++); //Inside Row - Cell 2
			cellName.setCellValue( currentPerson.getName() );
			
			Cell cellEmail = row.createCell(cell ++); //Inside Row - Cell 3
			cellEmail.setCellValue( currentPerson.getEmail() );
			
			Cell cellProgrammingLanguage = row.createCell(cell ++); //Inside Row - Cell 4
			cellProgrammingLanguage.setCellValue( currentPerson.getProgrammingLanguageProficiense() );
			
			Cell cellAge = row.createCell( cell++ ); //Inside Row - Cell 5
			cellAge.setCellValue( currentPerson.getAge() );
		} /* End of SpreadSheet */
		
		FileOutputStream output = new FileOutputStream(file);
		workBook.write( output );
		output.flush();
		output.close();
		
		System.out.println("\n**************************************************************************************");
		System.out.println("\n\u001B[32m\t\t**** File was Created! We had a Success in the operation! ****\u001B[0m");
		System.out.println("\n**************************************************************************************");
	}

}
