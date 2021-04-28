package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwUserAuthorize;
import com.jyzw.service.UserAuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="uAuthorize",method= {RequestMethod.GET,RequestMethod.POST})
public class YwUserAuthorizeWeb {
@Autowired
    private UserAuthorizeService userAuthorizeService;
  @RequestMapping("getList")
    public List<YwUserAuthorize> getList(){
  return     userAuthorizeService.getList();
  }
  @RequestMapping("getPageList")
    public PageInfo getPageList(Integer pageNum,Integer pageSize,YwUserAuthorize ywUserAuthorize){
    return   userAuthorizeService.getPageList(pageNum,pageSize,ywUserAuthorize);
  }
  @RequestMapping("getOne")
 public  YwUserAuthorize getOne(String yuaId){
      return userAuthorizeService.getOne(yuaId);
  }
  @RequestMapping("saveOne")
    public Result saveOne(YwUserAuthorize ywUserAuthorize){
      return  userAuthorizeService.saveOne(ywUserAuthorize);
  }
  @RequestMapping("updateOne")
    public Result updateOne(YwUserAuthorize ywUserAuthorize){
      return userAuthorizeService.updateOne(ywUserAuthorize);
  }
  @RequestMapping("delOne")
    public Result delOne(String yuaId){
      return userAuthorizeService.delOne(yuaId);
  }

}
