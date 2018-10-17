package com.biaob.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biaob.bean.Confession;
import com.biaob.bean.PageBean;

public interface ConfessionService {

	PageBean findAllConfessData(@Param(value="pageStart") int page, @Param(value="pageSize")int pageSize);

	Confession findById(Integer id);

	void add(Confession confession);

}
