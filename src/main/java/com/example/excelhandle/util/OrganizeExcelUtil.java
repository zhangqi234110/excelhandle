package com.example.excelhandle.util;

import com.example.excelhandle.pojo.Organizemess;
import com.example.excelhandle.pojo.ReadExcel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class OrganizeExcelUtil {
    /**
     * 先创建一个实体类
     */
    ReadExcel readExcel = new ReadExcel();
    /**
     * 读取Excel文件，获取信息集合
     * @param mFile
     * @return
     */
    public List<Organizemess> getExcelInfo(MultipartFile mFile) {
        //获取文件名
        String fileName = mFile.getOriginalFilename();
        List<Organizemess> ilist = null;
        try {
            //验证文件名是否合格
            if(!validateExcel(fileName)){
                //不合格的话直接return
                return null;
            }
            //根据文件名判断是2003版本的还是2007版本的
            boolean isExcel2003 = true;
            if(isExcel2007(fileName)){
                isExcel2003 = false;
            }
            ilist= createExcel(mFile.getInputStream(),isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ilist;
    }
    /**
     * 判断是不是2003版本的excel
     * @param filePath
     * @return
     */
    public static boolean isExcel2003(String filePath){
        return filePath.matches("^.+\\.(?i)(xls)$");
    }
    /**
     * 判断是不是2007版本的excel
     * @param filePath
     * @return
     */
    public static boolean isExcel2007(String filePath){
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
    /**
     * 判断是不是excel文件格式
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath){
        if(filePath ==null||!(isExcel2003(filePath) || isExcel2007(filePath))){
            readExcel.setErrorMsg("文件名不是excel格式");
            return false;
        }
        return true;
    }
    /**
     * 读取excel里面的信息
     */
    public List<Organizemess> readExcelValue(Workbook wb){
        List<Organizemess> ilist=new ArrayList<>();
        //先得到一个sheet
        Sheet sheet = wb.getSheetAt(0);
        //得到excel里面的行数
        int totalRows = sheet.getPhysicalNumberOfRows();
        readExcel.setTotalRows(totalRows);
        //得到excel里面的列，前提是有行
        //大于1是因为我从第二行就是数据了，这个大家看情况而定
        if(totalRows >1 && sheet.getRow(0)!=null){
            int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            readExcel.setTotalCells(totalCells);
        }
        for (int r = 1 ; r < totalRows; r++){
            Row row = sheet.getRow(r);
            if(row == null){
                continue;//如果行为空的话直接中断
            }
            Organizemess organizemess = new Organizemess();
            //循环xcel的列
            for(int c = 0; c<readExcel.getTotalCells() ; c++){
                Cell cell = row.getCell(c);
                if(cell != null){
                    //根据excel需要导入的列数来写
                    if(c == 0){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            //如果是纯数字,比如你写的是38,
                            //cell.getNumericCellValue()获得是38.0,
                            //通过截取字符串去掉.0获得25
                            String name = String.valueOf(cell.getNumericCellValue());
                            //截取如果length()-2为零了，就说明只有一位数，就直接截取0到1就行
                            organizemess.setName(name.substring(0,name.length()-2>0?name.length()-2:1));
                        }else{
                            //如果不是纯数字可以直接获得名称
                            organizemess.setName(cell.getStringCellValue());
                        }
                    }else if (c == 1){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String firstDept = String.valueOf(cell.getNumericCellValue());
                            organizemess.setFirstDept(firstDept.substring(0,firstDept.length()-2>0?firstDept.length()-2:1));
                        }else{
                            organizemess.setFirstDept(cell.getStringCellValue());
                        }
                    }else if( c == 2){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String secondDept = String.valueOf(cell.getNumericCellValue());
                            organizemess.setSecondDept(secondDept.substring(0, secondDept.length()-2>0?secondDept.length()-2:1));
                        }else{
                            organizemess.setSecondDept(cell.getStringCellValue());
                        }
                    }else if( c == 3){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String postion = String.valueOf(cell.getNumericCellValue());
                            organizemess.setPostion(postion.substring(0, postion.length()-2>0?postion.length()-2:1));
                        }else{
                            organizemess.setPostion(cell.getStringCellValue());
                        }
                    }else if( c == 4){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String postionDescribtion = String.valueOf(cell.getNumericCellValue());
                            organizemess.setPostionDescribtion(postionDescribtion.substring(0, postionDescribtion.length()-2>0?postionDescribtion.length()-2:1));
                        }else{
                            organizemess.setPostionDescribtion(cell.getStringCellValue());
                        }
                    }else if( c == 5){
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String phone = String.valueOf(cell.getNumericCellValue());
                            organizemess.setPhone(phone.substring(0, phone.length()-2>0?phone.length()-2:1));
                        }else{
                            organizemess.setPhone(cell.getStringCellValue());
                        }
                    }
                }
            }
            //最后将这些全部添加到ilist中
            ilist.add(organizemess);
        }
        return ilist;
    }
    public List<Organizemess> createExcel(InputStream is , boolean isExcel2003){
        List<Organizemess> ilist = null;
        try {
            Workbook wb = null;
            if(isExcel2003){
                //如果是2003版本的就new一个2003的wb出来
                wb = new HSSFWorkbook(is);
            }else{
                //否则就new 一个2007版的出来
                wb = new XSSFWorkbook(is);

            }
            //再让wb去解析readExcelValue(Workbook wb)方法
            ilist = readExcelValue(wb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ilist;
    }

}
