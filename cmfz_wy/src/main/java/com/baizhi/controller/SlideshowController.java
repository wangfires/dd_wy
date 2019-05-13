package com.baizhi.controller;

import com.baizhi.entity.Slideshow;
import com.baizhi.service.SlideshowService;
import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("slideshow")
public class SlideshowController {
    @Autowired
    private FastFileStorageClient client;
    @Autowired
    private SlideshowService slideshowService;
    @RequestMapping("edit")
    @ResponseBody
    public void edit(Slideshow slideshow, MultipartFile aaa, HttpServletRequest request) throws IOException {
        System.out.println(slideshow);
        System.out.println(aaa.getOriginalFilename());


        if (slideshow.getId()==null||"".equals(slideshow.getId())){
            //String type = aaa.getOriginalFilename().substring(aaa.getOriginalFilename().indexOf("."));
            //String realPath = request.getSession().getServletContext().getRealPath("/upload/");
            //String fileName = String.valueOf(System.currentTimeMillis()) + type;
            //slideshow.setPicpath("/upload/"+fileName);
            //aaa.transferTo(new File(realPath+fileName));
            //slideshow.setFilename(fileName);
            //File file = new File("d:\\dalao.jpg");

            //返回值封装了fileid
            //StorePath storePath = client.uploadFile(aaa.getInputStream(),aaa.getSize(), "jpg", null);
            StorePath storePath = client.uploadImageAndCrtThumbImage(aaa.getInputStream(), aaa.getSize(), "jpg", null);

            //slideshow.setFilename("192.168.31.152/"+storePath.getFullPath()+"_150x150");
            slideshow.setPicpath("192.168.31.152/"+storePath.getFullPath());
            slideshowService.add(slideshow);
        }else {
            slideshowService.update(slideshow);
        }
    }
    @RequestMapping("del")
    @ResponseBody
    public void del(String id){

        System.out.println(id);
        slideshowService.delete(id);
    }
    @ResponseBody
    @RequestMapping("findByPage")
    public Map<String,Object> findAll( Integer page, Integer rows){
        HashMap<String, Object> result = new HashMap<>();
        PageInfo<Slideshow> byPage = slideshowService.findByPage(page, rows);
        result.put("page",page);
        result.put("rows",byPage.getList());
        result.put("total",byPage.getPages());
        result.put("records",byPage.getTotal());
        return result;
    }
    @RequestMapping("/download")
    @ResponseBody
    public void download(String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //0.根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //1.根据获取的文件名读取指定目录中文件
        FileInputStream is = new FileInputStream(new File(realPath, name));
        //1.5 指定浏览器以附件形式下载  inline: 默认值 在线打开  attachment: 附件
        response.setHeader("content-disposition","inline;fileName="+ URLEncoder.encode(name,"UTF-8"));
        //1.8动态获取文件类型
        String extension = FilenameUtils.getExtension(name);//获取文件名后缀 没有"."
        String contentType = request.getSession().getServletContext().getMimeType("."+extension);
        System.out.println("动态获取文件类型: "+contentType);
        response.setContentType(contentType);
        //2.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //3.文件拷贝   1028
        int len = 0;
        byte[] b = new byte[1024];
        while (true){
            len = is.read(b);
            if (len==-1)break;
            os.write(b,0,len);
        }
        is.close();
        os.close();
    }
    @RequestMapping("export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse resp) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet = workbook.createSheet("轮播图信息");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        String[] title = {"id", "title", "picpath", "des", "status", "createdate", "filename"};
        List<Slideshow> all = slideshowService.findAll();
        System.out.println(all);
        System.out.println(all.size());
        //创建单元格对象
        HSSFCell cell = null;
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //处理日期格式
        HSSFCellStyle cellStyle = workbook.createCellStyle(); //样式对象
        HSSFDataFormat dataFormat = workbook.createDataFormat(); //日期格式
        cellStyle.setDataFormat(dataFormat.getFormat("yyyy 年 MM 月 dd 日 ")); //设置日期格式
        //处理数据行
        for (int i = 1; i <= all.size(); i++) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(all.get(i - 1).getId());
            row.createCell(1).setCellValue(all.get(i - 1).getTitle());
            row.createCell(2).setCellValue(all.get(i - 1).getPicpath());
            row.createCell(3).setCellValue(all.get(i - 1).getDes());
            row.createCell(4).setCellValue(all.get(i - 1).getStatus());
            row.createCell(5).setCellValue(all.get(i - 1).getCreatedate());
            row.createCell(6).setCellValue(all.get(i - 1).getFilename());
            //设置出生年月格式
            cell = row.createCell(5);
            cell.setCellValue(new Date());
            cell.setCellStyle(cellStyle);
        }
        String fileName = "用户报表("+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+").xls";
        try {
            fileName = new String(fileName.getBytes("gbk"),"iso-8859-1");
            //设置 response
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("content-disposition","attachment;filename="+fileName);
            workbook.write(resp.getOutputStream());
            workbook.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @RequestMapping("load")
    @ResponseBody
    public void aa(MultipartFile aaa) throws IOException {
        try {
            // 获取本地 Excel 文件输入流，并创建工作薄对象
            System.out.println(aaa.getInputStream());
            System.out.println(aaa.getName());
            HSSFWorkbook workbook = new HSSFWorkbook(aaa.getInputStream());

            // 获取工作表

            HSSFSheet sheetAt = workbook.getSheetAt(0);

            String sheetName =sheetAt.getSheetName();
            HSSFSheet sheet = workbook.getSheet(sheetName);
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

                slideshow.setStatus(row.getCell(4).getStringCellValue());

                slideshow.setCreatedate(row.getCell(5).getDateCellValue());

                slideshow.setFilename(row.getCell(6).getStringCellValue());

                slideshows.add(slideshow);
            }
            System.out.println(slideshows);
            slideshowService.insertSlideshows(slideshows);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); }
    }
}
