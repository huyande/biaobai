package com.biaob.bean;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-31
 */
public class Userbrowsing {
    private Integer id;

    private String openid;

    private Integer confid;

    private String avatarurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getConfid() {
        return confid;
    }

    public void setConfid(Integer confid) {
        this.confid = confid;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }
}