package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TOorg;
import com.jyzw.mapper.TOorgMapper;
import com.jyzw.service.TOorgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TOorgServiceImpl implements TOorgService {
   @Autowired
   private TOorgMapper tOorgMapper;
    @Override
    public List<TOorg> getList() {
        return tOorgMapper.getList();
    }

    @Override
    public Result saveOne(TOorg tOorg) {
        try {
            tOorgMapper.saveOne(tOorg);
            return new Result(Result.sCode,"保存成功！",tOorg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",tOorg);
        }

    }

    @Override
    public Result updateOne(TOorg tOorg) {
        try {
            tOorgMapper.updateOne(tOorg);
            return new Result(Result.sCode,"修改成功！",tOorg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败！",tOorg);
        }
    }

    @Override
    public TOorg getOne(String orgNo) {
        return tOorgMapper.getOne(orgNo);
    }

    @Override
    public Result  delOne(String orgNo) {
            TOorg tOorg=tOorgMapper.getOne(orgNo);
        try {
            tOorgMapper.delOne(orgNo);
            return new Result(Result.sCode,"删除成功！",tOorg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败！",tOorg);
        }
    }

    @Override
    public PageInfo<TOorg> getPageInfo(Integer page, Integer size, TOorg tOorg) {
        PageHelper.startPage(page,size);
        List<TOorg> list=tOorgMapper.getTOList(tOorg);
        PageInfo<TOorg> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
