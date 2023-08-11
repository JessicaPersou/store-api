package br.com.jp.store.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProfileType {
    ADMIN,
    USER,
    GUEST,
    DISABLED
}