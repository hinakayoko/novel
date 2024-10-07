package com.mapper;

import com.model.Bookshelf;

import java.util.List;
import java.util.Map;

public interface BookshelfMapper {
    /**
     * 查询所有用户书架信息
     *
     * @return
     */
    public List<Bookshelf> query(Map<String, Object> inputParam);

    /**
     * 查询用户书架信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存用户书架信息
     *
     * @param bookshelf
     * @return
     */
    public int insertBookshelf(Bookshelf bookshelf);

    /**
     * 删除用户书架信息
     *
     * @param id
     * @return
     */
    public int deleteBookshelf(int id);

    /**
     * 更新用户书架信息
     *
     * @param bookshelf
     * @return
     */
    public int updateBookshelf(Bookshelf bookshelf);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Bookshelf queryBookshelfById(int id);
}
