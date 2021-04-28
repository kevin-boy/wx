package com.jyzw.config;

import lombok.Data;

@Data
public class KYentity {
    private String addAllowedOrigin;
    private boolean allowCredentials;
    private String addAllowedHeader;
    private String addAllowedMethod;
}
