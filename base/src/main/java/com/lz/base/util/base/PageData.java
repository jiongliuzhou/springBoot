package com.lz.base.util.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *  封装成分页组件需要的格式
 * @author lz
 * @create 2019/7/23
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageData {
    private int total;
    private List<?> rows;
}
