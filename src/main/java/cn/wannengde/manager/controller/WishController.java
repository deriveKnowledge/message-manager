package cn.wannengde.manager.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wannengde.manager.bean.MailUtil;
import cn.wannengde.manager.bean.Msg;
import cn.wannengde.manager.bean.User;
import cn.wannengde.manager.bean.Wish;
import cn.wannengde.manager.service.UserService;
import cn.wannengde.manager.service.WishService;

@Controller
public class WishController {
	
	@Autowired
	WishService wishService;
	@Autowired
	UserService userService;
	
	//根据标题模糊查询
	@RequestMapping("/queryWishByLikeTitle")
	@ResponseBody
	public Msg queryWishByLikeTitle(@RequestParam(value="pn" , defaultValue="1") Integer pn
	,@RequestParam(value="userId") Integer userId,@RequestParam(value="wishTitle") String wishTitle) {
		
		PageHelper.startPage(pn, 5);
		List<Wish> wishs = wishService.queryWishByLikeTitle(wishTitle, userId);
		PageInfo page = new PageInfo(wishs,5);
		return Msg.success("查询成功！").add("page", page);
	}
	
	//定时任务，愿望到期邮件提醒，以及过期置愿望为过期
	@Scheduled(cron= "0 0 0 * * ?")
	public void wishScheduled() throws Exception {
		List<User> users = userService.queryAllUser();
		
		//为到期愿望做提醒
		for(User user : users) {
		//	SimpleDateFormat format = new SimpleDateFormat("YY-MM-DD");
			Date date = new Date();
			List<Wish> wishs = wishService.judgeTime(new java.sql.Date(date.getTime()),user.getUserId());
			int sum = 0;
			StringBuffer title = new StringBuffer();
			for(Wish wish : wishs) {
				if(wish.getWishStatus().equals(1)) {
					sum++;
					title.append(wish.getWishTitle() + " \n");
				}
			}
			if(sum != 0) {
				MailUtil mailUtil = new MailUtil();
				mailUtil.sendMail(user.getUserName(), "你有"+sum+"个愿望今日到期!  \n"+title.substring(0));
			}
		}
		
		//为过期愿望做过期
		for(User user : users) {
				Date date = new Date();
				List<Wish> wishs = wishService.queryWishAll(user.getUserId());
				int sum = 0;
				StringBuffer title = new StringBuffer();
				for(Wish wish : wishs) { System.out.println(wish.getWishOverTime() + "  " + date);
					if(wish.getWishStatus().equals(1) && wish.getWishOverTime().getTime() < date.getTime()) {
						sum++;
						title.append(wish.getWishTitle() + " \n");
						wish.setWishStatus(3);
						wishService.updateWish(wish);
					}
				}
				if(sum != 0) {
					MailUtil mailUtil = new MailUtil();
					mailUtil.sendMail(user.getUserName(), "你有"+sum+"个愿望失败!  \n"+title.substring(0));
				}
			}
		
	}
	
	//根据愿望ID删除愿望
	@ResponseBody
	@RequestMapping("/deleteWish")
	public Msg deleteWish(@RequestParam(value="wishId") Integer wishId) {
		wishService.deleteWish(wishId);
		return Msg.success("删除成功！");
	}
	
	//查询对应用户ID所有愿望
	@RequestMapping("/queryWishAll")
	@ResponseBody
	public Msg queryWishAll(@RequestParam(value="pn",defaultValue="1") Integer pn
			,@RequestParam(value="userId") Integer userId) {
		PageHelper.startPage(pn, 5);
		List<Wish> wishs = wishService.queryWishAll(userId);
		PageInfo page = new PageInfo(wishs,5);
		return Msg.success("查询成功！").add("page", page);
	}
	
	//修改愿望
	@RequestMapping("/updateWish")
	@ResponseBody
	public Msg updateWish(Wish wish) {
		System.out.println("==>>>>>>>>" + wish.getWishStatus() + " "+ wish.getWishId());
		wishService.updateWish(wish);
		return Msg.success("修改成功！");
	}
	
	//添加愿望
	@ResponseBody
	@RequestMapping("/addWish")
	public Msg addWish(Wish wish) {
		/*
		 * if(wish.getWishOverTime().getTime() < (new Date()).getTime()) {
		 * wish.setWishStatus(3); }
		 */
		wishService.addWish(wish);
		return Msg.success("添加成功!");
	}
}
