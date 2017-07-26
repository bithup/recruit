package com.xgh.recruit.entity;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * 用户表
 *
 **/
@SuppressWarnings("serial")
public class MemberUser implements Serializable {

	/**主键id**/
	private long id;

	/**用户名**/
	private String account;

	/**密码**/
	private String password;

	/**真实姓名**/
	private String realName;

	/**昵称**/
	private String nickName;

	/**性别：1男；2女**/
	private int sex;

	/**头像路径**/
	private String headPath;

	/**头像绝对路径**/
	private String headRealPath;

	/**生日**/
	private Date birthday;

	/**工作年限**/
	private String workYear;

	/**电话**/
	private String telephone;

	/**邮箱**/
	private String email;

	/**身份证号**/
	private String idCard;

	/**居住地区域id**/
	private long zoneId;

	/**居住地区域名称**/
	private String zoneName;

	/**详细居住地址**/
	private String address;

	/**开放状态：1是；2否**/
	private int isOpen;

	/**自我评价**/
	private String selfEvaluation;

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
	private String data6;

	/**备用字段7**/
	private String data7;

	/**备用字段8**/
	private String data8;

	/**备用字段9**/
	private int data9;

	/**最高学历(1专科2本科3硕士4博士)**/
	private int education;

	/**备用字段11**/
	private Double data11;

	/**备用字段12**/
	private Double data12;


	public MemberUser() { super(); }

	public MemberUser(long id) {
		super();
		this.id=id;
	}

	public MemberUser(long id,String account,String password,String realName,String nickName,int sex,String headPath,String headRealPath,Date birthday,String workYear,String telephone,String email,String idCard,long zoneId,String zoneName,String address,int isOpen,String selfEvaluation,Date createDate,Date updateDate,int status,long data1,long data2,String data3,String data4,String data5,String data6,String data7,String data8,int data9,int education,Double data11,Double data12){
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.realName = realName;
		this.nickName = nickName;
		this.sex = sex;
		this.headPath = headPath;
		this.headRealPath = headRealPath;
		this.birthday = birthday;
		this.workYear = workYear;
		this.telephone = telephone;
		this.email = email;
		this.idCard = idCard;
		this.zoneId = zoneId;
		this.zoneName = zoneName;
		this.address = address;
		this.isOpen = isOpen;
		this.selfEvaluation = selfEvaluation;
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
		this.data9 = data9;
		this.education = education;
		this.data11 = data11;
		this.data12 = data12;

	}
	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
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

	public void setRealName(String realName){
		this.realName = realName;
	}

	public String getRealName(){
		return this.realName;
	}

	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public String getNickName(){
		return this.nickName;
	}

	public void setSex(Integer sex){
		this.sex = sex;
	}

	public Integer getSex(){
		return this.sex;
	}

	public void setHeadPath(String headPath){
		this.headPath = headPath;
	}

	public String getHeadPath(){
		return this.headPath;
	}

	public void setHeadRealPath(String headRealPath){
		this.headRealPath = headRealPath;
	}

	public String getHeadRealPath(){
		return this.headRealPath;
	}

	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}

	public Date getBirthday(){
		return this.birthday;
	}

	public void setWorkYear(String workYear){
		this.workYear = workYear;
	}

	public String getWorkYear(){
		return this.workYear;
	}

	public void setTelephone(String telephone){
		this.telephone = telephone;
	}

	public String getTelephone(){
		return this.telephone;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setIdCard(String idCard){
		this.idCard = idCard;
	}

	public String getIdCard(){
		return this.idCard;
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

	public void setIsOpen(Integer isOpen){
		this.isOpen = isOpen;
	}

	public Integer getIsOpen(){
		return this.isOpen;
	}

	public void setSelfEvaluation(String selfEvaluation){
		this.selfEvaluation = selfEvaluation;
	}

	public String getSelfEvaluation(){
		return this.selfEvaluation;
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

	public void setData9(Integer data9){
		this.data9 = data9;
	}

	public Integer getData9(){
		return this.data9;
	}

	public void setEducation(Integer education){
		this.education = education;
	}

	public Integer getEducation(){
		return this.education;
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
