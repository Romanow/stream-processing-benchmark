/*
 * Copyright (c) Romanov Alexey, 2024
 */
package ru.romanow.model.processing;

import org.openjdk.jmh.annotations.*;
import ru.romanow.model.processing.entity.ProductScenarioEntity;
import ru.romanow.model.processing.model.ModelBuilder;
import ru.romanow.model.processing.model.ProductScenarioModel;
import ru.romanow.model.processing.service.ProductScenarioGenerator;

import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class ModelProcessingBenchmark {
    private static final int SIZE = 1_000_000;

    private List<ProductScenarioEntity> entities;

    @Setup
    public void setup() {
        entities = ProductScenarioGenerator.generate(SIZE);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 0)
    @Fork(value = 1, warmups = 0)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public List<ProductScenarioModel> benchmarkSingleThreadProcessing() {
        return entities
                .stream()
                .map(ModelBuilder::toModel)
                .toList();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 0)
    @Fork(value = 1, warmups = 0)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public List<ProductScenarioModel> benchmarkParallelProcessing() {
        return entities
                .parallelStream()
                .map(ModelBuilder::toModel)
                .toList();
    }
}
