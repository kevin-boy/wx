package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwEyunAccount;
import com.jyzw.service.YwEyunAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="account",method={RequestMethod.GET,RequestMethod.POST})
public class YwEyunAccountWeb {
    @Autowired
    private YwEyunAccountService ywEyunAccountService;
    @RequestMapping("getList")
    public List<YwEyunAccount> getList(){
       return ywEyunAccountService.getList();
    }
    @RequestMapping("getPageList")
    public PageInfo getPageList(Integer pageNum,Integer pageSize,YwEyunAccount ywEyunAccount){
      return  ywEyunAccountService.getpageList(pageNum,pageSize,ywEyunAccount);
    }
    @RequestMapping("getOne")
    public YwEyunAccount getOne(String yweaId){
        return ywEyunAccountService.getOne(yweaId);
    }
    @RequestMapping("saveOne")
    public Result saveOne(YwEyunAccount ywEyunAccount){
        return ywEyunAccountService.saveOne(ywEyunAccount);
    }
    @RequestMapping("updateOne")
    public Result updateOne(YwEyunAccount ywEyunAccount){
        return ywEyunAccountService.update(ywEyunAccount);
    }
    @RequestMapping("delOne")
    public Result delOne(String yweaId){
        return ywEyunAccountService.delOne(yweaId);
    }
}
