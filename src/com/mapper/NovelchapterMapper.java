package com.mapper;

import com.model.Novelchapter;

import java.util.List;
import java.util.Map;

public interface NovelchapterMapper {
    /**
     * 查询所有小说章节信息
     *
     * @return
     */
    public List<Novelchapter> query(Map<String, Object> inputParam);

    /**
     * 查询小说章节信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存小说章节信息
     *
     * @param novelchapter
     * @return
     */
    public int insertNovelchapter(Novelchapter novelchapter);

    /**
     * 删除小说章节信息
     *
     * @param id
     * @return
     */
    public int deleteNovelchapter(int id);


    /**
     * 根据小说id 删除小说章节
     *
     * @param novelid 小说id
     * @return
     */
    public int deleteNovelchapterByNovelid(int novelid);


    /**
     * 更新小说章节信息
     *
     * @param novelchapter
     * @return
     */
    public int updateNovelchapter(Novelchapter novelchapter);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelchapter queryNovelchapterById(int id);
}
