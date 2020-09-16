package com.fenrir.service.impl;

import org.springframework.stereotype.Service;

import com.fenrir.entity.BasicListResponseGenericityVO;
import com.fenrir.entity.BasicResponseGenericityVO;
import com.fenrir.entity.BasicResponseVO;
import com.fenrir.entity.BookVO;
import com.fenrir.service.BookService;

/**
 * service - 书本管理
 * @author fenrir
 *
 */
@Service
public class BookServiceImpl implements BookService {
	
	@Override
	public BasicResponseGenericityVO<BasicListResponseGenericityVO<BookVO>> queryAll(
		Integer pageNumber, Integer pageSize
	) {
		BasicListResponseGenericityVO<BookVO> listResponse = new BasicListResponseGenericityVO<BookVO>();
		
		return new BasicResponseGenericityVO<BasicListResponseGenericityVO<BookVO>>(200, "OK", listResponse);
	}

	@Override
	public BasicResponseVO add(BookVO vo) {
		return new BasicResponseVO(
			200, "OK", 
			"该demo只是为了展示swagger2的接口文档生成,请访问http://localhost:6001/swagger-ui.html或http://localhost:6001/doc.html"
		);
	}

	@Override
	public BasicResponseVO update(BookVO vo) {
		return new BasicResponseVO(
			200, "OK", 
			"该demo只是为了展示swagger2的接口文档生成,请访问http://localhost:6001/swagger-ui.html或http://localhost:6001/doc.html"
		);
	}

	@Override
	public BasicResponseVO deleteById(Integer id) {
		return new BasicResponseVO(
			200, "OK", 
			"该demo只是为了展示swagger2的接口文档生成,请访问http://localhost:6001/swagger-ui.html或http://localhost:6001/doc.html"
		);
	}

}