package com.biaob.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biaob.bean.Userbrowsing;

public interface UserbrowsingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userbrowsing record);

    int insertSelective(Userbrowsing record);

    Userbrowsing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userbrowsing record);

    int updateByPrimaryKey(Userbrowsing record);

    Userbrowsing findByOppenidAndconfId(@Param("openid")String openid, @Param("confid")Integer confid);

    List<Userbrowsing>  findAllByConfId(Integer vid);
}