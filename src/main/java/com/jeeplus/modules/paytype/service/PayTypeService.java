/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.paytype.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.paytype.entity.PayType;
import com.jeeplus.modules.paytype.dao.PayTypeDao;

/**
 * 支付方式Service
 * @author 瞿高青
 * @version 2017-11-08
 */
@Service
@Transactional(readOnly = true)
public class PayTypeService extends CrudService<PayTypeDao, PayType> {

	public PayType get(String id) {
		return super.get(id);
	}
	
	public List<PayType> findList(PayType payType) {
		return super.findList(payType);
	}
	
	public Page<PayType> findPage(Page<PayType> page, PayType payType) {
		return super.findPage(page, payType);
	}
	
	@Transactional(readOnly = false)
	public void save(PayType payType) {
		super.save(payType);
	}
	
	@Transactional(readOnly = false)
	public void delete(PayType payType) {
		super.delete(payType);
	}
	
	
	
	
}