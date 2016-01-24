/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import static library.excel.*;
import static library.publicmethod.print;

/**
 *
 * @author Spike
 */
public class borrow_control {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Scanner input=new Scanner(System.in);
    public void borrow() throws IOException, BiffException{
        print("请输入借书卡号");
        String id=input.nextLine();
        print("请输入借书名称");
        String ids=input.nextLine();
        Workbook rwb;
        Cell cell,cell2,cell3;
        InputStream stream = new FileInputStream("d:\\reader.xls");
        rwb = Workbook.getWorkbook(stream);
        Sheet sheet = rwb.getSheet(0);  
        cell2 = sheet.findCell(ids);
        cell = sheet.findCell(id);
        int ow1=cell2.getColumn();
        cell3=sheet.getCell(5, ow1);
        if (cell3.getContents()=="否"){
            System.out.print("该书已被借走");
        }
        else
        {int ow=cell.getRow();
        realediter(4,ow,ids,"D:\\reader.xls");
        realediter(5,ow,sdf.format(new Date()),"D:\\reader.xls");
        InputStream steam = new FileInputStream("d:\\books.xls");
        Workbook rwb1 = Workbook.getWorkbook(steam);
        Sheet sheet1 = rwb.getSheet(0);  
        realediter(5,ow1,"否","D:\\books.xls");
    }
    }
    public void comeback() throws FileNotFoundException, IOException, BiffException{
        print("请输入借书卡号");
        String id=input.nextLine();
        print("请输入借书名称");
        String ids=input.nextLine();
        Workbook rwb;
        Cell cell,cell2;
        InputStream stream = new FileInputStream("d:\\reader.xls");
        rwb = Workbook.getWorkbook(stream);
        Sheet sheet = rwb.getSheet(0);  
        cell = sheet.findCell(id);
        int ow=cell.getRow();
        realediter(4,ow,"","D:\\reader.xls");
        realediter(5,ow,"","D:\\reader.xls");
        InputStream steam = new FileInputStream("d:\\books.xls");
        Workbook rwb1 = Workbook.getWorkbook(steam);
        Sheet sheet1 = rwb.getSheet(0);  
        cell2 = sheet.findCell(ids);
        int ow1=cell2.getColumn();
        realediter(5,ow1,"是","D:\\books.xls");
    }
    public void money() throws FileNotFoundException, IOException, BiffException, ParseException{
        print("借书者的卡号");
        String id=input.nextLine();
        Workbook rwb;
        Cell cell,cell2;
        InputStream stream = new FileInputStream("d:\\reader.xls");
        rwb = Workbook.getWorkbook(stream);
        Sheet sheet = rwb.getSheet(0);  
        cell = sheet.findCell(id);
        int ow=cell.getRow();
        cell2=sheet.getCell(5, ow);
        if (daysBetween(cell2.getContents(),sdf.format(new Date()))>=30){
            print("先还钱再借书\n");
            System.out.printf("还欠%d元",daysBetween(cell2.getContents(),sdf.format(new Date())));
        }
        else{
            print("还未欠钱");
        }
    }
    public void add() throws FileNotFoundException, IOException, BiffException{
        print("借书卡号？");
        String id=input.nextLine();
        print("具体借书名称？");
        String ids=input.nextLine();
        Workbook rwb;
        Cell cell,cell2;
        InputStream stream = new FileInputStream("d:\\reader.xls");
        rwb = Workbook.getWorkbook(stream);
        Sheet sheet = rwb.getSheet(0);  
        cell = sheet.findCell(id);
        int ow=cell.getRow();
        realediter(5,ow,sdf.format(new Date()),"D:\\reader.xls");
    }
    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
       return Integer.parseInt(String.valueOf(between_days));     
    }  
}
