/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

import LibrarySystem.UI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author jerry
 */
public class Admin 
{
	static Admin_Info[] Admin=new Admin_Info[1];
        private static int n=0;
        static int i=0;
        public static void initAdmin()
	{
            if(i==0)
            {
	       Admin_Info admin=new Admin_Info("admin", "123456");
	       Admin[0]=admin;
               n=1;
               i++;
            }
        }
	
        public static Admin_Info Login(String Account, String Password) throws IOException, BiffException, FileNotFoundException, ParseException, WriteException
	{
		Admin_Info tempAdmin = null;
                for(int m = 0; m<n ;m++)
                {
	           if(Admin[m].getAdminAccount().equals(Account))
	           {
         	       tempAdmin=Admin[m];
		   }
                }
		if(tempAdmin==null)
		{
                    UI.error("登录失败,用户名不存在");
		}
		else
                {
		    if(!tempAdmin.getAdminPassword().equals(Password))
		    {
		        UI.error("登录失败,密码错误");
		    }
		}
		return tempAdmin;
        }       
}    

