package com.service;

import java.util.List;

import com.model.Swiperinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.SwiperinfoMapper;

/**
 * 轮播图信息Service实现类
 */
@Service
public class SwiperinfoServiceImpl implements SwiperinfoService {
    /**
     * 注入mapper
     */
    @Autowired
    private SwiperinfoMapper swiperinfoMapper;

    /**
     * 查询轮播图信息记录数
     *
     * @param swiperinfo
     * @return
     */
    public int getCount(Swiperinfo swiperinfo) {
        Map<String, Object> map = getQueryMap(swiperinfo, null);
        return swiperinfoMapper.getCount(map);
    }

    /**
     * 查询所有轮播图信息
     *
     * @return
     */
    public List<Swiperinfo> querySwiperinfoList(Swiperinfo swiperinfo, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(swiperinfo, page);
        List<Swiperinfo> list = swiperinfoMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param swiperinfo
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Swiperinfo swiperinfo, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (swiperinfo != null) {
            map.put("id", swiperinfo.getId());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存轮播图信息
     *
     * @param swiperinfo
     * @return
     */
    public int insertSwiperinfo(Swiperinfo swiperinfo) throws Exception {
        return swiperinfoMapper.insertSwiperinfo(swiperinfo);
    }

    /**
     * 删除轮播图信息
     *
     * @param id
     * @return
     */
    public int deleteSwiperinfo(int id) throws Exception {
        return swiperinfoMapper.deleteSwiperinfo(id);
    }

    /**
     * 更新轮播图信息
     *
     * @param swiperinfo
     * @return
     */
    public int updateSwiperinfo(Swiperinfo swiperinfo) throws Exception {
        return swiperinfoMapper.updateSwiperinfo(swiperinfo);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Swiperinfo querySwiperinfoById(int id) throws Exception {
        return swiperinfoMapper.querySwiperinfoById(id);
    }
}
