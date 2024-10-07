package com.controller;

import com.model.Novelcategory;
import com.service.NovelcategoryService;
import com.util.PageBean;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 小说分类信息Controller业务控制类
 */
@Controller
public class NovelcategoryController {
    /**
     * 注入Service
     */
    @Autowired
    private NovelcategoryService novelcategoryService;

    /**
     * 小说分类信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcategory_list")
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
        Novelcategory novelcategory = new Novelcategory();
        String name = request.getParameter("name");
        novelcategory.setName(name);
        request.setAttribute("name", name);
        //查询记录总数
        counts = novelcategoryService.getCount(novelcategory);
        //获取当前页记录
        List novelcategoryList = novelcategoryService.queryNovelcategoryList(novelcategory, page);
        request.setAttribute("list", novelcategoryList);
        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/admin/novelcategory/novelcategory_list.jsp";
    }

    /**
     * 跳转到新增小说分类信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcategory_toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        return "/admin/novelcategory/novelcategory_add.jsp";
    }

    /**
     * 保存新增小说分类信息
     *
     * @param novelcategory
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcategory_add")
    public String add(Novelcategory novelcategory, HttpServletRequest request) throws Exception {
        //保存到数据库
        novelcategoryService.insertNovelcategory(novelcategory);
        return "redirect:novelcategory_list.action";
    }

    /**
     * 跳转到更新小说分类信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcategory_toUpdate")
    public String toUpdate(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出需要更新的记录
        Novelcategory novelcategory = novelcategoryService.queryNovelcategoryById(id);
        request.setAttribute("novelcategory", novelcategory);
        return "/admin/novelcategory/novelcategory_update.jsp";
    }

    /**
     * 更新小说分类信息
     *
     * @param novelcategory
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcategory_update")
    public String update(Novelcategory novelcategory, HttpServletRequest request) throws Exception {
        //更新数据库
        novelcategoryService.updateNovelcategory(novelcategory);
        return "redirect:novelcategory_list.action";
    }

    /**
     * 删除小说分类信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcategory_delete")
    public String delete(HttpServletRequest request) throws Exception {
        //根据id删除数据库记录
        int id = Integer.parseInt(request.getParameter("id"));
        novelcategoryService.deleteNovelcategory(id);
        return "redirect:novelcategory_list.action";
    }

    /**
     * 查看小说分类信息详情
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelcategory_toView")
    public String toView(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出记录放到request中，到前台jsp界面显示
        Novelcategory novelcategory = novelcategoryService.queryNovelcategoryById(id);
        request.setAttribute("novelcategory", novelcategory);
        return "/admin/novelcategory/novelcategory_view.jsp";
    }
}
