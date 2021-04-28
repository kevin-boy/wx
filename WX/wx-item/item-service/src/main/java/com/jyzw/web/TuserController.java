package com.jyzw.web;

import com.github.pagehelper.PageInfo;

import com.jyzw.entity.Result;
import com.jyzw.entity.Tuser;
import com.jyzw.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value="user",method={RequestMethod.GET,RequestMethod.POST})
public class TuserController {
    @Autowired
    private TuserService tuserService;

    /**
     * 根据用户id得到用户信息
     * @param uid
     * @return
     */

    @RequestMapping("getOne")
    public Tuser getUser(@RequestParam("uid")String uid){
        Tuser user = tuserService.getUser(uid);
        return user;
    }

    /**
     * 根据用户id删除用户信息
     * @param uid
     * @return
     */

    @RequestMapping("delOne")
    public Result<Tuser>   delOne(String uid){
        return   tuserService.delOne(uid);

    }

    /**
     * 输入用户对应信息，保存用户
     * @param tuser
     * @return
     */

    @PostMapping("saveOne")
    public Result<Tuser>  save(Tuser tuser){
        return     tuserService.save(tuser);

    }

    /**
     * 分页查询有用户信息
     * @param pageNum
     * @param pageSize
     * @param tuser
     * @return
     */
    @ResponseBody
    @RequestMapping("findAll")
    public PageInfo<Tuser> getList(Integer pageNum,Integer pageSize,Tuser tuser){
     return   tuserService.getPageInfo(pageNum,pageSize,tuser);
    }

    /**
     * 查询所有用户信息
     * @return
     */

    @RequestMapping("findList")
    public List<Tuser> getListFL(){
        return tuserService.getListFL();
    }

    /**
     * 输入用户信息，根据id修改用户信息
     * @param tuser
     * @return
     */

    @PostMapping("edit")
    public Result edit(Tuser tuser){
        Result<Tuser>  resultInfo = tuserService.updateOne(tuser);
        return resultInfo;
    }

    /**
     * 输入用户名，密码，进行登录（用户名，密码校验）
     * @param dl_mc
     * @param dl_mm
     * @return
     */

    @PostMapping("login")
    public Result<Tuser> login(String dl_mc, String dl_mm){
        Result<Tuser>  login = tuserService.login(dl_mc, dl_mm);
    /*    if(dl_mc==null||dl_mc.equals("")){

       }*/
        return login;
    }


    @PostMapping("updatePwd")
    public Result updatePwd(String userId,String loginPwd){
      return  tuserService.updatePwd(userId,loginPwd);
    }


    @RequestMapping("getUser")
    public Tuser getUserByUP(@RequestParam("uname") String uname,@RequestParam("pwd") String pwd){
        return tuserService.getUserByUP(uname,pwd);
    }

    @PostMapping("updateWid")
    public Result updateWid(@RequestBody Tuser tuser){
        try {
            tuserService.updateWid(tuser);
            return new Result(Result.sCode,"修改实例ID成功！",tuser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(Result.fCode,"修改实例ID失败！",tuser);
    }

    @RequestMapping("getUByName")
    public Tuser getUByName(@RequestParam("uname") String uname){
      return   tuserService.getUserByUname(uname);
    }
}
