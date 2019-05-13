package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.github.pagehelper.PageInfo;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.io.FilenameUtils;
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
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @ResponseBody
    @RequestMapping("add")
    public void edit(Chapter slideshow, MultipartFile aaa, HttpServletRequest request) throws IOException, EncoderException {

        if (slideshow.getId()==null||"".equals(slideshow.getId())){

            String type = aaa.getOriginalFilename().substring(aaa.getOriginalFilename().indexOf("."));
            String realPath = request.getSession().getServletContext().getRealPath("/audio/");
            String fileName = String.valueOf(System.currentTimeMillis()) + type;
            slideshow.setAudiopath("/audio/"+fileName);
            File file = new File(realPath + fileName);
            aaa.transferTo(file);
            Encoder encoder = new Encoder();
            MultimediaInfo m = encoder.getInfo(file);
            long ls = m.getDuration() / 1000;
            long length = file.length();
            slideshow.setDuration(ls);
            slideshow.setSizes(length);
            chapterService.save(slideshow);
        }
    }
    @ResponseBody
    @RequestMapping("findByPage")
    public Map<String,Object> findAll(Integer page, Integer rows){
        HashMap<String, Object> result = new HashMap<>();
        PageInfo<Chapter> byPage = chapterService.findByPage(page, rows);
        result.put("page",page);
        result.put("rows",byPage.getList());
        result.put("total",byPage.getPages());
        result.put("records",byPage.getTotal());
        return result;
    }
    @RequestMapping("/download")
    @ResponseBody
    public String download(String id,String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //0.根据相对路径获取绝对路径
        System.out.println(name);
        String[] split = name.split("\\/");
        String s = split[2];
        System.out.println(s);
        String realPath = request.getSession().getServletContext().getRealPath("/audio");
        //1.根据获取的文件名读取指定目录中文件
        FileInputStream is = new FileInputStream(new File(realPath, s));
        //1.5 指定浏览器以附件形式下载  inline: 默认值 在线打开  attachment: 附件
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(s,"UTF-8"));
        //1.8动态获取文件类型
        String extension = FilenameUtils.getExtension(s);//获取文件名后缀 没有"."
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
        chapterService.updatedown(id);
        return "删除成功";
    }
    @RequestMapping("/del")
    @ResponseBody
    public void remove(String id,String path,HttpServletRequest request){
        String realPath = request.getSession().getServletContext().getRealPath(path);
        System.out.println(realPath);
        File file = new File(realPath);
        if(file.isFile()) {
            file.delete();
        }
        chapterService.remove(id);
    }
    @RequestMapping("update")
    @ResponseBody
    public void sa(String id){
        chapterService.updateplay(id);
    }
}
