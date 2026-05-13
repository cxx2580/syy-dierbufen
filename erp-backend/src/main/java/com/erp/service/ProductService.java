package com.erp.service;

import com.erp.common.PageResult;
import com.erp.entity.Product;
import com.erp.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public int add(Product product) {
        return productMapper.insert(product);
    }

    public int update(Product product) {
        return productMapper.update(product);
    }

    public int delete(Long id) {
        return productMapper.deleteById(id);
    }

    public Product getById(Long id) {
        return productMapper.selectById(id);
    }

    public PageResult<Product> list(String productName, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Product> list = productMapper.selectList(productName, offset, pageSize);
        int total = productMapper.count(productName);
        return PageResult.of(total, list, page, pageSize);
    }
}
