package com.erp.entity;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PurchaseOrderItem {
    private Long id;
    private Long orderId;
    @NotNull(message = "产品不能为空")
    private Long productId;
    private String productName;
    private String specification;
    private String unit;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subtotal;
    private LocalDateTime createTime;
}
