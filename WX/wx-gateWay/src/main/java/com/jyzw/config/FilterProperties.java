package com.jyzw.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
/*@ConfigurationProperties(prefix="wx.filter")*/
public class FilterProperties {
    private List<String> allowedPath;
}
