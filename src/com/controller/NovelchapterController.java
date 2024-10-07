package com.controller;

import com.model.Novelchapter;
import com.service.NovelchapterService;
import com.util.PageBean;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.service.NovelinfoService;
import com.model.Novelinfo;

/**
 * 小说章节信息Controller业务控制类
 */
@Controller
public class NovelchapterController {
    /**
     * 注入Service
     */
    @Autowired
    private NovelchapterService novelchapterService;
    @Autowired
    private NovelinfoService novelinfoService;

    /**
     * 小说章节信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelchapter_list")
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
        Novelchapter novelchapter = new Novelchapter();
        String novelid = request.getParameter("novelid");
        novelchapter.setNovelid(Integer.parseInt(novelid == null || "".equals(novelid) ? "0" : novelid));
        request.setAttribute("novelid", novelid);
        String title = request.getParameter("title");
        novelchapter.setTitle(title);
        request.setAttribute("title", title);
        //查询记录总数
        counts = novelchapterService.getCount(novelchapter);
        //获取当前页记录
        List novelchapterList = novelchapterService.queryNovelchapterList(novelchapter, page);
        request.setAttribute("list", novelchapterList);
        Novelinfo novelinfoQuery = new Novelinfo();
        List<Novelinfo> novelinfoList = novelinfoService.queryNovelinfoList(novelinfoQuery, null);
        request.setAttribute("novelinfoList", novelinfoList);
        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/admin/novelchapter/novelchapter_list.jsp";
    }

    /**
     * 跳转到新增小说章节信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelchapter_toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        request.setAttribute("novelid", request.getParameter("novelid"));
        return "/admin/novelchapter/novelchapter_add.jsp";
    }

    /**
     * 保存新增小说章节信息
     *
     * @param novelchapter
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelchapter_add")
    public String add(Novelchapter novelchapter, HttpServletRequest request) throws Exception {

        Novelinfo novelinfo = novelinfoService.queryNovelinfoById(novelchapter.getNovelid());
        novelinfo.setWordsnum(novelinfo.getWordsnum() + novelchapter.getWordscount());
        novelinfoService.updateNovelinfo(novelinfo);
        //保存到数据库
        novelchapterService.insertNovelchapter(novelchapter);
        return "redirect:novelchapter_list.action?novelid=" + novelchapter.getNovelid();
    }

    /**
     * 跳转到更新小说章节信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelchapter_toUpdate")
    public String toUpdate(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出需要更新的记录
        Novelchapter novelchapter = novelchapterService.queryNovelchapterById(id);
        request.setAttribute("novelchapter", novelchapter);
        return "/admin/novelchapter/novelchapter_update.jsp";
    }

    /**
     * 更新小说章节信息
     *
     * @param novelchapter
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelchapter_update")
    public String update(Novelchapter novelchapter, HttpServletRequest request) throws Exception {
        Novelchapter oldNovelchapter = novelchapterService.queryNovelchapterById(novelchapter.getId());
        int oldcount = oldNovelchapter.getWordscount();

        Novelinfo novelinfo = novelinfoService.queryNovelinfoById(novelchapter.getNovelid());
        novelinfo.setWordsnum(novelinfo.getWordsnum() - oldcount);

        novelinfo.setWordsnum(novelinfo.getWordsnum() + novelchapter.getWordscount());
        novelinfoService.updateNovelinfo(novelinfo);

        //更新数据库
        novelchapterService.updateNovelchapter(novelchapter);
        return "redirect:novelchapter_list.action?novelid=" + novelchapter.getNovelid();
    }

    /**
     * 删除小说章节信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelchapter_delete")
    public String delete(HttpServletRequest request) throws Exception {
        //根据id删除数据库记录
        int id = Integer.parseInt(request.getParameter("id"));
        Novelchapter novelchapter = novelchapterService.queryNovelchapterById(id);
        Novelinfo novelinfo = novelinfoService.queryNovelinfoById(novelchapter.getNovelid());
        novelinfo.setWordsnum(novelinfo.getWordsnum() - novelchapter.getWordscount());
        novelinfoService.updateNovelinfo(novelinfo);
        novelchapterService.deleteNovelchapter(id);
        return "redirect:novelchapter_list.action?novelid=" + novelchapter.getNovelid();
    }

    /**
     * 查看小说章节信息详情
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelchapter_toView")
    public String toView(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出记录放到request中，到前台jsp界面显示
        Novelchapter novelchapter = new Novelchapter();
        novelchapter.setId(id);
        List<Novelchapter> list = novelchapterService.queryNovelchapterList(novelchapter, null);
        novelchapter = list.get(0);
        request.setAttribute("novelchapter", novelchapter);
        return "/admin/novelchapter/novelchapter_view.jsp";
    }
}
