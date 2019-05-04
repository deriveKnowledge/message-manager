package cn.wannengde.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wannengde.manager.bean.Mind;
import cn.wannengde.manager.bean.Msg;
import cn.wannengde.manager.service.MindService;

@Controller
public class MindController {
	
	@Autowired
	private MindService mindService;
	
	//删除心情记录
	@RequestMapping("/deleteMind")
	@ResponseBody
	public Msg deleteMind(@RequestParam(value="mindId")Integer mindId) {
		mindService.deleteMindById(mindId);
		return Msg.success("删除成功！");
	}
	
	//根据用户ID进行内容模糊查询
	@RequestMapping("/queryMindByLike")
	@ResponseBody
	public Msg queryMindByLike(@RequestParam(value="userId")Integer userId,@RequestParam(value="mindText")String mindText) {
		List<Mind> minds = mindService.queryLikeText(mindText,userId);
		return Msg.success("查询成功").add("minds",minds);
	}
	
	//根据用户Id查询所有
	@RequestMapping("/queryMindAll")
	@ResponseBody
	public Msg queryMindAll(@RequestParam(value="userId")Integer userId
			,@RequestParam(value="pn",defaultValue="1") Integer pn) {
		PageHelper.startPage(pn, 7);
		List<Mind> minds = mindService.queryMindAll(userId);
		PageInfo page = new PageInfo(minds, 7);
		return Msg.success("查询成功").add("page", page);
	}
	
	//添加心情记录
	@RequestMapping("/addMind")
	@ResponseBody
	public Msg addMind(Mind mind) {
		Msg msg = new Msg();
		mindService.addMind(mind);
		return msg.ok("添加成功！");
	}
}
