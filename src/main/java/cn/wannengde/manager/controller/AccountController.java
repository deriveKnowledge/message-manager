package cn.wannengde.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wannengde.manager.bean.Account;
import cn.wannengde.manager.bean.Msg;
import cn.wannengde.manager.bean.Thing;
import cn.wannengde.manager.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	AccountService accountService;

	//查询用户所有账户
	@RequestMapping("/queryAccountAll")
	@ResponseBody
	public Msg queryAccountAll(@RequestParam(value="userId") Integer userId,
			@RequestParam(value="pn",defaultValue="1") Integer pn) {
		Msg msg = new Msg();
		PageHelper.startPage(pn, 7);
		List<Account> accounts = accountService.queryAccountAll(userId);
		PageInfo page = new PageInfo(accounts, 7);
		msg.getExtend().put("accounts", accounts);
		return msg.ok("查询成功").add("page",page);
	}
	
	//添加账户
	@RequestMapping("/addAccount")
	@ResponseBody
	public Msg addAccount(Account account) {
		accountService.insertAccount(account);
		return Msg.success("添加成功!");
	}
	
	//根据用户id 和 厂商传入值模糊查询账户
	@RequestMapping("/queryAccountLikeName")
	@ResponseBody
	public Msg queryAccountLikeName(@RequestParam(value="userId") Integer userId,
			@RequestParam(value="accountName") String accountName,
			@RequestParam(value="pn",defaultValue="1") Integer pn) {
		Msg msg = new Msg();
		PageHelper.startPage(pn, 7);
		List<Account> accounts = accountService.queryAccountLikeName(accountName, userId);
		PageInfo page = new PageInfo(accounts, 7);
		msg.getExtend().put("accounts", accounts);
		return msg.ok("查询成功").add("page",page);
	}
	
	//根据用户id 和 账户id号删除账户
	@RequestMapping("/deleteAccount")
	@ResponseBody
	public Msg deleteAccount(@RequestParam(value="accountId") Integer accountId,
			@RequestParam(value="userId") Integer userId) {
		Msg msg = new Msg();
		if(accountService.queryAccountById(accountId, userId) == null) {
			return msg.no("你不具有这个账户");
		}
		accountService.deleteAccount(accountId);
		return msg.ok("删除成功");
	}
	
	//根据传入值修改用户
	@RequestMapping("/updateAccount")
	@ResponseBody
	public Msg updateAccount(Account account) {
		accountService.updateAccount(account);
		return Msg.success("修改成功");
	}
}
