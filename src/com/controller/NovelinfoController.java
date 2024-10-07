package com.controller;

import com.model.Novelchapter;
import com.model.Novelinfo;
import com.service.NovelchapterService;
import com.service.NovelinfoService;
import com.util.CrawlingDataUtils;
import com.util.PageBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.NovelcategoryService;
import com.model.Novelcategory;

/**
 * 小说信息Controller业务控制类
 */
@Controller
public class NovelinfoController {
    /**
     * 注入Service
     */
    @Autowired
    private NovelinfoService novelinfoService;
    @Autowired
    private NovelcategoryService novelcategoryService;
    @Autowired
    private NovelchapterService novelchapterService;

    /**
     * 小说信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelinfo_list")
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
        Novelinfo novelinfo = new Novelinfo();
        String name = request.getParameter("name");
        novelinfo.setName(name);
        request.setAttribute("name", name);
        String categoryid = request.getParameter("categoryid");
        novelinfo.setCategoryid(Integer.parseInt(categoryid == null || "".equals(categoryid) ? "0" : categoryid));
        request.setAttribute("categoryid", categoryid);
        String author = request.getParameter("author");
        novelinfo.setAuthor(author);
        request.setAttribute("author", author);
        String progress = request.getParameter("progress");
        novelinfo.setProgress(Integer.parseInt(progress == null || "".equals(progress) ? "0" : progress));
        request.setAttribute("progress", progress);
        //查询记录总数
        counts = novelinfoService.getCount(novelinfo);
        //获取当前页记录
        List<Novelinfo> novelinfoList = novelinfoService.queryNovelinfoList(novelinfo, page);
        request.setAttribute("list", novelinfoList);
        Novelcategory novelcategoryQuery = new Novelcategory();
        List<Novelcategory> novelcategoryList = novelcategoryService.queryNovelcategoryList(novelcategoryQuery, null);
        request.setAttribute("novelcategoryList", novelcategoryList);
        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/admin/novelinfo/novelinfo_list.jsp";
    }

    /**
     * 跳转到新增小说信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelinfo_toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        Novelcategory novelcategory = new Novelcategory();
        List<Novelcategory> novelcategoryList = novelcategoryService.queryNovelcategoryList(novelcategory, null);
        request.setAttribute("novelcategoryList", novelcategoryList);
        return "/admin/novelinfo/novelinfo_add.jsp";
    }

    /**
     * 保存新增小说信息
     *
     * @param novelinfo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelinfo_add")
    public String add(Novelinfo novelinfo, HttpServletRequest request) throws Exception {
        novelinfo.setFavcount(0);
        novelinfo.setUpdatetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        novelinfo.setViewcount(0);
        novelinfo.setWordsnum(0);
        //保存到数据库
        novelinfoService.insertNovelinfo(novelinfo);
        return "redirect:novelinfo_list.action";
    }

    /**
     * 跳转到更新小说信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelinfo_toUpdate")
    public String toUpdate(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出需要更新的记录
        Novelinfo novelinfo = novelinfoService.queryNovelinfoById(id);
        request.setAttribute("novelinfo", novelinfo);
        Novelcategory novelcategory = new Novelcategory();
        List<Novelcategory> novelcategoryList = novelcategoryService.queryNovelcategoryList(novelcategory, null);
        request.setAttribute("novelcategoryList", novelcategoryList);
        return "/admin/novelinfo/novelinfo_update.jsp";
    }

    /**
     * 更新小说信息
     *
     * @param novelinfo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelinfo_update")
    public String update(Novelinfo novelinfo, HttpServletRequest request) throws Exception {
        novelinfo.setUpdatetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //更新数据库
        novelinfoService.updateNovelinfo(novelinfo);
        return "redirect:novelinfo_list.action";
    }

    /**
     * 删除小说信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelinfo_delete")
    public String delete(HttpServletRequest request) throws Exception {
        //根据id删除数据库记录
        int id = Integer.parseInt(request.getParameter("id"));
        novelinfoService.deleteNovelinfo(id);
        novelchapterService.deleteNovelchapterByNovelid(id); //删除所有小说章节信息
        return "redirect:novelinfo_list.action";
    }

    /**
     * 查看小说信息详情
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelinfo_toView")
    public String toView(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出记录放到request中，到前台jsp界面显示
        Novelinfo novelinfo = new Novelinfo();
        novelinfo.setId(id);
        List<Novelinfo> list = novelinfoService.queryNovelinfoList(novelinfo, null);
        novelinfo = list.get(0);
        request.setAttribute("novelinfo", novelinfo);
        return "/admin/novelinfo/novelinfo_view.jsp";
    }


    /**
     * 阅读量统计TOP10
     *
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/viewReport")
    public String viewReport(HttpServletRequest req) throws Exception {
        Novelinfo novelinfo = new Novelinfo();
        novelinfo.setSorts("view");
        PageBean pageBean = new PageBean(0,10);
        List<Novelinfo> novelinfos = novelinfoService.queryNovelinfoList(novelinfo,pageBean);
        req.setAttribute("title", "阅读量统计排行TOP10");
        String items = "";
        String score = "";
        if (novelinfos != null && novelinfos.size() > 0) {
            for (Novelinfo novel : novelinfos) {
                String gname = novel.getName();
                items = items + "'" + gname + "',";
                score = score + novel.getViewcount() + ",";
            }
        }
        req.setAttribute("items", items);
        req.setAttribute("score", score);
        return "/admin/novelinfo/reportview.jsp";
    }


    /**
     * 收藏量统计TOP10
     *
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/favReport")
    public String favReport(HttpServletRequest req) throws Exception {
        Novelinfo novelinfo = new Novelinfo();
        novelinfo.setSorts("fav");
        PageBean pageBean = new PageBean(0,10);
        List<Novelinfo> novelinfos = novelinfoService.queryNovelinfoList(novelinfo,pageBean);
        req.setAttribute("title", "收藏量统计排行TOP10");
        String items = "";
        String score = "";
        if (novelinfos != null && novelinfos.size() > 0) {
            for (Novelinfo novel : novelinfos) {
                String gname = novel.getName();
                items = items + "'" + gname + "',";
                score = score + novel.getFavcount() + ",";
            }
        }
        req.setAttribute("items", items);
        req.setAttribute("score", score);
        return "/admin/novelinfo/reportfav.jsp";
    }







}
