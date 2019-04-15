package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.peopledao;
import entity.people;

@RestController
public class peoplecontroller {

	@Autowired
	private peopledao p;
	
	
	//返回所有的用户
	@RequestMapping("findall")
	public String findall(){
		List<people> l = p.findall();
		return l.toString();
	}
	
	
	//http://127.0.0.1:1111/login?name=乔峰&password=123
	//根据用户名去获取密码，看链接中输入的用户和密码是否匹配获取到的密码
	@RequestMapping("login")
	public String login(String name,String password) {
		people peo = p.findpassword(name);
		String result = null;
		try{
			if(password.equalsIgnoreCase(peo.getPassword())) {
				result =  "恭喜您登陆成功 ~-~   "+peo;
			}
		}catch(Exception e) {
			result= "抱歉，登陆失败，请确认您的信息哈：    "+name+";"+password;
		}
		
		return result;
	}
	
}
