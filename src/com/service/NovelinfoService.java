package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Novelinfo;

/**
 * 小说信息Service接口
 */
public interface NovelinfoService {
    /**
     * 查询小说信息记录数
     *
     * @param novelinfo
     * @return
     */
    public int getCount(Novelinfo novelinfo);

    /**
     * 查询所有小说信息
     *
     * @return
     */
    public List<Novelinfo> queryNovelinfoList(Novelinfo novelinfo, PageBean page) throws Exception;

    /**
     * 保存小说信息
     *
     * @param novelinfo
     * @return
     */
    public int insertNovelinfo(Novelinfo novelinfo) throws Exception;

    /**
     * 删除小说信息
     *
     * @param id
     * @return
     */
    public int deleteNovelinfo(int id) throws Exception;

    /**
     * 更新小说信息
     *
     * @param novelinfo
     * @return
     */
    public int updateNovelinfo(Novelinfo novelinfo) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelinfo queryNovelinfoById(int id) throws Exception;
}
