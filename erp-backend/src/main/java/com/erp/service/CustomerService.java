package com.erp.service;

import com.erp.common.PageResult;
import com.erp.entity.Customer;
import com.erp.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public int add(Customer customer) {
        return customerMapper.insert(customer);
    }

    public int update(Customer customer) {
        return customerMapper.update(customer);
    }

    public int delete(Long id) {
        return customerMapper.deleteById(id);
    }

    public Customer getById(Long id) {
        return customerMapper.selectById(id);
    }

    public PageResult<Customer> list(String customerName, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Customer> list = customerMapper.selectList(customerName, offset, pageSize);
        int total = customerMapper.count(customerName);
        return PageResult.of(total, list, page, pageSize);
    }
}
