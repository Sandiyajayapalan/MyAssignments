package servicenowassignments.testng.dp;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/* Steps to read from excel:
			1.Open the workbook using filename and path
			2.Go to the specific sheet(by sheet name or index)
			3.Go to specific row(by index)    
			4.Go to the specific column(by index)---cell
			5.Read the content from excel
			*/
		//Set  the path
        XSSFWorkbook wbook=new XSSFWorkbook("Data/NewCallerData.xlsx");
        //Open the sheet
        XSSFSheet sheet=wbook.getSheetAt(0);//read the first sheet
        //Row count
        int rowCount = sheet.getLastRowNum(); //ctrl+2+l
        //column count
        short columnCount = sheet.getRow(0).getLastCellNum();  //ctrl+2+l
        
         System.out.println("Row Count"+rowCount);
         System.out.println("Column Count"+columnCount);
         
         //XSSFRow
         XSSFRow fstRow =sheet.getRow(2);
         XSSFCell companyName=fstRow.getCell(3);
         System.out.println(companyName.getStringCellValue());		

	}

}
