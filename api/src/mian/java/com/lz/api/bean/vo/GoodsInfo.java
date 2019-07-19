package com.lz.api.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品信息(必须序列化)
 * @author lz
 * @create 2019/7/19
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfo implements Serializable{
    private static final long serialVersionUID = -2568541924933041760L;

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
