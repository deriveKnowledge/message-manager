package cn.wannengde.manager.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wannengde.manager.bean.Wish;
import cn.wannengde.manager.bean.WishExample;
import cn.wannengde.manager.bean.WishExample.Criteria;
import cn.wannengde.manager.dao.WishMapper;

@Service
public class WishService {

	@Autowired
	WishMapper mapper;
	
	//根据标题模糊查询
	public List<Wish> queryWishByLikeTitle(String wishTitle , Integer userId){
		WishExample example = new WishExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andWishTitleLike("%" + wishTitle + "%");
		List<Wish> lists = mapper.selectByExample(example);
		return lists;
	}
	
	//返回传入日期相等的愿望
	public List<Wish> judgeTime(Date date,Integer userId) {
		WishExample example = new WishExample();
		Criteria criteria = example.createCriteria();
		criteria.andWishOverTimeEqualTo(date);
		criteria.andUserIdEqualTo(userId);
		List<Wish> lists = mapper.selectByExample(example);
		return lists;
	}
	
	//根据用户ID查询所有对应用户所有愿望
	public List<Wish> queryWishAll(Integer userId){
		WishExample example = new WishExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Wish> lists = mapper.selectByExample(example);
		return lists;
	}
	
	//添加愿望
	public void addWish(Wish wish) {
		mapper.insert(wish);
	}
	
	//根据愿望ID删除愿望
	public void deleteWish(Integer wishId) {
		mapper.deleteByPrimaryKey(wishId);
	}
	
	//修改愿望
	public void updateWish(Wish wish) {
		mapper.updateByPrimaryKeySelective(wish);
	}
}
