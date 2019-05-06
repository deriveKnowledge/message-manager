package cn.wannengde.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wannengde.manager.bean.User;
import cn.wannengde.manager.bean.UserExample;
import cn.wannengde.manager.dao.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper ;
	
	//删除用户
	public void deleteUser(Integer userId) {
		userMapper.deleteByPrimaryKey(userId);
	}
	
	//根据名字审查是否存在该用户
	public boolean checkUser(String username) {
		List<User> users = null;
		users = userMapper.selectByUserName(username);
		if(users.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	//根据名字查看并返回是否有该用户
	public List<User> login(String username) {
		List<User> users = null;
		users = userMapper.selectByUserName(username);
		return users;
	}
	//添加用户
	public void addUser(User user) {
		userMapper.insert(user);
	}
	//查询所有用户
	public List<User> queryAllUser(){
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
		return list;
	}
	//修改用户
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	
	//根据Id查询用户
	public User queryUserById(Integer userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

}
