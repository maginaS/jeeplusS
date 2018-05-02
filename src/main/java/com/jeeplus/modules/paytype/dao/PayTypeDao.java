/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.paytype.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.paytype.entity.PayType;

/**
 * 支付方式DAO接口
 * @author 瞿高青
 * @version 2017-11-08
 */
@MyBatisDao
public interface PayTypeDao extends CrudDao<PayType> {

	
}