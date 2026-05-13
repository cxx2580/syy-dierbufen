package com.erp.mapper;

import com.erp.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ProductMapper {
    int insert(Product product);
    int update(Product product);
    int deleteById(Long id);
    Product selectById(Long id);
    List<Product> selectList(@Param("productName") String productName,
                             @Param("offset") int offset,
                             @Param("limit") int limit);
    int count(@Param("productName") String productName);
}
