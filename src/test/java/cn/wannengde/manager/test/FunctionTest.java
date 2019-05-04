package cn.wannengde.manager.test;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wannengde.manager.service.UserService;

public class FunctionTest {
	@Autowired
	UserService userService;
	
	
	public static void main(String[] args) {
		
		System.out.println(UUID.randomUUID());
		
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("M月d日");//设置日期格式
		 * System.out.println(df.format(new Date())); String dfS = df.format(new
		 * Date()); String data = "2019年3月26日"; data = data.substring(5);
		 * System.out.println(data); System.out.println(data.equals(dfS));
		 */
	}
}
