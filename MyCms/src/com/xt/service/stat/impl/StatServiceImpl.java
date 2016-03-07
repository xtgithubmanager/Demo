package com.xt.service.stat.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.bean.Stat;
import com.xt.bean.XtParmas;
import com.xt.dao.stat.IStatMapper;
import com.xt.service.stat.IStatService;

/**
 * 
 * 后台日志信息管理
 * StatServiceImp;
 * 创建人:肖腾
 * 时间：2016-01-14 05-49-21
 * @version 1.0.0
 *
 */
@Service
public class StatServiceImpl implements IStatService {
	@Autowired
	private IStatMapper statMapper;
	
	@Override
	public List<Stat> findStat(XtParmas parmas) {
		return statMapper.findStat(parmas);
	}

	@Override
	public int save(Stat stat) {
		return statMapper.save(stat);
	}
}
