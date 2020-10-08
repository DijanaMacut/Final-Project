package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromFile {
    private XSSFWorkbook wb;
    private FileInputStream fi;
    private String path;

    public ReadFromFile(String path) {
        this.path = path;
        try {
            fi = new FileInputStream(path);
            wb = new XSSFWorkbook(fi);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Input format not correct.");
        }
    }

    public String getCell(int row, int column) {
        Sheet sheet = wb.getSheetAt(0);
        Row r = sheet.getRow(row);
        Cell cell = r.getCell(column);
        return cell.toString();
    }
}
