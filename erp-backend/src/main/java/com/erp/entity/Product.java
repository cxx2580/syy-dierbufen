package com.erp.entity;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
    private Long id;
    @NotBlank(message = "产品编号不能为空")
    private String productNo;
    @NotBlank(message = "产品名称不能为空")
    private String productName;
    private String specification;
    private String unit;
    @NotNull(message = "单价不能为空")
    private BigDecimal price;
    private Integer stock;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
