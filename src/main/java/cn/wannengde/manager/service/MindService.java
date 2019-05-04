package cn.wannengde.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wannengde.manager.bean.Mind;
import cn.wannengde.manager.bean.MindExample;
import cn.wannengde.manager.bean.MindExample.Criteria;
import cn.wannengde.manager.dao.MindMapper;

@Service
public class MindService {
	@Autowired
	private MindMapper mindMapper;
	
	//添加心情记录
	public void addMind(Mind mind) {
		mindMapper.insert(mind);
	}
	
	//根据用户ID查询所有心情记录
	public List<Mind> queryMindAll(Integer userId){
		MindExample example = new MindExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Mind> list = mindMapper.selectByExample(example);
		return list;
	}
	
	//根据用户ID和心情内容模糊查询
	public List<Mind> queryLikeText(String MindText,Integer userId){
		MindExample example = new MindExample();
		Criteria criteria = example.createCriteria();
		criteria.andMindTextLike(MindText);
		criteria.andUserIdEqualTo(userId);
		List<Mind> list = mindMapper.selectByExample(example);
		return list;
	}
	
	//根据心情Id删除心情记录
	public void deleteMindById(Integer mindId) {
		mindMapper.deleteByPrimaryKey(mindId);
	}
	
	//根据用户ID和心情ID查询心情记录
	public List<Mind> queryMindById(Integer userId,Integer mindId){
		MindExample example = new MindExample();
		Criteria criteria = example.createCriteria();
		criteria.andMindIdEqualTo(mindId);
		criteria.andUserIdEqualTo(userId);
		List<Mind> list  = mindMapper.selectByExample(example);
		return list;
	}
}
