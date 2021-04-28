package com.jyzw.dao;

import com.jyzw.entity.Result;
import com.jyzw.entity.TMenu;
import com.jyzw.entity.Tuser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient("item-service")
public interface UserClient {
    @RequestMapping("user/getUser")
    public Tuser getUserByUP(@RequestParam("uname") String uname,@RequestParam("pwd") String pwd);
    @PostMapping("user/updateWid")
    public Result updateWid(@RequestBody Tuser tuser);
    @RequestMapping("userRole/getUR")
    public Result getUR(@RequestParam String userId);
    @RequestMapping("roleMenu/getRM")
    public Set<TMenu> getRM(String roleId);
    @RequestMapping("user/getUByName")
    public Tuser getUByName(@RequestParam("uname") String uname);
}
