package com.biaob.bean;

import java.util.Date;

/**
 * 
 * @date 2018-09-03
 */
public class Confession {
	private Integer id;

	/**
	 * 性别
	 */
	private Integer gender;

	private String openid;

	private String fromuser;

	private String touser;

	/**
	 * 图片
	 */
	private String photo;

	/**
	 * 描述
	 */
	private String content;

	/**
	 * 是否显示
	 */
	private Integer display;

	/**
	 * 评论数
	 */
	private String plnum;

	private String headimageurl;

	/**
	 * 发布时间
	 */
	private String datetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid == null ? null : openid.trim();
	}

	public String getFromuser() {
		return fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser == null ? null : fromuser.trim();
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser == null ? null : touser.trim();
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo == null ? null : photo.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Integer getDisplay() {
		return display;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}

	public String getPlnum() {
		return plnum;
	}

	public void setPlnum(String plnum) {
		this.plnum = plnum == null ? null : plnum.trim();
	}

	public String getHeadimageurl() {
		return headimageurl;
	}

	public void setHeadimageurl(String headimageurl) {
		this.headimageurl = headimageurl == null ? null : headimageurl.trim();
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}