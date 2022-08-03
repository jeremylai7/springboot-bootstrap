package com.springbootbootstrap.util;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: laizc
 * @Date: 2019/6/30 00:57
 * @Description:
 */
@Getter
@Setter
public class TableData<T> {
    private Integer total;

    private List<T> rows;

    private TableData(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    /**
     * 服务端分页返回数据
     * @param total 总记录数
     * @param rows 显示数据
     * @param <T> 实体对象
     * @return 表格数据
     */
    public static <T> TableData<T> bulid(int total, List<T> rows) {
        return new TableData<>(total, rows);
    }

    /**
     * 返回空数据
     * @param <T>
     * @return
     */
    public static <T> TableData<T> empty(){
        return new TableData<T>(0,new ArrayList<T>(0));
    }

}
