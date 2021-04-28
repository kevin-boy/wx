package com.jyzw.util;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
public static Date converter(String time){
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
        Date parse1 = sdf.parse(time);
        return parse1;
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return new Date();
}
}
