package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.YwKeyWord;
import com.jyzw.mapper.YwkeyWordMapper;
import com.jyzw.service.YwkeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="ywKeyWord",method= {RequestMethod.GET,RequestMethod.POST})
public class YwkeyWordWeb {
    @Autowired
    private YwkeyWordService ywkeyWordService;
    @RequestMapping("getList")
    public List<YwKeyWord> getList(){
        return ywkeyWordService.getList();
    }
    @RequestMapping("getOne")
    public YwKeyWord getOne(String ywkId){
        return ywkeyWordService.getOne(ywkId);
    }

    @RequestMapping("getPageList")
    public PageInfo getPageList(Integer pageNum,Integer pageSize,YwKeyWord ywKeyWord){
      return  ywkeyWordService.getPageList(pageNum,pageSize,ywKeyWord);
    }
    @RequestMapping("saveOne")
    public Result  saveOne(YwKeyWord ywKeyWord){
        return ywkeyWordService.saveOne(ywKeyWord);
    }
    @RequestMapping("updateOne")
    public Result updateOne(YwKeyWord ywKeyWord){
        return ywkeyWordService.updateOne(ywKeyWord);
    }
    @RequestMapping("delOne")
    public Result delOne(String ywkId){
        return ywkeyWordService.delOne(ywkId);
    }
}
