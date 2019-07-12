package com.lz.authentication.service.impl;

import com.lz.authentication.bean.SysUser;
import com.lz.authentication.dao.UserDao;
import com.lz.authentication.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author DELL
 * @create 2019/6/14
 * @since 1.0.0
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public SysUser getUserByName(String username) {
        return userDao.selectByName(username);
    }
}
