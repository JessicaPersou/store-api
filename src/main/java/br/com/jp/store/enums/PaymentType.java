package br.com.jp.store.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
    CREDIT,
    DEBIT,
    PIX
}