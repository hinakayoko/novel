package com.service;

import java.util.List;

import com.model.Novelcomment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.NovelcommentMapper;

/**
 * 小说评论Service实现类
 */
@Service
public class NovelcommentServiceImpl implements NovelcommentService {
    /**
     * 注入mapper
     */
    @Autowired
    private NovelcommentMapper novelcommentMapper;

    /**
     * 查询小说评论记录数
     *
     * @param novelcomment
     * @return
     */
    public int getCount(Novelcomment novelcomment) {
        Map<String, Object> map = getQueryMap(novelcomment, null);
        return novelcommentMapper.getCount(map);
    }

    /**
     * 查询所有小说评论
     *
     * @return
     */
    public List<Novelcomment> queryNovelcommentList(Novelcomment novelcomment, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(novelcomment, page);
        List<Novelcomment> list = novelcommentMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param novelcomment
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Novelcomment novelcomment, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (novelcomment != null) {
            map.put("id", novelcomment.getId());
            map.put("novelid", novelcomment.getNovelid());
            map.put("userid", novelcomment.getUserid());
            map.put("commenttimeStart", novelcomment.getCommenttimeStart());
            map.put("commenttimeEnd", novelcomment.getCommenttimeEnd());
            map.put("name", novelcomment.getName());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存小说评论
     *
     * @param novelcomment
     * @return
     */
    public int insertNovelcomment(Novelcomment novelcomment) throws Exception {
        return novelcommentMapper.insertNovelcomment(novelcomment);
    }

    /**
     * 删除小说评论
     *
     * @param id
     * @return
     */
    public int deleteNovelcomment(int id) throws Exception {
        return novelcommentMapper.deleteNovelcomment(id);
    }

    /**
     * 更新小说评论
     *
     * @param novelcomment
     * @return
     */
    public int updateNovelcomment(Novelcomment novelcomment) throws Exception {
        return novelcommentMapper.updateNovelcomment(novelcomment);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelcomment queryNovelcommentById(int id) throws Exception {
        return novelcommentMapper.queryNovelcommentById(id);
    }
}
