package com.erp.mapper;

import com.erp.entity.PurchaseOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface PurchaseOrderMapper {
    int insert(PurchaseOrder order);
    int update(PurchaseOrder order);
    int deleteById(Long id);
    PurchaseOrder selectById(Long id);
    List<PurchaseOrder> selectList(@Param("orderNo") String orderNo,
                                   @Param("offset") int offset,
                                   @Param("limit") int limit);
    int count(@Param("orderNo") String orderNo);
}
