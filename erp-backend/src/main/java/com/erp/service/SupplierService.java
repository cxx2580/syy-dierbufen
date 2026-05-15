package com.erp.service;

import com.erp.common.PageResult;
import com.erp.entity.Supplier;
import com.erp.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    public int add(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    public int update(Supplier supplier) {
        return supplierMapper.update(supplier);
    }

    public int delete(Long id) {
        return supplierMapper.deleteById(id);
    }

    public Supplier getById(Long id) {
        return supplierMapper.selectById(id);
    }

    public PageResult<Supplier> list(String supplierName, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Supplier> list = supplierMapper.selectList(supplierName, offset, pageSize);
        int total = supplierMapper.count(supplierName);
        return PageResult.of(total, list, page, pageSize);
    }
}
