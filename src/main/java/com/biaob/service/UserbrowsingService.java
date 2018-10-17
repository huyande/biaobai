package com.biaob.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biaob.bean.Confession;
import com.biaob.bean.PageBean;
import com.biaob.bean.Userbrowsing;
import com.biaob.bean.Wxuserinfo;

public interface UserbrowsingService {

	Boolean findByOppenidAndconfId(String openid, Integer confid);

	void addUserbrowsing(Userbrowsing userbrowsing);

	List<Userbrowsing> findAllByConfId(Integer vid);

}
