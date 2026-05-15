package com.erp.mapper;

import com.erp.entity.PurchaseOrderItem;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PurchaseOrderItemMapper {
    int insert(PurchaseOrderItem item);
    int deleteByOrderId(Long orderId);
    List<PurchaseOrderItem> selectByOrderId(Long orderId);
}
