package com.jyzw.config;

import lombok.Data;

@Data
public class UserTokenproperties {
    private int expire;
    private String cookieName;
    private int minRefreshInterval;
   /* private String cookieDomain;*/
}
