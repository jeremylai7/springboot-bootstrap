package com.springbootbootstrap.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: laizc
 * @Date: Created in 9:48 2019-06-27
 */
@Getter
@Setter
public class PageBean {
    /**
     * 第几条数据开始
     */
    private Integer offset;

    /**
     * 每页大小
     */
    private Integer limit;

    /**
     * 搜索
     */
    private String search;

    /**
     * 排序
     */
    private String order;

    /**
     * 搜索字段
     */
    private String sort;
}
