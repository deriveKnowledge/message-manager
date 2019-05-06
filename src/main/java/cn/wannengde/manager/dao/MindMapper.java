package cn.wannengde.manager.dao;

import cn.wannengde.manager.bean.Mind;
import cn.wannengde.manager.bean.MindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MindMapper {
    long countByExample(MindExample example);

    int deleteByExample(MindExample example);

    int deleteByPrimaryKey(Integer mindId);

    int insert(Mind record);

    int insertSelective(Mind record);

    List<Mind> selectByExample(MindExample example);

    Mind selectByPrimaryKey(Integer mindId);

    Mind selectMindLast(Integer userId);

    int updateByExampleSelective(@Param("record") Mind record, @Param("example") MindExample example);

    int updateByExample(@Param("record") Mind record, @Param("example") MindExample example);

    int updateByPrimaryKeySelective(Mind record);

    int updateByPrimaryKey(Mind record);
}