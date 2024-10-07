package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Noticeinfo;

/**
 * 网站公告Service接口
 */
public interface NoticeinfoService {
    /**
     * 查询网站公告记录数
     *
     * @param noticeinfo
     * @return
     */
    public int getCount(Noticeinfo noticeinfo);

    /**
     * 查询所有网站公告
     *
     * @return
     */
    public List<Noticeinfo> queryNoticeinfoList(Noticeinfo noticeinfo, PageBean page) throws Exception;

    /**
     * 保存网站公告
     *
     * @param noticeinfo
     * @return
     */
    public int insertNoticeinfo(Noticeinfo noticeinfo) throws Exception;

    /**
     * 删除网站公告
     *
     * @param id
     * @return
     */
    public int deleteNoticeinfo(int id) throws Exception;

    /**
     * 更新网站公告
     *
     * @param noticeinfo
     * @return
     */
    public int updateNoticeinfo(Noticeinfo noticeinfo) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Noticeinfo queryNoticeinfoById(int id) throws Exception;
}
