package com.lz.goods.bean.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *  页面返回bean
 * @create 2019/5/21
 * @since 1.0.0
 */
@Data
@ToString
@NoArgsConstructor
public class GoodVO {
    /**
     * 编号
     */
    private String goodId;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 商品价格
     */
    private String goodPrice;
    /**
     * 商品库存
     */
    private String goodStock;
}
