package com.erp.entity;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class Supplier {
    private Long id;
    @NotBlank(message = "供应商编号不能为空")
    private String supplierNo;
    @NotBlank(message = "供应商名称不能为空")
    private String supplierName;
    private String contact;
    private String phone;
    private String email;
    private String address;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
