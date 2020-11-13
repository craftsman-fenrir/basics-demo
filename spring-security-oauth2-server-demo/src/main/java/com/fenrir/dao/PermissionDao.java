package com.fenrir.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.fenrir.entity.PermissionPO;

/**
 * dao - 授权管理
 * @author fenrir
 *
 */
public interface PermissionDao {

	String COLUMNS = "id,parent_id,name,enname,url,description,created,updated";
	
	/**
	 * 根据用户id查询授权
	 * @param userId
	 * @return
	 */
	@Select(
		"SELECT " + COLUMNS + " FROM tb_permission WHERE id IN (" + 
		"	SELECT permission_id FROM tb_role_permission WHERE role_id IN (" + 
		"		SELECT role_id FROM tb_user_role WHERE user_id = #{userId}" + 
		"	)" + 
		")"
	)
	List<PermissionPO> selectByUserId(@Param("userId") int userId);
	
}