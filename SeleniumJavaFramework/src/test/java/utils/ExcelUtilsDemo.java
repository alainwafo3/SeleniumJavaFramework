package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelUtils excel =new ExcelUtils("excel/data.xlsx", "Sheet1");
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);

	}

}
