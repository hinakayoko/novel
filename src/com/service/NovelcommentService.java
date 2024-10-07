package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Novelcomment;

/**
 * 小说评论Service接口
 */
public interface NovelcommentService {
    /**
     * 查询小说评论记录数
     *
     * @param novelcomment
     * @return
     */
    public int getCount(Novelcomment novelcomment);

    /**
     * 查询所有小说评论
     *
     * @return
     */
    public List<Novelcomment> queryNovelcommentList(Novelcomment novelcomment, PageBean page) throws Exception;

    /**
     * 保存小说评论
     *
     * @param novelcomment
     * @return
     */
    public int insertNovelcomment(Novelcomment novelcomment) throws Exception;

    /**
     * 删除小说评论
     *
     * @param id
     * @return
     */
    public int deleteNovelcomment(int id) throws Exception;

    /**
     * 更新小说评论
     *
     * @param novelcomment
     * @return
     */
    public int updateNovelcomment(Novelcomment novelcomment) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelcomment queryNovelcommentById(int id) throws Exception;
}
