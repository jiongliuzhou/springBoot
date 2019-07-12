package com.lz.authentication.dao;

import com.lz.authentication.bean.SysPermission;
import com.lz.authentication.bean.SysRole;
import com.lz.authentication.bean.SysUser;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

/**
 * 用户权限管理
 * @author lz
 * @create 2019/6/14
 * @since 1.0.0
 */
@Repository
public class UserDao {
    private SysRole admin = new SysRole("ADMIN", "管理员");
    private SysRole developer = new SysRole("DEVELOPER", "开发者");
    {
        SysPermission p1 = new SysPermission();
        p1.setCode("company");
        p1.setName("企业管理列表");
        p1.setUrl("/companyController/getCompanyList");
        SysPermission p2 = new SysPermission();
        p2.setCode("user");
        p2.setName("用户管理列表");
        p2.setUrl("/userController/getUserList");
        admin.setPermissionList(Arrays.asList(p1, p2));
        developer.setPermissionList(Arrays.asList(p1));

    }
    public SysUser selectByName(String userName) {
        if ("zhangsan".equals(userName)) {
            SysUser sysUser = new SysUser("zhangsan", "123456");
            sysUser.setRoleList(Arrays.asList(admin, developer));
            return sysUser;
        }else if ("lisi".equals(userName)) {
            SysUser sysUser = new SysUser("lisi", "123456");
            sysUser.setRoleList(Arrays.asList(developer));
            return sysUser;
        }
        return null;
    }
}
