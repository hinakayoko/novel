package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Novelchapter;

/**
 * 小说章节信息Service接口
 */
public interface NovelchapterService {
    /**
     * 查询小说章节信息记录数
     *
     * @param novelchapter
     * @return
     */
    public int getCount(Novelchapter novelchapter);

    /**
     * 查询所有小说章节信息
     *
     * @return
     */
    public List<Novelchapter> queryNovelchapterList(Novelchapter novelchapter, PageBean page) throws Exception;

    /**
     * 保存小说章节信息
     *
     * @param novelchapter
     * @return
     */
    public int insertNovelchapter(Novelchapter novelchapter) throws Exception;

    /**
     * 删除小说章节信息
     *
     * @param id
     * @return
     */
    public int deleteNovelchapter(int id) throws Exception;

    /**
     * 根据小说id 删除小说章节
     *
     * @param novelid 小说id
     * @return
     */
    public int deleteNovelchapterByNovelid(int novelid) throws Exception;

    /**
     * 更新小说章节信息
     *
     * @param novelchapter
     * @return
     */
    public int updateNovelchapter(Novelchapter novelchapter) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelchapter queryNovelchapterById(int id) throws Exception;
}
