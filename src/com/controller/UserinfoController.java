package com.controller;

import com.model.Userinfo;
import com.service.UserinfoService;
import com.util.PageBean;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户信息Controller业务控制类
 */
@Controller
public class UserinfoController {
    /**
     * 注入Service
     */
    @Autowired
    private UserinfoService userinfoService;

    /**
     * 用户信息列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userinfo_list")
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
        Userinfo userinfo = new Userinfo();
        String tel = request.getParameter("tel");
        userinfo.setTel(tel);
        request.setAttribute("tel", tel);
        String pwd = request.getParameter("pwd");
        userinfo.setPwd(pwd);
        request.setAttribute("pwd", pwd);
        String nickname = request.getParameter("nickname");
        userinfo.setNickname(nickname);
        request.setAttribute("nickname", nickname);
        //查询记录总数
        counts = userinfoService.getCount(userinfo);
        //获取当前页记录
        List userinfoList = userinfoService.queryUserinfoList(userinfo, page);
        request.setAttribute("list", userinfoList);
        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/admin/userinfo/userinfo_list.jsp";
    }

    /**
     * 跳转到新增用户信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userinfo_toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        return "/admin/userinfo/userinfo_add.jsp";
    }

    /**
     * 保存新增用户信息
     *
     * @param userinfo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userinfo_add")
    public String add(Userinfo userinfo, HttpServletRequest request) throws Exception {
        if(StringUtils.isBlank(userinfo.getHeadurl())){
            userinfo.setHeadurl("/images/userdefault.gif");
        }
        //保存到数据库
        userinfoService.insertUserinfo(userinfo);
        return "redirect:userinfo_list.action";
    }

    /**
     * 跳转到更新用户信息界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userinfo_toUpdate")
    public String toUpdate(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出需要更新的记录
        Userinfo userinfo = userinfoService.queryUserinfoById(id);
        request.setAttribute("userinfo", userinfo);
        return "/admin/userinfo/userinfo_update.jsp";
    }

    /**
     * 更新用户信息
     *
     * @param userinfo
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userinfo_update")
    public String update(Userinfo userinfo, HttpServletRequest request) throws Exception {
        //更新数据库
        userinfoService.updateUserinfo(userinfo);
        return "redirect:userinfo_list.action";
    }

    /**
     * 删除用户信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userinfo_delete")
    public String delete(HttpServletRequest request) throws Exception {
        //根据id删除数据库记录
        int id = Integer.parseInt(request.getParameter("id"));
        userinfoService.deleteUserinfo(id);
        return "redirect:userinfo_list.action";
    }

    /**
     * 查看用户信息详情
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userinfo_toView")
    public String toView(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //根据ID查询出记录放到request中，到前台jsp界面显示
        Userinfo userinfo = userinfoService.queryUserinfoById(id);
        request.setAttribute("userinfo", userinfo);
        return "/admin/userinfo/userinfo_view.jsp";
    }

    /**
     * 判断手机号码是否存在
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userinfo_telExist")
    public String telExist(HttpServletRequest request) throws Exception {
        String exist = "true";
        String tel = request.getParameter("tel");
        Userinfo userinfo = new Userinfo();
        userinfo.setTel(tel);
        List list = userinfoService.queryUserinfoList(userinfo, null);
        if (list != null && list.size() > 0) {
            exist = "false"; // 验证插件需要返回false 返回false时验证提示已存在
        }
        return exist;
    }
}
