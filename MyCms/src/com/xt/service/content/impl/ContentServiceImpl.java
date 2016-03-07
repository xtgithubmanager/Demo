package com.xt.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.bean.Content;
import com.xt.bean.XtParmas;
import com.xt.dao.content.IContentMapper;
import com.xt.service.content.IContentService;

@Service
public class ContentServiceImpl implements IContentService {
	@Autowired
	private IContentMapper contentMapper;
	
	@Override
	public List<Content> findContent(XtParmas parmas) {
		return contentMapper.findContent(parmas);
	}

	@Override
	public int countContent(XtParmas parmas) {
		return contentMapper.countContent(parmas);
	}

	@Override
	public int update(Content content) {
		return contentMapper.update(content);
	}

	@Override
	public int delete(XtParmas parmas) {
		return contentMapper.delete(parmas);
	}
}
