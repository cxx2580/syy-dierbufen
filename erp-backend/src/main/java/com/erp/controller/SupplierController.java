package com.erp.controller;

import com.erp.common.PageResult;
import com.erp.common.Result;
import com.erp.entity.Supplier;
import com.erp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/supplier")
@CrossOrigin
@Validated
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/add")
    public Result<Void> add(@Valid @RequestBody Supplier supplier) {
        supplierService.add(supplier);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<Void> update(@Valid @RequestBody Supplier supplier) {
        supplierService.update(supplier);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        supplierService.delete(id);
        return Result.success();
    }

    @GetMapping("/get/{id}")
    public Result<Supplier> getById(@PathVariable Long id) {
        return Result.success(supplierService.getById(id));
    }

    @GetMapping("/list")
    public Result<PageResult<Supplier>> list(@RequestParam(required = false) String supplierName,
                                              @RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int pageSize) {
        return Result.success(supplierService.list(supplierName, page, pageSize));
    }
}
