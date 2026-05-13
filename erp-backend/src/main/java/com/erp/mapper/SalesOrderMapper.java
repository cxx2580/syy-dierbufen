package com.erp.mapper;

import com.erp.entity.SalesOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SalesOrderMapper {
    int insert(SalesOrder order);
    int update(SalesOrder order);
    int deleteById(Long id);
    SalesOrder selectById(Long id);
    List<SalesOrder> selectList(@Param("orderNo") String orderNo,
                                @Param("offset") int offset,
                                @Param("limit") int limit);
    int count(@Param("orderNo") String orderNo);
}
