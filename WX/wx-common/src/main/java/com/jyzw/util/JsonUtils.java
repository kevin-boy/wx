package com.jyzw.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonUtils {

   /* public static final ObjectMapper mapper = new ObjectMapper();*/

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
         return   JSON.toJSONString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "序列化出错";
        }


    }

    public static <T> T toBean(String json, Class<T> tClass) {
        T t = null;
        try {
            t = JSON.parseObject(json, tClass);
            return  t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <E> List<E> toList(String json, Class<E> eClass) {
        try {
            List<E> es = JSON.parseArray(json, eClass);
            return es;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
/*
    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        JSONObject.
        return null;
    }

    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }*/
}
