package com.erp.dto;

import com.erp.entity.SalesOrder;
import com.erp.entity.SalesOrderItem;
import lombok.Data;
import java.util.List;

@Data
public class SalesOrderDTO {
    private SalesOrder order;
    private List<SalesOrderItem> items;
}
