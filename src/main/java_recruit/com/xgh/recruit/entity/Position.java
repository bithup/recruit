package com.xgh.recruit.entity;
import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Position implements Serializable {

	/**主键id**/
	private long id;

	/**企业id**/
	private long companyId;

	/**工作性质**/
	private int jobType;

	/**职位名称**/
	private String jobName;

	/**职位类型id**/
	private long jobKindsId;

	/**职位类型名称**/
	private String jobKindsName;

	/**招聘人数**/
	private int recruitingNum;

	/**学历**/
	private int qualification;

	/**经验**/
	private int experience;

	/**薪资待遇起点**/
	private String salaryMin;

	/**薪资终点**/
	private String salaryMax;

	/**（考虑到兼职）薪资类型：1月；2天；3小时**/
	private int unit;

	/**职位描述**/
	private String jobDescription;

	/**福利待遇**/
	private String welfareTreatment;

	/**职位标签**/
	private String positionLabel;

	/**技能要求**/
	private String skillsRequirement;

	/**工作所属区域id**/
	private long zoneId;

	/**工作所属区域**/
	private String zoneName;

	/**工作地详细地址**/
	private String address;

	/**是否接收简历：1是；2否**/
	private int isReceive;

	/**职位状态：1正常；2冻结**/
	private int positionStatus;

	/**发布状态：1发布；2不发布**/
	private int releaseStatus;

	/**简历接收邮箱**/
	private String receiveMailbox;

	/**联系电话**/
	private String telephone;

	/**联系人**/
	private String contacts;

	/**职位失效日期**/
	private Date expiryDate;

	/**审核状态：0未审核；1审核通过；2审核不通过**/
	private int isCheck;

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

	/**备用字段10**/
	private int data10;

	/**备用字段11**/
	private Double data11;

	/**备用字段12**/
	private Double data12;


	public Position() { super(); }

	public Position(long id) {
	 super();
	 this.id=id;
	}

	public Position(long id,long companyId,int jobType,String jobName,long jobKindsId,String jobKindsName,int recruitingNum,int qualification,int experience,String salaryMin,String salaryMax,int unit,String jobDescription,String welfareTreatment,String positionLabel,String skillsRequirement,long zoneId,String zoneName,String address,int isReceive,int positionStatus,int releaseStatus,String receiveMailbox,String telephone,String contacts,Date expiryDate,int isCheck,Date createDate,Date updateDate,int status,long data1,long data2,String data3,String data4,String data5,String data6,String data7,String data8,int data9,int data10,Double data11,Double data12){
		super();
		this.id = id;
		this.companyId = companyId;
		this.jobType = jobType;
		this.jobName = jobName;
		this.jobKindsId = jobKindsId;
		this.jobKindsName = jobKindsName;
		this.recruitingNum = recruitingNum;
		this.qualification = qualification;
		this.experience = experience;
		this.salaryMin = salaryMin;
		this.salaryMax = salaryMax;
		this.unit = unit;
		this.jobDescription = jobDescription;
		this.welfareTreatment = welfareTreatment;
		this.positionLabel = positionLabel;
		this.skillsRequirement = skillsRequirement;
		this.zoneId = zoneId;
		this.zoneName = zoneName;
		this.address = address;
		this.isReceive = isReceive;
		this.positionStatus = positionStatus;
		this.releaseStatus = releaseStatus;
		this.receiveMailbox = receiveMailbox;
		this.telephone = telephone;
		this.contacts = contacts;
		this.expiryDate = expiryDate;
		this.isCheck = isCheck;
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

	public void setCompanyId(Long companyId){
		this.companyId = companyId;
	}

	public Long getCompanyId(){
		return this.companyId;
	}

	public void setJobType(Integer jobType){
		this.jobType = jobType;
	}

	public Integer getJobType(){
		return this.jobType;
	}

	public void setJobName(String jobName){
		this.jobName = jobName;
	}

	public String getJobName(){
		return this.jobName;
	}

	public void setJobKindsId(Long jobKindsId){
		this.jobKindsId = jobKindsId;
	}

	public Long getJobKindsId(){
		return this.jobKindsId;
	}

	public void setJobKindsName(String jobKindsName){
		this.jobKindsName = jobKindsName;
	}

	public String getJobKindsName(){
		return this.jobKindsName;
	}

	public void setRecruitingNum(Integer recruitingNum){
		this.recruitingNum = recruitingNum;
	}

	public Integer getRecruitingNum(){
		return this.recruitingNum;
	}

	public void setQualification(Integer qualification){
		this.qualification = qualification;
	}

	public Integer getQualification(){
		return this.qualification;
	}

	public void setExperience(Integer experience){
		this.experience = experience;
	}

	public Integer getExperience(){
		return this.experience;
	}

	public void setSalaryMin(String salaryMin){
		this.salaryMin = salaryMin;
	}

	public String getSalaryMin(){
		return this.salaryMin;
	}

	public void setSalaryMax(String salaryMax){
		this.salaryMax = salaryMax;
	}

	public String getSalaryMax(){
		return this.salaryMax;
	}

	public void setUnit(Integer unit){
		this.unit = unit;
	}

	public Integer getUnit(){
		return this.unit;
	}

	public void setJobDescription(String jobDescription){
		this.jobDescription = jobDescription;
	}

	public String getJobDescription(){
		return this.jobDescription;
	}

	public void setWelfareTreatment(String welfareTreatment){
		this.welfareTreatment = welfareTreatment;
	}

	public String getWelfareTreatment(){
		return this.welfareTreatment;
	}

	public void setPositionLabel(String positionLabel){
		this.positionLabel = positionLabel;
	}

	public String getPositionLabel(){
		return this.positionLabel;
	}

	public void setSkillsRequirement(String skillsRequirement){
		this.skillsRequirement = skillsRequirement;
	}

	public String getSkillsRequirement(){
		return this.skillsRequirement;
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

	public void setIsReceive(Integer isReceive){
		this.isReceive = isReceive;
	}

	public Integer getIsReceive(){
		return this.isReceive;
	}

	public void setPositionStatus(Integer positionStatus){
		this.positionStatus = positionStatus;
	}

	public Integer getPositionStatus(){
		return this.positionStatus;
	}

	public void setReleaseStatus(Integer releaseStatus){
		this.releaseStatus = releaseStatus;
	}

	public Integer getReleaseStatus(){
		return this.releaseStatus;
	}

	public void setReceiveMailbox(String receiveMailbox){
		this.receiveMailbox = receiveMailbox;
	}

	public String getReceiveMailbox(){
		return this.receiveMailbox;
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

	public void setExpiryDate(Date expiryDate){
		this.expiryDate = expiryDate;
	}

	public Date getExpiryDate(){
		return this.expiryDate;
	}

	public void setIsCheck(Integer isCheck){
		this.isCheck = isCheck;
	}

	public Integer getIsCheck(){
		return this.isCheck;
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
