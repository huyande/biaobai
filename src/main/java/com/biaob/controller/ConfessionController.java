package com.biaob.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.biaob.bean.Confession;
import com.biaob.bean.PageBean;
import com.biaob.bean.Userbrowsing;
import com.biaob.bean.Wxuserinfo;
import com.biaob.service.ConfessionService;
import com.biaob.service.UserbrowsingService;
import com.biaob.service.WxUserInfoService;
import com.google.gson.Gson;

/**
 * 表白墙 控制层
 * @author runner
 *
 */
@RestController
public class ConfessionController {

	@Autowired
	private ConfessionService confessionService;
	
	@Autowired
	private UserbrowsingService userbrowsingService;
	
	@Autowired
	private WxUserInfoService wxUserInfoService;
	
	//index 页面请求数据的方法
	@RequestMapping(value="get")
	public String get(int page,int page_size) {
		Gson gson = new Gson();
		PageBean pageBean=confessionService.findAllConfessData(page,page_size);
		String json = gson.toJson(pageBean);
		return json;
	}
	/**
	 *	查询详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/view/id/{id}")
	public String viewContent(@PathVariable("id") Integer id) {
		Gson gson = new Gson();
		Confession confession= confessionService.findById(id);
		String json = gson.toJson(confession);
		return json;
	}
	/**
	 * 	新增表白信息
	 * @param confession
	 */
	@RequestMapping(value="/addData")
	public String add(Confession confession) {
		//根据oppeid 查询用户记录表 
		Wxuserinfo wxuserinfo = wxUserInfoService.findByOpenId(confession.getOpenid());
		confession.setGender(wxuserinfo.getGender());
		confession.setHeadimageurl(wxuserinfo.getAvatarurl());
		confessionService.add(confession);
		return confession.getId().toString();
	}
	
	/**
	 * 	上传文件
	 * 	aid 是插入数据库的信息 主键id  
	 * @param confession
	 */
	@RequestMapping(value="/upload/pid/{aid}")
	public String upload(MultipartFile files,@PathVariable("aid")String aid) {
		System.err.println("=====ssssss======");
		return "ff";
	}
	
	
	
	
	
	/**
	 * 	增加该信息访客信息 暂不使用 
	 * 	方法一实现
	 * @param userbrowsing
	 */
	@RequestMapping(value="/addGuanzhu")
	public void addGuanzhu(Userbrowsing userbrowsing) {
		Boolean has=userbrowsingService.findByOppenidAndconfId(userbrowsing.getOpenid(),userbrowsing.getConfid());
		if(!has) {
			userbrowsingService.addUserbrowsing(userbrowsing);
		}
	}
	
	/**
	 * 	查询该文章 所有的访客记录  
	 * @param vid
	 * @return
	 */
	@RequestMapping(value="/getGuanzhu")
	public String getGuanzhu(Integer vid) {
		List<Userbrowsing> datas=userbrowsingService.findAllByConfId(vid);
		Gson gson = new Gson();
		String json = gson.toJson(datas);
		return json;
	}
	
	
	
	
}
