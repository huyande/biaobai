package com.biaob.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.biaob.bean.Wxuserinfo;
import com.biaob.service.WxUserInfoService;
import com.biaob.utils.HttpClientUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
@ConfigurationProperties(prefix = "wx")
public class LoginController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WxUserInfoService wxUserInfoService;
	
	private String appid;
	private String secret;
	private String grantType;
	private String sessionHost;
	
	@RequestMapping(value="/GetOpenid/code/{code}")
	public String login(@PathVariable("code") String code)throws Exception {
		
		Map<String, String> params = new HashMap<>();
		params.put("appid", appid);
		params.put("secret", secret);
		params.put("js_code", code);
		params.put("grant_type", grantType);
		// 定义JackJson 对象
		ObjectMapper mapper = new ObjectMapper();
		String param_json = mapper.writeValueAsString(params);
		String api_url =sessionHost+"?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type="+grantType ;
		String str = HttpClientUtil.get(api_url);
		//restTemplate.getForObject(url, responseType, uriVariables)
		//Gson gson = new Gson();
		/*String string = entity.getBody();*/
		//System.err.println(string);
		return str;
	}

	@RequestMapping(value="/user/add")
	public void add(Wxuserinfo wxuserinfo)throws Exception {
		//根据openid 查询  如果有 则不添加，没有则进行添加
		Wxuserinfo has=wxUserInfoService.findByOpenId(wxuserinfo.getOpenid());
		if(has==null) {
			wxUserInfoService.addWxUserInfo(wxuserinfo);
		}
	}
	
	

	public String getAppid() {
		return appid;
	}


	public void setAppid(String appid) {
		this.appid = appid;
	}


	public String getSecret() {
		return secret;
	}


	public void setSecret(String secret) {
		this.secret = secret;
	}


	public String getGrantType() {
		return grantType;
	}


	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}


	public String getSessionHost() {
		return sessionHost;
	}


	public void setSessionHost(String sessionHost) {
		this.sessionHost = sessionHost;
	}
	
}
