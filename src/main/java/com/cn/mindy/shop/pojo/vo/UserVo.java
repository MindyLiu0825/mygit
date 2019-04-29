package com.cn.mindy.shop.pojo.vo;

import com.cn.mindy.shop.pojo.User;
import com.cn.mindy.shop.validation.ValidationRegistGroup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Repository("userVo")
@Scope("prototype")
public class UserVo implements Serializable{

	private static final long serialVersionUID = 5544282910861954161L;

	@Resource(name="user")
	private User user;

	@Size(min=5,max=12,message="{user.username.length.error}",groups={ValidationRegistGroup.class})
	private String username;  //用户名

	private  String repassword; //重新输入密码
		
	
	    
		
		public UserVo() {
		
		}
	

		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public String getRepassword() {
			return repassword;
		}


		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}



		

		public String getUsername() {
			return username;
		}




		public void setUsername(String username) {
			this.username = username;
		}




		@Override
		public String toString() {
			return "UserVo [user=" + user + ", repassword=" + repassword + "]";
		}


	

}
