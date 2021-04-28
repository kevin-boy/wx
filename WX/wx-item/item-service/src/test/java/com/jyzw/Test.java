package com.jyzw;

import com.jyzw.entity.Tuser;
import com.jyzw.mapper.TuserMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Test {
   @Autowired
   private TuserMapper tuserMapper;
    public static void main(String[] args) {
        String pwd=new Md5Hash("12345","赵光耀").toString();
        System.out.println(pwd);
       /* ResultInfo result=new ResultInfo("133","z1",new Tuser());
        System.out.println(result);*/
    }


        /*Tuser tuser=tuserMapper.getUserByUP("zgy","123");*/
        /*System.out.println(tuser.toString())*/;
  @org.junit.Test
    public void test3(){
      Tuser tuser=new Tuser();
      tuser.setLoginName("zgy");
      tuser.setLoginPwd("123");
      tuser.setUserId("2");
      /*tuserMapper.insert(tuser);*/

  }
  @org.junit.Test
    public void test4(){
      Tuser tuser=new Tuser();
      tuser.setUserId("3");
      tuser.setLoginName("zgy");
     /* tuserMapper.updateByPrimaryKey(tuser);*/
  }

}
