package cn.wannengde.manager.dao;

import cn.wannengde.manager.bean.Journal;
import cn.wannengde.manager.bean.JournalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JournalMapper {
    long countByExample(JournalExample example);

    int deleteByExample(JournalExample example);

    int deleteByPrimaryKey(Integer journalId);

    int insert(Journal record);

    int insertSelective(Journal record);

    List<Journal> selectByExample(JournalExample example);

    Journal selectByPrimaryKey(Integer journalId);

    int updateByExampleSelective(@Param("record") Journal record, @Param("example") JournalExample example);

    int updateByExample(@Param("record") Journal record, @Param("example") JournalExample example);

    int updateByPrimaryKeySelective(Journal record);

    int updateByPrimaryKey(Journal record);
}