package cn.wannengde.manager.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wannengde.manager.bean.MailUtil;
import cn.wannengde.manager.bean.Msg;
import cn.wannengde.manager.bean.User;
import cn.wannengde.manager.service.UserService;
import cn.wannengde.manager.tool.MainTool;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//管理员编辑用户
	@RequestMapping("/updateByManager")
	@ResponseBody
	public Msg updateByManager(User user) {
		Msg msg = new Msg();
		userService.updateUser(user);
		return msg.ok("更新完成！");
	}
	
	//删除用户
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Msg deleteUser(@RequestParam(value="userId")Integer userId) {
		userService.deleteUser(userId);
		return Msg.success("删除成功");
	}
	
	//根据用户名查询用户
	@RequestMapping("/queryUserByUsername")
	@ResponseBody
	public Msg queryUserByUserName(@RequestParam(value="pn",defaultValue="1")Integer pn,
			@RequestParam(value="username")String username) {
		PageHelper.startPage(pn, 7);
		List<User> users = userService.login(username);
		PageInfo page = new PageInfo(users, 7);
		return Msg.success("查询成功").add("page", page);
	}
	
	//查询所有用户
	@ResponseBody
	@RequestMapping("/queryUserAll")
	public Msg queryUserAll(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		PageHelper.startPage(pn, 7);
		List<User> users = userService.queryAllUser();
		PageInfo page = new PageInfo(users, 7);
		return Msg.success("查询成功").add("page", page);
	}
	
	//用户修改用户功能
	@RequestMapping("/updateUser")
	@ResponseBody
	public Msg updateUser(User user,HttpServletResponse response) {
		Msg msg = new Msg();
		userService.updateUser(user);
		User temp = userService.queryUserById(user.getUserId());
		Cookie cookie = new Cookie("user_update",temp.toCookie());System.out.println(temp.toCookie());
		response.addCookie(cookie);
		msg.ok("更新完成！");
		return msg;
	}
	
	//退出功能
	@RequestMapping("/exitLogin")
	public String exitLogin(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	//注册功能
	@RequestMapping("/regist")
	@ResponseBody
	public Msg regist(@RequestParam(value="username",defaultValue="") String username,
			@RequestParam(value="password",defaultValue="") String password,
			@RequestParam(value="idCode",defaultValue="")String idcode, HttpServletRequest request) {
		System.out.println(idcode + "===========" + request.getSession().getAttribute("idcode"));
		if (username != null) {
			if (!request.getSession().getAttribute("idcode").equals(idcode)) {
				return Msg.fail("验证码错误");
			}
			if (MainTool.judgeEmail(username) && !userService.checkUser(username)) {
				return Msg.fail("用户名已存在");
			}
			userService.addUser(new User(username,password));
			return Msg.success("注册成功");
		} else {
			return Msg.fail("用户名不能为空");
		}
	}
	
	//输入时查找用户是否已存在
	@RequestMapping("/checkUser")
	@ResponseBody
	public Msg checkUser(@RequestParam(value="username",defaultValue="")String username) {
		if(!MainTool.judgeEmail(username)) {
			return Msg.fail("请输入正确邮箱");
		}
		
		if(userService.checkUser(username)) {
			return Msg.success("用户名可以使用");
		}else {
			return Msg.fail("用户名已存在");
		}
	}
	
	//发送邮件验证码
	@RequestMapping("/sendMailCode")
	public void sendMailCode(@RequestParam(value="mail",defaultValue="")String mail,
			HttpServletResponse response,HttpServletRequest request) throws Exception {
		response.setCharacterEncoding("utf-8");
		int idcode = (int) (Math.random()*100000);
		String text = Integer.toString(idcode);
		request.getSession().setAttribute("idcode", text);
		MailUtil mailUtil = new MailUtil();
		mailUtil.sendMail(mail, text);
	}
	
	//登陆请求
	@RequestMapping("/login")
	public String login(@RequestParam(value="username",defaultValue="") String username,
			@RequestParam(value="password",defaultValue="")String password,Model model
			,HttpServletResponse response,HttpServletRequest request) throws  Exception{
		Msg msg = new Msg(); //前后端用来传输消息
		//后台校验是否是邮箱格式
		System.out.println("我进来试试");
		if(!MainTool.judgeEmail(username)) {
			msg.setCode(200);
			msg.setMsg("邮箱错误！");
			model.addAttribute("msg", msg);
			return "login";
		}
		//查询数据库是否有此用户
		List<User> users = userService.login(username);
		if(users.size() == 0) {
			msg.setCode(200);
			msg.setMsg("无此用户");
			model.addAttribute("msg", msg);
			return "login";
		}
		User user = users.get(0);
		if(user.getUserPassword().equals(password)) {//密码是否正确
			msg.setCode(100);
			msg.setMsg("密码正确");
			model.addAttribute("msg", msg);
			Cookie cookie = new Cookie("user",user.toCookie());//设置一个cookie用于传递信息
			response.addCookie(cookie);
			if(user.getUserPower().equals(1)) { //根据权限跳转页面
				return "redirect:/go?type=userView";
			}else {
				return "redirect:/go?type=managerView";
			}
		}else {
			msg.setCode(200);
			msg.setMsg("密码错误");
			model.addAttribute("msg", msg);
			return "login";
		}
	}

	//解决回退重复提交时登陆问题
	@RequestMapping("/go")
	public String go(@RequestParam String type) {
		return type;
	}
}
