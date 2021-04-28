package com.jyzw.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyzw.entity.Result;
import com.jyzw.entity.TNotice;
import com.jyzw.mapper.TNoticeMapper;
import com.jyzw.service.TNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TNoticeServiceImpl implements TNoticeService {
    @Autowired
    private TNoticeMapper tNoticeMapper;
    @Override
    public List<TNotice> getList() {
        return tNoticeMapper.getList();
    }

    @Override
    public TNotice getOne(String noticeId) {
        return tNoticeMapper.getOne(noticeId);
    }

    @Override
    public Result saveTNotice(TNotice tNotice) {
        try {
            tNoticeMapper.save(tNotice);
            return new Result(Result.sCode,"保存成功！",tNotice);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"保存失败！",tNotice);
        }
    }

    @Override
    public Result updateTNotice(TNotice tNotice) {
        try {
            tNoticeMapper.update(tNotice);
            return new Result(Result.sCode,"修改成功！",tNotice);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"修改失败",tNotice);
        }
    }

    @Override
    public Result delOne(String noticeId) {
       TNotice tNotice=tNoticeMapper.getOne(noticeId);
        try {
            tNoticeMapper.delOne(noticeId);
            return new Result(Result.sCode,"删除成功！",tNotice);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Result.fCode,"删除失败！",tNotice);
        }
    }

    @Override
    public PageInfo<TNotice> getPageList(Integer pageNum, Integer pageSize, TNotice tNotice) {
        PageHelper.startPage(pageNum,pageSize);
        List<TNotice>  list=tNoticeMapper.getTNList(tNotice);
        PageInfo<TNotice>  pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
