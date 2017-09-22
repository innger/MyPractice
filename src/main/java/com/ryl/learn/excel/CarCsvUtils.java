package com.ryl.learn.excel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * 打车每月财务数据处理类
 * Created on 17/7/3 10:51.
 */
public class CarCsvUtils {
    
    
    public static void main(String[] args) throws Exception {

//        getFeeDetail("9002");
//        shenzhouExcel();
        shouqiExcel();
        
    }
    
    /**
     * 财务每月数据导出
     * select a.*, b.fee_detail from (
     * select * from car_order where gmt_create >= '2017-07-01 00:00:00' and gmt_create <= '2017-07-31 23:59:59'
     * and cp_code = 9002 and status in (106,112) and amap_ride_type <> 'gd_taxi') a
     * left join car_order_bill b on (a.amap_order_id = b.amap_order_id)
     */
    
    
    private static void shenzhouExcel() throws Exception {
        String cpCode = "9003";
        File fileOut = new File("/Users/alibaba/Downloads/car_shenzhou_201708.xlsx");
        
        Workbook wbOut = new XSSFWorkbook();
        Sheet sheetOut = wbOut.createSheet("sheet1");
        
        File excel = new File("/Users/alibaba/Downloads/201708月神州对账-20170918.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(1);
        int rowNum = sheet.getPhysicalNumberOfRows();
        int colNum = row.getPhysicalNumberOfCells();
        String[] feeDetailCols =
                new String[]{"停车费", "时长费", "抹零", "路桥费", "违约金", "里程费", "出城费", "起租价", "其他费用", "远途费"};
        
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
            if (row == null) break;
            String cpCodeExcel = String.valueOf(row.getCell(7));
            if (!cpCodeExcel.contains(cpCode)) continue;
            outRowNum++;
            rowOut = sheetOut.createRow(outRowNum);
            for (int i = 1; i <= colNum; i++) {
                Cell cellIn = row.getCell(i);
                String value = String.valueOf(cellIn);
                values[i - 1] = value;
                Cell cell = rowOut.createCell(i - 1);
                copyCell(cellIn, cell);
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
                    cell.setCellType(CellType.STRING);
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
        File fileOut = new File("/Users/alibaba/Downloads/car_shouqi_201708.xlsx");
        
        Workbook wbOut = new XSSFWorkbook();
        Sheet sheetOut = wbOut.createSheet("sheet1");
        
        File excel = new File("/Users/alibaba/Downloads/201708月首汽对账-20170920.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(1);
        int rowNum = sheet.getPhysicalNumberOfRows();
        int colNum = row.getPhysicalNumberOfCells();
        String[] shouqi = new String[]{"基础价格", "高峰时长费", "停车费", "抹零", "夜间里程费", "空驶费", "超里程费用", "高速服务费", "高峰里程费用", "等待费用", "超时长费用", "夜间时长费用"};
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
            if (!cpCodeExcel.contains(cpCode)) continue;
            outRowNum++;
            rowOut = sheetOut.createRow(outRowNum);
            for (int i = 1; i <= colNum; i++) {
                Cell cellIn = row.getCell(i);
                String value = String.valueOf(cellIn);
                values[i - 1] = value;
                if(cellIn == null) {
                    rowOut.createCell(i - 1);
                    continue;
                }
                Cell cell = rowOut.createCell(i - 1, cellIn.getCellTypeEnum());
                copyCell(cellIn, cell);
            }
            //处理feeDetail
            String feeDetail = values[colNum - 1];
            if (!Strings.isNullOrEmpty(feeDetail)) {
                JSONArray jsonArray = JSON.parseArray(feeDetail);
                if (jsonArray == null) continue;
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
        File excel = new File("/Users/alibaba/Downloads/201708月首汽对账-20170920.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(1);
        int rowNum = sheet.getPhysicalNumberOfRows();
        int colNum = row.getPhysicalNumberOfCells();
        Set<String> feeDetailCols = Sets.newHashSet();
        for (int r = 2; r <= rowNum; r++) {
            row = sheet.getRow(r);
            if (row == null) break;
            Cell cpCodeCell = row.getCell(7);
            if (cpCodeCell == null) break;
            String cpCodeExcel = String.valueOf(cpCodeCell);
            if (!cpCodeExcel.contains(cpCode)) continue;
            //处理feeDetail
            Cell cell = row.getCell(colNum);
            if (cell == null) continue;
            String feeDetail = String.valueOf(cell);
            if (!Strings.isNullOrEmpty(feeDetail)) {
                System.out.println(r + " " + feeDetail);
                JSONArray jsonArray = JSON.parseArray(feeDetail);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String title = object.getString("title");
                    feeDetailCols.add(title.split("\\(")[0]);
                }
            }
        }
        System.out.println(feeDetailCols);
        System.out.println("\"" + Joiner.on("\",\"").join(feeDetailCols) + "\"");
    }
    
    private static void copyCell(Cell sourceCell, Cell targetCell) {
        switch (sourceCell.getCellTypeEnum()) {
            case STRING:
                targetCell.setCellValue(sourceCell.getRichStringCellValue());
                break;
            case NUMERIC:
                targetCell.setCellValue(sourceCell.getNumericCellValue());
                break;
            case BLANK:
                targetCell.setCellType(CellType.BLANK);
                break;
            case BOOLEAN:
                targetCell.setCellValue(sourceCell.getBooleanCellValue());
                break;
            case ERROR:
                targetCell.setCellErrorValue(sourceCell.getErrorCellValue());
                break;
            case FORMULA:
                targetCell.setCellFormula(sourceCell.getCellFormula());
                break;
            default:
                break;
        }
    }
}
