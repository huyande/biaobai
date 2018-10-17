package com.biaob.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biaob.bean.Confession;
import com.biaob.bean.PageBean;
import com.biaob.mapper.ConfessionMapper;
import com.biaob.service.ConfessionService;
import com.github.pagehelper.PageHelper;

@Service
public class ConfessionServiceImpl implements ConfessionService{

	@Autowired
	private ConfessionMapper confessionMapper;
	
	@Override
	public PageBean findAllConfessData(int page,int pageSize) {
		int countItem = confessionMapper.countItem();
		PageBean<Confession> pageBean = new PageBean<>(page,pageSize,countItem);
		//查所有
		List<Confession> list = confessionMapper.findAllConfession(pageBean.getStartIndex(),pageSize);
		
		pageBean.setItems(list);
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(pageSize);
		return pageBean;
	}

	/**
	 * 根据id查询数据
	 */
	@Override
	public Confession findById(Integer id) {
		Confession confession = confessionMapper.selectByPrimaryKey(id);
		return confession;
	}

	@Override
	public void add(Confession confession) {
		confessionMapper.insert(confession);
	}

}
