package com.xgh.recruit.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CQ on 2017/2/24.
 */
public class Industry implements Serializable {

    /**主键id**/
    private long id;

    /**行业名称**/
    private String name;

    /**创建时间**/
    private Date createDate;

    /**修改时间**/
    private Date updateDate;

    /**状态：-1删除；0取消；1正常**/
    private int status;

    /**备用字段1**/
    private long data1;

    /**备用字段2**/
    private long data2;

    /**备用字段3**/
    private String data3;

    /**备用字段4**/
    private String data4;

    /**备用字段5**/
    private String data5;

    /**备用字段6**/
    private int data6;

    /**备用字段7**/
    private int data7;

    /**备用字段8**/
    private Double data8;


    public Industry() { super(); }

    public Industry(long id) {
        super();
        this.id=id;
    }

    public Industry(long id,String name,Date createDate,Date updateDate,int status,long data1,long data2,String data3,String data4,String data5,int data6,int data7,Double data8){
        super();
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
        this.data6 = data6;
        this.data7 = data7;
        this.data8 = data8;

    }
    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public Date getCreateDate(){
        return this.createDate;
    }

    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }

    public Date getUpdateDate(){
        return this.updateDate;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setData1(Long data1){
        this.data1 = data1;
    }

    public Long getData1(){
        return this.data1;
    }

    public void setData2(Long data2){
        this.data2 = data2;
    }

    public Long getData2(){
        return this.data2;
    }

    public void setData3(String data3){
        this.data3 = data3;
    }

    public String getData3(){
        return this.data3;
    }

    public void setData4(String data4){
        this.data4 = data4;
    }

    public String getData4(){
        return this.data4;
    }

    public void setData5(String data5){
        this.data5 = data5;
    }

    public String getData5(){
        return this.data5;
    }

    public void setData6(Integer data6){
        this.data6 = data6;
    }

    public Integer getData6(){
        return this.data6;
    }

    public void setData7(Integer data7){
        this.data7 = data7;
    }

    public Integer getData7(){
        return this.data7;
    }

    public void setData8(Double data8){
        this.data8 = data8;
    }

    public Double getData8(){
        return this.data8;
    }
}
