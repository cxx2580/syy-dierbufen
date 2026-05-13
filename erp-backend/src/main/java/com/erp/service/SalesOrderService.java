package com.erp.service;

import com.erp.common.PageResult;
import com.erp.entity.Product;
import com.erp.entity.SalesOrder;
import com.erp.entity.SalesOrderItem;
import com.erp.mapper.ProductMapper;
import com.erp.mapper.SalesOrderMapper;
import com.erp.mapper.SalesOrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SalesOrderService {
    @Autowired
    private SalesOrderMapper salesOrderMapper;
    @Autowired
    private SalesOrderItemMapper salesOrderItemMapper;
    @Autowired
    private ProductMapper productMapper;

    @Transactional
    public int add(SalesOrder order, List<SalesOrderItem> items) {
        int result = salesOrderMapper.insert(order);
        if (items != null) {
            for (SalesOrderItem item : items) {
                item.setOrderId(order.getId());
                salesOrderItemMapper.insert(item);
                deductStock(item.getProductId(), item.getQuantity());
            }
        }
        return result;
    }

    @Transactional
    public int update(SalesOrder order, List<SalesOrderItem> items) {
        List<SalesOrderItem> oldItems = salesOrderItemMapper.selectByOrderId(order.getId());
        if (oldItems != null) {
            for (SalesOrderItem oldItem : oldItems) {
                restoreStock(oldItem.getProductId(), oldItem.getQuantity());
            }
        }
        int result = salesOrderMapper.update(order);
        salesOrderItemMapper.deleteByOrderId(order.getId());
        if (items != null) {
            for (SalesOrderItem item : items) {
                item.setOrderId(order.getId());
                salesOrderItemMapper.insert(item);
                deductStock(item.getProductId(), item.getQuantity());
            }
        }
        return result;
    }

    @Transactional
    public int delete(Long id) {
        List<SalesOrderItem> items = salesOrderItemMapper.selectByOrderId(id);
        if (items != null) {
            for (SalesOrderItem item : items) {
                restoreStock(item.getProductId(), item.getQuantity());
            }
        }
        salesOrderItemMapper.deleteByOrderId(id);
        return salesOrderMapper.deleteById(id);
    }

    private void deductStock(Long productId, Integer quantity) {
        if (productId != null && quantity != null) {
            Product product = productMapper.selectById(productId);
            if (product != null) {
                product.setStock(product.getStock() - quantity);
                productMapper.update(product);
            }
        }
    }

    private void restoreStock(Long productId, Integer quantity) {
        if (productId != null && quantity != null) {
            Product product = productMapper.selectById(productId);
            if (product != null) {
                product.setStock(product.getStock() + quantity);
                productMapper.update(product);
            }
        }
    }

    public SalesOrder getById(Long id) {
        return salesOrderMapper.selectById(id);
    }

    public List<SalesOrderItem> getItemsByOrderId(Long orderId) {
        return salesOrderItemMapper.selectByOrderId(orderId);
    }

    public PageResult<SalesOrder> list(String orderNo, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<SalesOrder> list = salesOrderMapper.selectList(orderNo, offset, pageSize);
        int total = salesOrderMapper.count(orderNo);
        return PageResult.of(total, list, page, pageSize);
    }
}
