package com.cto51.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsSingleController {

//	@CrossOrigin(origins = { "http://127.0.0.1:8092" })
	@RequestMapping(value = "/corsSingle")
	public Map<String, String> corsSingle(String id) {
		Map<String, String> resp = new HashMap<String, String>();
		resp.put("code", "200");
		resp.put("result", "single cors");
		return resp;
	}

}
