package com.model;

/**
 * 小说分类信息Model类
 */
public class Novelcategory {
    public Novelcategory() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 分类名称
     */
    private String name;

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
}
