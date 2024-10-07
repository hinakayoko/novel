package com.service;

import java.util.List;

import com.model.Novelchapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.NovelchapterMapper;

/**
 * 小说章节信息Service实现类
 */
@Service
public class NovelchapterServiceImpl implements NovelchapterService {
    /**
     * 注入mapper
     */
    @Autowired
    private NovelchapterMapper novelchapterMapper;

    /**
     * 查询小说章节信息记录数
     *
     * @param novelchapter
     * @return
     */
    public int getCount(Novelchapter novelchapter) {
        Map<String, Object> map = getQueryMap(novelchapter, null);
        return novelchapterMapper.getCount(map);
    }

    /**
     * 查询所有小说章节信息
     *
     * @return
     */
    public List<Novelchapter> queryNovelchapterList(Novelchapter novelchapter, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(novelchapter, page);
        List<Novelchapter> list = novelchapterMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param novelchapter
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Novelchapter novelchapter, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (novelchapter != null) {
            map.put("id", novelchapter.getId());
            map.put("novelid", novelchapter.getNovelid());
            map.put("title", novelchapter.getTitle());
            map.put("sorts", novelchapter.getSorts());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存小说章节信息
     *
     * @param novelchapter
     * @return
     */
    public int insertNovelchapter(Novelchapter novelchapter) throws Exception {
        return novelchapterMapper.insertNovelchapter(novelchapter);
    }

    /**
     * 删除小说章节信息
     *
     * @param id
     * @return
     */
    public int deleteNovelchapter(int id) throws Exception {
        return novelchapterMapper.deleteNovelchapter(id);
    }


    /**
     * 根据小说id 删除小说章节
     *
     * @param novelid 小说id
     * @return
     */
    public int deleteNovelchapterByNovelid(int novelid) {
        return novelchapterMapper.deleteNovelchapterByNovelid(novelid);
    }


    /**
     * 更新小说章节信息
     *
     * @param novelchapter
     * @return
     */
    public int updateNovelchapter(Novelchapter novelchapter) throws Exception {
        return novelchapterMapper.updateNovelchapter(novelchapter);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelchapter queryNovelchapterById(int id) throws Exception {
        return novelchapterMapper.queryNovelchapterById(id);
    }
}
