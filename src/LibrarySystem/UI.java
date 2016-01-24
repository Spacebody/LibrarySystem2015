/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySystem;

/**
 *
 * @author jerry
 */
import static LibrarySystem.Entrance.Login;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
public class UI 
{
        static Scanner input = new Scanner(System.in);
        public static void Welcome()
	{
	    System.out.println("欢迎使用南方科技大学图书管理系统");	
	}
        
        public static void Line(String s)
        {
            System.out.println("*****************************"+s+"*****************************");
        }
        
        public static void error(String s) throws IOException, BiffException, FileNotFoundException, ParseException, WriteException//报错界面
	{
		Line("错误界面");
                System.out.println(s);
		System.out.println("请按键选择下一步操作:1.返回上个界面 2.返回初始界面");
                int n = input.nextInt();
		if(n==1)
                {                   
                    Login();
                }
                if(n==2)
		{
		    Entrance.Start();
		}
	}
}
