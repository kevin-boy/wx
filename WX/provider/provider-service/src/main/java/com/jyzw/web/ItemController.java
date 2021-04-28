package com.jyzw.web;

import com.jyzw.dao.ItemDao;
import com.jyzw.entity.TabUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemDao itemDao;
    @RequestMapping("iinyyy")
    List<TabUser> getList(){
        List<TabUser> list = itemDao.getList();
        return list;
    }

}
