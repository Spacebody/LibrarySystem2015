/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrator;

/**
 *
 * @author jerry
 */
public class Admin_Info 
{
    
        private String AdminAccount;//管理员账号
	private String AdminPassword;//登录密码
	
        public Admin_Info(String AdminAccount, String AdminPassword) 
        {
            setAdminAccount(AdminAccount);
            setAdminPassword(AdminPassword);
	}
	 
        public void setAdminAccount(String AdminAccount) 
        {
	    this.AdminAccount = AdminAccount;
	}
	
        public String getAdminAccount() 
        {
            return AdminAccount;
	}
	
        public void setAdminPassword(String AdminPassword) 
        {
	    this.AdminPassword = AdminPassword;
	}
        
        public String getAdminPassword() 
        {
            return AdminPassword;
        }
	
      
}

