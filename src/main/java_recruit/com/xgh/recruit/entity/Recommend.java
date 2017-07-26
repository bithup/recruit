package com.xgh.recruit.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CQ on 2017/2/23.
 */
public class Recommend implements Serializable {


    private static final long serialVersionUID = 1L;

    public static final String key = "keyStorehouse";

    //
    private long id;
    //提交建议,吐槽者id
    private long memberId;
    //类型  1.创意 2.挑毛病 3.吐槽
    private int kind;
    //内容
    private String context;
    //回复
    private String remart;
    //状态 0 未启用 1 启用
    private int status;
    //发表时间
    private Date createDate;
    //是否采纳 0 未采纳 1已采纳
    private int adopt;
    //冗余字段1
    private String data1;
    //冗余字段2
    private String data2;
    //冗余字段3
    private String data3;

    private Date updateDate;

    public Recommend(){
        super();
    }

    public Recommend(long id){
        super();
        this.id = id;
    }

    public Recommend(long id, long memberId, int kind, String context, Date updateDate,String remart, int status, Date createDate, int adopt, String data1, String data2, String data3) {
        super();
        this.id = id;
        this.memberId = memberId;
        this.kind = kind;
        this.context = context;
        this.remart = remart;
        this.status = status;
        this.createDate = createDate;
        this.adopt = adopt;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.updateDate = updateDate;


    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getRemart() {
        return remart;
    }

    public void setRemart(String remart) {
        this.remart = remart;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getAdopt() {
        return adopt;
    }

    public void setAdopt(int adopt) {
        this.adopt = adopt;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public Date getUpdateDate() {

        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }




}
