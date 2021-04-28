package com.jyzw.config;

import com.jyzw.util.RsaUtils;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.security.PrivateKey;
import java.security.PublicKey;

@Data
@ConfigurationProperties(prefix="auth.jwt")
public class JwtProperties implements InitializingBean {

    private String pubKeyPath;
    private String  priKeyPath;
    private PublicKey publicKey;
    private PrivateKey privateKey;
  UserTokenproperties user=new UserTokenproperties();
    @Override
    public void afterPropertiesSet() throws Exception {
    this.publicKey= RsaUtils.getPublicKey(pubKeyPath);
    this.privateKey=RsaUtils.getPrivateKey(priKeyPath);
    }
}
