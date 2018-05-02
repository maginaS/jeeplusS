/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.statistics.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.statistics.entity.Member;

/**
 * 会员统计DAO接口
 * @author 瞿高青
 * @version 2017-10-17
 */
@MyBatisDao
public interface MemberDao extends CrudDao<Member> {

	
}