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
 * po - 用户
 * @author fenrir
 *
 */
@Entity
@Table(name = "tb_user")
@Data
public class UserPO {

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	/**
	 * 用户名
	 */
	@Column(name = "username")
	private String userName;
	
	/**
	 * 密码
	 */
	@Column(name = "password")
	private String password;
	
	/**
	 * 注册手机号
	 */
	@Column(name = "phone")
	private String phone;
	
	/**
	 * 注册邮箱
	 */
	@Column(name = "email")
	private String email;
	
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