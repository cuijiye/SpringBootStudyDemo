package com.example.demo.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Package: com.example.demo.controller
 * @ClassName: HelloController
 * @Author: cuiji
 * @CreateTime: 2021/3/31 11:14
 * @Description:
 */
@Controller
public class HelloController {

    @RequestMapping("/test")
    public String hello(Model model){
        model.addAttribute("msg", "<h1>hello,SpringBoot</h1>");
        model.addAttribute("msg2", "<h2>hello,SpringBoot</h2>");
        model.addAttribute("msg3", "<h3>hello,SpringBoot</h3>");
        model.addAttribute("msg4", "<h4>hello,SpringBoot</h4>");
        model.addAttribute("msg6", "<h6>hello,SpringBoot</h6>");
        model.addAttribute("msg5", "<h5>hello,SpringBoot</h5>");
        model.addAttribute("GitHub push", "<h5>hello,SpringBoot</h5>");
        model.addAttribute("GitHub pull", "<h5>hello,SpringBoot</h5>");
        model.addAttribute("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "hello";
    }

    @RequestMapping(value = "/poizip")
    public void poizip(HttpServletResponse response) throws IOException {
        //response 输出流
        ServletOutputStream out = response.getOutputStream();
        //压缩输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(out);
        try {
            for (int i = 0; i < 6; i++) {
                //创建工作簿
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("sheet" + i);
                HSSFRow row = sheet.createRow(0);
                HSSFCell cell = row.createCell(0);
                cell.setCellValue("内容" + i);
                response.setContentType("application/octet-stream; charset=utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("测试.zip","utf-8"));
                //重点开始,创建压缩文件
                ZipEntry z = new ZipEntry(i + ".xls");
                zipOutputStream.putNextEntry(z);
                //写入一个压缩文件
                wb.write(zipOutputStream);
            }
            zipOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //注意关闭顺序，否则可能文件错误
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
