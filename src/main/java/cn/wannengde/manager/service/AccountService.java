package cn.wannengde.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wannengde.manager.bean.Account;
import cn.wannengde.manager.bean.AccountExample;
import cn.wannengde.manager.bean.AccountExample.Criteria;
import cn.wannengde.manager.dao.AccountMapper;

@Service
public class AccountService {
	@Autowired
	AccountMapper accountMapper;
	
	//根据账户Id和用户id查询账户
	public Account queryAccountById(Integer accountId,Integer userId) {
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andAccountIdEqualTo(accountId);
		List<Account> list = accountMapper.selectByExample(example);
		if(list.size() != 0)
			return list.get(0);
		else
			return null; 
	}
	
	//添加账户
	public void insertAccount(Account account) {
		accountMapper.insert(account);
	}
	
	//根据用户id查询用户所有账号
	public List<Account> queryAccountAll(Integer userId){
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Account> list = accountMapper.selectByExample(example);
		return list;
	}
	
	//根据用户id 及 传入值进行服务厂商模糊查询
	public List<Account> queryAccountLikeName(String accountName,Integer userId){
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andAccountNameLike("%" + accountName + "%");
		List<Account> list = accountMapper.selectByExample(example);
		return list;
	}
	
	//根据用户id 和 传入对象修改
	public void updateAccount(Account account) {
		accountMapper.updateByPrimaryKeySelective(account);
	}
	
	//根据账户id删除用户 
	public void deleteAccount(Integer accountId) {
		accountMapper.deleteByPrimaryKey(accountId);
	}
}
