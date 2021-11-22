package utils;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	//static String cellData;
	//Sheet 1 est le tableur 1 sur excel
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet=workbook.getSheet(sheetName);

		} catch (Exception e) {
			System.out.println("Message: "+e.getMessage());
			System.out.println("Cause: "+e.getCause());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//getRowCount();
		//getCellDataString(0,0);
		//getCellDataNumber(1,1);
	}


	public static int getRowCount() {
		int rowCount=0;
		try {
			//projectPath=System.getProperty("user.dir");
			//for new excel format (xlsx)

			//workbook = new XSSFWorkbook(projectPath+"/excel/data.xlsx");
			//for old excel format (xls)
			//HSSFWorkbook workbook= new HSSFWorkbook();
			//sheet=workbook.getSheet("Sheet1");
			rowCount =sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows: "+rowCount);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Message: "+e.getMessage());
			System.out.println("Cause: "+e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}


	public static int getColCount() {
		int colCount=0;
		try {

			colCount =sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of columns: "+colCount);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Message: "+e.getMessage());
			System.out.println("Cause: "+e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}


	public static String getCellDataString(int rowNum, int colNum) {
		String cellData=null;
		try {
			//projectPath=System.getProperty("user.dir");

			//cellData =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

			DataFormatter formatter = new DataFormatter();
			cellData = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Message: "+e.getMessage());
			System.out.println("Cause: "+e.getCause());
			e.printStackTrace();
		}
		return cellData;

	}


	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			//projectPath=System.getProperty("user.dir");
			//for new excel format (xlsx)

			//workbook = new XSSFWorkbook("/excel/data.xlsx");
			//for old excel format (xls)
			//HSSFWorkbook workbook= new HSSFWorkbook();
			//sheet=workbook.getSheet("Sheet1");
			double cellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println(cellData);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Message: "+e.getMessage());
			System.out.println("Cause: "+e.getCause());
			e.printStackTrace();
		}

	}
}
