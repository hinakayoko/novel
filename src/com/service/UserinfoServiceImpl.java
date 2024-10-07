package com.service;

import java.util.List;

import com.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.UserinfoMapper;

/**
 * 用户信息Service实现类
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {
    /**
     * 注入mapper
     */
    @Autowired
    private UserinfoMapper userinfoMapper;

    /**
     * 查询用户信息记录数
     *
     * @param userinfo
     * @return
     */
    public int getCount(Userinfo userinfo) {
        Map<String, Object> map = getQueryMap(userinfo, null);
        return userinfoMapper.getCount(map);
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<Userinfo> queryUserinfoList(Userinfo userinfo, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(userinfo, page);
        List<Userinfo> list = userinfoMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param userinfo
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Userinfo userinfo, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (userinfo != null) {
            map.put("id", userinfo.getId());
            map.put("tel", userinfo.getTel());
            map.put("pwd", userinfo.getPwd());
            map.put("nickname", userinfo.getNickname());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存用户信息
     *
     * @param userinfo
     * @return
     */
    public int insertUserinfo(Userinfo userinfo) throws Exception {
        return userinfoMapper.insertUserinfo(userinfo);
    }

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    public int deleteUserinfo(int id) throws Exception {
        return userinfoMapper.deleteUserinfo(id);
    }

    /**
     * 更新用户信息
     *
     * @param userinfo
     * @return
     */
    public int updateUserinfo(Userinfo userinfo) throws Exception {
        return userinfoMapper.updateUserinfo(userinfo);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Userinfo queryUserinfoById(int id) throws Exception {
        return userinfoMapper.queryUserinfoById(id);
    }
}
