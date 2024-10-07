package com.model;

/**
 * 用户书架信息Model类
 */
public class Bookshelf {
    public Bookshelf() {
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
    private Novelinfo novelinfoVO;
    private Userinfo userinfoVO;
    private Novelcategory novelcategoryVO;
    private Integer progress;

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Novelcategory getNovelcategoryVO() {
        return novelcategoryVO;
    }

    public void setNovelcategoryVO(Novelcategory novelcategoryVO) {
        this.novelcategoryVO = novelcategoryVO;
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

    public Novelinfo getNovelinfoVO() {
        return novelinfoVO;
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
