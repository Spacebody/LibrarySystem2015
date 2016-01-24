/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;
import java.util.Calendar;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import static library.publicmethod.*;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import static library.excel.addBooks;
import static library.excel.readReaders;
/**
 *
 * @author Spike
 */
public class reader_info {
    Calendar date;
    File file;
    FileReader reader;
    FileWriter writer;
    ArrayList array;
    Scanner input=new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static File hasFile=new File("D:\\reader.xls");
    
        public void loginnew() throws BiffException, IOException, WriteException{
        print("输入读者信息，格式为：借书卡号/读者姓名/性别/学号\n");
        String bianhao,mingcheng,danjia,shujia;
        print("输入借书卡号\n");
        bianhao=input.nextLine();
        print("输入读者姓名\n");
        mingcheng=input.nextLine();
        print("输入性别\n");
        danjia=input.nextLine();
        print("输入学号\n");
        shujia=input.nextLine();
        String[] str = { bianhao, mingcheng, danjia,shujia,"",""};  
        addBooks(hasFile,str);
    }

    public void listall() throws IOException, BiffException{
        readReaders();
    }
}
