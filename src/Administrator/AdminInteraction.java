/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import LibrarySystem.Entrance;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author jerry
 */
public class AdminInteraction 
{
        public static void AdminCheckIn(String Account,String Password) throws IOException, BiffException, WriteException, FileNotFoundException, ParseException//检测登陆
	{
		Admin_Info admin =Admin.Login(Account, Password);
		if(admin!=null)
		{
	            System.out.println("登录成功");
		    Entrance.AdminService(admin);
		}
		else
		{
                    System.out.println("登录失败,回到上一级菜单");
		    Entrance.Login();
		}
	}
	
    
	public static void init() 
        {//初始化
		Admin.initAdmin();
	}

}
