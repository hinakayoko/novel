package com.controller;

import com.model.Novelcomment;
import com.service.NovelcommentService;
import com.util.PageBean;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.NovelinfoService;
import com.model.Novelinfo;
import com.service.UserinfoService;
import com.model.Userinfo;

/**
 * 小说评论Controller业务控制类
 */
@Controller
public class NovelcommentController {
    /**
     * 注入Service
     */
    @Autowired
    private NovelcommentService novelcommentService;
    @Autowired
    private NovelinfoService novelinfoService;
    @Autowired
    private UserinfoService userinfoService;

    /**
     * 小说评论列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcomment_list")
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
        Novelcomment novelcomment = new Novelcomment();
        String name = request.getParameter("name");
        novelcomment.setName(name);
        request.setAttribute("name", name);

        String commenttimeStart = request.getParameter("commenttimeStart");
        String commenttimeEnd = request.getParameter("commenttimeEnd");
        novelcomment.setCommenttimeStart(commenttimeStart);
        novelcomment.setCommenttimeEnd(commenttimeEnd);
        request.setAttribute("commenttimeStart", commenttimeStart);
        request.setAttribute("commenttimeEnd", commenttimeEnd);
        //查询记录总数
        counts = novelcommentService.getCount(novelcomment);
        //获取当前页记录
        List novelcommentList = novelcommentService.queryNovelcommentList(novelcomment, page);
        request.setAttribute("list", novelcommentList);
        Novelinfo novelinfoQuery = new Novelinfo();
        List<Novelinfo> novelinfoList = novelinfoService.queryNovelinfoList(novelinfoQuery, null);
        request.setAttribute("novelinfoList", novelinfoList);
        Userinfo userinfoQuery = new Userinfo();
        List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfoQuery, null);
        request.setAttribute("userinfoList", userinfoList);
        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/admin/novelcomment/novelcomment_list.jsp";
    }

    /**
     * 跳转到新增小说评论界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcomment_toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        Novelinfo novelinfo = new Novelinfo();
        List<Novelinfo> novelinfoList = novelinfoService.queryNovelinfoList(novelinfo, null);
        request.setAttribute("novelinfoList", novelinfoList);
        Userinfo userinfo = new Userinfo();
        List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfo, null);
        request.setAttribute("userinfoList", userinfoList);
        return "/admin/novelcomment/novelcomment_add.jsp";
    }

    /**
     * 保存新增小说评论
     *
     * @param novelcomment
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcomment_add")
    public String add(Novelcomment novelcomment, HttpServletRequest request) throws Exception {
        //保存到数据库
        novelcommentService.insertNovelcomment(novelcomment);
        return "redirect:novelcomment_list.action";
    }

    /**
     * 跳转到更新小说评论界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcomment_toUpdate")
    public String toUpdate(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出需要更新的记录
        Novelcomment novelcomment = novelcommentService.queryNovelcommentById(id);
        request.setAttribute("novelcomment", novelcomment);
        Novelinfo novelinfo = new Novelinfo();
        List<Novelinfo> novelinfoList = novelinfoService.queryNovelinfoList(novelinfo, null);
        request.setAttribute("novelinfoList", novelinfoList);
        Userinfo userinfo = new Userinfo();
        List<Userinfo> userinfoList = userinfoService.queryUserinfoList(userinfo, null);
        request.setAttribute("userinfoList", userinfoList);
        return "/admin/novelcomment/novelcomment_update.jsp";
    }

    /**
     * 更新小说评论
     *
     * @param novelcomment
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcomment_update")
    public String update(Novelcomment novelcomment, HttpServletRequest request) throws Exception {
        //更新数据库
        novelcommentService.updateNovelcomment(novelcomment);
        return "redirect:novelcomment_list.action";
    }

    /**
     * 删除小说评论
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcomment_delete")
    public String delete(HttpServletRequest request) throws Exception {
        //根据id删除数据库记录
        int id = Integer.parseInt(request.getParameter("id"));
        novelcommentService.deleteNovelcomment(id);
        return "redirect:novelcomment_list.action";
    }

    /**
     * 查看小说评论详情
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcomment_toView")
    public String toView(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出记录放到request中，到前台jsp界面显示
        Novelcomment novelcomment = new Novelcomment();
        novelcomment.setId(id);
        List<Novelcomment> list = novelcommentService.queryNovelcommentList(novelcomment, null);
        novelcomment = list.get(0);
        request.setAttribute("novelcomment", novelcomment);
        return "/admin/novelcomment/novelcomment_view.jsp";
    }
}
