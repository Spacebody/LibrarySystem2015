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
import Books.books_info;
import Books.borrow_control;
import Books.reader_info;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import static library.publicmethod.*;
import Administrator.AdminInteraction;
import Administrator.Admin_Info;
import static LibrarySystem.UI.*;
import java.util.Scanner;

/**
 *
 * @author jerry
 */
public class Entrance 
{
	static Scanner input =new Scanner(System.in);
	public static void main(String[] args) throws IOException, BiffException, WriteException, FileNotFoundException, ParseException//初始界面
	{
            Welcome();
            AdminInteraction.init();
            Start();
            
	}
        
        public static void Start() throws IOException, BiffException, FileNotFoundException, ParseException, WriteException
        {
	    System.out.println("请输入功能编号:1.进入系统  2.退出系统");
            int n = input.nextInt();
	    if(n==1)
            { 
                Login();  
            }
	    else if(n==2)
            {
                System.out.println("成功退出");
            }
	    else{
	    	System.out.println("输入错误，请重新选择");
	    	Start();
	    }
        
        }
        public static void Login() throws IOException, BiffException, FileNotFoundException, ParseException, WriteException
        {
            Line("系统界面");
            System.out.println("请输入功能编号:1.管理员登录  2.图书信息界面  3.借还书信息界面  其他.重新输入");
            int n = input.nextInt();
	    if(n==1)
            { 
                Line("管理员登录界面");
                AdminLogin();  
            }
	    
	    else  if(n==2)
            {
                Line("图书信息界面");
                AdminLogin();
            }
	    else   if(n==3)
            {
                Line("借还书信息界面");
                AdminLogin();
            }
	    else{
	    	System.out.println("输入错误，请重新选择");
	    	Login();
	    }
           
	}
        
            public static void AdminLogin() throws IOException, BiffException, WriteException, FileNotFoundException, ParseException//管理员登录界面
	    {
		System.out.println("请按键选择:1.继续登录 2.返回");
		int n= input.nextInt();
                if(n==2)
		{
		    Login();
		}   
                else if(n==1)
                {
	            System.out.println("请输入管理员账号");
		    String Account=input.next();
		    System.out.println("请输入密码");
	            String Password=input.next();
                    AdminInteraction.AdminCheckIn(Account, Password);
                }
                else
                {
                	System.out.println("输入错误，请重新选择");
                	AdminLogin();
                }
            }
            public static void AdminService(Admin_Info admin) throws IOException, BiffException, WriteException, FileNotFoundException, ParseException//管理员界面
	    {
		Line("管理员功能界面");
		System.out.println("您好,"+admin.getAdminAccount());
		System.out.println("请输入功能选项:1.读者信息管理  2.图书信息管理  3.借还书管理  其他.登出");
		int n = input.nextInt();
                switch(n)
		{
		case 1:
                    reader_info reader=new reader_info();
                    System.out.println("请输入功能选项:1.录入新读者  2.所有读者信息");
                    int a=input.nextInt();
                    switch(a)
                    {
                        case 1:
                            reader.loginnew();
                            break;
                        case 2:
                            reader.listall();
                            break;           
                    }
                    break;
		case 2:
                    books_info book=new books_info();
                    System.out.println("请输入功能选项:1.新书入馆  2.编辑图书信息  3.所有图书信息");
                    int b=input.nextInt();
                    switch(b)
                    {
                        case 1:
                            book.loginnew();
                            break;
                        case 2:
                            book.editer();
                            break;        
                        case 3:
                            book.listall();
                    }
                    break;
		case 3:
                    borrow_control borrow=new borrow_control();
                    System.out.println("请输入是功能选项:1.借书管理  2.还书管理  3.续借  4.欠款管理");
                    int c=input.nextInt();
                    switch(c)
                    {
                        case 1:
                            borrow.borrow();
                            break;
                        case 2:
                            borrow.comeback();
                            break;
                        case 3:
                            borrow.add();
                            break;
                        case 4:
                            borrow.money();
                            break;
                    }
                    break;
                default:
                    Login();
                    break;
		}
	    }
        
        
        

}