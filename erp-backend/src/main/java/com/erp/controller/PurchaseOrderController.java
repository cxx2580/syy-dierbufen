package com.erp.controller;

import com.erp.common.PageResult;
import com.erp.common.Result;
import com.erp.dto.PurchaseOrderDTO;
import com.erp.entity.PurchaseOrder;
import com.erp.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/purchase-order")
@CrossOrigin
@Validated
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping("/add")
    public Result<Void> add(@Valid @RequestBody PurchaseOrderDTO dto) {
        purchaseOrderService.add(dto.getOrder(), dto.getItems());
        return Result.success();
    }

    @PostMapping("/update")
    public Result<Void> update(@Valid @RequestBody PurchaseOrderDTO dto) {
        purchaseOrderService.update(dto.getOrder(), dto.getItems());
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        purchaseOrderService.delete(id);
        return Result.success();
    }

    @GetMapping("/get/{id}")
    public Result<PurchaseOrderDTO> getById(@PathVariable Long id) {
        PurchaseOrderDTO dto = new PurchaseOrderDTO();
        dto.setOrder(purchaseOrderService.getById(id));
        dto.setItems(purchaseOrderService.getItemsByOrderId(id));
        return Result.success(dto);
    }

    @GetMapping("/list")
    public Result<PageResult<PurchaseOrder>> list(@RequestParam(required = false) String orderNo,
                                                   @RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "10") int pageSize) {
        return Result.success(purchaseOrderService.list(orderNo, page, pageSize));
    }
}
