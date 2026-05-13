package com.erp.mapper;

import com.erp.entity.SalesOrderItem;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SalesOrderItemMapper {
    int insert(SalesOrderItem item);
    int deleteByOrderId(Long orderId);
    List<SalesOrderItem> selectByOrderId(Long orderId);
}
