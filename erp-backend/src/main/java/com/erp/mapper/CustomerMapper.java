package com.erp.mapper;

import com.erp.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CustomerMapper {
    int insert(Customer customer);
    int update(Customer customer);
    int deleteById(Long id);
    Customer selectById(Long id);
    List<Customer> selectList(@Param("customerName") String customerName,
                              @Param("offset") int offset,
                              @Param("limit") int limit);
    int count(@Param("customerName") String customerName);
}
