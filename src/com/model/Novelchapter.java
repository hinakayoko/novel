package com.model;

import com.util.Utils;
import org.springframework.util.ObjectUtils;

/**
 * 小说章节信息Model类
 */
public class Novelchapter {
    public Novelchapter() {
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
     * 章节标题
     */
    private String title;
    /**
     * 章节内容
     */
    private String contents;
    /**
     * 章节字数
     */
    private Integer wordscount;
    private Novelinfo novelinfoVO;
    private String sorts;

    private String desc;

    public String getDesc() {
        String t = "";
        if(!ObjectUtils.isEmpty(contents)){
             t = Utils.delHTMLTag(contents);
            if(t.length()>300){
                t = t.substring(0,300) + "...";
            }
        }
        return t;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSorts() {
        return sorts;
    }

    public void setSorts(String sorts) {
        this.sorts = sorts;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getWordscount() {
        return this.wordscount;
    }

    public void setWordscount(Integer wordscount) {
        this.wordscount = wordscount;
    }

    public Novelinfo getNovelinfoVO() {
        return this.novelinfoVO;
    }

    public void setNovelinfoVO(Novelinfo novelinfoVO) {
        this.novelinfoVO = novelinfoVO;
    }
}
