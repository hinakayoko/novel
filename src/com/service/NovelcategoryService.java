package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Novelcategory;

/**
 * 小说分类信息Service接口
 */
public interface NovelcategoryService {
    /**
     * 查询小说分类信息记录数
     *
     * @param novelcategory
     * @return
     */
    public int getCount(Novelcategory novelcategory);

    /**
     * 查询所有小说分类信息
     *
     * @return
     */
    public List<Novelcategory> queryNovelcategoryList(Novelcategory novelcategory, PageBean page) throws Exception;

    /**
     * 保存小说分类信息
     *
     * @param novelcategory
     * @return
     */
    public int insertNovelcategory(Novelcategory novelcategory) throws Exception;

    /**
     * 删除小说分类信息
     *
     * @param id
     * @return
     */
    public int deleteNovelcategory(int id) throws Exception;

    /**
     * 更新小说分类信息
     *
     * @param novelcategory
     * @return
     */
    public int updateNovelcategory(Novelcategory novelcategory) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelcategory queryNovelcategoryById(int id) throws Exception;
}
