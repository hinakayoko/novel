package com.service;

import java.util.List;

import com.model.Novelcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.NovelcategoryMapper;

/**
 * 小说分类信息Service实现类
 */
@Service
public class NovelcategoryServiceImpl implements NovelcategoryService {
    /**
     * 注入mapper
     */
    @Autowired
    private NovelcategoryMapper novelcategoryMapper;

    /**
     * 查询小说分类信息记录数
     *
     * @param novelcategory
     * @return
     */
    public int getCount(Novelcategory novelcategory) {
        Map<String, Object> map = getQueryMap(novelcategory, null);
        return novelcategoryMapper.getCount(map);
    }

    /**
     * 查询所有小说分类信息
     *
     * @return
     */
    public List<Novelcategory> queryNovelcategoryList(Novelcategory novelcategory, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(novelcategory, page);
        List<Novelcategory> list = novelcategoryMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param novelcategory
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Novelcategory novelcategory, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (novelcategory != null) {
            map.put("id", novelcategory.getId());
            map.put("name", novelcategory.getName());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存小说分类信息
     *
     * @param novelcategory
     * @return
     */
    public int insertNovelcategory(Novelcategory novelcategory) throws Exception {
        return novelcategoryMapper.insertNovelcategory(novelcategory);
    }

    /**
     * 删除小说分类信息
     *
     * @param id
     * @return
     */
    public int deleteNovelcategory(int id) throws Exception {
        return novelcategoryMapper.deleteNovelcategory(id);
    }

    /**
     * 更新小说分类信息
     *
     * @param novelcategory
     * @return
     */
    public int updateNovelcategory(Novelcategory novelcategory) throws Exception {
        return novelcategoryMapper.updateNovelcategory(novelcategory);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelcategory queryNovelcategoryById(int id) throws Exception {
        return novelcategoryMapper.queryNovelcategoryById(id);
    }
}
