package com.lz.base.util.base;

import lombok.Data;

/**
 *  基础参数bean
 * @create 2019/5/21
 * @since 1.0.0
 */
@Data
public class BaseRequest {
    private Integer pageNum=1;
    private Integer pageSize=10;
}
