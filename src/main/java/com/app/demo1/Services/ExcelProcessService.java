package com.app.demo1.Services;

import com.app.demo1.Services.impl.ExcelFileInterface;
import com.app.demo1.model.FileInfoModel;
import com.app.demo1.model.RecordModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelProcessService implements ExcelFileInterface {


    FileInputStream fileInputStream = null;
    Workbook workbook =null;

    @Override
    public List<RecordModel> processExcel(FileInfoModel fileInfoModel) throws IOException {

        String path = fileInfoModel.getFilePath();
        String fileName = fileInfoModel.getFileName();
        Sheet sheet = workbook.getSheet(fileInfoModel.getSheetName());
        List<RecordModel> recordModelList = new ArrayList<>();

        try {
            File tempfile = new File( path + fileName);
            workbook = new XSSFWorkbook(fileInputStream);

            List<RecordModel> recordList = new ArrayList<>();
            Iterator<Row> rows = sheet.rowIterator();
            RecordModel recordModel = null;

            while (rows.hasNext()){
             Row currentRow = rows.next();
             int rowNumber = currentRow.getRowNum();

             if (rowNumber == 0 || rowNumber == 1){
                 continue;
             }
             recordModel = new RecordModel();
             loadModelUsingSheet(recordModel, currentRow);
             recordModelList.add(recordModel);
            }

        } catch (IOException e){
            System.out.println(e + "Issue with reading timesheet");
        } finally {
            if (workbook != null){
                workbook.close();
            if (fileInputStream != null){
                fileInputStream.close();
                }
            }
        }
        return null;
    }

    private void loadModelUsingSheet(RecordModel recordModel, Row currentRow) {

        Iterator<Cell> cellsInRow = currentRow.cellIterator();
        int cellIndex;
        while(cellsInRow.hasNext()){
            Cell currentCell = cellsInRow.next();
            cellIndex = currentCell.getColumnIndex();

            switch(cellIndex){
                case 3:
                    recordModel.setFirstName(currentCell.getStringCellValue());
                    break;
                case 4:
                    recordModel.setLastName(currentCell.getStringCellValue());
                    break;
                case 5:
                    recordModel.setState(currentCell.getStringCellValue());
                    break;
            }
        }

    }
}
