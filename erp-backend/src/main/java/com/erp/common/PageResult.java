package com.erp.common;

import lombok.Data;
import java.util.List;

@Data
public class PageResult<T> {
    private long total;
    private List<T> list;
    private int page;
    private int pageSize;

    public static <T> PageResult<T> of(long total, List<T> list, int page, int pageSize) {
        PageResult<T> result = new PageResult<>();
        result.setTotal(total);
        result.setList(list);
        result.setPage(page);
        result.setPageSize(pageSize);
        return result;
    }
}
