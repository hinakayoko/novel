package com.controller;

import com.model.Bookshelf;
import com.service.BookshelfService;
import com.util.PageBean;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.NoticeinfoService;
import com.model.Noticeinfo;
import com.service.UserinfoService;
import com.model.Userinfo;

/**
 * 用户书架信息Controller业务控制类
 */
@Controller
public class BookshelfController {
    /**
     * 注入Service
     */
    @Autowired
    private BookshelfService bookshelfService;
    @Autowired
    private NoticeinfoService noticeinfoService;
    @Autowired
    private UserinfoService userinfoService;

    /**
     * 用户书架信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookshelf_list")
    public String list(HttpServletRequest request) throws Exception {
        /**
         * 获取分页参数
         */
        int offset = 0;  //记录偏移量
        int counts = 0;  //总记录数
        try {
            offset = Integer.parseInt(request.getParameter("pager.offset"));
        } catch (Exception e) {
        }
        PageBean page = new PageBean(offset);
        Bookshelf bookshelf = new Bookshelf();
        String novelid = request.getParameter("novelid");
        bookshelf.setNovelid(Integer.parseInt(novelid == null || "".equals(novelid) ? "0" : novelid));
        request.setAttribute("novelid", novelid);
        String userid = request.getParameter("userid");
        bookshelf.setUserid(Integer.parseInt(userid == null || "".equals(userid) ? "0" : userid));
        request.setAttribute("userid", userid);
        //查询记录总数
        counts = bookshelfService.getCount(bookshelf);
        //获取当前页记录
        List bookshelfList = bookshelfService.queryBookshelfList(bookshelf, page);
        request.setAttribute("list", bookshelfList);
        Noticeinfo noticeinfoQuery = new Noticeinfo();
        List<Noticeinfo> noticeinfoList = noticeinfoService.queryNoticeinfoList(noticeinfoQuery, null);
        request.setAttribute("noticeinfoList", noticeinfoList);
        Userinfo userinfoQuery = new Userinfo();
        List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfoQuery, null);
        request.setAttribute("userinfoList", userinfoList);
        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/admin/bookshelf/bookshelf_list.jsp";
    }

    /**
     * 跳转到新增用户书架信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookshelf_toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        Noticeinfo noticeinfo = new Noticeinfo();
        List<Noticeinfo> noticeinfoList = noticeinfoService.queryNoticeinfoList(noticeinfo, null);
        request.setAttribute("noticeinfoList", noticeinfoList);
        Userinfo userinfo = new Userinfo();
        List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfo, null);
        request.setAttribute("userinfoList", userinfoList);
        return "/admin/bookshelf/bookshelf_add.jsp";
    }

    /**
     * 保存新增用户书架信息
     *
     * @param bookshelf
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookshelf_add")
    public String add(Bookshelf bookshelf, HttpServletRequest request) throws Exception {
        //保存到数据库
        bookshelfService.insertBookshelf(bookshelf);
        return "redirect:bookshelf_list.action";
    }

    /**
     * 跳转到更新用户书架信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookshelf_toUpdate")
    public String toUpdate(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出需要更新的记录
        Bookshelf bookshelf = bookshelfService.queryBookshelfById(id);
        request.setAttribute("bookshelf", bookshelf);
        Noticeinfo noticeinfo = new Noticeinfo();
        List<Noticeinfo> noticeinfoList = noticeinfoService.queryNoticeinfoList(noticeinfo, null);
        request.setAttribute("noticeinfoList", noticeinfoList);
        Userinfo userinfo = new Userinfo();
        List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfo, null);
        request.setAttribute("userinfoList", userinfoList);
        return "/admin/bookshelf/bookshelf_update.jsp";
    }

    /**
     * 更新用户书架信息
     *
     * @param bookshelf
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookshelf_update")
    public String update(Bookshelf bookshelf, HttpServletRequest request) throws Exception {
        //更新数据库
        bookshelfService.updateBookshelf(bookshelf);
        return "redirect:bookshelf_list.action";
    }

    /**
     * 删除用户书架信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookshelf_delete")
    public String delete(HttpServletRequest request) throws Exception {
        //根据id删除数据库记录
        int id = Integer.parseInt(request.getParameter("id"));
        bookshelfService.deleteBookshelf(id);
        return "redirect:bookshelf_list.action";
    }

    /**
     * 查看用户书架信息详情
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookshelf_toView")
    public String toView(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出记录放到request中，到前台jsp界面显示
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setId(id);
        List<Bookshelf> list = bookshelfService.queryBookshelfList(bookshelf, null);
        bookshelf = list.get(0);
        request.setAttribute("bookshelf", bookshelf);
        return "/admin/bookshelf/bookshelf_view.jsp";
    }
}
