package cn.wannengde.manager.dao;

import cn.wannengde.manager.bean.Thing;
import cn.wannengde.manager.bean.ThingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThingMapper {
    long countByExample(ThingExample example);

    int deleteByExample(ThingExample example);

    int deleteByPrimaryKey(Integer thingId);

    int insert(Thing record);

    int insertSelective(Thing record);

    List<Thing> selectByExample(ThingExample example);

    Thing selectByPrimaryKey(Integer thingId);

    int updateByExampleSelective(@Param("record") Thing record, @Param("example") ThingExample example);

    int updateByExample(@Param("record") Thing record, @Param("example") ThingExample example);

    int updateByPrimaryKeySelective(Thing record);

    int updateByPrimaryKey(Thing record);
}