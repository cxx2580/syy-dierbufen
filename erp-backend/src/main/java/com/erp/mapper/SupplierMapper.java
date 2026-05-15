package com.erp.mapper;

import com.erp.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SupplierMapper {
    int insert(Supplier supplier);
    int update(Supplier supplier);
    int deleteById(Long id);
    Supplier selectById(Long id);
    List<Supplier> selectList(@Param("supplierName") String supplierName,
                              @Param("offset") int offset,
                              @Param("limit") int limit);
    int count(@Param("supplierName") String supplierName);
}
