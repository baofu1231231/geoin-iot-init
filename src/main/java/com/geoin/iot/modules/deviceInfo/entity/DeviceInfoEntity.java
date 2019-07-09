package com.geoin.iot.modules.deviceInfo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
@Data
@TableName("tb_device_info")
public class DeviceInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String sn;
	/**
	 * 0:无类型，1：安全帽，2：电池
	 */
	private Integer type;
	/**
	 * IMEI
	 */
	private String imei;
	/**
	 * 物联网卡号
	 */
	private String iotcard;
	/**
	 * 0 激活 1 激活
	 */
	private Integer activited;
	/**
	 * 激活时间
	 */
	private Date actidate;
	/**
	 * 在线状态  0 离线 1 在线
	 */
	private Integer status;
	/**
	 * 录入时阿
	 */
	private Date regdate;
	/**
	 * 纬度
	 */
	private BigDecimal lat;
	/**
	 * 经度
	 */
	private BigDecimal lon;
	/**
	 * 高度
	 */
	private BigDecimal height;
	/**
	 * 电池充电次数（）
	 */
	private Integer chargenum;
	/**
	 * 所属用户手机号
	 */
	private String ownerphone;
	/**
	 * 电压
	 */
	private Float voltage;
	/**
	 * 可见卫星数
	 */
	private Integer satview;

	private Float snrmax;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getIotcard() {
		return iotcard;
	}

	public void setIotcard(String iotcard) {
		this.iotcard = iotcard;
	}

	public Integer getActivited() {
		return activited;
	}

	public void setActivited(Integer activited) {
		this.activited = activited;
	}

	public Date getActidate() {
		return actidate;
	}

	public void setActidate(Date actidate) {
		this.actidate = actidate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public Date getPostime() {
		return postime;
	}

	public void setPostime(Date postime) {
		this.postime = postime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 定位时间
	 */
	private Date postime;
	/**
	 * 位置
	 */
	private String location;

}
