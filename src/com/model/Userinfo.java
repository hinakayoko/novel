package com.model;

/**
 * 用户信息Model类
 */
public class Userinfo {
    public Userinfo() {
    }

    /**
     * id
     */
    private Integer id;
    /**
     * 手机号码
     */
    private String tel;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 性别
     */
    private String sex;
    /**
     * 头像
     */
    private String headurl;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadurl() {
        return this.headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }
}
