package com.controller;

import com.model.Noticeinfo;
import com.service.NoticeinfoService;
import com.util.PageBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 网站公告Controller业务控制类
 */
@Controller
public class NoticeinfoController {
    /**
     * 注入Service
     */
    @Autowired
    private NoticeinfoService noticeinfoService;

    /**
     * 网站公告列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/noticeinfo_list")
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
        Noticeinfo noticeinfo = new Noticeinfo();
        String title = request.getParameter("title");
        noticeinfo.setTitle(title);
        request.setAttribute("title", title);
        //查询记录总数
        counts = noticeinfoService.getCount(noticeinfo);
        //获取当前页记录
        List noticeinfoList = noticeinfoService.queryNoticeinfoList(noticeinfo, page);
        request.setAttribute("list", noticeinfoList);
        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/admin/noticeinfo/noticeinfo_list.jsp";
    }

    /**
     * 跳转到新增网站公告界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/noticeinfo_toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {

        return "/admin/noticeinfo/noticeinfo_add.jsp";
    }

    /**
     * 保存新增网站公告
     *
     * @param noticeinfo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/noticeinfo_add")
    public String add(Noticeinfo noticeinfo, HttpServletRequest request) throws Exception {
        noticeinfo.setUpdatetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //保存到数据库
        noticeinfoService.insertNoticeinfo(noticeinfo);
        return "redirect:noticeinfo_list.action";
    }

    /**
     * 跳转到更新网站公告界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/noticeinfo_toUpdate")
    public String toUpdate(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出需要更新的记录
        Noticeinfo noticeinfo = noticeinfoService.queryNoticeinfoById(id);
        request.setAttribute("noticeinfo", noticeinfo);
        return "/admin/noticeinfo/noticeinfo_update.jsp";
    }

    /**
     * 更新网站公告
     *
     * @param noticeinfo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/noticeinfo_update")
    public String update(Noticeinfo noticeinfo, HttpServletRequest request) throws Exception {
        noticeinfo.setUpdatetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //更新数据库
        noticeinfoService.updateNoticeinfo(noticeinfo);
        return "redirect:noticeinfo_list.action";
    }

    /**
     * 删除网站公告
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/noticeinfo_delete")
    public String delete(HttpServletRequest request) throws Exception {
        //根据id删除数据库记录
        int id = Integer.parseInt(request.getParameter("id"));
        noticeinfoService.deleteNoticeinfo(id);
        return "redirect:noticeinfo_list.action";
    }

    /**
     * 查看网站公告详情
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/noticeinfo_toView")
    public String toView(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出记录放到request中，到前台jsp界面显示
        Noticeinfo noticeinfo = noticeinfoService.queryNoticeinfoById(id);
        request.setAttribute("noticeinfo", noticeinfo);
        return "/admin/noticeinfo/noticeinfo_view.jsp";
    }
}
