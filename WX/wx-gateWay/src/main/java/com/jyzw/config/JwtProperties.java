package com.jyzw.config;

import com.jyzw.util.RsaUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.PublicKey;
@Data
@Slf4j
/*@ConfigurationProperties(prefix = "auth.jwt")*/
public class JwtProperties implements InitializingBean {
    private String pubKeyPath;
    private PublicKey publicKey;
    private UserTokenproperties user=new UserTokenproperties();
    @Data
    public class UserTokenproperties{
        private String cookieName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            this.publicKey= RsaUtils.getPublicKey(pubKeyPath);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取公钥失败！",e);
        }
    }
}
