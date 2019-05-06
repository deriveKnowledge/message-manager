package cn.wannengde.manager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wannengde.manager.bean.Journal;
import cn.wannengde.manager.bean.Msg;
import cn.wannengde.manager.service.JournalService;

@Controller
public class JournalController {
	
	@Autowired
	JournalService journalService;
	
	
	//根据用户Id和日记时间查询日记
	@RequestMapping("/queryJournalByTime")
	public @ResponseBody Msg queryJournalByTime(@RequestParam Integer userId,@RequestParam Integer pn,@RequestParam String journalTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(journalTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return Msg.fail("查询失败");
		}
		PageHelper.startPage(pn,5);System.out.println(date);
		List<Journal> journals =  journalService.queryJournalByTime(userId, new java.sql.Date(date.getTime()));
		PageInfo page =  new PageInfo(journals, 5);
		return Msg.success("查询成功!").add("page", page);
	}
	
	//根据用户ID查询日记
	@RequestMapping("/queryJournalAll")
	public @ResponseBody Msg queryJournalAll(Integer userId,Integer pn) {
		PageHelper.startPage(pn,5);
		List<Journal> journals =  journalService.queryJournalAll(userId);
		PageInfo page =  new PageInfo(journals, 5);
		return Msg.success("删除成功!").add("page", page);
	}
	
	//根据用户ID和日记ID删除日记
	@RequestMapping("/deleteJournal")
	public @ResponseBody Msg deleteJournal(Integer userId,Integer journalId) {
		journalService.deleteJournal(journalId);
		return Msg.success("删除成功!");
	}
	
	//添加日记
	@RequestMapping("/addJournal")
	public @ResponseBody Msg addJournal(Journal journal) {
		journalService.AddJournal(journal);
		return Msg.success("添加成功!");
	}
}
