package com.fenrir.service;

import org.springframework.stereotype.Service;

import com.fenrir.entity.BasicListVO;
import com.fenrir.entity.BasicResponseGenericityVO;
import com.fenrir.entity.BookVO;

/**
 * service - 书本管理（spring boot cache使用demo）
 * @author fenrir
 *
 */
@Service
public interface CacheService {

	/**
	 * 查询书本
	 * @param bookName
	 * @param condition
	 * @param ndition
	 * @return
	 */
	public BasicResponseGenericityVO<BasicListVO<BookVO>> cacheable(String bookName);
	
}