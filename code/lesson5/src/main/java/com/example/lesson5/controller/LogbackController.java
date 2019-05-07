package com.example.lesson5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LogbackController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getFileContent")
    public Map<String,Object> getFileContent(String filePath){
        logger.debug("begin getFileContent");
        Map<String, Object> resp = new HashMap<>();
        resp.put("code","000001");
        resp.put("msg","fail");
        FileInputStream fin = null;
        try{
            File file = new File(filePath);
            if(file.exists()) {
                logger.info("filePath = {}",filePath);
                fin = new FileInputStream(file);
                resp.put("code","000000");
                resp.put("msg","ok");
                resp.put("body",getContent(fin));
            }else {
                logger.warn("no exist filePath = {}",filePath);
            }
        } catch (FileNotFoundException e) {
            logger.error("no exist filePath = {}",filePath,e);
        }catch (Exception e){
            logger.error("other error filePath ={}",filePath,e);
        }finally{
            if(fin !=null){
                try{
                    fin.close();
                }catch (IOException e){
                    logger.error("io error",e);
                }
            }
        }
        logger.debug("end getFileContent = {}",resp);

        return resp;
    }

    private String getContent(FileInputStream fin) {
        String result = null;
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream out = null;
        int len = -1;
        try{
            out = new ByteArrayOutputStream();
            while((len = fin.read(buffer))!=-1){
                out.write(buffer,0,len);
            }
            byte[] temp = out.toByteArray();
            if(temp.length>0){
                result = new String(temp,0,temp.length,"utf-8");
            }
        } catch (IOException e) {
            logger.error("io error",e);
        }

        return result;
    }
}
