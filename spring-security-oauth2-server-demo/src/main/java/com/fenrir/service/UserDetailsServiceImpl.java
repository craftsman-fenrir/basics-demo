package com.fenrir.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fenrir.dao.PermissionDao;
import com.fenrir.dao.UserDao;
import com.fenrir.entity.PermissionPO;
import com.fenrir.entity.UserPO;

/**
 * 用户信息服务，spring security用于做登录验证
 * @author fenrir
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PermissionDao permissionDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 查询用户信息
		UserPO user = userDao.getByUsername(username);
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		
		if (null != user) {
			// 获取用户授权
			List<PermissionPO> permissions = permissionDao.selectByUserId(user.getId());
			
			// 设置用户授权
			int size = permissions.size();
			for (int i = 0; i < size; i++) {
				if (permissions != null && permissions.get(i).getEnname() != null) {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissions.get(i).getEnname());
					grantedAuthorities.add(grantedAuthority);
				}
			}
		}
		
		// 返回用户信息
		return new User(user.getUserName(), user.getPassword(), grantedAuthorities);
	}

}