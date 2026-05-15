package com.erp.dto;

import com.erp.entity.PurchaseOrder;
import com.erp.entity.PurchaseOrderItem;
import lombok.Data;
import java.util.List;

@Data
public class PurchaseOrderDTO {
    private PurchaseOrder order;
    private List<PurchaseOrderItem> items;
}
