package cn.wannengde.manager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wannengde.manager.bean.Journal;
import cn.wannengde.manager.bean.JournalExample;
import cn.wannengde.manager.bean.JournalExample.Criteria;
import cn.wannengde.manager.dao.JournalMapper;

@Service
public class JournalService{
	@Autowired
	JournalMapper mapper;
	
	//根据用户id和文章内容模糊查询
	public List<Journal> queryJournalByText(Integer userId,String journalText){
		JournalExample example = new JournalExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andJournalTextLike(journalText);
		List<Journal> lists = mapper.selectByExample(example);
		return lists;
	}
	
	//根据用户Id和日期传入日记
	public List<Journal> queryJournalByTime(Integer userId,Date journalTime){
		JournalExample example = new JournalExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andJournalTimeEqualTo(journalTime);System.out.println(journalTime);
		List<Journal> lists = mapper.selectByExample(example);
		return lists;
	}
	
	//根据用户ID查询日记
	public List<Journal> queryJournalAll(Integer userId){
		JournalExample example = new JournalExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Journal> lists = mapper.selectByExample(example);
		return lists;
	}
	
	//根据传入日记对象修改日记
	public void updateJournal(Journal journal) {
		mapper.updateByPrimaryKeySelective(journal);
	}
	
	//根据日记Id删除日记
	public void deleteJournal(Integer journalId) {
		mapper.deleteByPrimaryKey(journalId);
	}
	
	//添加日记
	public void AddJournal(Journal journal) {
		mapper.insert(journal);
	}
}
