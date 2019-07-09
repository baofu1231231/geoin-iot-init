package com.geoin.iot.modules.DeviceSupplement.entity;

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
@TableName("tb_device_supplement")
public class DeviceSupplementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * SN设备SN
	 */
	private String sn;
	/**
	 * 可见卫星数
	 */
	private Integer satview;
	/**
	 * 使用卫星数
	 */
	private Integer satused;
	/**
	 * 
	 */
	private Float snrmax;
	/**
	 * 电压
	 */
	private Float voltage;
	/**
	 * 电池偷盗
	 */
	private Integer stealbattry;
	/**
	 * 0 正常  1  报警
	 */
	private Integer chargeindoor;
	/**
	 * 非法移动
	 */
	private Integer movingunusual;
	/**
	 * 0 在电子围栏内  1 在电子围栏外
	 */
	private Integer efencing;
	/**
	 * 生产厂家
	 */
	private String manufacturer;
	/**
	 * 电池型号
	 */
	private String sku;
	/**
	 * 电池充电次数（）
	 */
	private Integer chargenum;
	/**
	 * 所属用户手机号
	 */
	private String ownerphone;
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
	 * 定位时间
	 */
	private Date postime;
	/**
	 * 位置
	 */
	private String location;

	private Double speed;

}
