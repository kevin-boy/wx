package com.jyzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TMenu {
    private String menuId;
    private String menuName;
    private String level;
    private String link;
    private String pid;
    private Integer grade;
    private String icon;
    private String isDel;
    private String  createrDate;
    private String explain;

    @Override
    public String toString() {
        return "TMenu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", level='" + level + '\'' +
                ", link='" + link + '\'' +
                ", pid='" + pid + '\'' +
                ", grade=" + grade +
                ", icon='" + icon + '\'' +
                ", isDel='" + isDel + '\'' +
                ", createrDate='" + createrDate + '\'' +
                ", explain='" + explain + '\'' +
                '}';
    }
}
