package com.ryl.learn.excel;


import com.ali.com.google.common.collect.Maps;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * Created on 17/7/10 19:17.
 */
public class OrderStat {
    

    
    @Test
    public void processOrderId() throws Exception {
        File file = new File("/Users/alibaba/Documents/mytemp/order_failed.txt");
        List<String> lines = Files.readLines(file, Charsets.UTF_8);
        for(String line : lines) {
            System.out.println("'"+line+"',");
        }
    }
    
    @Test
    public void carOrderFailed() throws Exception {
        Map<String, String> statusMap = Maps.newHashMap();
        File alipayExcel = new File("/Users/alibaba/Downloads/2017-07-10-19-09-53_EXPORT_XLSX_858097_441_0.xlsx");
        FileInputStream fis = new FileInputStream(alipayExcel);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(1);
        int rowNum = sheet.getPhysicalNumberOfRows();
        int colNum = row.getPhysicalNumberOfCells();
        for(int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            String amapOrderId = row.getCell(2).getStringCellValue();
            String tradeStatus = row.getCell(5).getStringCellValue();
            System.out.println(amapOrderId + " " + tradeStatus);
            statusMap.put(amapOrderId, tradeStatus);
        }
        File fileOut = new File("/Users/alibaba/logs/car_shenzhou_6.xlsx");
        Workbook wbOut = new XSSFWorkbook();
        Sheet sheetOut = wbOut.createSheet("sheet1");
        
        File excel = new File("/Users/alibaba/Downloads/order_failed_order.xlsx");
        fis = new FileInputStream(excel);
        wb = WorkbookFactory.create(fis);
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(1);
        rowNum = sheet.getPhysicalNumberOfRows();
        colNum = row.getPhysicalNumberOfCells();
        for (int r = 0; r < rowNum; r++) {
            row = sheet.getRow(r);
            String amapOrderId = row.getCell(3).getStringCellValue();
            String tradeStatus = statusMap.get(amapOrderId);
            System.out.println(amapOrderId);
            Cell cell = row.createCell(colNum);
            cell.setCellValue(tradeStatus);
            
//            for (int i = 0; i < colNum; i++) {
//                Cell cell = row.getCell(i);
//                System.out.print(cell == null ? null : cell.getStringCellValue() + ",");
//            }
            System.out.println();
        }
        
    }
    
}
