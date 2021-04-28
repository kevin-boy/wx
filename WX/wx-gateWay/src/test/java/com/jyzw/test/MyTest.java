package com.jyzw.test;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class MyTest {
@Test
    public void test(){
    Md5Hash md5Hash=new Md5Hash("123","asd");
    System.out.println(md5Hash.toString());
    /*String zgy = Md5Crypt.apr1Crypt("123", "zgy");
    System.out.println("*******"+zgy);*/
    Md5Hash md5=new Md5Hash(md5Hash.toString());
    System.out.println(md5.toString());

}

}
