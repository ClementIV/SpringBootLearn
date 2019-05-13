package com.cto51.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cto51.model.User;

//@CrossOrigin(origins = { "http://127.0.0.1:8092" })
@RestController
public class CorsMutilController {

	@RequestMapping(value = "/user/getUserInfo")
	public Map<String, Object> getUserInfo(String id) {
		Map<String, Object> resp = new HashMap<String, Object>();
		resp.put("code", "200");
		User user = new User();
		user.setId(1);
		user.setUsername("java乐园");
		user.setSalary(120000f);
		resp.put("body", user);
		return resp;
	}
	
	@RequestMapping(value = "/user/listUserInfo")
	public Map<String, Object> listUserInfo(String id) {
		List<User> list = new ArrayList<>();
		User user = new User();
		user.setId(1);
		user.setUsername("java乐园");
		user.setSalary(120000f);
		list.add(user);	
		
		user = new User();
		user.setId(2);
		user.setUsername("51cto");
		user.setSalary(120000f);
		list.add(user);
		
		Map<String, Object> resp = new HashMap<String, Object>();
		resp.put("code", "200");
		resp.put("body", list);
		return resp;
	}

}
