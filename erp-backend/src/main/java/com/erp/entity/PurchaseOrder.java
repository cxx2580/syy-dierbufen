package com.erp.entity;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PurchaseOrder {
    private Long id;
    @NotBlank(message = "订单编号不能为空")
    private String orderNo;
    @NotNull(message = "供应商不能为空")
    private Long supplierId;
    private String supplierName;
    private BigDecimal totalAmount;
    private Integer status;
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
