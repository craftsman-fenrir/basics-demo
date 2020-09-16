package com.fenrir.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fenrir.entity.BookPO;

/**
 * dao - 书本管理（spring boot cache使用demo）
 * @author fenrir
 *
 */
public interface CacheDao {

	String COLUMNS = "id,book_name,author,total,price,introduction,creation_time,updated_time";
	
	@Select(
		"SELECT " + COLUMNS + " FROM test_book WHERE book_name LIKE CONCAT('%', #{bookName}, '%')"
	)
	List<BookPO> cacheable(@Param("bookName")String bookName);
	
}