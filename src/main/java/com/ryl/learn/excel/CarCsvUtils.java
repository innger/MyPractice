package com.ryl.learn.excel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

/**
 * 打车每月财务数据处理类
 * Created on 17/7/3 10:51.
 */
public class CarCsvUtils {
    
    
    public static void main(String[] args) throws Exception {
        
        shenzhouExcel();
        
    }
    
    
    private static void shenzhouExcel() throws Exception {
        String cpCode = "9003";
        File fileOut = new File("/Users/alibaba/logs/car_shenzhou_6.xlsx");
        
        Workbook wbOut = new XSSFWorkbook();
        Sheet sheetOut = wbOut.createSheet("sheet1");
        
        File excel = new File("/Users/alibaba/Downloads/2017-07-03-11-17-20_EXPORT_XLSX_840992_765_0.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(1);
        int rowNum = sheet.getPhysicalNumberOfRows();
        int colNum = row.getPhysicalNumberOfCells();
        String[] feeDetailCols = new String[]{"停车费", "时长费", "抹零", "路桥费", "违约金", "清洁费", "里程费", "出城费", "起租价", "远途费"};
        
        int outRowNum = 0;
        Row rowOut = sheetOut.createRow(outRowNum);
        for (int i = 1; i <= colNum; i++) {
            String value = String.valueOf(row.getCell(i));
            Cell cell = rowOut.createCell(i - 1);
            cell.setCellValue(value);
        }
        for (int i = 0; i < feeDetailCols.length; i++) {
            Cell cell = rowOut.createCell(colNum + i);
            cell.setCellValue(feeDetailCols[i]);
        }
        
        String[] values = new String[colNum];
        for (int r = 2; r <= rowNum; r++) {
            row = sheet.getRow(r);
            String cpCodeExcel = String.valueOf(row.getCell(7));
            if (!cpCode.equals(cpCodeExcel)) continue;
            outRowNum++;
            rowOut = sheetOut.createRow(outRowNum);
            for (int i = 1; i <= colNum; i++) {
                String value = String.valueOf(row.getCell(i));
                Cell cell = rowOut.createCell(i - 1);
                cell.setCellValue(value);
                values[i - 1] = value;
            }
            //处理feeDetail
            String feeDetail = values[colNum - 1];
            if (!Strings.isNullOrEmpty(feeDetail)) {
                JSONArray jsonArray = JSON.parseArray(feeDetail);
                Map<String, String> feeDetailMap = Maps.newHashMap();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String title = object.getString("title").split("\\(")[0];
                    String value = object.getString("value");
                    feeDetailMap.put(title, value);
                }
                for (int i = 0; i < feeDetailCols.length; i++) {
                    String value = feeDetailMap.get(feeDetailCols[i]);
                    if (Strings.isNullOrEmpty(value)) {
                        value = "0";
                    }
                    Cell cell = rowOut.createCell(colNum + i);
                    cell.setCellValue(value);
                }
            }
        }
        
        OutputStream outputStream = new FileOutputStream(fileOut);
        wbOut.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
    
    private static void shouqiExcel() throws Exception {
        String cpCode = "9002";
        File fileOut = new File("/Users/alibaba/logs/car_shouqi_6.xlsx");
        
        Workbook wbOut = new XSSFWorkbook();
        Sheet sheetOut = wbOut.createSheet("sheet1");
        
        File excel = new File("/Users/alibaba/Downloads/2017-07-03-11-17-20_EXPORT_XLSX_840992_765_0.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(1);
        int rowNum = sheet.getPhysicalNumberOfRows();
        int colNum = row.getPhysicalNumberOfCells();
        String[] shouqi = new String[]{"基础价格", "高峰时长费", "抹零", "夜间里程费", "空驶费", "超里程费用", "高速服务费", "超时长费用"};
        
        int outRowNum = 0;
        Row rowOut = sheetOut.createRow(outRowNum);
        for (int i = 1; i <= colNum; i++) {
            String value = String.valueOf(row.getCell(i));
            Cell cell = rowOut.createCell(i - 1);
            cell.setCellValue(value);
        }
        for (int i = 0; i < shouqi.length; i++) {
            Cell cell = rowOut.createCell(colNum + i);
            cell.setCellValue(shouqi[i]);
        }
        
        Set<String> feeDetailCols = Sets.newHashSet();
        
        String[] values = new String[colNum];
        for (int r = 2; r <= rowNum; r++) {
            row = sheet.getRow(r);
            String cpCodeExcel = String.valueOf(row.getCell(7));
            if (!cpCode.equals(cpCodeExcel)) continue;
            outRowNum++;
            rowOut = sheetOut.createRow(outRowNum);
            for (int i = 1; i <= colNum; i++) {
                String value = String.valueOf(row.getCell(i));
                Cell cell = rowOut.createCell(i - 1);
                cell.setCellValue(value);
                values[i - 1] = value;
            }
            //处理feeDetail
            String feeDetail = values[colNum - 1];
            if (!Strings.isNullOrEmpty(feeDetail)) {
                JSONArray jsonArray = JSON.parseArray(feeDetail);
                Map<String, String> feeDetailMap = Maps.newHashMap();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String title = object.getString("title");
                    String value = object.getString("value");
                    feeDetailCols.add(title);
                    feeDetailMap.put(title, value);
                }
                for (int i = 0; i < shouqi.length; i++) {
                    String value = feeDetailMap.get(shouqi[i]);
                    if (Strings.isNullOrEmpty(value)) {
                        value = "0";
                    }
                    Cell cell = rowOut.createCell(colNum + i);
                    cell.setCellValue(value);
                }
            }
        }
        
        OutputStream outputStream = new FileOutputStream(fileOut);
        wbOut.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
    
    private static void getFeeDetail(String cpCode) throws Exception {
        File excel = new File("/Users/alibaba/Downloads/2017-07-03-11-17-20_EXPORT_XLSX_840992_765_0.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(1);
        int rowNum = sheet.getPhysicalNumberOfRows();
        int colNum = row.getPhysicalNumberOfCells();
        Set<String> feeDetailCols = Sets.newHashSet();
        for (int r = 2; r <= rowNum; r++) {
            row = sheet.getRow(r);
            String cpCodeExcel = String.valueOf(row.getCell(7));
            if (!cpCode.equals(cpCodeExcel)) continue;
            //处理feeDetail
            String feeDetail = String.valueOf(row.getCell(colNum));
            if (!Strings.isNullOrEmpty(feeDetail)) {
                JSONArray jsonArray = JSON.parseArray(feeDetail);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String title = object.getString("title");
                    feeDetailCols.add(title.split("\\(")[0]);
                }
            }
        }
        System.out.println(feeDetailCols);
    }
    
    
}
