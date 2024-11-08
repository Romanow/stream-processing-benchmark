/*
 * Copyright (c) Romanov Alexey, 2024
 */
package ru.romanow.model.processing.service;

import lombok.experimental.UtilityClass;
import ru.romanow.model.processing.entity.ProductScenarioEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@UtilityClass
public final class ProductScenarioGenerator {

    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();

    public static List<ProductScenarioEntity> generate(int size) {
        return IntStream.range(0, size).mapToObj(i -> build()).collect(toList());
    }

    private static ProductScenarioEntity build() {
        return new ProductScenarioEntity()
                .setId(UUID.randomUUID())
                .setActualDateFrom(LocalDateTime.now())
                .setActualDateTo(LocalDateTime.now())
                .setProductTreeCode(randomString(12))
                .setProductTreeCode(randomString(12))
                .setOrderBy(RANDOM.nextLong())
                .setMeasureName(randomString(12))
                .setMeasureValue(randomString(16))
                .setMeasureGroup(randomString(8))
                .setWeightParam(true)
                .setCfCode(randomString(12))
                .setSegmentId(randomString(8))
                .setRateTypeId(randomString(8))
                .setCcy(randomString(16))
                .setMeasureStatus(RANDOM.nextInt())
                .setMeasureParent(RANDOM.nextInt());
    }

    private static String randomString(int length) {
        final var result = new StringBuilder();
        int len = ALPHABET.length();
        for (int i = 0; i < length; i++) {
            result.append(ALPHABET.charAt(RANDOM.nextInt(len)));
        }
        return result.toString();
    }
}
