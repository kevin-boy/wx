package com.jyzw.web;

import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TMenu;
import com.jyzw.service.TMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="menu",method={RequestMethod.GET,RequestMethod.POST})
public class TMenuController {
    @Autowired
    private TMenuService tMenuService;

    /**
     * 根据父级id查询子菜单
     *
     * @param menuId
     * @return
     */
    @RequestMapping("getOne")
    public List<TMenu> getOne(String menuId) {
        List<TMenu> one = tMenuService.getOne(menuId);
        return one;
    }

    /**
     * 根据菜单id删除菜单
     *
     * @param menuId
     * @return
     */
    @GetMapping("delOne")
    public Result  delOne(String menuId) {
        Result resultInfo = tMenuService.delOne(menuId);
        return resultInfo;
    }

    /**
     * 根据菜单id修改菜单
     *
     * @param tMenu
     * @return
     */
    @PostMapping("updateOne")
    public Result updateOne(TMenu tMenu) {
        return tMenuService.updateOne(tMenu);
    }

    /**
     * 保存菜单信息
     *
     * @param tMenu
     * @return
     */
    @PostMapping("saveOne")
    public Result save(TMenu tMenu) {
        return tMenuService.saveOne(tMenu);
    }

    /**
     * 根据排序和等级进行父子菜单查询
     *
     * @return
     */
    @GetMapping("getMenulist")
    public List<TMenu> getML() {
        return tMenuService.getMenuList();
    }

    @GetMapping("getOneCd")
    public TMenu getOneCd(String menuId) {
        return tMenuService.getOneCd(menuId);
    }

    @GetMapping("getPageList")
    public PageInfo<TMenu> getPageList(Integer pageNum,Integer pageSize,TMenu menu){
        return tMenuService.getMenuPage(pageNum,pageSize,menu);
    }
}
