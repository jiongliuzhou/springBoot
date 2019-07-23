package com.lz.goods.mapper.provider;

import com.lz.goods.bean.request.GoodRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 商品管理SQL提供类
 * @create 2019/5/21
 * @since 1.0.0
 */
@Slf4j
public class GoodProvider {
    private static final String TABLE_NAME="LZ_GOODS";
    /**
     * 获取查询商品列表sql
     * @param param
     * @return
     */
    public String getGoodList(GoodRequest param){
        SQL sql=new SQL();
        sql.SELECT("GOOD_ID goodId","GOOD_NAME goodName","GOOD_PRICE goodPrice","GOOD_STOCK goodStock")
                .FROM(TABLE_NAME);
        sql.WHERE("STATUS=0");
        if(param.getGoodName()!=null && !"".equals(param.getGoodName())){
            param.setGoodName("%"+param.getGoodName()+"%");
            sql.WHERE("GOOD_NAME like #{goodName}");
        }
        return sql.toString();
    }

    /**
     * 获取查询商品详情sql
     * @param param
     * @return
     */
    public String getGoodInfo(@Param("param") GoodRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.SELECT("GOOD_ID goodId","GOOD_NAME goodName","GOOD_PRICE goodPrice","GOOD_STOCK goodStock")
                .FROM(TABLE_NAME)
                .WHERE("STATUS=0")
                .WHERE("GOOD_ID=#{param.goodId}");
        return sql.toString();
    }

    /**
     * 获取新增商品sql
     * @param param
     * @return
     */
    public String insertGood(GoodRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.INSERT_INTO(TABLE_NAME)
                .INTO_COLUMNS("GOOD_ID","GOOD_NAME","GOOD_PRICE","GOOD_STOCK","CREATE_TIME","STATUS")
                .INTO_VALUES("#{goodId}","#{goodName}","#{goodPrice}","#{goodStock}","#{createTime}","#{status}");
        return sql.toString();
    }

    /**
     * 获取修改商品sql
     * @param param
     * @return
     */
    public String updateGood(GoodRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.UPDATE(TABLE_NAME)
                .SET("GOOD_NAME=#{goodName}","GOOD_PRICE=#{goodPrice}","GOOD_STOCK=#{goodStock}","UPDATE_TIME=#{updateTime}")
                .WHERE("GOOD_ID=#{goodId}");
        return sql.toString();
    }

    /**
     * 获取删除商品sql
     * @param param
     * @return
     */
    public String deleteGood(GoodRequest param){
        log.info(param.toString());
        SQL sql=new SQL();
        sql.DELETE_FROM(TABLE_NAME)
                .WHERE("GOOD_ID=#{goodId}");
        return sql.toString();
    }
}
