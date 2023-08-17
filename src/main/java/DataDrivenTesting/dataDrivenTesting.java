package DataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class dataDrivenTesting {
    // Reading the excel sheet from Resources Folder
    static XSSFWorkbook wb;
    static XSSFSheet sheet1;

    public static void readingExcelSheet(String fileName) {
        try {
            File src = new File(fileName);

            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static String getData(int sheetNumber, int row, int column) {
        sheet1 = wb.getSheetAt(sheetNumber);
        String data = sheet1.getRow(row).getCell(column).getStringCellValue();
        return data;

    }

    public int getRowCount(int sheetIndex) {
        int rowC = wb.getSheetAt(sheetIndex).getLastRowNum();
        rowC = rowC + 1;
        return rowC;
    }
}
