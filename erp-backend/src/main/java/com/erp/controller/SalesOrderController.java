package com.erp.controller;

import com.erp.common.PageResult;
import com.erp.common.Result;
import com.erp.dto.SalesOrderDTO;
import com.erp.entity.SalesOrder;
import com.erp.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/sales-order")
@CrossOrigin
@Validated
public class SalesOrderController {
    @Autowired
    private SalesOrderService salesOrderService;

    @PostMapping("/add")
    public Result<Void> add(@Valid @RequestBody SalesOrderDTO dto) {
        salesOrderService.add(dto.getOrder(), dto.getItems());
        return Result.success();
    }

    @PostMapping("/update")
    public Result<Void> update(@Valid @RequestBody SalesOrderDTO dto) {
        salesOrderService.update(dto.getOrder(), dto.getItems());
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        salesOrderService.delete(id);
        return Result.success();
    }

    @GetMapping("/get/{id}")
    public Result<SalesOrderDTO> getById(@PathVariable Long id) {
        SalesOrderDTO dto = new SalesOrderDTO();
        dto.setOrder(salesOrderService.getById(id));
        dto.setItems(salesOrderService.getItemsByOrderId(id));
        return Result.success(dto);
    }

    @GetMapping("/list")
    public Result<PageResult<SalesOrder>> list(@RequestParam(required = false) String orderNo,
                                                @RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "10") int pageSize) {
        return Result.success(salesOrderService.list(orderNo, page, pageSize));
    }
}
