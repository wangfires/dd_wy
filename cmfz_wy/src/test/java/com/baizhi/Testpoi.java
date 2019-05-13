package com.baizhi;

import com.baizhi.entity.Slideshow;
import com.baizhi.service.SlideshowService;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)

@SpringBootTest
public class Testpoi {
    @Autowired
    private SlideshowService slideshowService;
    @Test
    public void test1(){
    //创建excel工作薄对象
    HSSFWorkbook workbook = new HSSFWorkbook();
    //创建工作表
    HSSFSheet sheet = workbook.createSheet("轮播图信息");
    //创建标题行
    HSSFRow row = sheet.createRow(0);
    String [] title={"id","title","picpath","des","status","createdate","filename"};
        List<Slideshow> all = slideshowService.findAll();
        System.out.println(all);
        System.out.println(all.size());
        //创建单元格对象
    HSSFCell cell=null;
    for (int i =0;i<title.length;i++){
        cell = row.createCell(i);
        cell.setCellValue(title[i]);
    }
    //处理日期格式
    HSSFCellStyle cellStyle = workbook.createCellStyle(); //样式对象
    HSSFDataFormat dataFormat = workbook.createDataFormat(); //日期格式
    cellStyle.setDataFormat(dataFormat.getFormat("yyyy 年 MM 月 dd 日 ")); //设置日期格式
    //处理数据行
            for (int i = 1; i<=all.size(); i++) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(all.get(i-1).getId());
            row.createCell(1).setCellValue(all.get(i-1).getTitle());
            row.createCell(2).setCellValue(all.get(i-1).getPicpath());
            row.createCell(3).setCellValue(all.get(i-1).getDes());
            row.createCell(4).setCellValue(all.get(i-1).getStatus());
            row.createCell(5).setCellValue(all.get(i-1).getCreatedate());
            row.createCell(6).setCellValue(all.get(i-1).getFilename());
            //设置出生年月格式
            cell = row.createCell(5);
            cell.setCellValue(new Date());
            cell.setCellStyle(cellStyle);
        }
    try {
        workbook.write(new File("d:\\轮播图.xls"));
        workbook.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    @Test
    public void aa() throws IOException {
        try {
            // 获取本地 Excel 文件输入流，并创建工作薄对象
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("d:\\111.xls"));
            // 获取工作表
            HSSFSheet sheet = workbook.getSheet("轮播图信息");
            System.out.println(sheet);
            // 声明行对象
            HSSFRow row = null;
            //注意：获取数据 需排除标题行 从数据行开始读取
            ArrayList<Slideshow> slideshows = new ArrayList<>();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            // 获取当前工作表中的数据行信息 数据行索引从 1 开始
                row = sheet.getRow(i);
               // System.out.println((int)row.getCell(0).getNumericCellValue() + " " + row.getCell(1).getStringCellValue() + " " + row.getCell(2).getDateCellValue());
                Slideshow slideshow = new Slideshow();
                slideshow.setId(row.getCell(0).getStringCellValue());
                slideshow.setTitle(row.getCell(1).getStringCellValue());
                slideshow.setPicpath(row.getCell(2).getStringCellValue());
                slideshow.setDes(row.getCell(3).getStringCellValue());
                slideshow.setCreatedate(row.getCell(4).getDateCellValue());
                slideshow.setFilename(row.getCell(5).getStringCellValue());
                slideshows.add(slideshow);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); }
    }
    @Test
    public void mm(){
        //slideshowService.insertSlideshows();
    }
}





