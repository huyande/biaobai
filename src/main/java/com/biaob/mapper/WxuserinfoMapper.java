package com.biaob.mapper;

import com.biaob.bean.Wxuserinfo;

public interface WxuserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wxuserinfo record);

    int insertSelective(Wxuserinfo record);

    Wxuserinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wxuserinfo record);

    int updateByPrimaryKey(Wxuserinfo record);

	Wxuserinfo findByOpenId(String openid);
}