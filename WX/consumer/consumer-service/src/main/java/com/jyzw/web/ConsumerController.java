package com.jyzw.web;

import com.jyzw.dao.YgDao;
import com.jyzw.entity.TabUser;
import com.jyzw.entity.Ygmoney;
import com.jyzw.mapper.Itemmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("con")
public class ConsumerController {
    @Autowired
    private Itemmapper itemmapper;
    @Autowired
    private YgDao ygDao;
    @RequestMapping("user")
     public List<TabUser> getList(){
       return itemmapper.getList();
    }

    @RequestMapping("gogo/{id}")
    public Ygmoney getOne(@PathVariable("id")String id){
      return   ygDao.getOne(id);
    }
}
