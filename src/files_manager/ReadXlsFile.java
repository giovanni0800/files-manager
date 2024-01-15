package files_manager;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadXlsFile {

	public static void read () throws Exception {
		String userName = System.getProperty("user.name");
		
		FileInputStream fileInput = new FileInputStream( new File( "/home/" + userName + "/my-projects/"
				+ "eclipse-workspace-java-web/files_manager/src/files/myUsersInfos.xls" ) );
		
		HSSFWorkbook workbook = new HSSFWorkbook( fileInput ); //Prepara a entrada do arquivo excel para ler.
		HSSFSheet sheet = workbook.getSheetAt( 0 );
		
		Iterator<Row> loopIterator = sheet.iterator();
		
		List<Person> people = new ArrayList<Person>();
		
		int separateLineHeader = 0;
		
		while ( loopIterator.hasNext() ) {
			
			Row row = loopIterator.next();
			
			if( separateLineHeader == 0 ) {
				separateLineHeader++;
				continue;
			}
			
			Iterator<Cell> cells = row.iterator();
			
			Person person = new Person();
			
			while ( cells.hasNext() ) {
				
				Cell currentCell = cells.next();
				
				switch ( currentCell.getColumnIndex() ) {
					case 0 :
						person.setId( (int) currentCell.getNumericCellValue() );
						break;
					case 1 :
						person.setName( currentCell.getStringCellValue() );
						break;
					case 2:
						person.setEmail( currentCell.getStringCellValue() );
						break;
					case 3:
						person.setProgrammingLanguageProficiense( currentCell.getStringCellValue() );
						break;
					case 4:
						person.setAge( ( int ) currentCell.getNumericCellValue() ) ;
						break;
				}
				
			}
			
			people.add(person);
			
		}
		
		fileInput.close();
		workbook.close();
		
		for(Person currentPerson : people) {
			System.out.println( currentPerson );
			Thread.sleep(1000);
		}
	
	}

}
