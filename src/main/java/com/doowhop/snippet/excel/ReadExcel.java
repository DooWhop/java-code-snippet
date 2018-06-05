package com.doowhop.snippet.excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static void readExcel() throws FileNotFoundException, IOException {
		
		try(XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\liudp\\Desktop\\area.xlsx")))){
			
			XSSFSheet sheet = book.getSheetAt(0);
		    
		    List<Map<String, Object>> list = new ArrayList<>();

		    for(int i=1; i<sheet.getLastRowNum()+1; i++) {
		        XSSFRow row = sheet.getRow(i);
		        String areaName = row.getCell(1).getStringCellValue(); 
		        String areaNo = row.getCell(2).getStringCellValue(); 
		        String parentAreaNo = row.getCell(3)==null? null:row.getCell(3).getStringCellValue();
		        Map<String, Object> map = new HashMap<>();
		        map.put("areaName", areaName);
		        map.put("areaNo", areaNo);
		        map.put("parentAreaNo", parentAreaNo);
		        list.add(map);
		    }
		    System.out.println(list.size());
		    
		    FileWriter fw = new FileWriter(new File("C:\\Users\\liudp\\Desktop\\area1.sql"));
		    for (Map<String, Object> map : list) {				
				fw.write("insert into loan.full_area (area_name, area_no, parent_area_no) values (" +"\'"+ map.get("areaName")+"\'"
				+", "+"\'"+map.get("areaNo")+"\'"+" ,"+"\'"+map.get("parentAreaNo")+"\'"+");");
				fw.write("\n");
				fw.flush();
					
			}
		    fw.close();
		}

	    System.out.println("done!");
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		readExcel();
	}
	

}
