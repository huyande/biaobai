package com.biaob.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biaob.bean.Wxuserinfo;
import com.biaob.mapper.WxuserinfoMapper;
import com.biaob.service.WxUserInfoService;
@Service
public class WxUserInfoServiceImpl implements WxUserInfoService {

	@Autowired
	private WxuserinfoMapper wxuserinfoMapper;

	@Override
	public Wxuserinfo findByOpenId(String openid) {
		Wxuserinfo wxuserinfo =wxuserinfoMapper.findByOpenId(openid);
		return wxuserinfo;
	}

	@Override
	public void addWxUserInfo(Wxuserinfo wxuserinfo) {
		wxuserinfoMapper.insert(wxuserinfo);
	}
	
}
