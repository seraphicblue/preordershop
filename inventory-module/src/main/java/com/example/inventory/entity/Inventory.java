package com.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "stock_quantity", nullable = false, precision = 10, scale = 2)
    private BigDecimal stockQuantity;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    public Inventory(Long productId, BigDecimal stockQuantity) {
        this.productId = productId;
        this.stockQuantity = stockQuantity;
        this.lastUpdate = LocalDateTime.now();

    }


    // 재고 수량 업데이트
    public void updatedStockQuantity(BigDecimal newStockQuantity) {
        this.stockQuantity = newStockQuantity;
        this.lastUpdate = LocalDateTime.now();
    }
}
