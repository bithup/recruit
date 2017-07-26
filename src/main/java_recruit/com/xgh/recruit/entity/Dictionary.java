package com.xgh.recruit.entity;

import java.io.Serializable;
import java.util.Date;


/**
 *
 *
 *
 **/
@SuppressWarnings("serial")
public class Dictionary implements Serializable {

    /**
     * 主键id
     **/
    private long id;

    /**
     * 公司id
     **/
    private long unitId;

    /**
     * 行业id
     **/
    private long instId;

    /**
     * 种类
     **/
    private String item;

    /**
     * 行业编码
     **/
    private String instCode;

    /**
     * Key键
     **/
    private String code;

    /**
     * value值
     **/
    private String value;

    /**
     * 创建时间
     **/
    private Date createDate;

    /**
     * 更新时间
     **/
    private Date updateDate;

    /**
     * 备注
     **/
    private String remark;

    /**
     * 1正常-1删除
     **/
    private int status;

    /**
     * 冗余字段1
     **/
    private long data1;

    /**
     * 冗余字段2
     **/
    private int data2;

    /**
     * 冗余字段3
     **/
    private String data3;

    /**
     * 冗余字段4
     **/
    private String data4;

    /**
     * 冗余字段5
     **/
    private long data5;

    /**
     * 冗余字段8
     **/
    private Date data8;


    public Dictionary() {
        super();
    }

    public Dictionary(long id) {
        super();
        this.id = id;
    }

    public Dictionary(long id, long unitId, long instId, String item, String instCode, String code, String value, Date createDate, Date updateDate, String remark, int status, long data1, int data2, String data3, String data4, long data5, Date data8) {
        super();
        this.id = id;
        this.unitId = unitId;
        this.instId = instId;
        this.item = item;
        this.instCode = instCode;
        this.code = code;
        this.value = value;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.remark = remark;
        this.status = status;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
        this.data8 = data8;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getUnitId() {
        return this.unitId;
    }

    public void setInstId(Long instId) {
        this.instId = instId;
    }

    public Long getInstId() {
        return this.instId;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getInstCode() {
        return this.instCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setData1(Long data1) {
        this.data1 = data1;
    }

    public Long getData1() {
        return this.data1;
    }

    public void setData2(Integer data2) {
        this.data2 = data2;
    }

    public Integer getData2() {
        return this.data2;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData3() {
        return this.data3;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData4() {
        return this.data4;
    }

    public void setData5(Long data5) {
        this.data5 = data5;
    }

    public Long getData5() {
        return this.data5;
    }

    public void setData8(Date data8) {
        this.data8 = data8;
    }

    public Date getData8() {
        return this.data8;
    }

}

