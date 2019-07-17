package com.lz.authentication.dao.provider;

import com.lz.authentication.bean.request.ResourceRequest;
import com.lz.authentication.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 系统资源
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
@Slf4j
public class SysResourceProvider {
    /**
     * 获取查询资源列表sql
     * @param param
     * @return
     */
    public String getResourceList(ResourceRequest param){
        SQL sql=new SQL();
        sql.SELECT("RESOURCE_ID resourceId","RESOURCE_NAME resourceName","URL url","PARENT_RESOURCE_ID parentResourceId")
                .FROM(Constants.SYS_RESOURCE.getKey());
        sql.WHERE("STATUS=0");
        if(param.getResourceName()!=null && !"".equals(param.getResourceName())){
            sql.WHERE("RESOURCE_NAME=#{resourceName}");
        }
        return sql.toString();
    }

    /**
     * 获取查询资源详情sql
     * @param param
     * @return
     */
    public String getResourceInfo(@Param("param") ResourceRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.SELECT("RESOURCE_ID resourceId","RESOURCE_NAME resourceName","URL url","PARENT_RESOURCE_ID parentResourceId")
                .FROM(Constants.SYS_RESOURCE.getKey())
                .WHERE("STATUS=0")
                .WHERE("RESOURCE_ID=#{param.resourceId}");
        return sql.toString();
    }

    /**
     * 获取新增资源sql
     * @param param
     * @return
     */
    public String insertResource(ResourceRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.INSERT_INTO(Constants.SYS_RESOURCE.getKey())
                .INTO_COLUMNS("RESOURCE_ID","RESOURCE_NAME","URL","PARENT_RESOURCE_ID","CREATE_TIME")
                .INTO_VALUES("#{resourceId}","#{resourceName}","#{url}","#{parentResourceId}","#{createTime}");
        return sql.toString();
    }

    /**
     * 获取修改资源sql
     * @param param
     * @return
     */
    public String updateResource(ResourceRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.UPDATE(Constants.SYS_RESOURCE.getKey())
                .SET("RESOURCE_NAME=#{resourceName}","URL=#{url}","PARENT_RESOURCE_ID=#{parentResourceId}","UPDATE_TIME=#{updateTime}")
                .WHERE("RESOURCE_ID=#{resourceId}");
        return sql.toString();
    }

    /**
     * 获取删除资源sql
     * @param param
     * @return
     */
    public String deleteResource(ResourceRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.DELETE_FROM(Constants.SYS_RESOURCE.getKey())
                .WHERE("RESOURCE_ID=#{resourceId}");
        return sql.toString();
    }
}
