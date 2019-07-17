package com.lz.authentication.support;

import com.lz.authentication.bean.vo.SysPermission;
import com.lz.authentication.bean.vo.SysRole;
import com.lz.authentication.bean.vo.SysUser;
import com.lz.authentication.service.SysUserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户授权
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource(name="sysUserServiceImpl")
    private SysUserService userService;

    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     */
    @Override
    public UserDetails loadUserByUsername(String username){
        SysUser sysUser = userService.getUserByName(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException(username);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (SysRole role : sysUser.getRoleList()) {
            for (SysPermission permission : role.getPermissionList()) {
                authorities.add(new SimpleGrantedAuthority(permission.getPermissionId()));
            }
        }
        return new User(sysUser.getUserName(), sysUser.getPassword(), authorities);
    }
}
