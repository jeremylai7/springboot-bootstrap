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
     * 页码
     */
    private Integer pageNumber;

    /**
     * 每页显示个数
     */
    private Integer pageSize;
}
