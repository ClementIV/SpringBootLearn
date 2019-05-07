package com.example.lesson5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getUser")
    public Map<String,Object> getUser(String type){
        logger.debug("begin getUser");
        Map<String, Object> resp = new HashMap<>();
        resp.put("code","0000001");
        resp.put("msg","fail");
        try{
            if("1".equals(type)){
                logger.info("ger success type = {}",type);
                resp.put("code","0000000");
                resp.put("msg","ok");
            }else{
                logger.warn("no this type ={} user",type);
            }
        }catch (Exception e){
            logger.error("other error",e);
        }
        logger.debug("end getUser = {}",resp);

        return resp;
    }
}
