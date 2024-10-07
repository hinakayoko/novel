package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Tadmin;
import com.service.TadminService;

/**
 * 登录Controller控制类
 */
@Controller
public class LoginController {
    /**
     * 注入Service
     */
    @Autowired
    private TadminService tadminService;

    /**
     * 用户登录
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/tadmin_login")
    public String login(HttpServletRequest request) throws Exception {
        String flag = "false";
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        Tadmin tadmin = new Tadmin();
        tadmin.setUname(uname);
        tadmin.setUpwd(upwd);
        List<Tadmin> tadminList = tadminService.queryTadminList(tadmin, null);
        if (tadminList != null && tadminList.size() > 0) {
            Tadmin admin = tadminList.get(0);
            request.getSession().setAttribute("adminuser", admin);
            request.getSession().setAttribute("utype", 0);
            flag = "true";
        }
        return flag;
    }

    /**
     * 退出登录
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/tadmin_loginout")
    public String loginout(HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("adminuser", null);
        request.getSession().invalidate();
        return "/admin/login.jsp";
    }

}
