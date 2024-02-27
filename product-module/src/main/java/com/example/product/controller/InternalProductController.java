
package com.example.product.controller;

import com.example.product.service.ProductService;
import com.example.product.controller.request.UpdateStockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InternalProductController {

    private final ProductService productService;

    @PostMapping("/internal/products/deduct")
    public void deductProduct(@RequestBody UpdateStockRequest deductrequest) {
        productService.deductProduct(deductrequest.getProductId(), deductrequest.getPaymentAmount());
    }

    @PostMapping("/internal/products/plus")
    public void plusProduct(@RequestBody UpdateStockRequest plusrequest) {
        productService.plusProduct(plusrequest.getProductId(), plusrequest.getPaymentAmount());
    }
}
