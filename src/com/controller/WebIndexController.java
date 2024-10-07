package com.controller;

import com.model.*;
import com.service.*;
import com.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 前台业务Controller控制类
 */
@Controller
public class WebIndexController {
    /**
     * 注入Service
     */
    @Autowired
    private NoticeinfoService noticeinfoService;
    @Autowired
    private NovelcategoryService novelcategoryService;
    @Autowired
    private SwiperinfoService swiperinfoService;
    @Autowired
    private NovelinfoService novelinfoService;
    @Autowired
    private NovelchapterService novelchapterService;
    @Autowired
    private UserinfoService userinfoService;
    @Autowired
    private BookshelfService bookshelfService;
    @Autowired
    private NovelcommentService novelcommentService;


    /**
     * 网站首页
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) throws Exception {
        //把所有小说分类查询出来，放到session中
        request.getSession().setAttribute("categorylist",novelcategoryService.queryNovelcategoryList(new Novelcategory(),null));

        //从数据库查询出所有轮播图，放到request中
        List<Swiperinfo> swiperinfos = swiperinfoService.querySwiperinfoList(new Swiperinfo(),null);
        request.setAttribute("swiperinfos",swiperinfos);

        //从数据库查询最新的5条公告信息，放到request中
        PageBean pageBean = new PageBean(0,5);
        List<Noticeinfo> noticeinfos = noticeinfoService.queryNoticeinfoList(new Noticeinfo(),pageBean);
        request.setAttribute("noticeinfos",noticeinfos);

        //热门推荐   按点击量推荐，推荐点击量多的,放到request中
        Novelinfo novelinfo = new Novelinfo();
        novelinfo.setSorts("view");
        pageBean = new PageBean(0,7);
        List<Novelinfo> hotnovelinfos = novelinfoService.queryNovelinfoList(novelinfo,pageBean);
        request.setAttribute("hotnovelinfos",hotnovelinfos);

        //新书榜单,放到request中
        novelinfo = new Novelinfo();
        pageBean = new PageBean(0,10);
        List<Novelinfo> newnovelinfos = novelinfoService.queryNovelinfoList(novelinfo,pageBean);
        request.setAttribute("newnovelinfos",newnovelinfos);


        //收藏榜单,放到request中
        novelinfo = new Novelinfo();
        novelinfo.setSorts("fav");
        pageBean = new PageBean(0,10);
        List<Novelinfo> favnovelinfos = novelinfoService.queryNovelinfoList(novelinfo,pageBean);
        request.setAttribute("favnovelinfos",favnovelinfos);

        //前4个小说分类，每个分类取最新的3个放到request中
        Novelcategory novelcategory = new Novelcategory();
        pageBean = new PageBean(0,4);
        List<Novelcategory> novelcategories = novelcategoryService.queryNovelcategoryList(novelcategory,pageBean);
        if(!ObjectUtils.isEmpty(novelcategories)){
            for (int i = 0; i < novelcategories.size(); i++) {
                Novelcategory novelcategoryTemp =  novelcategories.get(i);
                request.setAttribute("novelcategory"+i,novelcategoryTemp);
                novelinfo = new Novelinfo();
                novelinfo.setCategoryid(novelcategoryTemp.getId());
                pageBean = new PageBean(0,3);
                List<Novelinfo> novelinfos = novelinfoService.queryNovelinfoList(novelinfo,pageBean);
                request.setAttribute("novelinfos"+i,novelinfos);

            }
        }

        return "/qiantai/index.jsp";
    }



    /**
     * 根据分类查询小说列表及 书库（书库就是查询说有分类）
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/categoryQuery")
    public String categoryQuery(HttpServletRequest request) throws Exception {
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

        String keyword = request.getParameter("keyword");
        novelinfo.setKeyword(keyword);

        //获取小说分类id
        String cid = request.getParameter("cid");
        novelinfo.setCategoryid(Integer.parseInt(cid == null || "".equals(cid) ? "0" : cid));
        request.setAttribute("cid", novelinfo.getCategoryid());

        //写作进度
        String progress = request.getParameter("progress");
        novelinfo.setProgress(Integer.parseInt(progress == null || "".equals(progress) ? "0" : progress));
        request.setAttribute("progress", novelinfo.getProgress());

        //排序方式
        String sorts = request.getParameter("sorts");
        novelinfo.setSorts((sorts == null || "".equals(sorts) ? "" : sorts));
        request.setAttribute("sorts", novelinfo.getSorts());


        //查询记录总数
        counts = novelinfoService.getCount(novelinfo);
        //获取满足查询条件的当前页记录
        List<Novelinfo> novelinfoList = novelinfoService.queryNovelinfoList(novelinfo, page);
        if(!ObjectUtils.isEmpty(novelinfoList)){
            for (Novelinfo novelinfo1 : novelinfoList) {
                Novelchapter novelchapter = new Novelchapter();
                novelchapter.setSorts("desc");
                novelchapter.setNovelid(novelinfo1.getId());
                page = new PageBean(0,1);
                List<Novelchapter> novelchapters = novelchapterService.queryNovelchapterList(novelchapter,page);
                if(!ObjectUtils.isEmpty(novelchapters)){
                    novelinfo1.setNewNovelchapter(novelchapters.get(novelchapters.size()-1));
                }

                if (request.getSession().getAttribute("cuser")!=null) {
                    Userinfo userinfo = (Userinfo) request.getSession().getAttribute("cuser");
                    Bookshelf bookshelf = new Bookshelf();
                    bookshelf.setUserid(userinfo.getId());
                    bookshelf.setNovelid(novelinfo1.getId());
                    int count = bookshelfService.getCount(bookshelf);
                    if(count>0){
                        novelinfo1.setFavstatus("Y");
                    }
                }


            }
        }
        request.setAttribute("list", novelinfoList);



        //查询出所有小说分类，放到request中
        Novelcategory novelcategoryQuery = new Novelcategory();
        List<Novelcategory> novelcategoryList = novelcategoryService.queryNovelcategoryList(novelcategoryQuery, null);
        request.setAttribute("novelcategoryList", novelcategoryList);
        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/qiantai/novelinfolist.jsp";
    }



    /**
     * 小说详情信息页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelinfoDetail")
    public String novelinfoDetail(HttpServletRequest request) throws Exception {
        //获取页面传过来的小说id
        int id = Integer.parseInt(request.getParameter("id"));
        Novelinfo novelinfo = new Novelinfo();
        novelinfo.setId(id);
        //根据id查询出小说详情
        novelinfo = novelinfoService.queryNovelinfoList(novelinfo,null).get(0);

        //查询出该小说的最新更新章节
        Novelchapter novelchapter = new Novelchapter();
        novelchapter.setSorts("desc");
        novelchapter.setNovelid(id);
        PageBean page = new PageBean(0,1);
        List<Novelchapter> novelchapters = novelchapterService.queryNovelchapterList(novelchapter,page);
        if(!ObjectUtils.isEmpty(novelchapters)){
            novelinfo.setNewNovelchapter(novelchapters.get(novelchapters.size()-1));
        }


        novelchapter = new Novelchapter();
        novelchapter.setNovelid(id);
        List<Novelchapter> onenovelchapters = novelchapterService.queryNovelchapterList(novelchapter,page);
        if(!ObjectUtils.isEmpty(onenovelchapters)){
            Novelchapter one = onenovelchapters.get(0);
            novelinfo.setOneNovelchapter(one);
        }

        novelinfo.setViewcount(novelinfo.getViewcount()+1);
        novelinfoService.updateNovelinfo(novelinfo);

        //如果用户已登录，判断是否已加入书架
        if (request.getSession().getAttribute("cuser")!=null) {
            Userinfo userinfo = (Userinfo) request.getSession().getAttribute("cuser");
            Bookshelf bookshelf = new Bookshelf();
            bookshelf.setUserid(userinfo.getId());
            bookshelf.setNovelid(id);
            int count = bookshelfService.getCount(bookshelf);
            if(count>0){
                novelinfo.setFavstatus("Y");
            }
        }

        request.setAttribute("novelinfo",novelinfo);

        //点击量排行   点击量最多的10本小说
        Novelinfo noveltemp = new Novelinfo();
        noveltemp.setSorts("view");
        PageBean pageBean = new PageBean(0,10);
        List<Novelinfo> viewNovelinfos = novelinfoService.queryNovelinfoList(noveltemp,pageBean);
        request.setAttribute("viewNovelinfos",viewNovelinfos);

        //小说评论信息
        Novelcomment novelcomment = new Novelcomment();
        novelcomment.setNovelid(id);
        List<Novelcomment> novelcomments = novelcommentService.queryNovelcommentList(novelcomment,null);
        request.setAttribute("novelcomments",novelcomments);
        request.setAttribute("commentsnum",novelcomments==null?0:novelcomments.size());






        return "/qiantai/novelinfodetail.jsp";
    }


    /**
     * 小说章节信息页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/novelinfoChapterList")
    public String novelinfoChapterList(HttpServletRequest request) throws Exception {
        //获取页面传过来的小说id
        int id = Integer.parseInt(request.getParameter("id"));
        Novelinfo novelinfo = new Novelinfo();
        novelinfo.setId(id);
        //根据id查询出小说详情
        novelinfo = novelinfoService.queryNovelinfoList(novelinfo,null).get(0);

        //如果用户已登录，判断是否已加入书架
        if (request.getSession().getAttribute("cuser")!=null) {
            Userinfo userinfo = (Userinfo) request.getSession().getAttribute("cuser");
            Bookshelf bookshelf = new Bookshelf();
            bookshelf.setUserid(userinfo.getId());
            bookshelf.setNovelid(id);
            int count = bookshelfService.getCount(bookshelf);
            if(count>0){
                novelinfo.setFavstatus("Y");
            }
        }

        //查询出小说章节信息列表
        Novelchapter novelchapter = new Novelchapter();
        novelchapter.setNovelid(id);
        List<Novelchapter> novelchapters = novelchapterService.queryNovelchapterList(novelchapter,null);

        if(!ObjectUtils.isEmpty(novelchapters)){
            novelinfo.setOneNovelchapter(novelchapters.get(0));
        }

        request.setAttribute("novelinfo",novelinfo);
        request.setAttribute("novelchapters",novelchapters);
        return "/qiantai/novelinfochapters.jsp";
    }

    /**
     * 阅读小说具体章节内容
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/read")
    public String read(HttpServletRequest request) throws Exception {
        //获取页面传过来的章节id
        int id = Integer.parseInt(request.getParameter("id"));
        Novelchapter novelchapter = new Novelchapter();
        novelchapter.setId(id);
        novelchapter = novelchapterService.queryNovelchapterList(novelchapter,null).get(0);
        request.setAttribute("novelchapter",novelchapter);
        int preid = 0; // 前一章id
        int nextid = 0; // 下一章id
        Novelchapter chapter = new Novelchapter();
        chapter.setNovelid(novelchapter.getNovelid());
        List<Novelchapter> novelchapterList = novelchapterService.queryNovelchapterList(chapter,null);
        if(!ObjectUtils.isEmpty(novelchapterList)){
            if (novelchapterList.size() > 1) {
                for (int i = 0; i < novelchapterList.size(); i++) {
                    Novelchapter zp = novelchapterList.get(i);
                    if (zp.getId() == id) {
                        if (i == 0) { // 第一章
                            nextid = novelchapterList.get(i + 1).getId();// 下一章
                        } else if (i == novelchapterList.size() - 1) {
                            preid = novelchapterList.get(i - 1).getId();// 前一章
                        } else {
                            nextid = novelchapterList.get(i + 1).getId();// 下一章
                            preid = novelchapterList.get(i - 1).getId();// 前一章
                        }
                    }
                }
            }
        }
        request.setAttribute("preid", preid);
        request.setAttribute("nextid", nextid);

        return "/qiantai/read.jsp";
    }




    /**
     * 用户注册
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/userinfoRegister")
    public String userinfoRegister(HttpServletRequest request) throws Exception {
        String flag = "true";
        String tel = request.getParameter("tel");
        String pwd = request.getParameter("pwd");
        String nickname = request.getParameter("nickname");
        String vcode = request.getParameter("vcode");

        String svcode = request.getSession().getAttribute("vcode").toString();
        if(!svcode.equals(vcode)){
            return "code_error";
        }
        Userinfo userinfo = new Userinfo();
        userinfo.setTel(tel);
        int count = userinfoService.getCount(userinfo);
        if(count>0){
            return "tel_exists";
        }

        userinfo.setNickname(nickname);
        userinfo.setPwd(pwd);
        userinfo.setBirthday("");
        userinfo.setSex("");
        userinfo.setHeadurl("/images/userdefault.gif");
        userinfoService.insertUserinfo(userinfo);
        return flag;
    }



    /**
     * 用户登录
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/userinfoLogin")
    public String userinfoLogin(HttpServletRequest request) throws Exception {
        String flag = "true";
        String tel = request.getParameter("tel");
        String pwd = request.getParameter("pwd");

        Userinfo userinfo = new Userinfo();
        userinfo.setTel(tel);
        userinfo.setPwd(pwd);
        List<Userinfo> userinfos = userinfoService.queryUserinfoList(userinfo,null);
        if(ObjectUtils.isEmpty(userinfos)){
            return "loginerror";
        }
        userinfo = userinfos.get(0);
        request.getSession().setAttribute("cuser",userinfo);
        return flag;
    }


    /**
     * 用户退出
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/userinfoLoginout")
    public String userinfoLoginout(HttpServletRequest request) throws Exception {
        request.getSession().setAttribute("cuser",null);
        request.getSession().invalidate();
        return "redirect:index.action";
    }

    /**
     * 加入书架
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/novelfav")
    public String novelfav(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Userinfo userinfo = (Userinfo) request.getSession().getAttribute("cuser");
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setNovelid(id);
        bookshelf.setUserid(userinfo.getId());
        int count = bookshelfService.getCount(bookshelf);
        if(count==0){
            Novelinfo novelinfo = novelinfoService.queryNovelinfoById(id);
            novelinfo.setFavcount(novelinfo.getFavcount()+1);
            novelinfoService.updateNovelinfo(novelinfo);
            bookshelfService.insertBookshelf(bookshelf);
        }
        return "true";
    }


    /**
     * 我的书架列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bookshelflist")
    public String bookshelflist(HttpServletRequest request) throws Exception {
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
        String progress = request.getParameter("progress");
        bookshelf.setProgress(Integer.parseInt(request.getParameter("progress") == null || "".equals(request.getParameter("progress")) ? "0" : request.getParameter("progress")));
        request.setAttribute("progress", bookshelf.getProgress());
        Userinfo userinfo = (Userinfo) request.getSession().getAttribute("cuser");
        bookshelf.setUserid(userinfo.getId());
        //查询记录总数
        counts = bookshelfService.getCount(bookshelf);
        //获取当前页记录
        List<Bookshelf> bookshelfList = bookshelfService.queryBookshelfList(bookshelf, page);
        request.setAttribute("list", bookshelfList);

        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        request.setAttribute("leftmenu",2);
        return "/qiantai/bookshelflist.jsp";
    }


    /**
     * 移除书架
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delBookshelf")
    public String delBookshelf(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Bookshelf bookshelf = bookshelfService.queryBookshelfById(id);
        bookshelfService.deleteBookshelf(id);
        //将收藏数量减少1
        Novelinfo novelinfo = novelinfoService.queryNovelinfoById(bookshelf.getNovelid());
        novelinfo.setFavcount(novelinfo.getFavcount()-1);
        novelinfoService.updateNovelinfo(novelinfo);
        return "redirect:bookshelflist.action";
    }



    /**
     * 跳转到个人资料页面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toEditUserinfo")
    public String toEditUserinfo(HttpServletRequest request) throws Exception {
        Userinfo userinfo = (Userinfo) request.getSession().getAttribute("cuser");
        userinfo = userinfoService.queryUserinfoById(userinfo.getId());
        request.setAttribute("userinfo",userinfo);
        request.setAttribute("leftmenu",1);
        return "/qiantai/userinfo.jsp";
    }


    /**
     * 保存修改用户基本信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateUserinfo")
    public String updateUserinfo(HttpServletRequest request) throws Exception {
        String epwd = request.getParameter("epwd");
        String enickname = request.getParameter("enickname");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        Userinfo ouserinfo = (Userinfo) request.getSession().getAttribute("cuser");
        ouserinfo.setPwd(epwd);
        ouserinfo.setNickname(enickname);
        ouserinfo.setBirthday(birthday);
        ouserinfo.setSex(sex);
        userinfoService.updateUserinfo(ouserinfo);
        request.getSession().setAttribute("cuser",ouserinfo);

        request.setAttribute("message","操作成功");
        request.setAttribute("path","toEditUserinfo.action");

        return "/common/succeed.jsp";
    }





    /**
     * 保存评论信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/saveComment")
    public String saveComment(Novelcomment novelcomment,HttpServletRequest request) throws Exception {
        novelcomment.setUserid(((Userinfo)request.getSession().getAttribute("cuser")).getId());
        novelcomment.setCommenttime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        novelcommentService.insertNovelcomment(novelcomment);
        return "redirect:novelinfoDetail.action?id=" + novelcomment.getNovelid();
    }


    /**
     * 我的评论信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/commentlist")
    public String commentlist(HttpServletRequest request) throws Exception {
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
        Userinfo userinfo = (Userinfo) request.getSession().getAttribute("cuser");
        novelcomment.setUserid(userinfo.getId());
        //查询记录总数
        //查询记录总数
        counts = novelcommentService.getCount(novelcomment);
        //获取当前页记录
        List novelcommentList = novelcommentService.queryNovelcommentList(novelcomment, page);
        request.setAttribute("list", novelcommentList);

        //将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        request.setAttribute("leftmenu",3);
        return "/qiantai/commentlist.jsp";
    }


    /**
     * 删除评论信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delComments")
    public String delComments(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        novelcommentService.deleteNovelcomment(id);
        return "redirect:commentlist.action";
    }

    /**
     * 修改头像
     *
     * @param req
     * @param res
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(HttpServletRequest req, HttpServletResponse res, @RequestParam("file") MultipartFile file) throws ServletException, IOException {

        String fileName = file.getOriginalFilename();
        fileName = fileName.substring(fileName.lastIndexOf("."));
        String fname = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+fileName;
        String basePath = req.getRealPath("/upload");
        String furl = "/upload/" + fname;
        File dest = new File(basePath, fname);
        try {
            file.transferTo(dest);
            try {
                Userinfo userinfo = (Userinfo) req.getSession().getAttribute("cuser");
                userinfo.setHeadurl(furl);
                userinfoService.updateUserinfo(userinfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        req.setAttribute("message","操作成功");
        req.setAttribute("path","qiantai/modifyHead.jsp");
        return "/common/succeed.jsp";

    }



    /**
     * 前台网站公告列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/noticeinfolist")
    public String noticeinfolist(HttpServletRequest request) throws Exception {
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
        return "/qiantai/noticeinfolist.jsp";
    }


    /**
     * 前台网站公告列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/noticeDetail")
    public String noticeDetail(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Noticeinfo noticeinfo = noticeinfoService.queryNoticeinfoById(id);
        request.setAttribute("noticeinfo", noticeinfo);
        return "/qiantai/noticeinfo.jsp";
    }

}
