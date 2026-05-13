package com.erp.controller;

import com.erp.common.PageResult;
import com.erp.common.Result;
import com.erp.entity.Customer;
import com.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
@Validated
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Result<Void> add(@Valid @RequestBody Customer customer) {
        customerService.add(customer);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<Void> update(@Valid @RequestBody Customer customer) {
        customerService.update(customer);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return Result.success();
    }

    @GetMapping("/get/{id}")
    public Result<Customer> getById(@PathVariable Long id) {
        return Result.success(customerService.getById(id));
    }

    @GetMapping("/list")
    public Result<PageResult<Customer>> list(@RequestParam(required = false) String customerName,
                                              @RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int pageSize) {
        return Result.success(customerService.list(customerName, page, pageSize));
    }
}
