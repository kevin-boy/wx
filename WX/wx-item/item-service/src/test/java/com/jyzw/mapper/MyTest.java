package com.jyzw.mapper;

import com.jyzw.entity.TMenu;
import com.jyzw.entity.Tuser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {
   @Autowired
   private TMenuMapper tMenuMapper;
   @Autowired
   private TuserMapper tuserMapper;

       /* TMenu tMenu=new TMenu("001","002","1","123","124",8,"456","1","1","00");
        tMenuMapper.saveOne(tMenu);*/

    @Test
    public void tst2(){
        String ids= UUID.randomUUID().toString();
        System.out.println(ids);
    }


      /* List<TMenu> ids=tMenuMapper.getOne("menu_one_xtgl");
        System.out.println(ids.toString());*/

    @Test
    public void test3(){
        Tuser tuser=new Tuser();
        tuser.setLoginName("杨宏秋");
        List<Tuser> list=tuserMapper.getListByTJ(tuser);
        for (Tuser t:list){
            System.out.println(t.toString());
        }
        Tuser a1=tuserMapper.getUserByName("赵光耀");
        System.out.println(a1.toString());
    }
}
