package com.example.demo.test.Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ExcelToZip {
    /*
    动态生产多个Excel文件
     */
    private List<File> getFileList() {
        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Test");
            Row row = sheet.createRow(0);
            for (int j = 0; j <= 5; j++) {
                Cell cell = row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue("第" + (j + 1) + "行");
            }
            row = sheet.createRow(1);
            for (int j = 0; j <= 5; j++) {
                Cell cell = row.createCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cell.setCellValue(j + 1);
            }
            String fileName = "表" + (i + 1) + ".xls";
            File file = new File(fileName);
            try {
                FileOutputStream out = new FileOutputStream(file.getPath());
                workbook.write(out);
                out.close();
            } catch (Exception e) {
                System.out.println("出现异常");
                e.printStackTrace();
            }
            fileList.add(file);
        }
        return fileList;
    }

    /*
    多个文件打包ZIP并下载
     */
    private void downloadZip(List<File> fileList, String zipName, HttpServletResponse response) throws IOException {
        if (null == fileList || fileList.size() <= 0) {
            return;
        }
        //将多个文件压缩成一个zip包
        String zipFilePath = zipName + ".zip";
        File filePath  = new File(zipFilePath);
        if (!filePath.isDirectory()) {
            filePath.mkdirs();
        }
        File zipfile = new File(zipFilePath);
        if (!zipfile.exists()) {
            zipfile.createNewFile();
        }
        getZip(fileList, zipFilePath);
        downloadFile(zipfile, response);
    }

    /*
    压缩为ZIP
     */
    private void getZip(List<File> files, String zipFilePath) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        ZipOutputStream zipOut = null;
        List<String> entryNames = new ArrayList<>();
        try {
            out = new FileOutputStream(zipFilePath);
            // 使用GBK编码可以避免压缩中文文件名乱码　
            zipOut = new ZipOutputStream(out, Charset.forName("GBK"));
            byte[] buffer = new byte[1024];
            String entryName = "";
            int seq = 0;
            for (File f : files) {
                seq++;
                in = new FileInputStream(f);
                //如果待压缩的文件名存在相同的，则先重命名
                entryName = f.getName();
                if (entryNames.contains(entryName)) {
                    int lastIndexOf = entryName.lastIndexOf(".");
                    if (lastIndexOf != -1) {
                        String name = entryName.substring(0, lastIndexOf);
                        String suffix = entryName.substring(lastIndexOf + 1, entryName.length());
                        entryName = name + "(" + seq + ")" + "." + suffix;
                    } else {
                        entryName += "(" + seq + ")";
                    }
                }
                entryNames.add(entryName);
                ZipEntry entry = new ZipEntry(entryName);
                zipOut.putNextEntry(entry);
                int nNumber;
                while ((nNumber = in.read(buffer)) != -1) {
                    zipOut.write(buffer, 0, nNumber);
                }
                zipOut.closeEntry();
            }
        } catch (Exception e) {
            System.out.println("压缩ZIP包出现异常");
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
            zipOut.close();
        }
    }

    /*
    下载文件
     */
    private void downloadFile(File file, HttpServletResponse response) throws IOException {
        String fileName = file.getName();
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/force-download"); // 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName); // 设置文件名
            response.setHeader("Content-Length", String.valueOf(file.length()));
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                response.getOutputStream().write(b, 0, len);
            }
            response.flushBuffer();
        } catch (IOException e) {
            System.out.println("下载出现异常");
            e.printStackTrace();
        } finally {
            fis.close();
        }
    }
}
