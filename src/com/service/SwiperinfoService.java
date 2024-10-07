package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Swiperinfo;

/**
 * 轮播图信息Service接口
 */
public interface SwiperinfoService {
    /**
     * 查询轮播图信息记录数
     *
     * @param swiperinfo
     * @return
     */
    public int getCount(Swiperinfo swiperinfo);

    /**
     * 查询所有轮播图信息
     *
     * @return
     */
    public List<Swiperinfo> querySwiperinfoList(Swiperinfo swiperinfo, PageBean page) throws Exception;

    /**
     * 保存轮播图信息
     *
     * @param swiperinfo
     * @return
     */
    public int insertSwiperinfo(Swiperinfo swiperinfo) throws Exception;

    /**
     * 删除轮播图信息
     *
     * @param id
     * @return
     */
    public int deleteSwiperinfo(int id) throws Exception;

    /**
     * 更新轮播图信息
     *
     * @param swiperinfo
     * @return
     */
    public int updateSwiperinfo(Swiperinfo swiperinfo) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Swiperinfo querySwiperinfoById(int id) throws Exception;
}
