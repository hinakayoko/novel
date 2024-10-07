package com.mapper;

import com.model.Novelcategory;

import java.util.List;
import java.util.Map;

public interface NovelcategoryMapper {
    /**
     * 查询所有小说分类信息
     *
     * @return
     */
    public List<Novelcategory> query(Map<String, Object> inputParam);

    /**
     * 查询小说分类信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存小说分类信息
     *
     * @param novelcategory
     * @return
     */
    public int insertNovelcategory(Novelcategory novelcategory);

    /**
     * 删除小说分类信息
     *
     * @param id
     * @return
     */
    public int deleteNovelcategory(int id);

    /**
     * 更新小说分类信息
     *
     * @param novelcategory
     * @return
     */
    public int updateNovelcategory(Novelcategory novelcategory);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelcategory queryNovelcategoryById(int id);
}
