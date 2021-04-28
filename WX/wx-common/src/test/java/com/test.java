package com;

import com.alibaba.fastjson.JSON;
import com.jyzw.entity.UserInfo;
import com.jyzw.util.JwtUtils;
import com.jyzw.util.RsaUtils;
import org.junit.Test;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

public class test {
@Test
    public void test() throws Exception {
    RsaUtils.generateKey("D:\\public","D:\\private","1230",1024);
}
@Test
    public void test2(){
    Map<String,String> map =new HashMap<>();
    map.put("a","1230");
    map.put("b","158");
    map.put("c","789");
    String s = JSON.toJSONString(map);
    System.out.println(s);

}
@Test
    public void test3() throws Exception {
    String pub="D:\\public";
    String pri="D:\\private";
    PrivateKey privateKey=RsaUtils.getPrivateKey(pri);
    String token= JwtUtils.generateTokenExpireInMinutes(new UserInfo("1","jack","guest"),privateKey,5);
    System.out.println(token);
}
}
