package com.xgh.recruit.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * 企业表
 *
 **/
@SuppressWarnings("serial")
public class CompanyInfo implements Serializable {

	/****/
	private long id;

	/**公司名称**/
	private String companyName;

	/**公司简称**/
	private String shortName;

	/**企业账号**/
	private String account;

	/**密码**/
	private String password;

	/**行业id**/
	private long industryId;

	/**行业名称**/
	private String industryName;

	/**公司性质**/
	private int companyType;

	/**公司规模**/
	private int companySize;

	/**公司所属区域id**/
	private long zoneId;

	/**公司所属区域名称**/
	private String zoneName;

	/**公司详细地址**/
	private String address;

	/**经度**/
	private BigDecimal gpsLongitude;

	/**纬度**/
	private BigDecimal gpsLatitude;

	/**公司介绍**/
	private String intro;

	/**公司邮箱**/
	private String email;

	/**绑定手机号**/
	private String mobile;

	/**联系电话-座机**/
	private String telephone;

	/**联系人**/
	private String contacts;

	/**企业官网地址**/
	private String companyUrl;

	/**logo地址**/
	private String logoPath;

	/**logo绝对地址**/
	private String logoRealPath;

	/**三证路径**/
	private String credentialsPath;

	/**三证绝对路径**/
	private String credentialsRealPath;

	/**审核状态：0未审核；1通过；2未通过**/
	private int isCheck;

	/**认证状态：1认证；2未认证**/
	private int isCertify;

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

	/**微信公众号**/
	private String weixinNum;

	/**备用字段4**/
	private String data4;

	/**备用字段5**/
	private String data5;

	/**备用字段6**/
	private String data6;

	/**备用字段7**/
	private String data7;

	/**备用字段8**/
	private String data8;

	/**是否推荐(首页)**/
	private int isRecommend;

	/**备用字段10**/
	private int data10;

	/**备用字段11**/
	private Double data11;

	/**备用字段12**/
	private Double data12;


	public CompanyInfo() { super(); }

	public CompanyInfo(long id) {
		super();
		this.id=id;
	}

	public CompanyInfo(long id,String companyName,String shortName,String account,String password,long industryId,String industryName,int companyType,int companySize,long zoneId,String zoneName,String address,BigDecimal gpsLongitude,BigDecimal gpsLatitude,String intro,String email,String mobile,String telephone,String contacts,String companyUrl,String logoPath,String logoRealPath,String credentialsPath,String credentialsRealPath,int isCheck,int isCertify,Date createDate,Date updateDate,int status,long data1,long data2,String weixinNum,String data4,String data5,String data6,String data7,String data8,int isRecommend,int data10,Double data11,Double data12){
		super();
		this.id = id;
		this.companyName = companyName;
		this.shortName = shortName;
		this.account = account;
		this.password = password;
		this.industryId = industryId;
		this.industryName = industryName;
		this.companyType = companyType;
		this.companySize = companySize;
		this.zoneId = zoneId;
		this.zoneName = zoneName;
		this.address = address;
		this.gpsLongitude = gpsLongitude;
		this.gpsLatitude = gpsLatitude;
		this.intro = intro;
		this.email = email;
		this.mobile = mobile;
		this.telephone = telephone;
		this.contacts = contacts;
		this.companyUrl = companyUrl;
		this.logoPath = logoPath;
		this.logoRealPath = logoRealPath;
		this.credentialsPath = credentialsPath;
		this.credentialsRealPath = credentialsRealPath;
		this.isCheck = isCheck;
		this.isCertify = isCertify;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.status = status;
		this.data1 = data1;
		this.data2 = data2;
		this.weixinNum = weixinNum;
		this.data4 = data4;
		this.data5 = data5;
		this.data6 = data6;
		this.data7 = data7;
		this.data8 = data8;
		this.isRecommend = isRecommend;
		this.data10 = data10;
		this.data11 = data11;
		this.data12 = data12;

	}
	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return this.companyName;
	}

	public void setShortName(String shortName){
		this.shortName = shortName;
	}

	public String getShortName(){
		return this.shortName;
	}

	public void setAccount(String account){
		this.account = account;
	}

	public String getAccount(){
		return this.account;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setIndustryId(Long industryId){
		this.industryId = industryId;
	}

	public Long getIndustryId(){
		return this.industryId;
	}

	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}

	public String getIndustryName(){
		return this.industryName;
	}

	public void setCompanyType(Integer companyType){
		this.companyType = companyType;
	}

	public Integer getCompanyType(){
		return this.companyType;
	}

	public void setCompanySize(Integer companySize){
		this.companySize = companySize;
	}

	public Integer getCompanySize(){
		return this.companySize;
	}

	public void setZoneId(Long zoneId){
		this.zoneId = zoneId;
	}

	public Long getZoneId(){
		return this.zoneId;
	}

	public void setZoneName(String zoneName){
		this.zoneName = zoneName;
	}

	public String getZoneName(){
		return this.zoneName;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return this.address;
	}

	public void setGpsLongitude(BigDecimal gpsLongitude){
		this.gpsLongitude = gpsLongitude;
	}

	public BigDecimal getGpsLongitude(){
		return this.gpsLongitude;
	}

	public void setGpsLatitude(BigDecimal gpsLatitude){
		this.gpsLatitude = gpsLatitude;
	}

	public BigDecimal getGpsLatitude(){
		return this.gpsLatitude;
	}

	public void setIntro(String intro){
		this.intro = intro;
	}

	public String getIntro(){
		return this.intro;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return this.mobile;
	}

	public void setTelephone(String telephone){
		this.telephone = telephone;
	}

	public String getTelephone(){
		return this.telephone;
	}

	public void setContacts(String contacts){
		this.contacts = contacts;
	}

	public String getContacts(){
		return this.contacts;
	}

	public void setCompanyUrl(String companyUrl){
		this.companyUrl = companyUrl;
	}

	public String getCompanyUrl(){
		return this.companyUrl;
	}

	public void setLogoPath(String logoPath){
		this.logoPath = logoPath;
	}

	public String getLogoPath(){
		return this.logoPath;
	}

	public void setLogoRealPath(String logoRealPath){
		this.logoRealPath = logoRealPath;
	}

	public String getLogoRealPath(){
		return this.logoRealPath;
	}

	public void setCredentialsPath(String credentialsPath){
		this.credentialsPath = credentialsPath;
	}

	public String getCredentialsPath(){
		return this.credentialsPath;
	}

	public void setCredentialsRealPath(String credentialsRealPath){
		this.credentialsRealPath = credentialsRealPath;
	}

	public String getCredentialsRealPath(){
		return this.credentialsRealPath;
	}

	public void setIsCheck(Integer isCheck){
		this.isCheck = isCheck;
	}

	public Integer getIsCheck(){
		return this.isCheck;
	}

	public void setIsCertify(Integer isCertify){
		this.isCertify = isCertify;
	}

	public Integer getIsCertify(){
		return this.isCertify;
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

	public void setWeixinNum(String weixinNum){
		this.weixinNum = weixinNum;
	}

	public String getWeixinNum(){
		return this.weixinNum;
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

	public void setData6(String data6){
		this.data6 = data6;
	}

	public String getData6(){
		return this.data6;
	}

	public void setData7(String data7){
		this.data7 = data7;
	}

	public String getData7(){
		return this.data7;
	}

	public void setData8(String data8){
		this.data8 = data8;
	}

	public String getData8(){
		return this.data8;
	}

	public void setIsRecommend(Integer isRecommend){
		this.isRecommend = isRecommend;
	}

	public Integer getIsRecommend(){
		return this.isRecommend;
	}

	public void setData10(Integer data10){
		this.data10 = data10;
	}

	public Integer getData10(){
		return this.data10;
	}

	public void setData11(Double data11){
		this.data11 = data11;
	}

	public Double getData11(){
		return this.data11;
	}

	public void setData12(Double data12){
		this.data12 = data12;
	}

	public Double getData12(){
		return this.data12;
	}

}
