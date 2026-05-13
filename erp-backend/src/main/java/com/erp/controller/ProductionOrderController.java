package com.erp.controller;

import com.erp.common.PageResult;
import com.erp.common.Result;
import com.erp.entity.ProductionOrder;
import com.erp.service.ProductionOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/production-order")
@CrossOrigin
@Validated
public class ProductionOrderController {
    @Autowired
    private ProductionOrderService productionOrderService;

    @PostMapping("/add")
    public Result<Void> add(@Valid @RequestBody ProductionOrder order) {
        productionOrderService.add(order);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<Void> update(@Valid @RequestBody ProductionOrder order) {
        productionOrderService.update(order);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        productionOrderService.delete(id);
        return Result.success();
    }

    @GetMapping("/get/{id}")
    public Result<ProductionOrder> getById(@PathVariable Long id) {
        return Result.success(productionOrderService.getById(id));
    }

    @GetMapping("/list")
    public Result<PageResult<ProductionOrder>> list(@RequestParam(required = false) String productionNo,
                                                     @RequestParam(defaultValue = "1") int page,
                                                     @RequestParam(defaultValue = "10") int pageSize) {
        return Result.success(productionOrderService.list(productionNo, page, pageSize));
    }
}
