package com.erp.entity;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class Customer {
    private Long id;
    @NotBlank(message = "客户编号不能为空")
    private String customerNo;
    @NotBlank(message = "客户名称不能为空")
    private String customerName;
    private String contact;
    private String phone;
    private String email;
    private String address;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
