package com.erp.controller;

import com.erp.common.PageResult;
import com.erp.common.Result;
import com.erp.entity.Product;
import com.erp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
@Validated
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Result<Void> add(@Valid @RequestBody Product product) {
        productService.add(product);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<Void> update(@Valid @RequestBody Product product) {
        productService.update(product);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return Result.success();
    }

    @GetMapping("/get/{id}")
    public Result<Product> getById(@PathVariable Long id) {
        return Result.success(productService.getById(id));
    }

    @GetMapping("/list")
    public Result<PageResult<Product>> list(@RequestParam(required = false) String productName,
                                             @RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int pageSize) {
        return Result.success(productService.list(productName, page, pageSize));
    }
}
