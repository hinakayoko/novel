package com.mapper;

import com.model.Noticeinfo;

import java.util.List;
import java.util.Map;

public interface NoticeinfoMapper {
    /**
     * 查询所有网站公告
     *
     * @return
     */
    public List<Noticeinfo> query(Map<String, Object> inputParam);

    /**
     * 查询网站公告记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存网站公告
     *
     * @param noticeinfo
     * @return
     */
    public int insertNoticeinfo(Noticeinfo noticeinfo);

    /**
     * 删除网站公告
     *
     * @param id
     * @return
     */
    public int deleteNoticeinfo(int id);

    /**
     * 更新网站公告
     *
     * @param noticeinfo
     * @return
     */
    public int updateNoticeinfo(Noticeinfo noticeinfo);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Noticeinfo queryNoticeinfoById(int id);
}
