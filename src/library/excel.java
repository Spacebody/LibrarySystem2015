package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class excel {
    public static void readBooks() throws BiffException, IOException{
   //创建一个list 用来存储读取的内容
    List list = new ArrayList();
    Workbook rwb = null;
    Cell cell = null;
    
    //创建输入流
    InputStream stream = new FileInputStream("d:\\books.xls");
    
    //获取Excel文件对象
    rwb = Workbook.getWorkbook(stream);
    
    //获取文件的指定工作表 默认的第一个
    Sheet sheet = rwb.getSheet(0);  
   
    //行数(表头的目录不需要，从1开始)
    for(int i=0; i<sheet.getRows(); i++){
     
     //创建一个数组 用来存储每一列的值
     String[] str = new String[sheet.getColumns()];
     
     //列数
     for(int j=0; j<sheet.getColumns(); j++){
     
      //获取第i行，第j列的值
      cell = sheet.getCell(j,i);    
      str[j] = cell.getContents();
     }
     //把刚获取的列存入list
     list.add(str);
    }
    for(int i=0;i<list.size();i++){
     String[] str = (String[])list.get(i);
        for (String str1 : str) {
            System.out.print(str1+"\t"+"\t");
        }
        System.out.println();
    }
  }
    public static void readReaders() throws BiffException, IOException{
   //创建一个list 用来存储读取的内容
    List list = new ArrayList();
    Workbook rwb = null;
    Cell cell = null;
    
    //创建输入流
    InputStream stream = new FileInputStream("d:\\reader.xls");
    
    //获取Excel文件对象
    rwb = Workbook.getWorkbook(stream);
    
    //获取文件的指定工作表 默认的第一个
    Sheet sheet = rwb.getSheet(0);  
   
    //行数(表头的目录不需要，从1开始)
    for(int i=0; i<sheet.getRows(); i++){
     
     //创建一个数组 用来存储每一列的值
     String[] str = new String[sheet.getColumns()];
     
     //列数
     for(int j=0; j<sheet.getColumns(); j++){
     
      //获取第i行，第j列的值
      cell = sheet.getCell(j,i);    
      str[j] = cell.getContents();
     }
     //把刚获取的列存入list
     list.add(str);
    }
    for(int i=0;i<list.size();i++){
     String[] str = (String[])list.get(i);
        for (String str1 : str) {
            System.out.print(str1+"\t"+"\t");
        }
        System.out.println();
    }
  }
    public static void addBooks(File file, String[] args) throws BiffException,  IOException, RowsExceededException, WriteException {  
        InputStream stream = new FileInputStream(file);
        Workbook book = Workbook.getWorkbook(stream);  
        Sheet sheet = book.getSheet(0);  
        // 获取行  
        int length = sheet.getRows();  
        WritableWorkbook wbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象  
        WritableSheet sh = wbook.getSheet(0);// 得到一个工作对象  
        // 从最后一行开始加  
        for (int i = 0; i < args.length; i++) {  
            Label label = new Label(i, length, args[i]);  
            sh.addCell(label);  
        }
        wbook.write();  
        wbook.close();  
    }  
    public static void addReaders(File file, String[] args) throws BiffException,  IOException, RowsExceededException, WriteException {  
        InputStream stream = new FileInputStream("d:\\reader.xls");
        Workbook book = Workbook.getWorkbook(stream);  
        Sheet sheet = book.getSheet(0);  
        // 获取行  
        int length = sheet.getRows();  
        System.out.println(length);  
        WritableWorkbook wbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象  
        WritableSheet sh = wbook.getSheet(0);// 得到一个工作对象  
        // 从最后一行开始加  
        for (int i = 0; i < args.length; i++) {  
            Label label = new Label(i, length, args[i]);  
            sh.addCell(label);  
        }
        wbook.write();  
        wbook.close();  
    } 
    public static void realediter(int a,int b,String c,String where) throws IOException{
            try {  
            jxl.Workbook wb =null;  //创建一个workbook对象  
            try {  
                InputStream is = new FileInputStream(where); //创建一个文件流，读入Excel文件  
                wb = Workbook.getWorkbook(is); //将文件流写入到workbook对象  
            } catch (BiffException | IOException e) {  
            }
                // TODO Auto-generated catch block
           // jxl.Workbook 对象是只读的，所以如果要修改Excel，需要创建一个可读的副本，副本指向原Excel文件（即下面的new File(excelpath)）  
            jxl.write.WritableWorkbook wbe= Workbook.createWorkbook(new File(where), wb);//创建workbook的副本  
            WritableSheet sheet  = wbe.getSheet(0); //获取第一个sheet  
            WritableCell cell =sheet.getWritableCell(0, 0);//获取第一个单元格  
            jxl.format.CellFormat cf = cell.getCellFormat();//获取第一个单元格的格式  
            jxl.write.Label lbl = new jxl.write.Label(a, b, c);//将第一个单元格的值改为“修改後的值”  
            lbl.setCellFormat(cf);//将修改后的单元格的格式设定成跟原来一样  
            sheet.addCell(lbl);//将改过的单元格保存到sheet  
            wbe.write();//将修改保存到workbook --》一定要保存  
            wbe.close();//关闭workbook，释放内存 ---》一定要释放内存  
        } catch (IOException | WriteException e) {  
        }
        // TODO Auto-generated catch block
    }
}