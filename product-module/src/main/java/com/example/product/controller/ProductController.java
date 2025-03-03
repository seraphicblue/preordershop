package com.example.product.controller;

import com.example.product.controller.dto.StockStatusDto;
import com.example.product.service.ProductService;
import com.example.product.controller.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    //상품 등록
    @PostMapping("/register")
    public ResponseEntity<ProductDto> registerProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.registerProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // 전체 상품 가져오기
    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getProductList() {
        List<ProductDto> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    // 상품 재고 확인하기
    @GetMapping("/{productId}/stock")
    public ResponseEntity<StockStatusDto> getCurrentStock(@PathVariable Long productId) {
        StockStatusDto stockStatus = productService.checkStock(productId);
        return ResponseEntity.ok(stockStatus);
    }

    // 상품 상세 조회
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductDetail(@PathVariable Long productId) {
        ProductDto productDetail = productService.getProductDetail(productId);
        return ResponseEntity.ok(productDetail);
    }
}
