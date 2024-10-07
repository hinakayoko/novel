package com.model;

import java.util.List;

/**
 * 小说信息Model类
 */
public class Novelinfo {
    public Novelinfo() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 小说名称
     */
    private String name;
    /**
     * 小说分类
     */
    private Integer categoryid;
    /**
     * 作者
     */
    private String author;
    /**
     * 小说简介
     */
    private String noveldesc;
    /**
     * 更新时间
     */
    private String updatetime;
    /**
     * 字数
     */
    private Integer wordsnum;
    /**
     * 浏览量
     */
    private Integer viewcount;
    /**
     * 进度
     */
    private Integer progress;
    /**
     * 收藏数
     */
    private Integer favcount;
    /**
     * 封面
     */
    private String novelcover;

    private Novelcategory novelcategoryVO;
    /**
     * 章节信息
     */
    private List<Novelchapter> novelchapterList;
    /**
     * 最新章节
     */
    private Novelchapter newNovelchapter;
    /**
     * 第一章节
     */
    private Novelchapter oneNovelchapter;
    private String keyword;
    /**
     * 是否已经加入书架
     */
    private String favstatus="N";

    public String getFavstatus() {
        return favstatus;
    }

    public void setFavstatus(String favstatus) {
        this.favstatus = favstatus;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Novelchapter getOneNovelchapter() {
        return oneNovelchapter;
    }

    public void setOneNovelchapter(Novelchapter oneNovelchapter) {
        this.oneNovelchapter = oneNovelchapter;
    }

    public Novelchapter getNewNovelchapter() {
        return newNovelchapter;
    }

    public void setNewNovelchapter(Novelchapter newNovelchapter) {
        this.newNovelchapter = newNovelchapter;
    }

    public List<Novelchapter> getNovelchapterList() {
        return novelchapterList;
    }

    public void setNovelchapterList(List<Novelchapter> novelchapterList) {
        this.novelchapterList = novelchapterList;
    }

    private String progressStr;

    private String sorts;

    public String getSorts() {
        return sorts;
    }

    public void setSorts(String sorts) {
        this.sorts = sorts;
    }

    public String getProgressStr() {
        if (progress == 1) {
            progressStr = "连载中";
        }
        if (progress == 2) {
            progressStr = "已完结";
        }
        return progressStr;
    }

    public void setProgressStr(String progressStr) {
        this.progressStr = progressStr;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryid() {
        return this.categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNoveldesc() {
        return this.noveldesc;
    }

    public void setNoveldesc(String noveldesc) {
        this.noveldesc = noveldesc;
    }

    public String getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getWordsnum() {
        return this.wordsnum;
    }

    public void setWordsnum(Integer wordsnum) {
        this.wordsnum = wordsnum;
    }

    public Integer getViewcount() {
        return this.viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getFavcount() {
        return this.favcount;
    }

    public void setFavcount(Integer favcount) {
        this.favcount = favcount;
    }

    public String getNovelcover() {
        return this.novelcover;
    }

    public void setNovelcover(String novelcover) {
        this.novelcover = novelcover;
    }

    public Novelcategory getNovelcategoryVO() {
        return this.novelcategoryVO;
    }

    public void setNovelcategoryVO(Novelcategory novelcategoryVO) {
        this.novelcategoryVO = novelcategoryVO;
    }
}
