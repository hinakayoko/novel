package com.mapper;

import com.model.Userinfo;

import java.util.List;
import java.util.Map;

public interface UserinfoMapper {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<Userinfo> query(Map<String, Object> inputParam);

    /**
     * 查询用户信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存用户信息
     *
     * @param userinfo
     * @return
     */
    public int insertUserinfo(Userinfo userinfo);

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    public int deleteUserinfo(int id);

    /**
     * 更新用户信息
     *
     * @param userinfo
     * @return
     */
    public int updateUserinfo(Userinfo userinfo);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Userinfo queryUserinfoById(int id);
}
