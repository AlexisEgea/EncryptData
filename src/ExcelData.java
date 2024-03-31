import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ExcelData {
    /**
     * Get All value (in String) from Excel File
     * @param fileLocation: Path to the Excel File
     * @return all the value from the first & second column from Excel File in tab_res
     */
    public static Map<String, String> getStringValueFromExcel(String fileLocation) throws IOException {
        Map<String, String> tab_res = new HashMap<>();
        FileInputStream file = new FileInputStream(fileLocation);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            if(sheet.getRow(i) != null){
                String key = dataFormatter.formatCellValue(sheet.getRow(i).getCell(0));
                String value = dataFormatter.formatCellValue(sheet.getRow(i).getCell(1));
                tab_res.put(key, value);
            }
        }
        file.close();
        workbook.close();
        return tab_res;
    }

    /**
     * Update the Excel File by locating the row to modify (with List[0]) and modify it (with List[1]) with the new value
     * @param fileLocation: Path to the Excel File
     * @param list: Set of two value : [0] = name to encode, [1] = value to encode
     *              Example: [0] = Username, [1] = Alexis
     * @throws IOException
     */
    public static void update(String fileLocation, List<String> list) throws IOException {
        FileInputStream file = new FileInputStream(fileLocation);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
            Row currentRow = sheet.getRow(j);
            if (currentRow != null) {
                String key = dataFormatter.formatCellValue(currentRow.getCell(0));
                if (Objects.equals(list.get(0), key)) {
                    Cell cell = currentRow.getCell(1);
                    cell.setCellValue(list.get(1));
                }
            }
        }
        FileOutputStream outFile = new FileOutputStream(fileLocation);
        workbook.write(outFile);
        outFile.close();
        file.close();
        workbook.close();
    }
}
