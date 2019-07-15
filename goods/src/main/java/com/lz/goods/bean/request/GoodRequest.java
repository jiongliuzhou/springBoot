package com.lz.goods.bean.request;

import com.lz.base.util.base.BaseRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *  参数接收bean
 * @create 2019/5/21
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@ToString
public class GoodRequest extends BaseRequest {
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

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 状态
     */
    private String status;
}
