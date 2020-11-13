package com.fenrir.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fenrir.entity.UserPO;

/**
 * dao - 用户信息
 * @author fenrir
 *
 */
public interface UserDao {

	String COLUMNS = "id,username,password,phone,email,created,updated";
	
	/**
	 * 根据名字获取用户
	 * @param username
	 * @return
	 */
	@Select(
		"SELECT " + COLUMNS + " FROM tb_user WHERE username = #{username}"
	)
	UserPO getByUsername(@Param("username") String username);
	
}