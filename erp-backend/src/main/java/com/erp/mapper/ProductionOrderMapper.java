package com.erp.mapper;

import com.erp.entity.ProductionOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ProductionOrderMapper {
    int insert(ProductionOrder order);
    int update(ProductionOrder order);
    int deleteById(Long id);
    ProductionOrder selectById(Long id);
    List<ProductionOrder> selectList(@Param("productionNo") String productionNo,
                                     @Param("offset") int offset,
                                     @Param("limit") int limit);
    int count(@Param("productionNo") String productionNo);
}
