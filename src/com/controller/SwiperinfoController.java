package com.controller;

import com.model.Swiperinfo;
import com.service.SwiperinfoService;
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

/**
 * 轮播图信息Controller业务控制类
 */
@Controller
public class SwiperinfoController {
    /**
     * 注入Service
     */
    @Autowired
    private SwiperinfoService swiperinfoService;
    @Autowired
    private NovelinfoService novelinfoService;

    /**
     * 轮播图信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/swiperinfo_list")
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
        Swiperinfo swiperinfo = new Swiperinfo();
        //查询记录总数
        counts = swiperinfoService.getCount(swiperinfo);
        //获取当前页记录
        List swiperinfoList = swiperinfoService.querySwiperinfoList(swiperinfo, page);
        request.setAttribute("list", swiperinfoList);
        Novelinfo novelinfoQuery = new Novelinfo();
        List<Novelinfo> novelinfoList = novelinfoService.queryNovelinfoList(novelinfoQuery, null);
        request.setAttribute("novelinfoList", novelinfoList);
        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/admin/swiperinfo/swiperinfo_list.jsp";
    }

    /**
     * 跳转到新增轮播图信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/swiperinfo_toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        Novelinfo novelinfo = new Novelinfo();
        List<Novelinfo> novelinfoList = novelinfoService.queryNovelinfoList(novelinfo, null);
        request.setAttribute("novelinfoList", novelinfoList);
        return "/admin/swiperinfo/swiperinfo_add.jsp";
    }

    /**
     * 保存新增轮播图信息
     *
     * @param swiperinfo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/swiperinfo_add")
    public String add(Swiperinfo swiperinfo, HttpServletRequest request) throws Exception {
        //保存到数据库
        swiperinfoService.insertSwiperinfo(swiperinfo);
        return "redirect:swiperinfo_list.action";
    }

    /**
     * 跳转到更新轮播图信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/swiperinfo_toUpdate")
    public String toUpdate(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出需要更新的记录
        Swiperinfo swiperinfo = swiperinfoService.querySwiperinfoById(id);
        request.setAttribute("swiperinfo", swiperinfo);
        Novelinfo novelinfo = new Novelinfo();
        List<Novelinfo> novelinfoList = novelinfoService.queryNovelinfoList(novelinfo, null);
        request.setAttribute("novelinfoList", novelinfoList);
        return "/admin/swiperinfo/swiperinfo_update.jsp";
    }

    /**
     * 更新轮播图信息
     *
     * @param swiperinfo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/swiperinfo_update")
    public String update(Swiperinfo swiperinfo, HttpServletRequest request) throws Exception {
        //更新数据库
        swiperinfoService.updateSwiperinfo(swiperinfo);
        return "redirect:swiperinfo_list.action";
    }

    /**
     * 删除轮播图信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/swiperinfo_delete")
    public String delete(HttpServletRequest request) throws Exception {
        //根据id删除数据库记录
        int id = Integer.parseInt(request.getParameter("id"));
        swiperinfoService.deleteSwiperinfo(id);
        return "redirect:swiperinfo_list.action";
    }

    /**
     * 查看轮播图信息详情
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/swiperinfo_toView")
    public String toView(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出记录放到request中，到前台jsp界面显示
        Swiperinfo swiperinfo = new Swiperinfo();
        swiperinfo.setId(id);
        List<Swiperinfo> list = swiperinfoService.querySwiperinfoList(swiperinfo, null);
        swiperinfo = list.get(0);
        request.setAttribute("swiperinfo", swiperinfo);
        return "/admin/swiperinfo/swiperinfo_view.jsp";
    }
}
