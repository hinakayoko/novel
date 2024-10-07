package com.service;

import java.util.List;

import com.model.Novelinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.NovelinfoMapper;

/**
 * 小说信息Service实现类
 */
@Service
public class NovelinfoServiceImpl implements NovelinfoService {
    /**
     * 注入mapper
     */
    @Autowired
    private NovelinfoMapper novelinfoMapper;

    /**
     * 查询小说信息记录数
     *
     * @param novelinfo
     * @return
     */
    public int getCount(Novelinfo novelinfo) {
        Map<String, Object> map = getQueryMap(novelinfo, null);
        return novelinfoMapper.getCount(map);
    }

    /**
     * 查询所有小说信息
     *
     * @return
     */
    public List<Novelinfo> queryNovelinfoList(Novelinfo novelinfo, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(novelinfo, page);
        List<Novelinfo> list = novelinfoMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param novelinfo
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Novelinfo novelinfo, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (novelinfo != null) {
            map.put("id", novelinfo.getId());
            map.put("name", novelinfo.getName());
            map.put("categoryid", novelinfo.getCategoryid());
            map.put("author", novelinfo.getAuthor());
            map.put("progress", novelinfo.getProgress());
            map.put("sorts", novelinfo.getSorts());
            map.put("keyword", novelinfo.getKeyword());

        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存小说信息
     *
     * @param novelinfo
     * @return
     */
    public int insertNovelinfo(Novelinfo novelinfo) throws Exception {
        return novelinfoMapper.insertNovelinfo(novelinfo);
    }

    /**
     * 删除小说信息
     *
     * @param id
     * @return
     */
    public int deleteNovelinfo(int id) throws Exception {
        return novelinfoMapper.deleteNovelinfo(id);
    }

    /**
     * 更新小说信息
     *
     * @param novelinfo
     * @return
     */
    public int updateNovelinfo(Novelinfo novelinfo) throws Exception {
        return novelinfoMapper.updateNovelinfo(novelinfo);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelinfo queryNovelinfoById(int id) throws Exception {
        return novelinfoMapper.queryNovelinfoById(id);
    }
}
