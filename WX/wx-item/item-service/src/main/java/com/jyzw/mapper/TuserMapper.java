package com.jyzw.mapper;

import com.jyzw.entity.Tuser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TuserMapper extends Mapper<Tuser> {
    @Results({@Result(property = "userId",column="user_id"),
     @Result(property="loginName",column="login_name"),
     @Result(property="loginPwd",column="login_pwd"),
     @Result(property="userName",column="user_name"),
   /*  @Result(property="companyId",column="company_id"),
     @Result(property="companyName",column="company_name"),*/
     @Result(property="userImg",column="user_img"),
     @Result(property="loginIp",column="login_ip"),
     @Result(property="createrId",column="creater_id"),
     @Result(property="createrName",column="creater_name"),
     @Result(property="createrDate",column="creater_date"),
     @Result(property="wxLoginData",column="wx_login_data"),
     @Result(property="wxWcId",column="wx_wcId"),
     @Result(property="wxType",column="wx_type"),
     @Result(property="wxWid",column="wx_wid"),
     @Result(property="wxWAccount",column="wx_wAccount"),
     @Result(property="wxQrCodeUrl",column="wx_qrCodeUrl"),
     @Result(property="wxSmallHeadImgUrl",column="wx_smallHeadImgUrl"),
     @Result(property="dataJson",column="data_json"),
            @Result(property="orgName",column="org_name"),
            @Result(property="orgNo",column="org_no"),
            @Result(property="consId",column="cons_id"),
            @Result(property="consName",column="cons_name"),
            @Result(property="consNo",column="cons_no"),
            @Result(property="wxNickName",column="wx_nickName")
    })
    @Select("select * from t_user where user_id=#{id}")
    Tuser getUser(String uid);

    @Results({@Result(property = "userId",column="user_id"),
            @Result(property="loginName",column="login_name"),
            @Result(property="loginPwd",column="login_pwd"),
            @Result(property="userName",column="user_name"),
          /*  @Result(property="companyId",column="company_id"),
            @Result(property="companyName",column="company_name"),*/
            @Result(property="userImg",column="user_img"),
            @Result(property="loginIp",column="login_ip"),
            @Result(property="createrId",column="creater_id"),
            @Result(property="createrName",column="creater_name"),
            @Result(property="createrDate",column="creater_date"),
            @Result(property="wxLoginData",column="wx_login_data"),
            @Result(property="wxWcId",column="wx_wcId"),
            @Result(property="wxType",column="wx_type"),
            @Result(property="wxWid",column="wx_wid"),
            @Result(property="wxWAccount",column="wx_wAccount"),
            @Result(property="wxQrCodeUrl",column="wx_qrCodeUrl"),
            @Result(property="wxSmallHeadImgUrl",column="wx_smallHeadImgUrl"),
            @Result(property="dataJson",column="data_json"),
            @Result(property="orgName",column="org_name"),
            @Result(property="orgNo",column="org_no"),
            @Result(property="consId",column="cons_id"),
            @Result(property="consName",column="cons_name"),
            @Result(property="consNo",column="cons_no"),
            @Result(property="wxNickName",column="wx_nickName")
    })
    @Select("select * from t_user")
    List<Tuser>  getList();
    @Results({@Result(property = "userId",column="user_id"),
            @Result(property="loginName",column="login_name"),
            @Result(property="loginPwd",column="login_pwd"),
         @Result(property="userName",column="user_name"),
           /* @Result(property="companyId",column="company_id")*/
           /* @Result(property="companyName",column="company_name"),*/
            @Result(property="userImg",column="user_img"),
            @Result(property="loginIp",column="login_ip"),
            @Result(property="createrId",column="creater_id"),
            @Result(property="createrName",column="creater_name"),
            @Result(property="createrDate",column="creater_date"),
            @Result(property="wxLoginData",column="wx_login_data"),
            @Result(property="wxWcId",column="wx_wcId"),
            @Result(property="wxType",column="wx_type"),
            @Result(property="wxWid",column="wx_wid"),
            @Result(property="wxWAccount",column="wx_wAccount"),
            @Result(property="wxQrCodeUrl",column="wx_qrCodeUrl"),
            @Result(property="wxSmallHeadImgUrl",column="wx_smallHeadImgUrl"),
            @Result(property="dataJson",column="data_json"),
            @Result(property="orgName",column="org_name"),
            @Result(property="orgNo",column="org_no"),
            @Result(property="consId",column="cons_id"),
            @Result(property="consName",column="cons_name"),
            @Result(property="consNo",column="cons_no"),
            @Result(property="wxNickName",column="wx_nickName")
    })
    @Select("select * from t_user where 1=1 and (login_name like '%${t.loginName}%'  or #{t.loginName} is null  or #{t.loginName}='' ) and " +
            "(user_name like '%${t.userName}%' or #{t.userName}='' or #{t.userName} is null)   " +
            "and (phone like '%${t.phone}%'  or #{t.phone} is null or #{t.phone}='' ) and (WeChat like '%${t.WeChat}%'  or #{t.WeChat}='' or #{t.WeChat} is null)")
    List<Tuser> getListByTJ(@Param("t")Tuser tuser);
    @Results({@Result(property = "userId",column="user_id"),
            @Result(property="loginName",column="login_name"),
            @Result(property="loginPwd",column="login_pwd"),
            @Result(property="userName",column="user_name"),
            @Result(property="userImg",column="user_img"),
            @Result(property="loginIp",column="login_ip"),
            @Result(property="createrId",column="creater_id"),
            @Result(property="createrName",column="creater_name"),
            @Result(property="createrDate",column="creater_date"),
            @Result(property="wxLoginData",column="wx_login_data"),
            @Result(property="wxWcId",column="wx_wcId"),
            @Result(property="wxType",column="wx_type"),
            @Result(property="wxWid",column="wx_wid"),
            @Result(property="wxWAccount",column="wx_wAccount"),
            @Result(property="wxQrCodeUrl",column="wx_qrCodeUrl"),
            @Result(property="wxSmallHeadImgUrl",column="wx_smallHeadImgUrl"),
            @Result(property="dataJson",column="data_json"),
            @Result(property="orgName",column="org_name"),
            @Result(property="orgNo",column="org_no"),
            @Result(property="consId",column="cons_id"),
            @Result(property="consName",column="cons_name"),
            @Result(property="consNo",column="cons_no"),
            @Result(property="wxNickName",column="wx_nickName")
    })
    @Select("select * from t_user where login_name=#{uname}")
    Tuser getUserByName(String uname);
    @Results({@Result(property = "userId",column="user_id"),
            @Result(property="loginName",column="login_name"),
            @Result(property="loginPwd",column="login_pwd"),
            @Result(property="userName",column="user_name"),
            @Result(property="userImg",column="user_img"),
            @Result(property="loginIp",column="login_ip"),
            @Result(property="createrId",column="creater_id"),
            @Result(property="createrName",column="creater_name"),
            @Result(property="createrDate",column="creater_date"),
            @Result(property="wxLoginData",column="wx_login_data"),
            @Result(property="wxWcId",column="wx_wcId"),
            @Result(property="wxType",column="wx_type"),
            @Result(property="wxWid",column="wx_wid"),
            @Result(property="wxWAccount",column="wx_wAccount"),
            @Result(property="wxQrCodeUrl",column="wx_qrCodeUrl"),
            @Result(property="wxSmallHeadImgUrl",column="wx_smallHeadImgUrl"),
            @Result(property="dataJson",column="data_json"),
            @Result(property="orgName",column="org_name"),
            @Result(property="orgNo",column="org_no"),
            @Result(property="consId",column="cons_id"),
            @Result(property="consName",column="cons_name"),
            @Result(property="consNo",column="cons_no"),
            @Result(property="wxNickName",column="wx_nickName")
    })
    @Select("select * from t_user where login_name=#{uname} and login_pwd=#{pwd}")
    Tuser getUserByUP(String uname,String pwd);
    @Insert("insert into t_user  values(#{t.userId},#{t.loginName},#{t.loginPwd},#{t.userName},#{t.phone},#{t.sex}," +
            "#{t.WeChat},#{t.userImg},#{t.email},#{t.isDel},#{t.loginIp},#{t.createrId},#{t.createrName}," +
            "#{t.createrDate},#{t.isAdmin},#{t.wxLoginData},#{t.explain},#{t.wxWcId}," +
            "#{t.wxType},#{t.wxWid},#{t.wxQrCodeUrl},#{t.wxWAccount},#{t.wxSmallHeadImgUrl},#{t.dataJson}," +
            "#{t.orgNo},#{t.orgName},#{t.consId},#{t.consNo},#{t.consName})")
    void save(@Param("t") Tuser tuser);

    @Delete("delete from t_user where user_id=#{id}")
    void delOne(String uid);

    @Update("update t_user set login_name=#{t.loginName}," +
            "user_name=#{t.userName}," +
             "phone=#{t.phone}," +
            "sex=#{t.sex},"+ "email=#{t.email}" +
            "where user_id=#{t.userId}")
    void updateOne(@Param("t") Tuser tuser);

    @Update("update t_user set login_pwd=#{loginPwd}  where user_id=#{userId}")
    void updatePwd(String userId,String loginPwd);

    @Update("update t_user set wx_wid=#{wxWid}  where login_name=#{loginName}")
    void updateWid(Tuser tuser);
}
