package cn.wannengde.manager.dao;

import cn.wannengde.manager.bean.Wish;
import cn.wannengde.manager.bean.WishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WishMapper {
    long countByExample(WishExample example);

    int deleteByExample(WishExample example);

    int deleteByPrimaryKey(Integer wishId);

    int insert(Wish record);

    int insertSelective(Wish record);

    List<Wish> selectByExample(WishExample example);

    Wish selectByPrimaryKey(Integer wishId);

    int updateByExampleSelective(@Param("record") Wish record, @Param("example") WishExample example);

    int updateByExample(@Param("record") Wish record, @Param("example") WishExample example);

    int updateByPrimaryKeySelective(Wish record);

    int updateByPrimaryKey(Wish record);
}