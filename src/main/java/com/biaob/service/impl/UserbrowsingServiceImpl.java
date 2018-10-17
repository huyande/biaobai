package com.biaob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biaob.bean.Userbrowsing;
import com.biaob.mapper.UserbrowsingMapper;
import com.biaob.service.UserbrowsingService;
@Service
public class UserbrowsingServiceImpl implements UserbrowsingService {

	@Autowired
	private UserbrowsingMapper userbrowsingMapper;

	@Override
	public Boolean findByOppenidAndconfId(String openid, Integer confid) {
		Userbrowsing userinfo =userbrowsingMapper.findByOppenidAndconfId(openid,confid);
		if(userinfo!=null) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public void addUserbrowsing(Userbrowsing userbrowsing) {
		userbrowsingMapper.insert(userbrowsing);
	}

	@Override
	public List<Userbrowsing> findAllByConfId(Integer vid) {
		List<Userbrowsing> list=userbrowsingMapper.findAllByConfId(vid);
		return list;
	}

	
}
