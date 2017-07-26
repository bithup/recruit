package com.xgh.recruit.entity;
import java.io.Serializable;
import java.util.Date;


/**
 *
 *
 *
 **/
@SuppressWarnings("serial")
public class Subject implements Serializable {

	/****/
	private long id;

	/**行业Id**/
	private long instId;

	/**行业code**/
	private String instCode;

	/**公司Id**/
	private long unitId;

	/**公司code**/
	private String unitCode;

	/**创建人id**/
	private long userId;

	/**主题类型，1 头部广告主题**/
	private int type;

	/**根路径**/
	private String path;

	/**相对路径**/
	private String relativePath;

	/**ios图片存储位置**/
	private String iosFilePath;

	/**android图片存储路径**/
	private String androidFilePath;

	/**手机网站图片存储路径**/
	private String mobileFilePath;

	/**pc图片存储位置**/
	private String pcFilePath;

	/**主题名称**/
	private String subjectName;

	/**1 商品列表，2 商品详情 3 url页面，4 宣传页面**/
	private int subjectType;

	/**类型为3的时候存储url地址**/
	private String subjectUrl;

	/**主题html内容，subject_type为4时，存储html富文本内容**/
	private String subjectContent;

	/**创建时间**/
	private Date createDate;

	/**创建时间**/
	private Date updateDate;

	/**活动排序**/
	private int ord;

	/**主题备注**/
	private String remark;

	/**-1：删除、0：不启用、1：启用**/
	private int status;

	/**主题提示**/
	private String subjectHint;

	/**轮播图打开地址**/
	private String sujectUrl;


	public Subject() { super(); }

	public Subject(long id) {
		super();
		this.id=id;
	}

	public Subject(long id,long instId,String instCode,long unitId,String unitCode,long userId,int type,String path,String relativePath,String iosFilePath,String androidFilePath,String mobileFilePath,String pcFilePath,String subjectName,int subjectType,String subjectUrl,String subjectContent,Date createDate,Date updateDate,int ord,String remark,int status,String subjectHint,String sujectUrl){
		super();
		this.id = id;
		this.instId = instId;
		this.instCode = instCode;
		this.unitId = unitId;
		this.unitCode = unitCode;
		this.userId = userId;
		this.type = type;
		this.path = path;
		this.relativePath = relativePath;
		this.iosFilePath = iosFilePath;
		this.androidFilePath = androidFilePath;
		this.mobileFilePath = mobileFilePath;
		this.pcFilePath = pcFilePath;
		this.subjectName = subjectName;
		this.subjectType = subjectType;
		this.subjectUrl = subjectUrl;
		this.subjectContent = subjectContent;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.ord = ord;
		this.remark = remark;
		this.status = status;
		this.subjectHint = subjectHint;
		this.sujectUrl = sujectUrl;

	}
	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setInstId(Long instId){
		this.instId = instId;
	}

	public Long getInstId(){
		return this.instId;
	}

	public void setInstCode(String instCode){
		this.instCode = instCode;
	}

	public String getInstCode(){
		return this.instCode;
	}

	public void setUnitId(Long unitId){
		this.unitId = unitId;
	}

	public Long getUnitId(){
		return this.unitId;
	}

	public void setUnitCode(String unitCode){
		this.unitCode = unitCode;
	}

	public String getUnitCode(){
		return this.unitCode;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public Long getUserId(){
		return this.userId;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getType(){
		return this.type;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return this.path;
	}

	public void setRelativePath(String relativePath){
		this.relativePath = relativePath;
	}

	public String getRelativePath(){
		return this.relativePath;
	}

	public void setIosFilePath(String iosFilePath){
		this.iosFilePath = iosFilePath;
	}

	public String getIosFilePath(){
		return this.iosFilePath;
	}

	public void setAndroidFilePath(String androidFilePath){
		this.androidFilePath = androidFilePath;
	}

	public String getAndroidFilePath(){
		return this.androidFilePath;
	}

	public void setMobileFilePath(String mobileFilePath){
		this.mobileFilePath = mobileFilePath;
	}

	public String getMobileFilePath(){
		return this.mobileFilePath;
	}

	public void setPcFilePath(String pcFilePath){
		this.pcFilePath = pcFilePath;
	}

	public String getPcFilePath(){
		return this.pcFilePath;
	}

	public void setSubjectName(String subjectName){
		this.subjectName = subjectName;
	}

	public String getSubjectName(){
		return this.subjectName;
	}

	public void setSubjectType(Integer subjectType){
		this.subjectType = subjectType;
	}

	public Integer getSubjectType(){
		return this.subjectType;
	}

	public void setSubjectUrl(String subjectUrl){
		this.subjectUrl = subjectUrl;
	}

	public String getSubjectUrl(){
		return this.subjectUrl;
	}

	public void setSubjectContent(String subjectContent){
		this.subjectContent = subjectContent;
	}

	public String getSubjectContent(){
		return this.subjectContent;
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

	public void setOrd(Integer ord){
		this.ord = ord;
	}

	public Integer getOrd(){
		return this.ord;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setSubjectHint(String subjectHint){
		this.subjectHint = subjectHint;
	}

	public String getSubjectHint(){
		return this.subjectHint;
	}

	public void setSujectUrl(String sujectUrl){
		this.sujectUrl = sujectUrl;
	}

	public String getSujectUrl(){
		return this.sujectUrl;
	}

}
