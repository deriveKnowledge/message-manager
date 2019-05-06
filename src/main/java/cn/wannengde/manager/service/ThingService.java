package cn.wannengde.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wannengde.manager.bean.Thing;
import cn.wannengde.manager.bean.ThingExample;
import cn.wannengde.manager.bean.ThingExample.Criteria;
import cn.wannengde.manager.dao.ThingMapper;

@Service
public class ThingService {
	@Autowired
	private ThingMapper thingMapper;

	//根据用户ID查询用户失效事件
	public List<Thing> queryThingByUserIdDisable(Integer userId){
		ThingExample example = new ThingExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andAbilityEqualTo(0);
		List<Thing> list = thingMapper.selectByExample(example);
		return list;
	}

	//根据用户ID查询用户有效事件
	public List<Thing> queryThingByUserIdAble(Integer userId){
		ThingExample example = new ThingExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andAbilityEqualTo(1);
		List<Thing> list = thingMapper.selectByExample(example);
		return list;
	}

	//增加事件
	public void insert(Thing thing) {
		thingMapper.insert(thing);
	}
	
	//根据事件id删除事件
	public void deletById(Integer thingId) {
		thingMapper.deleteByPrimaryKey(thingId);
	}


	//根据事件更新事件
	public void updateByThing(Thing thing) {
		thingMapper.updateByPrimaryKeySelective(thing);
	}
	
	//根据事件id查询事件
	public Thing queryById(Integer thingId) {
		Thing thing = thingMapper.selectByPrimaryKey(thingId);
		return thing;
	}
	
	//根据事件标题和用户Id查询事件
	public List<Thing> queryByTitle(String thingTitle,Integer userId){
		ThingExample example = new ThingExample();
		Criteria criteria = example.createCriteria();
		criteria.andThingTitleLike("%" +  thingTitle + "%");
		criteria.andUserIdEqualTo(userId);
		List<Thing> list = thingMapper.selectByExample(example);
		return list;
	}
	
	//根据userId查询所有事件
	public List<Thing> queryByUserId(Integer userId){
		ThingExample example = new ThingExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Thing> list = thingMapper.selectByExample(example);
		return list;
	}
	
	//根据时间点和用户id查询事件
	public List<Thing> queryByTime(String thingTime,Integer userId){
		ThingExample example = new ThingExample();
		Criteria criteria = example.createCriteria();
		criteria.andThingTimeEqualTo(thingTime);
		criteria.andUserIdEqualTo(userId);
		List<Thing> list = thingMapper.selectByExample(example);
		return list;
	}
	
	//根据userId统计事件数量
	public long countByUserId(Integer userId){
		ThingExample example = new ThingExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return thingMapper.countByExample(example);
	}
	
}
