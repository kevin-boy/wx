package com.jyzw.web;

import com.jyzw.entity.UserInfo;
import com.jyzw.mapper.TuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemController {

@RequestMapping("baidu")
public String toBaidu(){
      return "redirect:http://baidu.com";
}
   @RequestMapping("logout")
    public String logout(){
      return "redirect:http://121.37.187.26:8089/login.call#";
   }
}
