package com.model;

/**
 * 网站公告Model类
 */
public class Noticeinfo {
    public Noticeinfo() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告内容
     */
    private String tcontents;
    /**
     * 更新时间
     */
    private String updatetime;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTcontents() {
        return this.tcontents;
    }

    public void setTcontents(String tcontents) {
        this.tcontents = tcontents;
    }

    public String getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
