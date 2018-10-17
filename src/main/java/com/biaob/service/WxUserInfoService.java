package com.biaob.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biaob.bean.Confession;
import com.biaob.bean.PageBean;
import com.biaob.bean.Wxuserinfo;

public interface WxUserInfoService {

	Wxuserinfo findByOpenId(String openid);

	void addWxUserInfo(Wxuserinfo wxuserinfo);

}
