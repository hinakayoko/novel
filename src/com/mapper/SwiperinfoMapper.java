package com.mapper;

import com.model.Swiperinfo;

import java.util.List;
import java.util.Map;

public interface SwiperinfoMapper {
    /**
     * 查询所有轮播图信息
     *
     * @return
     */
    public List<Swiperinfo> query(Map<String, Object> inputParam);

    /**
     * 查询轮播图信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存轮播图信息
     *
     * @param swiperinfo
     * @return
     */
    public int insertSwiperinfo(Swiperinfo swiperinfo);

    /**
     * 删除轮播图信息
     *
     * @param id
     * @return
     */
    public int deleteSwiperinfo(int id);

    /**
     * 更新轮播图信息
     *
     * @param swiperinfo
     * @return
     */
    public int updateSwiperinfo(Swiperinfo swiperinfo);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Swiperinfo querySwiperinfoById(int id);
}
