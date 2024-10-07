package com.model;

/**
 * 轮播图信息Model类
 */
public class Swiperinfo {
    public Swiperinfo() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 图片
     */
    private String pic;
    /**
     * 关联小说
     */
    private Integer novelid;
    private Novelinfo novelinfoVO;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return this.pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getNovelid() {
        return this.novelid;
    }

    public void setNovelid(Integer novelid) {
        this.novelid = novelid;
    }

    public Novelinfo getNovelinfoVO() {
        return this.novelinfoVO;
    }

    public void setNovelinfoVO(Novelinfo novelinfoVO) {
        this.novelinfoVO = novelinfoVO;
    }
}
