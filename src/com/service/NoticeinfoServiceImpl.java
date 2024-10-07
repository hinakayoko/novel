package com.service;

import java.util.List;

import com.model.Noticeinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.NoticeinfoMapper;

/**
 * 网站公告Service实现类
 */
@Service
public class NoticeinfoServiceImpl implements NoticeinfoService {
    /**
     * 注入mapper
     */
    @Autowired
    private NoticeinfoMapper noticeinfoMapper;

    /**
     * 查询网站公告记录数
     *
     * @param noticeinfo
     * @return
     */
    public int getCount(Noticeinfo noticeinfo) {
        Map<String, Object> map = getQueryMap(noticeinfo, null);
        return noticeinfoMapper.getCount(map);
    }

    /**
     * 查询所有网站公告
     *
     * @return
     */
    public List<Noticeinfo> queryNoticeinfoList(Noticeinfo noticeinfo, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(noticeinfo, page);
        List<Noticeinfo> list = noticeinfoMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param noticeinfo
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Noticeinfo noticeinfo, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (noticeinfo != null) {
            map.put("id", noticeinfo.getId());
            map.put("title", noticeinfo.getTitle());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存网站公告
     *
     * @param noticeinfo
     * @return
     */
    public int insertNoticeinfo(Noticeinfo noticeinfo) throws Exception {
        return noticeinfoMapper.insertNoticeinfo(noticeinfo);
    }

    /**
     * 删除网站公告
     *
     * @param id
     * @return
     */
    public int deleteNoticeinfo(int id) throws Exception {
        return noticeinfoMapper.deleteNoticeinfo(id);
    }

    /**
     * 更新网站公告
     *
     * @param noticeinfo
     * @return
     */
    public int updateNoticeinfo(Noticeinfo noticeinfo) throws Exception {
        return noticeinfoMapper.updateNoticeinfo(noticeinfo);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Noticeinfo queryNoticeinfoById(int id) throws Exception {
        return noticeinfoMapper.queryNoticeinfoById(id);
    }
}
