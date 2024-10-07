package com.mapper;

import com.model.Novelcomment;

import java.util.List;
import java.util.Map;

public interface NovelcommentMapper {
    /**
     * 查询所有小说评论
     *
     * @return
     */
    public List<Novelcomment> query(Map<String, Object> inputParam);

    /**
     * 查询小说评论记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存小说评论
     *
     * @param novelcomment
     * @return
     */
    public int insertNovelcomment(Novelcomment novelcomment);

    /**
     * 删除小说评论
     *
     * @param id
     * @return
     */
    public int deleteNovelcomment(int id);

    /**
     * 更新小说评论
     *
     * @param novelcomment
     * @return
     */
    public int updateNovelcomment(Novelcomment novelcomment);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelcomment queryNovelcommentById(int id);
}
