package com.quartztask.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "smsPool")
public class MongoSmsPoolEntity implements MongoCommonEntity{

	private String id;

	private Integer sendTimes; //发送次数

	/**
	 * 主键
	 */
	private Integer smsId;

	/**
	 * 短信任务id
	 */
	private Integer smsTaskId;


	/**
	 * 发送手机号码
	 */
	private String toMobile;

	/**
	 * 短信内容
	 */
	private String content;

	/**
	 * 发送优先级 1-9 默认为1
	 */
	private Integer priority;

	/**
	 * 0: 未发送 1: 发送成功 2: 连接超时 3: 发送失败
	 */
	private Integer sendstatus;

	/**
	 * 备注：发送失败时记录错误码
	 */
	private String note;

	/**
	 * 发送人ip地址，应用入口必须记录，后端发送可不纪录
	 */
	private String ipaddr;

	/**
	 * endtime 短信发送时间(1970年以来的毫秒数)
	 */
	private Long sendtime;

	/**
	 * 发送成功时间(1970年以来的毫秒数)
	 */
	private Long successtime;

	private Integer receviedByMq;

	private Long updateTime;

	private Long createTime;

	private Date updateT = new Date();

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

	public Integer getSmsId() {
		return smsId;
	}

	public void setSmsId(Integer smsId) {
		this.smsId = smsId;
	}

	public Integer getSmsTaskId() {
		return smsTaskId;
	}

	public void setSmsTaskId(Integer smsTaskId) {
		this.smsTaskId = smsTaskId;
	}

	public String getToMobile() {
		return toMobile;
	}

	public void setToMobile(String toMobile) {
		this.toMobile = toMobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getSendstatus() {
		return sendstatus;
	}

	public void setSendstatus(Integer sendstatus) {
		this.sendstatus = sendstatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public Long getSendtime() {
		return sendtime;
	}

	public void setSendtime(Long sendtime) {
		this.sendtime = sendtime;
	}

	public Long getSuccesstime() {
		return successtime;
	}

	public void setSuccesstime(Long successtime) {
		this.successtime = successtime;
	}

	public Integer getReceviedByMq() {
		return receviedByMq;
	}

	public void setReceviedByMq(Integer receviedByMq) {
		this.receviedByMq = receviedByMq;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateT() {
		return updateT;
	}

	public void setUpdateT(Date updateT) {
		this.updateT = updateT;
	}
}
