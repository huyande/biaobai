package com.biaob.mapper;

import java.util.List;

import com.biaob.bean.Confession;

public interface ConfessionMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(Confession record);

    int insertSelective(Confession record);

    Confession selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Confession record);

    int updateByPrimaryKey(Confession record);

    /**
     * 	查所有
     * @return
     */
	List<Confession> findAllConfession(int pageStart,int pageSize);
	//查总数
	int countItem(); 
}