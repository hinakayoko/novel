package com.service;

import java.util.List;

import com.model.Bookshelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import com.util.PageBean;

import java.util.Map;

import com.mapper.BookshelfMapper;

/**
 * 用户书架信息Service实现类
 */
@Service
public class BookshelfServiceImpl implements BookshelfService {
    /**
     * 注入mapper
     */
    @Autowired
    private BookshelfMapper bookshelfMapper;

    /**
     * 查询用户书架信息记录数
     *
     * @param bookshelf
     * @return
     */
    public int getCount(Bookshelf bookshelf) {
        Map<String, Object> map = getQueryMap(bookshelf, null);
        return bookshelfMapper.getCount(map);
    }

    /**
     * 查询所有用户书架信息
     *
     * @return
     */
    public List<Bookshelf> queryBookshelfList(Bookshelf bookshelf, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(bookshelf, page);
        List<Bookshelf> list = bookshelfMapper.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param bookshelf
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Bookshelf bookshelf, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bookshelf != null) {
            map.put("id", bookshelf.getId());
            map.put("novelid", bookshelf.getNovelid());
            map.put("userid", bookshelf.getUserid());
            map.put("progress", bookshelf.getProgress());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存用户书架信息
     *
     * @param bookshelf
     * @return
     */
    public int insertBookshelf(Bookshelf bookshelf) throws Exception {
        return bookshelfMapper.insertBookshelf(bookshelf);
    }

    /**
     * 删除用户书架信息
     *
     * @param id
     * @return
     */
    public int deleteBookshelf(int id) throws Exception {
        return bookshelfMapper.deleteBookshelf(id);
    }

    /**
     * 更新用户书架信息
     *
     * @param bookshelf
     * @return
     */
    public int updateBookshelf(Bookshelf bookshelf) throws Exception {
        return bookshelfMapper.updateBookshelf(bookshelf);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Bookshelf queryBookshelfById(int id) throws Exception {
        return bookshelfMapper.queryBookshelfById(id);
    }
}
