package com.arcone.learning.util;

import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class IdUtil {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

}
