package com.model;

/**
 * 小说评论Model类
 */
public class Novelcomment {
    public Novelcomment() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 小说
     */
    private Integer novelid;
    /**
     * 用户
     */
    private Integer userid;
    /**
     * 评论内容
     */
    private String contents;
    /**
     * 评论时间
     */
    private String commenttime;
    private String commenttimeStart;
    private String commenttimeEnd;
    private Novelinfo novelinfoVO;
    private Userinfo userinfoVO;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNovelid() {
        return this.novelid;
    }

    public void setNovelid(Integer novelid) {
        this.novelid = novelid;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCommenttime() {
        return this.commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }

    public String getCommenttimeStart() {
        return this.commenttimeStart;
    }

    public void setCommenttimeStart(String commenttimeStart) {
        this.commenttimeStart = commenttimeStart;
    }

    public String getCommenttimeEnd() {
        return this.commenttimeEnd;
    }

    public void setCommenttimeEnd(String commenttimeEnd) {
        this.commenttimeEnd = commenttimeEnd;
    }

    public Novelinfo getNovelinfoVO() {
        return this.novelinfoVO;
    }

    public void setNovelinfoVO(Novelinfo novelinfoVO) {
        this.novelinfoVO = novelinfoVO;
    }

    public Userinfo getUserinfoVO() {
        return this.userinfoVO;
    }

    public void setUserinfoVO(Userinfo userinfoVO) {
        this.userinfoVO = userinfoVO;
    }
}
