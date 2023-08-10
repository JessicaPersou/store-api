package br.com.shop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SaleStatus {
    PENDING,
    APPROVED,
    CANCELED
}