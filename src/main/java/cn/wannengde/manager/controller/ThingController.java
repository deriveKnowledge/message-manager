package cn.wannengde.manager.controller;

import java.text.SimpleDateFormat;
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
import cn.wannengde.manager.bean.Thing;
import cn.wannengde.manager.bean.User;
import cn.wannengde.manager.service.ThingService;
import cn.wannengde.manager.service.UserService;
import cn.wannengde.manager.tool.MainTool;
import cn.wannengde.manager.tool.TimeTool;

@Controller
public class ThingController {
	@Autowired
	private ThingService thingService;
	@Autowired
	private UserService userService;
	
	//植入定时任务，每天发邮件
	@Scheduled(cron= "0 0 1 * * ?")
	public void alertThing() {
		SimpleDateFormat sf = new SimpleDateFormat("M月d日");//设置日期格式
        String timeS = sf.format(new Date()); //根据格式获取今天阳历日期
        String timeL = TimeTool.getLunarTime();//根据格式获取今天农历日期
		List<User> users =  userService.queryAllUser();
		for(int i = 0 ; i < users.size(); i++) {
			List<Thing> things = thingService.queryByUserId(users.get(i).getUserId());
			String text = "";
			for(Thing thing : things) {
				if(thing.getThingTime().length() < 6) continue;//防止数据库中有不规则日期，导致程序中断，下面的发不出去
				String temp = thing.getThingTime();
				temp = temp.substring(5); //截取日期的月日
				if(thing.getTimeType() == 1) {
					if(temp.equals(timeS) && thing.getAbility() != 0) {
						text += "["+thing.getThingTitle() + " : " + thing.getThingText() + "]/t";
						if(thing.getCirculate() == 0){ //如果不是每年循环的置为废弃
							thing.setAbility(0);
							thingService.updateByThing(thing);
						}
					}
				}else {
					if(temp.equals(timeL) && thing.getAbility() != 0) {
						text += "["+thing.getThingTitle() + " : " + thing.getThingText() + "]";
						if (thing.getCirculate() == 0){
							thing.setAbility(0);
							thingService.updateByThing(thing);
						}
					}
				}
			}
			if(text != null && !text.equals("")) {
				try {
					MailUtil mailUtil = new MailUtil();
					mailUtil.sendMail(users.get(i).getUserName(),text+"------->来自你的儿子黄中原的提醒");
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
	}

	//根据用户ID查询失效事件
	@ResponseBody
	@RequestMapping("/thingQueryDisable")
	public Msg thingQueryDisable(@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,@RequestParam(value="userId",defaultValue="0")Integer userId) {
		Msg msg = new Msg();
		PageHelper.startPage(pn, 5);
		List<Thing> things = thingService.queryThingByUserIdDisable(userId);
		PageInfo page = new PageInfo(things, 5);
		return msg.ok("查询成功").add("page",page);
	}

	//根据用户ID查询有效事件
	@ResponseBody
	@RequestMapping("/thingQueryAble")
	public Msg thingQueryAble(@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,@RequestParam(value="userId",defaultValue="0")Integer userId) {
		Msg msg = new Msg();
		PageHelper.startPage(pn, 5);
		List<Thing> things = thingService.queryThingByUserIdAble(userId);
		PageInfo page = new PageInfo(things, 5);
		return msg.ok("查询成功").add("page",page);
	}

	//插入事件
	@ResponseBody
	@RequestMapping("/thingAdd")
	public Msg thingAdd(Thing thing) {
		Msg msg = new Msg();
		if(!MainTool.judgeTime(thing.getThingTime())) {
			return msg.no("请输入正确时间");
		}
		System.out.println(thing);
		thingService.insert(thing);
		msg.ok("上传事件成功");
		return msg;
	}
	
	//删除事件
	@ResponseBody
	@RequestMapping("/thingDelete")
	public Msg thingDelete(@RequestParam(value="thingId",defaultValue="0")Integer thingId) {
		Msg msg = new Msg();
		if(thingService.queryById(thingId) == null) {
			msg.no("不存在此事件");
		}
		thingService.deletById(thingId);
		return msg.ok("成功删除");
	}
	
	//修改事件,未进行验证
	@ResponseBody
	@RequestMapping("/thingUpdate")
	public Msg thingUpdate(Thing thing) {
		if(thing.getCirculate() == 1) thing.setAbility(1);
		Msg msg = new Msg();System.out.println(thing);
		thingService.updateByThing(thing);
		return msg.ok("更新完成");
	}
	
	//根据用户ID查询所有事件,未验证
	@ResponseBody
	@RequestMapping("/thingQueryAll")
	public Msg thingQueryALL(@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,@RequestParam(value="userId",defaultValue="0")Integer userId) {
		Msg msg = new Msg();
		PageHelper.startPage(pn, 5);
		List<Thing> things = thingService.queryByUserId(userId);
		PageInfo page = new PageInfo(things, 5);
		return msg.ok("查询成功").add("page",page);
	}
	
	//根据用户id和时间点查询事件,未验证
	@ResponseBody
	@RequestMapping("/thingQueryByTime")
	public Msg thingQueryTime(@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,@RequestParam(value="thingTime",defaultValue="")String thingTime
			,@RequestParam(value="userId",defaultValue="0") Integer userId) {
		Msg msg = new Msg();
		PageHelper.startPage(pn, 5);
		List<Thing> things = thingService.queryByTime(thingTime, userId);
		PageInfo page = new PageInfo(things, 5);
		return msg.ok("查询成功").add("page",page);
	}
	
	//根据用户id和事件标题查询事件,未验证
	@ResponseBody
	@RequestMapping("/thingQueryByTitle")
	public Msg thingQueryBytitle(@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,@RequestParam(value="thingTitle",defaultValue="")String thingTitle
			,@RequestParam(value="userId",defaultValue="0") Integer userId) {
		Msg msg = new Msg();
		PageHelper.startPage(pn, 5);
		List<Thing> things = thingService.queryByTitle(thingTitle, userId);
		PageInfo page = new PageInfo(things, 5);
		return msg.ok("查询成功").add("page",page);
	}
}
