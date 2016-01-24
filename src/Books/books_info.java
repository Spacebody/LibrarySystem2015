/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import LibrarySystem.Entrance;
import static library.publicmethod.*;
import static library.excel.*;
/**
 *
 * @author Spike
 */
public class books_info {
    Calendar date;
    File file;
    FileReader reader;
    FileWriter writer;
    ArrayList array;
    Scanner input=new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static File hasFile=new File("D:\\books.xls");
    
    public void loginnew() throws BiffException, IOException, WriteException{
        print("输入图书信息，格式为：书籍编号/书籍名称/书籍单价/入馆时间/书架编号/是否在馆\n");
        String bianhao,mingcheng,danjia,shujia;
        print("输入书籍编号\n");
        bianhao=input.nextLine();
        print("输入书籍名称\n");
        mingcheng=input.nextLine();
        print("输入书籍单价\n");
        danjia=input.nextLine();
        print("输入书架编号\n");
        shujia=input.nextLine();
        String[] str = { bianhao, mingcheng, danjia, sdf.format(new Date()),shujia,"是"};  
        addBooks(hasFile,str);
    }
    public void editer() throws IOException{
        listall();
        int a,b;
        String yes;
        print("具体内容\n");
        yes=input.nextLine();
        print("要修改的列\n");
        a=input.nextInt();
        print("要修改的行\n");
        b=input.nextInt();
            try {  
            jxl.Workbook wb =null;  //创建一个workbook对象  
            try {  
                InputStream is = new FileInputStream("D:\\books.xls"); //创建一个文件流，读入Excel文件  
                wb = Workbook.getWorkbook(is); //将文件流写入到workbook对象  
            } catch (BiffException | IOException e) {  
            }
                // TODO Auto-generated catch block
           // jxl.Workbook 对象是只读的，所以如果要修改Excel，需要创建一个可读的副本，副本指向原Excel文件（即下面的new File(excelpath)）  
            jxl.write.WritableWorkbook wbe= Workbook.createWorkbook(new File("D:\\books.xls"), wb);//创建workbook的副本  
            WritableSheet sheet  = wbe.getSheet(0); //获取第一个sheet  
            WritableCell cell =sheet.getWritableCell(0, 0);//获取第一个单元格  
            jxl.format.CellFormat cf = cell.getCellFormat();//获取第一个单元格的格式  
            jxl.write.Label lbl = new jxl.write.Label(a-1, b, yes);//将第一个单元格的值改为“修改後的值”  
            lbl.setCellFormat(cf);//将修改后的单元格的格式设定成跟原来一样  
            sheet.addCell(lbl);//将改过的单元格保存到sheet  
            wbe.write();//将修改保存到workbook --》一定要保存  
            wbe.close();//关闭workbook，释放内存 ---》一定要释放内存  
        } catch (IOException | WriteException e) {  
        }
        // TODO Auto-generated catch block
    }
    public void listall() throws IOException{
        print("下面为所有图书的列表\n");
        try {
            readBooks();
        } catch (BiffException ex) {
            Logger.getLogger(Entrance.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    // 
}
