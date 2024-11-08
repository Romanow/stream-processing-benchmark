/*
 * Copyright (c) Romanov Alexey, 2024
 */
package ru.romanow.model.processing;

import ru.romanow.model.processing.model.ModelBuilder;
import ru.romanow.model.processing.service.ProductScenarioGenerator;

public class ModelProcessingApplication {
    private static final int SIZE = 1_000_000;

    public static void main(String[] args) {
        final var entities = ProductScenarioGenerator.generate(SIZE);

        long start = System.currentTimeMillis();
        var models = entities
                .stream()
                .map(ModelBuilder::toModel)
                .toList();
        long end = System.currentTimeMillis();
        System.out.printf("Single thread processing (%d items), time: %dms\n", models.size(), end - start);

        start = System.currentTimeMillis();
        models = entities
                .parallelStream()
                .map(ModelBuilder::toModel)
                .toList();
        end = System.currentTimeMillis();
        System.out.printf("Parallel processing (%d items), time: %dms\n", models.size(), end - start);
    }
}
