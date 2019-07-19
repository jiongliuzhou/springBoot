package com.lz.api.bean.request;

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
public class GoodsParam implements Serializable{
    private static final long serialVersionUID = -6573675547775382641L;
    /**
     * 商品名称
     */
    private String goodsName;
}
