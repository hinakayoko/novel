package com.service;

import java.util.List;

import com.util.PageBean;
import com.model.Bookshelf;

/**
 * 用户书架信息Service接口
 */
public interface BookshelfService {
    /**
     * 查询用户书架信息记录数
     *
     * @param bookshelf
     * @return
     */
    public int getCount(Bookshelf bookshelf);

    /**
     * 查询所有用户书架信息
     *
     * @return
     */
    public List<Bookshelf> queryBookshelfList(Bookshelf bookshelf, PageBean page) throws Exception;

    /**
     * 保存用户书架信息
     *
     * @param bookshelf
     * @return
     */
    public int insertBookshelf(Bookshelf bookshelf) throws Exception;

    /**
     * 删除用户书架信息
     *
     * @param id
     * @return
     */
    public int deleteBookshelf(int id) throws Exception;

    /**
     * 更新用户书架信息
     *
     * @param bookshelf
     * @return
     */
    public int updateBookshelf(Bookshelf bookshelf) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Bookshelf queryBookshelfById(int id) throws Exception;
}
