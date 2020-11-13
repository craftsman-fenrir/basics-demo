package com.fenrir.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * po - 权限
 * @author fenrir
 *
 */
@Entity
@Table(name = "tb_permission")
@Data
public class PermissionPO {

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	/**
	 * 上级id
	 */
	@Column(name = "parent_id")
	private Integer parentId;
	
	/**
	 * 权限名称
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 权限英文名称
	 */
	@Column(name = "enname")
	private String enname;
	
	/**
	 * 授权路径
	 */
	@Column(name = "url")
	private String url;
	
	/**
	 * 备注
	 */
	@Column(name = "description")
	private String description;
	
	/**
	 * 创建时间
	 */
	@Column(name = "created")
	private Timestamp created;
	
	/**
	 * 更新时间
	 */
	@Column(name = "updated")
	private Timestamp updated;

}