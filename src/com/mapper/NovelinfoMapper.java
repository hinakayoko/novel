package com.mapper;

import com.model.Novelinfo;

import java.util.List;
import java.util.Map;

public interface NovelinfoMapper {
    /**
     * 查询所有小说信息
     *
     * @return
     */
    public List<Novelinfo> query(Map<String, Object> inputParam);

    /**
     * 查询小说信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存小说信息
     *
     * @param novelinfo
     * @return
     */
    public int insertNovelinfo(Novelinfo novelinfo);

    /**
     * 删除小说信息
     *
     * @param id
     * @return
     */
    public int deleteNovelinfo(int id);

    /**
     * 更新小说信息
     *
     * @param novelinfo
     * @return
     */
    public int updateNovelinfo(Novelinfo novelinfo);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Novelinfo queryNovelinfoById(int id);
}
