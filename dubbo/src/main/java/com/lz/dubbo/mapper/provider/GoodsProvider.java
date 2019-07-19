package com.lz.dubbo.mapper.provider;

import com.lz.api.bean.request.GoodsParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

/**
 * 商品管理SQL提供类
 * @create 2019/5/21
 * @since 1.0.0
 */
@Slf4j
public class GoodsProvider {
    private static final String TABLE_NAME="LZ_GOODS";
    /**
     * 获取查询商品列表sql
     * @param param
     * @return
     */
    public String getGoodList(GoodsParam param){
        SQL sql=new SQL();
        sql.SELECT("GOOD_ID goodId","GOOD_NAME goodName","GOOD_PRICE goodPrice","GOOD_STOCK goodStock")
                .FROM(TABLE_NAME);
        sql.WHERE("STATUS=0");
        if(param.getGoodsName()!=null && !"".equals(param.getGoodsName())){
            sql.WHERE("GOOD_NAME=#{goodName}");
        }
        return sql.toString();
    }

}
