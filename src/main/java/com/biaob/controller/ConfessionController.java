package com.biaob.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
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
import com.biaob.utils.FileUtil;
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
	public String upload(MultipartFile files,@PathVariable("aid")Integer aid) {
		try {
			//创建文件 
			String path ="D:/demo/download/";
			if(!FileUtil.isExist(path)) {
				FileUtil.makeDir(path);
			}
			//保存文件
			files.transferTo(new File(path+files.getOriginalFilename()));
			String filename = files.getOriginalFilename();
			//根据aid 查询信息 
			Confession confession= confessionService.findById(aid);
			confession.setPhoto(filename);
			confessionService.updataConfession(confession);
			return "true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
	}
	
	
	/**
	 * 显示图片 
	 * getFeedBackPicture.do?picName=
	 * @return
	 */
	@RequestMapping(value="/viewPhoto/{photopath}")
	public void getFeedBackPicture(HttpServletResponse response,@PathVariable("photopath")String photopath) throws Exception{
		String realPath="D:/demo/download/"+photopath;
		FileInputStream inputStream = new FileInputStream(realPath);
		int i = inputStream.available();
		//byte数组用于存放图片字节数据
		byte[] buff = new byte[i];
		inputStream.read(buff);
		//记得关闭输入流
		inputStream.close();
		//设置发送到客户端的响应内容类型
		response.setContentType("image/*");
		OutputStream out = response.getOutputStream();
		out.write(buff);
		//关闭响应输出流
		out.close();
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
