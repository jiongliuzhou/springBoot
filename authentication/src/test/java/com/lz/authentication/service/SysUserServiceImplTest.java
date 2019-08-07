package com.lz.authentication.service;

import com.lz.authentication.bean.request.UserRequest;
import com.lz.authentication.bean.vo.SysUser;
import com.lz.authentication.dao.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author DELL
 * @create 2019/8/5
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SysUserServiceImplTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void getUserList(){
        UserRequest param=new UserRequest();
        List<SysUser> userList = sysUserMapper.getUserList(param);
        log.debug(userList.toString());
    }

}
