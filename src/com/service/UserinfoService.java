package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Userinfo;

/**
 * 用户信息Service接口
 */
public interface UserinfoService {
    /**
     * 查询用户信息记录数
     *
     * @param userinfo
     * @return
     */
    public int getCount(Userinfo userinfo);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<Userinfo> queryUserinfoList(Userinfo userinfo, PageBean page) throws Exception;

    /**
     * 保存用户信息
     *
     * @param userinfo
     * @return
     */
    public int insertUserinfo(Userinfo userinfo) throws Exception;

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    public int deleteUserinfo(int id) throws Exception;

    /**
     * 更新用户信息
     *
     * @param userinfo
     * @return
     */
    public int updateUserinfo(Userinfo userinfo) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Userinfo queryUserinfoById(int id) throws Exception;
}
