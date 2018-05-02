/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.statistics.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeeplus.common.persistence.DataEntity;
import com.jeeplus.common.utils.excel.annotation.ExcelField;

/**
 * 销售统计Entity
 * @author 瞿高青
 * @version 2017-10-17
 */
public class Checks extends DataEntity<Checks> {
	
	private static final long serialVersionUID = 1L;
	private String num;		// 订单编号
	private String status;		// 订单状态
	private String type;		// 订单类型
	private Date order_date;		// 下单时间
	private Date send_date;		// 发送给物流时间
	private Date accept_date;		// 物流接收时间
	private Date receiving_date;		// 收货人接收时间
	private Double total_amount;		// 订单总金额
	private Double discount_amount;		// 折扣金额
	private Double coupon_amount;		// 优惠券金额
	private Double integral_amount;		// 积分抵扣金额
	private Double freight_amount;		// 运费
	private Double com_amount;		// 商品金额
	private String pay_code;		// 支付方式
	private String delivery_id;		// 配送方式表id
	private String consignee;		// 收货人
	private String phone;		// 收货人电话
	private String country_id;		// 国家表id
	private String country_name;		// 国家名称
	private String state_id;		// 省级表id
	private String state_name;		// 收货地址省份名称
	private String city_id;		// 收货地址市级表id
	private String city_name;		// 收货地址市级名称
	private String area_id;		// 收货地址区县表id
	private String area_name;		// 收货地址区县名称
	private String address_id;		// 会员地址表id
	private String address_name;		// 会员详细地址
	private Integer invoice_type;		// 发票类型
	private String invoice_company;		// 发票抬头
	private String invoice_ein;		// 发票税号
	private String remark;		// 订单备注
	private Double number;      //销售量
	
	public Checks() {
		super();
	}

	public Checks(String id){
		super(id);
	}

	@ExcelField(title="订单编号", align=2, sort=7)
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	@ExcelField(title="订单状态", align=2, sort=8)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ExcelField(title="订单类型", align=2, sort=9)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="下单时间", align=2, sort=10)
	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="发送给物流时间", align=2, sort=11)
	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="物流接收时间", align=2, sort=12)
	public Date getAccept_date() {
		return accept_date;
	}

	public void setAccept_date(Date accept_date) {
		this.accept_date = accept_date;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="收货人接收时间", align=2, sort=13)
	public Date getReceiving_date() {
		return receiving_date;
	}

	public void setReceiving_date(Date receiving_date) {
		this.receiving_date = receiving_date;
	}
	
	@ExcelField(title="订单总金额", align=2, sort=14)
	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	
	@ExcelField(title="折扣金额", align=2, sort=15)
	public Double getDiscount_amount() {
		return discount_amount;
	}

	public void setDiscount_amount(Double discount_amount) {
		this.discount_amount = discount_amount;
	}
	
	@ExcelField(title="优惠券金额", align=2, sort=16)
	public Double getCoupon_amount() {
		return coupon_amount;
	}

	public void setCoupon_amount(Double coupon_amount) {
		this.coupon_amount = coupon_amount;
	}
	
	@ExcelField(title="积分抵扣金额", align=2, sort=17)
	public Double getIntegral_amount() {
		return integral_amount;
	}

	public void setIntegral_amount(Double integral_amount) {
		this.integral_amount = integral_amount;
	}
	
	@ExcelField(title="运费", align=2, sort=18)
	public Double getFreight_amount() {
		return freight_amount;
	}

	public void setFreight_amount(Double freight_amount) {
		this.freight_amount = freight_amount;
	}
	
	@ExcelField(title="商品金额", align=2, sort=19)
	public Double getCom_amount() {
		return com_amount;
	}

	public void setCom_amount(Double com_amount) {
		this.com_amount = com_amount;
	}
	
	@ExcelField(title="支付方式", align=2, sort=20)
	public String getPay_code() {
		return pay_code;
	}

	public void setPay_code(String pay_code) {
		this.pay_code = pay_code;
	}
	
	@ExcelField(title="配送方式表id", align=2, sort=21)
	public String getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}
	
	@ExcelField(title="收货人", align=2, sort=22)
	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	@ExcelField(title="收货人电话", align=2, sort=23)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@ExcelField(title="国家表id", align=2, sort=24)
	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	
	@ExcelField(title="国家名称", align=2, sort=25)
	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	
	@ExcelField(title="省级表id", align=2, sort=26)
	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	
	@ExcelField(title="收货地址省份名称", align=2, sort=27)
	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	
	@ExcelField(title="收货地址市级表id", align=2, sort=28)
	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	
	@ExcelField(title="收货地址市级名称", align=2, sort=29)
	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
	@ExcelField(title="收货地址区县表id", align=2, sort=30)
	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	
	@ExcelField(title="收货地址区县名称", align=2, sort=31)
	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	
	@ExcelField(title="会员地址表id", align=2, sort=32)
	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	
	@ExcelField(title="会员详细地址", align=2, sort=33)
	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	
	@ExcelField(title="发票类型", align=2, sort=34)
	public Integer getInvoice_type() {
		return invoice_type;
	}

	public void setInvoice_type(Integer invoice_type) {
		this.invoice_type = invoice_type;
	}
	
	@ExcelField(title="发票抬头", align=2, sort=35)
	public String getInvoice_company() {
		return invoice_company;
	}

	public void setInvoice_company(String invoice_company) {
		this.invoice_company = invoice_company;
	}
	
	@ExcelField(title="发票税号", align=2, sort=36)
	public String getInvoice_ein() {
		return invoice_ein;
	}

	public void setInvoice_ein(String invoice_ein) {
		this.invoice_ein = invoice_ein;
	}
	
	@ExcelField(title="订单备注", align=2, sort=37)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@ExcelField(title="销售量", align=2, sort=37)
	public Double getNumber() {
		return number;
	}

	
	
}